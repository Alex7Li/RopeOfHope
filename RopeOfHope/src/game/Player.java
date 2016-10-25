package game;

public class Player {
	public static int charx = 300;
	public static int chary = 300;
	public static int charVy = 0;
	public static int charVx = 0;
	public static final int charsize= 30;
	public static final int SPEED = 2;
	
	public Player(int x, int y)
    {
		
    }
	public void moveright(){
		
		if (charVy < 20){
			charVy += SPEED;
		}
		charVx-=1;
	}
	public void moveleft(){	
	
		if (charVy > 10){
			charVy -= SPEED;
		}
		charVx-=1;

	}
	public void jump(){
			charVy += 40;
	}


}
