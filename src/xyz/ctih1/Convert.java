package src.xyz.ctih1;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.batik.transcoder.SVGAbstractTranscoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import java.io.ByteArrayInputStream;

public class Convert {
	private static ByteArrayOutputStream stream;
	private static TranscoderInput input;
	private static TranscoderOutput output;
	private static PNGTranscoder transcoder;
		
	public static BufferedImage SVG(String location) throws IOException, TranscoderException {
		stream = new ByteArrayOutputStream();
		input = new TranscoderInput(location);
        output = new TranscoderOutput(stream);
        System.out.println(String.format("[DEBUG] - stream: %s input: %s output: %s location: %s", stream, input, output, location));
        return(TranscoderToImage());
	}
	
	public static BufferedImage TranscoderToImage() throws IOException, TranscoderException {
		transcoder = new PNGTranscoder();
		transcoder.addTranscodingHint(SVGAbstractTranscoder.KEY_HEIGHT, 4096f);
		transcoder.addTranscodingHint(SVGAbstractTranscoder.KEY_WIDTH, 4096f);
		transcoder.transcode(input, output);
		
		stream.flush();
		return ImageIO.read(new ByteArrayInputStream(stream.toByteArray()));
	}

}
