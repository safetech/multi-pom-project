package resources.pages.phonepages.oldOlePages.variations.authorization;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WI_AuthorizationAndVerificationPage extends WizardPage {

    @FindBy(css = "#UnderstandAuth_1") FluentWebElement UnderstandAuth_Yes;
    @FindBy(css = "#UnderstandAuth_2") FluentWebElement UnderstandAuth_No;
    @FindBy(css = "#ReplacementReason_1") FluentWebElement ReplacementReason_ReplaceAdditionalBenefits;
    @FindBy(css = "#ReplacementReason_2") FluentWebElement ReplacementReason_SameBenefits;
    @FindBy(css = "#ReplacementReason_3") FluentWebElement ReplacementReason_FewerBenefits;
    @FindBy(css = "#ReplacementReason_4") FluentWebElement ReplacementReason_EnrolledPartD;
    @FindBy(css = "#ReplacementReason_5") FluentWebElement ReplacementReason_Disenroll;
    @FindBy(css = "#ReplacementReason_6") FluentWebElement ReplacementReason_OtherReason;
    FluentWebElement RNOther;
    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;
    FluentWebElement ApplicantRNSignatureInd;

    public void fillAndSubmit(Application app) {

        UnderstandAuth_Yes.click();
        SignatureInd.click();
        MedicalReleaseAuthSignatureInd.click();
        switch (app.getReplacementReason()) {
            case "ReplaceAdditionalBenefits":
                ReplacementReason_ReplaceAdditionalBenefits.click();
                break;
            case "SameBenefits":
                ReplacementReason_SameBenefits.click();
                break;
            case "FewerBenefits":
                ReplacementReason_FewerBenefits.click();
                break;
            case "EnrolledPartD":
                ReplacementReason_EnrolledPartD.click();
                break;
            case "Disenroll":
                ReplacementReason_Disenroll.click();
                fill(RNOther).with(app.getRNOther());
                break;
            case "OtherReason":
                ReplacementReason_OtherReason.click();
                fill(RNOther).with(app.getRNOther());
                break;
        }

        ApplicantRNSignatureInd.click();
        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}
