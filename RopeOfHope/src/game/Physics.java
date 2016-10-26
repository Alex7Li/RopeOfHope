package game;

import java.awt.Rectangle;

public class Physics {
	
	
	public Physics(){
		
	}
	//shhhh i got this
	public Boolean isAbleMoveRight(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
		
		Rectangle right1 = new Rectangle(x1 + width1 + 3, y1,1,height1 );
		
		if (right1.intersects(Level1))
		
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