package hr.fer.zavrsniRad.BurgerMaster.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class which presents object representation of burger.
 * 
 * @author Jelena Šarić
 *
 */
public class Burger {
	
	/** Burger's meat state. */
	private Meat meat;
	
	/** Burger's ingredients. */
	private Set<Ingredient> ingredients;

	/**
	 * Get's burger's meat state.
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
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets burger's ingredients.
	 * 
	 * @param ingredients burger's ingredients
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
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
		if (this.ingredients == null) {
			if (other.ingredients != null)
				return false;
		}
		
		if (this.meat != other.meat) return false;
		
		List<Ingredient> firstIngredients = new ArrayList<>(this.ingredients);
		List<Ingredient> secondIngredients = new ArrayList<>(other.ingredients);
		firstIngredients.sort(null);
		secondIngredients.sort(null);
		return firstIngredients.equals(secondIngredients);
	}
	
	
}
