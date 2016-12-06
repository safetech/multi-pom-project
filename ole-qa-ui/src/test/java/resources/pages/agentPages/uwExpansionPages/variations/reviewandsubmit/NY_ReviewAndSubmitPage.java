package resources.pages.agentpages.uwExpansionPages.variations.reviewandsubmit;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
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

public class NY_ReviewAndSubmitPage extends WizardPage {

    private FluentWebElement requiredlink;
    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement applicationStatus;
    
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[103]") static FluentWebElement NyGiAarpMemberShipnumber;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[99]") static FluentWebElement NyGiFirstNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[90]") static FluentWebElement NyGiMiddleNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[88]") static FluentWebElement NyGiLastNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[95]") static FluentWebElement NyGiAddressOnePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[101]") static FluentWebElement NyGiCityPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[104]") static FluentWebElement NyGiStatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[100]") static FluentWebElement NyGiZipcodePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[92]") static FluentWebElement NyGiFirstNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[102]") static FluentWebElement NyGiMiddleNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[91]") static FluentWebElement NyGiLastNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[87]") static FluentWebElement NyGiMedicareClainNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[94]") static FluentWebElement NyGiSexPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[89]") static FluentWebElement NyGiHospitalPartADatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[105]") static FluentWebElement NyGiHospitalPartBDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[98]") static FluentWebElement NyGiMedicarePartABActivePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[86]") static FluentWebElement NyGiDateOfBirthPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[97]") static FluentWebElement NyGiPhoneNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[93]") static FluentWebElement NyGiEmailAddressPdf;
    //Page2g
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[53]") static FluentWebElement NyGiFirstNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[51]") static FluentWebElement NyGiLastNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[50]") static FluentWebElement NyGiPlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[52]") static FluentWebElement NyGiPlanStartDatePdf;
    //Page3g
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[68]") static FluentWebElement NyGiFirstNamePage3;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[66]") static FluentWebElement NyGiLastNamePage3;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[69]") static FluentWebElement NyGiCPATurned65;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[71]") static FluentWebElement NyGiCPAPartBIn6;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[67]") static FluentWebElement NyGiMedicarePartBYesDate;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[70]") static FluentWebElement NyGiMedicaidCovered;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[65]") static FluentWebElement NyGiOtherInsCoverage;
    
    //Page4g
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[70]") static FluentWebElement NyGiFirstNamePage4;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[67]") static FluentWebElement NyGiLastNamePage4;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[69]") static FluentWebElement NyGiExistingMedicare;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[68]") static FluentWebElement NyGiExistMedSupp;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[71]") static FluentWebElement NyGiTodayDatePage4;
    //Page5g
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[60]") static FluentWebElement NyGiFirstNamePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[57]") static FluentWebElement NyGiLastNamePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[58]") static FluentWebElement NyGiTodayDatePage5;
    //Page6g
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[77]") static FluentWebElement NyGiFirstNamePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[70]") static FluentWebElement NyGiLastNamePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[75]") static FluentWebElement NyGiAgentOtherInsPoliciesSold;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[74]") static FluentWebElement NyGiAgentPoliciesInForce;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[76]") static FluentWebElement NyGiAgentPoliciesSoldNotInForce;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[78]") static FluentWebElement NyGiAgentFirstName;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[81]") static FluentWebElement NyGiAgentMI;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[82]") static FluentWebElement NyGiAgentLastName;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[80]") static FluentWebElement NyGiAgentId;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[72]") static FluentWebElement NyGiAgentTodayDatePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[71]") static FluentWebElement NyGiAgentPhone;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[79]") static FluentWebElement NyGiAgentEmail;
    //Page7g
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[46]") static FluentWebElement NyGiEftPlanCode;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[48]") static FluentWebElement NyGiEftAppFirstName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[47]") static FluentWebElement NyGiEftAppMiddleName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[45]") static FluentWebElement NyGiEftAppLastName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[36]") static FluentWebElement NyGiEftAppAddress;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[42]") static FluentWebElement NyGiEftAddress2;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[40]") static FluentWebElement NyGiEftCity;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[41]") static FluentWebElement NyGiEftState;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[37]") static FluentWebElement NyGiEftZip;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[43]") static FluentWebElement NyGiEftBankName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[44]") static FluentWebElement NyGiEftRoutingNumber;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[38]") static FluentWebElement NyGiEftAccountNumber;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[49]") static FluentWebElement NyGiEftAccountType;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[39]") static FluentWebElement NyGiEftDate;

    //-------------------------------------------------------------------------------------------------------------//
    //Page1f
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[108]") static FluentWebElement ArFullAarpMemberShipnumber;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[103]") static FluentWebElement ArFullFirstNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[90]") static FluentWebElement ArFullMiddleNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[88]") static FluentWebElement ArFullLastNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[95]") static FluentWebElement ArFullAddressOnePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[96]") static FluentWebElement ArFullAddressTwoPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[106]") static FluentWebElement ArFullCityPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[109]") static FluentWebElement ArFullStatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[105]") static FluentWebElement ArFullZipcodePdf;        
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[97]") static FluentWebElement ArFullMailingAddress1;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[98]") static FluentWebElement ArFullMailingAddress2;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[101]") static FluentWebElement ArFullCity2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[100]") static FluentWebElement ArFullState2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[104]") static FluentWebElement ArFullZipcode2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[92]") static FluentWebElement ArFullFirstNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[107]") static FluentWebElement ArFullMiddleNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[91]") static FluentWebElement ArFullLastNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[87]") static FluentWebElement ArFullMedicareClainNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[94]") static FluentWebElement ArFullSexPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[89]") static FluentWebElement ArFullHospitalPartADatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[110]") static FluentWebElement ArFullHospitalPartBDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[102]") static FluentWebElement ArFullMedicarePartABActivePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[86]") static FluentWebElement ArFullDateOfBirthPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[99]") static FluentWebElement ArFullPhoneNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[93]") static FluentWebElement ArFullEmailAddressPdf;
    //Page2f
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[53]") static FluentWebElement ArFullFirstNamePage2;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[51]") static FluentWebElement ArFullLastNamePage2;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[50]") static FluentWebElement ArFullPlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[52]") static FluentWebElement ArFullPlanStartDatePdf;
    //Page3f
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[72]") static FluentWebElement ArFullFirstNamePage3;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[66]") static FluentWebElement ArFullLastNamePage3;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[73]") static FluentWebElement NyfullCPATurned65;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[76]") static FluentWebElement NyFullCPAPartBIn6;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[68]") static FluentWebElement NyFullMedicarePartBYesDate;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[74]") static FluentWebElement ArFullMedicaidCovered;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[71]") static FluentWebElement ArFullMedicaidPremium;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[70]") static FluentWebElement ArFullMedicaidbenefit;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[65]") static FluentWebElement ArFullExistingMedicare;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[77]") static FluentWebElement ArFullOtherMedplanstart;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[67]") static FluentWebElement ArFullOtherMedplanend;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[69]") static FluentWebElement ArFullIntentReplace;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[75]") static FluentWebElement ArFullFirstTime;
    @FindBy(xpath = "//*[@id='pageContainer3']/div[2]/div[78]") static FluentWebElement ArFullDropMedSuppForThisPlan;
    //Page4f
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[76]") static FluentWebElement ArFullFirstNamePage4;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[70]") static FluentWebElement ArFullLastNamePage4;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[73]") static FluentWebElement ArFullExistMedSupp;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[79]") static FluentWebElement ArFullMSInsCompany;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[67]") static FluentWebElement ArFullMSPLAN;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[68]") static FluentWebElement ArFullReplaceExistingMedSup;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[71]") static FluentWebElement ArFullOtherInsCoverage;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[78]") static FluentWebElement ArFullOtherInsCompany;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[75]") static FluentWebElement ArFullOtherInsType;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[69]") static FluentWebElement ArFullOtherInsStart;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[74]") static FluentWebElement ArFullOtherInsEnd;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[72]") static FluentWebElement ArFullOtherInsReplace;
    @FindBy(xpath = "//*[@id='pageContainer4']/div[2]/div[77]") static FluentWebElement ArFullTodayDatePage4;
    //Page5f
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[60]") static FluentWebElement ArFullFirstNamePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[57]") static FluentWebElement ArFullLastNamePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[58]") static FluentWebElement ArFullApp2SignaturePage5;
    @FindBy(xpath = "//*[@id='pageContainer5']/div[2]/div[59]") static FluentWebElement ArFullApp3SignaturePage5;
    //Page6f
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[77]") static FluentWebElement ArFullFirstNamePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[70]") static FluentWebElement ArFullLastNamePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[75]") static FluentWebElement NyFullAgentOtherInsPoliciesSold;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[74]") static FluentWebElement NyFullAgentPoliciesInForce;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[76]") static FluentWebElement NyFullAgentPoliciesSoldNotInForce;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[78]") static FluentWebElement NyFullAgentFirstName;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[81]") static FluentWebElement NyFullAgentMI;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[82]") static FluentWebElement NyFullAgentLastName;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[80]") static FluentWebElement NyFullAgentId;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[72]") static FluentWebElement NyFullAgentTodayDatePage6;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[79]") static FluentWebElement NyFullAgentEmail;
    @FindBy(xpath = "//*[@id='pageContainer6']/div[2]/div[71]") static FluentWebElement NyFullAgentPhone;
    //Page7f
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[57]") static FluentWebElement NyFullOtherReason;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[59]") static FluentWebElement NyFullRNOther;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[56]") static FluentWebElement NyFullAgentRnDate;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[61]") static FluentWebElement NyFullAppRnDate;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[60]") static FluentWebElement NyFullAppName;
    @FindBy(xpath = "//*[@id='pageContainer7']/div[2]/div[58]") static FluentWebElement NyFullAppAddress;
    //Page8f
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[46]") static FluentWebElement NyFullEftPlanCode;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[48]") static FluentWebElement NyFullEftAppFirstName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[47]") static FluentWebElement NyFullEftAppMiddleName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[45]") static FluentWebElement NyFullEftAppLastName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[36]") static FluentWebElement NyFullEftAppAddress;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[42]") static FluentWebElement NyFullEftAddress2;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[40]") static FluentWebElement NyFullEftCity;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[41]") static FluentWebElement NyFullEftState;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[37]") static FluentWebElement NyFullEftZip;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[43]") static FluentWebElement NyFullEftBankName;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[44]") static FluentWebElement NyFullEftRoutingNumber;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[38]") static FluentWebElement NyFullEftAccountNumber;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[49]") static FluentWebElement NyFullEftAccountType;
    @FindBy(xpath = "//*[@id='pageContainer8']/div[2]/div[39]") static FluentWebElement NyFullEftDate;
    
    
    String TodaysDate=new SimpleDateFormat("MM-dd-yyyy").format(new Date());


    public void fillAndSubmit(Application app) {

        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        requiredlink.click();
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        String baseWindowHdl = getDriver().getWindowHandle();
        getDriver().switchTo().window(windows.get(1)).manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String pdfUrl= getDriver().getCurrentUrl();
        System.out.println(pdfUrl);
        if(pdfUrl.contains("https://aarpsupplementalhealth-tst.uhc.com/")){
            pdfUrl=pdfUrl.replace("https://aarpsupplementalhealth-tst.uhc.com/","http://apsrt0786.uhc.com:8080/");
        }else
            pdfUrl.replace("https://aarpsupplementalhealth-stg.uhc.com/","http://apsrt0786.uhc.com:8080/");
        if(app.getMethodName().equals("AGENT_NewYork_GI")||(app.getMethodName().equals("AGENT_Arkansas_GI"))){
            ArGiPdfAssertions(app);
            PdfSignatureAssertions(pdfUrl,app.getMethodName());
        }else if(app.getMethodName().equals("AGENT_NewYork_Eligibility_FU_With_RN")||(app.getMethodName().equals("AGENT_NewYork_Eligibility_FU_With_RN"))){
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
        assertThat(NyGiAarpMemberShipnumber.getText(), equalTo(app.getAARPMembershipNumber()));
        assertThat(NyGiFirstNamePdf.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiMiddleNamePdf.getText(), equalTo(app.getMI()));
        assertThat(NyGiLastNamePdf.getText(), equalTo(app.getLastName()));
        assertThat(NyGiAddressOnePdf.getText(), equalTo(app.getAddressLine1()));
        assertThat(NyGiCityPdf.getText(), equalTo(app.getCity()));
        assertThat(NyGiStatePdf.getText(), equalTo(app.getState()));
        assertThat(NyGiZipcodePdf.getText(), equalTo(app.getZipCode()));
        assertThat(NyGiFirstNameOfBeneficiaryPdf.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiMiddleNameOfBeneficiaryPdf.getText(), equalTo(app.getMI()));
        assertThat(NyGiLastNameOfBeneficiaryPdf.getText(), equalTo(app.getLastName()));
        assertThat(NyGiMedicareClainNumberPdf.getText(), equalTo(app.getMedicareClaimNum()));
        assertThat(NyGiSexPdf.getText(), equalTo(app.getGender()));
        assertThat(NyGiHospitalPartADatePdf.getText(), equalTo(app.getMPAED().replace("/","-")));
        assertThat(NyGiHospitalPartBDatePdf.getText(), equalTo(app.getMPBED().replace("/","-")));
        assertThat(NyGiMedicarePartABActivePdf.getText().toLowerCase(), equalTo(YES));
        assertThat(NyGiDateOfBirthPdf.getText(), equalTo(app.getDOB().replace("/","-")));
        assertThat(NyGiPhoneNumberPdf.getText().replace("-",""), equalTo(app.getPhonePrimary()));
        assertThat(NyGiEmailAddressPdf.getText(), equalTo(app.getEmail()));
        gotoPdfpage(2);
        assertThat(NyGiFirstNamePage2Pdf.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiLastNamePage2Pdf.getText(), equalTo(app.getLastName()));
        assertThat(NyGiPlanBPdf.getText(), equalTo("B"));
        assertThat(NyGiPlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-").trim()));
        gotoPdfpage(3);
        assertThat(NyGiFirstNamePage3.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiLastNamePage3.getText(), equalTo(app.getLastName()));
        assertThat(NyGiCPATurned65.getText().toLowerCase(), equalTo(YES));
        assertThat(NyGiCPAPartBIn6.getText().toLowerCase(), equalTo(YES));
        assertThat(NyGiMedicarePartBYesDate.getText(), equalTo(app.getMPBED().replace("/","-").trim()));
        assertThat(NyGiMedicaidCovered.getText().toLowerCase(), equalTo(app.getMedicaidCovered()));
        assertThat(NyGiOtherInsCoverage.getText().toLowerCase(), equalTo(app.getOtherInsCoverage()));
        gotoPdfpage(4);
        assertThat(NyGiFirstNamePage4.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiLastNamePage4.getText(), equalTo(app.getLastName()));
        assertThat(NyGiExistingMedicare.getText().toLowerCase(), equalTo(app.getExistingMedicare()));
        assertThat(NyGiExistMedSupp.getText().toLowerCase(), equalTo(app.getExistMedSupp()));
        assertThat(NyGiTodayDatePage4.getText(), equalTo(TodaysDate));
        gotoPdfpage(5);
        assertThat(NyGiFirstNamePage5.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiLastNamePage5.getText(), equalTo(app.getLastName()));
        assertThat(NyGiTodayDatePage5.getText(), equalTo(TodaysDate));
        gotoPdfpage(6);
        assertThat(NyGiFirstNamePage6.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiLastNamePage6.getText(), equalTo(app.getLastName()));
        assertThat(NyGiAgentOtherInsPoliciesSold.getText(), equalTo(app.getAgentOtherInsPoliciesSold()));
        assertThat(NyGiAgentPoliciesInForce.getText(), equalTo(app.getAgentPoliciesInForce()));
        assertThat(NyGiAgentPoliciesSoldNotInForce.getText(), equalTo(app.getAgentPoliciesSoldNotInForce()));
        assertThat(NyGiAgentFirstName.getText(), equalTo(app.getAgentFirstName()));
        assertThat(NyGiAgentMI.getText(), equalTo(app.getAgentMI().trim()));
        assertThat(NyGiAgentLastName.getText(), equalTo(app.getAgentLastName()));
        assertThat(NyGiAgentId.getText(), equalTo("AutoTester"));
        assertThat(NyGiAgentTodayDatePage6.getText(), equalTo(TodaysDate));
        assertThat(NyGiAgentPhone.getText().replace("-",""), equalTo(app.getAgentPhone()));
        assertThat(NyGiAgentEmail.getText(), equalTo(app.getAgentEmail()));
        gotoPdfpage(7);
        assertThat(NyGiEftPlanCode.getText(), equalTo("B"));
        assertThat(NyGiEftAppFirstName.getText(), equalTo(app.getFirstName()));
        assertThat(NyGiEftAppMiddleName.getText(), equalTo(app.getMI()));
        assertThat(NyGiEftAppLastName.getText(), equalTo(app.getLastName()));
        assertThat(NyGiEftAppAddress.getText(), equalTo(app.getAddressLine1()));
        assertThat(NyGiEftAddress2.getText(), equalTo(app.getAddressLine2()));
        assertThat(NyGiEftCity.getText(), equalTo(app.getCity()));
        assertThat(NyGiEftState.getText(), equalTo(app.getState()));
        assertThat(NyGiEftZip.getText(), equalTo(app.getZipCode()));
        assertThat(NyGiEftBankName.getText(), equalTo(app.getBankName()));
        assertThat(NyGiEftRoutingNumber.getText(), equalTo(app.getRoutingNumber()));
        assertThat(NyGiEftAccountNumber.getText(), equalTo(app.getAccountNumber()));
        assertThat(NyGiEftAccountType.getText(), equalTo("Checking"));
        assertThat(NyGiEftDate.getText(), equalTo(TodaysDate));
    }
    public void ArFullUnderwritingPdfAssertions(Application app) {
        app.getTest().log(LogStatus.INFO,"Verifying Pdf..");
        assertThat(ArFullAarpMemberShipnumber.getText(), equalTo(app.getAARPMembershipNumber()));
        assertThat(ArFullFirstNamePdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullMiddleNamePdf.getText(), equalTo(app.getMI()));
        assertThat(ArFullLastNamePdf.getText(), equalTo(app.getLastName()));
        assertThat(ArFullAddressOnePdf.getText(), equalTo(app.getAddressLine1()));
        assertThat(ArFullAddressTwoPdf.getText(), equalTo(app.getAddressLine2()));
        assertThat(ArFullCityPdf.getText(), equalTo(app.getCity()));
        assertThat(ArFullStatePdf.getText(), equalTo(app.getState()));
        assertThat(ArFullZipcodePdf.getText(), equalTo(app.getZipCode()));
        assertThat(ArFullMailingAddress1.getText(), equalTo(app.getMailingAddressLine1()));
        assertThat(ArFullMailingAddress2.getText(), equalTo(app.getMailingAddressLine2()));
        assertThat(ArFullCity2Pdf.getText(), equalTo(app.getMailingCity()));
        assertThat(ArFullState2Pdf.getText(), equalTo(app.getMailingState()));
        assertThat(ArFullZipcode2Pdf.getText(), equalTo(app.getMailingZipCode()));
        assertThat(ArFullFirstNameOfBeneficiaryPdf.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullMiddleNameOfBeneficiaryPdf.getText(), equalTo(app.getMI()));
        assertThat(ArFullLastNameOfBeneficiaryPdf.getText(), equalTo(app.getLastName()));
        assertThat(ArFullMedicareClainNumberPdf.getText(), equalTo(app.getMedicareClaimNum()));
        assertThat(ArFullSexPdf.getText(), equalTo(app.getGender()));
        assertThat(ArFullHospitalPartADatePdf.getText(), equalTo(app.getMPAED().replace("/","-")));
        assertThat(ArFullHospitalPartBDatePdf.getText(), equalTo(app.getMPBED().replace("/","-")));
        assertThat(ArFullMedicarePartABActivePdf.getText().toLowerCase(), equalTo(YES));
        assertThat(ArFullDateOfBirthPdf.getText(), equalTo(app.getDOB().replace("/","-")));
        assertThat(ArFullPhoneNumberPdf.getText().replace("-",""), equalTo(app.getPhonePrimary()));
        assertThat(ArFullEmailAddressPdf.getText(), equalTo(app.getEmail()));
        gotoPdfpage(2);
        assertThat(ArFullFirstNamePage2.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage2.getText(), equalTo(app.getLastName()));
        assertThat(ArFullPlanBPdf.getText(), equalTo("B"));
        assertThat(ArFullPlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-").trim()));
        gotoPdfpage(3);
        assertThat(ArFullFirstNamePage3.getText(), equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage3.getText(), equalTo(app.getLastName()));
        assertThat(NyfullCPATurned65.getText().toLowerCase(), equalTo(NO));
        assertThat(NyFullCPAPartBIn6.getText().toLowerCase(), equalTo(NO));
        assertThat(NyFullMedicarePartBYesDate.getText(), equalTo(app.getMPBED().replace("/","-")));
        assertThat(ArFullMedicaidCovered.getText().toLowerCase(), equalTo(app.getMedicaidCovered()));
        assertThat(ArFullMedicaidPremium.getText().toLowerCase(), equalTo(app.getMedicaidSupPremium()));
        assertThat(ArFullMedicaidbenefit.getText().toLowerCase(), equalTo(app.getMedicaidbenefit()));
        assertThat(ArFullExistingMedicare.getText().toLowerCase(), equalTo(app.getExistingMedicare()));
        assertThat(ArFullOtherMedplanstart.getText(), equalTo(app.getOtherMedplanstart().replace("/","-")));
        assertThat(ArFullOtherMedplanend.getText(), equalTo(app.getOtherMedplanend().replace("/","-")));
        assertThat(ArFullIntentReplace.getText().toLowerCase(), equalTo(app.getIntentReplace()));
        assertThat(ArFullFirstTime.getText().toLowerCase(), equalTo(app.getFirstTime()));
        assertThat(ArFullDropMedSuppForThisPlan.getText().toLowerCase(), equalTo(app.getDropMedSuppForThisPlan()));
        gotoPdfpage(4);
        assertThat(ArFullFirstNamePage4.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage4.getText(),equalTo(app.getLastName()));
        assertThat(ArFullExistMedSupp.getText().toLowerCase(),equalTo(app.getExistMedSupp()));
        assertThat(ArFullMSInsCompany.getText(), equalTo(app.getMSInsCompany()));
        assertThat(ArFullMSPLAN.getText(),equalTo(app.getMSPLAN()));
        assertThat(ArFullReplaceExistingMedSup.getText().toLowerCase(),equalTo(app.getReplaceExistingMedSup()));
        assertThat(ArFullOtherInsCoverage.getText().toLowerCase(),equalTo(app.getOtherInsCoverage()));
        assertThat(ArFullOtherInsCompany.getText(), equalTo(app.getOtherInsCompany()));
        assertThat(ArFullOtherInsType.getText(),equalTo(app.getOtherInsType()));
        assertThat(ArFullOtherInsStart.getText(),equalTo(app.getOtherInsStart().replace("/","-").trim()));
        assertThat(ArFullOtherInsEnd.getText(),equalTo(app.getOtherInsEnd().replace("/","-").trim()));
        assertThat(ArFullOtherInsReplace.getText().toLowerCase(),equalTo(app.getOtherInsReplace()));
        assertThat(ArFullTodayDatePage4.getText(),equalTo(TodaysDate));
        gotoPdfpage(5);
        assertThat(ArFullFirstNamePage5.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage5.getText(),equalTo(app.getLastName()));
        assertThat(ArFullApp2SignaturePage5.getText(), equalTo(TodaysDate));
        assertThat(ArFullApp3SignaturePage5.getText(), equalTo(TodaysDate));
        gotoPdfpage(6);
        assertThat(ArFullFirstNamePage6.getText(),equalTo(app.getFirstName()));
        assertThat(ArFullLastNamePage6.getText(),equalTo(app.getLastName()));
        assertThat(NyFullAgentOtherInsPoliciesSold.getText(), equalTo(app.getAgentOtherInsPoliciesSold()));
        assertThat(NyFullAgentPoliciesInForce.getText(), equalTo(app.getAgentPoliciesInForce()));
        assertThat(NyFullAgentPoliciesSoldNotInForce.getText(), equalTo(app.getAgentPoliciesSoldNotInForce()));
        assertThat(NyFullAgentFirstName.getText(), equalTo(app.getAgentFirstName()));
        assertThat(NyFullAgentMI.getText(), equalTo(app.getAgentMI().trim()));
        assertThat(NyFullAgentLastName.getText(), equalTo(app.getAgentLastName()));
        assertThat(NyFullAgentId.getText(), equalTo("AutoTester"));
        assertThat(NyFullAgentTodayDatePage6.getText(), equalTo(TodaysDate));
        assertThat(NyFullAgentEmail.getText(), equalTo(app.getAgentEmail()));
        assertThat(NyFullAgentPhone.getText().replace("-",""), equalTo(app.getAgentPhone()));
        gotoPdfpage(7);
        assertThat(NyFullOtherReason.getText(),equalTo("OtherReason"));
        assertThat(NyFullRNOther.getText(),equalTo(app.getRNOther()));
        assertThat(NyFullAgentRnDate.getText(),equalTo(TodaysDate));
        assertThat(NyFullAppRnDate.getText(),equalTo(TodaysDate));
        assertThat(NyFullAppName.getText(),equalTo(app.getApplicantPrintedNameAdd()));
        assertThat(NyFullAppAddress.getText(),equalTo(app.getApplicantAddress()));
        gotoPdfpage(8);
        assertThat(NyFullEftPlanCode.getText(), equalTo("B"));
        assertThat(NyFullEftAppFirstName.getText(), equalTo(app.getFirstName()));
        assertThat(NyFullEftAppMiddleName.getText(), equalTo(app.getMI()));
        assertThat(NyFullEftAppLastName.getText(), equalTo(app.getLastName()));
        assertThat(NyFullEftAppAddress.getText(), equalTo(app.getAddressLine1()));
        assertThat(NyFullEftAddress2.getText(), equalTo(app.getAddressLine2()));
        assertThat(NyFullEftCity.getText(), equalTo(app.getCity()));
        assertThat(NyFullEftState.getText(), equalTo(app.getState()));
        assertThat(NyFullEftZip.getText(), equalTo(app.getZipCode()));
        assertThat(NyFullEftBankName.getText(), equalTo(app.getBankName()));
        assertThat(NyFullEftRoutingNumber.getText(), equalTo(app.getRoutingNumber()));
        assertThat(NyFullEftAccountNumber.getText(), equalTo(app.getAccountNumber()));
        assertThat(NyFullEftAccountType.getText(), equalTo("Checking"));
        assertThat(NyFullEftDate.getText(), equalTo(TodaysDate));
        
    }

    
}
