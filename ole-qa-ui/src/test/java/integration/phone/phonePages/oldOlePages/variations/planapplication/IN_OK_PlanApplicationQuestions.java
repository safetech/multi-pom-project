package integration.phone.phonePages.oldOlePages.variations.planapplication;


import entity.Application;
import integration.phone.phonePages.oldOlePages.PlanApplicationQuestions;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class IN_OK_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
    @FindBy(css = "#LostCoverage_1")  FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2")  FluentWebElement LostCoverage_No;

    public void verifyInitialStateOfElements(Application app) {

        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(TobaccoUse_Yes, TobaccoUse_No);
        assertVisibleBasedUpon(app.getTurned65In6GA().equals(NO), LostCoverage_Yes, LostCoverage_No);
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {

        isAt();

        verifyInitialStateOfElements(app);

        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

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
        assertVisibleBasedUpon(app.getTurned65In6GA().equals(NO), LostCoverage_Yes, LostCoverage_No);
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertVisibleBasedUpon(app.getTurned65In6GA().equals(NO), LostCoverage_Yes, LostCoverage_No);
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }
}
