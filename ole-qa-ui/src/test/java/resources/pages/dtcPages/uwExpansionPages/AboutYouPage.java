package resources.pages.dtcpages.uwExpansionPages;

import resources.entity.Application;
import resources.entity.dtc.CribSheet;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AboutYouPage extends WizardPage{
    
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
    FluentWebElement MailingAddressLine1;
    FluentWebElement MailingAddressLine2;
    FluentWebElement MailingCity;
    FluentWebElement MailingState;
    FluentWebElement MailingZipCode;

        @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
        @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;
        @FindBy(css = "#MailingAddressCheck_1") FluentWebElement MailingAddressCheck_Yes;
        @FindBy(css = "#MailingAddressCheck_2") FluentWebElement MailingAddressCheck_No;
    
    public void fillAndSubmit(Application app, CribSheet sheet) {
        isAt();

        fill(AARPMembershipNumber).with(app.getAARPMembershipNumber());
        fill(FirstName).with(app.getFirstName());
        fill(MI).with(app.getMI());
        fill(LastName).with(app.getLastName());
        fill(AddressLine1).with(app.getAddressLine1());
        fill(AddressLine2).with(app.getAddressLine2());
        fill(City).with(app.getCity());
        assertThat(State.getValue(), equalTo(sheet.getState()));
        assertThat(ZipCode.getValue(), equalTo(sheet.getZip()));
        fill(Email).with(app.getEmail());
        fill(ConfirmEmail).with(app.getConfirmEmail());
        fill(PhonePrimary).with(app.getPhonePrimary());
        assertThat(DOB.getValue(), equalTo(sheet.getDOB()));
        (new Select(Gender.getElement())).selectByValue(app.getGender());
        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        assertThat(MPBED.getValue(), equalTo(sheet.getEffDate()));
        fill(MPAED).with(app.getMPAED());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());

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

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("About You"));
    }

}
