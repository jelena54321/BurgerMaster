package hr.fer.zavrsniRad.BurgerMaster.domain;

public class UserModel {

	/** User's name. */
	private String username;
	
	/** User's email. */
	private String email;
	
	/** User's password. */
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
