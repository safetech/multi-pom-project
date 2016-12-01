package resources.pages.agentpages.uwExpansionPages;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.entity.Application;
import resources.pages.WizardPage;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static resources.utils.PDFSignatureAssertions.PdfSignatureAssertions;

public class ReviewAndSubmitPage extends WizardPage {

    private FluentWebElement requiredlink;
    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement applicationStatus;

<<<<<<< HEAD
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
=======
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[82]") FluentWebElement AarpMemberShipnumber;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[78]") FluentWebElement FirstNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[70]") FluentWebElement MiddleNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[68]") FluentWebElement LastNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[75]") FluentWebElement AddressOnePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[80]") FluentWebElement CityPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[83]") FluentWebElement StatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[79]") FluentWebElement ZipcodePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[72]") FluentWebElement FirstNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[81]") FluentWebElement MiddleNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[71]") FluentWebElement LastNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[67]") FluentWebElement MedicareClainNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[74]") FluentWebElement SexPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[69]") FluentWebElement HospitalPartADatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[84]") FluentWebElement HospitalPartBDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[77]") FluentWebElement MedicarePartABActivePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[66]") FluentWebElement DateOfBirthPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[76]") FluentWebElement PhoneNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[73]") FluentWebElement EmailAddressPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[141]") FluentWebElement FirstNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[139]") FluentWebElement LastNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[138]") FluentWebElement PlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[140]") FluentWebElement PlanStartDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[142]") FluentWebElement startDateWithin6MonthsOFTurning65;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[81]") FluentWebElement FirstNamePage3Pdf;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[74]") FluentWebElement FirstNamePage4Pdf;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[80]") FluentWebElement LastNamePage3Pdf;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[73]") FluentWebElement LastNamePage4Pdf;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[76]") FluentWebElement FirstNamePage5Pdf;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[74]") FluentWebElement LastNamePage5Pdf;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[77]") FluentWebElement areYouCoveredForMedicalAssistance;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[73]") FluentWebElement haveYouHadCoverageForAnyMedicarePLan;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[75]") FluentWebElement doYouHaveAnotherMedicareSupplementPolicy;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[77]") FluentWebElement FirstNamePage6Pdf;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[75]") FluentWebElement LastNamePage6Pdf;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[77]") FluentWebElement FirstNamePage7Pdf;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[75]") FluentWebElement LastNamePage7Pdf;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[54]") FluentWebElement FirstNamePage8Pdf;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[48]") FluentWebElement LastNamePage8Pdf;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[76]") FluentWebElement haveYouHadCoverageForPast63Days;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[52]") FluentWebElement listAnyPoliciesIssued;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[51]") FluentWebElement listAnyPoliciesIssuedStillInForce;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[53]") FluentWebElement listAnyPoliciesIssuedInPast5Years;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[55]") FluentWebElement AgentFirstName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[58]") FluentWebElement AgentMI;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[59]") FluentWebElement AgentLastName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[57]") FluentWebElement AgentId;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[78]") FluentWebElement TodayDatePage6Pdf;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[76]") FluentWebElement TodayDatePage7Pdf;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[78]") FluentWebElement TodayDatePage7Pdf2;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[50]") FluentWebElement TodayDatePage8Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[39]") FluentWebElement TodayDatePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[56]") FluentWebElement AgentEmail;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[49]") FluentWebElement AgentPhone;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[46]") FluentWebElement PlanBPDFPage9;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[48]") FluentWebElement FirstNamePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[45]") FluentWebElement LastNamePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[47]") FluentWebElement MiddleNamePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[36]") FluentWebElement AddressOnePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[42]") FluentWebElement AddressTwoPage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[40]") FluentWebElement CityPage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[41]") FluentWebElement StatePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[37]") FluentWebElement ZipCodePage9Pdf;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[43]") FluentWebElement BankName;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[44]") FluentWebElement BankRoutingNumber;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[38]") FluentWebElement BankAccountNumber;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[49]") FluentWebElement AccountType;
    @FindBy(xpath = "//*[@id='pageNumber']") FluentWebElement PageNumber;




