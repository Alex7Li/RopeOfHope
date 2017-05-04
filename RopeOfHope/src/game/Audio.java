package game;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	static File clip;

	public Audio() {
	}

	public static void doAudioJunk(String s) {
		if (s == "thud") {
			clip = new File("thudForRope.wav");
		} else if (s == "jump") {
			clip = new File("jumpGameRope.wav");
		} else if (s == "bg1")
			clip = new File("BGM1.wav");
		PlaySound(clip);
	}

	public static void PlaySound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e) {
			
		}
	}
}
