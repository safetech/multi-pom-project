package resources.pages.agentpages.oldOlePages.variations.planapplication;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.agentpages.oldOlePages.PlanApplicationQuestions;

public class ME_PlanApplicationQuestionsPage extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 13;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#ContinuousCoverage_1") FluentWebElement ContinuousCoverage_Yes;
    @FindBy(css = "#ContinuousCoverage_2") FluentWebElement ContinuousCoverage_No;
    @FindBy(css = "#GIMPBED") FluentWebElement GIMPBED;

    public void verifyInitialStateOfElements(Application app) {
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertBlank(TobaccoUse_Yes, TobaccoUse_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertHidden(ContinuousCoverage_Yes, ContinuousCoverage_No);
        assertHidden(GIMPBED);

    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);
        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        if((app.getLostCoverage()).equalsIgnoreCase("NO"))
            fillYesNoQuestion(ContinuousCoverage_Yes, ContinuousCoverage_No, app.getContinuousCoverage());

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(Turned65In6GA_Yes,
                Turned65In6GA_No,
                PartBIn6GA_Yes,
                PartBIn6GA_No,
                PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No,
                LostCoverage_Yes,
                LostCoverage_No,
                TobaccoUse_Yes,
                TobaccoUse_No);
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertVisibleBasedUpon(app.getLostCoverage().equals(NO), TobaccoUse_Yes, TobaccoUse_No);
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
