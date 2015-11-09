package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerInformationPage extends WizardPage{
    
        FluentWebElement AARPMembershipNumber;
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
        FluentWebElement Email;
        @FindBy(css = "#na1110")
        FluentWebElement ConfirmEmail;
        FluentWebElement PhonePrimary;
        FluentWebElement PhoneEvening;
        FluentWebElement DOB;
        FluentWebElement Gender;
        FluentWebElement MedicareClaimNum;
        FluentWebElement MPBED;
        FluentWebElement MPAED;
        FluentWebElement AgentEmail;
        FluentWebElement AgentEmailConfirm;

        FluentWebElement MailingAddressLine1;
        FluentWebElement MailingAddressLine2;
        FluentWebElement MailingCity;
        FluentWebElement MailingState;
        FluentWebElement MailingZipCode;

        @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
        @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;

    
    public void fillAndSubmit(Application app) {
        isAt();
        fill(AARPMembershipNumber).with(app.getAARPMembershipNumber());
        (new Select(Prefix.getElement())).selectByValue(app.getPrefix());
        fill(FirstName).with(app.getFirstName());
        fill(MI).with(app.getMI());
        fill(LastName).with(app.getLastName());
        (new Select(Suffix.getElement())).selectByValue(app.getSuffix());
        fill(AddressLine1).with(app.getAddressLine1());
        fill(AddressLine2).with(app.getAddressLine2());
        fill(City).with(app.getCity());
        assertThat(State.getValue(), equalTo(app.getState()));
        fill(Email).with(app.getEmail());
        fill(ConfirmEmail).with(app.getConfirmEmail());
        fill(PhonePrimary).with(app.getPhonePrimary());
        fill(PhoneEvening).with(app.getPhoneEvening());
        // fill(DOB).with(sheet.getDOB());
        (new Select(Gender.getElement())).selectByValue(app.getGender());
        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());
        fill(AgentEmail).with(app.getAgentEmail());
        fill(AgentEmailConfirm).with(app.getAgentEmailConfirm());

        if (app.getMailingAddressCheck().equals(YES)) {
            fill(MailingAddressLine1).with(app.getAddressLine1());
            fill(MailingAddressLine2).with(app.getAddressLine2());
            fill(MailingCity).with(app.getMailingCity());
            (new Select(MailingState.getElement())).selectByValue(app.getMailingState());
            fill(MailingZipCode).with(app.getMailingZipCode());

        }

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Customer Information"));
    }

}
