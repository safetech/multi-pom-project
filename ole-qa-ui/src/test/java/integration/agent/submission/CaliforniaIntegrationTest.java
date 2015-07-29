package integration.agent.submission;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.agent.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.agent.*;
import pages.agent.variations.authorization.CA_AuthorizationPage;
import pages.agent.variations.currentinsurancecoverage.CA_CurrentInsuranceCoveragePage;
import pages.agent.variations.eligibilityhealthquestions.CA_EligibilityHealthQuestionsPage;
import pages.agent.variations.planapplication.CA_PlanApplicationQuestionsPage;
import pages.agent.variations.replacenotice.RN034andRE073WithSignaturePage;
import queries.SubmissionQueryAgent;
import util.DateUtils;

public class CaliforniaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public CA_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public CA_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public CA_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public CA_AuthorizationPage authorizationPage;
    @Page public RN034andRE073WithSignaturePage replacementNotice;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;


    public SubmissionQueryAgent submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQueryAgent();
        faker = new Faker();
        sheet = new CribSheet(faker);

        expectedSubmissionResult = new SubmissionResult();
    }
    @Test
    public void test_california_eligibility_underwriting_with_rn() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);

        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        Application app = new Application();

        app.setState("CA");
        app.setZipCode("90210");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(70));
        app.setMPBED("01/01/2012");
        app.setCpaSignatureIndTouch(Application.ALL_SIGNATURES[0]);
        app.setSignatureIndTouch(Application.ALL_SIGNATURES[1]);
        app.setMedicalReleaseAuthSignatureIndTouch(Application.ALL_SIGNATURES[2]);
        app.setDesigneeSigTouch(Application.ALL_SIGNATURES[3]);
        app.setAgentSignatureIndTouch(Application.ALL_SIGNATURES[4]);
        app.setAgentRNSignatureIndTouch(Application.ALL_SIGNATURES[5]);
        app.setApplicantRNSignatureIndTouch(Application.ALL_SIGNATURES[6]);
        app.setEftSignatureIndTouch(Application.ALL_SIGNATURES[7]);
        app.setMedicalReleaseClaimSignatureIndTouch(Application.ALL_SIGNATURES[8]);

        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(this.faker.firstName());
        app.setMI(this.faker.letterify("?"));
        app.setLastName(this.faker.lastName());
        app.setSuffix("PHD");
        app.setAddressLine1("111 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agent@uhc.com");
        app.setAgentEmailConfirm("agent@uhc.com");
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Eligibility Questions(SPECIFIC TO CA)
        app.setEligdialysis(NO);
        app.setEligRecdialysis(NO);
        app.setEligHospital(NO);
        app.setEligSurgery(NO);
        app.setEligOrgan(NO);
        app.setEligSpine(NO);
        app.setEligjoint(NO);
        app.setEligCancer(NO);
        app.setEligHeart(NO);
        app.setEligVascular(NO);
        app.setGI30dayBday(NO);
        app.setGIEmployerCov(NO);
        app.setGIMediCal(NO);
        app.setGIMilitary(NO);
        app.setGILocation(NO);
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
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
        app.setMSInsCompany("Blue Cross Blue Shield NV");
        app.setMSPLAN("Medical Supplement NV");
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Agent Verification page
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentFirstName("AgnetFirst");
        app.setAgentMI("A");
        app.setAgentLastName("AgentLast");
        app.setAgentPhone("3334445555");

        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.isAt();
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);

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
        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);
        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void test_california_guranteed_issue() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        Application app = new Application();
        app.setState("CA");
        app.setZipCode("90210");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(66));
        app.setMPBED("05/01/2015");
        app.setCpaSignatureIndTouch(Application.ALL_SIGNATURES[0]);
        app.setSignatureIndTouch(Application.ALL_SIGNATURES[1]);
        app.setMedicalReleaseAuthSignatureIndTouch(Application.ALL_SIGNATURES[2]);
        app.setDesigneeSigTouch(Application.ALL_SIGNATURES[3]);
        app.setAgentSignatureIndTouch(Application.ALL_SIGNATURES[4]);
        app.setAgentRNSignatureIndTouch(Application.ALL_SIGNATURES[5]);
        app.setApplicantRNSignatureIndTouch(Application.ALL_SIGNATURES[6]);
        app.setEftSignatureIndTouch(Application.ALL_SIGNATURES[7]);
        app.setMedicalReleaseClaimSignatureIndTouch(Application.ALL_SIGNATURES[8]);
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(this.faker.firstName());
        app.setMI(this.faker.letterify("?"));
        app.setLastName(this.faker.lastName());
        app.setSuffix("PHD");
        app.setAddressLine1("111 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
        app.setMPAED("01/01/2015");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agent@uhc.com");
        app.setAgentEmailConfirm("agent@uhc.com");
        //app.setDefaultPlanEligibilityQuestions(sheet);
        app.setGI30dayBday(YES);
        app.setGIEmployerCov(NO);
        app.setGIMediCal(NO);
        app.setGIMilitary(NO);
        app.setGILocation(NO);
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Eligibility Questions(SPECIFIC TO CA)
        app.setEligdialysis(NO);
        app.setEligRecdialysis(NO);
        app.setEligHospital(NO);
        app.setEligSurgery(NO);
        app.setEligOrgan(NO);
        app.setEligSpine(NO);
        app.setEligjoint(NO);
        app.setEligCancer(NO);
        app.setEligHeart(NO);
        app.setEligVascular(NO);
        app.setTobaccoUse(YES);
        //Past And Current Coverage
        app.setCPATurned65(YES);
        app.setCPAPartBIn6(YES);
        app.setPlanEffIn6OfEligible(YES);
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
        app.setMSInsCompany("Blue Cross Blue Shield NV");
        app.setMSPLAN("Medical Supplement NV");
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Agent Verification page
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentFirstName("AgnetFirst");
        app.setAgentMI("A");
        app.setAgentLastName("AgentLast");
        app.setAgentPhone("3334445555");

        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();

        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setCommonHealthHistoryAnswers();

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.isAt();
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);

        planSelectionPage.isAt();
        planSelectionPage.fillAndSubmit(app);

        whatYouNeedPage.isAt();
        whatYouNeedPage.fillAndSubmit(app);

        customerInformationPage.isAt();
        customerInformationPage.fillAndSubmit(app);

        planApplicationQuestionsPage.isAt();
        planApplicationQuestionsPage.fillAndSubmit(app);

        currentInsuranceCoveragePage.isAt();
        currentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationPage.isAt();
        authorizationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        replacementNotice.isAt();
        replacementNotice.fillAndSubmit(app);

        planPaymentOptionsPage.isAt();
        planPaymentOptionsPage.fillAndSubmit(app);

        paymentDetailsSummaryPage.isAt();
        paymentDetailsSummaryPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }

}
