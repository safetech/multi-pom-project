package functionalAndIntegrationTests.dtc.integrationTests;

import com.github.javafaker.Faker;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.DtcSubmissionQuery;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.dtc.CribSheet;
import resources.pages.dtcpages.oldOlePages.*;
import resources.pages.dtcpages.oldOlePages.variations.aboutyourpage.MN_AboutYouPage;
import resources.pages.dtcpages.oldOlePages.variations.authorization.MN_AuthorizationPage;
import resources.pages.dtcpages.oldOlePages.variations.planapplication.MN_PlanApplicationQuestionsPage;
import resources.pages.dtcpages.oldOlePages.variations.planselectionandstartdate.PA_AR_NV_MA_PlanSelectionAndStartDatePage;
import resources.pages.dtcpages.uwExpansionPages.variations.eligibilityhealthquestions.CA_EligibilityHealthQuestions;
import resources.utils.DateUtils;

public class MinesotaIntegrationFunctionalSubmissionTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public MN_AboutYouPage aboutYouPage;
    @Page public PA_AR_NV_MA_PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public MN_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public CA_EligibilityHealthQuestions eligibilityHealthQuestionsPage;
    @Page public resources.pages.dtcpages.uwExpansionPages.variations.pastandcurrentcoverage.MN_PastAndCurrentCoveragePage pastAndCurrentCoveragePage;
    @Page public MN_AuthorizationPage authorizationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public resources.pages.dtcpages.uwExpansionPages.PreferencesPage preferencesPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;

    public DtcSubmissionQuery submissionQuery;
    private Faker faker;
    protected CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        faker = new Faker();
        sheet = new CribSheet(faker);
        app = new Application();
        submissionQuery = new DtcSubmissionQuery();
        expectedSubmissionResult = new SubmissionResult();
        logger.info(gson.toJson(app));
    }

    @Test
    public void MN_MND2_BasicWithRider1FullUWWithRN() throws Exception {

        sheet.setState("MN");
        sheet.setZip("55001");
        sheet.setPlanCode("TW");
        sheet.setRiderChoice1("XW");
        sheet.setRiderChoice2("");
        sheet.setRiderChoice3("");
        sheet.setRiderChoice4("");
        sheet.setRiderChoice5("");
        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        //sheet.setEffDate("03/01/2016");
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setReferrer("uLayer");

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
        app.setMedicareClaimNum(faker.bothify("A#########"));
       // app.setMedicareClaimNum("123123123A");
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        //Plan Application Page
        app.setPlanEffIn6OfEligible(NO);
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        //EligibilityHealthQuestionsPage
        app.setUWEligibilityPageWithAppValues(NO);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);
        //Past And Current Coverage
        app.setSixMonEligEnroll(YES);
        app.setSixMonEligEnroll(YES);
        app.setSixMonTurn65Enroll(YES);
        app.setSixMonTurn65Enroll(YES);
        app.setSixEmpCovTerm(YES);
        app.setSixEmpCovTerm(YES);
        app.setSixMonMoveOut(YES);
        app.setSixMonMoveOut(YES);
        app.setSixMonResident(YES);
        app.setSixMonResident(YES);
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
        app.setReplaceExistingMedSup(YES);
        app.setReplacementReason("OtherReason");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");
        app.setRNOther("Cheaper");
        app.setHIV("NotHidden");

        goTo(cheatPage);
 //       cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.fillAndSubmit(app);
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit();
        planPaymentOptionsPage.fillAndSubmit(app);
        preferencesPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyAcceptedPlanAndRiderCodes("TW1", "XW1", "", "", "");

        submissionQuery.verifyPlanAndRiderCodes(app, sheet, expectedSubmissionResult);
    }
    @Test
    public void MN_MND3_FullUWWithHH() throws Exception {

        sheet.setState("MN");
        sheet.setZip("55001");
        sheet.setPlanCode("TW");
        sheet.setRiderChoice1("YW");
        sheet.setRiderChoice2("VW");
        sheet.setRiderChoice3("WW");
        sheet.setRiderChoice4("ZW");
        sheet.setRiderChoice5("");
        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(71));
        sheet.setEffDate("01/01/2012");
        //sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setReferrer("uLayer");

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
        app.setMedicareClaimNum(faker.bothify("A#########"));
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);
        //Plan Application Page
        app.setPlanEffIn6OfEligible(NO);
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        //Eligibility Page
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);
        //Past And Current Coverage
        app.setSixMonEligEnroll(YES);
        app.setSixMonEligEnroll(YES);
        app.setSixMonTurn65Enroll(YES);
        app.setSixMonTurn65Enroll(YES);
        app.setSixEmpCovTerm(YES);
        app.setSixEmpCovTerm(YES);
        app.setSixMonMoveOut(YES);
        app.setSixMonMoveOut(YES);
        app.setSixMonResident(YES);
        app.setSixMonResident(YES);
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
        app.setReplaceExistingMedSup(YES);
        app.setReplacementReason("OtherReason");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");
        app.setRNOther("Cheaper");
        app.setHIV("NotHidden");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit();
        planPaymentOptionsPage.fillAndSubmit(app);
        preferencesPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyPendingPlanAndRiderCodes("TW1", "YW1", "VW1", "WW1", "ZW1", "", "");
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