>>>>>>> 63577b07189a74c5079081847dd5936cb94c46b8
    public void fillAndSubmit(Application app) {

        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        requiredlink.click();
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        String baseWindowHdl = getDriver().getWindowHandle();
        getDriver().switchTo().window(windows.get(1)).manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
<<<<<<< HEAD
        
        if(app.getMethodName().equals("AGENT_Arkansas_GI")){
            ArGiPdfAssertions(app);
        }else ArFullUnderwritingPdfAssertions(app);
        

       String pdfUrl= getDriver().getCurrentUrl();
        if(pdfUrl.contains("https://aarpsupplementalhealth-tst.uhc.com/")){
            pdfUrl=pdfUrl.replace("https://aarpsupplementalhealth-tst.uhc.com/","http://apsrt0786.uhc.com:8080/");
        }else
            pdfUrl.replace("https://aarpsupplementalhealth-stg.uhc.com/","http://apsrt0786.uhc.com:8080/");
            
        
        PdfSignatureAssertions(pdfUrl);
=======

        PdfAssertions(app);

>>>>>>> 63577b07189a74c5079081847dd5936cb94c46b8
        getDriver().switchTo().window(baseWindowHdl);
        closeSpecificBrowser(1);
        app.getTest().log(LogStatus.INFO,"Clicking Submit..");
        click(WIZARD_PAGE_NEXT_BTN_SELECTOR);
        await().atMost(40, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Review and Submit"));

<<<<<<< HEAD
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
=======
    }
    public void gotoPdfpage(int pageNumber){
        getDriver().findElement(By.id("pageNumber")).sendKeys(Keys.CONTROL+"a"+Keys.CONTROL);
        getDriver().findElement(By.id("pageNumber")).sendKeys(pageNumber+"\r");
    }
    public void PdfAssertions(Application app) {
        //page 1 and 2
        String TodayDate=new SimpleDateFormat("mm-dd-yyyy").format(new Date());

        assertThat(AarpMemberShipnumber.getText(), equalTo(app.getAARPMembershipNumber()));
        assertThat(FirstNamePdf.getText(), equalTo(app.getFirstName()));
        assertThat(MiddleNamePdf.getText(), equalTo(app.getMI()));
        assertThat(LastNamePdf.getText(), equalTo(app.getLastName()));
        assertThat(AddressOnePdf.getText(), equalTo(app.getAddressLine1()));
        assertThat(CityPdf.getText(), equalTo(app.getCity()));
        assertThat(StatePdf.getText(), equalTo(app.getState()));
        assertThat(ZipcodePdf.getText(), equalTo(app.getZipCode()));
        assertThat(FirstNameOfBeneficiaryPdf.getText(), equalTo(app.getFirstName()));
        assertThat(MiddleNameOfBeneficiaryPdf.getText(), equalTo(app.getMI()));
        assertThat(LastNameOfBeneficiaryPdf.getText(), equalTo(app.getLastName()));
        assertThat(MedicareClainNumberPdf.getText(), equalTo(app.getMedicareClaimNum()));
        assertThat(SexPdf.getText(), equalTo(app.getGender()));
        assertThat(HospitalPartADatePdf.getText(), equalTo(app.getMPAED().replace("/","-")));
        assertThat(HospitalPartBDatePdf.getText(), equalTo(app.getMPBED().replace("/","-")));
        assertThat(MedicarePartABActivePdf.getText().toLowerCase(), equalTo("yes"));
        assertThat(DateOfBirthPdf.getText(), equalTo(app.getDOB().replace("/","-")));
        assertThat(PhoneNumberPdf.getText().replace("-",""), equalTo(app.getPhonePrimary()));
        assertThat(EmailAddressPdf.getText(), equalTo(app.getEmail()));
        assertThat(FirstNamePage2Pdf.getText(), equalTo(app.getFirstName()));
        assertThat(LastNamePage2Pdf.getText(), equalTo(app.getLastName()));
        assertThat(PlanBPdf.getText(), equalTo("B"));

         assertThat(PlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-")));
        assertThat(startDateWithin6MonthsOFTurning65.getText(),equalTo("Yes"));
        //page 3 and 4
        gotoPdfpage(3);
        assertThat(FirstNamePage3Pdf.getText(),equalTo(app.getFirstName()));
        assertThat(LastNamePage3Pdf.getText(),equalTo(app.getLastName()));

        assertThat(FirstNamePage4Pdf.getText(),equalTo(app.getFirstName()));
        assertThat(LastNamePage4Pdf.getText(),equalTo(app.getLastName()));
        //page 5 and 6
        gotoPdfpage(5);
        assertThat(FirstNamePage5Pdf.getText(),equalTo(app.getFirstName()));
        assertThat(LastNamePage5Pdf.getText(),equalTo(app.getLastName()));
        assertThat(areYouCoveredForMedicalAssistance.getText().toLowerCase(),equalTo("no"));
        assertThat(haveYouHadCoverageForAnyMedicarePLan.getText().toLowerCase(),equalTo("no"));
        assertThat(doYouHaveAnotherMedicareSupplementPolicy.getText().toLowerCase(),equalTo("no"));

        assertThat(FirstNamePage6Pdf.getText(),equalTo(app.getFirstName()));
        assertThat(LastNamePage6Pdf.getText(),equalTo(app.getLastName()));
        assertThat(haveYouHadCoverageForPast63Days.getText().toLowerCase(),equalTo("no"));
        assertThat(TodayDatePage6Pdf.getText(),equalTo(TodayDate));
        //page 7 and 8
        gotoPdfpage(7);
        assertThat(FirstNamePage7Pdf.getText(),equalTo(app.getFirstName()));
        assertThat(LastNamePage7Pdf.getText(),equalTo(app.getLastName()));
        assertThat(TodayDatePage7Pdf.getText(),equalTo(TodayDate));
        assertThat(TodayDatePage7Pdf2.getText(),equalTo(TodayDate));

        assertThat(FirstNamePage8Pdf.getText(),equalTo(app.getFirstName()));
        assertThat(LastNamePage8Pdf.getText(),equalTo(app.getLastName()));
        assertThat(listAnyPoliciesIssued.getText(),equalTo("HMO"));
        assertThat(listAnyPoliciesIssuedStillInForce.getText(),equalTo("HMO In Force"));
        assertThat(listAnyPoliciesIssuedInPast5Years.getText(),equalTo("HMO Not In Force"));
        assertThat(AgentFirstName.getText(),equalTo(app.getAgentFirstName()));
        assertThat(AgentMI.getText(),equalTo(app.getAgentMI()));
        assertThat(AgentLastName.getText(),equalTo(app.getAgentLastName()));
        assert(!AgentId.getText().equals(""));
        assertThat(AgentEmail.getText(),equalTo(app.getAgentEmail()));
        assertThat(AgentPhone.getText(),equalTo(app.getAgentPhone()));
        assertThat(TodayDatePage8Pdf.getText(),equalTo(TodayDate));

        gotoPdfpage(9);
        assertThat(PlanBPDFPage9.getText(),equalTo("B"));
        assertThat(FirstNamePage9Pdf.getText(), equalTo(app.getFirstName()));
        assertThat(MiddleNamePage9Pdf.getText(), equalTo(app.getMI()));
        assertThat(LastNamePage9Pdf.getText(), equalTo(app.getLastName()));
        assertThat(AddressOnePage9Pdf.getText(), equalTo(app.getAddressLine1()));
        assertThat(AddressTwoPage9Pdf.getText(), equalTo(app.getAddressLine2()));
        assertThat(CityPage9Pdf.getText(), equalTo(app.getCity()));
        assertThat(StatePage9Pdf.getText(), equalTo(app.getState()));
        assertThat(ZipCodePage9Pdf.getText(), equalTo(app.getZipCode()));
        assertThat(BankName.getText(),equalTo(app.getBankName()));
        assertThat(BankAccountNumber.getText(),equalTo(app.getAccountNumber()));
        assertThat(BankRoutingNumber.getText(),equalTo(app.getRoutingNumber()));
        assert(!AccountType.getText().equals(""));
        assertThat(TodayDatePage9Pdf.getText(),equalTo(TodayDate));

        assertThat(PlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-").trim()));
>>>>>>> 63577b07189a74c5079081847dd5936cb94c46b8


    }
<<<<<<< HEAD
=======

>>>>>>> 63577b07189a74c5079081847dd5936cb94c46b8
}
