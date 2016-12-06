package functionalAndIntegrationTests.agent.uwSubmissiontests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.pages.agentpages.uwExpansionPages.*;
import resources.pages.agentpages.uwExpansionPages.variations.authorization.MN_WA_AuthorizationPage;
import resources.pages.agentpages.uwExpansionPages.variations.checkeligibility.ME_CA_FL_CheckEligibilityAndAvailabilityPage;
import resources.pages.agentpages.uwExpansionPages.variations.currentinsurancecoverage.OR_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.uwExpansionPages.variations.eligibilityhealthquestions.MN_ME_CA_FL_EligibilityHealthQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.planapplication.OR_PlanApplicationQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.replacenotice.RN034_RN038_RN073WithSignaturePage;
import queries.AgentSubmissionQuery;
import resources.utils.DateUtils;

public class OreganIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public ME_CA_FL_CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public OR_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public MN_ME_CA_FL_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public OR_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public MN_WA_AuthorizationPage authorizationPage;
    @Page public RN034_RN038_RN073WithSignaturePage replacementNotice;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PreferencesPage preferencesPage;
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
        //Signature
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
        expectedSubmissionResult = new SubmissionResult();
    }
    @Test
    public void AGENT_Oregan_GI() throws Exception {

        sheet.setAgentID("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| PA| WA| OR]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setState("OR");
        app.setZipCode("97001");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"_Agent_GA_"+faker.letterify("??????????"));
        app.setLastName(faker.letterify("??????????"));
        app.setSuffix("PHD");
        app.setAddressLine1(faker.bothify("### ??????????? ??"));
        app.setAddressLine1("11211 frStreet dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("romansilver@g212dnk5.com");
        app.setConfirmEmail(app.getEmail());
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening("1255561234");
        app.setGender("M");
        app.setMedicareClaimNum(faker.bothify("?#########"));
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
        //Plan ApplicationPage
        app.setPlanEffIn6OfEligible(YES);
        app.setTobaccoUse(YES);
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
        preferencesPage.fillAndSubmit( app );
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifyUwExpansionSubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }

    @Test
    public void AGENT_Oregan_Eligibility_HH_FU_With_RN() throws Exception {

        sheet.setAgentID("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| PA| WA| OR]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setState("OR");
        app.setZipCode("97001");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(69));
        app.setMPBED("01/01/2010");
        app.setMPAED("01/01/2010");
        //TestData
        
        app.setFirstName(app.getState()+"_Agent_FU_"+faker.letterify("??????????"));
        app.setLastName(faker.letterify("??????????"));
        app.setSuffix("PHD");
        app.setAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setAddressLine2("apt #123");
        app.setCity(faker.letterify("??????????"));
        app.setEmail("test@uhc.com");
        app.setConfirmEmail(app.getEmail());
        app.setPhonePrimary(faker.numerify("##########"));
    //    app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum(faker.bothify("#########?"));
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
        //Plan application question
        app.setTurned65In6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setGI30dayBday(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
        //Eligibility Health Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
        //Caurrent Insurance Coverage page
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(YES);
        app.setOtherMedplanstart("01/01/2012");
        app.setOtherMedplanend("01/01/2015");
        app.setContinuousMedicareCoverageNoGap(YES);
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
        app.setMailingState(faker.letterify("OR"));
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
        preferencesPage.fillAndSubmit( app );
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
