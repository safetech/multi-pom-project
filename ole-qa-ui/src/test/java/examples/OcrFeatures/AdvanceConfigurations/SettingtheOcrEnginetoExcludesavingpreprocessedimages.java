package examples.OcrFeatures.AdvanceConfigurations;

import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;
import examples.Utils;


public class SettingtheOcrEnginetoExcludesavingpreprocessedimages {
	public static void main(String[] args) throws Exception {
		// ExStart:SettingtheOcrEnginetoExcludesavingpreprocessedimages
		String FileName = "";

		// Initialize an instance of OcrEngine
		OcrEngine ocr = new OcrEngine();

		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SettingtheOcrEnginetoExcludesavingpreprocessedimages.class) + "OcrFeatures/";

		/// Set the paths
		String imagePath = dataDir + "Sample1.jpg";

		// Set Image property by loading an image from file path
		ocr.setImage(ImageStream.fromFile(imagePath));

		// Set the SavePreprocessedImages property to false
		//ocr.getConfig().setSavePreprocessedImages(false);

		if (ocr.process()) {
			// Do processing
		}
		// ExEnd:SettingtheOcrEnginetoExcludesavingpreprocessedimages
	}
}
