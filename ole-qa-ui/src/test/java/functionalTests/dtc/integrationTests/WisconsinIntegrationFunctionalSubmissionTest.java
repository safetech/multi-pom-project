package functionalTests.dtc.integrationTests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.dtc.CribSheet;
import functionalTests.CQBaseIntegrationTest;
import resources.pages.dtcPages.oldOlePages.*;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.pages.dtcPages.oldOlePages.variations.authorization.WI_AuthorizationPage;
import resources.pages.dtcPages.oldOlePages.variations.pastandcurrentcoverage.AR_CA_PA_WI_MN_PastAndCurrentCoveragePage;
import resources.pages.dtcPages.oldOlePages.variations.planapplication.AR_PA_WI_PlanApplicationQuestionsPage;
import resources.pages.dtcPages.oldOlePages.variations.planselectionandstartdate.PA_AR_NV_MA_PlanSelectionAndStartDatePage;
import queries.SubmissionQueryDtc;
import resources.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WisconsinIntegrationFunctionalSubmissionTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public AboutYouPage aboutYouPage;
    @Page public PA_AR_NV_MA_PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public AR_PA_WI_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public AR_CA_PA_WI_MN_PastAndCurrentCoveragePage pastAndCurrentCoveragePage;
    @Page public WI_AuthorizationPage authorizationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;

    public SubmissionQueryDtc submissionQuery;
    private Faker faker;
    protected CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        faker = new Faker();
        sheet = new CribSheet(faker);
        submissionQuery = new SubmissionQueryDtc();
        expectedSubmissionResult = new SubmissionResult();
        app = new Application();
        logger.info(gson.toJson(app));
    }
    public static SimpleDateFormat NORMALIZED_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    @Test
    public void WI_WID2_GARider1And3NoRN() throws Exception {

        sheet.setState("WI");
        sheet.setZip("54001");
        sheet.setRiderChoice1("OW");
        sheet.setRiderChoice2("QW");
        sheet.setRiderChoice3("");
        sheet.setRiderChoice4("");
        sheet.setRiderChoice5("");
        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("MW");
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
        app.setTobaccoUse(YES);
        app.setLostCoverage(NO);
        app.setTurned65In6GA(YES);
        app.setPartBIn6GA(YES);
        app.setPlanEffIn6OfEligible(YES);
        //Eligibility Page
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);
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
        app.setReplaceExistingMedSup(YES);
        app.setReplacementReason("OtherReason");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");
        app.setRNOther("Cheaper");
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setApplicantRNSignatureIndRequired("required");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        expectedSubmissionResult.verifyAcceptedPlanAndRiderCodes("MW1", "OW1", "QW1", "", "");
        submissionQuery.verifyPlanAndRiderCodes(app, sheet, expectedSubmissionResult);
    }
@Test
    public void WI_WID3_BaiscPlanFullUWWithRNRider2And4() throws Exception {
        logger.info(gson.toJson(app));
        sheet.setState("WI");
        sheet.setZip("54001");
        sheet.setRiderChoice1("PW");
        sheet.setRiderChoice2("SW");
        sheet.setRiderChoice3("");
        sheet.setRiderChoice4("");
        sheet.setRiderChoice5("");
        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate("01/01/2012");
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("MW");
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
        app.setTurned65In6GA(NO);
        app.setPartBIn6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);
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
        app.setMSInsCompany("Blue Cross Blue Shield");
        app.setMSPLAN("Medical Supplement");
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Humana");
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
        app.setApplicantRNSignatureIndRequired("required");
        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        healthHistoryQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyPendingPlanAndRiderCodes("MW1", "PW1", "SW1", "", "", "", "");
        submissionQuery.verifyPlanAndRiderCodes(app, sheet, expectedSubmissionResult);
    }
    @Test
    public void WI_WID5_BaiscPlanWithCoPayFullUWWithRNRider1And4() throws Exception {
        sheet.setState("WI");
        sheet.setZip("54001");
        sheet.setRiderChoice1("OW");
        sheet.setRiderChoice2("SW");
        sheet.setRiderChoice3("");
        sheet.setRiderChoice4("");
        sheet.setRiderChoice5("");
        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate("01/01/2012");
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("MW");
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
        app.setApplicantRNSignatureIndRequired("required");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        healthHistoryQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyPendingPlanAndRiderCodes("MW1", "OW1", "SW1", "", "", "", "");
        submissionQuery.verifyPlanAndRiderCodes(app, sheet, expectedSubmissionResult);
    }
    @Test
    public void WI_WID6_BaiscPlanWithCoPayGANORNRider2And4() throws Exception {

        sheet.setState("WI");
        sheet.setZip("54001");
        sheet.setRiderChoice1("PW");
        sheet.setRiderChoice2("SW");
        sheet.setRiderChoice3("");
        sheet.setRiderChoice4("");
        sheet.setRiderChoice5("");
        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate("01/01/2012");
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("MW");
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
        app.setApplicantRNSignatureIndRequired("required");
        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        healthHistoryQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.verifyPendingPlanAndRiderCodes("MW1", "PW1", "SW1", "", "","","");
        submissionQuery.verifyPlanAndRiderCodes(app, sheet, expectedSubmissionResult);
    }

    public static String getDOBInNormalDateFormat(int age) {
        Date dob = org.apache.commons.lang3.time.DateUtils.addYears(new Date(), -age);
        return NORMALIZED_DATE_FORMAT.format(dob);
    }
}
