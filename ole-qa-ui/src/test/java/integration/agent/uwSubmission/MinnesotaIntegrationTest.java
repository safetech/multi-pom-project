package integration.agent.uwSubmission;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.agent.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.agent.*;
import pages.agent.uwExpansion.variations.authorization.OR_AuthorizationPage;
import pages.agent.uwExpansion.variations.checkeligibility.ME_CA_FL_CheckEligibilityAndAvailabilityPage;
import pages.agent.uwExpansion.variations.currentinsurancecoverage.WA_CurrentInsuranceCoveragePage;
import pages.agent.uwExpansion.variations.eligibilityhealthquestions.ME_CA_FL_EligibilityHealthQuestionsPage;
import pages.agent.uwExpansion.variations.planapplication.MN_PlanApplicationQuestionsPage;
import pages.agent.uwExpansion.variations.planselection.riders_MN_PlanSelectionPage;
import pages.agent.variations.replacenotice.RN034andRE073WithSignaturePage;
import queries.SubmissionQueryAgent;
import util.DateUtils;;

public class MinnesotaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public riders_MN_PlanSelectionPage planSelectionPage;
    @Page public ME_CA_FL_CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public MN_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public ME_CA_FL_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public WA_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public OR_AuthorizationPage authorizationPage;
    @Page public RN034andRE073WithSignaturePage replacementNotice;
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
        app = new Application();

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

        app.setState("MN");
        app.setZipCode("55445");
        expectedSubmissionResult = new SubmissionResult();
    }
    @Test
    public void test_minnesota_guranteed_acceptance() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| PA| WA| MN]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
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
        app.setPhoneEvening("1255561234");
        app.setMedicareClaimNum(faker.bothify("?#########"));
        app.setGender("M");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agent@uhc.com");
        app.setAgentEmailConfirm("agent@uhc.com");
        //Plan ApplicationPage
        app.setPlanEffIn6OfEligible(YES);
        //Past And Current Coverage
        app.setCPATurned65(YES);
        app.setCPAPartBIn6(YES);
        app.setMedicaidCovered(NO);
        app.setExistingMedicare(NO);
        app.setExistMedSupp(NO);
        app.setOtherInsCoverage(NO);
        //Agent Verification page
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentFirstName("AgnetFirst");
        app.setAgentMI("A");
        app.setAgentLastName("AgentLast");
        app.setAgentPhone("3334445555");
        //Mailing Address
        app.setMailingAddressCheck(NO);
        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.fillAndSubmit(app);
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
//        expectedSubmissionResult.setPendingInfo("ENROLLMENT GI REVIEW","BBA REVIEW REQUIRED");
//        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }
    @Test
    public void test_minnesota_eligibility_healthhistory_underwriting_with_rn() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| PA| WA]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setState("MN");
        app.setZipCode("55445");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(67));
        app.setMPBED("01/01/2012");
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
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agent@uhc.com");
        app.setAgentEmailConfirm("agent@uhc.com");
        //Plan application question\
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        app.setMedSuppReplace(NO);
        app.setTurned65In6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
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
        app.setTobaccoUse(YES);
        //Eligibility Health Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
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
        app.setAgentPrintedNameAdd(faker.letterify("??????????"));
        app.setAgentAddress(faker.letterify("??????????"));
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("MN"));
        app.setMailingZipCode(faker.numerify("#####"));
        //SSForm Page
        app.setSS_FormDate("01/01/2001");
        app.setAgencyName("Agency Name");
        app.setAgencyAddress("Agency Address");
        app.setAgencyPhone("2346759876");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

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
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        //expectedSubmissionResult.setPendingInfo("ENROLLMENT MISSING INFORMATION","CPA REVIEW REQUIRED");
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
