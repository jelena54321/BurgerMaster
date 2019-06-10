$(document).ready(processLoading);

/**
 * Returns <i>HTML</i> code for logged in user's perspective.
 * 
 * @param username
 *            user's user name
 *            
 * @returns <i>HTML</i> code
 */
function getHtmlForLoggedIn(username) {
	return "<div class='postLoginContainer'>" +
				"<label class='firstFunc'>" +
					"Welcome back, <b>" + username +"</b>!" + 
				"</label>" +
				"<div class='groupedFunc'>" +
					"<button " +
						"class='secondFunc' " +
						"onClick='loadMap()'>" +
						"<span>Map</span>" + 
					"</button>" +
					"<button " +
						"class='thirdFunc' " +
						"onClick='loadRecipes()'>" +
						"<span>Recipes</span>" +
					"</button>" +
					"<button " +
						"class='fourthFunc' " +
						"onClick='loadRankings()'>" +
						"<span>Rankings</span>" +
					"</button>" +
				"</div>" +
				"<button " +
					"class='fifthFunc' " +
					"onClick='logOut()'>" +
					"<span>Log Out</span>" +
				"</button>" +
			"</div>";
}

/**
 * Returns <i>HTML</i> code for logged out user's perspective.
 * 
 * @param username
 *            user's user name
 *            
 * @returns <i>HTML</i> code
 */
function getHtmlForLoggedOut() {
	return "<div class='preLoginContainer'>" +
				"<input " +
					"class='firstInputField' " + 
					"id='username' " + 
					"type='text' " + 
					"placeholder='Username'>" +
				"<input " +
					"class='secondInputField' " + 
					"id='password' " + 
					"type='password' " + 
					"placeholder='Password'>" +
				"<label class='errorLabel' id='errorLabel' hidden='true'>" +
					"Provided user name and/or password is incorrect" +
				"</label>" +
				"<label class='signUpLabel'>" +
					"Don't have an account? <a href='/register'>Sign Up</a>" +
				"</label>" +
				"<button class='button' onClick='logIn()'>" +
					"<span>Log In</span>" +
				"</button>" +
			"</div>";
}
    	
/**
 * Determines whether there is user currently logged in. If so, logged in user's
 * perspective is loaded, otherwise logged out user's perspective is loaded.
 */
function processLoading() {
	$.get({
		url: "/users/current",
		dataType: "json",
		success: function(data) {
			$("#container").html(getHtmlForLoggedIn(data.username));
		},
		error: function() {
			$("#container").html(getHtmlForLoggedOut());
		}
	});
}

/**
 * Processes login request by using current values from username and password
 * fields.
 */
function logIn() {
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	$.post({
		url: "/login",
		data: "username=" + username + "&password=" + password,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		success: function() {
			$("#container").html(getHtmlForLoggedIn(username));
		},
		error: function() {
			document.getElementById("errorLabel").hidden = false;
		}
	});
}