package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.zavrsniRad.BurgerMaster.domain.Game;
import hr.fer.zavrsniRad.BurgerMaster.service.GameService;

/**
 * Class which presents game controller.
 * 
 * @author Jelena Šarić
 *
 */
@RestController
@RequestMapping("/games")
public class GameController {

	/** Game service. */
	@Autowired
	private GameService gameService;

	/**
	 * Returns new game instance for level value as provided through request
	 * parameter.
	 * 
	 * @param level
	 *            inquired game's level if level is provided as argument, otherwise
	 *            <code>null</code>
	 */
	@GetMapping("/create")
	public Game createGame(@RequestParam Optional<Integer> level) {
		return level.isPresent() ? gameService.createGame(level.get()) : null;
	}

	/**
	 * Posts user's results and returns calculated points according to useer's
	 * performance.
	 * 
	 * @param game
	 *            game for which points ought to be calculated
	 * 
	 * @return user's points
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public int postResults(@RequestBody Game game) {
		return gameService.postResults(game);
	}
}
