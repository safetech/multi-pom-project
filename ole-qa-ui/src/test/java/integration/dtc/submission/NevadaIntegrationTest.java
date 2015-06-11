package integration.dtc.submission;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import integration.entity.Application;
import integration.entity.CribSheet;
import integration.entity.SubmissionResult;
import integration.phone.pages.*;
import integration.phone.pages.variations.authorizationandverification.NVAuthorizationAndVerificationPage;
import integration.phone.pages.variations.pastandcurrentcoverage.NVPastAndCurrentInsuranceCoveragePage;
import integration.phone.pages.variations.planapplicationpage.DE_NV_IN_AL_SC_PlanApplicationQuestions;
import integration.phone.pages.variations.replacementnotice.RN034andRE073Page;
import integration.phone.queries.SubmissionQuery;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;

public class NevadaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public DE_NV_IN_AL_SC_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public NVPastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public NVAuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page replacementNoticePage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQuery submissionQuery;
    private Faker faker;
    protected CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQuery();
        faker = new Faker();

        sheet = new CribSheet(faker);
        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("NV", "89101");
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
    public void test_nevada_health_history_underwriting_with_designeeSig_with_rn() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2012-04-01");

        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        eligibilityHealthQuestionsPage.fillAndSubmit(app);
        healthHistoryQuestionsPage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNoticePage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isPending();

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
