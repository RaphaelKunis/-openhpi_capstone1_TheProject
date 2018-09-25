package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.starter.Defaults;

public abstract class AbstractSubject {
	
	protected int posX   	= 0;
	protected int posY   	= 0;
	protected int width  	= 0;
	protected int height 	= 0;
	protected int move_step =  Defaults.MOV_STEP;
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void moveRight() {
		posX = (posX >= Defaults.DIM_WIDTH - width/2 + move_step) ? Defaults.DIM_WIDTH - width/2 : this.posX + move_step;	// nicht rechts raus
	}

	public void moveLeft() {
		posX = (posX <= width/2 - move_step) ? width/2 : this.posX - move_step;	// nicht links raus
	}	
	
	public void moveUp() {
		posY = (posY <= height/2 - move_step) ? height/2 : this.posY - move_step;	// nicht oben raus
	}

	public void moveDown() {
		posY = (posY >= Defaults.DIM_HEIGHT - height/2 + move_step) ? Defaults.DIM_HEIGHT - height/2 : this.posY + move_step;	// nicht unten raus
	}	
	
	/*
	 * Only relevant for moving objects
	 * Detect collision with edges of PApplet. 
	 * Returns true if object leaves field.	
	 */
	public abstract boolean detectCollision() throws Exception;
	
	/*
	 * Only relevant for moving objects
	 * Detect collision with other AbstractSubject. 
	 * Returns true if object leaves field.	
	 */
	public abstract boolean detectCollision(AbstractSubject other) throws Exception;
	
	public String toString () {
		return this.getClass().getSimpleName() + ": X= " + posX + ", Y= " + posY + ", W= " + width + "H= " + height + ";";
	}
}
