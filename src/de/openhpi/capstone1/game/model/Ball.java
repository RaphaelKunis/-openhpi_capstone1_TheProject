package de.openhpi.capstone1.game.model;

import de.openhpi.capstone1.game.starter.Defaults;

public class Ball extends AbstractSubject {

	Direction dir; 
	
	public Ball () {
		this.width 	= 5;
		this.height = 5;
		this.posX = Defaults.DIM_WIDTH/2;
		this.posY = Defaults.DIM_HEIGHT/2;
		this.dir = Direction.NORTHWEST; 
	}

	public Direction getDir() {
		return dir;
	}

	/* 
	 * Prüfe Kollision mit Rand
	 * !!! Kollision mit Paddle ist separat zu prüfen !!!
	 * Gibt true zurück, wenn Ball unten aus dem spielfeld fliegt
	 */
	public boolean detectCollision() throws Exception {
		int collision = 0;	// 0 bei nicht, 1 bei linker Rand, 2  bei Top, 3 bei rechter Rand, 4 bei unten raus)
		if (posX <= (width+1)/2)  collision = 1;
		if (posY <= (height+1)/2) collision = 2;
		if (posX >= Defaults.DIM_WIDTH-(width+1)/2)  collision = 3;
		if (posY >= Defaults.DIM_HEIGHT-(height+1)/2) collision = 4;
		switch (dir) {
			case NORTHEAST: if (collision == 2) { dir = Direction.SOUTHEAST; } 	// Top 
							else if (collision == 3) { dir = Direction.NORTHWEST; } // RIGHT
							else if ((collision == 1) || (collision == 4)) throw new Exception("Error Wrong collision for direction NORTHEAST:" + collision );
						    break;
			case SOUTHEAST: if (collision == 3) { dir = Direction.SOUTHWEST; } 	// RIGHT
							if (collision == 4) return true;			
							else if ((collision == 1) || (collision == 2)) throw new Exception("Error Wrong collision for direction SOUTHEAST:" + collision );			
							break;
			case SOUTHWEST: if (collision == 1) { dir = Direction.SOUTHEAST; } 	// LEFT 
							if (collision == 4) return true;
							else if ((collision == 2) || (collision == 3))  throw new Exception("Error Wrong collision for direction SOUTHWEST:" + collision );
		    				break;			    				
			case NORTHWEST: if (collision == 1) { dir = Direction.NORTHEAST; } 		// LEFT 
							else if (collision == 2) { dir = Direction.SOUTHWEST; } // TOP
							else if ((collision == 3) || (collision == 4)) throw new Exception("Error Wrong collision for direction NORTHWEST:" + collision );
						    break;			
		}
		return false;
	}
}
