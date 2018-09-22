package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.starter.Defaults;
import processing.core.PApplet;

public class InteractiveComponentBuilder {
	public static InteractiveComponent create(PApplet applet, String type) {
		InteractiveComponent component = null;	
		switch (type) {
			case Defaults.NAME_PADDLE: component = new InteractivePaddle(applet); break;
			case Defaults.NAME_BALL:   component = new InteractiveBall(applet); break;
		}
		return component;
	}
}
