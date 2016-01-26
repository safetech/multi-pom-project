package pages.phone.uwExpansion;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class MN_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertBlank(TobaccoUse_Yes, TobaccoUse_No);
    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);
        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
