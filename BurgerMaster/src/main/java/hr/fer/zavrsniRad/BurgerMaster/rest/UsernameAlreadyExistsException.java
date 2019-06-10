package hr.fer.zavrsniRad.BurgerMaster.rest;

/**
 * Class which presents exception which is thrown when user with provided user
 * name already exists in the database.
 * 
 * @author Jelena Šarić
 *
 */
public class UsernameAlreadyExistsException extends RuntimeException {

	/** Serial version number. */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates default <code>UsernameAlreadyExistsException</code> instance.
	 */
	public UsernameAlreadyExistsException() {
		super();
	}

	/**
	 * Creates <code>UsernameAlreadyExistsException</code> instance with message and
	 * cause provided as arguments.
	 * 
	 * @param message
	 *            message to user
	 * @param cause
	 *            cause of exception
	 */
	public UsernameAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates <code>UsernameAlreadyExistsException</code> instance with message and
	 * provided as argument.
	 * 
	 * @param message
	 *            message to user
	 */
	public UsernameAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * Creates <code>UsernameAlreadyExistsException</code> instance with cause
	 * provided as argument.
	 * 
	 * @param cause
	 *            cause of exception
	 */
	public UsernameAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
	

}
