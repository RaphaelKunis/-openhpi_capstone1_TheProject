package de.openhpi.capstone1.game.exceptions;

public class OutOfDisplayException extends Exception {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -476269679752153851L;

	@Override
	public String getMessage() {
		return "Ball went out of display";
	}
	
}
