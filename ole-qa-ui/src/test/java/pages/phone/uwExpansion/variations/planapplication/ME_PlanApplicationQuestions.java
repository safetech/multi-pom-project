package pages.phone.uwExpansion.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class ME_PlanApplicationQuestions extends PlanApplicationQuestions {


protected int TOTAL_POSSIBLE_QUESTION_COUNT = 8;
@FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
@FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
@FindBy(css = "#ContinuousCoverage_1") FluentWebElement ContinuousCoverage_YES;
@FindBy(css = "#ContinuousCoverage_2") FluentWebElement ContinuousCoverage_NO;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertVisible(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No);
        assertVisible(ContinuousCoverage_YES, ContinuousCoverage_NO);
        assertHidden(LostCoverage_Yes, LostCoverage_No);
        assertVisible(TobaccoUse_Yes, TobaccoUse_No);
    }

    public void fillAndSubmit(Application app) {
        verifyInitialStateOfElements(app);

        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        if(app.getPlanEffIn6OfEligible().equalsIgnoreCase("NO")) {
            fillYesNoQuestion(ContinuousCoverage_YES, ContinuousCoverage_NO, app.getContinuousCoverage());
            if(app.getContinuousCoverage().equals(NO)){
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
                ContinuousCoverage_YES,
                ContinuousCoverage_NO,
                LostCoverage_Yes,
                LostCoverage_No);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), ContinuousCoverage_YES, ContinuousCoverage_NO);
        assertVisibleBasedUpon(app.getContinuousCoverage().equals(NO), LostCoverage_Yes, LostCoverage_No);

        //assertVisibleBasedUpon(app.getPartBIn6GA().equals(YES), GIMPBED);

    }

}
