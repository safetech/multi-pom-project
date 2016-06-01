package functionaltests.greenbay.integrationTests;

import com.github.javafaker.Faker;
import functionaltests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.SubmissionQueryPhone;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.pages.greenbaypages.*;
import resources.pages.greenbaypages.AgentVerificationPage;
import resources.pages.greenbaypages.ApplicationSubmissionPage;
import resources.pages.greenbaypages.AuthorizationAndVerificationPage;
import resources.pages.greenbaypages.CustomerInformationPage;
import resources.pages.greenbaypages.EligibilityHealthQuestionsPage;
import resources.pages.greenbaypages.PlanSelectionAndStartDatePage;
import resources.pages.greenbaypages.VoiceSignatureInstructionsPage;
import resources.pages.greenbaypages.PastAndCurrentCoveragePage;
import resources.utils.DateUtils;

public class NewYorkIntegrationTest extends CQBaseIntegrationTest {
    
    @Page LandingPage landingPage;
    @Page VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page CheckEligibilityPage checkEligibilityPage;
    @Page CustomerInformationPage customerInformationPage;
    @Page PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page PastAndCurrentCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page AgentVerificationPage agentVerificationPage;
    @Page ReviewAndSubmitPage reviewAndSubmitPage;
    @Page ApplicationSubmissionPage applicationSubmissionPage;


    public SubmissionQueryPhone submissionQueryPhone;
    private Faker faker;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQueryPhone = new SubmissionQueryPhone();
        faker = new Faker();
        expectedSubmissionResult = new SubmissionResult();
        app = new Application();
        logger.info(gson.toJson(app));
        
        app.setEmployerId(faker.numerify("######"));
        app.setZipCode("12345");
        app.setState("NY");

        //PlanSelectionAndStartDate
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(6));
        
        //CommonDataForCustomerInformationPage
        app.setAARPMembershipNumber(faker.numerify("##########"));
        app.setPrefix("MR");
        app.setFirstName(this.faker.firstName());
        app.setMI(this.faker.letterify("?"));
        app.setLastName(this.faker.lastName());
        app.setSuffix("PHD");
        app.setAddressLine1(faker.streetAddress(false));
        app.setAddressLine2(faker.secondaryAddress());
        app.setCity("Horsham");
        app.setEmail(faker.letterify("??????????"+"@uhc.com"));
        app.setConfirmEmail(faker.letterify("??????????"+"@uhc.com"));
        app.setPhonePrimary(faker.numerify("### ### ####"));
        app.setPhoneEvening(faker.numerify("### ### ####"));
        app.setGender("M");
        app.setMedicareClaimNum(faker.bothify("A#########"));
        app.setPartABActiveIndicator(YES);
        //Plan Selection and Start Date
        app.setPlanCode("F");
        //Past And Current Coverage page
        app.setUnderstandAndAuthorize(YES);
        
        
        
    }

    @Test
    public void GREENBAY_NeyYork_NonQrGiNoRn(){
        app.setExpectedRefEffectiveDates(6);
        app.setGroupApp(YES);
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        
        goTo(landingPage);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        
    }
    
}
