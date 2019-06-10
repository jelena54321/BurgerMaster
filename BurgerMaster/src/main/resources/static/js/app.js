$(document).ready(getUsername);

/** Current user's username. */
var username;

/**
 * Processes logout request and redirects to index page.
 */
function logOut() {
	$.get({
		url: "/logout",
		success: function() {
			window.location.replace("/");
		}
	});
}

/**
 * Loads index page.
 */
function loadIndex() {
	window.location.replace("/");
}

/**
 * Loads map page. 
 */
function loadMap() {
	window.location.replace("/map");
}

/**
 * Loads recipes page.
 */
function loadRecipes() {
	window.location.replace("/recipes");
}

/**
 * Loads rankings page.
 */
function loadRankings() {
	window.location.replace("/rankings");
}

/**
 * Gets currently logged in user and updates username label value according to
 * obtained value.
 */
function getUsername() {
	$.get({
		url: "/users/current",
		dataType: "json",
		success: function(data) {
			let innerHtml = "Hi, <b>" + data.username + "</b>!";
			$("#usernameLabel").html(innerHtml);
		}
	});
}

/**
 * Gets <i>HTML</i> for headers.
 * 
 * @returns <i>HTML</i> for headers
 */
function getHeaders() {
	let html = 
		"<div class='firstSectionHeader'>" +
			"<img " +
				"class='logo' " + 
				"src='media/logo.png' " +
				"alt='BurgerMaster: logo' " + 
				"width=150px " +
				"onClick='loadIndex()'>" +
		"</div>" +
		"<div class='secondSectionHeader'>" +
			"<label class='littleTitle'>BurgerMaster</label>" +
		"</div>" +
		"<div class='thirdSectionHeader'>" +
			"<div class='rightAligned'>" +
				"<label " +
				"id='usernameLabel' " +
				"class='usernameLabel'>" +
				"</label>" +
			"</div>" +
		"</div>" +
		"<div class='fourthSectionHeader'>" +
			"<button " +
				"class='logoutButton' " +
				"onClick='logOut()'>" +
				"<span>Log Out</span>" +
			"</button>" +
		"</div>";
	$("#header").html(html);
}