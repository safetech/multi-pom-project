package resources.pages.agentpages.uwExpansionPages.variations.authorization;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AuthorizationPage extends WizardPage{

    private FluentWebElement SignatureInd;
    private FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {
        isAt();
        SignatureInd.click();
        fillTouchSignature("SignatureIndTouch",  app.getSignatureIndTouch());
        
        MedicalReleaseAuthSignatureInd.click();
        fillTouchSignature("MedicalReleaseAuthSignatureIndTouch", app.getMedicalReleaseAuthSignatureIndTouch());

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
