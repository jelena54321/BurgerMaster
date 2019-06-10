package hr.fer.zavrsniRad.BurgerMaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.District;

/**
 * Interface which presents communication with repository for storing
 * {@link District} objects.
 * 
 * @author Jelena Šarić
 *
 */
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

}
