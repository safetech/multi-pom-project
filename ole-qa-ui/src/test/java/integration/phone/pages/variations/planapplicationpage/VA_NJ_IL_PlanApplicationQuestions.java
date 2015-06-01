package integration.phone.pages.variations.planapplicationpage;

import integration.phone.entity.Application;
import integration.phone.pages.PlanApplicationQuestions;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class VA_NJ_IL_PlanApplicationQuestions extends PlanApplicationQuestions {


    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;

    public void verifyInitialStateOfElements(Application app) {
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertBlank(LostCoverage_Yes, LostCoverage_No);
        assertHidden(TobaccoUse_Yes, TobaccoUse_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {
        verifyInitialStateOfElements(app);

        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        verifyStateOfElementAfterAnswers(app);

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
            LostCoverage_No);
        assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
        assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
        assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
        assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        assertVisibleBasedUpon(app.getLostCoverage().equals("no"), TobaccoUse_Yes, TobaccoUse_No);
        assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    /* public static class PAPlanApplicationQuestions extends PlanApplicationQuestions {

        protected int TOTAL_POSSIBLE_QUESTION_COUNT = 10;
        @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
        @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;

        public void verifyInitialStateOfElements(Application app) {
            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertBlank(LostCoverage_Yes, LostCoverage_No);
            assertHidden(TobaccoUse_Yes, TobaccoUse_No);
            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        }

        public void fillAndSubmit(Application app) {
            verifyInitialStateOfElements(app);

            fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

            verifyStateOfElementAfterAnswers(app);

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
                LostCoverage_No);
            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
            assertVisibleBasedUpon(app.getLostCoverage().equals("no"), TobaccoUse_Yes, TobaccoUse_No);
            assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());
            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        }
    }

    public static class CAPlanApplicationQuestions extends WizardPage {

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

        public void verifyInitialStateOfElements(Application app) {

            assertBlank(GI30Bday_Yes, GI30Bday_No);
            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());
            assertHidden(GIEmployerCov_Yes,
                GIEmployerCov_No,
                GIMediCal_Yes,
                GIMediCal_No,
                GIMilitary_Yes,
                GIMilitary_No,
                GILocation_Yes,
                GILocation_No,
                LostCoverage_Yes,
                LostCoverage_No,
                TobaccoUse_Yes,
                TobaccoUse_No);

            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        }

        public void fillAndSubmit(Application app) {
            verifyInitialStateOfElements(app);

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

            verifyStateOfElementAfterAnswers(app);

        }

        public void verifyStateOfElementAfterAnswers(Application app) {
            assertVisible(GI30Bday_Yes,
                GI30Bday_No,
                Turned65In6GA_Yes,
                Turned65In6GA_No,
                PartBIn6GA_Yes,
                PartBIn6GA_No,
                PlanEffIn6OfEligible_Yes,
                PlanEffIn6OfEligible_No);

            assertYesNoQuestion(GI30Bday_Yes, GI30Bday_No, app.getGI30dayBday());
            assertYesNoQuestion(Turned65In6GA_Yes, Turned65In6GA_No, app.getTurned65In6GA());
            assertYesNoQuestion(PartBIn6GA_Yes, PartBIn6GA_No, app.getPartBIn6GA());
            assertYesNoQuestion(PlanEffIn6OfEligible_Yes, PlanEffIn6OfEligible_No, app.getPlanEffIn6OfEligible());

            assertVisibleBasedUpon(app.getGI30dayBday().equals(NO), GIEmployerCov_Yes, GIEmployerCov_No);
            assertYesNoQuestion(GIEmployerCov_Yes, GIEmployerCov_No, app.getGIEmployerCov());

            assertVisibleBasedUpon(app.getGIEmployerCov().equals(NO), GIMediCal_Yes, GIMediCal_No);
            assertYesNoQuestion(GIMediCal_Yes, GIMediCal_No, app.getGIMediCal());

            assertVisibleBasedUpon(app.getGIMediCal().equals(NO), GIMilitary_Yes, GIMilitary_No);
            assertYesNoQuestion(GIMilitary_Yes, GIMilitary_No, app.getGIMilitary());

            assertVisibleBasedUpon(app.getGIMilitary().equals(NO), GILocation_Yes, GILocation_No);
            assertYesNoQuestion(GILocation_Yes, GILocation_No, app.getGILocation());

            assertVisibleBasedUpon(app.getGILocation().equals(NO), LostCoverage_Yes, LostCoverage_No);
            assertYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());

            assertVisibleBasedUpon(app.getLostCoverage().equals(NO), TobaccoUse_Yes, TobaccoUse_No);
            assertYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

            assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
            clickNextAndWaitForSpinnerToFinish();
        }
    }*/
}
