package integration.dtc.submission;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.dtc.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.dtc.*;
import pages.dtc.variations.authorization.CA_AuthorizationPage;
import pages.dtc.variations.eligibilityhealthquestions.CA_EligibilityHealthQuestions;
import pages.dtc.variations.pastandcurrentcoverage.CA_PastAndCurrentCoveragePage;
import pages.dtc.variations.planapplication.CA_PlanApplicationQuestions;
import pages.dtc.variations.replacenotice.RN040Page;
import queries.SubmissionQuery;
import util.DateUtils;

public class CaliforniaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public AboutYouPage aboutYouPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public CA_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public CA_EligibilityHealthQuestions eligibilityHealthQuestionsPage;
    @Page public CA_PastAndCurrentCoveragePage pastAndCurrentCoveragePage;
    @Page public CA_AuthorizationPage authorizationPage;
    @Page public RN040Page replacementNoticePage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;

    public SubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        sheet.setState("CA");
        sheet.setZip("90210");

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_california_eligibility_underwriting_with_rn() throws Exception {


        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate("01/01/2012");
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
        //TestData
        app.setAARPMembershipNumber("1234567890");
        app.setPrefix("MR");
        app.setFirstName("Bob");
        app.setMI("N");
        app.setLastName("Automation");
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
        //Plan Application Page
        app.setGI30dayBday(NO);
        app.setGIEmployerCov(NO);
        app.setGIMediCal(NO);
        app.setGIMilitary(NO);
        app.setGILocation(NO);
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        //Eligibility Questions(SPECIFIC TO CA)
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
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
        //Authorizationa

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

        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setCommonHealthHistoryAnswers();

        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.isAt();
        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();

        electronicSignatureAndDocumentConsentPage.isAt();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();

        aboutYouPage.isAt();
        aboutYouPage.fillAndSubmit(app, sheet);

        planSelectionAndStartDatePage.isAt();
        planSelectionAndStartDatePage.fillAndSubmit(app);

        planApplicationQuestionsPage.isAt();
        planApplicationQuestionsPage.fillAndSubmit(app);

        eligibilityHealthQuestionsPage.isAt();
        eligibilityHealthQuestionsPage.fillAndSubmit(app);

        pastAndCurrentCoveragePage.isAt();
        pastAndCurrentCoveragePage.fillAndSubmit(app);

        authorizationPage.isAt();
        authorizationPage.fillAndSubmit(app);

        planPaymentOptionsPage.isAt();
        planPaymentOptionsPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void test_california_guranteed_issue() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate("04/01/2015");
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
        //TestData
        app.setAARPMembershipNumber("1234567890");
        app.setPrefix("MR");
        app.setFirstName("Bob");
        app.setMI("N");
        app.setLastName("Automation");
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
        //Plan Application Page
        app.setGI30dayBday(YES);
        //Eligibility Questions(SPECIFIC TO CA)
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
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

        //Authorizationa and verififcation page
        app.setDesignateLapse(NO);
        app.setAuxFirstName("AuxFirstName");
        app.setAuxMI("M");
        app.setAuxLastName("AuxLastName");
        app.setAuxAddressLine1("AuxAddressLine1");
        app.setAuxCity("AuxCity");
        app.setAuxState("NV");
        app.setAuxZipCode("89101");

        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();

        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");


        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.isAt();
        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();

        electronicSignatureAndDocumentConsentPage.isAt();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();

        aboutYouPage.isAt();
        aboutYouPage.fillAndSubmit(app, sheet);

        planSelectionAndStartDatePage.isAt();
        planSelectionAndStartDatePage.fillAndSubmit(app);

        planApplicationQuestionsPage.isAt();
        planApplicationQuestionsPage.fillAndSubmit(app);

        pastAndCurrentCoveragePage.isAt();
        pastAndCurrentCoveragePage.fillAndSubmit(app);

        authorizationPage.isAt();
        authorizationPage.fillAndSubmit(app);

        planPaymentOptionsPage.isAt();
        planPaymentOptionsPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
