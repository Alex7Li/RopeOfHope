package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LevelSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LevelSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnlevel1 = new JButton("Level 1");
		addLevel(btnlevel1,1);

		JButton btnlevel2 = new JButton("Level 2");
		addLevel(btnlevel2,2);
		
		JButton btnlevel3 = new JButton("Level 3");
		addLevel(btnlevel3,3);
		
		JButton btnlevel4 = new JButton("Level 4");
		addLevel(btnlevel4,4);
		
		JButton btnlevel5 = new JButton("Level 5");
		addLevel(btnlevel5,5);
	}

	public void addLevel(JButton btnName, int level){
		if (level <= MainMenu.getHighestLevelReached()){
		
			btnName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu.setLevel(level);
					MainMenu.startGame();
				}
			});
		}
		else{
			btnName.setText("Level " + level + " (locked)");
		}
		contentPane.add(btnName);
	}
}