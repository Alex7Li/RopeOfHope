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

	public static void main(String[] args) {
		Level1 AlexCantCode = new Level1();
		JFrame frame = new JFrame("Rope of Hope");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.add(AlexCantCode);
		frame.setVisible(true);
		frame.repaint();

	}

	/**
	 * Create the frame.
	 */
	public Level1() {
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.WHITE);
		setLayout(null);
		t.start();
		setVisible(true);
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		int[] x = { 100, 200, 123 };
		int[] y = { 100, 200, 500 };
		int[] width = { 100, 50, 32 };
		int[] height = { 100, 30, 10 };

		Rectangle[] walls = new Rectangle[x.length];
		for (int i = 0; i < x.length; i++) {
			Rectangle r = new Rectangle(x[i], y[i], width[i], height[i]);
			walls[i] = r;
			// array with rectangles in it
			g.fillRect(x[i], y[i], width[i], height[i]);
		}
		// add wall physics (Just do level 1 for now)
		// do this in the actionPerformed Method, at the bottom
		// also add a exit rectangle (Just like a blue rectangle)
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
	//doesn't work very well because it only cares about when the key is pressed
	/*Listen for two separate events, one where the key is pressed down,
	 * the other where it is released.
	 * Pressing the key should set a flag, releasing it clear said flag. 
	 * Then you can check the value of the flag instead of
	 * continually trying to pester the keyboard.
	 * When you're looking at more than just one key, 
	 * you'd want to store all of the currently pressed KeyStrokes in a map.
	 */

		if (k == KeyEvent.VK_RIGHT) {
			circle.moveRight();
		}
		if (k == KeyEvent.VK_LEFT) {
			circle.moveLeft();
		}
		if (k == KeyEvent.VK_UP) {
			circle.jump();
		}
		if (k == KeyEvent.VK_D) {
			square.moveRight();
		}
		if (k == KeyEvent.VK_A) {
			square.moveLeft();
		}
		if (k == KeyEvent.VK_W) {
			square.jump();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		rope.timePassed(circle, square);
		circle.timePassed();
		square.timePassed();
		repaint();
	}


}