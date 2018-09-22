package de.openhpi.capstone1.game.view;

import de.openhpi.capstone1.game.model.AbstractSubject;
import processing.core.PApplet;

public abstract class AbstractView {
	protected PApplet display;
	
	public AbstractView(PApplet display) {
		this.display = display;
	}
	
	public abstract void update();
	
	public abstract AbstractSubject getSubject();
}
