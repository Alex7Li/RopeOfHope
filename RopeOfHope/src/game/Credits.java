package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Credits extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Credits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea(

			    "Alex Li: coder, did physics, made things work in general \n\n" +
			    "Cameron Byrne: coder, did art and sound, did level design \n\n" +
			    "Made for the 2016 Congressional App Challenge for Congressman Dave Joyce."
			);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
		if (MainMenu.hasWon == true){
			JTextArea textArea2 = new JTextArea(
				    "Congratulations! \n" +
					"You beat the game! \n" +
				    "Had fun sensations? \n" +
					"Hope you're glad you came! \n" +
				    "Now you're a hero! \n" +
				    "Didn't even need to burn a rope! \n" +
				    "You are no zero \n" +
				    "You're success gives us all hope!"
				);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
			contentPane.add(textArea2, BorderLayout.SOUTH);
		}
		contentPane.add(textArea, BorderLayout.CENTER);

		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnToMain();
			}
		});
		contentPane.add(btnReturnToMain, BorderLayout.EAST);
	}
	private void returnToMain() {
		this.setVisible(false);
		new MainMenu().setVisible(true);
	}
	//pretty sure this is horrible design

}
