package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.dao.LevelRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.Level;

@Service
public class LevelServiceImpl implements LevelService {
	
	@Autowired
	private LevelRepository repository;

	@Override
	public List<Level> listAll() {
		return repository.findAll();
	}

	@Override
	public Map<Integer, Level> collectAsMap() {
		List<Level> levels = repository.findAll();
		return levels.stream().collect(
				Collectors.toMap(
					(level) -> level.getLevel(), 
					(level) -> level
				)
		);
	}

}
