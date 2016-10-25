package game;

public class Player {
	public static int charx = 300;
	public static int chary = 300;
	public static int charVy = 0;
	public static int charVx = 0;
	public static final int CHARSIZE= 30;
	public static final int SPEED = 2;
	public static final int JUMP_POWER = 20;
	
	public Player(int x, int y)
    {
		charx = x;
		chary = y;
    }
	public void moveright(){
		
		if (charVy < 20){
			charVy += SPEED;
		}
		charVx-=1;
	}
	public void moveleft(){	
	
		if (charVy > 20){
			charVy -= SPEED;
		}
		charVx-=1;

	}
	public void jump(){
			charVy += JUMP_POWER;
	}


}
