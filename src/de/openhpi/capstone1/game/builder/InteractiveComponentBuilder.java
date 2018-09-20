package de.openhpi.capstone1.game.builder;

import processing.core.PApplet;

public class InteractiveComponentBuilder {
	public static InteractiveComponent create(PApplet applet, String type) {
		InteractiveComponent component = null;	
		switch (type) {
			case "Paddle": component = new InteractivePaddle(applet); break;
			case "Ball":   component = new InteractiveBall(applet); break;
		}
	return component;
	}
}
