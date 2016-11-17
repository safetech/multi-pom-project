package resources.utils;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SaveImagesFromPDF {

    public static boolean saveImagesFromPDF(URL url)
    {
        try {

            String destinationDir = "/Users/sislam13/dev/code/codehub/ole-qa/ole-qa-ui/src/test/java/resources/pdf/ActualImages/";

            // Removes all files from PdfActualImages Directory
            FileUtils.cleanDirectory(new File(destinationDir));

            PDDocument document = PDDocument.load(url);

            List list = document.getDocumentCatalog().getAllPages();

            int totalImages = 1;
            for (Object page : list) {
                PDResources pdResources = ((PDPage)page).getResources();

                Map<String,PDXObjectImage> pageImages = pdResources.getImages();
                if (pageImages != null) {

                    Iterator<String> imageIter = pageImages.keySet().iterator();
                    while (imageIter.hasNext()) {
                        String key =  imageIter.next();
                        PDXObjectImage pdxObjectImage =  pageImages.get(key);
                        pdxObjectImage.write2file(destinationDir + "img"+ "_" + totalImages);
                        totalImages++;
                        
                    }
                }
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
}