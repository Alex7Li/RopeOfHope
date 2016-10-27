package game;

import java.awt.Rectangle;

public class Physics {
	
public Physics(){
		
	}
	
	//shhhh i got this
	public Boolean isAbleMoveRight(int x1, int y1, int width1, int height1, int speedX, int speedY){
		
		Rectangle right1 = new Rectangle(x1 + speedX / 5, y1 ,width1 ,height1 );
		
		for (int i = 0; i < Level1.walls.length; i++){
		    if (right1.intersects(Level1.walls[i])){
			    return false;
		    }
		}
		return true;
	}
	
	
	
    public Boolean isAbleMoveLeft(int x1, int y1, int width1, int height1, int speedX, int speedY){
    	Rectangle left1 = new Rectangle(x1 + speedX / 5, y1 ,width1 ,height1 );
    	
    	for (int i = 0; i < Level1.walls.length; i++){
		    if (left1.intersects(Level1.walls[i])){
			    return false;
		    }
		}
    	return true;
	}
    
    
    
    public Boolean isAbleMoveUp(int x1, int y1, int width1, int height1, int speedX, int speedY){
        Rectangle down1 = new Rectangle(x1, y1 + speedY / 5, width1 ,height1 );
		
		for (int i = 0; i < Level1.walls.length; i++){
		    if (down1.intersects(Level1.walls[i])){
			    return false;
		    }
		}
		return true;
    }
    
    
    
    public Boolean isAbleMoveDown(int x1, int y1, int width1, int height1, int speedX, int speedY){
        
    	Rectangle down1 = new Rectangle(x1, y1 + speedY / 5, width1 ,height1 );
		
		for (int i = 0; i < Level1.walls.length; i++){
		    if (down1.intersects(Level1.walls[i])){
			    return false;
		    }
		}
		return true;
    }
}