package resources.utils;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SaveImagesFromPDF {

    public static boolean saveImagesFromPDF(URL url,String destination)
    {
        try {

            String destinationDir = "/Users/sislam13/dev/code/codehub/ole-qa/ole-qa-ui/src/test/java/resources/pdf/"+destination+"/ExpectedImages/";

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

    public static void main(String[] args) {
        try {
            System.out.println(saveImagesFromPDF(new URL("http://apsrt0786.uhc.com:8080/bin/oleuhcproxy.html/appEnroll-web/resources/applicationDetail/SHIP/MEDSUPP/1561-E629-27/generatePDF/full_PDF?verifyDOB=1941-12-01&verifyZipCode=71611&channel=agent&appPdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FApplicationPDFs%2FS25F49AGMMAR01_01D_WB.pdf&onePdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FEFTPDFs%2FBIL_EFT_Web_1_Time_AGT_3.pdf&recPdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FEFTPDFs%2FBIL_EFT_Web_Recurring_Only_AGT.pdf&rnPdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FReplacementNotices%2FRN034_AR_WB.pdf&ssPdfFile=&&override=requiredlink_clicked:true"),"AGENT_Arkansas_Eligibility_FU_With_RN"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}