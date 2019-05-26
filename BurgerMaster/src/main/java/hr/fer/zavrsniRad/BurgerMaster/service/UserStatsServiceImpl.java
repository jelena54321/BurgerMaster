package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import hr.fer.zavrsniRad.BurgerMaster.dao.UserStatsRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.UserStats;

/**
 * Class which presents concrete implementation of <code>UserStatsService</code>.
 * 
 * @author Jelena Šarić
 */
public class UserStatsServiceImpl implements UserStatsService {
	
	/** User stats repository. */
	@Autowired
	private UserStatsRepository repository;

	@Override
	public List<UserStats> listAll() {
		return repository.findAll();
	}

	@Override
	public Optional<UserStats> findByUserId(int userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public UserStats createUserStats(UserStats userStats) {
		return repository.save(userStats);
	}

	@Override
	public UserStats saveUserStats(UserStats userStats) {
		return repository.save(userStats);
	}

	@Override
	public List<UserStats> listSorted(Comparator<UserStats> comparator) {
		List<UserStats> userStats = repository.findAll();
		Collections.sort(userStats, comparator);
		return userStats;
	}

}
