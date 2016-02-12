package integration.agent.agentPages.oldOlePages.variations.eligibilityhealthquestions;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FL_EligibilityHealthQuestionsPage extends WizardPage {

    @FindBy(css = "#KidneyProblem_1") FluentWebElement KidneyProblem_Yes;
    @FindBy(css = "#KidneyProblem_2") FluentWebElement KidneyProblem_No;
    @FindBy(css = "#KidneyProblem_3") FluentWebElement KidneyProblem_Unsure;
    @FindBy(css = "#EligibilitySurgery_1") FluentWebElement EligibilitySurgery_Yes;
    @FindBy(css = "#EligibilitySurgery_2") FluentWebElement EligibilitySurgery_No;
    @FindBy(css = "#EligibilitySurgery_3") FluentWebElement EligibilitySurgery_Unsure;
    @FindBy(css = "#EligibilityAdmitToHospPast90Days_1") FluentWebElement AdmitToHospPast90Days_Yes;
    @FindBy(css = "#EligibilityAdmitToHospPast90Days_2") FluentWebElement AdmitToHospPast90Days_No;
    @FindBy(css = "#EligibilityAdmitToHospPast90Days_3") FluentWebElement AdmitToHospPast90Days_Unsure;
    @FindBy(css = "#NursingFacility_1") FluentWebElement NursingFacility_Yes;
    @FindBy(css = "#NursingFacility_2") FluentWebElement NursingFacility_No;
    @FindBy(css = "#NursingFacility_3") FluentWebElement NursingFacility_Unsure;
    @FindBy(css = "#EligibilityHeartAttackTIAStroke_1") FluentWebElement EligibilityHeartAttackTIAStroke_Yes;
    @FindBy(css = "#EligibilityHeartAttackTIAStroke_2") FluentWebElement EligibilityHeartAttackTIAStroke_No;
    @FindBy(css = "#EligibilityHeartAttackTIAStroke_3") FluentWebElement EligibilityHeartAttackTIAStroke_Unsure;
    @FindBy(css = "#EligibilityChronicMedicalConditions_1") FluentWebElement EligibilityChronicMedicalConditions_Yes;
    @FindBy(css = "#EligibilityChronicMedicalConditions_2") FluentWebElement EligibilityChronicMedicalConditions_No;
    @FindBy(css = "#EligibilityChronicMedicalConditions_3") FluentWebElement EligibilityChronicMedicalConditions_Unsure;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 33;

    public void verifyInitialStateOfElements(Application app) {
        assertBlank(
            KidneyProblem_Yes,
            KidneyProblem_No,
            KidneyProblem_Unsure,
            EligibilitySurgery_Yes,
            EligibilitySurgery_No,
            EligibilitySurgery_Unsure,
            AdmitToHospPast90Days_Yes,
            AdmitToHospPast90Days_No,
            AdmitToHospPast90Days_Unsure,
            NursingFacility_Yes,
            NursingFacility_No,
            NursingFacility_Unsure,
            EligibilityHeartAttackTIAStroke_Yes,
            EligibilityHeartAttackTIAStroke_No,
            EligibilityHeartAttackTIAStroke_Unsure,
            EligibilityChronicMedicalConditions_Yes,
            EligibilityChronicMedicalConditions_No,
            EligibilityChronicMedicalConditions_Unsure);

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {
        verifyInitialStateOfElements(app);

        fillYesNoUnsureQuestion(KidneyProblem_Yes, KidneyProblem_No, KidneyProblem_Unsure, app.getKidneyProblem());
        fillYesNoUnsureQuestion(EligibilitySurgery_Yes, EligibilitySurgery_No, EligibilitySurgery_Unsure, app.getEligSurgery());
        fillYesNoUnsureQuestion(AdmitToHospPast90Days_Yes, AdmitToHospPast90Days_No, AdmitToHospPast90Days_Unsure, app.getEligibilityAdmitToHospPast90Days());
        fillYesNoUnsureQuestion(NursingFacility_Yes, NursingFacility_No, NursingFacility_Unsure, app.getNursingFacility());
        fillYesNoUnsureQuestion(EligibilityHeartAttackTIAStroke_Yes, EligibilityHeartAttackTIAStroke_No, EligibilityHeartAttackTIAStroke_Unsure, app.getEligibilityHeartAttackTIAStroke());
        fillYesNoUnsureQuestion(EligibilityChronicMedicalConditions_Yes, EligibilityChronicMedicalConditions_No, EligibilityChronicMedicalConditions_Unsure, app.getEligibilityChronicMedicalConditions());

        verifyStateOfElementAfterAnswers(app);
        clickNextAndWaitForSpinnerToFinish();


    }

    public void verifyStateOfElementAfterAnswers(Application app) {

        assertVisible(
            KidneyProblem_Yes,
            KidneyProblem_No,
            KidneyProblem_Unsure,
            EligibilitySurgery_Yes,
            EligibilitySurgery_No,
            EligibilitySurgery_Unsure,
            AdmitToHospPast90Days_Yes,
            AdmitToHospPast90Days_No,
            AdmitToHospPast90Days_Unsure,
            NursingFacility_Yes,
            NursingFacility_No,
            NursingFacility_Unsure,
            EligibilityHeartAttackTIAStroke_Yes,
            EligibilityHeartAttackTIAStroke_No,
            EligibilityHeartAttackTIAStroke_Unsure,
            EligibilityChronicMedicalConditions_Yes,
            EligibilityChronicMedicalConditions_No,
            EligibilityChronicMedicalConditions_Unsure);
        assertYesNoUnsureQuestion(KidneyProblem_Yes, KidneyProblem_No, KidneyProblem_Unsure, app.getKidneyProblem());
        assertYesNoUnsureQuestion(EligibilitySurgery_Yes, EligibilitySurgery_No, EligibilitySurgery_Unsure, app.getEligSurgery());
        assertYesNoUnsureQuestion(AdmitToHospPast90Days_Yes, AdmitToHospPast90Days_No, AdmitToHospPast90Days_Unsure, app.getEligibilityAdmitToHospPast90Days());
        assertYesNoUnsureQuestion(NursingFacility_Yes, NursingFacility_No, NursingFacility_Unsure, app.getNursingFacility());
        assertYesNoUnsureQuestion(EligibilityHeartAttackTIAStroke_Yes, EligibilityHeartAttackTIAStroke_No, EligibilityHeartAttackTIAStroke_Unsure, app.getEligibilityHeartAttackTIAStroke());
        assertYesNoUnsureQuestion(EligibilityChronicMedicalConditions_Yes, EligibilityChronicMedicalConditions_No, EligibilityChronicMedicalConditions_Unsure, app.getEligibilityChronicMedicalConditions());

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Eligibility Health Questions"));
    }
}

