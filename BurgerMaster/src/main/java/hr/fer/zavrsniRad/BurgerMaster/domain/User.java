package hr.fer.zavrsniRad.BurgerMaster.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NaturalId;

/**
 * Class which presents object representation of a user in database.
 * 
 * @author Jelena Šarić
 */
@Entity
@SequenceGenerator(name = "generator", initialValue = 100, allocationSize = 100)
public class User {
	
	/** User's id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	private int id;
	
	/** User's name. */
	@NaturalId
	private String username;
	
	/** User's email. */
	@NaturalId
	private String email;
	
	/** User's password. */
	private String password;
	
	/** 
	 * Gets user id. 
	 * 
	 * @return user's id 
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets usre's id.
	 * 
	 * @param id user's id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets user's user name.
	 * 
	 * @return user's user name
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets user's user name.
	 * 
	 * @param username user's user name
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets user's email.
	 * 
	 * @return user's email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set's user's email.
	 * 
	 * @param email user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets user's password.
	 * 
	 * @return user's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets user's password.
	 * 
	 * @param password user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
