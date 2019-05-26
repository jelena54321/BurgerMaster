package hr.fer.zavrsniRad.BurgerMaster.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;

/**
 * Interface to user's stats repository.
 * 
 * @author Jelena Šarić
 */
@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Integer> {
	
	/**
	 * Finds user's stats by <i>userId</i> provided as argument.
	 * 
	 * @param userId user's id
	 * 
	 * @return user's stats if user's stats with provided user id exists, 
	 * 		   otherwise empty optional 
	 */
	Optional<UserStats> findByUserId(int userId);

}
