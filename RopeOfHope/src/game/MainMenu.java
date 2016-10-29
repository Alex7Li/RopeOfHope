package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	static final int LEVELS = 1;
	static int level = 2; //change this when adding levels
	static int highestLevelReached = 1;
	static int circlex[] = {200,200};
	static int circley[] = {200,200};
	static int squarex[] = {200,200};
	static int squarey[] = {200,200};
	
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnStartGame = new JButton("Start Game");
		contentPane.add(btnStartGame, BorderLayout.SOUTH);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		
		JButton btnLevelSelection = new JButton("Level Selection");
		btnLevelSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLevelSelect();
			}
		});
		contentPane.add(btnLevelSelection, BorderLayout.WEST);
		
		JButton btnCredits = new JButton("Credits");
		contentPane.add(btnCredits, BorderLayout.EAST);
	}
	private static void startGame(){
		JFrame frame = new JFrame("Level 1");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//iterate through a level of the 2-D arrays to get the x, y, width, and height
		//values. This was neccessary because you can't change arrays except by each
		//element which meant I would otherwise have to make level*4 1-D arrays.
		Level level1 = new Level();
		frame.add(level1);
	}
	
	private void openLevelSelect(){
		JFrame frame = new JFrame("Level Selection");
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void incrementLevel(){
		level++;
		if (highestLevelReached<level){
			highestLevelReached=level;
		}
		startGame();
	}
	
	public static int getCirclex(int level) {
		return circlex[level];
	}
	public static int getCircley(int level) {
		return circley[level];
	}
	public static int getSquarex(int level) {
		return squarex[level];
	}
	public static int getSquarey(int level) {
		return squarey[level];
	}
	public static int getLevels() {
		return LEVELS;
	}

}
