package hr.fer.zavrsniRad.BurgerMaster.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.dao.LevelRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.Burger;
import hr.fer.zavrsniRad.BurgerMaster.domain.Game;
import hr.fer.zavrsniRad.BurgerMaster.domain.Level;

/**
 * Class which presents {@link GameService} interface implementation. 
 * 
 * @author Jelena Šarić
 *
 */
@Service
public class GameServiceImpl implements GameService {

	/** Level repository. */
	@Autowired
	private LevelRepository levelRepository;

	@Override
	public Game createGame(int level) {
		Level gameLevel = levelRepository.findByLevel(level).get();
		List<Burger> burgers = gameLevel.getBurgers();
		List<Burger> orders = new ArrayList<>();
		Random random = new Random();
		int size = burgers.size();
		for (int i = 0, n = gameLevel.getOrdersCount() ; i < n; i++) {
			orders.add(burgers.get(random.nextInt(size)));
		}
		
		Game game = new Game();
		game.setSleepInterval(gameLevel.getSleepInterval());
		game.setOrders(orders);
		return game; 
	}

	@Override
	public int postResults(Game game) {
		int noOfOrders = game.getOrders().size();
		int noOfResults = game.getResults().size();
		
		int points = 0;
		int n = Math.min(noOfOrders, noOfResults);
		for (int i = 0; i < n; i++) {
			Burger order = game.getOrders().get(i);
			Burger result = game.getResults().get(i);
			if (!order.equals(result)) continue;
			
			points += order.getPoints();
		}
		
		points += Duration.ofMinutes(2)
						  .minus(Duration.ofMillis(game.getTotalTime()))
						  .getSeconds();
		
		return points;
	}

}
