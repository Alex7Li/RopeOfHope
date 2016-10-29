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
	
	private Timer t = new Timer(30, this);
	Rope rope = new Rope();
    Physics physics = new Physics();
    static int level = 1;   
	Player circle = new Player(MainMenu.getCirclex(level), MainMenu.getCircley(level));
	Player square = new Player(MainMenu.getSquarex(level), MainMenu.getSquarey(level));
	
	static int[] wallNums = {6,6};
	//wallNums = number of walls in level corresponding to array position.
	
	static int[][] xarrs = {
		{ 0,   850, 0, 150, 40, 253},
		{ 0,   850, 0, 100, 300, 123}
	};
	//each 1-D array level is a level's x-block positions.
	static int[][] yarrs = {     
		{ 0,   0,   550, 280, 150, 500},
		{ 0,   0,   550, 100, 200, 20}
	};
	
	static int[][] widtharrs = {
		{ 40,  50,  700, 100, 50 , 32},
		{ 40,  50,  700, 70, 10 , 32}
	};
	
	static int[][] heightarrs = {
		{ 700, 700, 40, 100, 30 , 10},
		{ 700, 700, 40, 340, 30 , 330}
	};

	public static Rectangle[]  walls = new Rectangle[wallNums[level-1]];
	
	public Level() {
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.WHITE);	
	    level = MainMenu.getLevel();    
		int[] x = new int[wallNums[level-1]];
		for (int i=0; i<x.length; i++) {
	           x[i]=xarrs[level-1][i];
		}
		int[] y = new int[wallNums[level-1]];   
		for (int i=0; i<y.length; i++) {
	           y[i]=yarrs[level-1][i];
		}
		int[] width =  new int[wallNums[level-1]];   
		for (int i=0; i<width.length; i++) {
	           width[i]=widtharrs[level-1][i];
		}

		int[] height = new int[wallNums[level-1]];   
		for (int i=0; i<height.length; i++) {
	           height[i]=heightarrs[level-1][i];
		}
		for (int i = 0; i < x.length; i++) {
			Rectangle r = new Rectangle(x[i], y[i], width[i], height[i]);
			walls[i] = r;
		}		
		setLayout(null);
		t.start();
		setVisible(true);
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < xarrs[level-1].length; i++) {
			g.fillRect(xarrs[level-1][i], yarrs[level-1][i], widtharrs[level-1][i], heightarrs[level-1][i]);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(square.getx(), square.gety(), square.getSize(), square.getSize());
		g.setColor(Color.RED);
		g.fillOval(circle.getx(), circle.gety(), circle.getSize(), circle.getSize());
		g.setColor(Color.BLACK);
		
		g.drawLine(circle.getx() + square.getSize() / 2, circle.gety() + square.getSize() / 2,
		square.getx() + square.getSize() / 2, square.gety() + square.getSize() / 2);
		
		double length = Math.hypot(circle.getx()-square.getx(), circle.gety()-square.gety());
		double angle = Math.atan2(circle.gety()-square.gety(), circle.getx()-square.getx());
		
		rope.setLength(length);
		rope.setAngle(angle);
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();

		switch(k){
		case KeyEvent.VK_RIGHT:
			circle.setRightKeyPressed(true); break;
		case KeyEvent.VK_LEFT:
			circle.setLeftKeyPressed(true); break;
		case KeyEvent.VK_UP:
			circle.jump(); break;
		case KeyEvent.VK_DOWN:
			circle.setDownKeyPressed(true); break;
		case KeyEvent.VK_0:
			MainMenu.incrementLevel(); break;
		}
		switch(k){
		case KeyEvent.VK_D:
			square.setRightKeyPressed(true); break;
		case KeyEvent.VK_A:
			square.setLeftKeyPressed(true); break;
		case KeyEvent.VK_W:
			square.jump(); break;
		case KeyEvent.VK_S:
			square.setDownKeyPressed(true); break;
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();

		switch(k){
		case KeyEvent.VK_RIGHT:
			circle.setRightKeyPressed(false); break;
		case KeyEvent.VK_LEFT:
			circle.setLeftKeyPressed(false); break;
		case KeyEvent.VK_UP:
			circle.jump(); break;
		case KeyEvent.VK_DOWN:
			circle.setDownKeyPressed(false); break;
		}
		switch(k){
			case KeyEvent.VK_D:
				square.setRightKeyPressed(false); break;
			case KeyEvent.VK_A:
				square.setLeftKeyPressed(false); break;
			case KeyEvent.VK_S:
				square.setDownKeyPressed(false); break;
		}

		
	}

	public void actionPerformed(ActionEvent e) {
		
		rope.timePassed(circle, square);
		circle.timePassed();
		square.timePassed();
		repaint();
	}

}