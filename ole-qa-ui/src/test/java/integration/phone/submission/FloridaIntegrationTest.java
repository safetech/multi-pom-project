package integration.phone.submission;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import entity.Application;
import entity.phone.CribSheet;
import entity.SubmissionResult;
import pages.phone.*;
import pages.phone.variations.pastandcurrentcoverage.FL_PastAndCurrentInsuranceCoveragePage;
import pages.phone.variations.replacementnotice.RN034andRE073Page;
import queries.SubmissionQueryPhone;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;

public class FloridaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public FL_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
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
        expectedSubmissionResult = new SubmissionResult();

    }

    @Test
    public void test_florida_guaranteed_issue_without_rn() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("FL", "33480");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setMedPartBdate("1999-01-01");
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("A01");

        Application app = new Application(sheet);

        app.setMedicareClaimNum(faker.bothify("#########A"));
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
        app.setOtherMedplanend(BLANK);
        app.setExistMedSupp(NO);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);

        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setAdjudicationStatus("A");

        goTo(cheatPage);
        cheatPage.isAt();
        cheatPage.fillAndSubmit(sheet);

        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);

        customerInformationPage.isAt();
        customerInformationPage.fillAndSubmit(app);

        planSelectionAndStartDatePage.isAt();
        planSelectionAndStartDatePage.fillAndSubmit(app);

        planApplicationQuestionsPage.isAt();
        planApplicationQuestionsPage.fillAndSubmit(app);

        pastAndCurrentInsuranceCoveragePage.isAt();
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationAndVerificationPage.isAt();
        authorizationAndVerificationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQueryPhone.verifySubmissionData(app, expectedSubmissionResult);
        submissionQueryPhone.verifyAdjudicationData(app, expectedSubmissionResult);

    }

    @Test
    public void test_florida_guaranteed_issue_with_rn() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("FL", "33480");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setMedPartBdate("1999-01-01");
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("A01");

        Application app = new Application(sheet);

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
        app.setCommonReplacementNoticeAnswersWithoutApplicantInfo();

        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setAdjudicationStatus("A");

        goTo(cheatPage);
        cheatPage.isAt();
        cheatPage.fillAndSubmit(sheet);

        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);

        customerInformationPage.isAt();
        customerInformationPage.fillAndSubmit(app);

        planSelectionAndStartDatePage.isAt();
        planSelectionAndStartDatePage.fillAndSubmit(app);

        planApplicationQuestionsPage.isAt();
        planApplicationQuestionsPage.fillAndSubmit(app);

        pastAndCurrentInsuranceCoveragePage.isAt();
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationAndVerificationPage.isAt();
        authorizationAndVerificationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        replacementNoticePage.isAt();
        replacementNoticePage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQueryPhone.verifySubmissionData(app, expectedSubmissionResult);
        submissionQueryPhone.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
