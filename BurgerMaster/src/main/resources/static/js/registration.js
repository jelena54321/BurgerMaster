function register() {
    let usernameElement = document.getElementById("username");
	let username = usernameElement.value;
	let emailElement = document.getElementById("email");
	let email = emailElement.value;
	let passwordElement = document.getElementById("password");
	let password = passwordElement.value;
	
	let usernameErrorLabel = document.getElementById("usernameErrorLabel");
	let emailErrorLabel = document.getElementById("emailErrorLabel");
	let passwordErrorLabel = document.getElementById("passwordErrorLabel");
	
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
	
	$.get({
		url: "/users/check/username/" + username,
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		success: function() {
			
			$.get({
    			url: "/users/check/email/" + email,
    			headers: {
   					"Content-Type": "application/x-www-form-urlencoded"
   				},
   				success: function() {
   					
	   				$.post({
   		     			url: "/users",
   		     			headers: {
   		     				"Content-Type": "application/json"
   		     			},
   		     			data: JSON.stringify({
   		     				username: username,
   		     				email: email,
   		     				password: password,
   		     			}),
   		     			success: function() {
   		     				
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