package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.builder.InteractiveComponent;

/*
 * Checks for Collision between 
 */
public class BallPaddleController extends InteractiveComponentController {

	public BallPaddleController(InteractiveComponent ball, InteractiveComponent paddle) {
		super(ball, paddle);
	}

	// No need to overwrite the checkCollision method as its generic
}
