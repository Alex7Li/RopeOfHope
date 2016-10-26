package game;

public class Player {
	private int charx = 300;
	private int chary = 300;
	private double charVy = 0;
	private double charVx = 0;
	private final int TOPSPEED = 5;
	private final int CHARSIZE= 30;
	private final int SPEED = 50;
	private final int JUMP_POWER = 90;
	private final double FRICTION_RATE = .8;
	private final double ROPE_PULL = .2;
	private final int ROPE_LENGTH = 100; //pixels

	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	public void moveRight(){
		if (charVx < TOPSPEED){
			charVx += SPEED;
		}
	}
	public void moveLeft(){	

		if (charVx > -TOPSPEED){
			charVx -= SPEED;
		}
	}
	public void ropePull(double force, double angle){	
		charVx -= Math.max(0,force*Math.cos(angle)*ROPE_PULL-ROPE_PULL*ROPE_LENGTH);
		charVy -= Math.max(0,force*Math.sin(angle)*ROPE_PULL-ROPE_PULL*ROPE_LENGTH);
	}
	public void jump(){
		//needs a better method to test if its touching the ground
			charVy -= JUMP_POWER;
	}
	public void timePassed(){
		//this allows for move smooth movements
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
		
		if (chary > 600){
			chary=600;
			charVy = 0;
		}
		
		else if (chary <= 600){
			//floor
			//should work when touching any surface
			charVy+= 3;
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
	
	
}