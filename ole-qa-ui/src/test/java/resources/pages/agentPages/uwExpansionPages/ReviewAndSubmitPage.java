package resources.pages.agentpages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReviewAndSubmitPage extends WizardPage {

    private FluentWebElement requiredlink;
    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement applicationStatus;
    
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[83]") FluentWebElement AarpMemberShipnumber;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[79]") FluentWebElement FirstNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[71]") FluentWebElement MiddleNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[69]") FluentWebElement LastNamePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[76]") FluentWebElement AddressOnePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[81]") FluentWebElement CityPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[84]") FluentWebElement StatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[80]") FluentWebElement ZipcodePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[73]") FluentWebElement FirstNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[82]") FluentWebElement MiddleNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[72]") FluentWebElement LastNameOfBeneficiaryPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[68]") FluentWebElement MedicareClainNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[75]") FluentWebElement SexPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[70]") FluentWebElement HospitalPartADatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[85]") FluentWebElement HospitalPartBDatePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[78]") FluentWebElement MedicarePartABActivePdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[67]") FluentWebElement DateOfBirthPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[77]") FluentWebElement PhoneNumberPdf;
    @FindBy(xpath = "//*[@id='pageContainer1']/div[2]/div[74]") FluentWebElement EmailAddressPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[141]") FluentWebElement FirstNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[139]") FluentWebElement LastNamePage2Pdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[138]") FluentWebElement PlanBPdf;
    @FindBy(xpath = "//*[@id='pageContainer2']/div[2]/div[140]") FluentWebElement PlanStartDatePdf;
    

    public void fillAndSubmit(Application app) {

        isAt();
        requiredlink.click();
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        String baseWindowHdl = getDriver().getWindowHandle();
        getDriver().switchTo().window(windows.get(1));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PdfAssertions(app);
        
        getDriver().switchTo().window(baseWindowHdl);
        closeSpecificBrowser(1);

        click(WIZARD_PAGE_NEXT_BTN_SELECTOR);
        await().atMost(40, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }
    
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Review and Submit"));

    }    
    public void PdfAssertions(Application app) {
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
        assertThat(MedicarePartABActivePdf.getText(), equalTo("yes"));
        assertThat(DateOfBirthPdf.getText(), equalTo(app.getDOB().replace("/","-")));
        assertThat(PhoneNumberPdf.getText().replace("-",""), equalTo(app.getPhonePrimary()));
        assertThat(EmailAddressPdf.getText(), equalTo(app.getEmail()));
        assertThat(FirstNamePage2Pdf.getText(), equalTo(app.getFirstName()));
        assertThat(LastNamePage2Pdf.getText(), equalTo(app.getLastName()));
        assertThat(PlanBPdf.getText(), equalTo("B"));
        assertThat(PlanStartDatePdf.getText(), equalTo(app.getReqEffectiveDate().replace("/","-")));

    }
    
}
