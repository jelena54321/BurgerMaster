package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;

/**
 * Interface which presents user stats service.
 * 
 * @author Jelena Šarić
 */
@Service
public interface UserStatsService {
	
	/**
	 * Finds user's stats by <i>username</i> provided as argument.
	 * 
	 * @param username user's username
	 * 
	 * @return user's stats if user's stats with provided username exists, 
	 * 		   otherwise empty optional 
	 */
	Optional<UserStats> findByUsername(String username);
	
	/**
	 * Saves <i>userStats</i> provided as argument in the database.
	 * 
	 * @param userStats modified user's stats
	 * 
	 * @return saved user's stats
	 */
	UserStats saveUserStats(UserStats userStats);
	
	/**
	 * Lists all user's stats stored in the database using <i>comparator</i>.
	 * 
	 * @return list of <code>UserStats</code> objects sorted by comparator
	 */
	List<UserStats> listSorted(Comparator<UserStats> comparator);
}
