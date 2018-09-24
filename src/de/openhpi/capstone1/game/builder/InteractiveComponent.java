package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.model.Event;
import de.openhpi.capstone1.game.view.AbstractView;

public abstract class InteractiveComponent {
	
	public abstract void handleEvent() throws Exception;	// needed to tell the calling App that the ball went out of the display -> OutOfDisplayException
	public abstract void handleEvent(Event e, Object o);
	
	protected AbstractView[] views; 
	
	
	public void update() {
		for (AbstractView view : views) {
			view.update(); 
		}
	}
	
	/* return the views **/
	public AbstractView[] getViews() {
		return views;
	}
}
