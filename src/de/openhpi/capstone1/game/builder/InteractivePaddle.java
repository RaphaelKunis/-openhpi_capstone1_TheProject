package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.model.Event;
import de.openhpi.capstone1.game.model.Mouse;
import de.openhpi.capstone1.game.model.MouseMove;
import de.openhpi.capstone1.game.model.Paddle;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.PaddleView;
import processing.core.PApplet;

public class InteractivePaddle extends InteractiveComponent{

	Paddle p;
	AbstractView pView;
	
	public InteractivePaddle(PApplet applet) {
		super();
		init(applet);
	}
	
	private void init(PApplet applet) {
		p = new Paddle();
		pView = new PaddleView(applet, p);
		views = new AbstractView[] {pView};
	}
	
	@Override
	public void handleEvent() {
		handleEvent(Event.NONE, null);
	}

	public void handleEvent(Event e, Object o) {
		switch (e) {
			case KEYBOARD: int keyCode = (int) o;
						   if (keyCode == 39) p.moveRight();
						   if (keyCode == 37) p.moveLeft();		
						   break;
			case MOUSEMOVE: Mouse mouse = (Mouse) o;
							if (mouse.getMove() == MouseMove.RIGHT) p.moveRight(); 
							else p.moveLeft();
							break;
			case MOUSECLICK: break;		// Currently does nothing
			case NONE: return;
		}	
	}
}
