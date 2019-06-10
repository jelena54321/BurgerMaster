package hr.fer.zavrsniRad.BurgerMaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.Burger;

/**
 * Interface which presents communication with repository for storing
 * {@link Burger} objects.
 * 
 * @author Jelena Šarić
 *
 */
@Repository
public interface BurgerRepository extends JpaRepository<Burger, String> {

}
