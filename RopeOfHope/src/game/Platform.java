package game;

public class Platform {
	private int x = 300;
	private int y = 300;
	private int width = 300;
	private int height = 300;
	public Platform(int x, int y, int width, int height)
    {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
    }
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
