package integration.phoneRider;

import com.github.javafaker.Faker;
import entity.Application;
import entity.phone.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.phone.*;
import pages.phone.variations.pastandcurrentcoverage.GA_MI_PastAndCurrentInsuranceCoveragePage;
import pages.phone.variations.planapplicationpage.OH_MI_TX_PlanApplicationQuestions;
import pages.phone.variations.planselection.riders_WI_PlanSelectionPage;
import pages.phone.variations.replacementnotice.RN034andRE073Page;
import util.DateUtils;

public class WisconsinFunctionalTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public riders_WI_PlanSelectionPage planSelectionAndStartDatePage;
    @Page public OH_MI_TX_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public GA_MI_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN034andRE073Page ReplacementNotice034Page;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    private Faker faker;
    private CribSheet sheet;

    @Before
    public void setup() {
        faker = new Faker();
        sheet = new CribSheet(faker);
        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("WI", "54001");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("MW");

        app = new Application();

        // Customer Info Page Question
        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("MW");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Agent Verification Page
        app.setCommonAgentVerificationAnswers();

    }

    @Test
    public void test_wisconsin_basic_plan() throws Exception {
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2011-10-01");

        //Customer Information
        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/2011");
        app.setMPBED("10/01/2011");
        app.setPartABActiveIndicator(YES);
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.goodComboBasicPlan();
        planSelectionAndStartDatePage.badComboBasicPlan();


    }

    @Test
    public void test_wisconsin_basic_plan_with_CoPays() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(66));
        sheet.setMedPartBdate("2014-10-01");
        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/2011");
        app.setMPBED("10/01/2014");
        app.setPartABActiveIndicator(YES);


        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));

        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.isAt();
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.goodComboWithCoPay();
        planSelectionAndStartDatePage.badComboWithCoPay();


    }

}


