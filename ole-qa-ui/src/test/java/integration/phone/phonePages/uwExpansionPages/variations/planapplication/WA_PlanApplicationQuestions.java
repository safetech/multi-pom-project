package integration.phone.phonePages.uwExpansionPages.variations.planapplication;


import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import integration.phone.phonePages.oldOlePages.PlanApplicationQuestions;

public class WA_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#MedSuppReplace_1") FluentWebElement MedSuppReplace_Yes;
    @FindBy(css = "#MedSuppReplace_2") FluentWebElement MedSuppReplace_No;

    public void verifyInitialStateOfElements(Application app) {

        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") ||app.getPlanEffIn6OfEligible().equals("yes")){
            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertBlank(MedSuppReplace_Yes, MedSuppReplace_No);

        } else {

            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertBlank(LostCoverage_Yes, LostCoverage_No);
            assertBlank(MedSuppReplace_Yes, MedSuppReplace_No);
            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        }
    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);

        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") ||app.getPlanEffIn6OfEligible().equals("yes")){
            fillYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
        } else {

            fillYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

            verifyStateOfElementAfterAnswers(app);
        }
        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        if (app.getTurned65In6GA().equals("yes") || app.getPartBIn6GA().equals("yes") ||app.getPlanEffIn6OfEligible().equals("yes")){
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
        } else {

            assertVisible(Turned65In6GA_Yes,
                Turned65In6GA_No,
                PartBIn6GA_Yes,
                PartBIn6GA_No,
                PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No,
                LostCoverage_Yes,
                LostCoverage_No);
            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
            assertVisibleBasedUpon(app.getMedSuppReplace().equals("no"), LostCoverage_Yes, LostCoverage_No);
            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        }
    }
}
