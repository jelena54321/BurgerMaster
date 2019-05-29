package hr.fer.zavrsniRad.BurgerMaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import hr.fer.zavrsniRad.BurgerMaster.dao.UserRepository;
import hr.fer.zavrsniRad.BurgerMaster.domain.User;

/**
 * Class which presents concrete implementation of <code>UserService</code>.
 * 
 * @author Jelena Šarić
 */
@Service
public class UserServiceImpl implements UserService {
	
	/** User repository. */
	@Autowired
	private UserRepository repository;
	
	@Autowired
    private InMemoryUserDetailsManager manager;
	
	/** Password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<User> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		manager.createUser(
			org.springframework.security.core.userdetails.User.withUsername(
					user.getUsername())
					.password(user.getPassword())
					.roles("USER")
					.build()
		);
		
		return repository.save(user);
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public boolean checkIfUsernameExists(String username) {
		return repository.findByUsername(username).isPresent();
	}

	@Override
	public boolean checkIfEmailExists(String email) {
		return repository.findByEmail(email).isPresent();
	}

}
