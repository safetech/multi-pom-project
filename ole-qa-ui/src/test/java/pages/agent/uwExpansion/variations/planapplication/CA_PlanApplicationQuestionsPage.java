package pages.agent.uwExpansion.variations.planapplication;


import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class CA_PlanApplicationQuestionsPage extends PlanApplicationQuestions {


        @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
        @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
        @FindBy(css = "#GI30dayBday_1") protected FluentWebElement GI30Bday_Yes;
        @FindBy(css = "#GI30dayBday_2") protected FluentWebElement GI30Bday_No;
        @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
        @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
        @FindBy(css = "#ESRD_3") FluentWebElement ESRD_Maybe;
        @FindBy(css = "#CAGuaranteedAcceptance_1") protected FluentWebElement CAGuaranteedAcceptance_Yes;
        @FindBy(css = "#CAGuaranteedAcceptance_2") protected FluentWebElement CAGuaranteedAcceptance_No;
        @FindBy(css = "#LostCoverage_1") protected FluentWebElement LostCoverage_Yes;
        @FindBy(css = "#LostCoverage_2") protected FluentWebElement LostCoverage_No;
        @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
        @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;


        protected int TOTAL_POSSIBLE_QUESTION_COUNT = 13;


    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertVisible(PlanEffIn6OfEligible_Yes,PlanEffIn6OfEligible_No);
        if(app.getPlanEffIn6OfEligible().equals(NO))
        {
            assertHidden(ESRD_Yes,
                    ESRD_No,
                    ESRD_Maybe,
                    CAGuaranteedAcceptance_Yes,
                    CAGuaranteedAcceptance_No,
                    LostCoverage_Yes,
                    LostCoverage_No);
        }
        else {
            assertHidden(ESRD_Yes,
                    ESRD_No,
                    ESRD_Maybe,
                    GI30Bday_Yes,
                    GI30Bday_No,
                    CAGuaranteedAcceptance_Yes,
                    CAGuaranteedAcceptance_No,
                    LostCoverage_Yes,
                    LostCoverage_No);
        }
    }

    public void fillAndSubmit(Application app) {
        isAt();

        verifyInitialStateOfElements(app);
        if(app.getPlanEffIn6OfEligible().equals(NO)) {
            fillYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
            if(app.getGI30dayBday().equals(NO)) {
                fillYesNoUnsureQuestion(ESRD_Yes, ESRD_No,ESRD_Maybe, app.getESRD());
                if(app.getESRD().equals(NO)) {
                    fillYesNoQuestion(CAGuaranteedAcceptance_Yes, CAGuaranteedAcceptance_No, app.getCAGuaranteedAcceptance());
                    if(app.getCAGuaranteedAcceptance().equals(NO)) {
                        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
                    }
                }
            }
            fillYesNoQuestion(TobaccoUse_Yes,TobaccoUse_No,app.getTobaccoUse());
        }
        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {
        assertVisible(PlanEffIn6OfEligible_Yes,PlanEffIn6OfEligible_No);
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), GI30Bday_Yes, GI30Bday_No);
        assertYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
        assertVisibleBasedUpon(app.getGI30dayBday().equals(NO), ESRD_Yes, ESRD_No,ESRD_Maybe);
        assertYesNoUnsureQuestion(ESRD_Yes,ESRD_No,ESRD_Maybe,app.getESRD());
        assertVisibleBasedUpon(app.getESRD().equals(NO), CAGuaranteedAcceptance_Yes, CAGuaranteedAcceptance_No);
        assertYesNoQuestion(CAGuaranteedAcceptance_Yes, CAGuaranteedAcceptance_No, app.getCAGuaranteedAcceptance());
        assertVisibleBasedUpon(app.getCAGuaranteedAcceptance().equals(NO), LostCoverage_Yes, LostCoverage_No);
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }
    }

