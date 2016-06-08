package resources.pages.greenbaypages;

import com.sun.tools.javac.jvm.Gen;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.entity.Application;
import resources.entity.TestData;
import resources.pages.WizardPage;
import static javafx.beans.binding.Bindings.select;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerInformationPage extends WizardPage {
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
    @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
    @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;
    @FindBy(xpath = "//*[@id='colctrl_0_showhide']/div/label[2]") FluentWebElement AarpIdRequired;
    @FindBy(css = ".button.action_back") FluentWebElement backButton;
    FluentWebElement VoiceSignatureApproval;
    @FindBy(css = "#GroupApp_1") FluentWebElement GroupApp_Yes;
    @FindBy(css = "#GroupApp_2") FluentWebElement GroupApp_No;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 22;

    public void setCustomerInfo(Application app) {
        fill(AARPMembershipNumber).with(app.getAARPMembershipNumber());
        (new Select(Prefix.getElement())).selectByValue(app.getPrefix());
        fill(FirstName).with(app.getFirstName());
        fill(MI).with(app.getMI());
        fill(LastName).with(app.getLastName());
        (new Select(Suffix.getElement())).selectByValue(app.getSuffix());
        fill(AddressLine1).with(app.getAddressLine1());
        fill(AddressLine2).with(app.getAddressLine2());
        fill(City).with(app.getCity());
        fill(Email).with(app.getEmail());
        fill(PhonePrimary).with(app.getPhonePrimary());
        fill(PhoneEvening).with(app.getPhoneEvening());
        assertThat(MPBED.getValue(), equalTo(app.getMPBED()));
        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());
        (new Select(Gender.getElement())).selectByValue(app.getGender());
        
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
    
    
    public void isDisplayingErrorMessages(Application app) {
        assertThat(AarpIdRequired.getText(), equalTo("Required field"));
        app.setGroupApp(NO);
        backButton.click();
        backButton.click();
        VoiceSignatureApproval.click();
        fillYesNoQuestion(GroupApp_Yes, GroupApp_No, app.getGroupApp());
        clickNextAndWaitForSpinnerToFinish();
        clickNextAndWaitForSpinnerToFinish();
        clickNextAndWaitForSpinnerToFinish();
        assertThat(AarpIdRequired.getText(), equalTo("Required field"));
        
    }
}
