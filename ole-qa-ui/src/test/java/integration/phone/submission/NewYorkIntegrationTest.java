package integration.phone.submission;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import entity.Application;
import entity.phone.CribSheet;
import entity.SubmissionResult;
import pages.phone.*;
import pages.phone.variations.pastandcurrentcoverage.NY_PastAndCurrentInsuranceCoveragePage;
import pages.phone.variations.replacementnotice.RN034andRE073Page;
import queries.SubmissionQueryPhone;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;

public class NewYorkIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public NY_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQueryPhone submissionQueryPhone;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQueryPhone = new SubmissionQueryPhone();
        faker = new Faker();
        sheet = new CribSheet(faker);
        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("NY", "10001");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");

        app = new Application();

        // Customer Info Page Question
        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);

        //Agent Verification Page
        app.setCommonAgentVerificationAnswers();

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_newyork_guaranteed_issue_with_rn() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2012-04-01");

        // Customer Info Page
        app.setMPAED("01/01/2012");
        app.setMPBED("04/01/2012");

        //Plan Eligibility
        app.setDefaultPlanEligibilityQuestions(sheet);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);

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
        app.setMSInsCompany("AARP Insurance");
        app.setMSPLAN("HMO");
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


        expectedSubmissionResult.setAcceptedInfo();

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNoticePage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQueryPhone.verifySubmissionData(app, expectedSubmissionResult);
        submissionQueryPhone.verifyAdjudicationData(app, expectedSubmissionResult);

    }
    @Test
    public void test_newyork_guaranteed_issue_without_rn() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(68));
        sheet.setMedPartBdate("2014-01-01");

        // Customer Info Page
        app.setMPAED("01/01/2014");
        app.setMPBED("01/01/2014");

        //Plan Eligibility
        app.setDefaultPlanEligibilityQuestions(sheet);
        app.setLostCoverage(NO);
        app.setTobaccoUse(NO);

        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(YES);
        app.setMedicaidSupPremium(YES);
        app.setMedicaidbenefit(YES);
        app.setExistingMedicare(NO);
        app.setFirstTime(BLANK);
        app.setDropMedSuppForThisPlan(BLANK);
        app.setExistMedSupp(NO);
        app.setReplaceExistingMedSup(BLANK);
        app.setOtherInsCoverage(NO);
        app.setOtherInsCompany("");
        app.setOtherInsType("");
        app.setOtherInsStart("");
        app.setOtherInsEnd("");
        app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);

        //Authorizationa and verififcation page
        app.setDesignateLapse(YES);

        expectedSubmissionResult.setAcceptedInfo();

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQueryPhone.verifySubmissionData(app, expectedSubmissionResult);
        submissionQueryPhone.verifyAdjudicationData(app, expectedSubmissionResult);

    }

    @Test
    public void test_newyork_guaranteed_issue_with_rn2() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2012-04-01");

        // Customer Info Page
        app.setMPAED("01/01/2012");
        app.setMPBED("04/01/2012");

        //Plan Eligibility
        app.setDefaultPlanEligibilityQuestions(sheet);
        app.setLostCoverage(NO);
        app.setTobaccoUse(YES);

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
        app.setMSInsCompany("AARP Insurance");
        app.setMSPLAN("HMO");
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(YES);
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace(NO);
        app.setCpaSignatureInd(YES);

        //Replacement Notice Page
        app.setCommonReplacementNoticeAnswersWithApplicantInfo();

        expectedSubmissionResult.setAcceptedInfo();

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNoticePage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQueryPhone.verifySubmissionData(app, expectedSubmissionResult);
        submissionQueryPhone.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
