package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;
import hr.fer.zavrsniRad.BurgerMaster.service.UserStatsService;
import hr.fer.zavrsniRad.BurgerMaster.util.Constants;
import hr.fer.zavrsniRad.BurgerMaster.util.Util;

/**
 * Class which presents user stats controller.
 * 
 * @author Jelena Šarić
 * 
 */
@RestController
@RequestMapping("/stats")
public class UserStatsController {
	
	/** User stats service. */
	@Autowired
	private UserStatsService service;
	
	/**
	 * Gets user's stats by <i>userId</i> provided as request parameter.
	 * 
	 * @param userId user's id
	 * 
	 * @return user's stats if stats with provided user id exists, otherwise
	 * 		   <code>null</code>
	 */
	@GetMapping("/single")
	public UserStats getByUsername(@RequestParam(Constants.USERNAME) Optional<String> username) {
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
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserStats saveUserStats(@RequestBody UserStats userStats) {
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
		return service.listSorted(
				Util.COMPARATOR_BY_LEVEL.thenComparing(Util.COMPARATOR_BY_POINTS)
		);
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
		return service.listSorted(
				Util.COMPARATOR_BY_POINTS.thenComparing(Util.COMPARATOR_BY_LEVEL)
		);
	}

}
