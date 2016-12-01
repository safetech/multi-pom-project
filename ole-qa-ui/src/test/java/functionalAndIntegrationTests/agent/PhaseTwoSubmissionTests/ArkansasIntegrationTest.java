package functionalAndIntegrationTests.agent.PhaseTwoSubmissionTests;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import queries.AgentSubmissionQuery;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import resources.pages.agentpages.uwExpansionPages.*;
import resources.pages.agentpages.uwExpansionPages.variations.authorization.AR_AuthorizationPage;
import resources.pages.agentpages.uwExpansionPages.variations.checkeligibility.ME_CA_FL_CheckEligibilityAndAvailabilityPage;
import resources.pages.agentpages.uwExpansionPages.variations.currentinsurancecoverage.CA_AR_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.uwExpansionPages.variations.eligibilityhealthquestions.AR_EligibilityHealthQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.planapplication.AR_PlanApplicationQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.replacenotice.RN034_AR_Page;
import resources.pages.agentpages.uwExpansionPages.variations.whatyouneed.AR_WhatYouNeedPage;
import resources.reports.ExtentManager;
import resources.utils.DateUtils;

public class ArkansasIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public ME_CA_FL_CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public AR_WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public AR_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public AR_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public CA_AR_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public AR_AuthorizationPage authorizationPage;
    @Page public RN034_AR_Page replacementNotice;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public PreferencesPage preferencesPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;

    public AgentSubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;
    private String marketabilityCode = null;
    ExtentReports rep = ExtentManager.getInstance();
    @Before
    public void setup() {
        submissionQuery = new AgentSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        app = new Application();
        app.setState("AR");
        app.setZipCode("71611");
        app.setAgentFirstName(faker.firstName());
        app.setAgentLastName(faker.lastName());
        app.setAgentMI(faker.letterify(" ? "));
        
        marketabilityCode = "S25F49AGMMAR01_01D";
        expectedSubmissionResult = new SubmissionResult();

        app.setCpaSignatureIndTouch(Application.ALL_SIGNATURES[0]);
        app.setSignatureIndTouch(Application.ALL_SIGNATURES[1]);
        app.setMedicalReleaseAuthSignatureIndTouch(Application.ALL_SIGNATURES[2]);
        app.setDesigneeSigTouch(Application.ALL_SIGNATURES[3]);
        app.setAgentSignatureIndTouch(Application.ALL_SIGNATURES[4]);
        app.setAgentRNSignatureIndTouch(Application.ALL_SIGNATURES[5]);
        app.setApplicantRNSignatureIndTouch(Application.ALL_SIGNATURES[6]);
        app.setEftSignatureIndTouch(Application.ALL_SIGNATURES[7]);
        app.setMedicalReleaseClaimSignatureIndTouch(Application.ALL_SIGNATURES[8]);
        app.setSS_App_Signature1(Application.ALL_SIGNATURES[9]);
        app.setSS_Agent_Signature1(Application.ALL_SIGNATURES[10]);
        app.setReplacementAgentSignInd2Touch(Application.ALL_SIGNATURES[11]);
        app.setOnlinePreferenceSignatureTouch(Application.ALL_SIGNATURES[12]);
        app.setIL23991Touch(Application.ALL_SIGNATURES[13]);
        app.setIL23993Touch(Application.ALL_SIGNATURES[14]);
    }

    @Test
    public void AGENT_Arkansas_GI() throws Exception {
        sheet.setAgentCertificationYears("[2016| 2017| 2018]");
        sheet.setAgentID("AutoTester");
        sheet.setAgentMedSuppStates("[NV| AR| MA| FL| NY| OH]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName(app.getAgentFirstName()+app.getAgentMI()+app.getAgentLastName());
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@uhc.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setMethodName("AGENT_Arkansas_GI");
        app.setState("AR");
        app.setZipCode("71611");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"_InteliJ"+faker.firstName());
        app.setMI(this.faker.letterify("?"));
        app.setLastName(this.faker.lastName());
        app.setSuffix("PHD");
        app.setAddressLine1("111 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail(this.faker.letterify("??????????")+"@uhc.com");
//        app.setEmail("wlvr@arurgitu.gq");
        app.setConfirmEmail(app.getEmail());
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
        app.setGIEmployerCov(NO);
        app.setGIMediCal(NO);
        app.setGIMilitary(NO);
        app.setGILocation(NO);
        //Eligibility Questions
        app.setPlanEffIn6OfEligible(YES);
        //Past And Current Coverage
        app.setMedicaidCovered(NO);
        app.setExistingMedicare(NO);
        app.setExistMedSupp(NO);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);
        //Plan Payment Options
        app.setPlanPaymentOptions("Recurring");
        //Agent Verification page
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentPhone("3334445555");
        //Sig required
        app.setMedicalReleaseAuthSignatureIndRequired("Required");
        //Mailing Address
        app.setMailingAddressCheck(NO);
        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setCommonHealthHistoryAnswers();

        app.setTest(rep.startTest("AGENT_Arkansas_GI"));
        goTo(cheatPage);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Cheat Page");
        cheatPage.fillAndSubmit(sheet);
        app.getTest().log(LogStatus.INFO,"Fill Check Eligibility And Availability Page");
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Verifying Marketability Code");
        planSelectionPage.checkMarketabilityCode(marketabilityCode);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Plan Selection Page");
        planSelectionPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit What You Need Page");
        whatYouNeedPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Custer Information Page");
        customerInformationPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Plan Application Questions Page");
        planApplicationQuestionsPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Current Insurance Coverage Page");
        currentInsuranceCoveragePage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Authorization Page");
        authorizationPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Agent Verification Page");
        agentVerificationPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Plan Payment Options Page");
        planPaymentOptionsPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Payment Details Summary Page");
        paymentDetailsSummaryPage.fillAndSubmit(app);
        app.getTest().log(LogStatus.INFO,"Fill and Submit Preferences Page");
        preferencesPage.fillAndSubmit( app );
        app.getTest().log(LogStatus.INFO,"Fill and Submit Review And Submit Page");
        reviewAndSubmitPage.fillAndSubmit(app);

        logger.info(reviewAndSubmitPage.getQuestionMapValues());
        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifyUwExpansionSubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }
    @Test
    public void AGENT_Arkansas_Eligibility_FU_With_RN() throws Exception {
        sheet.setAgentCertificationYears("[2016| 2017| 2018]");
        sheet.setAgentID("AutoTester");
        sheet.setAgentMedSuppStates("[NV| AR| MA| FL| NY| OH]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName(faker.firstName()+" f "+faker.lastName());
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@uhc.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        sheet.setAgentName(app.getAgentFirstName()+app.getAgentMI()+app.getAgentLastName());
        app.setMethodName("AGENT_Arkansas_Eligibility_FU_With_RN");
        app.setState("AR");
        app.setZipCode("71611");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(75));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"Agent_FU_InteliJ");
        app.setMI(this.faker.letterify("?"));
        app.setLastName(this.faker.lastName());
        app.setSuffix("PHD");
        app.setAddressLine1("111 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("jaxon18@g212dnk5.com");
        app.setConfirmEmail(app.getEmail());
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
        //Plan Application Question
        app.setPlanEffIn6OfEligible(NO);
        app.setGI30dayBday(NO);
        app.setESRD(NO);
        app.setCAGuaranteedAcceptance(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
        //Eligibility Health Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
        //Current Insurance Coverage
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
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        app.setMSInsCompany("Blue Cross Blue Shield");
        app.setMSPLAN("Medical Supplement");
        //Agent Verification page
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentPhone("3334445555");
        //Plan Payment Options
        app.setPlanPaymentOptions("Recurring");
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("CA"));
        app.setMailingZipCode(faker.numerify("#####"));
        //Eligibility Health Questions
        app.setNoToAllEligibilityAnswers();        
        //Sig required
        app.setMedicalReleaseAuthSignatureIndRequired("Required");
        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();

        app.setTest(rep.startTest("AGENT_Arkansas_Eligibility_FU_With_RN"));
        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode(marketabilityCode);
        planSelectionPage.fillAndSubmit(app);
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        preferencesPage.fillAndSubmit( app );
        reviewAndSubmitPage.fillAndSubmit(app);
        
        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifyUwExpansionSubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

    @After
    public void endTest(){
        rep.endTest(app.getTest());
        rep.flush();
    }
}

