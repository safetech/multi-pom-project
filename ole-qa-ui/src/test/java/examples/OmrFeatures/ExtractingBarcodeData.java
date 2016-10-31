package examples.OmrFeatures;

import com.aspose.ocr.License;
import com.aspose.omr.*;
import com.aspose.omr.elements.BarcodeElement;
import examples.Utils;

import java.awt.geom.Point2D;
import java.util.Set;

public class ExtractingBarcodeData {
	public static void main(String[] args) throws Exception {
		// ExStart:ExtractingBarcodeData
		String dataDir = Utils.getSharedDataDir(ExtractingBarcodeData.class) + "OmrFeatures/";

		String templateFile = dataDir + "sample_1.amr";
		String imageFile = dataDir + "sample1.jpg";

		// Set the license for Aspose.BarCode for Java in case BarCode elements
		// are used in the project
		License licenseBarCode = new License();
		licenseBarCode.setLicense(dataDir + "Aspose.Total.Java.lic");

		// Set the license for OMR package
		com.aspose.ocr.License licenseOmr = new com.aspose.ocr.License();
		licenseOmr.setLicense(dataDir + "Aspose.Total.Java.lic");

		// Load the template for mapping of elements
		OmrTemplate template = OmrTemplate.load(templateFile);

		// Add the BarCode element while specifying the location and size of
		// barcode
		java.awt.Dimension objDimension = new java.awt.Dimension(205, 205);
		BarcodeElement barcodeElement = new BarcodeElement("aztec", new Point2D.Float(0, 0), objDimension);
		// Add the BarCode element to the template page
		template.getPages().getItem(0).getElements().add(barcodeElement);

		// Load image to perform OMR
		OmrImage image = OmrImage.load(imageFile);
		// Initialize the OmrEngine with template file
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
			for (String key : keys) {
				// Display the result for each key
				String value = page.get(key);
				System.out.println("key: " + key);
				System.out.println("value: '" + value + "'");
			}
		}
		// ExEnd:ExtractingBarcodeData
	}

}
