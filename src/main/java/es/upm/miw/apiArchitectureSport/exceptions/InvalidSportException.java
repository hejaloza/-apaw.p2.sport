package es.upm.miw.apiArchitectureSport.exceptions;

public class InvalidSportException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "El deporte no existe, para poder asociarlo";

	public InvalidSportException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidSportException() {
		this("");
	}

}
