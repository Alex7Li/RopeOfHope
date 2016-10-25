package game;

public class Player {
	private static int charx = 300;
	private static int chary = 300;
	private static int charVy = 0;
	private static int charVx = 0;
	public static final int CHARSIZE= 30;
	public static final int SPEED = 5;
	public static final int JUMP_POWER = 30;

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
			charVy -= JUMP_POWER;
	}
	public void timePassed(){
		chary += charVy;
		charx += charVx;
	}


}
