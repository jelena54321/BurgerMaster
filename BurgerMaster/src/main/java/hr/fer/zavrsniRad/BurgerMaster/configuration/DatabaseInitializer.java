package hr.fer.zavrsniRad.BurgerMaster.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import hr.fer.zavrsniRad.BurgerMaster.domain.User;
import hr.fer.zavrsniRad.BurgerMaster.service.UserService;

/**
 * Class which presents database initializer.
 * 
 * @author Jelena Šarić
 *
 */
@Component
@Lazy
public class DatabaseInitializer {
	    
    /** User service. */
    @Autowired
    private UserService userService;
    
    /**
     * Defines action which will be executed once application is ready.
     * 
     * @param event app ready event
     */
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		String[] usernames = new String[] {
				"marko", 
				"ivo", 
				"ana"
		};
		String[] emails = new String[] {
				"marko.markic@fer.hr", 
				"ivo.ivic@fer.hr", 
				"ana.anic@fer.hr"
		};
		
		for (int i = 0; i < usernames.length; i++) {
			String username = usernames[i];
			User user = new User();
			user.setUsername(username);
			user.setPassword(username);
			user.setEmail(emails[i]);
			
			userService.createUser(user);
		}
	}
}
