package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.zavrsniRad.BurgerMaster.domain.User;
import hr.fer.zavrsniRad.BurgerMaster.service.UserService;

/**
 * Class which presents user controller.
 * 
 * @author Jelena Šarić
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	/** User service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Gets user by <i>username</i> provided as request parameter.
	 * 
	 * @param username
	 *            user's user name
	 * @return <code>User</code> object if user with provided username exists,
	 *         otherwise <code>null</code>
	 */
	@GetMapping("/username/{username}")
	public User getByUsername(@PathVariable String username) {
		Optional<User> user = userService.findByUsername(username);
		return user.isPresent() ? user.get() : null;
	}
	
	/**
	 * Checks whether user with <i>username</i> provided as request parameter
	 * already exists.
	 * 
	 * @param username
	 *            user's user name
	 * 
	 * @throws UsernameAlreadyExistsException
	 *             if user with provided username already exists
	 */
	@GetMapping("/check/username/{username}")
	public void checkIfUsernameExists(@PathVariable String username) {
		if (userService.checkIfUsernameExists(username)) {
			throw new UsernameAlreadyExistsException(
					"User with provided username already exists!"
			);
		}
	}
	
	/**
	 * Checks whether user with <i>email</i> provided as request parameter already
	 * exists.
	 * 
	 * @param email
	 *            user's email
	 * 
	 * @throws EmailAlreadyExistsException
	 *             if user with provided email already exists
	 */
	@GetMapping("/check/email/{email}")
	public void checkIfEmailExists(@PathVariable String email) {
		if (userService.checkIfEmailExists(email)) {
			throw new EmailAlreadyExistsException(
					"User with provided email already exists!"
			);
		}
	}
	
	/**
	 * Gets current user.
	 * 
	 * @param principal
	 *            principal reference
	 * 
	 * @return user who has currently established session
	 */
	@GetMapping("/current")
	public User getCurrentUser(Principal principal) {
		Objects.requireNonNull(principal, "Principal can not be null!");
		String username = principal.getName();
		return userService.findByUsername(username).get();
	}
	
	/**
	 * Registers new user in the system.
	 * 
	 * @param user
	 *            new user
	 * 
	 * @return newly added user
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public User registerUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
}
