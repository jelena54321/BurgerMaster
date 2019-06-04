package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;
import hr.fer.zavrsniRad.BurgerMaster.service.UserStatsService;

/**
 * Class which presents user stats controller.đ
 * 
 * @author Jelena Šarić
 */
@RestController
@RequestMapping("/stats")
public class UserStatsController {
	
	/** User stats service. */
	@Autowired
	private UserStatsService service;
	
	/** Comparator by level. */
	private static final Comparator<UserStats> COMPARATOR_BY_LEVEL = 
			(first, second) -> Integer.compare(second.getLevel(), first.getLevel());
			
			
	/** Comparator by points. */
	private static final Comparator<UserStats> COMPARATOR_BY_POINTS = 
			(first, second) -> Integer.compare(second.getPoints(), first.getPoints());
	
	/**
	 * Gets all user's stats stored in the database.
	 * 
	 * @return list of <code>UserStats</code> objects
	 */
	@GetMapping
	public List<UserStats> getUserStats() {
		return service.listAll();
	}
	
	/**
	 * Gets user's stats by <i>userId</i> provided as request parameter.
	 * 
	 * @param userId user's id
	 * 
	 * @return user's stats if stats with provided user id exists, otherwise
	 * 		   <code>null</code>
	 */
	@GetMapping("/single")
	public UserStats getByUsername(@RequestParam("username") Optional<String> username) {
		if (!username.isPresent()) return null;
		Optional<UserStats> userStats = service.findByUsername(username.get());
		return userStats.isPresent() ? userStats.get() : null;
	}
	
	/**
	 * Saves new <code>UserStats</code> object in the database.
	 * 
	 * @param userStats new user's stats
	 * 
	 * @return newly added user's stats object
	 */
	@PostMapping
	public UserStats createUserStats(@RequestBody UserStats userStats) {
		return service.saveUserStats(userStats);
	}
	
	/**
	 * Gets all user's stats stored in the database in descending order
	 * by level.
	 * 
	 * @return list of <code>UserStats</code> objects sorted by level in
	 * 		   descending order
	 */
	@GetMapping("/sorted/byLevel")
	public List<UserStats> getUserStatsSortedByLevel() {
		return service.listSorted(COMPARATOR_BY_LEVEL.thenComparing(COMPARATOR_BY_POINTS));
	}
	
	/**
	 * Gets all user's stats stored in the database in descending order
	 * by points.
	 * 
	 * @return list of <code>UserStats</code> objects sorted by points in
	 * 		   descending order
	 */
	@GetMapping("/sorted/byPoints")
	public List<UserStats> getUserStatsSortedByPoints() {
		return service.listSorted(COMPARATOR_BY_POINTS.thenComparing(COMPARATOR_BY_LEVEL));
	}

}
