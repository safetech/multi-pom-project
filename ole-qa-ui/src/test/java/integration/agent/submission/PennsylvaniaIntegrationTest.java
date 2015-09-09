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
import pages.agent.variations.currentinsurancecoverage.AR_CurrentInsuranceCoveragePage;
import pages.agent.variations.planapplication.AR_PlanApplicationQuestionsPage;
<<<<<<< HEAD
import pages.agent.variations.replacenotice.RN078Page;
=======
import pages.agent.variations.replacenotice.RN034_AR_Page;
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
import queries.SubmissionQueryAgent;
import util.DateUtils;

public class PennsylvaniaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public AR_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public AR_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public AuthorizationPage authorizationPage;
<<<<<<< HEAD
    @Page public RN078Page replacementNotice;
=======
    @Page public RN034_AR_Page replacementNotice;
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

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
    public void test_pennsylvania_health_history_without_rn() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| PA]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        Application app = new Application();
        app.setState("PA");
        app.setZipCode("19044");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(69));
        app.setMPBED("05/01/2012");
<<<<<<< HEAD
=======

>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
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
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
<<<<<<< HEAD
        app.setFirstName(faker.letterify("??????????"));
        app.setLastName(faker.letterify("??????????"));
        app.setSuffix("PHD");
        app.setAddressLine1(faker.bothify("#### ??????????? ??"));
=======
        app.setFirstName("trBob");
        app.setLastName("adAutomation");
        app.setSuffix("PHD");
        app.setAddressLine1("11211 frStreet dr");
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
<<<<<<< HEAD
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening("1255561234");
        app.setGender("M");
        app.setMedicareClaimNum(faker.bothify("?#########"));
=======
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1255561234");
        app.setGender("M");
        app.setMedicareClaimNum("123443123A");
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
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
        app.setTurned65In6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
<<<<<<< HEAD
=======

>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setTurned65In6GA(NO);
        app.setPartBIn6GA(NO);
        app.setCPAPartBIn6(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(NO);
        app.setOtherMedplanstart("01/01/2012");
        app.setOtherMedplanend("01/01/2015");
        app.setIntentReplace(YES);
        app.setFirstTime(YES);
        app.setDropMedSuppForThisPlan(YES);
        app.setExistMedSupp(NO);
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

<<<<<<< HEAD
        expectedSubmissionResult.setPendingInfo("UNDERWRITING ELIGIBILITY", "REVIEW FOR POSSIBLE ESRD");
=======
        expectedSubmissionResult.setPendingInfo("ENROLLMENT MEMBERSHIP VERIFICATION", "VERIFY MEMBER NUMBER");
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee

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

        eligibilityHealthQuestionsPage.isAt();
        eligibilityHealthQuestionsPage.fillAndSubmit(app);

        healthHistoryQuestionsPage.isAt();
        healthHistoryQuestionsPage.fillAndSubmit(app);

        currentInsuranceCoveragePage.isAt();
        currentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationPage.isAt();
        authorizationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        planPaymentOptionsPage.isAt();
        planPaymentOptionsPage.fillAndSubmit(app);

        paymentDetailsSummaryPage.isAt();
        paymentDetailsSummaryPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isPending();

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
<<<<<<< HEAD
    public void test_pennsylvania_eligibility_underwriting_with_rn() throws Exception {
=======
    public void test_pennsylvania_eligibility_healthhistory_underwriting_with_rn() throws Exception {
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| PA]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        Application app = new Application();
        app.setState("PA");
        app.setZipCode("19044");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(67));
        app.setMPBED("01/01/2015");
        //Signatures
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
<<<<<<< HEAD
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(faker.letterify("??????????"));
        app.setLastName(faker.letterify("??????????"));
        app.setSuffix("PHD");
        app.setAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setAddressLine2("apt #123");
        app.setCity(faker.letterify("??????????"));
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum(faker.bothify("#########?"));
=======

        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName("rtyBob");
        app.setLastName("asAutomation");
        app.setSuffix("PHD");
        app.setAddressLine1("3211 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agent@uhc.com");
        app.setAgentEmailConfirm("agent@uhc.com");
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Eligibility Questions
        app.setTurned65In6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        //Plan application question
        app.setPartBIn6GA(NO);
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
<<<<<<< HEAD
=======

>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setCommonHealthHistoryAnswers();
<<<<<<< HEAD
        app.setAgentPrintedNameAdd(faker.letterify("??????????"));
        app.setAgentAddress(faker.letterify("??????????"));

        expectedSubmissionResult.setAcceptedInfo();
=======
        //SSForm Page
        app.setSS_FormDate("01/01/2001");
        app.setAgencyName("Agency Name");
        app.setAgencyAddress("Agency Address");
        app.setAgencyPhone("2346759876");
        expectedSubmissionResult.setPendingInfo("ENROLLMENT MEMBERSHIP VERIFICATION", "VERIFY MEMBER NUMBER");
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee

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

        eligibilityHealthQuestionsPage.isAt();
        eligibilityHealthQuestionsPage.fillAndSubmit(app);

<<<<<<< HEAD
=======
        healthHistoryQuestionsPage.isAt();
        healthHistoryQuestionsPage.fillAndSubmit(app);

>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
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

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
