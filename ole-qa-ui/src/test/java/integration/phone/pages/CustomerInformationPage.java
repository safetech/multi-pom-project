package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.Fluent;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerInformationPage extends WizardPage{

    FluentWebElement MedicareClaimNum;
    FluentWebElement MPAED;
    FluentWebElement MPBED;
    FluentWebElement Email;
    @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
    @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 6;

    public void verifyCustomerInfo(Application app) {
        assertThat(getTextSubValue("Prefix").getText(), equalTo(app.getPrefix()));
        assertThat(getTextSubValue("FirstName").getText(), equalTo(app.getFirstName()));
        assertThat(getTextSubValue("MI").getText(), equalTo(app.getMI()));
        assertThat(getTextSubValue("LastName").getText(), equalTo(app.getLastName()));
        assertThat(getTextSubValue("Suffix").getText(), equalTo(app.getSuffix()));
        assertThat(getTextSubValue("AddressLine1").getText(), equalTo(app.getAddressLine1()));
        assertThat(getTextSubValue("AddressLine2").getText(), equalTo(app.getAddressLine2()));
        assertThat(getTextSubValue("City").getText(), equalTo(app.getCity()));
        assertThat(getTextSubValue("State").getText(), equalTo(app.getState()));
        assertThat(getTextSubValue("ZipCode").getText(), equalTo(app.getZipCode()));
        assertThat(getTextSubValue("DOB").getText(), equalTo(app.getDOB()));
        assertThat(getTextSubValue("Gender").getText(), equalTo(app.getGender()));
        assertThat(getTextSubValue("PhonePrimary").getText(), equalTo(app.getPhonePrimary()));
        assertThat(getTextSubValue("PhoneEvening").getText(), equalTo(app.getPhoneEvening()));
        assertThat(getTextSubValue("AARPMembershipNumber").getText(), equalTo(app.getAARPMembershipNumber()));
    }

    public void verifyInitialStateOfElements(Application app) {
        assertBlank(MedicareClaimNum,
            Email,
            MPAED);
        assertThat(MPBED.getValue(), equalTo(app.getMPBED()));
        assertBlank(PartABActiveIndicator_Yes,
            PartABActiveIndicator_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {

        verifyInitialStateOfElements(app);

        verifyCustomerInfo(app);

        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fill(MPBED).with(app.getMPBED());
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
