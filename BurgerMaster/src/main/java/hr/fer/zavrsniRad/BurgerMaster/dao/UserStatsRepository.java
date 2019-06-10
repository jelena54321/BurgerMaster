package hr.fer.zavrsniRad.BurgerMaster.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;

/**
 * Interface which presents communication with repository for storing
 * {@link UserStats} objects.
 * 
 * @author Jelena Šarić
 *
 */
@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Integer> {
	
	/**
	 * Finds all user's stats by <i>username</i> provided as argument.
	 * 
	 * @param username
	 *            user's user name
	 *            
	 * @return list of <code>UserStats</code> objects with user name value
	 *         corresponding to argument
	 */
	List<UserStats> findAllByUsername(String username);
	
	/**
	 * Finds user's stats by <i>username</i> and <i>level</i> provided as argument.
	 * 
	 * @param username
	 *            user's user name
	 * @param level
	 *            level for which are stats inquired
	 * 
	 * @return <code>UserStats</code> object with user name and level value
	 *         corresponding to arguments
	 */
	Optional<UserStats> findByUsernameAndLevel(String username, int level);
}
