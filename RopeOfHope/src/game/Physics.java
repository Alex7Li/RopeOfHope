package game;

import java.awt.Rectangle;

public class Physics {
	
public Physics(){
		
	}

	public Boolean isAbleMoveRight(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
		return false;
	}
	public Boolean isAbleMoveRight(int x1, int y1, int width1, int height1, int speed1,int x2, int y2, int width2, int height2, int speed2){
		// takes where the other rec will be and where this one will be to determine if they can move.
		Rectangle right1 = new Rectangle(x1 + width1 + speed1, y1,1,height1 );
		Rectangle right2 = new Rectangle(x2 + speed2, y2, width2, height2);
		
		for (int i = 0; i <= Level1.walls.length; i++){
		    if (right1.intersects(Level1.walls[i])){
			    return false;
		    }
		    else if (right1.intersects(right2)){
		    	return false;
		    }
		}
		return true;
	}
	
    public Boolean isAbleMoveLeft(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
    	return true;
	}
    
    public Boolean isAbleMoveUp(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
    	return true;
    }
    
    public Boolean isAbleMoveDown(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
    	return true;
    }
}