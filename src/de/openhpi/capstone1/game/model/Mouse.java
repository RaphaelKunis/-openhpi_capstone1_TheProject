package de.openhpi.capstone1.game.model;

public class Mouse {
	
	private int curPosX;
	private int lastPosX;
	
	public Mouse () {
		curPosX = 0;
		lastPosX = 0;
	}

	public void setCurPosX(int curPosX) {
		this.curPosX = curPosX;
	}

	/* get last Move and set lastPosX to curPosX */
	public MouseMove getMove() {
		MouseMove m;
		m = (curPosX > lastPosX) ? MouseMove.RIGHT : (curPosX < lastPosX) ? MouseMove.LEFT : MouseMove.NONE; 
		lastPosX = curPosX;	
		return m;
	}
}