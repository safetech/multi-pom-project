package resources.pages.phonePages.uwExpansionPages;

import resources.entity.phone.CribSheet;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheatPage extends FluentPage{

    @FindBy(css = "#page-title")
    FluentWebElement pageTitle;
    FluentWebElement Prefix;
    FluentWebElement FirstName;
    FluentWebElement MI;
    FluentWebElement LastName;
    FluentWebElement Suffix;
    FluentWebElement AddressLine1;
    FluentWebElement AddressLine2;
    FluentWebElement City;
    FluentWebElement State;
    FluentWebElement ZipCode;
    FluentWebElement AARPMembershipNumber;
    FluentWebElement DOB;
    FluentWebElement Gender;
    FluentWebElement PhonePrimary;
    FluentWebElement PhoneEvening;
    FluentWebElement Email;
    FluentWebElement MPBED;
    FluentWebElement ReqEffectiveDate;
    FluentWebElement planCode;
    FluentWebElement HCSGApplicationId;
    FluentWebElement sourceCode;
    FluentWebElement AgentFullName;
    FluentWebElement QRIndicator;
    FluentWebElement generateXmlAndCheat;

    public String getUrl() {
        return "https://aarpsupplementalhealth-stg.uhc.com/ole/ms-phone.html?cheat=true";
    }
    public void fillAndSubmit(CribSheet sheet) {

        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
        isAt();

        (new Select(Prefix.getElement())).selectByValue(sheet.getPrefix());
        fill(FirstName).with(sheet.getFirstName());
        fill(MI).with(sheet.getMiddleInitial());
        fill(LastName).with(sheet.getLastName());
        (new Select(Suffix.getElement())).selectByValue(sheet.getSuffix());
        fill(AddressLine1).with(sheet.getAddressLine1());
        fill(AddressLine2).with(sheet.getAddressLine2());
        fill(City).with(sheet.getCity());
        fill(State).with(sheet.getState());
        fill(ZipCode).with(sheet.getZip());
        fill(AARPMembershipNumber).with(sheet.getMembershipNumber());
        fill(DOB).with(sheet.getDateOfBirth());
        fill(Gender).with(sheet.getGender());
        fill(PhonePrimary).with(sheet.getDayPhone());
        fill(PhoneEvening).with(sheet.getEveningPhone());
        fill(Email).with(sheet.getEmail());
        fill(MPBED).with(sheet.getMedPartBdate());
        fill(ReqEffectiveDate).with(sheet.getDpsd());
        fill(planCode).with(sheet.getPlanCode());
        fill(HCSGApplicationId).with(sheet.getHcsgApplicationId());
        fill(sourceCode).with(sheet.getSourceCode());
        fill(AgentFullName).with(sheet.getAgentFullName());
        fill(QRIndicator).with(sheet.getQrIndicator());
        generateXmlAndCheat.click();
        waitForSpinnerToFinish();
    }

    public void fillAndSubmitQrTest(CribSheet sheet) {
        isAt();

        (new Select(Prefix.getElement())).selectByValue(sheet.getPrefix());
        fill(FirstName).with(sheet.getFirstName());
        fill(MI).with(sheet.getMiddleInitial());
        fill(LastName).with(sheet.getLastName());
        (new Select(Suffix.getElement())).selectByValue(sheet.getSuffix());
        fill(AddressLine1).with(sheet.getAddressLine1());
        fill(AddressLine2).with(sheet.getAddressLine2());
        fill(City).with(sheet.getCity());
        fill(State).with(sheet.getState());
        fill(ZipCode).with(sheet.getZip());
        fill(AARPMembershipNumber).with(sheet.getMembershipNumber());
        fill(DOB).with(sheet.getDateOfBirth());
        fill(Gender).with(sheet.getGender());
        fill(PhonePrimary).with(sheet.getDayPhone());
        fill(PhoneEvening).with(sheet.getEveningPhone());
        fill(Email).with(sheet.getEmail());
        fill(MPBED).with(sheet.getMedPartBdate());
        fill(ReqEffectiveDate).with(sheet.getDpsd());
        fill(planCode).with(sheet.getPlanCode());
        fill(HCSGApplicationId).with(sheet.getHcsgApplicationId());
        fill(sourceCode).with(sheet.getSourceCode());
        fill(AgentFullName).with(sheet.getAgentFullName());
        fill(QRIndicator).with("N");
        generateXmlAndCheat.click();
        waitForSpinnerToFinish();
    }
    protected void waitForSpinnerToFinish() {
        await().atMost(25, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Cheat Page"));
    }

}
