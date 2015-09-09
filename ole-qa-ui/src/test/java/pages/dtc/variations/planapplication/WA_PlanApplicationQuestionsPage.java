package pages.dtc.variations.planapplication;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class WA_PlanApplicationQuestionsPage extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(id = "MedSuppReplace_1") FluentWebElement MedSuppReplace_Yes;
    @FindBy(id = "MedSuppReplace_2") FluentWebElement MedSuppReplace_No;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(MedSuppReplace_Yes, MedSuppReplace_No);
        assertBlank(LostCoverage_Yes, LostCoverage_No);
    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);

        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") ||app.getPlanEffIn6OfEligible().equals("yes")) {
            assertBlank(MedSuppReplace_Yes, MedSuppReplace_No);
            assertHidden(LostCoverage_Yes, LostCoverage_No);
        } else {

            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

        }

        fillYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
       // fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

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
        assertYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
