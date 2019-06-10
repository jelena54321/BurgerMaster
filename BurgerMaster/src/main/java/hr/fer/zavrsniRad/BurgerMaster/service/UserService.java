package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.domain.User;

/**
 * Interface which presents user service.
 * 
 * @author Jelena Šarić
 */
@Service
public interface UserService {
	
	/**
	 * Finds user by <i>username</i> provided as argument.
	 * 
	 * @param username
	 *            user's user name
	 * 
	 * @return user if user with provided username exists, otherwise empty optional
	 *         is returned
	 */
	Optional<User> findByUsername(String username);
	
	/**
	 * Creates <i>user</i> provided as argument and stores said user in database.
	 * 
	 * @param user
	 *            new user
	 * 
	 * @return newly created user
	 */
	User createUser(User user);
		
	/**
	 * Checks whether user with provided <i>username</i> already exists in the
	 * database.
	 * 
	 * @param username
	 *            user name which is inquired
	 * 
	 * @return <code>true</code> if user with provided user name exists,
	 *         <code>false</code> otherwise
	 */
	boolean checkIfUsernameExists(String username);
	
	/**
	 * Checks whether user with provided <i>email</i> already exists in the
	 * database.
	 * 
	 * @param email
	 *            email which is inquired
	 * 
	 * @return <code>true</code> if user with provided email exists,
	 *         <code>false</code> otherwise
	 */
	boolean checkIfEmailExists(String email);

}
