package resources.pages.greenbaypages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationAndVerificationPage extends WizardPage {

    @FindBy(css = "#UnderstandAuth_1") FluentWebElement UnderstandAuth_Yes;
    @FindBy(css = "#UnderstandAuth_2") FluentWebElement UnderstandAuth_No;
    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {

        UnderstandAuth_Yes.click();
        SignatureInd.click();

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}