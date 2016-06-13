package resources.utils;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.BeforeClass;
import resources.entity.Application;
import resources.entity.phone.CribSheet;

import static resources.utils.AnswerUtils.NO;
import static resources.utils.AnswerUtils.YES;

public class helperClass {
    private Faker faker;
    public void testData(Application app, CribSheet sheet){
        

        //Customer Information
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(1));
        //Plan Application
//        app.setDefaultPlanEligibilityQuestions(sheet);
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
    }
    public void testDatatForFullUnderWriting(Application app, CribSheet sheet){
        
        
    }    

}
