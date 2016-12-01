package resources.pages.agentpages.uwExpansionPages.variations.eligibilityhealthquestions;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AR_EligibilityHealthQuestionsPage extends WizardPage {

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
    @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
    @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
    @FindBy(css = "#ESRD_3") FluentWebElement ESRD_Unsure;    
    
    @FindBy(css = "#ArteryorVeinBlockage_1") FluentWebElement ArteryorVeinBlockage_Yes;
    @FindBy(css = "#ArteryorVeinBlockage_2") FluentWebElement ArteryorVeinBlockage_No;
    @FindBy(css = "#ArteryorVeinBlockage_3") FluentWebElement ArteryorVeinBlockage_Unsure;    
    
    @FindBy(css = "#PeripheralVascularDisease_1") FluentWebElement PeripheralVascularDisease_Yes;
    @FindBy(css = "#PeripheralVascularDisease_2") FluentWebElement PeripheralVascularDisease_No;
    @FindBy(css = "#PeripheralVascularDisease_3") FluentWebElement PeripheralVascularDisease_Unsure;
    
    @FindBy(css = "#Cardiomyopathy_1") FluentWebElement Cardiomyopathy_Yes;
    @FindBy(css = "#Cardiomyopathy_2") FluentWebElement Cardiomyopathy_No;
    @FindBy(css = "#Cardiomyopathy_3") FluentWebElement Cardiomyopathy_Unsure;

    @FindBy(css = "#CongestiveHeartFailure_1") FluentWebElement CongestiveHeartFailure_Yes;
    @FindBy(css = "#CongestiveHeartFailure_2") FluentWebElement CongestiveHeartFailure_No;
    @FindBy(css = "#CongestiveHeartFailure_3") FluentWebElement CongestiveHeartFailure_Unsure;
    
    @FindBy(css = "#CoronaryArteryDisease_1") FluentWebElement CoronaryArteryDisease_Yes;
    @FindBy(css = "#CoronaryArteryDisease_2") FluentWebElement CoronaryArteryDisease_No;
    @FindBy(css = "#CoronaryArteryDisease_3") FluentWebElement CoronaryArteryDisease_Unsure;

    @FindBy(css = "#ChronicLungDisease_1") FluentWebElement ChronicLungDisease_Yes;
    @FindBy(css = "#ChronicLungDisease_2") FluentWebElement ChronicLungDisease_No;
    @FindBy(css = "#ChronicLungDisease_3") FluentWebElement ChronicLungDisease_Unsure;

    @FindBy(css = "#ChronicKidneyDisease_1") FluentWebElement ChronicKidneyDisease_Yes;
    @FindBy(css = "#ChronicKidneyDisease_2") FluentWebElement ChronicKidneyDisease_No;
    @FindBy(css = "#ChronicKidneyDisease_3") FluentWebElement ChronicKidneyDisease_Unsure;    
    
    @FindBy(css = "#Diabetes_1") FluentWebElement Diabetes_Yes;
    @FindBy(css = "#Diabetes_2") FluentWebElement Diabetes_No;
    @FindBy(css = "#Diabetes_3") FluentWebElement Diabetes_Unsure;    
    
    @FindBy(css = "#Cancer_1") FluentWebElement Cancer_Yes;
    @FindBy(css = "#Cancer_2") FluentWebElement Cancer_No;
    @FindBy(css = "#Cancer_3") FluentWebElement Cancer_Unsure;    
    
    @FindBy(css = "#CirrhosisDisease_1") FluentWebElement CirrhosisDisease_Yes;
    @FindBy(css = "#CirrhosisDisease_2") FluentWebElement CirrhosisDisease_No;
    @FindBy(css = "#CirrhosisDisease_3") FluentWebElement CirrhosisDisease_Unsure;

    @FindBy(css = "#EligibilityHeartAttackTIAStroke_1") FluentWebElement EligibilityHeartAttackTIAStroke_Yes;
    @FindBy(css = "#EligibilityHeartAttackTIAStroke_2") FluentWebElement EligibilityHeartAttackTIAStroke_No;
    @FindBy(css = "#EligibilityHeartAttackTIAStroke_3") FluentWebElement EligibilityHeartAttackTIAStroke_Unsure;
    
    @FindBy(css = "#EligibilityChronicMedicalConditions_1") FluentWebElement EligibilityChronicMedicalConditions_Yes;
    @FindBy(css = "#EligibilityChronicMedicalConditions_2") FluentWebElement EligibilityChronicMedicalConditions_No;
    @FindBy(css = "#EligibilityChronicMedicalConditions_3") FluentWebElement EligibilityChronicMedicalConditions_Unsure;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 48;

    public void verifyInitialStateOfElements(Application app) {
        isAt();
        app.getTest().log(LogStatus.INFO,"Page checkpoint passed");
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        
        assertBlank(KidneyProblem_Yes, KidneyProblem_No, KidneyProblem_Unsure);
        assertBlank(EligibilitySurgery_Yes, EligibilitySurgery_No, EligibilitySurgery_Unsure);
        assertBlank(AdmitToHospPast90Days_Yes, AdmitToHospPast90Days_No, AdmitToHospPast90Days_Unsure);
        assertBlank(NursingFacility_Yes, NursingFacility_No, NursingFacility_Unsure);
        assertBlank(EligibilityHeartAttackTIAStroke_Yes, EligibilityHeartAttackTIAStroke_No, EligibilityHeartAttackTIAStroke_Unsure);
        assertBlank(ESRD_Yes, ESRD_No, ESRD_Unsure);
        assertBlank(ArteryorVeinBlockage_Yes, ArteryorVeinBlockage_No, ArteryorVeinBlockage_Unsure);
        assertBlank(PeripheralVascularDisease_Yes, PeripheralVascularDisease_No, PeripheralVascularDisease_Unsure);
        assertBlank(Cardiomyopathy_Yes, Cardiomyopathy_No, Cardiomyopathy_Unsure);
        assertBlank(CongestiveHeartFailure_Yes, CongestiveHeartFailure_No, CongestiveHeartFailure_Unsure);
        assertBlank(CoronaryArteryDisease_Yes, CoronaryArteryDisease_No, CoronaryArteryDisease_Unsure);
        assertBlank(ChronicLungDisease_Yes, ChronicLungDisease_No, ChronicLungDisease_Unsure);
        assertBlank(ChronicKidneyDisease_Yes, ChronicKidneyDisease_No, ChronicKidneyDisease_Unsure);
        assertBlank(Diabetes_Yes, Diabetes_No, Diabetes_Unsure);
        assertBlank(Cancer_Yes, Cancer_No, Cancer_Unsure);
        assertBlank(CirrhosisDisease_Yes, CirrhosisDisease_No, CirrhosisDisease_Unsure);
        
    }

    public void fillAndSubmit(Application app) {
        verifyInitialStateOfElements(app);
        fillYesNoUnsureQuestion(KidneyProblem_Yes, KidneyProblem_No, KidneyProblem_Unsure, app.getKidneyProblem());
        fillYesNoUnsureQuestion(EligibilitySurgery_Yes, EligibilitySurgery_No, EligibilitySurgery_Unsure, app.getEligibilitySurgery());
        fillYesNoUnsureQuestion(AdmitToHospPast90Days_Yes, AdmitToHospPast90Days_No, AdmitToHospPast90Days_Unsure, app.getEligibilityAdmitToHospPast90Days());
        fillYesNoUnsureQuestion(NursingFacility_Yes, NursingFacility_No, NursingFacility_Unsure, app.getNursingFacility());
        fillYesNoUnsureQuestion(EligibilityHeartAttackTIAStroke_Yes, EligibilityHeartAttackTIAStroke_No, EligibilityHeartAttackTIAStroke_Unsure, app.getEligibilityHeartAttackTIAStroke());
        fillYesNoUnsureQuestion(ESRD_Yes, ESRD_No, ESRD_Unsure, app.getESRD());
        fillYesNoUnsureQuestion(ArteryorVeinBlockage_Yes, ArteryorVeinBlockage_No, ArteryorVeinBlockage_Unsure, app.getArteryorVeinBlockage());
        fillYesNoUnsureQuestion(PeripheralVascularDisease_Yes, PeripheralVascularDisease_No, PeripheralVascularDisease_Unsure, app.getPeripheralVascularDisease());
        fillYesNoUnsureQuestion(Cardiomyopathy_Yes, Cardiomyopathy_No, Cardiomyopathy_Unsure, app.getCardiomyopathy());
        fillYesNoUnsureQuestion(CongestiveHeartFailure_Yes, CongestiveHeartFailure_No, CongestiveHeartFailure_Unsure, app.getCongestiveHeartFailure());
        fillYesNoUnsureQuestion(CoronaryArteryDisease_Yes, CoronaryArteryDisease_No, CoronaryArteryDisease_Unsure, app.getCoronaryArteryDisease());
        fillYesNoUnsureQuestion(ChronicLungDisease_Yes, ChronicLungDisease_No, ChronicLungDisease_Unsure, app.getChronicLungDisease());
        fillYesNoUnsureQuestion(ChronicKidneyDisease_Yes, ChronicKidneyDisease_No, ChronicKidneyDisease_Unsure, app.getChronicKidneyDisease());
        fillYesNoUnsureQuestion(Diabetes_Yes, Diabetes_No, Diabetes_Unsure, app.getDiabetes());
        fillYesNoUnsureQuestion(Cancer_Yes, Cancer_No, Cancer_Unsure, app.getCancer());
        fillYesNoUnsureQuestion(CirrhosisDisease_Yes, CirrhosisDisease_No, CirrhosisDisease_Unsure, app.getCirrhosisDisease());
        
        verifyStateOfElementAfterAnswers(app);
        app.getTest().log(LogStatus.INFO,"Clicking Next..");
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
            ESRD_Yes, ESRD_No, ESRD_Unsure,
            ArteryorVeinBlockage_Yes, ArteryorVeinBlockage_No, ArteryorVeinBlockage_Unsure,
            Cardiomyopathy_Yes, Cardiomyopathy_No, Cardiomyopathy_Unsure,
            CongestiveHeartFailure_Yes, CongestiveHeartFailure_No, CongestiveHeartFailure_Unsure,
            CoronaryArteryDisease_Yes, CoronaryArteryDisease_No, CoronaryArteryDisease_Unsure,
            ChronicLungDisease_Yes, ChronicLungDisease_No, ChronicLungDisease_Unsure,
            ChronicKidneyDisease_Yes, ChronicKidneyDisease_No, ChronicKidneyDisease_Unsure,
            Diabetes_Yes, Diabetes_No, Diabetes_Unsure,
            Cancer_Yes, Cancer_No, Cancer_Unsure,
            CirrhosisDisease_Yes, CirrhosisDisease_No, CirrhosisDisease_Unsure            
        );

        assertYesNoUnsureQuestion(KidneyProblem_Yes, KidneyProblem_No, KidneyProblem_Unsure, app.getKidneyProblem());
        assertYesNoUnsureQuestion(EligibilitySurgery_Yes, EligibilitySurgery_No, EligibilitySurgery_Unsure, app.getEligibilitySurgery());
        assertYesNoUnsureQuestion(AdmitToHospPast90Days_Yes, AdmitToHospPast90Days_No, AdmitToHospPast90Days_Unsure, app.getEligibilityAdmitToHospPast90Days());
        assertYesNoUnsureQuestion(NursingFacility_Yes, NursingFacility_No, NursingFacility_Unsure, app.getNursingFacility());
        assertYesNoUnsureQuestion(EligibilityHeartAttackTIAStroke_Yes, EligibilityHeartAttackTIAStroke_No, EligibilityHeartAttackTIAStroke_Unsure, app.getEligibilityHeartAttackTIAStroke());
        

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Eligibility Health Questions"));
    }
}

