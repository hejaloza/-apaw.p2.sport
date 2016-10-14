package es.upm.miw.apiArchitectureSport.exceptions;

public class ExistsUserException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "El Usuario ya Existe";

	public ExistsUserException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public ExistsUserException() {
		this("");
	}

}
