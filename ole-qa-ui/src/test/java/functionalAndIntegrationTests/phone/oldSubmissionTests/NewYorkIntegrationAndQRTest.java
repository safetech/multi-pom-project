package functionalAndIntegrationTests.phone.oldSubmissionTests;

import com.github.javafaker.Faker;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import queries.SubmissionQueryPhone;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.phone.CribSheet;
import resources.pages.phonepages.oldOlePages.*;
import resources.pages.phonepages.oldOlePages.variations.pastandcurrentcoverage.NY_PastAndCurrentInsuranceCoveragePage;
import resources.pages.phonepages.oldOlePages.variations.planapplication.VA_NJ_IL_LA_NC_KY_AR_PlanApplicationQuestions;
import resources.pages.phonepages.oldOlePages.variations.replacementnotice.RN078Page;
import resources.utils.DateUtils;

public class NewYorkIntegrationAndQRTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public VA_NJ_IL_LA_NC_KY_AR_PlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public NY_PastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN078Page replacementNoticePage;
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
        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void OCSS_NewYork_QR_Fu_with_Rn_And_HH() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setFirstName("QR-Ret"+this.faker.firstName());
        sheet.setRandomAddress("NY", "12345");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");
        sheet.setQrIndicator("Y");
        sheet.setGRSId(faker.numerify("######"));
        sheet.setMembershipNumber(faker.numerify("#########"));
        Application app = new Application(sheet);

        app.setMedicareClaimNum(faker.bothify("#########A"));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-1));
        app.setPartABActiveIndicator(YES);
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        //Plan Eligibility
        app.setTurned65In6GA(NO);
        app.setPartBIn6GA(NO);
        app.setPlanEffIn6OfEligible(NO);
        app.setLostCoverage(NO);
        app.setTobaccoUse(NO);
        //Eligibility Questions
        app.setESRD(NO);
        app.setSurgeryNeeded(NO);
        //Health History
        app.setEmphysema(YES);
        app.setOthercancer(YES);
        app.setPolycystic(YES);
        app.setCirrhosis(YES);
        app.setBonemarrow(YES);
        app.setPancreatitis(YES);
        app.setAmputation(YES);
        app.setAlcohol(YES);
        app.setParaplegia(YES);
        app.setBipolar(YES);
        app.setMacular(YES);
        app.setAlzheimers(YES);
        app.setHIV(YES);
        //Past And Current Coverage
        app.setCPATurned65(NO);
        app.setCPAPartBIn6(YES);
        app.setMedicaidCovered(YES);
            app.setMedicaidSupPremium(YES);
            app.setMedicaidbenefit(YES);
        app.setExistingMedicare(YES);
            app.setOtherMedplanstart("01/01/2000");
            app.setOtherMedplanend("01/01/2015");
            app.setIntentReplace(YES);
            app.setFirstTime(YES);
            app.setDropMedSuppForThisPlan(YES);
        app.setExistMedSupp(YES);
            app.setReplaceExistingMedSup(YES);
            app.setMSPLAN(faker.name());
            app.setMSInsCompany(faker.country());
        app.setOtherInsCoverage(YES);
            app.setOtherInsCompany("Blue Cross Blue Shield");
            app.setOtherInsType("HMO");
            app.setOtherInsStart("01/01/2001");
            app.setOtherInsEnd("01/01/2014");
            app.setOtherInsReplace(YES);
        app.setCpaSignatureInd(YES);
        //Agent Verification Page
        app.setAgentOtherInsPoliciesSold("HIP");
        app.setAgentPoliciesInForce("EP");
        app.setAgentPoliciesSoldNotInForce("EPHIP");
        app.setAgentSignatureInd(YES);
        //Replacement Notice Page
        app.setReplacementReason("OtherReason");
        app.setRNOther("Cheaper");
        app.setAgentPrintedNameAdd("ProducerName");
        app.setAgentAddress("ProducerAdd");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");

        expectedSubmissionResult.setPendingInfo("ENROLLMENT", "REVIEW");

        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        voiceSignatureInstructionsPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planSelectionAndStartDatePage.fillAndSubmit(app);
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationAndVerificationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNoticePage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isPending();

        goTo(cheatPage).alert().accept();
        cheatPage.fillAndSubmitQrTest(sheet);
        voiceSignatureInstructionsPage.verifyStateOfElementsAfterQrRetreive();
        customerInformationPage.clickNextAndWaitForSpinnerToFinish();
        planSelectionAndStartDatePage.clickNextAndWaitForSpinnerToFinish();
        pastAndCurrentInsuranceCoveragePage.clickNextAndWaitForSpinnerToFinish();
        authorizationAndVerificationPage.clickNextAndWaitForSpinnerToFinish();
        agentVerificationPage.clickNextAndWaitForSpinnerToFinish();
        replacementNoticePage.clickNextAndWaitForSpinnerToFinish();
        reviewAndSubmitPage.clickNextAndWaitForSpinnerToFinish();

        submissionQueryPhone.verifySubmissionData(app, expectedSubmissionResult);
        submissionQueryPhone.verifyAdjudicationData(app, expectedSubmissionResult);

    }
  }
