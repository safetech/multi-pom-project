package integration.agent.submission;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.dtc.CribSheet;
import integration.CQBaseIntegrationTest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.dtc.*;
import pages.dtc.variations.pastandcurrentcoverage.FL_PastAndCurrentCoveragePage;
import pages.dtc.variations.planapplication.NV_MA_PlanApplicationQuestionsPage;
import pages.dtc.variations.planselectionandstartdate.NV_MA_PlanSelectionAndStartDatePage;
import queries.SubmissionQuery;
import util.DateUtils;

public class FloridaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public AboutYouPage aboutYouPage;
    @Page public NV_MA_PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public NV_MA_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public FL_PastAndCurrentCoveragePage pastAndCurrentCoveragePage;
    @Page public AuthorizationPage authorizationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        expectedSubmissionResult = new SubmissionResult();
        sheet.setState("FL");
        sheet.setZip("32065");
    }

    @Ignore
    public void test_db() throws Exception {
        Application app = new Application();
        app.setHCSGApplicationId("3-BXRJHQO");
        SubmissionResult expectedSubmissionResult = new SubmissionResult();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
    }

    @Test
    public void test_florida_eligibility() throws Exception {

        sheet.setAarpMemid("y");
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
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        //Eligibility Page
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Past and Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(NO);
        app.setOtherMedplanstart("");
        app.setOtherMedplanend("");
        app.setExistMedSupp(YES);
        app.setMSInsCompany("US Care");
        app.setMSPLAN("HMO, P");
        app.setReplaceExistingMedSup(YES);
        app.setReplacementReason("OtherReason");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");
        app.setRNOther("Cheaper");
        app.setIntentReplace(YES);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);

        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setAdjudicationStatus("A");

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

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

    @Test
    public void test_florida_guaranteed_issue() throws Exception {

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
        app.setTobaccoUse(YES);
        app.setTurned65In6GA("yes");
        app.setPartBIn6GA("yes");
        app.setPlanEffIn6OfEligible("yes");
        app.setLostCoverage("");

        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/1999");
        app.setMPBED("01/01/1999");
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("A");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        app.setTobaccoUse(NO);
        app.setCPATurned65(YES);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(NO);
        app.setOtherMedplanstart("");
        app.setOtherMedplanend("");
        app.setExistMedSupp(YES);
        app.setMSInsCompany("US Care");
        app.setMSPLAN("HMO, P");
        app.setReplaceExistingMedSup(YES);
        app.setReplacementReason("OtherReason");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");
        app.setRNOther("Cheaper");
        app.setIntentReplace(YES);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);

        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setAdjudicationStatus("A");


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

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}