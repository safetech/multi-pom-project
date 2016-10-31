package examples.OmrFeatures;


import com.aspose.omr.*;
import examples.Utils;

import java.util.Set;

public class ExtractingOMRData {
	public static void main(String[] args) throws Exception {
		// ExStart:ExtractingOMRData
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(ExtractingOMRData.class) + "OmrFeatures/";
		// Initialize a string with template file location
		String templateFile = dataDir + "template.amr";
		// Initialize a string with scanned image file location
		String imageFile = dataDir + "sample1.jpg";
		// Create an instance of OmrTemplate class and load the template using
		// the factory method Load
		OmrTemplate template = OmrTemplate.load(templateFile);
		// Create an instance of OmrImage class and load the template using the
		// factory method Load
		OmrImage image = OmrImage.load(imageFile);
		// Create an instance of OmrEngine class
		OmrEngine engine = new OmrEngine(template);
		// Extract the OMR data
		OmrProcessingResult result = engine.extractData(new OmrImage[] { image });
		// Get page data of extracted data
		StringDictionary[] pages = result.getPageData();
		int index = 0;
		// Iterate over the pages and display the data
		for (StringDictionary page : pages) {
			System.out.println("------Page: " + index++);
			Set<String> keys = page.keySet();
			for (Object key : keys) {
				String value = page.get(key);
				System.out.println("key: " + key);
				System.out.println("value: '" + value + "'");
			}
		}
		// ExEnd:ExtractingOMRData
	}

}
