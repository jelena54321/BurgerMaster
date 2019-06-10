package hr.fer.zavrsniRad.BurgerMaster.rest;

/**
 * Class which presents exception which is thrown when user with provided email
 * already exists in the database.
 * 
 * @author Jelena Šarić
 *
 */
public class EmailAlreadyExistsException extends RuntimeException {

	/** Serial version number. */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates default <code>EmailAlreadyExistsException</code> instance.
	 */
	public EmailAlreadyExistsException() {
		super();
	}

	/**
	 * Creates <code>EmailAlreadyExistsException</code> instance with message and
	 * cause provided as arguments.
	 * 
	 * @param message
	 *            message to user
	 * @param cause
	 *            cause of exception
	 */
	public EmailAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates <code>EmailAlreadyExistsException</code> instance with message and
	 * provided as argument.
	 * 
	 * @param message
	 *            message to user
	 */
	public EmailAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * Creates <code>EmailAlreadyExistsException</code> instance with cause provided
	 * as argument.
	 * 
	 * @param cause
	 *            cause of exception
	 */
	public EmailAlreadyExistsException(Throwable cause) {
		super(cause);
	}
}
