$(document).ready(fetchMapData);
$(document).ready(getHeaders);

/** Manhattan districts. */
var districts;
/** Current user's stats. */
var userStats;

/**
 * Fetches map data, i.e. obtains districts data and according to said value
 * specifies areas on the map.
 */
function fetchMapData() {
	document.getElementById("mapInfo").style.display = "none";
	
	$.get({
		url: "/districts/asMap",
		dataType: "json",
		success: function(data) {
			districts = data;
			
			let html = "";
			for (let district in data) {
				let districtValue = data[district];
				html +=
					"<area " +
						"shape='circle' " +
						"coords='" + districtValue.x + "," + districtValue.y + ",10' " +
						"onMouseLeave='onLeaveArea()' " +
						"onClick='startGame(" + districtValue.id + ")' " +
						"onMouseOver='updateInfo(" + districtValue.id + ")'/>";
			}
			
			$("#districts").html(html);
		}
	});
	
	$.get({
		url: "/users/current",
		dataType: "json",
		success: function(user) {
			
			$.get({
				url: "stats/single",
				data: "username=" + user.username,
				headers: {
					"Content-Type": "application/x-www-form-urlencoded"
				},
				dataType: "json",
				success: function(data) {
					userStats = data;
				}
			});
		
		}
	});
}

/**
 * Updates district information by presenting data about area which mouse
 * currently hovers.
 * 
 * @param area
 *            area which mouse currently hovers
 */
function updateInfo(area) {
	let district = districts[area];
	document.getElementById("mapImage").src = "media/level/level" + district.id + ".png";
	document.getElementById("levelNameLabel").innerText = district.name;
	document.getElementById("availableLabel").innerText = isAvailable(district.id);
	document.getElementById("burgerLabel").innerText = district.burger;
	document.getElementById("levelDescription").innerText = district.description;
	document.getElementById("mapInfo").style.display = "grid";
	
	$("#levelStars").html(getLevelStars(district.id));
}

/**
 * Returns <code>boolean</code> value whether <i>level</i> provided as
 * argument is available (unlocked) for current user.
 * 
 * @param level
 *            level which availability is inquired
 *            
 * @returns <code>true</code> if level is unlocked, <code>false</code>
 *          otherwise
 */
function isAvailable(level) {
	return level <= userStats.level;
}

/**
 * Defines action which will be executed once mouse leaves map area.
 * In this case, district information is hidden.
 */
function onLeaveArea() {
	document.getElementById("mapInfo").style.display = "none";
}

/**
 * Gets <i>HTML</i> code for <i>level</i> provided as argument. Function adds
 * as many star icons as is level value.
 * 
 * @param level
 *            level for which <i>HTML</i> code is inquired
 *            
 * @returns <i>HTML</i> code corresponding level value provided as argument
 */
function getLevelStars(level) {
	let html = "";
	for (let i = 0; i < level; i++) {
		html += "<img src='media/starIcon.png' width=25>";
	}
	
	return html;
}

/**
 * Starts game by redirecting to game page with <i>level</i> provided as
 * argument.
 * 
 * @param area
 *            area which presents game level
 */
function startGame(area) {
	if (!isAvailable(area)) {
		alert("Sorry, this level is not available for you yet. :(");
		return;
	}
	
	window.location.replace("/game?level=" + area);
}