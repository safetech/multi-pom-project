package resources.pages.greenbaypages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VoiceSignatureInstructionsPage extends WizardPage {

    FluentWebElement VoiceSignatureApproval;
    @FindBy(css = "#AppInFrontOfYou_1") FluentWebElement AppInFrontOfYou_Yes;
    @FindBy(css = "#AppInFrontOfYou_2") FluentWebElement AppInFrontOfYou_No;
    @FindBy(css = "#GroupApp_1") FluentWebElement GroupApp_Yes;
    @FindBy(css = "#GroupApp_2") FluentWebElement GroupApp_No;
    @FindBy(css = "#employerId") FluentWebElement EmployerId;
    @FindBy(xpath = "//*[@id='colctrl_0_showhide']/div/label[2]") FluentWebElement EmployerIdRequired;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 6;

    public void fillAndSubmit(Application app) {
        isAt();
        verifyInitialStateOfElements();

        VoiceSignatureApproval.click();
        AppInFrontOfYou_Yes.click();
        fillYesNoQuestion(GroupApp_Yes, GroupApp_No, app.getGroupApp());
        if(app.getGroupApp().equals(YES)) {
            fill(EmployerId).with(app.getEmployerId());
        }else {
            assertHidden(EmployerId);
        }
        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyInitialStateOfElements() {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertBlank(VoiceSignatureApproval);
        assertHidden(AppInFrontOfYou_Yes, AppInFrontOfYou_No);
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(VoiceSignatureApproval);
        assertThat(VoiceSignatureApproval.isSelected(), equalTo(true));
        assertVisible(AppInFrontOfYou_Yes, AppInFrontOfYou_No);
        assertThat(AppInFrontOfYou_Yes.isSelected(), equalTo(true));
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void verifyEmployerIDShowsExpectedErrorMessages(Application app) {
        VoiceSignatureApproval.click();
        AppInFrontOfYou_Yes.click();
        fillYesNoQuestion(GroupApp_Yes, GroupApp_No, app.getGroupApp());
        clickNextAndWaitForSpinnerToFinish();
        assertThat(EmployerIdRequired.getText(), equalTo("Required field"));
        
        fill(EmployerId).with("123abc");
        assertThat(EmployerIdRequired.getText(), equalTo("Please use only numbers for this field."));

        fill(EmployerId).with(app.getEmployerId());
        clickNextAndWaitForSpinnerToFinish();
    }


    public void isAt() {
        assertThat(pageTitle.getText(), containsString("Voice Signature Instructions"));
    }
}
