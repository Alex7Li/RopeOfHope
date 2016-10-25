package game;

import java.awt.event.ActionEvent;

public class Player {
	public static int charx = 300;
	public static int chary = 300;
	public static int charVy = 0;
	public static int charVx = 0;
	public static final int CHARSIZE= 30;
	public static final int ACCELERATION = 2;
	private static final int SPEEDLIMIT = 5;
	
	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	public void moveRight(){
		
		if (charVx < SPEEDLIMIT){
			charVx += ACCELERATION;
		}
		charVx+=1;
	}
	public void moveLeft(){	
	
		if (charVx < SPEEDLIMIT){
			charVx -= ACCELERATION;
		}
		charVx-=1;

	}
	public void jump(){
			charVy += 7;
	}

	

}
