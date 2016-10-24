package Levels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Level1 extends JFrame {

	Rectangle r = new Rectangle(100,100,10,10);
	
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=70,121
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1 frame = new Level1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Level1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
//<<<<<<< HEAD
	public void paint (Graphics g) {    
		
		super.paint(g);
		g.setColor(Color.BLUE);
		//g.fillRect(100, 100, 200, 250);
		
	    g.fillRect( (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());  
	}
}
