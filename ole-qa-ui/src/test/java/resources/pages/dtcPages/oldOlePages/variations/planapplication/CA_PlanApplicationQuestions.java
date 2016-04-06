package resources.pages.dtcPages.oldOlePages.variations.planapplication;


import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.phonePages.oldOlePages.PlanApplicationQuestions;

public class CA_PlanApplicationQuestions extends PlanApplicationQuestions {

        @FindBy(css = "#GI30dayBday_1") protected FluentWebElement GI30Bday_Yes;
        @FindBy(css = "#GI30dayBday_2") protected FluentWebElement GI30Bday_No;
        @FindBy(css = "#Turned65In6GA_1") protected FluentWebElement Turned65In6GA_Yes;
        @FindBy(css = "#Turned65In6GA_2") protected FluentWebElement Turned65In6GA_No;
        @FindBy(css = "#PartBIn6GA_1") protected FluentWebElement PartBIn6GA_Yes;
        @FindBy(css = "#PartBIn6GA_2") protected FluentWebElement PartBIn6GA_No;
        @FindBy(css = "#PlanEffIn6OfEligible_1") protected FluentWebElement PlanEffIn6OfEligible_Yes;
        @FindBy(css = "#PlanEffIn6OfEligible_2") protected FluentWebElement PlanEffIn6OfEligible_No;
        @FindBy(css = "#GIEmployerCov_1") protected FluentWebElement GIEmployerCov_Yes;
        @FindBy(css = "#GIEmployerCov_2") protected FluentWebElement GIEmployerCov_No;
        @FindBy(css = "#GIMediCal_1") protected FluentWebElement GIMediCal_Yes;
        @FindBy(css = "#GIMediCal_2") protected FluentWebElement GIMediCal_No;
        @FindBy(css = "#GIMilitary_1") protected FluentWebElement GIMilitary_Yes;
        @FindBy(css = "#GIMilitary_2") protected FluentWebElement GIMilitary_No;
        @FindBy(css = "#GILocation_1") protected FluentWebElement GILocation_Yes;
        @FindBy(css = "#GILocation_2") protected FluentWebElement GILocation_No;
        @FindBy(css = "#LostCoverage_1") protected FluentWebElement LostCoverage_Yes;
        @FindBy(css = "#LostCoverage_2") protected FluentWebElement LostCoverage_No;
        @FindBy(css = "#TobaccoUse_1") protected FluentWebElement TobaccoUse_Yes;
        @FindBy(css = "#TobaccoUse_2") protected FluentWebElement TobaccoUse_No;

        protected int TOTAL_POSSIBLE_QUESTION_COUNT = 20;



        public void fillAndSubmit(Application app) {

            fillYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());

            if(app.getGI30dayBday().equals(NO)) {
                fillYesNoQuestion(GIEmployerCov_Yes, GIEmployerCov_No, app.getGIEmployerCov());
                if(app.getGIEmployerCov().equals(NO)) {
                    fillYesNoQuestion(GIMediCal_Yes, GIMediCal_No, app.getGIMediCal());
                    if(app.getGIMediCal().equals(NO)) {
                        fillYesNoQuestion(GIMilitary_Yes, GIMilitary_No, app.getGIMilitary());
                        if(app.getGIMilitary().equals(NO)) {
                            fillYesNoQuestion(GILocation_Yes, GILocation_No, app.getGILocation());
                            if(app.getGILocation().equals(NO)) {
                                fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
                                if(app.getLostCoverage().equals(NO)) {
                                    fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

                                }
                            }
                        }
                    }
                }
            }

            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
            clickNextAndWaitForSpinnerToFinish();
        }
    }

