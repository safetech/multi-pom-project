package integration.phone.phonePages.oldOlePages.variations.planapplication;
import entity.Application;
import pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OR_PlanApplicationQuestions extends WizardPage{

    @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;
    @FindBy(css = "#Turned65In6GA_1") protected FluentWebElement Turned65In6GA_Yes;
    @FindBy(css = "#Turned65In6GA_2") protected FluentWebElement Turned65In6GA_No;
    @FindBy(css = "#PartBIn6GA_1") protected FluentWebElement PartBIn6GA_Yes;
    @FindBy(css = "#PartBIn6GA_2") protected FluentWebElement PartBIn6GA_No;
    @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#GI30dayBday_1") protected FluentWebElement GI30Bday_Yes;
    @FindBy(css = "#GI30dayBday_2") protected FluentWebElement GI30Bday_No;
    @FindBy(css = "#LostCoverage_1") protected FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") protected FluentWebElement LostCoverage_No;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 12;

    public void verifyInitialStateOfElements(Application app) {
        assertBlank(TobaccoUse_Yes, TobaccoUse_No);
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(GI30Bday_Yes, GI30Bday_No);
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }
    public void fillAndSubmit(Application app) {

        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        fillYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

        clickNextAndWaitForSpinnerToFinish();
    }
    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(TobaccoUse_Yes,
                TobaccoUse_No,
                Turned65In6GA_Yes,
                Turned65In6GA_No,
                PartBIn6GA_Yes,
                PartBIn6GA_No,
                PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No,
                GI30Bday_Yes,
                GI30Bday_No,
                LostCoverage_Yes,
                LostCoverage_No);
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }
    public void  isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));
    }

}
