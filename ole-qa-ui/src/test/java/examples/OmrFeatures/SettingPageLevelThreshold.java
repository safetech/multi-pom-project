package examples.OmrFeatures;

import com.aspose.omr.*;
import examples.Utils;

public class SettingPageLevelThreshold {
	public static void main(String[] args) throws Exception {
		// ExStart:SettingPageLevelThreshold
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SettingPageLevelThreshold.class) + "OmrFeatures/";
		// Load template
		OmrTemplate template = OmrTemplate.load(dataDir + "template.amr");

		// Load image
		OmrImage image = OmrImage.load(dataDir + "sample1.jpg");

		// Get the first page of the template
		OmrPage page = template.getPages().getItem(0);

		// Create page configurations
		page.setConfiguration(new OmrConfig());

		// Set fill threshold
		page.getConfiguration().setFillThreshold(0.21);

		// Create an instance of OmrEngine and pass object of OmrTemplate as
		// parameter
		OmrEngine engine = new OmrEngine(template);

		// Extract the data
		OmrProcessingResult result = engine.extractData(new OmrImage[] { image });
		// ExEnd:SettingPageLevelThreshold
	}
}
