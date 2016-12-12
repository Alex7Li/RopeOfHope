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
		
		if (level%5 == 1)
			imageFile = new File("RopeOfHopeBg.jpg");
		else if (level%5 == 2)
			imageFile = new File("RopeOfHopeBg2.jpg");
		else if (level%5 == 3)
			imageFile = new File("Bg3.jpg");
		else if (level%5 == 4)
			imageFile = new File("Bg4.jpg");
		else if (level%5 == 0)
			imageFile = new File("Bg5.jpg");
		else 
			imageFile = new File("Error.png");
		//default
		
		try {
			image = ImageIO.read((imageFile));
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return image;
		
		
	}

}
