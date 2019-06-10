$(document).ready(loadData);

/** Burger state. */
var burger;
/** Meat status (on the stove). */ 
var meatStatus;

/** Timeout until meat is WELL DONE. */
var untilWellDone;
/** Timeout until meat is OVERDONE. */
var untilOverdone;
/** Timeout until game is finished. */
var gameTimeout;
/** Time interval between two orders. */
var gameInterval;

/** Game start. */
var start;
/** Game finish. */
var finish;

/** Game data. */
var game;
/** Points. */
var points;
/** Level data. */
var level;

/** Number of remaining clock blinks. */
var blinkCounter = 3;
/** Orders counter. */
var ordersCounter = 0;
/** Number of finished orders. */
var finishedCounter = 0;

//===========================================================================
//						 		PRE-GAME
//===========================================================================

/**
 * Loads data required for playing game. Game is created according to the level
 * value provided through <i>URL</i> parameter.
 */
function loadData() {
	setUpQuitButton();
	
	level = getLevelValueFromURL();
	$.get({
		url: "/games/create",
		data: "level=" + level,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		dataType: "json",
		success: function(data) {
			game = data;
			game.results = [];
		}
	});
	
	initBurger();
}

// ==========================================================================
// 								GAME START
// ==========================================================================

/**
 * Starts the game.
 */
function startGame() {
	document.getElementById("startDiv").style.display = "none";
	start = new Date();
	
	gameTimeout = setTimeout(finish, 2 * 60 * 1000);
	gameInterval = setInterval(addOrder, game.sleepInterval);

	addOrder();
}

// ==========================================================================
//                          	   GAME
// ==========================================================================

/**
 * Adds order to the board.
 */
function addOrder() {
	if (ordersCounter == game.orders.length) {
		clearInterval(gameInterval);
		return;
	}
	
	++ordersCounter;
	
	let content = document.getElementById("tableContent");
	setOrdersOnBoard(content);
	
	let html = content.innerHTML;
	html += 
		"<div class='centered'>" +
			"<label class='order' id='order" + ordersCounter + "'><b>" +
			game.orders[ordersCounter - 1].name + 
			"</b></label>" +
		"</div>";
	$("#tableContent").html(html);
}

/**
 * Adds bread on the cooking counter.
 */
function addBread() {
	if (burger.Bread) return;
	burger.Bread = true;
	document.getElementById("interfaceCenter").src = 
		"media/burgers/InterfaceCenter_0000000.png";
}

/**
 * Adds ingredient in the burger.
 * 
 * @param ingredient
 *            ingredient which will be added
 */
function addIngredient(ingredient) {
	if (!burger.Bread) return;
	if (burger[ingredient]) return;
	burger[ingredient] = true;
	
	console.log(burger);
	
	let index;
	switch (ingredient) {
	case 'Tomato':
		index = 1;
		break;
	case 'Cheese':
		index = 2
		break;
	case 'Salad':
		index = 3;
		break;
	case 'Onion':
		index = 4;
		break;
	case 'Bacon':
		index = 5;
		break;
	case 'Ketchup':
		index = 6;
		break;
	}
		
	let oldSrc = document.getElementById("interfaceCenter").src;
	let relPathIndex = oldSrc.indexOf("_") + 1;
	let path = oldSrc.substring(0, relPathIndex);
	let prefix = oldSrc.substring(relPathIndex, relPathIndex + index);
	let postfix = oldSrc.substring(relPathIndex + index + 1);
	let newSrc = prefix + 1 + postfix;
	console.log(newSrc);
	document.getElementById("interfaceCenter").src = path + newSrc;
}

/**
 * Adds meat in the burger.
 */
function addMeat() {
	if (meatStatus == undefined) return;
	if (!burger.Bread) return;
	burger.Meat = meatStatus;
	
	let meat;
	switch (meatStatus) {
	case "RAW":
		meat = 1;
		break;
	case "WELL_DONE":
		meat = 2;
		break;
	case "OVERDONE":
		meat = 3;
		break;
	}
	
	let oldSrc = document.getElementById("interfaceCenter").src;
	let relPathIndex = oldSrc.indexOf("_") + 1;
	let path = oldSrc.substring(0, relPathIndex);
	let postfix = oldSrc.substring(relPathIndex + 1);
	let newSrc = meat + postfix;
	console.log(newSrc);
	document.getElementById("interfaceCenter").src = path + newSrc;
	
	throwMeat();
}

/**
 * Puts meat on the stove.
 */
function putMeatOnTheStove() {
	if (meatStatus != undefined) return;
	meatStatus = "RAW";
	document.getElementById("interfaceBottomRight").src = 
		"media/interface/InterfaceBottomRightRaw.png";
	
	untilWellDone = setTimeout(meatHasBecomeWellDone, 4000);
}

/**
 * Defines action which will be executed once meat has become WELL DONE.
 */
function meatHasBecomeWellDone() {
	untilWellDone = undefined;
	meatStatus = "WELL_DONE";
	document.getElementById("interfaceBottomRight").src =
		"media/interface/InterfaceBottomRightPerfect.png";
	
	untilOverdone = setTimeout(meatHasBecomeOverdone, 4000);
}

/**
 * Defines action which will be executed once meat has become OVERDONE.
 */
function meatHasBecomeOverdone() {
	untilOverdone = undefined;
	meatStatus = "OVERDONE";
	document.getElementById("interfaceBottomRight").src =
		"media/interface/InterfaceBottomRightOverdone.png";
}

/**
 * Throws burger in the trash.
 */
function throwBurger() {
	if (!burger.Bread) return;
	initBurger();
	document.getElementById("interfaceCenter").src = 
		"media/burgers/InterfaceCenter.png";
}

