package functionalAndIntegrationTests.phone.functionalityTests;

import com.github.javafaker.Faker;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.SubmissionQueryPhone;
import resources.entity.Application;
import resources.entity.phone.CribSheet;
import resources.pages.phonepages.uwExpansionPages.*;
import resources.pages.phonepages.uwExpansionPages.variations.agentverification.CA_AgentVerificationPage;
import resources.pages.phonepages.uwExpansionPages.variations.authorization.CA_AuthorizationAndVerificationPage;
import resources.pages.phonepages.uwExpansionPages.variations.eligibilityhealthquestions.CA_ME_OR_WA_EligibilityHealthQuestionsPage;
import resources.pages.phonepages.uwExpansionPages.variations.healthhistoryquestions.CA_HealthHistoryQuestionsPage;
import resources.pages.phonepages.uwExpansionPages.variations.pastandcurrentcoverage.CA_PA_NJ_IN_PastAndCurrentInsuranceCoveragePage;
import resources.pages.phonepages.uwExpansionPages.variations.planapplication.CA_PlanApplicationQuestions;
import resources.pages.phonepages.uwExpansionPages.variations.replacementnotice.RN040Page;
import resources.utils.DateUtils;
import resources.utils.helperClass;


public class CaliforniaFunctionalTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public CA_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public CA_ME_OR_WA_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public CA_HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public CA_PA_NJ_IN_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public CA_AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public CA_AgentVerificationPage agentVerificationPage;
    @Page public RN040Page replacementNoticePage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQueryPhone submissionQueryPhone;
    private Faker faker;
    private CribSheet sheet;
    

    @Before
    public void setup() {
        submissionQueryPhone = new SubmissionQueryPhone();
        faker = new Faker();

        sheet = new CribSheet(faker);
        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("CA", "90210");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setPlanCode("F01");
        sheet.setGRSId(faker.numerify("######"));

        app = new Application();
        // Customer Info Page Question
        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(13));
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Agent Verification Page
        app.setCommonAgentVerificationAnswers();

    }

    @Test
    public void PHONE_California_64YearsOld() throws Exception {
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        sheet.setDpsdToFirstDayOfFutureMonth(13);
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(64));
        helperClass ht = new helperClass();
        ht.testData(app, sheet);
        
        logger.info(gson.toJson(app));

        startApp(cheatPage, app, sheet);

        voiceSignatureInstructionsPage.checkMarketabilityCode("M14M43AGMMCA02_01D");
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        


    }
  
}
