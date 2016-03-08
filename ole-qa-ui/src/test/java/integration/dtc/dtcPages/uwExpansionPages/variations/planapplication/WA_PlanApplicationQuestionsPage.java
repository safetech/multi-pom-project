package integration.dtc.dtcPages.uwExpansionPages.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import integration.phone.phonePages.oldOlePages.PlanApplicationQuestions;

public class WA_PlanApplicationQuestionsPage extends PlanApplicationQuestions {

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 6;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#MedSuppReplace_1") FluentWebElement MedSuppReplace_Yes;
    @FindBy(css = "#MedSuppReplace_2") FluentWebElement MedSuppReplace_No;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), MedSuppReplace_Yes, MedSuppReplace_No);
        assertHidden(LostCoverage_Yes, LostCoverage_No);

    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);
        if(app.getPlanEffIn6OfEligible().equals(NO)) {
            fillYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        }

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        if(app.getPlanEffIn6OfEligible().equals(NO)){
            assertVisible(MedSuppReplace_Yes, MedSuppReplace_No, LostCoverage_Yes, LostCoverage_No);
            assertYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
            assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

        }
    }

}
