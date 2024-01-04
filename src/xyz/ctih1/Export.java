package src.xyz.ctih1;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

public class Export {

	public Export() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean export(BufferedImage image, String file) throws IOException {
		File outputfile = new File("image.png");
		ImageIO.write(image, "png", outputfile);
		return true;
	}

}
