package pages.phone.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class WI_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;

    public void verifyInitialStateOfElements(Application app) {
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertHidden(TobaccoUse_Yes, TobaccoUse_No);
    }

    public void fillAndSubmit(Application app) {

        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        verifyInitialStateOfElements(app);

        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") || app.getPlanEffIn6OfEligible().equals("yes")) {
            assertHidden(LostCoverage_Yes, LostCoverage_No);
            assertHidden(TobaccoUse_Yes, TobaccoUse_No);

        } else {

            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            assertVisibleBasedUpon(app.getLostCoverage().equals(NO), TobaccoUse_Yes, TobaccoUse_No);
            fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        }


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
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") || app.getPlanEffIn6OfEligible().equals("yes")) {
            assertHidden(LostCoverage_Yes, LostCoverage_No);
            assertHidden(TobaccoUse_Yes, TobaccoUse_No);
        }else{
            assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        }

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
