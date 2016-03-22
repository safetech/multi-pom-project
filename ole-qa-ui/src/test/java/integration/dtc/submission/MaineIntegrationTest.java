package integration.dtc.submission;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.dtc.CribSheet;
import integration.CQBaseIntegrationTest;
import integration.dtc.dtcPages.oldOlePages.*;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import integration.dtc.dtcPages.oldOlePages.variations.authorization.NV_AuthorizationPage;
import integration.dtc.dtcPages.oldOlePages.variations.pastandcurrentcoverage.NV_PastAndCurrentCoveragePage;
import integration.dtc.dtcPages.oldOlePages.variations.planapplication.ME_PlanApplicationQuestions;
import integration.dtc.dtcPages.oldOlePages.variations.planselectionandstartdate.PA_AR_NV_MA_PlanSelectionAndStartDatePage;
import queries.SubmissionQueryDtc;
import util.DateUtils;


//TODO: to be finished
public class MaineIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public AboutYouPage aboutYouPage;
    @Page public PA_AR_NV_MA_PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public ME_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public NV_PastAndCurrentCoveragePage pastAndCurrentCoveragePage;
    @Page public NV_AuthorizationPage authorizationPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;

    public SubmissionQueryDtc submissionQuery;
    private Faker faker;
    protected CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQueryDtc();
        faker = new Faker();
        sheet = new CribSheet(faker);
        sheet.setState("ME");
        sheet.setZip("03901");

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_maine_underwriting_with_health_history_and_designeeSig() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
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
        //Plan Application Page
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        app.setTurned65In6GA(NO);
        app.setPartBIn6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setContinuousCoverage(NO);
        //Eligibility Page
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);

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
        app.setCommonHealthHistoryAnswers();


        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.checkMarketabilityCode("M08O43AGMMME01_02C");
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

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void test_maine_guranteed_issue() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(-2));
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(this.faker.firstName());
        app.setMI(this.faker.letterify("?"));
        app.setLastName(this.faker.lastName());
        app.setSuffix("PHD");
        app.setAddressLine1("123 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Las Vegas");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        //Plan Application Page
        app.setTobaccoUse(YES);
        app.setTurned65In6GA(YES);
        app.setPartBIn6GA(YES);
        app.setPlanEffIn6OfEligible(YES);
        //Eligibility Page
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);

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

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.checkMarketabilityCode("M08O43AGMMME01_02C");
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

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
