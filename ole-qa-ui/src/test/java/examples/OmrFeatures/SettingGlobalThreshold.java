package examples.OmrFeatures;

import com.aspose.omr.*;
import examples.Utils;

public class SettingGlobalThreshold {
	public static void main(String[] args) throws Exception {
		// ExStart:SettingGlobalThreshold
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SettingGlobalThreshold.class) + "OmrFeatures/";
		// Load template
		OmrTemplate template = OmrTemplate.load(dataDir + "template.amr");

		// Load image
		OmrImage image = OmrImage.load(dataDir + "sample1.jpg");

		// Create an instance of OmrEngine and pass object of OmrTemplate as
		// parameter
		OmrEngine engine = new OmrEngine(template);

		// Get the configurations of OmrEngine
		OmrConfig config = engine.getConfiguration();

		// Set fill threshold
		config.setFillThreshold(0.12);

		// Extract the data
		OmrProcessingResult result = engine.extractData(new OmrImage[] { image });
		// ExEnd:SettingGlobalThreshold
	}

}
