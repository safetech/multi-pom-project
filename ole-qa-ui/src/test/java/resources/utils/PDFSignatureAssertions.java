package resources.utils;
import java.io.File;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PDFSignatureAssertions {
    
    public static void PdfSignatureAssertions(String url){
        try {
            if(SaveImagesFromPDF.saveImagesFromPDF(new URL(url))) {
                File[] actualImages= new File("/Users/sislam13/dev/code/codehub/ole-qa/ole-qa-ui/src/test/java/resources/pdf/ActualImages/").listFiles();
                File[] expectedImages= new File("/Users/sislam13/dev/code/codehub/ole-qa/ole-qa-ui/src/test/java/resources/pdf/ExpectedImages/").listFiles();
                for(int i=0;i<actualImages.length;i++) {
                    String actualFileName=actualImages[i].getName();
                    
                    assertThat("Actual --> "+actualFileName,CompareImages.compareImages(expectedImages[i],actualImages[i]), equalTo(true));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
