package hr.fer.zavrsniRad.BurgerMaster.service;

import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.domain.Game;

/**
 * Class which presents game service.
 * 
 * @author Jelena Šarić
 *
 */
@Service
public interface GameService {
	
	/**
	 * Returns new game instance for level value as provided as argument.
	 * 
	 * @param level
	 *            inquired game's level
	 */
	public Game createGame(int level);
	
	/**
	 * Posts user's results and returns calculated points according to useer's
	 * performance.
	 * 
	 * @param game
	 *            game for which points ought to be calculated
	 * 
	 * @return user's points
	 */
	public int postResults(Game game);

}
