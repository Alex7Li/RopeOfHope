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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		createLevel(4);
	}
	public void createLevel (int n) {  
		//n is blocks that are being made
	   Rectangle[] walls = new Rectangle[n];
	   for (int i = 0; i < walls.length; i++) {
		
	}

	public void createRectangle (Graphics g,int x,int y,int width,int height) {  
	    Rectangle r = new Rectangle(x,y,width,height);
	    g.fillRect(x, y, width, height);;  
	    g.setColor(Color.BLACK);
	}
}
