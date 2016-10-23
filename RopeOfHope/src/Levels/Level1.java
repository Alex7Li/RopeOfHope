package Levels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Level1 extends JFrame {
	public static int charx = 300;
	public static int chary = 300;
	public static int charsize = 30;
	
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
		setBounds(0, 0, 1000, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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
	
	public void paintComponent (Graphics g){
	//method does nothing since it's not named "paint"
	//can't name it paint because there's another method named paint
		super.paint(g);
	    g.setColor(Color.RED);
		g.fillOval(charx, chary, charsize, charsize);
	}
	public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        switch (k) {
            case KeyEvent.VK_RIGHT:
                charx++;
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                charx--;
                repaint();
                break;
            case KeyEvent.VK_UP:
                chary--;
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                chary++;
                repaint();
                break;
        }
    }
}