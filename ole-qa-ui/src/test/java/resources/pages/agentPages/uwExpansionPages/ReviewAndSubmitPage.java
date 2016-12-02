package resources.pages.agentpages.uwExpansionPages;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
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

    //Page1f
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
    //Page2f
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[79]") static FluentWebElement ArFullFirstNamePage2;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[76]") static FluentWebElement ArFullLastNamePage2;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[75]") static FluentWebElement ArFullPlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[78]") static FluentWebElement ArFullPlanStartDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[82]") static FluentWebElement ArFullPlanEffIn6OfEligible;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[81]") static FluentWebElement ArFullLostCoverage;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[77]") static FluentWebElement ArFullKidneyProblem;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[80]") static FluentWebElement ArFullEligibilitySurgery;
    //Page3f
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[67]") static FluentWebElement ArFullAdmitToHospPast90Days;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[64]") static FluentWebElement ArFullNursingFacility;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[61]") static FluentWebElement ArFullESRD;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[69]") static FluentWebElement ArFullFirstNamePage3;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[62]") static FluentWebElement ArFullLastNamePage3;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[68]") static FluentWebElement ArFullArteryorVeinBlockage;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[65]") static FluentWebElement ArFullPeripheralVascularDisease;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[63]") static FluentWebElement ArFullCardiomyopathy;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[66]") static FluentWebElement ArFullCongestiveHeartFailure;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[74]") static FluentWebElement ArFullCoronaryArteryDisease;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[75]") static FluentWebElement ArFullChronicLungDisease;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[70]") static FluentWebElement ArFullChronicKidneyDisease;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[72]") static FluentWebElement ArFullDiabetes;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[71]") static FluentWebElement ArFullCancer;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[73]") static FluentWebElement ArFullCirrhosisDisease;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[60]") static FluentWebElement ArFullEligibilityHeartAttackTIAStroke;
    //Page4f
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[67]") static FluentWebElement ArFullFirstNamePage4;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[62]") static FluentWebElement ArFullLastNamePage4;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[64]") static FluentWebElement ArFullTobaccoUse;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[68]") static FluentWebElement ArFullMedicaidCovered;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[66]") static FluentWebElement ArFullMedicaidSupPremium;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[65]") static FluentWebElement ArFullMedicaidbenefit;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[61]") static FluentWebElement ArFullExistingMedicare;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[69]") static FluentWebElement ArFullOtherMedplanstart;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[63]") static FluentWebElement ArFullOtherMedplanend;
    //Page5f
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[79]") static FluentWebElement ArFullFirstNamePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[72]") static FluentWebElement ArFullLastNamePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[74]") static FluentWebElement ArFullIntentReplace;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[82]") static FluentWebElement ArFullFirstTime;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[84]") static FluentWebElement ArFullDropMedSuppForThisPlan;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[76]") static FluentWebElement ArFullExistMedSupp;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[83]") static FluentWebElement ArFullMSInsCompany;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[69]") static FluentWebElement ArFullMSPLAN;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[70]") static FluentWebElement ArFullReplaceExistingMedSup;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[73]") static FluentWebElement ArFullOtherInsCoverage;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[81]") static FluentWebElement ArFullOtherInsCompany;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[78]") static FluentWebElement ArFullOtherInsType;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[71]") static FluentWebElement ArFullOtherInsStart;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[77]") static FluentWebElement ArFullOtherInsEnd;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[75]") static FluentWebElement ArFullOtherInsReplace;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[80]") static FluentWebElement ArFullTodayDatePage5;
   //Page6f
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[60]") static FluentWebElement ArFullFirstNamePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[58]") static FluentWebElement ArFullLastNamePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[59]") static FluentWebElement ArFullTodayDatePage6;
    //Page7f
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[75]") static FluentWebElement ArFullFirstNamePage7;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[67]") static FluentWebElement ArFullLastNamePage7;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[73]") static FluentWebElement ArFullTodayDatePage7;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[72]") static FluentWebElement ArFullAgentOtherInsPoliciesSold;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[71]") static FluentWebElement ArFullAgentPoliciesInForce;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[74]") static FluentWebElement ArFullAgentPoliciesSoldNotInForce;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[76]") static FluentWebElement ArFullAgentFirstName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[79]") static FluentWebElement ArFullAgentMI;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[80]") static FluentWebElement ArFullAgentLastName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[78]") static FluentWebElement ArFullAgentId;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[69]") static FluentWebElement ArFullAgentTodayDatePage7;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[68]") static FluentWebElement ArFullAgentPhone;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[77]") static FluentWebElement ArFullAgentEmail;
    //Page8f
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[75]") static FluentWebElement ArFullOtherReason;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[71]") static FluentWebElement ArFullRNOther;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[74]") static FluentWebElement ArFullAgentRnDate;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[73]") static FluentWebElement ArFullAppRnDate;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[72]") static FluentWebElement ArFullAppName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[70]") static FluentWebElement ArFullAppAddress;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[76]") static FluentWebElement ArFullAgentBrokerDate;
    //Page9f
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[46]") static FluentWebElement ArFullEftPlanCode;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[48]") static FluentWebElement ArFullEftAppFirstName;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[47]") static FluentWebElement ArFullEftAppMiddleName;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[45]") static FluentWebElement ArFullEftAppLastName;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[36]") static FluentWebElement ArFullEftAppAddress;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[42]") static FluentWebElement ArFullEftAddress2;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[40]") static FluentWebElement ArFullEftCity;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[41]") static FluentWebElement ArFullEftState;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[37]") static FluentWebElement ArFullEftZip;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[43]") static FluentWebElement ArFullEftBankName;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[44]") static FluentWebElement ArFullEftRoutingNumber;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[38]") static FluentWebElement ArFullEftAccountNumber;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[49]") static FluentWebElement ArFullEftAccountType;
    @FindBy(xpath = "//*[@id='pageContainer9']/div[2]/div[39]") static FluentWebElement ArFullEftDate;
    
    String TodaysDate=new SimpleDateFormat("MM-dd-yyyy").format(new Date());


    public void fillAndSubmit(Application app) {

        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        requiredlink.click();
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        String baseWindowHdl = getDriver().getWindowHandle();
        getDriver().switchTo().window(windows.get(1)).manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String pdfUrl= getDriver().getCurrentUrl();
        if(pdfUrl.contains("https://aarpsupplementalhealth-tst.uhc.com/")){
            pdfUrl=pdfUrl.replace("https://aarpsupplementalhealth-tst.uhc.com/","http://apsrt0786.uhc.com:8080/");
        }else
            pdfUrl.replace("https://aarpsupplementalhealth-stg.uhc.com/","http://apsrt0786.uhc.com:8080/");
        if(app.getMethodName().equals("AGENT_Arkansas_GI")){
            ArGiPdfAssertions(app);
            PdfSignatureAssertions(pdfUrl,app.getMethodName());
        }else if(app.getMethodName().equals("AGENT_Arkansas_Eligibility_FU_With_RN"))
        {
            ArFullUnderwritingPdfAssertions(app);
            PdfSignatureAssertions(pdfUrl,app.getMethodName());
        }
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
        assertThat(ArFullFirstNamePage2.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage2.getText(), equalTo(app.getLastName()));
        assertThat(ArFullPlanBPdf.getText(), equalTo("B"));
        assertThat(ArFullPlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-").trim()));
        assertThat(ArFullPlanEffIn6OfEligible.getText().toLowerCase(),equalTo(app.getPlanEffIn6OfEligible()));
        assertThat(ArFullLostCoverage.getText().toLowerCase(),equalTo(app.getLostCoverage()));
        assertThat(ArFullKidneyProblem.getText().toLowerCase(),equalTo(app.getKidneyProblem()));
        assertThat(ArFullEligibilitySurgery.getText().toLowerCase(),equalTo(app.getEligibilitySurgery()));
        gotoPdfpage(3);
        assertThat(ArFullAdmitToHospPast90Days.getText().toLowerCase(),equalTo(app.getEligibilityAdmitToHospPast90Days()));
        assertThat(ArFullNursingFacility.getText().toLowerCase(),equalTo(app.getNursingFacility()));
        assertThat(ArFullESRD.getText().toLowerCase(),equalTo(app.getESRD()));
        assertThat(ArFullFirstNamePage3.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage3.getText(),equalTo(app.getLastName()));
        assertThat(ArFullArteryorVeinBlockage.getText().toLowerCase(),equalTo(app.getArteryorVeinBlockage()));
        assertThat(ArFullPeripheralVascularDisease.getText().toLowerCase(),equalTo(app.getPeripheralVascularDisease()));
        assertThat(ArFullCardiomyopathy.getText().toLowerCase(),equalTo(app.getCardiomyopathy()));
        assertThat(ArFullCongestiveHeartFailure.getText().toLowerCase(),equalTo(app.getCongestiveHeartFailure()));
        assertThat(ArFullCoronaryArteryDisease.getText().toLowerCase(),equalTo(app.getCoronaryArteryDisease()));
        assertThat(ArFullChronicLungDisease.getText().toLowerCase(),equalTo(app.getChronicLungDisease()));
        assertThat(ArFullChronicKidneyDisease.getText().toLowerCase(),equalTo(app.getChronicKidneyDisease()));
        assertThat(ArFullDiabetes.getText().toLowerCase(),equalTo(app.getDiabetes()));
        assertThat(ArFullCancer.getText().toLowerCase(),equalTo(app.getCancer()));
        assertThat(ArFullCirrhosisDisease.getText().toLowerCase(),equalTo(app.getCirrhosisDisease()));
        assertThat(ArFullEligibilityHeartAttackTIAStroke.getText().toLowerCase(),equalTo(app.getEligibilityHeartAttackTIAStroke()));
        gotoPdfpage(4);
        assertThat(ArFullFirstNamePage4.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage4.getText(),equalTo(app.getLastName()));
        assertThat(ArFullTobaccoUse.getText().toLowerCase(),equalTo(app.getTobaccoUse()));
        assertThat(ArFullMedicaidCovered.getText().toLowerCase(),equalTo(app.getMedicaidCovered()));
        assertThat(ArFullMedicaidSupPremium.getText().toLowerCase(),equalTo(app.getMedicaidSupPremium()));
        assertThat(ArFullMedicaidbenefit.getText().toLowerCase(),equalTo(app.getMedicaidbenefit()));
        assertThat(ArFullExistingMedicare.getText().toLowerCase(),equalTo(app.getExistingMedicare()));
        assertThat(ArFullOtherMedplanstart.getText(),equalTo(app.getOtherMedplanstart().replace("/","-").trim()));
        assertThat(ArFullOtherMedplanend.getText(),equalTo(app.getOtherMedplanend().replace("/","-").trim()));
        gotoPdfpage(5);
        assertThat(ArFullFirstNamePage5.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage5.getText(),equalTo(app.getLastName()));
        assertThat(ArFullIntentReplace.getText().toLowerCase(),equalTo(app.getIntentReplace()));
        assertThat(ArFullFirstTime.getText().toLowerCase(),equalTo(app.getFirstTime()));
        assertThat(ArFullDropMedSuppForThisPlan.getText().toLowerCase(),equalTo(app.getDropMedSuppForThisPlan()));
        assertThat(ArFullExistMedSupp.getText().toLowerCase(),equalTo(app.getExistMedSupp()));
        assertThat(ArFullMSInsCompany.getText(),equalTo(app.getMSInsCompany()));
        assertThat(ArFullMSPLAN.getText(),equalTo(app.getMSPLAN()));
        assertThat(ArFullReplaceExistingMedSup.getText().toLowerCase(),equalTo(app.getReplaceExistingMedSup()));
        assertThat(ArFullOtherInsCoverage.getText().toLowerCase(),equalTo(app.getOtherInsCoverage()));
        assertThat(ArFullOtherInsCompany.getText(),equalTo(app.getOtherInsCompany()));
        assertThat(ArFullOtherInsType.getText(),equalTo(app.getOtherInsType()));
        assertThat(ArFullOtherInsStart.getText(),equalTo(app.getOtherInsStart().replace("/","-").trim()));
        assertThat(ArFullOtherInsEnd.getText(),equalTo(app.getOtherInsEnd().replace("/","-").trim()));
        assertThat(ArFullOtherInsReplace.getText().toLowerCase(),equalTo(app.getOtherInsReplace()));
        assertThat(ArFullTodayDatePage5.getText(),equalTo(TodaysDate));
        gotoPdfpage(6);
        assertThat(ArFullFirstNamePage6.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage6.getText(),equalTo(app.getLastName()));
        assertThat(ArFullTodayDatePage6.getText(),equalTo(TodaysDate));
        gotoPdfpage(7);
        assertThat(ArFullFirstNamePage7.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage7.getText(),equalTo(app.getLastName()));
        assertThat(ArFullTodayDatePage7.getText(),equalTo(TodaysDate));
        assertThat(ArFullAgentOtherInsPoliciesSold.getText(),equalTo(app.getAgentOtherInsPoliciesSold()));
        assertThat(ArFullAgentPoliciesInForce.getText(),equalTo(app.getAgentPoliciesInForce()));
        assertThat(ArFullAgentPoliciesSoldNotInForce.getText(),equalTo(app.getAgentPoliciesSoldNotInForce()));
        assertThat(ArFullAgentFirstName.getText(),equalTo(app.getAgentFirstName()));
        assertThat(ArFullAgentMI.getText(),equalTo(app.getAgentMI().trim()));
        assertThat(ArFullAgentLastName.getText(),equalTo(app.getAgentLastName()));
        assertThat(ArFullAgentId.getText(),equalTo("AutoTester"));
        assertThat(ArFullAgentTodayDatePage7.getText(),equalTo(TodaysDate));
        assertThat(ArFullAgentPhone.getText().replace("-",""),equalTo(app.getAgentPhone()));
        assertThat(ArFullAgentEmail.getText(),equalTo(app.getAgentEmail()));
        gotoPdfpage(8);
        assertThat(ArFullOtherReason.getText(),equalTo("OtherReason"));
        assertThat(ArFullRNOther.getText(),equalTo(app.getRNOther()));
        assertThat(ArFullAgentRnDate.getText(),equalTo(TodaysDate));
        assertThat(ArFullAppRnDate.getText(),equalTo(TodaysDate));
        assertThat(ArFullAppName.getText(),equalTo(app.getApplicantPrintedNameAdd()));
        assertThat(ArFullAppAddress.getText(),equalTo(app.getApplicantAddress()));
        assertThat(ArFullAgentBrokerDate.getText().replace("/","-"),equalTo(TodaysDate));
        gotoPdfpage(9);
        assertThat(ArFullEftPlanCode.getText(),equalTo("B"));
        assertThat(ArFullEftAppFirstName.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullEftAppMiddleName.getText(),equalTo(app.getMI().trim()));
        assertThat(ArFullEftAppLastName.getText(),equalTo(app.getLastName()));
        assertThat(ArFullEftAppAddress.getText(),equalTo(app.getAddressLine1()));
        assertThat(ArFullEftAddress2.getText(),equalTo(app.getAddressLine2()));
        assertThat(ArFullEftCity.getText(),equalTo(app.getCity()));
        assertThat(ArFullEftState.getText(),equalTo(app.getState()));
        assertThat(ArFullEftZip.getText(),equalTo(app.getZipCode()));
        assertThat(ArFullEftBankName.getText(),equalTo(app.getBankName()));
        assertThat(ArFullEftRoutingNumber.getText(),equalTo(app.getRoutingNumber()));
        assertThat(ArFullEftAccountNumber.getText(),equalTo(app.getAccountNumber()));
        assertThat(ArFullEftAccountType.getText(),equalTo("Checking"));
        assertThat(ArFullEftDate.getText(),equalTo(TodaysDate));
    }
    public void gotoPdfpage(int pageNumber){
        if(System.getProperty("os.name").toLowerCase().contains("mac")){
        getDriver().findElement(By.id("pageNumber")).sendKeys(Keys.COMMAND+"a");
        getDriver().findElement(By.id("pageNumber")).sendKeys(pageNumber+"\r");
        }
        else{
            getDriver().findElement(By.id("pageNumber")).sendKeys(Keys.CONTROL+"a");
            getDriver().findElement(By.id("pageNumber")).sendKeys(pageNumber+"\r");
            
        }
    }
    
}
