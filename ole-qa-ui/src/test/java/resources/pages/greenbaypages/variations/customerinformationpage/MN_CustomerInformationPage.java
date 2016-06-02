package resources.pages.greenbaypages.variations.customerinformationpage;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MN_CustomerInformationPage extends WizardPage {
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
    @FindBy(css = "#na1110") FluentWebElement ConfirmEmail;
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
   
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 27;

    public void setCustomerInfo(Application app) {
                //fill(AARPMembershipNumber).with(app.getAARPMembershipNumber()); TODO:Challenging field to fill with AARP Num
        
        fill(FirstName).with(app.getFirstName());
        fill(MI).with(app.getMI());
        fill(LastName).with(app.getLastName());
        fill(AddressLine1).with(app.getAddressLine1());
        fill(AddressLine2).with(app.getAddressLine2());
        fill(City).with(app.getCity());
        fill(Email).with(app.getEmail());
        fill(PhonePrimary).with(app.getPhonePrimary());
        fill(PhoneEvening).with(app.getPhoneEvening());
        assertThat(MPBED.getValue(), equalTo(app.getMPBED()));
        assertThat(DOB.getValue(), equalTo(app.getDOB()));
        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());
        (new Select(Gender.getElement())).selectByValue(app.getGender());
        
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
    }

    public void verifyInitialStateOfElements(Application app) {
        isAt();
        assertThat(State.getValue(), equalTo(app.getState()));
        assertThat(ZipCode.getValue(), equalTo(app.getZipCode()));
        assertThat(DOB.getValue(), equalTo(app.getDOB()));
        assertBlank(Gender);
        assertBlank(MedicareClaimNum,
                Email,
                MPAED);
        assertThat(MPBED.getValue(), equalTo(app.getMPBED()));
        assertBlank(PartABActiveIndicator_Yes,
                PartABActiveIndicator_No);
    }

    public void fillAndSubmit(Application app) {
        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        verifyInitialStateOfElements(app);
        setCustomerInfo(app);
        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish(8);
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(MedicareClaimNum,
                Email,
                MPAED,
                MPBED,
                PartABActiveIndicator_Yes,
                PartABActiveIndicator_No);
        assertThat(MedicareClaimNum.getValue(), equalTo(app.getMedicareClaimNum()));
        assertThat(MPAED.getValue(), equalTo(app.getMPAED()));
        assertThat(MPBED.getValue(), equalTo(app.getMPBED()));
        assertThat(Email.getValue(), equalTo(app.getEmail()));
        assertYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Customer Information"));
    }
}
