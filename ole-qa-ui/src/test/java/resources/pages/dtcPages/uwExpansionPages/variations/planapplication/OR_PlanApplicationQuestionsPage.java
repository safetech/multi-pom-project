package resources.pages.dtcPages.uwExpansionPages.variations.planapplication;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OR_PlanApplicationQuestionsPage extends WizardPage {


    @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;
    @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#LostCoverage_1")
    FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2")
    FluentWebElement LostCoverage_No;
    @FindBy(css = "#GI30dayBday_1")
    protected FluentWebElement GI30Bday_Yes;
    @FindBy(css = "#GI30dayBday_2")
    protected FluentWebElement GI30Bday_No;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 8;

    public void fillAndSubmit(Application app) {

        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());

        if (app.getPlanEffIn6OfEligible().equals(NO)) {
            fillYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
            if (app.getGI30dayBday().equals(YES)) {
                assertHidden(LostCoverage_Yes, LostCoverage_No);
            } else {
                fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            }

        }
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }
}
