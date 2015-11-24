package pages.dtc.uwExpansion.variations.planapplication;


import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.phone.PlanApplicationQuestions;

public class CA_PlanApplicationQuestions extends PlanApplicationQuestions {

        @FindBy(css = "#GI30dayBday_1") protected FluentWebElement GI30Bday_Yes;
        @FindBy(css = "#GI30dayBday_2") protected FluentWebElement GI30Bday_No;
        @FindBy(css = "#ESRD_1") protected FluentWebElement ESRD_Yes;
        @FindBy(css = "#ESRD_2") protected FluentWebElement ESRD_No;
        @FindBy(css = "#ESRD_3") protected FluentWebElement ESRD_NotSure;
        @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
        @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
        @FindBy(css = "#CAGuaranteedAcceptance_1") protected FluentWebElement CAGuaranteedAcceptance_Yes;
        @FindBy(css = "#CAGuaranteedAcceptance_2") protected FluentWebElement CAGuaranteedAcceptance_No;
        @FindBy(css = "#LostCoverage_1") protected FluentWebElement LostCoverage_Yes;
        @FindBy(css = "#LostCoverage_2") protected FluentWebElement LostCoverage_No;
        @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
        @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;

        protected int TOTAL_POSSIBLE_QUESTION_COUNT = 13;

        public void fillAndSubmit(Application app) {

            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
            fillYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
            if(app.getGI30dayBday().equals(NO)) {
                fillYesNoUnsureQuestion(ESRD_Yes, ESRD_No, ESRD_NotSure, app.getESRD());
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
                fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

            clickNextAndWaitForSpinnerToFinish();
        }
    }

