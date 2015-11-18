package pages.agent.uwExpansion.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.agent.PlanApplicationQuestions;

public class ME_PlanApplicationQuestionsPage extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 8;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#ContinuousCoverage_1") FluentWebElement ContinuousCoverage_Yes;
    @FindBy(css = "#ContinuousCoverage_2") FluentWebElement ContinuousCoverage_No;
    @FindBy(css = "#GIMPBED") FluentWebElement GIMPBED;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), ContinuousCoverage_Yes, ContinuousCoverage_No);
        assertHidden(LostCoverage_Yes, LostCoverage_No);
        assertBlank(TobaccoUse_Yes, TobaccoUse_No);

    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);
        if(app.getPlanEffIn6OfEligible().equals(NO)) {
            fillYesNoQuestion(ContinuousCoverage_Yes, ContinuousCoverage_No, app.getContinuousCoverage());
            if(app.getContinuousCoverage().equals(NO)) {
                fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            }

        }
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No,
                TobaccoUse_Yes,
                TobaccoUse_No);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), ContinuousCoverage_Yes, ContinuousCoverage_No);
        assertVisibleBasedUpon(app.getContinuousCoverage().equals(NO), LostCoverage_Yes, LostCoverage_No);

        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
