package game;

public class Player {
	private int charx = 300;
	private int chary = 300;
	private int charVy = 0;
	private int charVx = 0;
	private final int CHARSIZE= 30;
	private final int SPEED = 5;
	private final int JUMP_POWER = 20;

	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	public void moveRight(){
		if (charVx < 20){
			charVx += SPEED;
		}
	}
	public void moveLeft(){	
		if (charVx > -20){
			charVx -= SPEED;
		}
	}
	public void jump(){
		if (charVy == 0){
			charVy -= JUMP_POWER;
		}
	}
	public void timePassed(){
		charx += charVx;
		chary += charVy;

		if (charx > 650 || charx < 0){
			//walls
			charVx = 0;
		}
		
		if (chary < 600 && charVy<20){
			//floor
			charVy++;
		}
		
		else if (chary > 600){
			charVy=0;
		}

	}
	public int getx(){
		return charx;
	}
	public int gety(){
		return chary;
	}
	public int getSize(){
		return CHARSIZE;
	}
}
