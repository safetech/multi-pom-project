package examples.OmrFeatures;

import com.aspose.omr.*;
import com.aspose.omr.elements.TextOcrElement;
import examples.Utils;

import java.awt.geom.Point2D;
import java.util.Set;

public class ExtractTextDatafromScannedOMRForm {

	public static void main(String[] args) throws Exception {
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ExtractTextDatafromScannedOMRForm.class) + "OmrFeatures/";

		/// Set the paths
		String imageFile = dataDir + "sample1.jpg";
		String templateFile = dataDir + "template.amr";

		// Create an instance of OmrTemplate and load the template file
		OmrTemplate template = OmrTemplate.load(templateFile);

		// Set resource for TextOcrElement
		TextOcrElement.setResource(dataDir + "font.zip");
		// Create an instance of TextOcrElement and initialize it by specifying
		// the location of text and its size in mm
		java.awt.Dimension objDimension = new java.awt.Dimension(15, 5);
		TextOcrElement textElement = new TextOcrElement("ocr text", new Point2D.Float(23.6f, 15.5f), objDimension);
		// Add TextOcrElement to the template's element collection
		template.getPages().getItem(0).getElements().add(textElement);
		// Create an instance of OmrImage and load the scanned image
		OmrImage image = OmrImage.load(imageFile);
		// Create an instance of OmrEngine and initialize it with an object of
		// OmrTemplate
		OmrEngine engine = new OmrEngine(template);
		// Start the recognition process by calling OmrEngine.extractData method
		OmrProcessingResult result = engine.extractData(new OmrImage[] { image });
		// Get all pages of extracted data
		StringDictionary[] pages = result.getPageData();
		int index = 0;
		// Iterate over the pages
		for (StringDictionary page : pages) {
			System.out.println("------Page: " + index++);
			Set<String> keys = page.keySet();
			// Display the result for each key
			for (String key : keys) {
				String value = page.get(key);
				System.out.println("key: " + key);
				System.out.println("value: '" + value + "'");
			}
		}
	}

}
