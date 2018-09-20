package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.AbstractSubject;
import de.openhpi.capstone1.game.model.Ball;
import processing.core.PApplet;

public class BallView  extends AbstractView {
	
	AbstractSubject b = new Ball();
	
	public BallView(PApplet display) {
		this(display, new Ball());
	}

	public BallView(PApplet display, AbstractSubject ball) {
		super(display);
		this.b = ball;
	}	
	
	@Override
	public void update() {
		display.ellipse(b.getPosX(), b.getPosY(), b.getWidth(), b.getHeight());
		display.redraw();
	}
}
