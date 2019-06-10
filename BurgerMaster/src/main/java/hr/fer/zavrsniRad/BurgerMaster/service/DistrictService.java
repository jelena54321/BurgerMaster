package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.domain.District;

/**
 * Class which presents district service.
 * 
 * @author Jelena Šarić
 *
 */
@Service
public interface DistrictService {

	/**
	 * Gets districts grouped by their id's. 
	 * 
	 * @return map of districts associated with their ids as keys
	 */
	Map<Integer, District> collectAsMap();
}
