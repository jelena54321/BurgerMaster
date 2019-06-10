package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.dao.UserRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.User;
import hr.fer.zavrsniRad.BurgerMaster.util.Constants;

/**
 * Class which presents {@link UserService} interface implementation.
 * 
 * @author Jelena Šarić
 */
@Service
public class UserServiceImpl implements UserService {
	
	/** User repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** User details manager. */
	@Autowired
    private InMemoryUserDetailsManager manager;
	
	/** Password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		manager.createUser(
			org.springframework.security.core.userdetails.User.withUsername(
					user.getUsername())
					.password(user.getPassword())
					.roles(Constants.USER)
					.build()
		);
		
		return userRepository.save(user);
	}

	@Override
	public boolean checkIfUsernameExists(String username) {
		return userRepository.findByUsername(username).isPresent();
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		return userRepository.findByEmail(email).isPresent();
	}

}
