package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.zavrsniRad.BurgerMaster.domain.District;
import hr.fer.zavrsniRad.BurgerMaster.service.DistrictService;

/**
 * Class which presents district controller.
 * 
 * @author Jelena Šarić
 *
 */
@RestController
@RequestMapping("/districts")
public class DistrictController {
	
	/** District service. */
	@Autowired
	private DistrictService districtService;
	
	/**
	 * Gets districts grouped by their id's. 
	 * 
	 * @return map of districts associated with their ids as keys
	 */
	@GetMapping("/asMap")
	public Map<Integer, District> getDistrictsAsMap() {
		return districtService.collectAsMap();
	}

}
