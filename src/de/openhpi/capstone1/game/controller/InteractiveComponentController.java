package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.builder.InteractiveComponent;
import de.openhpi.capstone1.game.view.AbstractView;

/*
 * Possibility to interact between two InteractiveComponents, e.g. InteractiveBall and InteractivePaddle for collision detection
 */
public abstract class InteractiveComponentController {
	protected InteractiveComponent srcComp;
	protected InteractiveComponent dstComp;
	
	/*
	 * Connect two components so that they can interact with each other
	 */
	public InteractiveComponentController (InteractiveComponent srcComp, InteractiveComponent dstComp) {
		if (srcComp == null) { System.out.println("Source component does not exist"); return; }
		else this.srcComp = srcComp;
		if (dstComp == null) { System.out.println("Destination component does not exist"); return; }
		else this.dstComp = dstComp;
	}

	/* 
	 * Check for collision from src with dst and do something to handle it
	 */
	public void checkCollision() {
		AbstractView[] srcViews = srcComp.getViews();
		AbstractView[] dstViews = dstComp.getViews();		
		for (AbstractView vS : srcViews) {
			for (AbstractView vD : dstViews) {
				try {
					vS.getSubject().detectCollision(vD.getSubject());
				} catch (Exception e) {
					System.out.println("Problem with collision detection: " + e.getMessage());
				}
			}
		}
	}
}
