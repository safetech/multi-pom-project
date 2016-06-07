package functionaltests.greenbay;

import com.github.javafaker.Faker;
import functionaltests.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import queries.SubmissionQueryPhone;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.phone.CribSheet;
import resources.utils.DateUtils;


public class IntegrationTestData extends CQBaseIntegrationTest {

    public SubmissionQueryPhone submissionQueryPhone;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

//    @BeforeClass
//    public void setup() {
//        submissionQueryPhone = new SubmissionQueryPhone();
//        faker = new Faker();
//        sheet = new CribSheet(faker);
//        sheet.setRandomNameGenderAndMembershipNumber();
//        sheet.setRandomAddress("CA", "90210");
//        sheet.setRandomContactInfo();
//        sheet.setRandomCallCenterInfo();
//        sheet.setPlanCode("F01");
//        app = new Application();
//        // Customer Info Page Question
//        app.setMedicareClaimNum(faker.bothify("#########A"));
//        app.setPartABActiveIndicator(YES);
//        app.setPlanCode("F");
//        app.setReqEffectiveDate(DateUtils.getFirstDayOfFutureMonth(3));
//        //Eligibility Questions
//        app.setESRD(NO);
//        app.setSurgeryNeeded(NO);
//        //Agent Verification Page
//        app.setCommonAgentVerificationAnswers();
//        expectedSubmissionResult = new SubmissionResult();
//    }

    @BeforeClass
    public void PHONE_TestData() throws Exception {


        app.setDOB(DateUtils.getDOBofPersonTurningAgeToday(95));
        //Customer Information
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(-7));

        //Plan Application
        app.setDefaultPlanEligibilityQuestions(sheet);
        app.setLostCoverage(NO);
        app.setTobaccoUse(NO);
        app.setGI30dayBday(NO);
        app.setGIEmployerCov(NO);
        app.setGIMediCal(NO);
        app.setGIMilitary(NO);
        app.setGILocation(NO);
        //Eligibility Questions
        app.setKidneyProblem(NO);
        app.setEligibilitySurgery(NO);
        app.setEligibilityAdmitToHospPast90Days(NO);
        app.setNursingFacility(NO);
        app.setCAGuaranteedAcceptance(NO);
        app.setEligibilityHeartAttackTIAStroke(NO);
        app.setEligibilityChronicMedicalConditions(NO);
        //Eligibility Questions(SPECIFIC TO CA)
        app.setEligdialysis(NO);
        app.setEligRecdialysis(NO);
        app.setEligHospital(NO);
        app.setEligSurgery(NO);
        app.setEligOrgan(NO);
        app.setEligSpine(NO);
        app.setEligjoint(NO);
        app.setEligCancer(NO);
        app.setEligHeart(NO);
        app.setEligVascular(NO);
        //Past And Current Coverage
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
        app.setMSInsCompany("Meds supp");
        app.setMSPLAN("Ms Plan");
        app.setReplaceExistingMedSup(YES);
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
        app.setMedicalReleaseAuthSignatureIndRequired("Required");
        logger.info(gson.toJson(app));

    }
}
