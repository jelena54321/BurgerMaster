/**
 * Processes registration request.
 */
function register() {
	// DOM elements
    let usernameElement = document.getElementById("username");
	let username = usernameElement.value;
	let emailElement = document.getElementById("email");
	let email = emailElement.value;
	let passwordElement = document.getElementById("password");
	let password = passwordElement.value;
	
	// DOM error labels
	let usernameErrorLabel = document.getElementById("usernameErrorLabel");
	let emailErrorLabel = document.getElementById("emailErrorLabel");
	let passwordErrorLabel = document.getElementById("passwordErrorLabel");
	
	// FIELDS VALIDATION
	
	let validUsername = isValidUsername(username);
	if (!validUsername) usernameErrorLabel.innerText = "Invalid username";
	else usernameErrorLabel.innerText = "";
	
	let validEmail = isValidEmail(email);
	if (!validEmail) emailErrorLabel.innerText = "Invalid email";
	else emailErrorLabel.innerText = "";
	
	let validPassword = isValidPassword(password);
	if (!validPassword) passwordErrorLabel.innerText = "Invalid password";
	else passwordErrorLabel.innerText = "";
	
	if (!validUsername || !validEmail || !validPassword) {
		passwordElement.value = "";
		return;
	}
	
	// check if user name already exists
	$.get({
		url: "/users/check/username/" + username,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		success: function() {
			
			// check if email already exists
			$.get({
    			url: "/users/check/email/" + email,
    			headers: {
   					"Content-Type": "application/x-www-form-urlencoded"
   				},
   				success: function() {
   					
   					// register user
	   				$.post({
   		     			url: "/users",
   		     			headers: {
   		     				"Content-Type": "application/json"
   		     			},
   		     			data: JSON.stringify({
   		     				username: username,
   		     				email: email,
   		     				password: password
   		     			}),
   		     			success: function() {
   		     				
   		     				// initialize user's stats 
   		     				$.post({
   		     					url: "/stats",
	   		     				headers: {
	   	   		     				"Content-Type": "application/json"
	   	   		     			},
	   	   		     			data: JSON.stringify({
	   	   		     				username: username,
	   	   		     				points: 0,
	   	   		     				level: 1
	   	   		     			})
   		     				});
   		     				
   		     				// log in user 
	   		     			$.post({
	   		    				url: "/login",
	   		    				data: "username=" + username + "&password=" + password,
	   		    				headers: {
	   		    					"Content-Type": "application/x-www-form-urlencoded"
	   		    				},
	   		    				success: function(data) {
	   		    					window.location.replace("/");
	   		    				}
	   		     			});
   		     			}
	     			});
   					
   				},
   				error: function() {
   					emailErrorLabel.innerText = "User with provided email already exists";
   					passwordElement.value = "";
   					validEmail = false;
   				}
    		});
			
		},
		error: function() {
			usernameErrorLabel.innerText = "User with provided user name already exists";
			passwordElement.value = "";
			validUsername = false;
		}
	});
}