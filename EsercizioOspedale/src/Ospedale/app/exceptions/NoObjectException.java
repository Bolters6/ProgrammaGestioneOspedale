package Ospedale.app.exceptions;

public class NoObjectException extends Exception{
	public NoObjectException() {
		super("non esiste nessun paziente con i requisiti");
	}
}
