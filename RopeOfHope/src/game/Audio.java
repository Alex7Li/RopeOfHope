package game;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Audio {
	
	static File clip;
	
	public Audio() {
		// TODO Auto-generated constructor stub
	}
	
	public static void doAudioJunk(String s){
		if (s == "thud"){
		    clip = new File("thudForRope.wav");
		}
		else if (s == "jump"){
			clip = new File("jumpGameRope.wav");
		}
		
		PlaySound(clip);
	}

	public static void PlaySound(File sound){
		try{
		    Clip clip =  AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(sound));
		    clip.start();
		} 
		catch (Exception e){
			
		}
	}
	
}
