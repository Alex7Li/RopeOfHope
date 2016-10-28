package game;

public class Player extends Physics{
	
	public int maxJumps = 1;
	
	private boolean isLandSoundValid = true;
	private int currentJumps; 
	private int charx = 300;
	private int chary = 300;
	private double charVy = 0;
	private double charVx = 0;
	private boolean rightKeyPressed;
	private boolean leftKeyPressed;
	private double frictionRate = 3;
	private final int TOPSPEED = 100;
	private final int GRAVITY = 4;
	private final int CHARSIZE= 30;
	private final int SPEED = 4;
	private final int JUMP_POWER = 90;
	private final double ROPE_PULL = .1;
	private final int ROPE_LENGTH = 100; //pixels

	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	
	public void ropePull(double force, double angle){	
		if(Math.PI > angle && angle>0){
			charVy -= Math.max(0,(force-ROPE_LENGTH)*Math.sin(angle)*ROPE_PULL);
		}
		else{
			charVy += Math.max(0,(-force+ROPE_LENGTH)*Math.sin(angle)*ROPE_PULL);
		}
		if ((angle > - Math.PI/2 && angle < Math.PI/2) || angle > 3*Math.PI/2){
			charVx -= Math.max(0,(force-ROPE_LENGTH)*Math.cos(angle)*ROPE_PULL);
		}
		else{
			charVx += Math.max(0,(-force+ROPE_LENGTH)*Math.cos(angle)*ROPE_PULL);
		}
	}
	
	public void jump (){
		if (currentJumps < maxJumps){
		    charVy -= JUMP_POWER;
		    currentJumps++;
		    Audio.doAudioJunk("jump");
		}
	}
	
	public void timePassed(){
		if (rightKeyPressed && charVx < TOPSPEED){
			charVx += SPEED;
		}
		if (leftKeyPressed && charVx > -TOPSPEED){
			charVx -= SPEED;
		}
		
		//Movement
		if (isAbleMoveRight(charx, chary, CHARSIZE, CHARSIZE,(int)charVx, (int)charVy)){
		    charx += (int)charVx/5;
		}
		else {
			charVx = 0; 
		}
		
		if (isAbleMoveDown(charx, chary, CHARSIZE, CHARSIZE,(int)charVx, (int)charVy)){
		    chary += (int)charVy/5;
		    if (isTheLandingSoundValid(charx, chary, CHARSIZE, CHARSIZE,(int)charVx, (int)charVy)){
		    	isLandSoundValid = true;
		    }
		}
		else {
			charVy = 0;
		}
		    
		
		//increase Friction if on the ground
		if(!isAbleMoveDown(charx, chary, CHARSIZE, CHARSIZE,(int)charVx, (int)charVy)){
			frictionRate = 5;
		}
		else{
			frictionRate = 1;
		}
		
		// if thing is going left, get slowed down by friction
		if (charVx < 0){
			charVx += frictionRate;		
		}
			// if thing is going right, get slowed down by friction
		else if (charVx > 0){
			charVx -= frictionRate;
		}		
		
		if (charVy < TOPSPEED){
			charVy += GRAVITY;
		}	

		if (!isAbleMoveDown(charx, chary, CHARSIZE, CHARSIZE,(int)charVx, (int)charVy)){
			if (isLandSoundValid){
			    Audio.doAudioJunk("thud");
			    isLandSoundValid = false;
			}
			currentJumps = 0;
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
	
	public double getXSpeed(){	
		return charVx;
	}
	
	public double getYSpeed(){	
		return charVy;
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