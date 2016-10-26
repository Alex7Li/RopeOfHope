package game;

public class Player {
	private int charx = 300;
	private int chary = 300;
	private double charVy = 0;
	private double charVx = 0;
	private boolean rightKeyPressed;
	private boolean leftKeyPressed;
	private final int TOPSPEED = 5;
	private final int CHARSIZE= 30;
	private final int SPEED = 50;
	private final int JUMP_POWER = 90;
	private final double FRICTION_RATE = 1.5;
	private final double ROPE_PULL = .2;
	//private final int ROPE_LENGTH = 100; //pixels

	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	
	public void ropePull(double force, double angle){	
		charVx -= force*Math.cos(angle)*ROPE_PULL;
		charVy -= force*Math.sin(angle)*ROPE_PULL;
	}
	
	public void jump(){
		//needs a better method to test if its touching the ground
			charVy -= JUMP_POWER;
	}
	
	public void timePassed(){
		//this allows for move smooth movements
		
		//make a rectangle r that is about 4 pixels to the right of the middle of the shape... if it .intersectsWith a wall then dont move right
		if (rightKeyPressed && charVx < TOPSPEED){
			charVx += SPEED;
		}
		if (leftKeyPressed && charVx > -TOPSPEED){
			charVx -= SPEED;
		}
		charx += (int)charVx/5;
		chary += (int)charVy/5;

		if (charx < 20){
			//right wall
			charx = 20;
			charVx = 0;
		}
		if (charx > 650){
			//left wall
			charx = 650;
			charVx = 0;
		}
		// if thing is going left, get slowed down by friction
		else if (charVx < 0){
			charVx += FRICTION_RATE;
		}
		// if thing is going right, get slowed down by friction
		else if (charVx > 0){
			charVx -= FRICTION_RATE;
		}		
		if (chary < 600 && charVy<150){
			//floor
			charVy += 3;
		}
		if (chary > 600){
			chary=600;
			charVy = 0;
		}
		
		else if (chary <= 600){
			//floor
			//should work when touching any surface
			charVy+= 3;
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
	public void setCharx(int charx) {
		this.charx = charx;
	}
	public void setChary(int chary) {
		this.chary = chary;
	}
	public void setCharVy(double charVy) {
		this.charVy = charVy;
	}
	public void setCharVx(double charVx) {
		this.charVx = charVx;
	}

	public void setRightKeyPressed(boolean rightKeyPressed) {
		this.rightKeyPressed = rightKeyPressed;
	}

	public void setLeftKeyPressed(boolean leftKeyPressed) {
		this.leftKeyPressed = leftKeyPressed;
	}
	
	
}