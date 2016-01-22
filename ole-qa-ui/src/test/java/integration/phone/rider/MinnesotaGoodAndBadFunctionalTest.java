package integration.phone.rider;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.phone.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.phone.*;
import pages.phone.variations.pastandcurrentcoverage.MN_GA_MI_PastAndCurrentInsuranceCoveragePage;
import pages.phone.variations.planapplication.OH_MI_TX_PlanApplicationQuestions;
import pages.phone.variations.planselection.MN_Riders_PlanSelectionPage;
import pages.phone.variations.replacementnotice.RN034andRE073Page;
import queries.SubmissionQueryPhone;
import util.DateUtils;

public class MinnesotaGoodAndBadFunctionalTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public MN_Riders_PlanSelectionPage planSelectionAndStartDatePage;
    @Page public OH_MI_TX_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public MN_GA_MI_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page ReplacementNotice034Page;
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
        sheet.setRandomAddress("MN", "55445");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("TW");


        app = new Application();

        // Customer Info Page Question
        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("TW");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);

        //Agent Verification Page
        app.setCommonAgentVerificationAnswers();

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_minnesota_basic_plan_with_good_combo() throws Exception {
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2011-10-01");

        Application app = new Application(sheet);
        //Customer Information
        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/2011");
        app.setMPBED("10/01/2011");
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("TW");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.goodComboBasicPlan(app);
        planSelectionAndStartDatePage.badComboBasicPlan(app);


    }

    @Test
    public void test_minnesota_basic_Extendedplan_with_good_combo() throws Exception {
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(66));
        sheet.setMedPartBdate("2014-10-01");

        Application app = new Application(sheet);

        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/2011");
        app.setMPBED("10/01/2014");
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("TW");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.goodComboExtendedBasicPlan();


    }

}


