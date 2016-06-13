package functionalAndIntegrationTests.agent.oldSubmissiontests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import resources.pages.agentpages.oldOlePages.*;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.pages.agentpages.oldOlePages.variations.currentinsurancecoverage.OH_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.oldOlePages.variations.planapplication.NV_PlanApplicationQuestionsPage;
import resources.pages.agentpages.oldOlePages.variations.replacenotice.RN034andRE073WithSignaturePage;
import resources.pages.agentpages.oldOlePages.variations.statespecificationform.OH_SupplementalFormPage;
import queries.SubmissionQueryAgent;
import resources.utils.DateUtils;

public class OhioIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public NV_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public OH_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AuthorizationPage authorizationPage;
    @Page public RN034andRE073WithSignaturePage replacementNotice;
    @Page public OH_SupplementalFormPage supplementalFormPage;
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
    public void AGENT_ohio_eligibility_underwriting_with_rn() throws Exception {

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

        app.setState("OH");
        app.setZipCode("44444");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(70));
        app.setMPBED("01/01/2012");
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
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
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
        app.setCommonHealthHistoryAnswers();
        //SSForm Page
        app.setSS_FormDate("01/01/2001");
        app.setAgencyName("Agency Name");
        app.setAgencyAddress("Agency Address");
        app.setAgencyPhone("2346759876");
        app.setSS_App_PrintedName("Applicant_PrintedName");
        app.setSS_Agent_PrintedName("Agent_PrintedName");
        app.setSS_LicenseNumber("234432234");
        app.setSS_StreetAddress("555 street add");
        app.setSS_City("City");
        app.setSS_State("OH");
        app.setSS_Zip("44444");
        app.setSS_Phone("1111112222");


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

        replacementNotice.isAt();
        replacementNotice.fillAndSubmit(app);

        supplementalFormPage.isAt();
        supplementalFormPage.fillAndSubmit(app);

         planPaymentOptionsPage.isAt();
        planPaymentOptionsPage.fillAndSubmit(app);

        paymentDetailsSummaryPage.isAt();
        paymentDetailsSummaryPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

       expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");
       submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
       submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }
    @Test
    public void AGENT_ohio_guranteed_issue() throws Exception {

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
        app.setState("OH");
        app.setZipCode("44444");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
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
        app.setSS_App_Signature1(Application.ALL_SIGNATURES[9]);
        app.setSS_Agent_Signature1(Application.ALL_SIGNATURES[10]);
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
        app.setAgentEmail("agentpages@uhc.com");
        app.setAgentEmailConfirm("agentpages@uhc.com");
        //app.setDefaultPlanEligibilityQuestions(sheet);
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);

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
        app.setTobaccoUse(YES);

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
          //SSForm Page
        app.setSS_FormDate("01/01/2001");
        app.setAgencyName("Agency Name");
        app.setAgencyAddress("Agency Address");
        app.setAgencyPhone("2346759876");
        app.setSS_App_PrintedName("Applicant_PrintedName");
        app.setSS_Agent_PrintedName("Agent_PrintedName");
        app.setSS_LicenseNumber("234432234");
        app.setSS_StreetAddress("555 street add");
        app.setSS_City("City");
        app.setSS_State("OH");
        app.setSS_Zip("44444");
        app.setSS_Phone("1111112222");

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

        supplementalFormPage.isAt();
        supplementalFormPage.fillAndSubmit(app);

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
