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
	static int level = 1;
	static int levelReached = 1;
	static int circlex = 200;
	static int circley = 200;
	static int squarex = 200;
	static int squarey = 200;
	
	static int[] wallNums = {6,4};
	//wallNums = number of walls in level corresponding to array position.
	
	static int[][] xarrs = {{ 0,   650, 0,   150, 40, 253},
			    { 0,   650, 0, 89}
	};
	//each 1-D array level is a level's x-block positions.
	static int[][] yarrs =      {{ 0,   0,   650, 280, 150, 500},
					{ 0,   0,   650, 280}
	};
	static int[][] widtharrs =  {{ 40,  50,  700, 100, 50 , 32},
					{ 40,  50,  700, 100}
	};
	static int[][] heightarrs = {{ 700, 700, 40,  100, 30 , 10},
			{ 700, 700, 40,  100}
	};
	
	
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
		frame.setBounds(100, 100, 700, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//iterate through a level of the 2-D arrays to get the x, y, width, and height
		//values. This was neccessary because you can't change arrays except by each
		//element which meant I would otherwise have to make level*4 1-D arrays.
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

		Level level1 = new Level();
		level1.createLevel(x, y, width, height);
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
		if (levelReached<level){
			levelReached=level;
		}
		startGame();
	}
	
	public static int getCirclex() {
		return circlex;
	}
	public static int getCircley() {
		return circley;
	}
	public static int getSquarex() {
		return squarex;
	}
	public static int getSquarey() {
		return squarey;
	}
	public static int getLevels() {
		return LEVELS;
	}

}
