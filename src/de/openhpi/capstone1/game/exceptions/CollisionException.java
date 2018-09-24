package de.openhpi.capstone1.game.exceptions;

public class CollisionException extends Exception {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -5417637994867291886L;

	public CollisionException(String reason) {
		super(reason);
	}
}
