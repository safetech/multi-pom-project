package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanApplicationQuestions extends WizardPage{

    @FindBy(css = "#Turned65In6GA_1") FluentWebElement Turned65In6GA_Yes;
    @FindBy(css = "#Turned65In6GA_2") FluentWebElement Turned65In6GA_No;
    @FindBy(css = "#PartBIn6GA_1") FluentWebElement PartBIn6GA_Yes;
    @FindBy(css = "#PartBIn6GA_2") FluentWebElement PartBIn6GA_No;
    @FindBy(css = "#PlanEffIn6OfEligible_1") FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#TobaccoUse_1") FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") FluentWebElement TobaccoUse_No;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;

    public void fillAndSubmit(Application app) {

        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }

    public void verifyPrefilledAnswers(Application app) {
        assertThat(Turned65In6GA_Yes.isSelected(), equalTo(true));
        assertThat(PartBIn6GA_No.isSelected(), equalTo(true));
        assertThat(PlanEffIn6OfEligible_Yes.isSelected(), equalTo(true));
    }
}
