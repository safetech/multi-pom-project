package pages.phone.uwExpansion.variations.authorization;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AuthorizationAndVerificationPage extends WizardPage{

    @FindBy(css = "#UnderstandAuth_1") FluentWebElement UnderstandAuth_Yes;
    @FindBy(css = "#UnderstandAuth_2") FluentWebElement UnderstandAuth_No;
    FluentWebElement SignatureInd;
    FluentWebElement SellingAgentSignatureInd;
    FluentWebElement MedicalReleaseClaimSignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;


    public void fillAndSubmit(Application app) {

        UnderstandAuth_Yes.click();
        SignatureInd.click();
        MedicalReleaseClaimSignatureInd.click();
        if(app.getMedicalReleaseAuthSignatureIndRequired().equals("Required")){
        MedicalReleaseAuthSignatureInd.click();
        }
        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}
