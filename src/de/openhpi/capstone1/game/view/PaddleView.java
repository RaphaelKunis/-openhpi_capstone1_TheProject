package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.AbstractSubject;
import de.openhpi.capstone1.game.model.Paddle;
import processing.core.PApplet;

public class PaddleView extends AbstractView {

	AbstractSubject p;
	
	public PaddleView(PApplet display) {
		this(display, new Paddle());
	}
	
	public PaddleView(PApplet display, AbstractSubject paddle) {
		super(display);
		this.p = paddle;
	}
	
	@Override
	public void update() {
		display.rect(p.getPosX(), p.getPosY(), p.getWidth(), p.getHeight());
		display.redraw();
	}

	@Override
	public AbstractSubject getSubject() {
		return p;
	}
}
