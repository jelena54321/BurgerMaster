package hr.fer.zavrsniRad.BurgerMaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Level {
	
	@Id
	private int level;
	
	@Column
	private String name;
	
	@Column
	private int x;
	
	@Column
	private int y;
	
	@Column
	private String burger;
	
	@Column
	private String description;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getBurger() {
		return burger;
	}

	public void setBurger(String burger) {
		this.burger = burger;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
