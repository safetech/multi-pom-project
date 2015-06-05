package integration.phone.pages.variations.planapplicationpage;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DE_PlanApplicationQuestions extends WizardPage{

    @FindBy(css = "#Turned65In6GA_1") protected FluentWebElement Turned65In6GA_Yes;
    @FindBy(css = "#Turned65In6GA_2") protected FluentWebElement Turned65In6GA_No;
    @FindBy(css = "#PartBIn6GA_1") protected FluentWebElement PartBIn6GA_Yes;
    @FindBy(css = "#PartBIn6GA_2") protected FluentWebElement PartBIn6GA_No;
    @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;

    public void fillAndSubmit(Application app) {

        elementSelection(app);

        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        clickNextAndWaitForSpinnerToFinish();
    }

    private void elementSelection(Application app){
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
    }

    public void  isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }

}
