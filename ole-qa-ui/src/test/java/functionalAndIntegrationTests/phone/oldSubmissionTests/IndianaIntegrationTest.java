package functionalAndIntegrationTests.phone.oldSubmissionTests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.phone.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import resources.pages.phonepages.oldOlePages.*;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.pages.phonepages.oldOlePages.variations.pastandcurrentcoverage.CA_PA_NJ_IN_OR_PastAndCurrentInsuranceCoveragePage;
import resources.pages.phonepages.oldOlePages.variations.planapplication.IN_OK_PlanApplicationQuestions;
import resources.pages.phonepages.oldOlePages.variations.replacementnotice.RN034andRE073Page;
import queries.PhoneSubmissionQuery;
import resources.utils.DateUtils;

public class IndianaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public IN_OK_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public CA_PA_NJ_IN_OR_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page ReplacementNotice034Page;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

          public PhoneSubmissionQuery phoneSubmissionQuery;
          private Faker faker;
          private CribSheet sheet;
          private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        phoneSubmissionQuery = new PhoneSubmissionQuery();
        faker = new Faker();

        sheet = new CribSheet(faker);
        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("IN", "46001");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");
        sheet.setGRSId(faker.numerify("######"));
        app = new Application();
        // Customer Info Page Question
        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);

        //Agent Verification Page
        app.setCommonAgentVerificationAnswers();
        app.setCommonHealthHistoryAnswers();
        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_indiana_full_underwriting_with_rn() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(70));
        sheet.setMedPartBdate("2010-10-01");

        //Customer Information
        app.setMPAED("01/01/2011");
        app.setMPBED("10/01/2010");

        //Plan Eligibility
        app.setTurned65In6GA(NO);
        app.setPartBIn6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
        //Plan application Questions
        app.setMedSuppReplace(NO);
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Health History
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(YES);
        app.setOtherMedplanstart("01/01/2000");
        app.setOtherMedplanend("01/01/2015");
        app.setIntentReplace(YES);
        app.setFirstTime(YES);
        app.setDropMedSuppForThisPlan(YES);
        app.setExistMedSupp(YES);
        app.setMSInsCompany("Blue Cross Blue Shield");
        app.setMSPLAN("Medical Supplement");
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


        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        // The above resources.util.pages will always appear
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        healthHistoryQuestionsPage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        ReplacementNotice034Page.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isPending();

        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");

        phoneSubmissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        phoneSubmissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }

    @Test
    public void test_indiana_guranteed_issue_without_rn() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(1));

        //Customer Information
        app.setMPAED("01/01/2011");
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        //Plan Eligibility
        app.setTurned65In6GA(YES);
        app.setPartBIn6GA(YES);
        app.setPlanEffIn6OfEligible(YES);
        app.setTobaccoUse(YES);
        //Plan application Questions
        app.setMedSuppReplace(NO);
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Health History

        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
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


        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        // The above resources.util.pages will always appear
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.isAt();
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        expectedSubmissionResult.setAcceptedInfo();

        phoneSubmissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        phoneSubmissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}


