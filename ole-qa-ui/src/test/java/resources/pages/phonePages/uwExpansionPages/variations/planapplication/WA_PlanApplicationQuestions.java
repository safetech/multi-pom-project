package resources.pages.phonepages.uwExpansionPages.variations.planapplication;


import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.phonepages.oldOlePages.PlanApplicationQuestions;

public class WA_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 6;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#MedSuppReplace_1") FluentWebElement MedSuppReplace_Yes;
    @FindBy(css = "#MedSuppReplace_2") FluentWebElement MedSuppReplace_No;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        if (app.getPlanEffIn6OfEligible().equals(YES)){
            assertBlank(MedSuppReplace_Yes, MedSuppReplace_No);
            assertHidden(LostCoverage_Yes, LostCoverage_No);

        } else {

            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertBlank(MedSuppReplace_Yes, MedSuppReplace_No);
            assertBlank(LostCoverage_Yes, LostCoverage_No);

        }
    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);

        if (app.getPlanEffIn6OfEligible().equals("yes")){
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        } else {

            fillYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

            verifyStateOfElementAfterAnswers(app);
        }
        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        if (app.getPlanEffIn6OfEligible().equals("yes")){
            assertVisible(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No);
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
        } else {

            assertVisible(
                PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No,
                LostCoverage_Yes,
                LostCoverage_No);
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertYesNoQuestion(MedSuppReplace_Yes, MedSuppReplace_No, app.getMedSuppReplace());
            assertVisibleBasedUpon(app.getMedSuppReplace().equals(NO), LostCoverage_Yes, LostCoverage_No);

        }
    }
}
