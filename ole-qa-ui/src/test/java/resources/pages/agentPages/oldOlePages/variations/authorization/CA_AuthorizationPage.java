package resources.pages.agentPages.oldOlePages.variations.authorization;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AuthorizationPage extends WizardPage{

    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseClaimSignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {
        isAt();
        SignatureInd.click();
        fillTouchSignature("SignatureIndTouch",  app.getSignatureIndTouch());

        if(app.getMedicalReleaseAuthSignatureIndRequired().equals("Required")) {
            MedicalReleaseAuthSignatureInd.click();
            fillTouchSignature("MedicalReleaseAuthSignatureIndTouch", app.getMedicalReleaseAuthSignatureIndTouch());
        }

        MedicalReleaseClaimSignatureInd.click();
        fillTouchSignature("MedicalReleaseClaimSignatureIndTouch", app.getMedicalReleaseClaimSignatureIndTouch());


        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
