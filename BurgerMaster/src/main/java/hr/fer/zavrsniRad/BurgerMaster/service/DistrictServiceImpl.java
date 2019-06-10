package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.dao.DistrictRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.District;

/**
 * Class which presents {@link DistrictService} interface implementation.
 * 
 * @author Jelena Šarić
 *
 */
@Service
public class DistrictServiceImpl implements DistrictService {
	
	/** District repository. */
	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public Map<Integer, District> collectAsMap() {
		List<District> districts = districtRepository.findAll();
		return districts.stream().collect(
				Collectors.toMap(
					(district) -> district.getId(), 
					(district) -> district
				)
		);
	}

}
