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
		setBounds(100, 100, 1200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		for(int i = 1; i<MainMenu.getLevels(); i++){
			JButton btnlevel = new JButton("Level 1");
			addLevel(btnlevel,i);
		}
	}

	public void addLevel(JButton btnName, int level){
		btnName.setText("Level " + level);
		if (level <= MainMenu.getHighestLevelReached()){
		
			btnName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainMenu.setLevel(level);
					MainMenu.startGame();
					Audio.doAudioJunk("bg1");
				}
			});
		}
		else{
			btnName.setText("Level " + level + " (locked)");
		}
		contentPane.add(btnName);
	}
}