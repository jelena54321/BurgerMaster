package hr.fer.zavrsniRad.BurgerMaster.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class which presents burger's ingredient.
 * 
 * @author Jelena Šarić
 * 
 */
@Entity
public class Ingredient {
	
	/** Ingredient's name. */
	@Id
	private String name;

	/**
	 * Gets ingredient's name.
	 * 
	 * @return ingredient's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets ingredient's name.
	 * 
	 * @param name ingredient's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		
		Ingredient other = (Ingredient) obj;
		
		return this.name.equals(other.name);
	}
}
