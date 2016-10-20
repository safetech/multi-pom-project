package functionalAndIntegrationTests.agent.integrationtests;

import com.github.javafaker.Faker;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.AgentSubmissionQuery;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import resources.pages.agentpages.oldOlePages.*;
import resources.pages.agentpages.oldOlePages.variations.authorization.WI_AuthorizationPage;
import resources.pages.agentpages.oldOlePages.variations.currentinsurancecoverage.AR_PA_OR_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.oldOlePages.variations.planapplication.WI_PlanApplicationQuestionsPage;
import resources.pages.agentpages.oldOlePages.variations.planselection.iTest_WI_PlanSelectionPage;
import resources.pages.agentpages.oldOlePages.variations.replacenotice.RN034_AR_Page;
import resources.utils.DateUtils;

public class WisconsinIntegrationFunctionalSubmissionTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public iTest_WI_PlanSelectionPage planSelectionPage;
    @Page public CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public WI_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public AR_PA_OR_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public WI_AuthorizationPage authorizationPage;
    @Page public RN034_AR_Page replacementNotice;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public resources.pages.agentpages.uwExpansionPages.AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public AgentSubmissionQuery submissionQueryAgent;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQueryAgent = new AgentSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        expectedSubmissionResult = new SubmissionResult();
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
    }

    @Test
    public void WI_WIA2_BasicPlanWithRider1And3FullUWwithRn() throws Exception {

        sheet.setAgentID("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| WI| MN]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        app.setState("WI");
        app.setZipCode("53001");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(67));
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(3));
        app.setMPBED("01/01/2015");
        //CustomerInformationPage
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(faker.letterify("?????????? ?????"));
        app.setMI(faker.letterify("?"));
        app.setLastName(faker.letterify("?????????"));
        app.setSuffix("SR");
        app.setAddressLine1(faker.bothify("#### ??????????" + " Rd"));
        app.setAddressLine2(faker.bothify("#### ????????" + " St"));
        app.setCity(faker.letterify("?????? " + "City"));
        app.setEmail(faker.bothify("??????##" + "@uhc.com"));
        app.setConfirmEmail(app.getEmail());
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening(faker.numerify("##########"));
        app.setGender("M");
        app.setMedicareClaimNum(faker.numerify("#########A"));
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail(faker.letterify("??????" + "@uhc.com"));
        app.setAgentEmailConfirm(app.getAgentEmail());
        //PlanApplicationQuestionsPage
        app.setTurned65In6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setPartBIn6GA(NO);
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        //EligibilityHealthQuestionsPage
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //CurrentInsuranceCoveragePage
        app.setCPATurned65(NO);
        app.setTurned65In6GA(NO);
        app.setPartBIn6GA(NO);
        app.setCPAPartBIn6(NO);
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
        app.setExistMedSupp(NO);
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
        //AgentVerificationPage
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentFirstName("AgnetFirst");
        app.setAgentMI("A");
        app.setAgentLastName("AgentLast");
        app.setAgentPhone("333 444 5555");
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setApplicantPrintedNameAdd("");
        //PaymentDetailsSummaryPage
        app.setBankName("Bank of America");
        app.setRoutingNumber("123123123");
        app.setRoutingNumberConfirm("123123123");
        app.setAccountNumber("23456");
        app.setAccountNumberConfirm(app.getAccountNumber());
        app.setMailingAddressCheck("");
        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.selectRider1And3FullUWwithRn();
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
       // replacementNotice.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyPendingAndWorkQPlanAndRiderCodes("MW1", "OW1", "QW1", "", "", "","");
        submissionQueryAgent.verifyPlanAndRiderCodes(app, expectedSubmissionResult);
    }
    @Test
    public void WI_WIA3_BasicPlanWithCoPayRider2And4GaNoRn() throws Exception {

        sheet.setAgentID("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| WI| MN]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("WI");
        app.setZipCode("54001");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(3));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        //CustomerInformationPage
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(faker.letterify("?????????? ?????"));
        app.setMI(faker.letterify("?"));
        app.setLastName(faker.letterify("?????????"));
        app.setSuffix("SR");
        app.setAddressLine1(faker.bothify("#### ??????????" + " Rd"));
        app.setAddressLine2(faker.bothify("#### ????????" + " St"));
        app.setCity(faker.letterify("?????? " + "City"));
        app.setEmail(faker.bothify("??????##" + "@uhc.com"));
        app.setConfirmEmail(app.getEmail());
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening(faker.numerify("##########"));
        app.setGender("M");
        app.setMedicareClaimNum(faker.numerify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setAgentEmail(faker.letterify("??????" + "@uhc.com"));
        app.setAgentEmailConfirm(app.getAgentEmail());
        //PlanApplicationQuestionsPage
        app.setPlanEffIn6OfEligible(YES);
        app.setPartBIn6GA(YES);
        //EligibilityHealthQuestionsPage
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //CurrentInsuranceCoveragePage
        app.setCPATurned65(YES);
        app.setTurned65In6GA(YES);
        app.setPartBIn6GA(YES);
        app.setCPAPartBIn6(NO);
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
        app.setExistMedSupp(NO);
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
        //AgentVerificationPage
        app.setAgentOtherInsPoliciesSold("HMO");
        app.setAgentPoliciesInForce("HMO In Force");
        app.setAgentPoliciesSoldNotInForce("HMO Not In Force");
        app.setAgentFirstName("AgnetFirst");
        app.setAgentMI("A");
        app.setAgentLastName("AgentLast");
        app.setAgentPhone("333 444 5555");
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setApplicantPrintedNameAdd("");
        //PaymentDetailsSummaryPage
        app.setBankName("Bank of America");
        app.setRoutingNumber("123123123");
        app.setRoutingNumberConfirm("123123123");
        app.setAccountNumber("23456");
        app.setAccountNumberConfirm(app.getAccountNumber());

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.selectRider1And3FullUWwithRn();
        whatYouNeedPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyAcceptedPlanAndRiderCodes("MW1","PW1","SW1","","");
        submissionQueryAgent.verifyPlanAndRiderCodes(app, expectedSubmissionResult);
    }
}
