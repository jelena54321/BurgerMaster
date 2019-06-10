package hr.fer.zavrsniRad.BurgerMaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class which presents Manhattan district.
 * 
 * @author Jelena Šarić
 *
 */
@Entity
public class District {
	
	/** District's id. */
	@Id
	private int id;
	
	/** District's name. */ 
	@Column(nullable = false)
	private String name;
	
	/** District's x-axis location. */
	@Column(nullable = false)
	private int x;
	
	/** District's y-axis location. */
	@Column(nullable = false)
	private int y;
	
	/** District's best burger. */
	@Column(nullable = false)
	private String burger;
	
	/** District's description. */
	@Column(nullable = false)
	private String description;

	/**
	 * Gets district's id.
	 * 
	 * @return district's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets district's id.
	 * 
	 * @param id district's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets district's name.
	 * 
	 * @return district's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets district's name.
	 * 
	 * @param name district's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets district's x-coordinate.
	 * 
	 * @return district's x-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets district's x-coordinate.
	 * 
	 * @param x district's x-coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets district's y-coordinate.
	 * 
	 * @return district's y-coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets district's y-coordinate.
	 * 
	 * @param y district's y-coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets district's best burger.
	 * 
	 * @return district's best burger
	 */
	public String getBurger() {
		return burger;
	}

	/**
	 * Sets district's best burger.
	 * 
	 * @param burger district's best burger
	 */
	public void setBurger(String burger) {
		this.burger = burger;
	}

	/**
	 * Gets district's description.
	 * 
	 * @return district's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets districts description.
	 * 
	 * @param description district's description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
