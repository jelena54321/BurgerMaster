package hr.fer.zavrsniRad.BurgerMaster.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping({"/", ""})
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String getRegistrationPage() {
		return "static/registration";
	}
	
	@RequestMapping("/recipes")
	public String getRecipesPage() {
		return "static/recipes";
	}
	
	@RequestMapping("/rankings")
	public String getRankingsPage() {
		return "static/rankings";
	}
	
	@RequestMapping("/map")
	public String getMapPage() {
		return "static/map";
	}

}
