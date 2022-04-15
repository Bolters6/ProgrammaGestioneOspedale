package Ospedale.app.exceptions;

public class OrganoPresenteException extends Exception {
	public OrganoPresenteException() {
		super("questo organo e gia presente");
	}
}
