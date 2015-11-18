package pages.agent.uwExpansion.variations.planapplication;


import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class CA_PlanApplicationQuestionsPage extends PlanApplicationQuestions {

        @FindBy(css = "#GI30dayBday_1") protected FluentWebElement GI30Bday_Yes;
        @FindBy(css = "#GI30dayBday_2") protected FluentWebElement GI30Bday_No;
        @FindBy(css = "#Turned65In6GA_1") protected FluentWebElement Turned65In6GA_Yes;
        @FindBy(css = "#Turned65In6GA_2") protected FluentWebElement Turned65In6GA_No;
        @FindBy(css = "#PartBIn6GA_1") protected FluentWebElement PartBIn6GA_Yes;
        @FindBy(css = "#PartBIn6GA_2") protected FluentWebElement PartBIn6GA_No;
        @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
        @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
        @FindBy(css = "#CAGuaranteedAcceptance_1") protected FluentWebElement CAGuaranteedAcceptance_Yes;
        @FindBy(css = "#CAGuaranteedAcceptance_2") protected FluentWebElement CAGuaranteedAcceptance_No;
        @FindBy(css = "#LostCoverage_1") protected FluentWebElement LostCoverage_Yes;
        @FindBy(css = "#LostCoverage_2") protected FluentWebElement LostCoverage_No;
        @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
        @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;
        @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
        @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
        @FindBy(css = "#ESRD_3") FluentWebElement ESRD_Maybe;

        protected int TOTAL_POSSIBLE_QUESTION_COUNT = 13;

    public void verifyInitialStateOfElements(Application app) {
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        assertVisible(GI30Bday_Yes,GI30Bday_No, TobaccoUse_Yes, TobaccoUse_No);
        assertBlank(GI30Bday_Yes,GI30Bday_No, TobaccoUse_Yes, TobaccoUse_No);
        assertHidden(ESRD_Yes,
                ESRD_No,
                ESRD_Maybe,
                PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No,
                CAGuaranteedAcceptance_Yes,
                CAGuaranteedAcceptance_No,
                LostCoverage_Yes,
                LostCoverage_No);

    }
        public void fillAndSubmit(Application app) {

            fillYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
            fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
            if(app.getGI30dayBday().equals(NO)) {
                fillYesNoUnsureQuestion(ESRD_Yes, ESRD_No,ESRD_Maybe, app.getESRD());
                if(app.getESRD().equals(NO)) {
                    fillYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
                    if(app.getPlanEffIn6OfEligible().equals(NO)) {
                        fillYesNoQuestion(CAGuaranteedAcceptance_Yes, CAGuaranteedAcceptance_No, app.getCAGuaranteedAcceptance());
                        if(app.getCAGuaranteedAcceptance().equals(NO)) {
                            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
                        }
                    }
                }
            }
            verifyStateOfElementAfterAnswers(app);
            clickNextAndWaitForSpinnerToFinish();
        }

        public void verifyStateOfElementAfterAnswers(Application app) {
            assertYesNoQuestion(GI30Bday_Yes,GI30Bday_No, app.getGI30dayBday());
            assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
            if(app.getGI30dayBday().equals(NO)) {
            assertVisibleBasedUpon(app.getGI30dayBday().equals(NO), ESRD_Yes, ESRD_No, ESRD_Maybe);
            assertVisibleBasedUpon(app.getESRD().equals(NO), PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No);
            assertVisibleBasedUpon(app.getPlanEffIn6OfEligible().equals(NO), CAGuaranteedAcceptance_Yes, CAGuaranteedAcceptance_No);
            assertVisibleBasedUpon(app.getCAGuaranteedAcceptance().equals(NO), LostCoverage_Yes, LostCoverage_No);
            }else if(app.getGI30dayBday().equals(YES)){
                assertHidden(ESRD_Yes, ESRD_No, ESRD_Maybe);
                assertHidden(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No);
                assertHidden(CAGuaranteedAcceptance_Yes, CAGuaranteedAcceptance_No);
                assertHidden(LostCoverage_Yes, LostCoverage_No);
            }
                assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        }
    }

