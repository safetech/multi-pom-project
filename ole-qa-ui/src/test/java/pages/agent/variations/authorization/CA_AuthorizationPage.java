package pages.agent.variations.authorization;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AuthorizationPage extends WizardPage{

    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseClaimSignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {

        SignatureInd.click();
        MedicalReleaseClaimSignatureInd.click();
        MedicalReleaseAuthSignatureInd.click();
        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
