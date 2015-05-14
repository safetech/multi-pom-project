package integration.phone.submission;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import integration.phone.entity.Application;
import integration.phone.entity.CribSheet;
import integration.phone.entity.SubmissionResult;
import integration.phone.pages.*;
import integration.phone.pages.variations.replacementnotice.RN034Page;
import integration.phone.queries.SubmissionQuery;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import util.DateUtils;

public class FloridaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034Page rn034Page;
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
    }

    @Ignore
    @Test
    public void test_db() throws Exception {

        Application app = new Application();
        app.setHCSGApplicationId("3-BXRJHQO");
        SubmissionResult expectedSubmissionResult = new SubmissionResult();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
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

        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/1999");
        app.setMPBED("01/01/1999");
        app.setPartABActiveIndicator("yes");
        app.setPlanCode("A");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        app.setTobaccoUse("no");
        app.setCPATurned65("yes");
        app.setCPAPartBIn6("no");
        app.setMedicaidCovered("no");
        app.setOtherMedplanstart("");
        app.setOtherMedplanend("");
        app.setExistMedSupp("no");
        app.setOtherInsCoverage("no");
        app.setCpaSignatureInd("yes");
        app.setAgentOtherInsPoliciesSold("HIP");
        app.setAgentPoliciesInForce("EP");
        app.setAgentPoliciesSoldNotInForce("EPHIP");
        app.setAgentSignatureInd("yes");

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

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);


    }

    @Ignore
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
        app.setPartABActiveIndicator("yes");
        app.setPlanCode("A");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        app.setTobaccoUse("no");
        app.setCPATurned65("yes");
        app.setCPAPartBIn6("no");
        app.setMedicaidCovered("no");
        app.setOtherMedplanstart("");
        app.setOtherMedplanend("");
        app.setExistMedSupp("no");
        app.setOtherInsCoverage("no");
        app.setCpaSignatureInd("yes");
        app.setAgentOtherInsPoliciesSold("HIP");
        app.setAgentPoliciesInForce("EP");
        app.setAgentPoliciesSoldNotInForce("EPHIP");
        app.setAgentSignatureInd("yes");

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

        rn034Page.isAt();
        rn034Page.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isApproved();

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }


}
