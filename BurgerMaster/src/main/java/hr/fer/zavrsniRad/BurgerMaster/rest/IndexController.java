package hr.fer.zavrsniRad.BurgerMaster.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Class which presents index controller.
 * 
 * @author Jelena Šarić
 */
@Controller
public class IndexController {
	
	@RequestMapping({"/", ""})
	public String getIndexPage() {
		return "index";
	}

}
