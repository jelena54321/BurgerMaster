package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.dao.LevelRepository;
import hr.fer.zavrsniRad.BurgerMaster.dao.UserStatsRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.Level;
import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;
import hr.fer.zavrsniRad.BurgerMaster.util.Constants;
import hr.fer.zavrsniRad.BurgerMaster.util.Util;

/**
 * Class which presents {@link UserStatsService} interface implementation.
 * 
 * @author Jelena Šarić
 */
@Service
public class UserStatsServiceImpl implements UserStatsService {
	
	/** User stats repository. */
	@Autowired
	private UserStatsRepository statsRepository;
	
	/** Level repository. */
	@Autowired
	private LevelRepository levelRepository;

	@Override
	public Optional<UserStats> findByUsername(String username) {
		List<UserStats> stats = statsRepository.findAllByUsername(username);
		stats.sort(Util.COMPARATOR_BY_LEVEL);
		return stats.size() == 0 ? Optional.empty() : Optional.of(stats.get(0));
	}

	@Override
	public UserStats saveUserStats(UserStats userStats) {
		Optional<UserStats> oldUserStatsOptional = 
				statsRepository.findByUsernameAndLevel(
						userStats.getUsername(), userStats.getLevel()
				);
		
		if (!oldUserStatsOptional.isPresent()) {
			return statsRepository.save(userStats);
		}
		
		UserStats oldUserStats = oldUserStatsOptional.get();
		int oldPoints = oldUserStats.getPoints();
		int newPoints = userStats.getPoints();
		if (oldPoints < newPoints) {
			oldUserStats.setPoints(newPoints);
		}
		
		Level level = levelRepository.findByLevel(userStats.getLevel()).get();
		if (hasPassedLevel(oldUserStats, level) 
				&& oldUserStats.getLevel() != Constants.FINAL_LEVEL) {
			
			unlockNextLevel(oldUserStats);
		}
		
		return statsRepository.save(oldUserStats);
	}

	@Override
	public List<UserStats> listSorted(Comparator<UserStats> comparator) {
		List<UserStats> userStats = statsRepository.findAll();
		Collections.sort(userStats, comparator);
		return userStats;
	}
	
	/**
	 * Returns <code>boolean</code> value whether user has passed provided level.
	 * 
	 * @param userStats
	 *            user's stats
	 * @param level
	 *            game level
	 * @return <code>true</code> if user has passed level, <code>false</code>
	 *         otherwise
	 */
	private static boolean hasPassedLevel(UserStats userStats, Level level) {
		return userStats.getPoints() > level.getThreshold();
	}
	
	/**
	 * Unlocks next level by creating user stats for said level.
	 * 
	 * @param oldUserStats
	 *            previously passed level
	 */
	private void unlockNextLevel(UserStats oldUserStats) {
		UserStats unlockedStats = new UserStats();
		unlockedStats.setLevel(oldUserStats.getLevel() + 1);
		unlockedStats.setUsername(oldUserStats.getUsername());
		statsRepository.save(unlockedStats);
	}

}
