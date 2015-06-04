package integration.phone.submission;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import integration.phone.entity.Application;
import integration.phone.entity.CribSheet;
import integration.phone.entity.SubmissionResult;
import integration.phone.pages.*;
import integration.phone.pages.variations.pastandcurrentcoverage.CA_PA_NJ_IN_PastAndCurrentInsuranceCoveragePage;
import integration.phone.pages.variations.planapplicationpage.DEGuranteedIssuePlanApplicationQuestions;
import integration.phone.pages.variations.planapplicationpage.DE_NV_IN_PlanApplicationQuestions;
import integration.phone.pages.variations.replacementnotice.RN034andRE073Page;
import integration.phone.queries.SubmissionQuery;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;

public class DelawareIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public DE_NV_IN_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public DEGuranteedIssuePlanApplicationQuestions GIplanApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public CA_PA_NJ_IN_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_delaware_health_history_underwriting_with_rn() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("DE", "19701");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2012-04-01");
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");

        Application app = new Application(sheet);

        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/2012");
        app.setMPBED("04/01/2012");
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        //Plan Eligibility
        app.setTurned65In6GA(NO); //TODO: Replace these hard coded values with helper function that will determine answer based upon DOB
        app.setPartBIn6GA(NO); //TODO: Replace these hard coded values with helper function that will determine answer based upon MPBED
        app.setPlanEffIn6OfEligible(NO);  //TODO: Replace these hard coded values with helper function that will determine answer based upon DOB & MPBED
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Health History
        app.setEmphysema(YES);
        app.setOthercancer(YES);
        app.setPolycystic(YES);
        app.setCirrhosis(YES);
        app.setBonemarrow(YES);
        app.setPancreatitis(YES);
        app.setAmputation(YES);
        app.setAlcohol(YES);
        app.setParaplegia(YES);
        app.setBipolar(YES);
        app.setMacular(YES);
        app.setAlzheimers(YES);
        app.setHIV(YES);
        //Past And Current Coverage
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
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Agent Verification Page
        app.setAgentOtherInsPoliciesSold("HIP");
        app.setAgentPoliciesInForce("EP");
        app.setAgentPoliciesSoldNotInForce("EPHIP");
        app.setAgentSignatureInd(YES);
        //Replacement Notice Page
        app.setReplacementReason("OtherReason");
        app.setRNOther("Cheaper");
        app.setAgentPrintedNameAdd("ProducerName");
        app.setAgentAddress("ProducerAdd");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");

        expectedSubmissionResult.setAdjudicationStatus("P");
        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setWorkQueue("UNDERWRITING");
        expectedSubmissionResult.setWorkQueueReason("REVIEW FOR POSSIBLE ESRD");

        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.isAt();
        cheatPage.fillAndSubmit(sheet);

        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);

        customerInformationPage.isAt();
        customerInformationPage.fillAndSubmit(app);

        planSelectionAndStartDatePage.isAt();
        planSelectionAndStartDatePage.fillAndSubmit(app);

        planApplicationQuestionsPage.isAt();
        planApplicationQuestionsPage.fillAndSubmit(app);

        eligibilityHealthQuestionsPage.isAt();
        eligibilityHealthQuestionsPage.fillAndSubmit(app);

        healthHistoryQuestionsPage.isAt();
        healthHistoryQuestionsPage.fillAndSubmit(app);

        pastAndCurrentInsuranceCoveragePage.isAt();
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationAndVerificationPage.isAt();
        authorizationAndVerificationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        replacementNoticePage.isAt();
        replacementNoticePage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isPending();

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

    @Test
    public void test_delaware_eligibility_underwriting_without_rn() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("DE", "19701");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setMedPartBdate("2015-03-01");
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");

        Application app = new Application(sheet);

        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/2012");
        app.setMPBED("03/01/2015");
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        //Plan Eligibility
        app.setTurned65In6GA(YES); //TODO: Replace these hard coded values with helper function that will determine answer based upon DOB
        app.setPartBIn6GA(YES); //TODO: Replace these hard coded values with helper function that will determine answer based upon MPBED
        app.setPlanEffIn6OfEligible(YES);  //TODO: Replace these hard coded values with helper function that will determine answer based upon DOB & MPBED
        app.setLostCoverage(NO);
        app.setTobaccoUse(NO);
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Health History
        app.setEmphysema(YES);
        app.setOthercancer(YES);
        app.setPolycystic(YES);
        app.setCirrhosis(YES);
        app.setBonemarrow(YES);
        app.setPancreatitis(YES);
        app.setAmputation(YES);
        app.setAlcohol(YES);
        app.setParaplegia(YES);
        app.setBipolar(YES);
        app.setMacular(YES);
        app.setAlzheimers(YES);
        app.setHIV(YES);
        //Past And Current Coverage
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(NO);
        app.setOtherMedplanstart("");
        app.setOtherMedplanend("");
        app.setIntentReplace("");
        app.setFirstTime("");
        app.setDropMedSuppForThisPlan("");
        app.setExistMedSupp(NO);
        app.setReplaceExistingMedSup("");
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Agent Verification Page
        app.setAgentOtherInsPoliciesSold("HIP");
        app.setAgentPoliciesInForce("EP");
        app.setAgentPoliciesSoldNotInForce("EPHIP");
        app.setAgentSignatureInd(YES);
        //Replacement Notice Page
        app.setReplacementReason("OtherReason");
        app.setRNOther("Cheaper");
        app.setAgentPrintedNameAdd("ProducerName");
        app.setAgentAddress("ProducerAdd");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");

        expectedSubmissionResult.setAdjudicationStatus("A");
        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setWorkQueue("");
        expectedSubmissionResult.setWorkQueueReason("");

        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.isAt();
        cheatPage.fillAndSubmit(sheet);

        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);

        customerInformationPage.isAt();
        customerInformationPage.fillAndSubmit(app);

        planSelectionAndStartDatePage.isAt();
        planSelectionAndStartDatePage.fillAndSubmit(app);

        GIplanApplicationQuestionsPage.isAt();
        GIplanApplicationQuestionsPage.fillAndSubmit(app);

        pastAndCurrentInsuranceCoveragePage.isAt();
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationAndVerificationPage.isAt();
        authorizationAndVerificationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
