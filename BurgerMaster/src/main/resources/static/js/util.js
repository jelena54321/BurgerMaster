function isValidUsername(username) {
	if (username.match(/^[0-9]+.*/) != null) return false;
	if (username.match(/[^\w]/) != null) return false;
	if (username.length < 3) return false;
	return true;
}

function isValidEmail(email) {
	if (email.match(/^[0-9]+.*/) != null) return false;
	if (email.match(/.+[@].+/) == null) return false;
	if (email.match(/[^\w@\.]/) != null) return false;
	return true
}

function isValidPassword(password) {
	return password.length >= 3;
}