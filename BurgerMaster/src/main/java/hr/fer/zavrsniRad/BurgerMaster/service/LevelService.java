package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.domain.Level;

@Service
public interface LevelService {
	
	List<Level> listAll();
	
	Map<Integer, Level> collectAsMap();

}
