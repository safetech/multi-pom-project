package pages.agent.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NV_PlanApplicationQuestionsPage extends WizardPage {
    @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    public void fillAndSubmit(Application app) {

        isAt();

        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") ||app.getPlanEffIn6OfEligible().equals("yes")) {
                assertHidden(LostCoverage_Yes, LostCoverage_No);

        } else {

            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        }

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }
}
