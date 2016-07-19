package functionalAndIntegrationTests.dtc.uwSubmissionTests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.dtc.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import resources.pages.dtcpages.uwExpansionPages.*;
import resources.pages.dtcpages.uwExpansionPages.variations.authorization.ME_AuthorizationPage;
import resources.pages.dtcpages.uwExpansionPages.variations.pastandcurrentcoverage.ME_PastAndCurrentCoveragePage;
import resources.pages.dtcpages.uwExpansionPages.variations.planapplication.ME_PlanApplicationQuestions;
import resources.pages.dtcpages.uwExpansionPages.variations.planselectionandstartdate.PA_AR_NV_MA_PlanSelectionAndStartDatePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.DtcSubmissionQuery;
import resources.utils.DateUtils;


public class MaineIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public AboutYouPage aboutYouPage;
    @Page public PA_AR_NV_MA_PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public ME_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public ME_PastAndCurrentCoveragePage pastAndCurrentCoveragePage;
    @Page public ME_AuthorizationPage authorizationPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;

    public DtcSubmissionQuery submissionQuery;
    private Faker faker;
    protected CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new DtcSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        sheet.setState("ME");
        sheet.setZip("03901");

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void DTC_Maine_FU_With_HH_And_DesigneeSig() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"DTC_FU_InteliJ");
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
        //Eligibility Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
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
        app.setContinuousMedicareCoverageNoGap(YES);
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
        //Mailing Address
        app.setMailingAddressCheck(NO);
        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();
        app.setCommonHealthHistoryAnswers();

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        whatYouNeedPage.checkMarketabilityCode("M13T43AGMMME01_01E");
        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setPendingInfo("ENROLLMENT STATE MANDATE","STATE MANDATE");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void DTC_Maine_GI() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
        //TestData
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(app.getState()+"DTC_GA_InteliJ");
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
        app.setCPATurned65(YES);
        app.setCPAPartBIn6(YES);
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
        app.setContinuousMedicareCoverageNoGap(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("ME"));
        app.setMailingZipCode(faker.numerify("#####"));
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

        whatYouNeedPage.checkMarketabilityCode("M13T43AGMMME01_01E");
        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        pastAndCurrentCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        planPaymentOptionsPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setPendingInfo("ENROLLMENT STATE MANDATE","STATE MANDATE");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
