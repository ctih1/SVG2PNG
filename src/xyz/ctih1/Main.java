package src.xyz.ctih1;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.batik.transcoder.TranscoderException;

public class Main {

	public Main() {
		
		// TODO Auto-generated constructor stub
	}
	static BufferedImage image = null;

	public static void main(String[] args) {
		try {
			image = Convert.SVG("file:\\YOUR\\FILE\\LOCATION.SVG");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TranscoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		

		assert image.getWidth() == 256; // change them if you want
		assert image.getHeight() == 256;	
		try {
			System.out.println(Export.export(image, "file:\\YOUR\\EXPORT\\LOCATION"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
