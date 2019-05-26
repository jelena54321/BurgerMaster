package hr.fer.zavrsniRad.BurgerMaster.rest;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private UserService service;
	
	/**
	 * Gets user by <i>id</i> provided as request parameter.
	 * 
	 * @param id user's id
	 * 
	 * @return <code>User</code> object if user with provided id exists, otherwise
	 * 		   <code>null</code>
	 */
	@GetMapping
	public User getById(@RequestParam("id") Optional<Integer> id) {
		if (!id.isPresent()) return null;
		Optional<User> user = service.findById(id.get());
		return user.isPresent() ? user.get() : null;
	}
	
	/**
	 * Gets user by <i>username</i> provided as request parameter.
	 * 
	 * @param username user's user name
	 * @return <code>User</code> object if user with provided username exists, otherwise
	 * 		   <code>null</code>
	 */
	@GetMapping
	public User getByUsername(@RequestParam("username") Optional<String> username) {
		if (!username.isPresent()) return null;
		Optional<User> user = service.findByUsername(username.get());
		return user.isPresent() ? user.get() : null;
	}
	
	/**
	 * Checks whether user with <i>username</i> provided as request parameter already
	 * exist.
	 * 
	 * @param username user's user name
	 * 
	 * @throws UsernameAlreadyExistsException if user with provided username already
	 * 										  exists
	 */
	@GetMapping("/check")
	public void checkIfUsernameExists(@RequestParam("username") Optional<String> username) {
		if (!username.isPresent()) return;
		if (service.checkIfUsernameExists(username.get())) {
			throw new UsernameAlreadyExistsException(
					"User with provided username already exists!"
			);
		}
	}
	
	/**
	 * Checks whether user with <i>email</i> provided as request parameter already
	 * exist.
	 * 
	 * @param email user's email
	 * 
	 * @throws EmailAlreadyExistsException if user with provided email already
	 * 									   exists
	 */
	@GetMapping("/check")
	public void checkIfEmailExists(@RequestParam("email") Optional<String> email) {
		if (!email.isPresent()) return;
		if (service.checkIfEmailExists(email.get())) {
			throw new EmailAlreadyExistsException(
					"User with provided email already exists!"
			);
		}
	}
	
	/**
	 * Gets current user.
	 * 
	 * @param principal principal reference
	 * 
	 * @return user who has currently established session
	 */
	@GetMapping("/current")
	public User getCurrentUser(Principal principal) {
		Objects.requireNonNull(principal, "Principal can not be null!");
		String username = principal.getName();
		return service.findByUsername(username).get();
	}
	
	/**
	 * Registers new user in the system.
	 * 
	 * @param user new user
	 * 
	 * @return newly added user
	 */
	@PostMapping
	public User registerUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
}
