package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Level extends JPanel implements ActionListener, KeyListener {
	
	private Timer t; 
    // put level 6 right after level 3
	Rope rope = new Rope();
	Physics physics = new Physics();
	static int level = MainMenu.getLevel();
	static int circlex[] = { 0, 0, 100, 50,  300, 450, 200, }; // 
	static int circley[] = { 100, 100, 100, 50,  400, 400, 300,  }; //
	static int squarex[] = { 100, 100, 200, 0,  250, 500, 300,  }; //
	static int squarey[] = { 100, 100, 100, 50,  400, 400, 300,   }; //
	static int exitx[] = { 700, 750, 50, 800,  100, 500, 800,  }; //
	static int exity[] = { 200, 450, 305, 200,  10, 50, 500,  };//


	static Player circle = new Player(circlex[level-1], circley[level-1]);
	static Player square = new Player(squarex[level-1], squarey[level-1]);
	static Exit exit = new Exit(exitx[level-1], exity[level-1]);

	static int[] wallNums = { 4, 2, 3, 2, 5, 2, 9 };
	// wallNums = number of walls in level corresponding to array position.
	public static Rectangle[] walls = new Rectangle[6];
	//change to maximum value of wallNums.
	static int[][] xarrs = { 
			{ 0, 200, 300,  400}, 
			{ 0, 350 },
			{ 0, 350, -50},
			{ 0, 700},
			{ 50, 100, 50, 50, 50},
			{ 450, 450},
			{ 50, 100, 50, 100, 650, 650, 50, 50, 50},
			//
			};
	// each 1-D array level is a level's x-block positions.

	static int[][] yarrs = { 
			{ 350, 250, 150, 250 }, 
			{ 250, 150 },
			{ 250, 150, 0},
			{ 350, 350}, 
			{ 450, 100, 350, 250, 150},
			{ 200, 500},
			{ 450, 100, 250, 100, 100, 450, 350, 250, 150},

			 //
			};

	static int[][] widtharrs = { 
			{ 900, 50, 50, 50 },
			{ 400, 50 }, 
			{ 400, 50, 50 }, 
			{ 100, 200 },
			{ 350, 50, 150, 50, 50 },
			{ 100, 100},
			{ 350, 50, 50, 600, 50, 250, 150, 50, 50} ,

			//
			};


	static int[][] heightarrs = { 
			{ 50, 100, 200, 100 },
			{ 50, 100},
			{ 50, 100, 300},
			{ 50, 50},
			{ 20, 400, 20, 20, 20},
			{ 50, 50},
			{ 30, 400, 30, 50, 400, 50, 30, 30, 30},

			//
			};

	
	public Level() {
		Level.circle.setCharx(Level.circlex[level - 1]);
		Level.circle.setChary(Level.circley[level - 1]);
		Level.square.setCharx(Level.squarex[level - 1]);
		Level.square.setChary(Level.squarey[level - 1]);
		Level.circle.setCharVx(0);
		Level.circle.setCharVy(0);
		Level.square.setCharVx(0);
		Level.square.setCharVy(0);
		if (!MainMenu.isHasTimerGenerated()){
			t = new Timer(30, this);
			MainMenu.setHasTimerGenerated(true);
		}

		addKeyListener(this);
		
		
		level = MainMenu.getLevel();
		walls = new Rectangle[wallNums[level - 1]];
		setFocusable(true);
	
		setBackground(Color.WHITE);

		// creates arrays that hold the rectangles from the main class array.
		// I couldn't find a better way to do this because of the way arrays are
		// declared.
		int[] x = new int[wallNums[level - 1]];
		for (int i = 0; i < x.length; i++) {
			x[i] = xarrs[level - 1][i];
		}
		int[] y = new int[wallNums[level - 1]];
		for (int i = 0; i < y.length; i++) {
			y[i] = yarrs[level - 1][i];
		}
		int[] width = new int[wallNums[level - 1]];
		for (int i = 0; i < width.length; i++) {
			width[i] = widtharrs[level - 1][i];
		}

		int[] height = new int[wallNums[level - 1]];
		for (int i = 0; i < height.length; i++) {
			height[i] = heightarrs[level - 1][i];
		}
		for (int i = 0; i < x.length; i++) {
			Rectangle r = new Rectangle(x[i], y[i], width[i], height[i]);
			walls[i] = r;
		}
		for (int i = x.length; i < walls.length; i++) {
			walls[i] = null;
		}
//instructions

		setLayout(null);
		if (!MainMenu.isHasTimerStarted()){
		    t.start();
		    MainMenu.setHasTimerStarted(true);
		}

		setVisible(true);
		repaint();
		
	}

	public static void nextLevel() {
		// closes this level and starts the next one
		circle.setCharx(circlex[level-1]);
		circle.setChary(circley[level-1]);
		square.setCharx(squarex[level-1]);
		square.setChary(squarey[level-1]);
		circle.setCharVx(0);
		circle.setCharVy(0);
		square.setCharVx(0);
		square.setCharVy(0);
		MainMenu.incrementLevel();
		MainMenu.startGame();
	}

	public void paint(Graphics g) {
		// paints the initial elements
		super.paint(g);

		g.setColor(Color.BLACK);

		for (int i = 0; i < xarrs[level - 1].length; i++) {
			g.fillRect(xarrs[level - 1][i], yarrs[level - 1][i], widtharrs[level - 1][i], heightarrs[level - 1][i]);
		}
		g.setColor(Color.PINK);

		g.fillRect(exitx[level-1], exity[level-1], 50, 50);

		// draws background

	}

	public void paintComponent(Graphics g) {
		// elements that are repainted each frame
		super.paintComponent(g);
		// characters
		g.drawImage(Background.getImage(level), 0, 0, null);
		g.setColor(Color.BLUE);
		g.fillRect(square.getx(), square.gety(), square.getSize(), square.getSize());
		g.setColor(Color.RED);
		g.fillOval(circle.getx(), circle.gety(), circle.getSize(), circle.getSize());
		g.setColor(Color.BLACK);
		// rope
		g.drawLine(circle.getx() + square.getSize() / 2, circle.gety() + square.getSize() / 2,
				square.getx() + square.getSize() / 2, square.gety() + square.getSize() / 2);
		// just variables for the rope class
		double length = Math.hypot(circle.getx() - square.getx(), circle.gety() - square.gety());
		double angle = Math.atan2(circle.gety() - square.gety(), circle.getx() - square.getx());

		rope.setLength(length);
		rope.setAngle(angle);
		if (level == 1){
			g.drawString("Arrow Keys to move the circle, WASD to move the square. \nPress R to restart if you get stuck.", 20, 20);
		}
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();

		switch (k) {
		case KeyEvent.VK_RIGHT:
			circle.setRightKeyPressed(true);
			break;
		case KeyEvent.VK_LEFT:
			circle.setLeftKeyPressed(true);
			break;
		case KeyEvent.VK_UP:
			circle.jump();
			break;
		case KeyEvent.VK_DOWN:
			circle.setDownKeyPressed(true);
			break;
			//TAKE THIS OUT IN FINAL VERSION
		case KeyEvent.VK_0:
			nextLevel();
			break;
		case KeyEvent.VK_R:
			level = MainMenu.getLevel();
			MainMenu.restartLevel(level);
			break;			
		case KeyEvent.VK_M:
			this.invalidate();
			this.setVisible(false);
			MainMenu.setLevel(1);
			new MainMenu().setVisible(true);
			break;

		}

		switch (k) {
		case KeyEvent.VK_D:
			square.setRightKeyPressed(true);
			break;
		case KeyEvent.VK_A:
			square.setLeftKeyPressed(true);
			break;
		case KeyEvent.VK_W:
			square.jump();
			break;
		case KeyEvent.VK_S:
			square.setDownKeyPressed(true);
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();

		switch (k) {
		case KeyEvent.VK_RIGHT:
			circle.setRightKeyPressed(false);
			break;
		case KeyEvent.VK_LEFT:
			circle.setLeftKeyPressed(false);
			break;
		case KeyEvent.VK_UP:
			circle.jump();
			break;
		case KeyEvent.VK_DOWN:
			circle.setDownKeyPressed(false);
			break;
		}
		switch (k) {
		case KeyEvent.VK_D:
			square.setRightKeyPressed(false);
			break;
		case KeyEvent.VK_A:
			square.setLeftKeyPressed(false);
			break;
		case KeyEvent.VK_S:
			square.setDownKeyPressed(false);
			break;
		}
		
	}

	public void actionPerformed(ActionEvent e) {

		rope.timePassed(circle, square);
		circle.timePassed();
		square.timePassed();
		repaint();
	}
	public static void setLevel(int i) {
		level = i;
	}
	
	public static int getExitx(int i) {
		return exitx[i];
	}

	public static int getExity(int i) {
		return exity[i];
	}
}