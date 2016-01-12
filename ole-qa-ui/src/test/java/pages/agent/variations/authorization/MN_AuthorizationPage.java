package pages.agent.variations.authorization;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MN_AuthorizationPage extends WizardPage {

    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {
        isAt();
        MedicalReleaseAuthSignatureInd.click();
        fillTouchSignature("MedicalReleaseAuthSignatureIndTouch", app.getMedicalReleaseAuthSignatureIndTouch());

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}