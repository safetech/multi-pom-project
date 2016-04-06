package resources.pages.phonePages.oldOlePages.variations.authorization;

import resources.entity.Application;
import resources.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VA_AuthorizationAndVerificationPage extends WizardPage{

    @FindBy(css = "#UnderstandAuth_1") FluentWebElement UnderstandAuth_Yes;
    @FindBy(css = "#UnderstandAuth_2") FluentWebElement UnderstandAuth_No;
    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;
    FluentWebElement SellingAgentSignatureInd;


    public void fillAndSubmit(Application app) {

        UnderstandAuth_Yes.click();
        SignatureInd.click();
        MedicalReleaseAuthSignatureInd.click();
        SellingAgentSignatureInd.click();
        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}
