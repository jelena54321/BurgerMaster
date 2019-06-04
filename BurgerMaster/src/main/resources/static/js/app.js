$(document).ready(getUsername);

var username;

function logOut() {
	$.get({
		url: "/logout",
		success: function() {
			window.location.replace("/");
		}
	});
}

function loadIndex() {
	window.location.replace("/");
}

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

function getHeaders() {
	let html = 
		"<div class='firstSectionHeader'>" +
			"<img " +
				"class='logo' " + 
				"src='media/OGLogo.png' " +
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