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

	static boolean hasWon = false;
	static JFrame currentFrame = new JFrame("Rope of Hope");
	private static boolean hasTimerStarted = false;
	private static boolean hasTimerGenerated = false;
	private static boolean hasGenerated = false;

	static final int LEVELS = 8;// change this when adding levels
	static int level = 1; // keep at 1

	static int highestLevelReached = 1; // change this for levels to be unlocked

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnStartGame = new JButton("Start Game");
		contentPane.add(btnStartGame, BorderLayout.CENTER);
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Audio.doAudioJunk("bg1");
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
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCredits();
			}
		});
		contentPane.add(btnCredits, BorderLayout.EAST);
	}

	static void restartLevel(int level) {
		Level current = new Level();
		currentFrame.add(current);
		Level.circle.setCharx(Level.circlex[level - 1]);
		Level.circle.setChary(Level.circley[level - 1]);
		Level.square.setCharx(Level.squarex[level - 1]);
		Level.square.setChary(Level.squarey[level - 1]);
		Level.circle.setCharVx(0);
		Level.circle.setCharVy(0);
		Level.square.setCharVx(0);
		Level.square.setCharVy(0);
	}

	static void startGame() {

		if (!hasGenerated) {
			currentFrame.setBounds(100, 100, 900, 600);
			currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			currentFrame.setVisible(true);
			hasGenerated = true;
		}

		currentFrame.setTitle("Level " + (level));
		if (level == LEVELS) {
			level = 1;
			hasWon = true;
			currentFrame.invalidate();
			currentFrame.setVisible(false);
			new Credits().setVisible(true);
		} else {

			Level level = new Level();
			currentFrame.getContentPane().add(level);
		}
	}

	private void openLevelSelect() {
		this.setVisible(false);
		new LevelSelection().setVisible(true);
	}

	private void openCredits() {
		this.setVisible(false);
		new Credits().setVisible(true);
	}

	public static void incrementLevel() {
		level++;
		Level.setLevel(level);
		if (highestLevelReached < level) {
			highestLevelReached = level;
		}
	}

	public static int getHighestLevelReached() {
		return highestLevelReached;
	}

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int l) {
		level = l;
	}

	public static boolean isHasTimerGenerated() {
		return hasTimerGenerated;
	}

	public static boolean isHasTimerStarted() {
		return hasTimerStarted;
	}

	public static void setHasTimerGenerated(boolean TimerGenerated) {
		hasTimerGenerated = TimerGenerated;
	}

	public static void setHasTimerStarted(boolean TimerStarted) {
		hasTimerStarted = TimerStarted;
	}

	public static int getLevels() {
		return LEVELS;
	}

}