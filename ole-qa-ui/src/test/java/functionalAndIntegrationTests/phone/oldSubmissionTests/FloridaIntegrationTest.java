package functionalAndIntegrationTests.phone.oldSubmissionTests;

import com.github.javafaker.Faker;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import resources.entity.Application;
import resources.entity.phone.CribSheet;
import resources.entity.SubmissionResult;
import resources.pages.phonepages.oldOlePages.*;
import resources.pages.phonepages.oldOlePages.variations.pastandcurrentcoverage.FL_PastAndCurrentInsuranceCoveragePage;
import resources.pages.phonepages.oldOlePages.variations.replacementnotice.RN034andRE073Page;
import queries.PhoneSubmissionQuery;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.utils.DateUtils;

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

    public PhoneSubmissionQuery phoneSubmissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        phoneSubmissionQuery = new PhoneSubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        expectedSubmissionResult = new SubmissionResult();
        sheet.setGRSId(faker.numerify("######"));
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
        sheet.setPlanCode("FS");
        sheet.setEmail("thy@jcpclothing.ga");

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

        voiceSignatureInstructionsPage.checkMarketabilityCode("S03Q43AGMMFL03_02B");
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

        phoneSubmissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        phoneSubmissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

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

        voiceSignatureInstructionsPage.checkMarketabilityCode("S03Q43AGMMFL03_02B");
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

        phoneSubmissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        phoneSubmissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
