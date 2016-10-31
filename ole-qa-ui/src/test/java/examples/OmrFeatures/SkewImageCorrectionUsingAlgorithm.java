package examples.OmrFeatures;


import com.aspose.omr.OmrEngine;
import com.aspose.omr.OmrImage;
import com.aspose.omr.OmrTemplate;
import examples.Utils;

import javax.imageio.ImageIO;
import java.io.File;

public class SkewImageCorrectionUsingAlgorithm {
	public static void main(String[] args) throws Exception {
		// ExStart:SkewImageCorrectionUsingAlgorithm
		// Load image
		String dataDir = Utils.getSharedDataDir(SkewImageCorrectionUsingAlgorithm.class) + "OmrFeatures/";
		OmrImage image = OmrImage.load(dataDir + "sample1.jpg");

		// Use empty template or load any existing template
		OmrEngine engine = new OmrEngine(new OmrTemplate());

//		// Get skew degree of the image
//		int degree = engine.getSkewDegree(image);
//
//		// Rotate image to correct skew
//		engine.rotateImage(image, degree);

		// Save image
		File fileObj = new File(dataDir + "SkewImageCorrectionUsingAlgorithm_out.jpg");
		ImageIO.write(image.asBitmap(), "jpg", fileObj);
		// ExEnd:SkewImageCorrectionUsingAlgorithm
	}

}
