package Ospedale.app.exceptions;

public class PazienteException extends Exception {
	public PazienteException() {
		super("questo paziente gia esiste nel sistema");
	}
}
