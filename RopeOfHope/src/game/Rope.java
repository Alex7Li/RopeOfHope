package game;

public class Rope {
	private double length;
	private static double angle;
	
	public Rope()
    {
    }
	public void timePassed(Player one, Player two){
		one.ropePull(length,angle);
		two.ropePull(length,(angle+Math.PI));
	}
	public void setLength(double l){
		length = l;
	}
	public void setAngle(double a){
		angle = a;
	}
}
