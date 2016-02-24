package integration.dtc.dtcPages.uwExpansionPages.variations.authorization;

import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MN_AuthorizationPage extends WizardPage {

    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit() {

        SignatureInd.click();

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
