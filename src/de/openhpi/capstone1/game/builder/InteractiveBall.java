package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.exceptions.OutOfDisplayException;
import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.Event;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallView;
import processing.core.PApplet;

public class InteractiveBall extends InteractiveComponent{

	BallView bView;
	
	public InteractiveBall(PApplet applet) {
		super();
		init(applet);
	}
	
	private void init(PApplet applet) {
		bView = new BallView(applet, new Ball());
		views = new AbstractView[] {bView};
	}	
	
	@Override
	public void handleEvent() throws OutOfDisplayException  {
		// move the ball(s)
		for (AbstractView v : views) {
			Ball b = (Ball) ((BallView) v).getSubject();
			switch (b.getDir()) {
				case NORTHEAST: b.moveUp();   
								b.moveRight(); 
								break;
				case SOUTHEAST: b.moveDown(); 
								b.moveRight();
								break;
				case SOUTHWEST: b.moveDown(); 
								b.moveLeft();
								break;
				case NORTHWEST: b.moveUp();   
								b.moveLeft(); 
								break;		
			}
			// detect edge collision and switch direction
			boolean isOver = false;
			try { isOver = b.detectCollision(); } 
			catch (Exception e) { 
				System.out.println(e.getMessage());
			}
			if (isOver == true) { 
			//		System.out.println("GAME OVER"); 
			//		System.exit(-1);
				throw new OutOfDisplayException();
			}
		}
	}

	@Override
	public void handleEvent(Event e, Object o) {
		// DO NOTHING
	}	
}
