package resources;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.List;

public class methodEvaluator {

@Test
public void mtest(){

    WebDriver driver;
    ProfilesIni profile = new ProfilesIni();
    FirefoxProfile ffprofile = profile.getProfile("Selenium");
    driver = new FirefoxDriver(ffprofile);
    
    
    driver.get("https://aarpsupplementalhealth-tst.uhc.com/bin/oleuhcproxy.html/appEnroll-web/resources/applicationDetail/SHIP/MEDSUPP/1562-9888-77/generatePDF/full_PDF?verifyDOB=1951-12-06&verifyZipCode=12345&channel=agent&appPdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FApplicationPDFs%2FM24D44AGMMNY01_01D_WB.pdf&onePdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FEFTPDFs%2FBIL_EFT_Web_1_Time_AGT_3.pdf&recPdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FEFTPDFs%2FBIL_EFT_Web_Recurring_Only_AGT.pdf&rnPdfFile=https%3A%2F%2Faarpsupplementalhealth-tst.uhc.com%2Fcontent%2Fdam%2Fole%2FMedSuppDocs%2FReplacementNotices%2FRN038_WB.pdf&ssPdfFile=&&override=requiredlink_clicked:true");
    
        List<WebElement> findElement = driver.findElements(By.tagName("select"));
    System.out.println(findElement.size());

    driver.close();
}
      



}
