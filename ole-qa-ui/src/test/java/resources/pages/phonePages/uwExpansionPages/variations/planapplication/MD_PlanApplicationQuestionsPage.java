package resources.pages.phonePages.uwExpansionPages.variations.planapplication;


import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.phonePages.oldOlePages.PlanApplicationQuestions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MD_PlanApplicationQuestionsPage extends PlanApplicationQuestions{

    @FindBy(css = "#Turned65In6GA_1") protected FluentWebElement Turned65In6GA_Yes;
    @FindBy(css = "#Turned65In6GA_2") protected FluentWebElement Turned65In6GA_No;
    @FindBy(css = "#PartBIn6GA_1") protected FluentWebElement PartBIn6GA_Yes;
    @FindBy(css = "#PartBIn6GA_2") protected FluentWebElement PartBIn6GA_No;
    @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;
    @FindBy(css = "#InsurTermed_1") FluentWebElement InsuranceTerminated_Yes;
    @FindBy(css = "#InsurTermed_2") FluentWebElement InsuranceTerminated_No;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 12;

    public void verifyInitialStateOfElements(Application app) {
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertHidden(InsuranceTerminated_Yes, InsuranceTerminated_No);
        assertHidden(TobaccoUse_Yes, TobaccoUse_No);

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }
    public void fillAndSubmit(Application app) {
        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        fillYesNoQuestion(InsuranceTerminated_Yes, InsuranceTerminated_No, app.getInsurTermed());
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

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
                InsuranceTerminated_Yes,
                InsuranceTerminated_No,
                TobaccoUse_Yes,
                TobaccoUse_No);
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertYesNoQuestion(InsuranceTerminated_Yes, InsuranceTerminated_No, app.getInsurTermed());

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }
    public void  isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }
//TODO: Add "Page" in all the plan application page under variations package
}
