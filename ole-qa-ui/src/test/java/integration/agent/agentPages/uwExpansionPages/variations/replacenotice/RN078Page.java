package integration.agent.agentPages.uwExpansionPages.variations.replacenotice;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RN078Page extends WizardPage {

    @FindBy(css = "#ReplacementReason_1") FluentWebElement ReplacementReason_ReplaceAdditionalBenefits;
    @FindBy(css = "#ReplacementReason_2") FluentWebElement ReplacementReason_SameBenefits;
    @FindBy(css = "#ReplacementReason_3") FluentWebElement ReplacementReason_FewerBenefits;
    @FindBy(css = "#ReplacementReason_4") FluentWebElement ReplacementReason_EnrolledPartD;
    @FindBy(css = "#ReplacementReason_5") FluentWebElement ReplacementReason_Disenroll;
    @FindBy(css = "#ReplacementReason_6") FluentWebElement ReplacementReason_OtherReason;
    FluentWebElement RNOther;
    FluentWebElement AgentRNSignatureInd;
    FluentWebElement AgentPrintedNameAdd;
    FluentWebElement AgentAddress;
    FluentWebElement ApplicantRNSignatureInd;
    FluentWebElement ApplicantPrintedNameAdd;
    FluentWebElement ApplicantAddress;

    public void fillAndSubmit(Application app) {

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


        AgentRNSignatureInd.click();
        fillTouchSignature("AgentRNSignatureIndTouch",  app.getAgentRNSignatureIndTouch());
        fill(AgentPrintedNameAdd).with(app.getAgentPrintedNameAdd());
        fill(AgentAddress).with(app.getAgentAddress());
        ApplicantRNSignatureInd.click();
        fillTouchSignature("ApplicantRNSignatureIndTouch",  app.getApplicantRNSignatureIndTouch());
        fill(ApplicantPrintedNameAdd).with(app.getApplicantPrintedNameAdd());
        fill(ApplicantAddress).with(app.getApplicantAddress());



        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Notice to Applicant"));
    }
}
