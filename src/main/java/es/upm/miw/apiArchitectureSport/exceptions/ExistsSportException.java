package es.upm.miw.apiArchitectureSport.exceptions;

public class ExistsSportException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "Deporte ya existe";

	public ExistsSportException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public ExistsSportException() {
		this("");
	}

}
