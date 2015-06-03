package integration.phone.pages.variations.authorizationandverification;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CAAuthorizationAndVerificationPage extends WizardPage{

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
        MedicalReleaseAuthSignatureInd.click();
        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}
