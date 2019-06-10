package hr.fer.zavrsniRad.BurgerMaster.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import hr.fer.zavrsniRad.BurgerMaster.util.Util;

/**
 * Class which presents burger.
 * 
 * @author Jelena Šarić
 *
 */
@Entity
public class Burger {
	
	/** Burger name. */
	@Id
	private String name;
	
	/** Burger's meat state. */
	@Enumerated(EnumType.STRING)
	private Meat meat;
	
	/** Burger's point value. */
	@Column
	private int points;
	
	/** Burger's ingredients. */
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Ingredient> ingredients;
	
	/**
	 * Gets burger's name.
	 * 
	 * @return burger's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets burger's name.
	 * 
	 * @param name burger's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets burger's meat state.
	 * 
	 * @return burger's meat state
	 */
	public Meat getMeat() {
		return meat;
	}

	/**
	 * Sets burger's meat state.
	 * 
	 * @param meat burger's meat state
	 */
	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	/**
	 * Gets burger's ingredients.
	 * 
	 * @return burger's ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets burger's ingredients.
	 * 
	 * @param ingredients burger's ingredients
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	/**
	 * Gets burger's point value.
	 * 
	 * @return burger's point value
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets burger's point value.
	 * 
	 * @param points burger's point value
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((meat == null) ? 0 : meat.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		
		Burger other = (Burger) obj;
		
		List<Ingredient> first = new ArrayList<>(this.ingredients);
		first.sort(Util.COMPARATOR_BY_NAME);
		List<Ingredient> second = new ArrayList<>(other.ingredients);
		second.sort(Util.COMPARATOR_BY_NAME);
		
		return this.meat == other.meat &&
			   this.name.equals(other.name) &&
			   first.equals(second);
	}
}
