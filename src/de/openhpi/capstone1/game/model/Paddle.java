package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.starter.Defaults;

public class Paddle extends AbstractSubject {

	public Paddle() {
		this.width 	= 50;
		this.height = 15;
		this.posX = Defaults.DIM_WIDTH/2;
		this.posY = Defaults.DIM_HEIGHT - height+1;
	}

	@Override
	public boolean detectCollision() {
		// Do nothing
		return false;
	}

	@Override
	public boolean detectCollision(AbstractSubject other) {
		// Do nothing
		return false;
	}
}
