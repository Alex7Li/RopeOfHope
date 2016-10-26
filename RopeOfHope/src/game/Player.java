package game;

public class Player {
	private int charx = 300;
	private int chary = 300;
	private double charVy = 0;
	private double charVx = 0;
	private final int TOPSPEED = 5;
	private final int CHARSIZE= 30;
	private final int SPEED = 50;
	private final int JUMP_POWER = 100;
	private final double FRICTIONRATE = .1;

	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	
	public void accelerateRight(){
		if (charVx < TOPSPEED){
			charVx += SPEED;
		}
	}
	
	public void accelerateLeft(){	

		if (charVx > -TOPSPEED){
			charVx -= SPEED;
		}
	}
	public void ropePull(double force, double angle){	
		charVx -= force*force*Math.cos(angle)/2500;
		charVy -= force*force*Math.sin(angle)/2500;
		// damn son
	}
	
	public void jump(){
		if (charVy == 0){
			charVy -= JUMP_POWER;
		}
	}
	
	public void timePassed(){
		//this allows for move smooth movements
		
		//make a rectangle r that is about 4 pixels to the right of the middle of the shape... if it .intersectsWith a wall then dont move right
		charx += (int)charVx/5;
		chary += (int)charVy/5;

		// if thing is going right, get slowed down by friction
		if (charVx > 0){
			charVx -= FRICTIONRATE;
		}
		
		// if thing is going left, get slowed down by friction
		if (charVx < 0){
			charVx += FRICTIONRATE;
		}
			
		if (charx > 650 || charx < 0){
			//sidewalls
			charVx = 0;
		}
		
		if (chary < 600 && charVy<150){
			//floor
			charVy += 3;
		}
		
		else if (chary > 600){
			charVy = 0;
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