package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Level1 extends JPanel implements ActionListener, KeyListener {
	private Timer t = new Timer(30, this);
	Player circle = new Player(300, 300);
	Player square = new Player(200, 300);
	Rope rope = new Rope();
    Physics physics = new Physics();
    
	//this is the array declaration you gotta change
    static int wallNum = 1;
	int[] x = new int[wallNum];
	int[] y = new int[wallNum];
	int[] width = new int[wallNum];
	int[] height = new int[wallNum];
	public static Rectangle[]  walls = new Rectangle[wallNum];
	
	

	public Level1() {
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.WHITE);
		
		int[] x =      { 0,};
		int[] y =      { 250};
		int[] width =  { 900};
		int[] height = { 50};
		//this will break, change the length of the array declaration on top
		this.x = x;
		this.y = y; 
		this.width = width;
		this.height = height;
		
		for (int i = 0; i < x.length; i++) {
			Rectangle r = new Rectangle(x[i], y[i], width[i], height[i]);
			walls[i] = r;
		}
		
		setLayout(null);
		t.start();
		setVisible(true);
		repaint();
		Audio.doAudioJunk("bg1");
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < x.length; i++) {
			g.fillRect(x[i], y[i], width[i], height[i]);
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
		}
		switch(k){
		case KeyEvent.VK_D:
			square.setRightKeyPressed(true); 
			break;
		case KeyEvent.VK_A:
			square.setLeftKeyPressed(true); 
			break;
		case KeyEvent.VK_W:
			square.jump(); 
			break;
		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();

		if (k == KeyEvent.VK_RIGHT) {
			circle.setRightKeyPressed(false);
		}
		if (k == KeyEvent.VK_LEFT) {
			circle.setLeftKeyPressed(false);
		}
		if (k == KeyEvent.VK_D) {
			square.setRightKeyPressed(false);
		}
		if (k == KeyEvent.VK_A) {
			square.setLeftKeyPressed(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		rope.timePassed(circle, square);
		circle.timePassed();
		square.timePassed();
		repaint();
	}
}