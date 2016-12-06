package functionalAndIntegrationTests.agent.uwSubmissiontests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import resources.pages.agentpages.uwExpansionPages.*;
import resources.pages.agentpages.uwExpansionPages.variations.checkeligibility.ME_CA_FL_CheckEligibilityAndAvailabilityPage;
import resources.pages.agentpages.uwExpansionPages.variations.currentinsurancecoverage.FL_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.uwExpansionPages.variations.eligibilityhealthquestions.MN_ME_CA_FL_EligibilityHealthQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.planapplication.FL_PlanApplicationQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.replacenotice.RN034_RN038_RN073WithSignaturePage;
import resources.pages.agentpages.uwExpansionPages.variations.statespecificationform.SupplementalFormPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.AgentSubmissionQuery;
import resources.utils.DateUtils;

public class FloridaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public ME_CA_FL_CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public FL_PlanApplicationQuestionsPage planApplicationQuestionsPagePage;
    @Page public MN_ME_CA_FL_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public FL_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public AuthorizationPage authorizationPage;
    @Page public RN034_RN038_RN073WithSignaturePage replacementNotice;
    @Page public SupplementalFormPage supplementalFormPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public AgentSubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new AgentSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        app = new Application();
        sheet.setAgentCertificationYears("[2016| 2017| 2018]");
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
        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void AGENT_Florida_Eligibility_FU_With_RN() throws Exception {

        sheet.setAgentID("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("FL");
        app.setZipCode("32065");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(75));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"Agent_FU_InteliJ");
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
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
        //Plan Application Question
        app.setPlanEffIn6OfEligible(NO);
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Eligibility Health Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
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
        app.setCommonHealthHistoryAnswers();
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("ME"));
        app.setMailingZipCode(faker.numerify("#####"));
        //SSForm Page
        app.setSS_FormDate("01/01/2001");
        app.setAgencyName("Agency Name");
        app.setAgencyAddress("Agency Address");
        app.setAgencyPhone("2346759876");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.isAt();
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("S03Q43AGMMFL03_02B");
        planSelectionPage.fillAndSubmit(app);
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPagePage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        supplementalFormPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setPendingInfo("ENROLLMENT MEMBERSHIP VERIFICATION", "VERIFY MEMBER NUMBER");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void AGENT_Florida_GI() throws Exception {

        sheet.setAgentID("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setState("FL");
        app.setZipCode("32065");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"Agent_GA_InteliJ");
        app.setMI("A");
        app.setLastName("adAutomation");
        app.setSuffix("PHD");
        app.setAddressLine1("11211 frStreet dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1255561234");
        app.setGender("M");
        app.setMedicareClaimNum("123443123A");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
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
        app.setMedicaidCovered(NO);
        app.setExistingMedicare(NO);
        app.setExistMedSupp(NO);
        app.setOtherInsCoverage(NO);
        app.setPlanEffIn6OfEligible(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setOtherMedplanstart("01/01/2012");
        app.setOtherMedplanend("01/01/2015");
        app.setIntentReplace(YES);
        app.setFirstTime(YES);
        app.setDropMedSuppForThisPlan(YES);
        app.setMSInsCompany("Blue Cross Blue Shield NV");
        app.setMSPLAN("Medical Supplement NV");
        app.setReplaceExistingMedSup(YES);
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
        //Mailing Address
        app.setMailingAddressCheck(NO);
        //SSForm Page
        app.setSS_FormDate("01/01/2001");
        app.setAgencyName("Agency Name");
        app.setAgencyAddress("Agency Address");
        app.setAgencyPhone("2346759876");
        app.setMailingAddressCheck(NO);
        
        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("S03Q43AGMMFL03_02B");
        planSelectionPage.fillAndSubmit(app);
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPagePage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        supplementalFormPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isPending();

        expectedSubmissionResult.setPendingInfo("ENROLLMENT MEMBERSHIP VERIFICATION", "VERIFY MEMBER NUMBER");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);


    }

}
