package resources.pages.agentpages.uwExpansionPages.variations.planapplication;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.phonepages.uwExpansionPages.PlanApplicationQuestions;

public class AR_PlanApplicationQuestionsPage extends PlanApplicationQuestions{
    @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
    @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
    @FindBy(css = "#LostCoverage_1") protected FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") protected FluentWebElement LostCoverage_No;
    @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
    @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 6;

    public void fillAndSubmit(Application app) {
        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertVisible(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No);
        
        if(app.getPlanEffIn6OfEligible().equals(NO)){
            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        }

        verifyStateOfElementAfterAnswers(app);
        app.getTest().log(LogStatus.INFO,"Clicking Next..");
        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), LostCoverage_Yes, LostCoverage_No,TobaccoUse_Yes, TobaccoUse_No);
        app.getTest().log(LogStatus.INFO,"Verified State Of Element After Answers..");
    }
}
