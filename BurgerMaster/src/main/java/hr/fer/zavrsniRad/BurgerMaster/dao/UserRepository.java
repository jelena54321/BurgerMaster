package hr.fer.zavrsniRad.BurgerMaster.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.User;

/**
 * Interface to user repository.
 * 
 * @author Jelena Šarić
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * Finds user by <i>id</i> provided as argument.
	 * 
	 * @param id user's id
	 * 
	 * @return user if user with provided id exists, otherwise empty optional
	 */
	Optional<User> findById(int id);
	
	/**
	 * Finds user by <i>username</i> provided as argument.
	 * 
	 * @param username user's user name
	 * 
	 * @return user if user with provided user name exists, otherwise empty optional
	 */
	Optional<User> findByUsername(String username);
	
	/**
	 * Finds user by <i>email</i> provided as argument.
	 * 
	 * @param username user's email
	 * 
	 * @return user if user with provided email exists, otherwise empty optional
	 */
	Optional<User> findByEmail(String email);

}
