package pages.agent.uwExpansion;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanApplicationQuestions extends WizardPage {

    @FindBy(css = "#Turned65In6GA_1") protected FluentWebElement Turned65In6GA_Yes;
    @FindBy(css = "#Turned65In6GA_2") protected FluentWebElement Turned65In6GA_No;
    @FindBy(css = "#PartBIn6GA_1") protected FluentWebElement PartBIn6GA_Yes;
    @FindBy(css = "#PartBIn6GA_2") protected FluentWebElement PartBIn6GA_No;
    @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;

    public void fillAndSubmit(Application app) {

        isAt();

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyPrefilledAnswers(Application app) {
        assertThat(Turned65In6GA_Yes.isSelected(), equalTo(true));
        assertThat(PartBIn6GA_No.isSelected(), equalTo(true));
        assertThat(PlanEffIn6OfEligible_Yes.isSelected(), equalTo(true));
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }
}
