package pages.dtc.uwExpansion.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class ME_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 13;

    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#ContinuousCoverage_1") FluentWebElement ContinuousCoverage_YES;
    @FindBy(css = "#ContinuousCoverage_2") FluentWebElement ContinuousCoverage_NO;
    @FindBy(css = "#GIMPBED") FluentWebElement GIMPBED;
    public void verifyInitialStateOfElements(Application app) {
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertBlank(TobaccoUse_Yes, TobaccoUse_No);
        assertHidden(ContinuousCoverage_YES, ContinuousCoverage_NO);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {
        verifyInitialStateOfElements(app);

        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") ||app.getPlanEffIn6OfEligible().equals("yes")) {
            assertHidden(LostCoverage_Yes, LostCoverage_No);
            assertHidden(ContinuousCoverage_YES, ContinuousCoverage_NO);
        } else {

            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

        }


        if((app.getLostCoverage()).equalsIgnoreCase("NO"))
            fillYesNoQuestion(ContinuousCoverage_YES, ContinuousCoverage_NO, app.getContinuousCoverage());

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(Turned65In6GA_Yes,
            Turned65In6GA_No,
            PartBIn6GA_Yes,
            PartBIn6GA_No,
            PlanEffIn6OfEligible_Yes,
            PlanEffIn6OfEligible_No);
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertVisibleBasedUpon(app.getPartBIn6GA().equals(YES), GIMPBED);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
