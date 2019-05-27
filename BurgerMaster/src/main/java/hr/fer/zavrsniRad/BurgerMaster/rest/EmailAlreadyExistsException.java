package hr.fer.zavrsniRad.BurgerMaster.rest;

/**
 * Class which presents exception which is thrown when user with
 * provided email already exists in the database.
 * 
 * @author Jelena Šarić
 *
 */
public class EmailAlreadyExistsException extends RuntimeException {

	/** Serial version number. */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException() {
		super();
	}

	public EmailAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailAlreadyExistsException(String message) {
		super(message);
	}

	public EmailAlreadyExistsException(Throwable cause) {
		super(cause);
	}
}
