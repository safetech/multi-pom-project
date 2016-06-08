package functionaltests.greenbay.integrationTests;

import com.github.javafaker.Faker;
import functionaltests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import queries.SubmissionQueryGreenbay;
import queries.SubmissionQueryPhone;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.pages.greenbaypages.*;
import resources.pages.greenbaypages.variations.authorizationandverification.MN_AuthorizationAndVerificationPage;
import resources.pages.greenbaypages.variations.customerinformationpage.MN_CustomerInformationPage;
import resources.pages.greenbaypages.variations.eligibilityhealthquestions.MN_EligibilityHealthQuestionsPage;
import resources.pages.greenbaypages.variations.planapplication.MN_PlanApplicationQuestions;
import resources.pages.greenbaypages.variations.planselection.MN_PlanSelectionAndStartDatePage;
import resources.utils.DateUtils;
import functionaltests.greenbay.IntegrationTestData;

import java.sql.SQLException;

public class MinnesotaIntegrationTest extends CQBaseIntegrationTest {
    
    @Page LandingPage landingPage;
    @Page VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page CheckEligibilityPage checkEligibilityPage;
    @Page MN_CustomerInformationPage customerInformationPage;
    @Page MN_PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page MN_PlanApplicationQuestions planApplicationQuestions;
    @Page MN_EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page PastAndCurrentCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page MN_AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page AgentVerificationPage agentVerificationPage;
    @Page RN038Page replacementNotice;
    @Page ReviewAndSubmitPage reviewAndSubmitPage;
    @Page ApplicationSubmissionPage applicationSubmissionPage;


    public SubmissionQueryGreenbay submissionQuery;
    private Faker faker;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() throws Exception {
        submissionQuery = new SubmissionQueryGreenbay();
        faker = new Faker();
        expectedSubmissionResult = new SubmissionResult();
        app = new Application();

        
        app.setZipCode("55001");
        app.setState("MN");
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
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening(faker.numerify("##########"));
        app.setGender("M");
        app.setMedicareClaimNum(faker.bothify("A#########"));
        app.setPartABActiveIndicator(YES);
        //Past And Current Coverage page
        app.setUnderstandAndAuthorize(YES);
    }

    @Test
    public void GREENBAY_Minnesota_NonQrGiNoRnBlankAarp() throws SQLException {
        app.setExpectedReqEffectiveDates(3);
        app.setGroupApp(YES);
        app.setEmployerId(faker.numerify("##"));
        app.setAARPMembershipNumber(faker.numerify(BLANK));
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        //Plan Selection and Start Date
        app.setPlanCode("UW");
        //PlanApplicationQuestionsPage
        app.setTobaccoUse(YES);
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(NO);
        app.setExistingMedicare(NO);
        app.setExistMedSupp(NO);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);
        app.setPlanEffIn6OfEligible(YES);
        //Agent Verification Test
        app.setAgentOtherInsPoliciesSold("List Number One");
        app.setAgentPoliciesInForce("List two in force");
        app.setAgentPoliciesSoldNotInForce("List three not in force");
        app.setAgentFirstName("GreenBayFirstName");
        app.setAgentMI("K");
        app.setAgentLastName("GreenLastName");
        app.setAgentPhone(faker.numerify("### ### ####"));
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("ME"));
        app.setMailingZipCode(faker.numerify("#####"));
        logger.info(gson.toJson(app));
        goTo(landingPage);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.checkMarketabilityCode("M13Z43AGMMMN01_02D");
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestions.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isPending();

//        expectedSubmissionResult.setAcceptedInfo();
//        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
    }
    
    @Test
    public void GREENBAY_Minnesota_NonQrGiWithRnAarp() throws SQLException {
        app.setExpectedReqEffectiveDates(3);
        app.setGroupApp(YES);
        app.setEmployerId(faker.numerify("##"));
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        //PlanSelectionAndStartDate
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setRider1("XW");
        app.setRider2("YW");
        app.setPlanCode("TW");
        //Plan Application Questions 
        app.setPlanEffIn6OfEligible(YES);
        app.setTobaccoUse(YES);
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(NO);
        app.setMedicaidCovered(NO);
        app.setExistingMedicare(NO);
        app.setExistMedSupp(YES);
        app.setMSInsCompany(faker.country());
        app.setMSPLAN("Best Plan");
        app.setReplaceExistingMedSup(YES);
        app.setOtherInsCoverage(NO);
        app.setCpaSignatureInd(YES);
        app.setPlanEffIn6OfEligible(YES);
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
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("ME"));
        app.setMailingZipCode(faker.numerify("#####"));
        
        goTo(landingPage);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.checkMarketabilityCode("M13Z43AGMMMN01_02D");
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestions.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setPendingInfo("INFORMATION","REQUIRED");
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
    }
    @Test
    public void GREENBAY_Minnesota_NonQrFuWithRnAarp() throws SQLException {
        app.setExpectedReqEffectiveDates(3);
        app.setGroupApp(NO);
        app.setEmployerId(faker.numerify("#####"));
        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        //PlanSelectionAndStartDate
        app.setReqEffectiveDate(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setRider1("XW");
        app.setRider2("YW");
        app.setPlanCode("TW");
        //Plan Application Questions page
        app.setPlanEffIn6OfEligible(YES);
        app.setTobaccoUse(YES);
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
        //Mailing Address
        app.setMailingAddressCheck(YES);
        app.setMailingAddressLine1(faker.bothify("#### ??????????? ??"));
        app.setMailingAddressLine2(faker.bothify("#### ??????????? ??"));
        app.setMailingCity(faker.letterify("??????????????"));
        app.setMailingState(faker.letterify("ME"));
        app.setMailingZipCode(faker.numerify("#####"));

        goTo(landingPage);
        voiceSignatureInstructionsPage.fillAndSubmit(app);
        checkEligibilityPage.fillAndSubmit(app);
        customerInformationPage.checkMarketabilityCode("M13Z43AGMMMN01_02D");
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        planApplicationQuestions.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);

        expectedSubmissionResult.setAcceptedInfo();
        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
    }
}
