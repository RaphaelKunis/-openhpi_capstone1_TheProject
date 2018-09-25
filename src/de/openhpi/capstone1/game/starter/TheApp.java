package de.openhpi.capstone1.game.starter;


import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.builder.InteractiveComponentBuilder;
import de.openhpi.capstone1.game.controller.InteractiveComponentController;
import de.openhpi.capstone1.game.exceptions.OutOfDisplayException;
import de.openhpi.capstone1.game.controller.BallPaddleController;
import de.openhpi.capstone1.game.model.Event;
import de.openhpi.capstone1.game.model.Mouse;
import processing.core.PApplet;

public class TheApp extends PApplet {
	
	private Mouse mouse;
	InteractiveComponent pComp;
	InteractiveComponent bComp;
	InteractiveComponentController ctr;
	
	@Override
	public void settings() {
		size(Defaults.DIM_WIDTH,Defaults.DIM_HEIGHT);
	}

	@Override
	public void setup() {  // setup() runs once
		mouse = new Mouse();
		pComp = InteractiveComponentBuilder.create(this, "Paddle");
		bComp = InteractiveComponentBuilder.create(this, "Ball");
		ctr = new BallPaddleController(bComp, pComp);
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		this.fill(0);
		this.background(204);
		pComp.update();
		try { bComp.handleEvent(); bComp.update(); } // move the ball further
		catch (OutOfDisplayException e) {
			System.out.println(e.getMessage());
			// reset ball
			bComp = InteractiveComponentBuilder.create(this, "Ball");
			ctr = new BallPaddleController(bComp, pComp);
		}
		catch (Exception e) {	// check for other Exceptions
			System.out.println(e.getMessage());
		}
		
		ctr.checkCollision();	// check the ball->paddle collision
	}
	

	@Override 
	public void mouseMoved() {
		mouse.setCurPosX(this.mouseX);
		pComp.handleEvent(Event.MOUSEMOVE, mouse);
	}

//	@Override 
//	public void mouseClicked() {
//		pComp.handleEvent(Event.MOUSECLICK, null);
//	}	
	
	@Override
	public void keyPressed() {
		pComp.handleEvent(Event.KEYBOARD, keyCode);
	}
}
