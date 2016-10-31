package functionalAndIntegrationTests.agent.uwSubmissiontests;

import com.github.javafaker.Faker;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.AgentSubmissionQuery;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import resources.pages.agentpages.uwExpansionPages.*;
import resources.pages.agentpages.uwExpansionPages.variations.authorization.CA_AuthorizationPage;
import resources.pages.agentpages.uwExpansionPages.variations.checkeligibility.ME_CA_FL_CheckEligibilityAndAvailabilityPage;
import resources.pages.agentpages.uwExpansionPages.variations.currentinsurancecoverage.CA_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.uwExpansionPages.variations.eligibilityhealthquestions.MN_ME_CA_FL_EligibilityHealthQuestionsPage;
import resources.pages.agentpages.uwExpansionPages.variations.planapplication.CA_PlanApplicationQuestions;
import resources.pages.agentpages.uwExpansionPages.variations.replacenotice.RN034andRE073WithSignaturePage;
import resources.utils.DateUtils;

public class CaliforniaPdfAssertionTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public ME_CA_FL_CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public CA_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public MN_ME_CA_FL_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public CA_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public CA_AuthorizationPage authorizationPage;
    @Page public RN034andRE073WithSignaturePage replacementNotice;
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
    @Before
    public void setup() {
        submissionQuery = new AgentSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        app = new Application();
        app.setState("CA");
        app.setZipCode("90201");
        app.setAgentFirstName(faker.firstName());
        app.setAgentMI(faker.letterify(" ? "));
        app.setAgentLastName(faker.lastName());
        marketabilityCode = "M14M43AGMMCA02_01D";
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
    public void AGENT_California_GI() throws Exception {
        sheet.setAgentCertificationYears("[2016| 2017| 2018]");
        sheet.setAgentID("AutoTester");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName(app.getAgentFirstName()+app.getAgentMI()+app.getAgentLastName());
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
//        sheet.setAgentEmail("dsds@uhc.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("CA");
        app.setZipCode("90210");
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
        app.setEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
//        app.setEmail("jjkhgar@uhc.com");
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
        //Mailing Address
        app.setMailingAddressCheck(NO);
        //Payment Details Summary Page
        app.setPaymentDetailsSummaryPageWithAppValues();
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setCommonHealthHistoryAnswers();

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
        paymentDetailsSummaryPage.fillAndSubmit(app);
        preferencesPage.fillAndSubmit( app );
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifyUwExpansionSubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);
    }
    
}
