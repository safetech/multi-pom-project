package resources.pages.agentpages.uwExpansionPages;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static resources.utils.PDFSignatureAssertions.PdfSignatureAssertions;

public class ReviewAndSubmitPage extends WizardPage {

    private FluentWebElement requiredlink;
    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement applicationStatus;

    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[79]") static FluentWebElement ArGiAarpMemberShipnumber;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[75]") static FluentWebElement ArGiFirstNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[66]") static FluentWebElement ArGiMiddleNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[64]") static FluentWebElement ArGiLastNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[71]") static FluentWebElement ArGiAddressOnePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[77]") static FluentWebElement ArGiCityPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[80]") static FluentWebElement ArGiStatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[76]") static FluentWebElement ArGiZipcodePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[68]") static FluentWebElement ArGiFirstNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[78]") static FluentWebElement ArGiMiddleNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[67]") static FluentWebElement ArGiLastNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[63]") static FluentWebElement ArGiMedicareClainNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[70]") static FluentWebElement ArGiSexPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[65]") static FluentWebElement ArGiHospitalPartADatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[81]") static FluentWebElement ArGiHospitalPartBDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[74]") static FluentWebElement ArGiMedicarePartABActivePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[62]") static FluentWebElement ArGiDateOfBirthPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[73]") static FluentWebElement ArGiPhoneNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[69]") static FluentWebElement ArGiEmailAddressPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[78]") static FluentWebElement ArGiFirstNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[76]") static FluentWebElement ArGiLastNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[75]") static FluentWebElement ArGiPlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[77]") static FluentWebElement ArGiPlanStartDatePdf;

    
    
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[84]") static FluentWebElement ArFullAarpMemberShipnumber;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[79]") static FluentWebElement ArFullFirstNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[66]") static FluentWebElement ArFullMiddleNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[64]") static FluentWebElement ArFullLastNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[71]") static FluentWebElement ArFullAddressOnePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[74]") static FluentWebElement ArFullAddressTwoPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[82]") static FluentWebElement ArFullCityPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[85]") static FluentWebElement ArFullStatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[81]") static FluentWebElement ArFullZipcodePdf;        
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[77]") static FluentWebElement ArFullCity2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[85]") static FluentWebElement ArFullState2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[76]") static FluentWebElement ArFullZipcode2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[68]") static FluentWebElement ArFullFirstNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[83]") static FluentWebElement ArFullMiddleNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[67]") static FluentWebElement ArFullLastNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[63]") static FluentWebElement ArFullMedicareClainNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[70]") static FluentWebElement ArFullSexPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[65]") static FluentWebElement ArFullHospitalPartADatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[86]") static FluentWebElement ArFullHospitalPartBDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[78]") static FluentWebElement ArFullMedicarePartABActivePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[62]") static FluentWebElement ArFullDateOfBirthPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[75]") static FluentWebElement ArFullPhoneNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[69]") static FluentWebElement ArFullEmailAddressPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[79]") static FluentWebElement ArFullFirstNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[76]") static FluentWebElement ArFullLastNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[75]") static FluentWebElement ArFullPlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[78]") static FluentWebElement ArFullPlanStartDatePdf;
    public void fillAndSubmit(Application app) {

        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        requiredlink.click();
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        String baseWindowHdl = getDriver().getWindowHandle();
        getDriver().switchTo().window(windows.get(1)).manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        if(app.getMethodName().equals("AGENT_Arkansas_GI")){
            ArGiPdfAssertions(app);
        }else ArFullUnderwritingPdfAssertions(app);
        

       String pdfUrl= getDriver().getCurrentUrl();
        if(pdfUrl.contains("https://aarpsupplementalhealth-tst.uhc.com/")){
            pdfUrl=pdfUrl.replace("https://aarpsupplementalhealth-tst.uhc.com/","http://apsrt0786.uhc.com:8080/");
        }else
            pdfUrl.replace("https://aarpsupplementalhealth-stg.uhc.com/","http://apsrt0786.uhc.com:8080/");
            
        
        PdfSignatureAssertions(pdfUrl);
        getDriver().switchTo().window(baseWindowHdl);
        closeSpecificBrowser(1);
        app.getTest().log(LogStatus.INFO,"Clicking Submit..");
        click(WIZARD_PAGE_NEXT_BTN_SELECTOR);
        await().atMost(40, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }
    
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Review and Submit"));

    }    
    public void ArGiPdfAssertions(Application app) {
        app.getTest().log(LogStatus.INFO,"Verifying Pdf..");
        assertThat(ArGiAarpMemberShipnumber.getText(), equalTo(app.getAARPMembershipNumber()));
        assertThat(ArGiFirstNamePdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArGiMiddleNamePdf.getText(), equalTo(app.getMI()));
        assertThat(ArGiLastNamePdf.getText(), equalTo(app.getLastName()));
        assertThat(ArGiAddressOnePdf.getText(), equalTo(app.getAddressLine1()));
        assertThat(ArGiCityPdf.getText(), equalTo(app.getCity()));
        assertThat(ArGiStatePdf.getText(), equalTo(app.getState()));
        assertThat(ArGiZipcodePdf.getText(), equalTo(app.getZipCode()));
        assertThat(ArGiFirstNameOfBeneficiaryPdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArGiMiddleNameOfBeneficiaryPdf.getText(), equalTo(app.getMI()));
        assertThat(ArGiLastNameOfBeneficiaryPdf.getText(), equalTo(app.getLastName()));
        assertThat(ArGiMedicareClainNumberPdf.getText(), equalTo(app.getMedicareClaimNum()));
        assertThat(ArGiSexPdf.getText(), equalTo(app.getGender()));
        assertThat(ArGiHospitalPartADatePdf.getText(), equalTo(app.getMPAED().replace("/","-")));
        assertThat(ArGiHospitalPartBDatePdf.getText(), equalTo(app.getMPBED().replace("/","-")));
        assertThat(ArGiMedicarePartABActivePdf.getText().toLowerCase(), equalTo("yes"));
        assertThat(ArGiDateOfBirthPdf.getText(), equalTo(app.getDOB().replace("/","-")));
        assertThat(ArGiPhoneNumberPdf.getText().replace("-",""), equalTo(app.getPhonePrimary()));
        assertThat(ArGiEmailAddressPdf.getText(), equalTo(app.getEmail()));
        assertThat(ArGiFirstNamePage2Pdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArGiLastNamePage2Pdf.getText(), equalTo(app.getLastName()));
        assertThat(ArGiPlanBPdf.getText(), equalTo("B"));
        assertThat(ArGiPlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-").trim()));

    }
    public void ArFullUnderwritingPdfAssertions(Application app) {
        app.getTest().log(LogStatus.INFO,"Verifying Pdf..");
        assertThat(ArFullAarpMemberShipnumber.getText(), equalTo(app.getAARPMembershipNumber()));
        assertThat(ArFullFirstNamePdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullMiddleNamePdf.getText(), equalTo(app.getMI()));
        assertThat(ArFullLastNamePdf.getText(), equalTo(app.getLastName()));
        assertThat(ArFullAddressOnePdf.getText(), equalTo(app.getAddressLine1()));
        assertThat(ArFullCityPdf.getText(), equalTo(app.getCity()));
        assertThat(ArFullStatePdf.getText(), equalTo(app.getState()));
        assertThat(ArFullZipcodePdf.getText(), equalTo(app.getZipCode()));
        assertThat(ArFullFirstNameOfBeneficiaryPdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullMiddleNameOfBeneficiaryPdf.getText(), equalTo(app.getMI()));
        assertThat(ArFullLastNameOfBeneficiaryPdf.getText(), equalTo(app.getLastName()));
        assertThat(ArFullMedicareClainNumberPdf.getText(), equalTo(app.getMedicareClaimNum()));
        assertThat(ArFullSexPdf.getText(), equalTo(app.getGender()));
        assertThat(ArFullHospitalPartADatePdf.getText(), equalTo(app.getMPAED().replace("/","-")));
        assertThat(ArFullHospitalPartBDatePdf.getText(), equalTo(app.getMPBED().replace("/","-")));
        assertThat(ArFullMedicarePartABActivePdf.getText().toLowerCase(), equalTo("yes"));
        assertThat(ArFullDateOfBirthPdf.getText(), equalTo(app.getDOB().replace("/","-")));
        assertThat(ArFullPhoneNumberPdf.getText().replace("-",""), equalTo(app.getPhonePrimary()));
        assertThat(ArFullEmailAddressPdf.getText(), equalTo(app.getEmail()));
        assertThat(ArFullFirstNamePage2Pdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage2Pdf.getText(), equalTo(app.getLastName()));
        assertThat(ArFullPlanBPdf.getText(), equalTo("B"));
        assertThat(ArFullPlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-").trim()));

    }
}
