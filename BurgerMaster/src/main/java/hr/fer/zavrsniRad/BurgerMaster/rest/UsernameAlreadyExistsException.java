package hr.fer.zavrsniRad.BurgerMaster.rest;

/**
 * Class which presents exception which is thrown when user with
 * provided user name already exists in the database.
 * 
 * @author Jelena Šarić
 *
 */
public class UsernameAlreadyExistsException extends RuntimeException {

	/** Serial version number. */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExistsException() {
		super();
	}

	public UsernameAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}

	public UsernameAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
	

}
