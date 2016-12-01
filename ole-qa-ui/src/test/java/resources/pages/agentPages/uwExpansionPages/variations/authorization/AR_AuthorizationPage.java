package resources.pages.agentpages.uwExpansionPages.variations.authorization;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AR_AuthorizationPage extends WizardPage{

    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseClaimSignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {
        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        SignatureInd.click();
        fillTouchSignature("SignatureIndTouch",  app.getSignatureIndTouch());

        if(app.getMedicalReleaseAuthSignatureIndRequired().equals("Required")){
            MedicalReleaseAuthSignatureInd.click();
            fillTouchSignature("MedicalReleaseAuthSignatureIndTouch",  app.getMedicalReleaseAuthSignatureIndTouch());
        }

        app.getTest().log(LogStatus.INFO,"Clicking Next..");
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
