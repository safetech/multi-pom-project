package functionalAndIntegrationTests.phone.uwSubmissionTests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.phone.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.pages.phonepages.uwExpansionPages.*;
import resources.pages.phonepages.uwExpansionPages.variations.authorization.ME_AuthorizationAndVerificationPage;
import resources.pages.phonepages.uwExpansionPages.variations.eligibilityhealthquestions.CA_ME_OR_WA_EligibilityHealthQuestionsPage;
import resources.pages.phonepages.uwExpansionPages.variations.pastandcurrentcoverage.ME_PastAndCurrentInsuranceCoveragePage;
import resources.pages.phonepages.uwExpansionPages.variations.planapplication.ME_PlanApplicationQuestions;
import resources.pages.phonepages.uwExpansionPages.variations.replacementnotice.RN034andRE073Page;
import queries.PhoneSubmissionQuery;
import resources.utils.DateUtils;

public class MaineIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public ME_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public CA_ME_OR_WA_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public ME_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public ME_AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public PreferencesPage preferencesPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public PhoneSubmissionQuery phoneSubmissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;
    private Application app;

    @Before
    public void setup() {
        phoneSubmissionQuery = new PhoneSubmissionQuery();
        faker = new Faker();

        sheet = new CribSheet(faker);
        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("ME", "04001");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDpsdToFirstDayOfFutureMonth(3);
        sheet.setPlanCode("F01");
        sheet.setGRSId(faker.numerify("######"));
        app = new Application();

        //Customer Info Page Question
        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(3));

        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Agent Verification Page
        app.setCommonAgentVerificationAnswers();

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void PHONE_Maine_HH_FU_With_DesigneeSig_And_RN() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(71));
        sheet.setMedPartBdate("2010-04-01");
        app.setAgentFullName("Agent Name: "+sheet.getAgentFullName());
        // Customer Info Page
        app.setMPAED("01/01/2010");
        app.setMPBED("04/01/2010");

        //Plan Application Questions Page
        app.setPlanEffIn6OfEligible(NO);
        app.setTobaccoUse(NO);
        app.setLostCoverage(NO);
        app.setContinuousCoverage(NO);

        //Eligibility Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
        //Health History
        app.setCommonHealthHistoryAnswers();

        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(YES);
        app.setOtherMedplanstart("01/01/2012");
        app.setOtherMedplanend("01/01/2015");
        app.setIntentReplace(YES);
        app.setFirstTime(YES);
        app.setDropMedSuppForThisPlan(YES);
        app.setExistMedSupp(YES);
        app.setMSInsCompany("Blue Cross Blue Shield ME");
        app.setMSPLAN("Medical Supplement ME");
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setContinuousMedicareCoverageNoGap(YES);
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);

        //Authorizationa and verififcation page
        app.setDesignateLapse(NO);
        app.setAuxFirstName("AuxFirstName");
        app.setAuxMI("M");
        app.setAuxLastName("AuxLastName");
        app.setAuxAddressLine1("AuxAddressLine1");
        app.setAuxCity("AuxCity");
        app.setAuxState("ME");
        app.setAuxZipCode("04010");

        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
//Preference Page
        app.setEmail("alkjas@bd.com");
        
        
        expectedSubmissionResult.setPendingInfo("ENROLLMENT EA SPECIAL PROCESSING","EA INDIVIDUAL");
        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.checkMarketabilityCode("M13T43AGMMME01_01E");
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNoticePage.fillAndSubmit(app);
        preferencesPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isApprovedOrPending();
        
        phoneSubmissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        phoneSubmissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

    @Test
    public void PHONE_Maine_Eligibility_FU_DesigneeSig_Without_RN() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(68));
        sheet.setMedPartBdate("2014-01-01");
        // Customer Info Page
        app.setMPAED("01/01/2014");
        app.setMPBED("01/01/2014");
        //Eligibility Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
//        //Plan Application
        app.setPlanEffIn6OfEligible(NO);
        app.setContinuousCoverage(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(NO);
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(NO);
        app.setFirstTime(BLANK);
        app.setDropMedSuppForThisPlan(BLANK);
        app.setExistMedSupp(NO);
        app.setMSInsCompany("Blue Cross Blue Shield");
        app.setMSPLAN("Medical Supplement");
        app.setReplaceExistingMedSup(BLANK);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setContinuousMedicareCoverageNoGap(YES);
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);
        
        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.checkMarketabilityCode("M13T43AGMMME01_01E");
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isApprovedOrPending();

        expectedSubmissionResult.setPendingInfo("ENROLLMENT EA SPECIAL PROCESSING","EA INDIVIDUAL");
        phoneSubmissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        phoneSubmissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
