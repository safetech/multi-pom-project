package functionaltests.greenbay.functionalityTests;

import com.github.javafaker.Faker;
import functionaltests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.SubmissionQueryPhone;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.pages.greenbaypages.*;
import resources.utils.DateUtils;

public class NewYorkFunctionalityTest extends CQBaseIntegrationTest {
    
    @Page LandingPage landingPage;
    @Page VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page CheckEligibilityPage checkEligibilityPage;
    @Page CustomerInformationPage customerInformationPage;
    @Page PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page PastAndCurrentCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page AgentVerificationPage agentVerificationPage;
    @Page RN038Page replacementNotice;
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
        
        //CommonDataForCustomerInformationPage
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
        app.setExpectedReqEffectiveDates(6);
        app.setAARPMembershipNumber(faker.numerify(""));
        app.setGroupApp(YES);
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        //PlanSelectionAndStartDate
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(NO);
        app.setExistingMedicare(NO);
        app.setExistMedSupp(NO);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);
        //Agent Verification Test
        app.setAgentOtherInsPoliciesSold("List Number One");
        app.setAgentPoliciesInForce("List two in force");
        app.setAgentPoliciesSoldNotInForce("List three not in force");
        app.setAgentFirstName("GreenBayFirstName");
        app.setAgentMI("K");
        app.setAgentLastName("GreenLastName");
        app.setAgentPhone(faker.numerify("### ### ####"));
        
        goTo(landingPage);
        voiceSignatureInstructionsPage.verifyEmployerIDShowsExpectedErrorMessages(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
    }
    
  
}
