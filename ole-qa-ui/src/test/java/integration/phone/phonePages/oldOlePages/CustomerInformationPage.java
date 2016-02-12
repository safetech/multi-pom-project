package integration.phone.phonePages.oldOlePages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerInformationPage extends WizardPage {

    FluentWebElement MedicareClaimNum;
    FluentWebElement MPAED;
    FluentWebElement MPBED;
    FluentWebElement Email;
    @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
    @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 6;

    public void verifyCustomerInfo(Application app) {
        assertTextSubValue("Prefix", app.getPrefix());
        assertTextSubValue("FirstName", app.getFirstName());
        assertTextSubValue("MI", app.getMI());
        assertTextSubValue("LastName", app.getLastName());
        assertTextSubValue("Suffix", app.getSuffix());
        assertTextSubValue("AddressLine1", app.getAddressLine1());
        assertTextSubValue("AddressLine2", app.getAddressLine2());
        assertTextSubValue("City", app.getCity());
        assertTextSubValue("State", app.getState());
        assertTextSubValue("ZipCode", app.getZipCode());
        assertTextSubValue("DOB", app.getDOB());
        assertTextSubValue("Gender", app.getGender());
        assertTextSubValue("PhonePrimary", app.getPhonePrimary());
        assertTextSubValue("PhoneEvening", app.getPhoneEvening());
        assertTextSubValue("AARPMembershipNumber", app.getAARPMembershipNumber());
    }

    public void verifyInitialStateOfElements(Application app) {
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

        verifyCustomerInfo(app);

        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fill(MPBED).with(app.getMPBED());
        fill(Email).with(app.getEmail());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
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
