package game;

public class Physics {
	
	
	public Physics(){
		
	}
	//even if you use ints it still won't work well because you can go deep enough into thin walls within one frame, 
	//the player could get stuck in the middle of a wall with the collisions all saying "not touching anything" because the
	//edges aren't but the center is
	//much better to treat it as one object
	public Boolean isAbleMoveRight(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
		
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
    
  