package integration.phone.pages;

import org.fluentlenium.core.domain.FluentWebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VoiceSignatureInstructionsPage extends WizardPage{

    FluentWebElement VoiceSignatureApproval;
    FluentWebElement AppInFrontOfYou_1;

    public void fillAndSubmit() {

        VoiceSignatureApproval.click();
        AppInFrontOfYou_1.click();

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Voice Signature Instructions"));
    }
}
