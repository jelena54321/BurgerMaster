package hr.fer.zavrsniRad.BurgerMaster.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.User;

/**
 * Interface which presents communication with repository for storing
 * {@link User} objects.
 * 
 * @author Jelena Šarić
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Finds user by <i>username</i> provided as argument.
	 * 
	 * @param username
	 *            user's user name
	 * 
	 * @return <code>User</code>, if such user exists, stored in
	 *         <code>Optional</code>
	 */
	Optional<User> findByUsername(String username);

	/**
	 * Finds user by <i>email</i> provided as argument.
	 * 
	 * @param username
	 *            user's email
	 * 
	 * @return <code>User</code>, if such user exists, stored in
	 *         <code>Optional</code>
	 */
	Optional<User> findByEmail(String email);

}
