package integration.phone.phonePages.oldOlePages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VoiceSignatureInstructionsPage extends WizardPage {

    FluentWebElement VoiceSignatureApproval;
    @FindBy(css = "#AppInFrontOfYou_1") FluentWebElement AppInFrontOfYou_Yes;
    @FindBy(css = "#AppInFrontOfYou_2") FluentWebElement AppInFrontOfYou_No;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 3;

    public void fillAndSubmit(Application app) {

        //isAt();
        verifyInitialStateOfElements();

        VoiceSignatureApproval.click();
        AppInFrontOfYou_Yes.click();

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyInitialStateOfElements() {
        assertBlank(VoiceSignatureApproval);
        assertHidden(AppInFrontOfYou_Yes, AppInFrontOfYou_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(VoiceSignatureApproval);
        assertThat(VoiceSignatureApproval.isSelected(), equalTo(true));
        assertVisible(AppInFrontOfYou_Yes, AppInFrontOfYou_No);
        assertThat(AppInFrontOfYou_Yes.isSelected(), equalTo(true));
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void verifyStateOfElementsAfterQrRetreive() {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertVisible(VoiceSignatureApproval);
        assert(VoiceSignatureApproval.isSelected());
        assertVisible(AppInFrontOfYou_Yes, AppInFrontOfYou_No);
        clickNextAndWaitForSpinnerToFinish();
    }


    public void isAt() {
        assertThat(pageTitle.getText(), containsString("Voice Signature Instructions"));
    }
}
