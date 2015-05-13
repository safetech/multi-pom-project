package integration.phone.pages.variations.replacementnotice;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RN034Page extends WizardPage {

    @FindBy(css = "#ReplacementReason_1") FluentWebElement ReplacementReason_ReplaceAdditionalBenefits;
    @FindBy(css = "#ReplacementReason_2") FluentWebElement ReplacementReason_SameBenefits;
    @FindBy(css = "#ReplacementReason_3") FluentWebElement ReplacementReason_FewerBenefits;
    @FindBy(css = "#ReplacementReason_4") FluentWebElement ReplacementReason_EnrolledPartD;
    @FindBy(css = "#ReplacementReason_5") FluentWebElement ReplacementReason_Disenroll;
    @FindBy(css = "#ReplacementReason_6") FluentWebElement ReplacementReason_OtherReason;
    FluentWebElement RNOther;
    FluentWebElement AgentRNSignatureInd;
    FluentWebElement ApplicantRNSignatureInd;
    FluentWebElement ApplicantPrintedNameAdd;
    FluentWebElement ApplicantAddress;

    public void fillAndSubmit(Application app) {
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Notice to Applicant"));
    }
}
