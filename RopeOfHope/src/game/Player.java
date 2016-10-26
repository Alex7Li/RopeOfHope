package game;

public class Player {
	private int charx = 300;
	private int chary = 300;
	private int charVy = 0;
	private int charVx = 0;
	private final int CHARSIZE= 30;
	private final int SPEED = 50;
	private final int JUMP_POWER = 100;

	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	public void moveRight(){
		if (charVx < 100){
			charVx += SPEED;
		}
	}
	public void moveLeft(){	
		if (charVx > -100){
			charVx -= SPEED;
		}
	}
	public void ropePull(double force, double angle){	
		charVx -= force*force*Math.cos(angle)/2500;
		charVy -= force*force*Math.sin(angle)/2500;
	}
	public void jump(){
		if (charVy == 0){
			charVy -= JUMP_POWER;
		}
	}
	public void timePassed(){
		charx += (int)charVx/5;
		chary += (int)charVy/5;

		if (charx > 650 || charx < 0){
			//walls
			charVx = 0;
		}
		
		if (chary < 600 && charVy<150){
			//floor
			charVy+= 3;
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
