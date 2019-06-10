package hr.fer.zavrsniRad.BurgerMaster.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class which presents redirect controller for various requests.
 *  
 * @author Jelena Šarić
 *
 */
@Controller
public class RedirectController {
	
	/**
	 * Redirects to index page.
	 * 
	 * @return <i>index.html</i>
	 */
	@RequestMapping({"/", ""})
	public String getIndexPage() {
		return "index";
	}
	
	/**
	 * Redirects to registration page.
	 * 
	 * @return <i>registration.html</i>
	 */
	@RequestMapping("/register")
	public String getRegistrationPage() {
		return "static/registration";
	}
	
	/**
	 * Redirects to recipes page.
	 * 
	 * @return <i>recipes.html</i>
	 */
	@RequestMapping("/recipes")
	public String getRecipesPage() {
		return "static/recipes";
	}
	
	/**
	 * Redirects to rankings page.
	 * 
	 * @return <i>rankings.html</i>
	 */
	@RequestMapping("/rankings")
	public String getRankingsPage() {
		return "static/rankings";
	}
	
	/**
	 * Redirects to map page.
	 * 
	 * @return <i>map.html</i>
	 */
	@RequestMapping("/map")
	public String getMapPage() {
		return "static/map";
	}
	
	/**
	 * Redirects to game page.
	 * 
	 * @return <i>game.html</i>
	 */
	@RequestMapping("/game")
	public String getGamePage() {
		return "static/game";
	}

}
