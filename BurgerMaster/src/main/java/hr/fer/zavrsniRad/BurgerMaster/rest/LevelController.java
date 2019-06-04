package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.zavrsniRad.BurgerMaster.domain.Level;
import hr.fer.zavrsniRad.BurgerMaster.service.LevelService;

@RestController
@RequestMapping("/levels")
public class LevelController {
	
	@Autowired
	private LevelService service;
	
	@GetMapping
	public List<Level> getLevels() {
		return service.listAll();
	}
	
	@GetMapping("/asMap")
	public Map<Integer, Level> getLevelsAsMap() {
		return service.collectAsMap();
	}

}
