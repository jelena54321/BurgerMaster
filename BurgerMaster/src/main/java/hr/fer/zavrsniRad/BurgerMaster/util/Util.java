package hr.fer.zavrsniRad.BurgerMaster.util;

import java.util.Comparator;

import hr.fer.zavrsniRad.BurgerMaster.domain.Ingredient;
import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;


public class Util {
	
	/** User stats comparator by level. */
	public static final Comparator<UserStats> COMPARATOR_BY_LEVEL = 
			(first, second) -> Integer.compare(second.getLevel(), first.getLevel());
			
	/** User stats comparator by points. */
	public static final Comparator<UserStats> COMPARATOR_BY_POINTS = 
			(first, second) -> Integer.compare(second.getPoints(), first.getPoints());
			
	/** Ingredient comparator by name. */
	public static final Comparator<Ingredient> COMPARATOR_BY_NAME =
			(first, second) -> first.getName().compareTo(second.getName());

}
