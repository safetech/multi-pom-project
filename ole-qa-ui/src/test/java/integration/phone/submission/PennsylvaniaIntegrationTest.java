package integration.phone.submission;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import integration.CQBaseIntegrationTest;
import integration.phone.entity.Application;
import integration.phone.entity.CribSheet;
import integration.phone.entity.SubmissionResult;
import integration.phone.pages.*;
import integration.phone.pages.variations.pastandcurrentcoverage.PAPastAndCurrentInsuranceCoveragePage;
import integration.phone.pages.variations.pastandcurrentcoverage.PAPlanApplicationQuestions;
import integration.phone.pages.variations.replacementnotice.RN078Page;
import integration.phone.queries.SubmissionQuery;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;

public class PennsylvaniaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;
    @Page public PAPlanApplicationQuestions planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public PAPastAndCurrentInsuranceCoveragePage pastAndCurrentInsuranceCoveragePage;
    @Page public AuthorizationAndVerificationPage authorizationAndVerificationPage;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN078Page replacementNoticePage;
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

    @Test
    public void test_pennsylvania_full_underwriting_with_rn() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("PA", "19002");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(75));
        sheet.setMedPartBdate("1999-01-01");
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");

        Application app = new Application(sheet);

        app.setMedicareClaimNum(faker.bothify("??#########"));
        app.setMPAED("01/01/1999");
        app.setMPBED("01/01/1999");
        app.setPartABActiveIndicator("yes");
        app.setPlanCode("F");
        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(1));
        app.setLostCoverage("no");
        app.setTobaccoUse("no");
        app.setCPAPartBIn6("no");
        //Eligibility Questions
        app.setESRD("no");
        app.setSurgeryNeeded("no");
        //Health History
        app.setEmphysema("yes");
        app.setOthercancer("yes");
        app.setPolycystic("yes");
        app.setCirrhosis("yes");
        app.setBonemarrow("yes");
        app.setPancreatitis("yes");
        app.setAmputation("yes");
        app.setAlcohol("yes");
        app.setParaplegia("yes");
        app.setBipolar("yes");
        app.setMacular("yes");
        app.setAlzheimers("yes");
        app.setHIV("yes");
        //Past And Current Coverage
        app.setMedicaidCovered("yes");
        app.setMedicaidSupPremium("yes");
        app.setMedicaidbenefit("yes");
        app.setExistingMedicare("yes");
        app.setOtherMedplanstart("01/01/2000");
        app.setOtherMedplanend("01/01/2015");
        app.setIntentReplace("yes");
        app.setFirstTime("yes");
        app.setDropMedSuppForThisPlan("yes");
        app.setExistMedSupp("yes");
        app.setReplaceExistingMedSup("yes");
        app.setOtherInsCoverage("yes");
        app.setOtherInsCompany("Blue Cross Blue Shield");
        app.setOtherInsType("HMO");
        app.setOtherInsStart("01/01/2001");
        app.setOtherInsEnd("01/01/2014");
        app.setOtherInsReplace("yes");
        app.setCpaSignatureInd("yes");
        //Agent Verification Page
        app.setAgentOtherInsPoliciesSold("HIP");
        app.setAgentPoliciesInForce("EP");
        app.setAgentPoliciesSoldNotInForce("EPHIP");
        app.setAgentSignatureInd("yes");
        //Replacement Notice Page
        app.setReplacementReason("OtherReason");
        app.setRNOther("Cheaper");
        app.setAgentPrintedNameAdd("ProducerName");
        app.setAgentAddress("ProducerAdd");
        app.setApplicantPrintedNameAdd("AppName");
        app.setApplicantAddress("AppAdd");

        expectedSubmissionResult.setAdjudicationStatus("P");
        expectedSubmissionResult.setStatus("C");
        expectedSubmissionResult.setWorkQueue("UNDERWRITING");
        expectedSubmissionResult.setWorkQueueReason("REVIEW FOR POSSIBLE ESRD");

        logger.info(gson.toJson(app));

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

        eligibilityHealthQuestionsPage.isAt();
        eligibilityHealthQuestionsPage.fillAndSubmit(app);

        healthHistoryQuestionsPage.isAt();
        healthHistoryQuestionsPage.fillAndSubmit(app);

        pastAndCurrentInsuranceCoveragePage.isAt();
        pastAndCurrentInsuranceCoveragePage.fillAndSubmit(app);

        authorizationAndVerificationPage.isAt();
        authorizationAndVerificationPage.fillAndSubmit(app);

        agentVerificationPage.isAt();
        agentVerificationPage.fillAndSubmit(app);

        replacementNoticePage.isAt();
        replacementNoticePage.fillAndSubmit(app);

        reviewAndSubmitPage.isAt();
        reviewAndSubmitPage.fillAndSubmit(app);

        applicationSubmissionPage.isAt();
        applicationSubmissionPage.isPending();

        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
