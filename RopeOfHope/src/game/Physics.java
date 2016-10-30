package game;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Physics {

	public Physics() {

	}

	/* 
	 * below is collision detection for the walls and the shape
	 */
	public Boolean isAbleMoveRight(int x1, int y1, int width1, int height1, int speedX, int speedY) {

		Rectangle right1 = new Rectangle(x1 + speedX / 5, y1, width1, height1);

		for (int i = 0; i < Level.walls.length; i++) {
			if (right1.intersects(Level.walls[i])) {
				return false;
			}
		}
		return true;
	}

	public Boolean isAbleMoveDown(int x1, int y1, int width1, int height1, int speedX, int speedY) {

		Rectangle down1 = new Rectangle(x1, y1 + speedY / 5, width1, height1);

		for (int i = 0; i < Level.walls.length; i++) {
			if (down1.intersects(Level.walls[i])) {
				return false;
			}
			
		}
		return true;
	}
	
	/* 
	 * below is collision detection for the sound because the one above was sub-par for it
	 */
	
	public Boolean isTheLandingSoundValid(int x1, int y1, int width1, int height1, int speedX, int speedY) {

		Rectangle down1 = new Rectangle(x1, y1 + 20 + speedY / 5, width1, height1);

		for (int i = 0; i < Level.walls.length; i++) {
			if (down1.intersects(Level.walls[i])) {
				return false;
			}
		}
		return true;
	}
	
	/* 
	 * below is collision detection for the exit, because we kinda need that.
	 */
	
	public static boolean isTouchingExit(int x, int y, int width, int height){
		Rectangle shape = new Rectangle(x, y, width, height);
		//gets the level parameter to put into the get exit methods to get the exit's x and y
		Rectangle exit = new Rectangle(MainMenu.getExitx(MainMenu.getLevel()), MainMenu.getExity(MainMenu.getLevel()), 50, 50);
		
		if (shape.intersects(exit)){
			MainMenu.exitx[MainMenu.getLevel() - 1] = 9000;
			return true;
		}
		else {
			return false;
		}	
	}    
}



