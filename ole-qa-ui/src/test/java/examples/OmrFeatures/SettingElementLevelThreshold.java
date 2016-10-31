package examples.OmrFeatures;


import com.aspose.omr.*;
import com.aspose.omr.elements.GridElement;
import examples.Utils;

import java.awt.geom.Point2D;

public class SettingElementLevelThreshold {
	public static void main(String[] args) throws Exception {
		// ExStart:SettingElementLevelThreshold
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(SettingElementLevelThreshold.class) + "OmrFeatures/";
		// Load template
		OmrTemplate template = OmrTemplate.load(dataDir + "template.amr");

		// Load image
		OmrImage image = OmrImage.load(dataDir + "sample1.jpg");

		// Get the first page of the template
		OmrPage page = template.getPages().getItem(0);

		// Create an element by passing the name, location and size
		java.awt.Dimension objDimension = new java.awt.Dimension(60, 30);
		GridElement element = new GridElement("grid1", new Point2D.Float(10, 20), objDimension);

		// Add element to the page
		page.getElements().add(element);

		// Create configuration for the element
		element.setConfiguration(new OmrConfig());

		// Set the TrimWhitePixels to false
		element.getConfiguration().setTrimWhitePixels(false);

		// Create an instance of OmrEngine and pass object of OmrTemplate as
		// parameter
		OmrEngine engine = new OmrEngine(template);

		// Extract the data
		OmrProcessingResult result = engine.extractData(new OmrImage[] { image });
		// ExEnd:SettingElementLevelThreshold
	}

}
