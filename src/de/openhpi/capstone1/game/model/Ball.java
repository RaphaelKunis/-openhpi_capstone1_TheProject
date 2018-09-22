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

	@Override
	public boolean detectCollision() throws Exception {
		int collision = 0;	// 0 bei nicht, 1 bei linker Rand, 2  bei Top, 3 bei rechter Rand, 4 bei unten raus)
		if (posX <= (width+1)/2)  collision = 1;						// outside LEFT
		if (posY <= (height+1)/2) collision = 2;						// outside TOP	
		if (posX >= Defaults.DIM_WIDTH-(width+1)/2)  collision = 3;		// outside RIGHT
		if (posY >= Defaults.DIM_HEIGHT-(height+1)/2) collision = 4;	// outside BOTTOM
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
	
	@Override
	public boolean detectCollision(AbstractSubject other) throws Exception {
		if (other.getClass().getName() == Paddle.class.getName()) {
			Paddle p = (Paddle) other;
			// System.out.println(this.toString());
			// System.out.println(p.toString());
			// check whether ball hits the paddle can only 
			// @TODO: create a universal method to detect collision from Abstractsubject with abstractsubject
			// ball should hit paddle only from above -> dir must be SOUTHxxx
			if ((posY + (height+1)/2 == p.posY)	// check Bottom)
				&& (posX >= p.posX) 			// check left 
				&& (posX <= p.posX+p.width))	// check right		
				{	
				// System.out.println("================= COLLISION =================");
				switch (dir) {
					case SOUTHWEST: dir = Direction.NORTHWEST; break;
					case SOUTHEAST: dir = Direction.NORTHEAST; break;
					case NORTHEAST: break;
					case NORTHWEST: break;
				}
			}
		} else {
			System.out.println("detectCollision(AbstractSubject other): " + other.getClass().getName());
		}
		return false;
	}
}
