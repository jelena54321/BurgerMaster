package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;

/**
 * Interface which presents user stats service.
 * 
 * @author Jelena Šarić
 */
public interface UserStatsService {
	
	/**
	 * Lists all user's stats stored in the database.
	 * 
	 * @return list of <code>UserStats</code> objects
	 */
	List<UserStats> listAll();
	
	/**
	 * Finds user's stats by <i>userId</i> provided as argument.
	 * 
	 * @param userId user's id
	 * 
	 * @return user's stats if user's stats with provided user id exists, 
	 * 		   otherwise empty optional 
	 */
	Optional<UserStats> findByUserId(int userId);
	
	/**
	 * Creates <i>userStats</i> provided as argument in the database.
	 * 
	 * @param userStats new user's stats
	 * 
	 * @return newly created user's stats
	 */
	UserStats createUserStats(UserStats userStats);
	
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
