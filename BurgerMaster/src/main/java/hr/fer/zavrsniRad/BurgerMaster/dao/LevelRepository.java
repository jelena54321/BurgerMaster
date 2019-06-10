package hr.fer.zavrsniRad.BurgerMaster.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.Level;

/**
 * Interface which presents communication with repository for storing
 * {@link Level} objects.
 * 
 * @author Jelena Šarić
 *
 */
@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {

	/**
	 * Finds level by <i>level</i> provided as argument.
	 * 
	 * @param level
	 *            game level
	 * 
	 * @return <code>Level</code>, if such level exists, stored in
	 *         <code>Optional</code>
	 */
	Optional<Level> findByLevel(int level);
}