/**
 * Throws meat in the trash.
 */
function throwMeat() {
	if (meatStatus == undefined) return;
	
	if (untilWellDone != undefined) clearTimeout(untilWellDone);
	else clearTimeout(untilOverdone);
	
	meatStatus = undefined;
	document.getElementById("interfaceBottomRight").src =
		"media/interface/InterfaceBottomRight.png";
}

/**
 * Defines action which will be executed once bell has been rung.
 * Created burger is added to the results list.
 */
function finishOrder() {
	let ingredientsList = [];
	if (burger.Tomato) ingredientsList.push({ name: 'Tomato' });
	if (burger.Cheese) ingredientsList.push({ name: 'Cheese'});
	if (burger.Salad) ingredientsList.push({ name: 'Salad' });
	if (burger.Onion) ingredientsList.push({ name: 'Onion' });
	if (burger.Bacon) ingredientsList.push({ name: 'Bacon' });
	if (burger.Ketchup) ingredientsList.push({ name: 'Ketchup' });
	
	game.results.push({
		name: game.orders[finishedCounter].name,
		meat: burger.Meat,
		ingredients: ingredientsList
	});
	
	++finishedCounter;
	let content = document.getElementById("order" + finishedCounter);
	content.innerHTML = "<strike>" + content.innerHTML + "</strike>";
	
	throwBurger();
	
	if (finishedCounter == ordersCounter) finish();
}

// ==========================================================================
//                    			GAME END
// ==========================================================================

/**
 * Processes game end. Function is called either when user has completed all
 * orders or when shift has officially ended.
 */
function finish() {
	finish = new Date();
	game.totalTime = finish.getTime() - start.getTime();
	let TWO_MINUTES = 2 * 60 * 1000;
	if (game.totalTime < TWO_MINUTES) clearTimeout(gameTimeout);
	else drawTime();
	
	// post game results to server
	$.post({
		url: "/games",
		headers: {
			"Content-Type": "application/json"
		},
		data: JSON.stringify(game),
		success: function(computedPoints) {
			points = computedPoints;
			
			// get current user
			$.get({
				url: "/users/current",
				dataType: "json",
				success: function(user) {
					
					// update user stats for current user and game level
					$.post({
						url: "/stats",
						headers: {
							"Content-Type": "application/json"
						},
						data: JSON.stringify({
							username: user.username,
							level: parseInt(level),
							points: points
						})
					});
				}
			});
			
			let startDiv = document.getElementById("startDiv");
			startDiv.style.display = "grid";
			
			showPoints();
		}
	});
}

/**
 * Draws time on clock.
 */
function drawTime() {
	if (blinkCounter == 0) return;
	blinkCounter--;
	
	let canvas = document.getElementById("canvas");
	setCanvasOnClock(canvas);

	let ctx = canvas.getContext("2d");
	ctx.font = "bold 30px Quicksand";
	ctx.fillStyle = "white";
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.fillText("00 : 00", 27, 27);
	
	setTimeout(deleteTime, 1000);
}

/**
 * Deletes time from clock.
 */
function deleteTime() {
	let canvas = document.getElementById("canvas");
	setCanvasOnClock(canvas);
	
	let ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	
	setTimeout(drawTime, 1000);
}

// ==========================================================================
//                   			BUTTON ACTIONS
// ==========================================================================

function cancelGame() {
	window.location.replace("/map");
}

function quitGame() {
	clearTimeout(gameTimeout);
	clearTimeout(untilWellDone);
	clearTimeout(untilOverdone);
	clearInterval(gameInterval);
	
	window.location.replace("/map");
}

// ==========================================================================
//                   			HELP METHODS
// ==========================================================================

/**
 * Positions canvas on the clock.
 * 
 * @param canvas canvas which will be positioned
 */
function setCanvasOnClock(canvas) {
	let image = document.getElementById("imgInterfaceTop");
	let x = image.offsetLeft + 788;
	let y = image.offsetTop + 34;
	canvas.style.position = "absolute";
	canvas.style.left = x + "px";
	canvas.style.top = y + "px";
}

/**
 * Positions content container on the board.
 * 
 * @param content content which will be positioned
 */
function setOrdersOnBoard(content) {
	let image = document.getElementById("imgInterfaceTop");
	let x = image.offsetLeft + 47;
	let y = image.offsetTop + 41;
	content.style.position = "absolute";
	content.style.left = x + "px";
	content.style.top = y + "px";
}

/**
 * Sets burger to its initial state.
 */
function initBurger() {
	burger = {
		Bread: false,
		Meat: undefined,
		Tomato: false,
		Cheese: false,
		Salad: false,
		Onion: false,
		Bacon: false,
		Ketchup: false
	}
}

/**
 * Sets quit button to the interface.
 */
function setUpQuitButton() {
	let img = document.getElementById("imgInterfaceTop");
	let quitButton = document.getElementById("quitGameButton");
	let x = img.offsetLeft + 787;
	let y = img.offsetTop + 99;
	quitButton.style.position = "absolute";
	quitButton.style.left = x + "px";
	quitButton.style.top = y + "px";
}

/**
 * Gets level value from <i>URL</i> parameter.
 * 
 * @returns level value
 */
function getLevelValueFromURL() {
	let search = window.location.search;
	return search.match(/level=(.)/)[1];
}

/**
 * Shows calculated points.
 */
function showPoints() {
	let html = 
		"<p><br><br><br>Points for this shift: " + points + "</p>" +
		"<button class='button' onClick='loadMap()'><span>Map</span></button>" +
		"<button class='button' onClick='loadIndex()'><span>Home</span></button>";
	$("#centerDiv").html(html);
}