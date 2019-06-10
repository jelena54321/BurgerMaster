package hr.fer.zavrsniRad.BurgerMaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.Ingredient;

/**
 * Interface which presents communication with repository for storing
 * {@link Ingredient} objects.
 * 
 * @author Jelena Šarić
 *
 */
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
