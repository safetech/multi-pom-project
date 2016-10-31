package resources.utils;

import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine;
import examples.WorkingWithOcr.PerformOCROnImage;

public class OcrScanner {

    public static void main(String[] args) {
        

    String dataDir = Utils.getDataDir(PerformOCROnImage.class);

    /// Set the paths
    String imagePath = dataDir + "Sample1.jpg";

    // Create an instance of OcrEngine
    OcrEngine ocr = new OcrEngine();

// Set image file
    ocr.setImage(ImageStream.fromFile(imagePath));

// Perform OCR and get extracted text
    try {
        if (ocr.process()) {
            System.out.println("\ranswer -> " + ocr.getText());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

}
