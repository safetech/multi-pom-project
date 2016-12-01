package resources.pages.agentpages.uwExpansionPages;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerInformationPage extends WizardPage {

    private FluentWebElement AARPMembershipNumber;
    private FluentWebElement Prefix;
    FluentWebElement FirstName;
    private FluentWebElement MI;
    private FluentWebElement LastName;
    private FluentWebElement Suffix;
    private FluentWebElement AddressLine1;
    private FluentWebElement AddressLine2;
    private FluentWebElement City;
    private FluentWebElement State;
    private FluentWebElement ZipCode;
    private FluentWebElement Email;
    private @FindBy(css = "#na1110") FluentWebElement ConfirmEmail;
    private FluentWebElement PhonePrimary;
    private FluentWebElement PhoneEvening;
    private FluentWebElement DOB;
    private FluentWebElement Gender;
    private FluentWebElement MedicareClaimNum;
    private FluentWebElement MPBED;
    private FluentWebElement MPAED;
    private FluentWebElement AgentEmail;
    private FluentWebElement AgentEmailConfirm;

    private FluentWebElement MailingAddressLine1;
    private FluentWebElement MailingAddressLine2;
    private FluentWebElement MailingCity;
    private FluentWebElement MailingState;
    private FluentWebElement MailingZipCode;

    private @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
    private @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;
    private @FindBy(css = "#MailingAddressCheck_1") FluentWebElement MailingAddressCheck_Yes;
    private @FindBy(css = "#MailingAddressCheck_2") FluentWebElement MailingAddressCheck_No;
    
    public void fillAndSubmit(Application app) {
        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        fill(AARPMembershipNumber).with(app.getAARPMembershipNumber());
        fill(FirstName).with(app.getFirstName());
        fill(MI).with(app.getMI());
        fill(LastName).with(app.getLastName());
        fill(AddressLine1).with(app.getAddressLine1());
        fill(AddressLine2).with(app.getAddressLine2());
        fill(City).with(app.getCity());
        assertThat(State.getValue(), equalTo(app.getState()));
        fill(Email).with(app.getEmail());
        fill(ConfirmEmail).with(app.getConfirmEmail());
        fill(PhonePrimary).with(app.getPhonePrimary());
        assertThat(DOB.getValue(), equalTo(app.getDOB()));
        (new Select(Gender.getElement())).selectByValue(app.getGender());
        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());
        fill(AgentEmail).with(app.getAgentEmail());
        fill(AgentEmailConfirm).with(app.getAgentEmailConfirm());

        if (app.getMailingAddressCheck().equals(YES)) {
            MailingAddressCheck_Yes.click();
            fill(MailingAddressLine1).with(app.getAddressLine1());
            fill(MailingAddressLine2).with(app.getAddressLine2());
            fill(MailingCity).with(app.getMailingCity());
            (new Select(MailingState.getElement())).selectByValue(app.getMailingState());
            fill(MailingZipCode).with(app.getMailingZipCode());
        }else if (app.getMailingAddressCheck().equals(NO)) {
            MailingAddressCheck_No.click();
        } else if (app.getMailingAddressCheck().equals("")) {
            (new Select(Prefix.getElement())).selectByValue(app.getPrefix());
            (new Select(Suffix.getElement())).selectByValue(app.getSuffix());
            fill(PhoneEvening).with(app.getPhoneEvening());
        }

        app.getTest().log(LogStatus.INFO,"Clicking Next..");
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Customer Information"));
    }

}
