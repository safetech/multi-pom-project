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
    public void GREENBAY_NewYork_NonQrGiNoRn(){
        app.setExpectedReqEffectiveDates(6);
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
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.checkMarketabilityCode("M82044AGMMNY02_02B");
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
    }
    
    @Test
    public void GREENBAY_NewYork_NonQrFuWithRnGroup(){
        app.setExpectedReqEffectiveDates(3);
        app.setGroupApp(YES);
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(75));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        //PlanSelectionAndStartDate
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(3));
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
        //Agent Verification Test
        app.setAgentOtherInsPoliciesSold("List Number One");
        app.setAgentPoliciesInForce("List two in force");
        app.setAgentPoliciesSoldNotInForce("List three not in force");
        app.setAgentFirstName("GreenBayFirstName");
        app.setAgentMI("K");
        app.setAgentLastName("GreenLastName");
        app.setAgentPhone(faker.numerify("### ### ####"));
        //Replacement Notice
        app.setReplacementReason("OtherReason");
        app.setRNOther("Other");
        app.setApplicantPrintedNameAdd(faker.firstName()+" "+faker.lastName());
        app.setApplicantAddress(faker.streetAddress(false));

        goTo(landingPage);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.checkMarketabilityCode("M82044AGMMNY02_02B");
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
    }
    @Test
    public void GREENBAY_NewYork_NonQrGiIndividual(){
        app.setExpectedReqEffectiveDates(6);
        app.setGroupApp(NO);
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
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.checkMarketabilityCode("M82044AGMMNY02_02B");
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
    }
    @Test
    public void GREENBAY_NewYork_NonQrFuWithRnIndividual(){
        app.setExpectedReqEffectiveDates(3);
        app.setGroupApp(NO);
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(75));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-9));
        //PlanSelectionAndStartDate
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(3));
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
        //Agent Verification Test
        app.setAgentOtherInsPoliciesSold("List Number One");
        app.setAgentPoliciesInForce("List two in force");
        app.setAgentPoliciesSoldNotInForce("List three not in force");
        app.setAgentFirstName("GreenBayFirstName");
        app.setAgentMI("K");
        app.setAgentLastName("GreenLastName");
        app.setAgentPhone(faker.numerify("### ### ####"));
        //Replacement Notice
        app.setReplacementReason("OtherReason");
        app.setRNOther("Other");
        app.setApplicantPrintedNameAdd(faker.firstName()+" "+faker.lastName());
        app.setApplicantAddress(faker.streetAddress(false));

        goTo(landingPage);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
    }
}
