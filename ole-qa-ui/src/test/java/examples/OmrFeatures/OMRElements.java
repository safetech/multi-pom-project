package examples.OmrFeatures;


import com.aspose.omr.OmrElementsCollection;
import com.aspose.omr.OmrPage;
import com.aspose.omr.OmrTemplate;
import examples.Utils;

public class OMRElements {
	public static void main(String[] args) throws Exception {
		// ExStart:OMRElements
		// The path to the documents directory.
		String dataDir = Utils.getSharedDataDir(OMRElements.class) + "OmrFeatures/";
		// Initialize a string with file path to the template
		String templateFile = dataDir + "template.amr";
		// Create an instance of OmrTemplate and load the template
		OmrTemplate template = OmrTemplate.load(templateFile);
		// Iterate over the pages in template
		for (Object opage : template.getPages()) {
			OmrPage page = (OmrPage) opage;
			// Get elements of each page
			OmrElementsCollection collection = page.getElements();
			// Iterate over the element collection
			for (Object obj : collection) {
				// Display element name
				System.out.println(obj.getClass().toString());
			}
		}
		// ExEnd:OMRElements
	}

}
