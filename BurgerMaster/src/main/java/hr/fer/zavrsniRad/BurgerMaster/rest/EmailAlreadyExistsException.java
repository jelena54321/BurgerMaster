package hr.fer.zavrsniRad.BurgerMaster.rest;

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
