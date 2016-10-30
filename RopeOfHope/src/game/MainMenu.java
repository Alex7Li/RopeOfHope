package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	static final int LEVELS = 1;
	static int level = 1; // change this when adding levels

	static int highestLevelReached = 1;
	static int circlex[] = { 300, 300 };
	static int circley[] = { 200, 200 };
	static int squarex[] = { 200, 200 };
	static int squarey[] = { 200, 200 };
	static int exitx[] = { 150, 50 };
	static int exity[] = { 200, 350 };

	static JPanel contentPane;

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
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnStartGame = new JButton("Start Game");
		contentPane.add(btnStartGame, BorderLayout.SOUTH);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				startGame();
				Audio.doAudioJunk("bg1");
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

	static void startGame() {
		JFrame frame = new JFrame("Level " + (level));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Level level = new Level();
		frame.add(level);
	}

	private void openLevelSelect() {
		this.setVisible(false);
		new LevelSelection().setVisible(true);
	}

	public static void incrementLevel() {
		level++;
		if (highestLevelReached < level) {
			highestLevelReached = level;
		}
	}

	public static int getHighestLevelReached() {
		return highestLevelReached;
	}

	public static int getCirclex(int level) {
		return circlex[level - 1];
	}

	public static int getCircley(int level) {
		return circley[level - 1];
	}

	public static int getSquarex(int level) {
		return squarex[level - 1];
	}

	public static int getSquarey(int level) {
		return squarey[level - 1];
	}

	public static int getExitx(int level) {
		return exitx[level - 1];
	}

	public static int getExity(int level) {
		return exity[level - 1];
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int l) {
		level = l;
	}

}