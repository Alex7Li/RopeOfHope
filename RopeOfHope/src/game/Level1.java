package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Level1 extends JPanel implements ActionListener, KeyListener{
	private Timer t = new Timer(10, this);
	Player circle = new Player(300,300);
	/**
	 * Launch the application.
	 */
	
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

	public void paint (Graphics g){
		super.paint(g);		
	    g.setColor(Color.BLACK);
		int[] x= {100, 200};
		int[] y= {100, 200};
		int[] width= {100 , 50};
		int[] height= {100, 30};

		Rectangle[] walls = new Rectangle[x.length];
		   for (int i = 0; i < x.length; i++){
			   Rectangle r = new Rectangle(x[i], y[i], width[i], height[i]);
			   walls[i] = r;
			   //array with rectangles in it
			   g.fillRect(x[i], y[i], width[i], height[i]);		   
		   }
	}

	//create a game loop

	public void paintComponent (Graphics g){
		super.paintComponent(g);
	    g.setColor(Color.RED);
		g.fillOval(Player.charx, Player.chary, Player.charsize, Player.charsize);
	}


	public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        switch (k) {
            case KeyEvent.VK_RIGHT:
                moveRight();;
                break;
            case KeyEvent.VK_LEFT:
                moveLeft;
                break;
            case KeyEvent.VK_UP:
                jump();
                break;
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player.charx += Player.charVx;
		Player.chary += Player.charVy;
		repaint();
		
	}
}