/**
 * Returns <code>boolean</code> value whether provided <i>username</i> is
 * valid. 
 * User name must satisfy following rules:
 * <ol>
 * 		<li>user name can not start with number</li>
 * 		<li>user name can not contain special characters - only letters, numbers and
 * 		underscore</li>
 * 		<li>user name length can not be less than three</li>
 * </ol>
 * 
 * @param username user name which is inquired
 * 
 * @return <code>true</code> if user name is valid, <code>false</code>
 *         otherwise
 */
function isValidUsername(username) {
	if (username.match(/^[0-9]+.*/) != null) return false;
	if (username.match(/[^\w]/) != null) return false;
	if (username.length < 3) return false;
	return true;
}

/**
 * Returns <code>boolean</code> value whether provided <i>email</i> is valid.
 * Email must satisfy following rules:
 * <ol>
 * 		<li>email can not start with number</li>
 * 		<li>email must be of following format:<br>
 * 		<code>something@something</code></li>
 * 		<li>email can not contain special characters excluding:<br>
 * 		<code>@</code>, underscore and dot</li>
 * </ol>
 * 
 * @param email email which is inquired
 * 
 * @return <code>true</code> if email is valid, <code>false</code> 
 * 		   otherwise
 */
function isValidEmail(email) {
	if (email.match(/^[0-9]+.*/) != null) return false;
	if (email.match(/.+[@].+/) == null) return false;
	if (email.match(/[^\w@\.]/) != null) return false;
	return true
}

/**
 * Returns <code>boolean</code> value whether provided <i>password</i> is
 * valid. Password length can not be less than three.
 * 
 * @param password
 *            password which is inquired
 * @returns <code>true</code> if password is valid, <code>false</code>
 *          otherwise
 */
function isValidPassword(password) {
	return password.length >= 3;
}