package functionalAndIntegrationTests.agent.uwSubmissiontests;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.AgentSubmissionQuery;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import resources.pages.agentpages.oldOlePages.*;
import resources.pages.agentpages.oldOlePages.variations.replacenotice.RN034andRE073WithSignaturePage;
import resources.pages.agentpages.uwExpansionPages.PreferencesPage;
import resources.pages.agentpages.uwExpansionPages.variations.authorization.MN_WA_AuthorizationPage;
import resources.pages.agentpages.uwExpansionPages.variations.checkeligibility.ME_CA_FL_CheckEligibilityAndAvailabilityPage;
import resources.pages.agentpages.uwExpansionPages.variations.currentinsurancecoverage.MN_WA_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.uwExpansionPages.variations.eligibilityhealthquestions.MN_ME_CA_FL_EligibilityHealthQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.planapplication.MN_PlanApplicationQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.planselection.riders_MN_PlanSelectionPage;
import resources.reports.ExtentManager;
import resources.utils.DateUtils;

//TODO: Update pdf's and make sure "Not submitted" message resolves
public class MinnesotaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public riders_MN_PlanSelectionPage planSelectionPage;
    @Page public ME_CA_FL_CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public MN_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public MN_ME_CA_FL_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public MN_WA_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public MN_WA_AuthorizationPage authorizationPage;
    @Page public RN034andRE073WithSignaturePage replacementNotice;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public resources.pages.agentpages.uwExpansionPages.AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PreferencesPage preferencesPage;
    @Page public resources.pages.agentpages.uwExpansionPages.PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;
    ExtentReports rep = ExtentManager.getInstance();
    public AgentSubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;
    private String marketabilityCode = null;
    @Before
    public void setup() {
        submissionQuery = new AgentSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        app = new Application();
        sheet.setAgentMedSuppStates("[PA| WA| MN]");
        sheet.setAgentCertificationYears("[2016| 2017| 2018]");
        sheet.setAgentID("AutoTester");
        app.setAgentFirstName(faker.firstName());
        app.setAgentLastName(faker.lastName());
        app.setAgentMI(faker.letterify(" ? "));
        sheet.setAgentName(app.getAgentFirstName()+app.getAgentMI()+app.getAgentLastName());
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@uhc.com");
        marketabilityCode = "M27H49AGMMMN01_01D";
        app.setState("MN");
        app.setZipCode("55445");
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
        expectedSubmissionResult = new SubmissionResult();
    }
    @Test
    public void AGENT_minnesota_guranteed_acceptance() throws Exception {

        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        //TestData
        app.setCommonCustomerInformationAnswers();
//        //Plan ApplicationPage
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
        app.setAgentPhone("3334445555");
        //Plan Payment Options
        app.setPlanPaymentOptions("OneTime");
        //Mailing Address
        app.setMailingAddressCheck(NO);
        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();
        app.setTest(rep.startTest("AGENT_Minnesota_guranteed_acceptance"));
        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode(marketabilityCode);
        planSelectionPage.fillAndSubmit(app);
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        preferencesPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        logger.info(reviewAndSubmitPage.getQuestionMapValues());
        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifyUwExpansionSubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void AGENT_minnesota_eligibility_healthhistory_underwriting_with_rn() throws Exception {
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setDOB(DateUtils.getDOBInNormalDateFormat(67));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        //TestData
        app.setCommonCustomerInformationAnswers();
        //Eligibility Page
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
        //Plan application question\
        app.setMedSuppReplace(NO);
        app.setTurned65In6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
        //Past And Current Coverage
        app.setYesToCurrentInsuranceCoverage();
        app.setCpaSignatureInd(YES);
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
        app.setAgentPhone("3334445555");
        //Plan Payment Options
        app.setPlanPaymentOptions("Recurring");
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
        app.setTest(rep.startTest("AGENT_Minnesota_eligibility_healthhistory_underwriting_with_rn"));
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
        preferencesPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        logger.info(reviewAndSubmitPage.getQuestionMapValues());
        expectedSubmissionResult.setPendingInfo("INFORMATION","REQUIRED");
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
