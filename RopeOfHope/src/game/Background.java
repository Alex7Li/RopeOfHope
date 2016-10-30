package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	
	private static BufferedImage image; 
	
	public Background() {
		
	}

	
	public static BufferedImage getImage(int level){
		File imageFile;
		
		if (level == 1)
			imageFile = new File("RopeOfHopeBg.jpg");
		else if (level == 2)
			imageFile = new File("RopeOfHopeBg2.jpg");
		else 
			imageFile = new File("RopeOfHopeBg.jpg");
		//default
		
		try {
			image = ImageIO.read((imageFile));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		
		return image;
		
		
	}

}
