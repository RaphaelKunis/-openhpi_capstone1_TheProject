package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.model.Event;
import de.openhpi.capstone1.game.model.Mouse;
import de.openhpi.capstone1.game.model.MouseMove;
import de.openhpi.capstone1.game.model.Paddle;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.PaddleView;
import processing.core.PApplet;

public class InteractivePaddle extends InteractiveComponent{

	AbstractView pView;
	
	public InteractivePaddle(PApplet applet) {
		super();
		init(applet);
	}
	
	private void init(PApplet applet) {
		pView = new PaddleView(applet, new Paddle());
		views = new AbstractView[] {pView};
	}
	
	@Override
	public void handleEvent() {
		handleEvent(Event.NONE, null);
	}

	@Override
	public void handleEvent(Event e, Object o) {
		switch (e) {
			case KEYBOARD: int keyCode = (int) o;
						   if (keyCode == 39) for (AbstractView v : views) v.getSubject().moveRight();
						   if (keyCode == 37) for (AbstractView v : views) v.getSubject().moveLeft();		
						   break;
			case MOUSEMOVE: Mouse mouse = (Mouse) o;
							if (mouse.getMove() == MouseMove.RIGHT) for (AbstractView v : views) v.getSubject().moveRight(); 
							else for (AbstractView v : views) v.getSubject().moveLeft();
							break;
//			case MOUSECLICK: break;		// Currently does nothing
			case NONE: return;
		}
	}
}
