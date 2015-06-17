package entity;

import entity.phone.CribSheet;
import pages.WizardPage;
import util.AnswerUtils;
import util.DateUtils;
import util.PlanEligibilityQuestionUtils;

import java.util.Date;

public class Application {

    public String getAARPMembershipNumber() {
        return AARPMembershipNumber;
    }

    public void setAARPMembershipNumber(String AARPMembershipNumber) {
        this.AARPMembershipNumber = AARPMembershipNumber;
    }

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String suffix) {
        Suffix = suffix;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMI() {
        return MI;
    }

    public void setMI(String MI) {
        this.MI = MI;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDesignateLapse() {
        return DesignateLapse;
    }

    public void setDesignateLapse(String designateLapse) {
        DesignateLapse = designateLapse;
    }

    public String getAuxFirstName() {
        return AuxFirstName;
    }

    public void setAuxFirstName(String auxFirstName) {
        AuxFirstName = auxFirstName;
    }

    public String geAuxtMI() {
        return AuxMI;
    }

    public void setAuxMI(String auxMI) {
        this.AuxMI = auxMI;
    }

    public String getAuxLastName() {
        return AuxLastName;
    }

    public void setAuxLastName(String auxLastName) {
        AuxLastName = auxLastName;
    }

    public String getAuxAddressLine1() {
        return AuxAddressLine1;
    }

    public void setAuxAddressLine1(String auxAddressLine1) {
        AuxAddressLine1 = auxAddressLine1;
    }

    public String getAuxCity() {
        return AuxCity;
    }

    public void setAuxCity(String auxCity) {
        AuxCity = auxCity;
    }

    public String getAuxState() {
        return AuxState;
    }

    public void setAuxState(String auxState) {
        AuxState = auxState;
    }

    public String getAuxZipCode() {
        return AuxZipCode;
    }

    public void setAuxZipCode(String auxZipCode) {
        AuxZipCode = auxZipCode;
    }

    public String getAuxPhonePrimary() {
        return AuxPhonePrimary;
    }

    public void setAuxPhonePrimary(String auxPhonePrimary) {
        AuxPhonePrimary = auxPhonePrimary;
    }

    private String GI30dayBday = "";

    public String getGI30dayBday() {
        return GI30dayBday;
    }

    public void setGI30dayBday(String GI30dayBday) {
        this.GI30dayBday = GI30dayBday;
    }

    public String getGIEmployerCov() {
        return GIEmployerCov;
    }

    public void setGIEmployerCov(String GIEmployerCov) {
        this.GIEmployerCov = GIEmployerCov;
    }

    public String getGIMediCal() {
        return GIMediCal;
    }

    public void setGIMediCal(String GIMediCal) {
        this.GIMediCal = GIMediCal;
    }

    public String getGIMilitary() {
        return GIMilitary;
    }

    public void setGIMilitary(String GIMilitary) {
        this.GIMilitary = GIMilitary;
    }

    public String getGILocation() {
        return GILocation;
    }

    public void setGILocation(String GILocation) {
        this.GILocation = GILocation;
    }

    private String MedicareClaimNum = "";
    private String MPAED = "";
    private String MPBED = "";
    private String Email = "";
    private String GIEmployerCov = "";
    private String GIMediCal = "";
    private String GIMilitary = "";
    private String GILocation = "";
    private String PartABActiveIndicator = "";
    private String Turned65In6GA = "";
    private String PartBIn6GA = "";
    private String PlanEffIn6OfEligible = "";
    private String LostCoverage = "";
    private String ContinuousCoverage = "";
    private String TobaccoUse = "";
    private String CPATurned65 = "";
    private String CPAPartBIn6 = "";
    private String MedicaidCovered = "";
    private String MedicaidSupPremium = "";
    private String Medicaidbenefit = "";
    private String OtherMedplanstart = "";
    private String OtherMedplanend = "";
    private String ExistMedSupp = "";
    private String MSInsCompany = "";
    private String MSPLAN = "";
    private String ReplaceExistingMedSup = "";
    private String OtherInsCoverage = "";
    private String OtherInsCompany = "";
    private String OtherInsType = "";
    private String OtherInsStart = "";
    private String OtherInsEnd = "";
    private String OtherInsReplace = "";
    private String CpaSignatureInd = "";
    private String AgentOtherInsPoliciesSold = "";
    private String AgentPoliciesInForce = "";
    private String AgentPoliciesSoldNotInForce = "";
    private String AgentSignatureInd = "";
    private String ESRD = "";
    private String SurgeryNeeded = "";
    private String ExistingMedicare = "";
    private String FirstTime = "";
    private String DropMedSuppForThisPlan = "";
    private String AgentPrintedNameAdd = "";
    private String AgentAddress = "";
    private String AddressLine1 = "";
    private String AddressLine2 = "";
    private String City = "";
    private String State = "";
    private String ZipCode = "";
    private String DesignateLapse = "";
    private String AuxAddressLine1 = "";
    private String AuxCity = "";
    private String AuxState = "";
    private String AuxZipCode = "";
    private String AuxPhonePrimary = "";
    private String AARPMembershipNumber = "";
    private String AuxFirstName = "";
    private String AuxMI = "";
    private String AuxLastName = "";
    private String FirstName = "";
    private String MI = "";
    private String LastName = "";
    private String Prefix = "";
    private String Suffix = "";
    private String Eligdialysis = "";
    private String EligRecdialysis = "";
    private String EligHospital = "";
    private String EligSurgery = "";
    private String EligOrgan = "";
    private String EligSpine = "";
    private String Eligjoint = "";
    private String EligCancer = "";
    private String EligHeart = "";
    private String EligVascular = "";
    private String CPAMPBED = "";
    private String SellingAgentSignatureInd = "";
    private String MedSuppReplace = "";
    private String involTerm = "";
    private String OtherInsTerm = "";
    private String ConfirmEmail = "";
    private String AgentEmail = "";
    private String AgentEmailConfirm = "";

    public String getAgentEmail() {
        return AgentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        AgentEmail = agentEmail;
    }

    public String getAgentEmailConfirm() {
        return AgentEmailConfirm;
    }

    public void setAgentEmailConfirm(String agentEmailConfirm) {
        AgentEmailConfirm = agentEmailConfirm;
    }

    public String getConfirmEmail() {
        return ConfirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        ConfirmEmail = confirmEmail;
    }
    //private String DidNotAssistAnsweringQuestions = "";

    public String getOtherInsTerm() {
        return OtherInsTerm;
    }

    public void setOtherInsTerm(String otherInsTerm) {
        OtherInsTerm = otherInsTerm;
    }

    public String getInvolTerm() {
        return involTerm;
    }

    public void setInvolTerm(String involTerm) {
        this.involTerm = involTerm;
    }

    public String getMedSuppReplace() {
        return MedSuppReplace;
    }

    public void setMedSuppReplace(String medSuppReplace) {
        MedSuppReplace = medSuppReplace;
    }

    public String getSellingAgentSignatureInd() {
        return SellingAgentSignatureInd;
    }

    public void setSellingAgentSignatureInd(String sellingAgentSignatureInd) {
        SellingAgentSignatureInd = sellingAgentSignatureInd;
    }


    public String getCPAMPBED() {
        return CPAMPBED;
    }

    public void setCPAMPBED(String CPAMPBED) {
        this.CPAMPBED = CPAMPBED;
    }

    public String getEligdialysis() {
        return Eligdialysis;
    }

    public void setEligdialysis(String eligdialysis) {
        Eligdialysis = eligdialysis;
    }

    public String getEligRecdialysis() {
        return EligRecdialysis;
    }

    public void setEligRecdialysis(String eligRecdialysis) {
        EligRecdialysis = eligRecdialysis;
    }

    public String getEligHospital() {
        return EligHospital;
    }

    public void setEligHospital(String eligHospital) {
        EligHospital = eligHospital;
    }

    public String getEligSurgery() {
        return EligSurgery;
    }

    public void setEligSurgery(String eligSurgery) {
        EligSurgery = eligSurgery;
    }

    public String getEligOrgan() {
        return EligOrgan;
    }

    public void setEligOrgan(String eligOrgan) {
        EligOrgan = eligOrgan;
    }

    public String getEligSpine() {
        return EligSpine;
    }

    public void setEligSpine(String eligSpine) {
        EligSpine = eligSpine;
    }

    public String getEligjoint() {
        return Eligjoint;
    }

    public void setEligjoint(String eligjoint) {
        Eligjoint = eligjoint;
    }

    public String getEligCancer() {
        return EligCancer;
    }

    public void setEligCancer(String eligCancer) {
        EligCancer = eligCancer;
    }

    public String getEligHeart() {
        return EligHeart;
    }

    public void setEligHeart(String eligHeart) {
        EligHeart = eligHeart;
    }

    public String getEligVascular() {
        return EligVascular;
    }

    public void setEligVascular(String eligVascular) {
        EligVascular = eligVascular;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    private String DOB = "";
    private String Gender = "";

    public String getAgentPrintedNameAdd() {
        return AgentPrintedNameAdd;
    }

    public void setAgentPrintedNameAdd(String agentPrintedNameAdd) {
        AgentPrintedNameAdd = agentPrintedNameAdd;
    }

    public String getAgentAddress() {
        return AgentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        AgentAddress = agentAddress;
    }

    public String getApplicantPrintedNameAdd() {
        return ApplicantPrintedNameAdd;
    }

    public void setApplicantPrintedNameAdd(String applicantPrintedNameAdd) {
        ApplicantPrintedNameAdd = applicantPrintedNameAdd;
    }

    public String getApplicantAddress() {
        return ApplicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        ApplicantAddress = applicantAddress;
    }

    private String ApplicantPrintedNameAdd = "";
    private String ApplicantAddress = "";

    public String getRNOther() {
        return RNOther;
    }

    public void setRNOther(String RNOther) {
        this.RNOther = RNOther;
    }

    private String RNOther = "";

    public String getReplacementReason() {
        return ReplacementReason;
    }

    public void setReplacementReason(String replacementReason) {
        ReplacementReason = replacementReason;
    }

    private String ReplacementReason = "";

    public String getFirstTime() {
        return FirstTime;
    }

    public void setFirstTime(String firstTime) {
        FirstTime = firstTime;
    }

    public String getDropMedSuppForThisPlan() {
        return DropMedSuppForThisPlan;
    }

    public void setDropMedSuppForThisPlan(String dropMedSuppForThisPlan) {
        DropMedSuppForThisPlan = dropMedSuppForThisPlan;
    }

    public String getIntentReplace() {
        return IntentReplace;
    }

    public void setIntentReplace(String intentReplace) {
        IntentReplace = intentReplace;
    }

    private String IntentReplace = "";

    public String getExistingMedicare() {
        return ExistingMedicare;
    }

    public void setExistingMedicare(String existingMedicare) {
        ExistingMedicare = existingMedicare;
    }

    public String getAneurysm() {
        return aneurysm;
    }

    public void setAneurysm(String aneurysm) {
        this.aneurysm = aneurysm;
    }

    public String getSclerosis() {
        return sclerosis;
    }

    public void setSclerosis(String sclerosis) {
        this.sclerosis = sclerosis;
    }

    public String getArtery() {
        return artery;
    }

    public void setArtery(String artery) {
        this.artery = artery;
    }

    public String getAtrial() {
        return atrial;
    }

    public void setAtrial(String atrial) {
        this.atrial = atrial;
    }

    public String getCardiomyopathy() {
        return cardiomyopathy;
    }

    public void setCardiomyopathy(String cardiomyopathy) {
        this.cardiomyopathy = cardiomyopathy;
    }

    public String getCarotid() {
        return carotid;
    }

    public void setCarotid(String carotid) {
        this.carotid = carotid;
    }

    public String getCHF() {
        return CHF;
    }

    public void setCHF(String CHF) {
        this.CHF = CHF;
    }

    public String getCAD() {
        return CAD;
    }

    public void setCAD(String CAD) {
        this.CAD = CAD;
    }

    public String getHeart_attack() {
        return heart_attack;
    }

    public void setHeart_attack(String heart_attack) {
        this.heart_attack = heart_attack;
    }

    public String getPVD() {
        return PVD;
    }

    public void setPVD(String PVD) {
        this.PVD = PVD;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getVentricular() {
        return ventricular;
    }

    public void setVentricular(String ventricular) {
        this.ventricular = ventricular;
    }

    public String getCOPD() {
        return COPD;
    }

    public void setCOPD(String COPD) {
        this.COPD = COPD;
    }

    public String getEmphysema() {
        return emphysema;
    }

    public void setEmphysema(String emphysema) {
        this.emphysema = emphysema;
    }

    public String getOthercancer() {
        return othercancer;
    }

    public void setOthercancer(String othercancer) {
        this.othercancer = othercancer;
    }

    public String getLeukemia() {
        return leukemia;
    }

    public void setLeukemia(String leukemia) {
        this.leukemia = leukemia;
    }

    public String getMelanoma() {
        return melanoma;
    }

    public void setMelanoma(String melanoma) {
        this.melanoma = melanoma;
    }

    public String getRenalfailure() {
        return renalfailure;
    }

    public void setRenalfailure(String renalfailure) {
        this.renalfailure = renalfailure;
    }

    public String getPolycystic() {
        return polycystic;
    }

    public void setPolycystic(String polycystic) {
        this.polycystic = polycystic;
    }

    public String getRenal() {
        return renal;
    }

    public void setRenal(String renal) {
        this.renal = renal;
    }

    public String getCirrhosis() {
        return cirrhosis;
    }

    public void setCirrhosis(String cirrhosis) {
        this.cirrhosis = cirrhosis;
    }

    public String getBonemarrow() {
        return bonemarrow;
    }

    public void setBonemarrow(String bonemarrow) {
        this.bonemarrow = bonemarrow;
    }

    public String getPancreatitis() {
        return pancreatitis;
    }

    public void setPancreatitis(String pancreatitis) {
        this.pancreatitis = pancreatitis;
    }

    public String getEsophageal_varices() {
        return esophageal_varices;
    }

    public void setEsophageal_varices(String esophageal_varices) {
        this.esophageal_varices = esophageal_varices;
    }

    public String getAmputation() {
        return amputation;
    }

    public void setAmputation(String amputation) {
        this.amputation = amputation;
    }

    public String getRheumatoid() {
        return rheumatoid;
    }

    public void setRheumatoid(String rheumatoid) {
        this.rheumatoid = rheumatoid;
    }

    public String getSpinal_stenosis() {
        return spinal_stenosis;
    }

    public void setSpinal_stenosis(String spinal_stenosis) {
        this.spinal_stenosis = spinal_stenosis;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getParaplegia() {
        return paraplegia;
    }

    public void setParaplegia(String paraplegia) {
        this.paraplegia = paraplegia;
    }

    public String getBipolar() {
        return bipolar;
    }

    public void setBipolar(String bipolar) {
        this.bipolar = bipolar;
    }

    public String getSchizophrenia() {
        return schizophrenia;
    }

    public void setSchizophrenia(String schizophrenia) {
        this.schizophrenia = schizophrenia;
    }

    public String getMacular() {
        return macular;
    }

    public void setMacular(String macular) {
        this.macular = macular;
    }

    public String getALS() {
        return ALS;
    }

    public void setALS(String ALS) {
        this.ALS = ALS;
    }

    public String getAlzheimers() {
        return alzheimers;
    }

    public void setAlzheimers(String alzheimers) {
        this.alzheimers = alzheimers;
    }

    public String getMultiple_sclerosis() {
        return multiple_sclerosis;
    }

    public void setMultiple_sclerosis(String multiple_sclerosis) {
        this.multiple_sclerosis = multiple_sclerosis;
    }

    public String getParkinsons() {
        return parkinsons;
    }

    public void setParkinsons(String parkinsons) {
        this.parkinsons = parkinsons;
    }

    public String getNervous_condition() {
        return nervous_condition;
    }

    public void setNervous_condition(String nervous_condition) {
        this.nervous_condition = nervous_condition;
    }

    public String getAIDS() {
        return AIDS;
    }

    public void setAIDS(String AIDS) {
        this.AIDS = AIDS;
    }

    public String getHIV() {
        return HIV;
    }

    public void setHIV(String HIV) {
        this.HIV = HIV;
    }


    public String getDiabetes_child() {
        return diabetes_child;
    }

    public void setDiabetes_child(String diabetes_child) {
        this.diabetes_child = diabetes_child;
    }

    private String aneurysm = "";
    private String sclerosis = "";
    private String artery = "";
    private String atrial = "";
    private String cardiomyopathy = "";
    private String carotid = "";
    private String CHF = "";
    private String CAD = "";
    private String heart_attack = "";
    private String PVD = "";
    private String stroke = "";
    private String ventricular = "";
    private String diabetes_child = "";
    private String COPD = "";
    private String emphysema = "";
    private String othercancer = "";
    private String leukemia = "";
    private String melanoma = "";
    private String renalfailure = "";
    private String polycystic = "";
    private String renal = "";
    private String cirrhosis = "";
    private String bonemarrow = "";
    private String pancreatitis = "";
    private String esophageal_varices = "";
    private String amputation = "";
    private String rheumatoid = "";
    private String spinal_stenosis = "";
    private String alcohol = "";
    private String drug = "";
    private String paraplegia = "";
    private String bipolar = "";
    private String schizophrenia = "";
    private String macular = "";
    private String ALS = "";
    private String alzheimers = "";
    private String multiple_sclerosis = "";
    private String parkinsons = "";
    private String nervous_condition = "";
    private String AIDS = "";
    private String HIV = "";
    private String SixMonEligEnroll = "";
    private String SixMonTurn65Enroll = "";
    private String SixEmpCovTerm = "";
    private String SixMonMoveOut = "";
    private String SixMonResident = "";
    private String MOPlanCode = "";
    private String MOAnniversaryDate = "";


    public String getMOAnniversaryDate() {
        return MOAnniversaryDate;
    }

    public void setMOAnniversaryDate(String MOAnniversaryDate) {
        this.MOAnniversaryDate = MOAnniversaryDate;
    }

    public String getMOPlanCode() {
        return MOPlanCode;
    }

    public void setMOPlanCode(String MOPlanCode) {
        this.MOPlanCode = MOPlanCode;
    }

    public String getAuxMI() {
        return AuxMI;
    }

    public String getSixMonEligEnroll() {
        return SixMonEligEnroll;
    }

    public void setSixMonEligEnroll(String sixMonEligEnroll) {
        SixMonEligEnroll = sixMonEligEnroll;
    }

    public String getSixMonTurn65Enroll() {
        return SixMonTurn65Enroll;
    }

    public void setSixMonTurn65Enroll(String sixMonTurn65Enroll) {
        SixMonTurn65Enroll = sixMonTurn65Enroll;
    }

    public String getSixEmpCovTerm() {
        return SixEmpCovTerm;
    }

    public void setSixEmpCovTerm(String sixEmpCovTerm) {
        SixEmpCovTerm = sixEmpCovTerm;
    }

    public String getSixMonMoveOut() {
        return SixMonMoveOut;
    }

    public void setSixMonMoveOut(String sixMonMoveOut) {
        SixMonMoveOut = sixMonMoveOut;
    }

    public String getSixMonResident() {
        return SixMonResident;
    }

    public void setSixMonResident(String sixMonResident) {
        SixMonResident = sixMonResident;
    }

    public String getESRD() {
        return ESRD;
    }

    public void setESRD(String ESRD) {
        this.ESRD = ESRD;
    }

    public String getSurgeryNeeded() {
        return SurgeryNeeded;
    }

    public void setSurgeryNeeded(String surgeryNeeded) {
        SurgeryNeeded = surgeryNeeded;
    }

    public String getPhonePrimary() {
        return PhonePrimary;
    }

    public void setPhonePrimary(String phonePrimary) {
        PhonePrimary = phonePrimary;
    }

    public String getPhoneEvening() {
        return PhoneEvening;
    }

    public void setPhoneEvening(String phoneEvening) {
        PhoneEvening = phoneEvening;
    }

    private String PhonePrimary = "";
    private String PhoneEvening = "";


    public String getHCSGApplicationId() {
        return HCSGApplicationId;
    }

    public void setHCSGApplicationId(String HCSGApplicationId) {
        this.HCSGApplicationId = HCSGApplicationId;
    }

    private String HCSGApplicationId = "";

    public Application() {
    }

    public Application(CribSheet sheet) {
        setAnswersWithSheetValues(sheet);
    }

    public String getAgentOtherInsPoliciesSold() {
        return AgentOtherInsPoliciesSold;
    }

    public void setAgentOtherInsPoliciesSold(String agentOtherInsPoliciesSold) {
        AgentOtherInsPoliciesSold = agentOtherInsPoliciesSold;
    }

    public String getAgentPoliciesInForce() {
        return AgentPoliciesInForce;
    }

    public void setAgentPoliciesInForce(String agentPoliciesInForce) {
        AgentPoliciesInForce = agentPoliciesInForce;
    }

    public String getAgentPoliciesSoldNotInForce() {
        return AgentPoliciesSoldNotInForce;
    }

    public void setAgentPoliciesSoldNotInForce(String agentPoliciesSoldNotInForce) {
        AgentPoliciesSoldNotInForce = agentPoliciesSoldNotInForce;
    }

    public String getAgentSignatureInd() {
        return AgentSignatureInd;
    }

    public void setAgentSignatureInd(String agentSignatureInd) {
        AgentSignatureInd = agentSignatureInd;
    }

    public String getCPATurned65() {
        return CPATurned65;
    }

    public void setCPATurned65(String CPATurned65) {
        this.CPATurned65 = CPATurned65;
    }

    public String getCPAPartBIn6() {
        return CPAPartBIn6;
    }

    public void setCPAPartBIn6(String CPAPartBIn6) {
        this.CPAPartBIn6 = CPAPartBIn6;
    }

    public String getMedicaidCovered() {
        return MedicaidCovered;
    }

    public void setMedicaidCovered(String medicaidCovered) {
        MedicaidCovered = medicaidCovered;
    }

    public String getMedicaidSupPremium() {
        return MedicaidSupPremium;
    }

    public void setMedicaidSupPremium(String medicaidSupPremium) {
        MedicaidSupPremium = medicaidSupPremium;
    }

    public String getMedicaidbenefit() {
        return Medicaidbenefit;
    }

    public void setMedicaidbenefit(String medicaidbenefit) {
        Medicaidbenefit = medicaidbenefit;
    }

    public String getOtherMedplanstart() {
        return OtherMedplanstart;
    }

    public void setOtherMedplanstart(String otherMedplanstart) {
        OtherMedplanstart = otherMedplanstart;
    }

    public String getOtherMedplanend() {
        return OtherMedplanend;
    }

    public void setOtherMedplanend(String otherMedplanend) {
        OtherMedplanend = otherMedplanend;
    }

    public String getExistMedSupp() {
        return ExistMedSupp;
    }

    public void setExistMedSupp(String existMedSupp) {
        ExistMedSupp = existMedSupp;
    }

    public String getMSInsCompany() {
        return MSInsCompany;
    }

    public void setMSInsCompany(String MSInsCompany) {
        this.MSInsCompany = MSInsCompany;
    }

    public String getMSPLAN() {
        return MSPLAN;
    }

    public void setMSPLAN(String MSPLAN) {
        this.MSPLAN = MSPLAN;
    }

    public String getReplaceExistingMedSup() {
        return ReplaceExistingMedSup;
    }

    public void setReplaceExistingMedSup(String replaceExistingMedSup) {
        ReplaceExistingMedSup = replaceExistingMedSup;
    }

    public String getOtherInsCoverage() {
        return OtherInsCoverage;
    }

    public void setOtherInsCoverage(String otherInsCoverage) {
        OtherInsCoverage = otherInsCoverage;
    }

    public String getOtherInsCompany() {
        return OtherInsCompany;
    }

    public void setOtherInsCompany(String otherInsCompany) {
        OtherInsCompany = otherInsCompany;
    }

    public String getOtherInsType() {
        return OtherInsType;
    }

    public void setOtherInsType(String otherInsType) {
        OtherInsType = otherInsType;
    }

    public String getOtherInsStart() {
        return OtherInsStart;
    }

    public void setOtherInsStart(String otherInsStart) {
        OtherInsStart = otherInsStart;
    }

    public String getOtherInsEnd() {
        return OtherInsEnd;
    }

    public void setOtherInsEnd(String otherInsEnd) {
        OtherInsEnd = otherInsEnd;
    }

    public String getOtherInsReplace() {
        return OtherInsReplace;
    }

    public void setOtherInsReplace(String otherInsReplace) {
        OtherInsReplace = otherInsReplace;
    }

    public String getCpaSignatureInd() {
        return CpaSignatureInd;
    }

    public void setCpaSignatureInd(String cpaSignatureInd) {
        CpaSignatureInd = cpaSignatureInd;
    }

    public String getPartBIn6GA() {
        return PartBIn6GA;
    }

    public void setPartBIn6GA(String partBIn6GA) {
        PartBIn6GA = partBIn6GA;
    }

    public String getPlanEffIn6OfEligible() {
        return PlanEffIn6OfEligible;
    }

    public void setPlanEffIn6OfEligible(String planEffIn6OfEligible) {
        PlanEffIn6OfEligible = planEffIn6OfEligible;
    }

    public String getLostCoverage() {
        return LostCoverage;
    }

    public void setLostCoverage(String lostCoverage) {
        LostCoverage = lostCoverage;
    }

    public String getContinuousCoverage() {
        return ContinuousCoverage;
    }

    public void setContinuousCoverage(String continuousCoverage) {
        ContinuousCoverage = continuousCoverage;
    }

    public String getTobaccoUse() {
        return TobaccoUse;
    }

    public void setTobaccoUse(String tobaccoUse) {
        TobaccoUse = tobaccoUse;
    }

    public String getTurned65In6GA() {
        return Turned65In6GA;
    }

    public void setTurned65In6GA(String turned65In6GA) {
        Turned65In6GA = turned65In6GA;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getReqEffectiveDate() {
        return ReqEffectiveDate;
    }

    public void setReqEffectiveDate(String reqEffectiveDate) {
        ReqEffectiveDate = reqEffectiveDate;
    }

    private String planCode = "";
    private String ReqEffectiveDate = "";

    public String getMedicareClaimNum() {
        return MedicareClaimNum;
    }

    public void setMedicareClaimNum(String medicareClaimNum) {
        MedicareClaimNum = medicareClaimNum;
    }

    public String getMPAED() {
        return MPAED;
    }

    public void setMPAED(String MPAED) {
        this.MPAED = MPAED;
    }

    public String getMPBED() {
        return MPBED;
    }

    public void setMPBED(String MPBED) {
        this.MPBED = MPBED;
    }

    public String getPartABActiveIndicator() {
        return PartABActiveIndicator;
    }

    public void setPartABActiveIndicator(String partABActiveIndicator) {
        PartABActiveIndicator = partABActiveIndicator;
    }

    public void setCommonHealthHistoryAnswers() {
        setEmphysema(AnswerUtils.YES);
        setOthercancer(AnswerUtils.YES);
        setPolycystic(AnswerUtils.YES);
        setCirrhosis(AnswerUtils.YES);
        setBonemarrow(AnswerUtils.YES);
        setPancreatitis(AnswerUtils.YES);
        setAmputation(AnswerUtils.YES);
        setAlcohol(AnswerUtils.YES);
        setParaplegia(AnswerUtils.YES);
        setBipolar(AnswerUtils.YES);
        setMacular(AnswerUtils.YES);
        setAlzheimers(AnswerUtils.YES);
        setHIV(AnswerUtils.YES);
    }

    public void setCommonAgentVerificationAnswers() {
        setAgentOtherInsPoliciesSold("HIP");
        setAgentPoliciesInForce("EP");
        setAgentPoliciesSoldNotInForce("EPHIP");
        setAgentSignatureInd(AnswerUtils.YES);
    }

    public void setCommonReplacementNoticeAnswersWithApplicantInfo() {
        setCommonReplacementNoticeAnswersWithoutApplicantInfo();
        setApplicantPrintedNameAdd("AppName");
        setApplicantAddress("AppAdd");
    }

    public void setCommonReplacementNoticeAnswersWithoutApplicantInfo() {
        setReplacementReason("OtherReason");
        setRNOther("Cheaper");
        setAgentPrintedNameAdd("ProducerName");
        setAgentAddress("ProducerAdd");
    }

    public void setAnswersWithSheetValues(CribSheet sheet) {
        setAARPMembershipNumber(sheet.getMembershipNumber());
        setFirstName(sheet.getFirstName());
        setLastName(sheet.getLastName());
        setMI(sheet.getMiddleInitial().substring(0, 1));
        setHCSGApplicationId(sheet.getHcsgApplicationId());
        setAddressLine1(sheet.getAddressLine1());
        setAddressLine2(sheet.getAddressLine2());
        setCity(sheet.getCity());
        setState(sheet.getState());
        setZipCode(sheet.getZip());
        setDOB(DateUtils.convertDate(sheet.getDateOfBirth(), DateUtils.NORMALIZED_DATE_FORMAT));
        setPhonePrimary(sheet.getDayPhone());
        setPhoneEvening(sheet.getEveningPhone());
        setGender(sheet.getGender().equals("M") || sheet.getGender().equals("F") ? sheet.getGender() : "");
        setPrefix(sheet.getPrefix().toUpperCase());
        setSuffix(sheet.getSuffix().toUpperCase());
    }

    public void setWhatYouNeedBySheetValues(CribSheet sheet) {
        setAARPMembershipNumber(sheet.getMembershipNumber());
        setPrefix(sheet.getPrefix().toUpperCase());
        setFirstName(sheet.getFirstName());
        setMI(sheet.getMiddleInitial().substring(0, 1));
        setLastName(sheet.getLastName());
        setAddressLine1(sheet.getAddressLine1());
        setAddressLine2(sheet.getAddressLine2());
        setCity(sheet.getCity());
        setState(sheet.getState());
        setZipCode(sheet.getZip());
        //setConfirmEmail(sheet.getConfirmEmail());
        setPhonePrimary(sheet.getDayPhone());
        setPhoneEvening(sheet.getEveningPhone());
        setDOB(DateUtils.convertDate(sheet.getDateOfBirth(), DateUtils.NORMALIZED_DATE_FORMAT));
        setGender(sheet.getGender().substring(0, 1));

        setSuffix(sheet.getSuffix().toUpperCase());
    }

    public void setDefaultPlanEligibilityQuestions(CribSheet sheet) {

        Date dob = new Date(DateUtils.convertDate(sheet.getDateOfBirth(), DateUtils.NORMALIZED_DATE_FORMAT));
        Date dpsd = new Date(DateUtils.convertDate(sheet.getDpsd(), DateUtils.NORMALIZED_DATE_FORMAT));
        Date mpbed = new Date(DateUtils.convertDate(sheet.getMedPartBdate(), DateUtils.NORMALIZED_DATE_FORMAT));

        setTurned65In6GA(PlanEligibilityQuestionUtils.hasTurned65In6GABasedUponDpsd(dob, dpsd));
        setPartBIn6GA(PlanEligibilityQuestionUtils.hasPartBIn6GABasedUponDpsd(mpbed, dpsd));
        setPlanEffIn6OfEligible(PlanEligibilityQuestionUtils.hasPlanEffIn6OfEligibleBasedUponDpsd(dob, mpbed, dpsd));

    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String signature = "";

    public class AutoSignature extends WizardPage {

        public void main(String args[]) {

            Signature("AppSig1");
            Signature("AppSig2");
            Signature("AppSig3");
            Signature("AppSig4");
            Signature("AppSig5");

        }

        public void Signature(String Signature) {

            switch (Signature) {
                case "AppSig1":
                    String AppSig1 = "{\"lines\":[[[25,25.73],[25,26.73],[26,26.73],[28,26.73],[29,26.73],[31,26.73],[32,26.73],[33,26.73],[34,26.73],[34,26.73],[36,26.73],[36,26.73],[37,26.73],[38,26.73],[39,26.73],[40,26.73],[41,26.73],[42,26.73],[42,26.73],[43,26.73],[44,26.73],[46,26.73],[47,26.73],[47,26.73],[48,26.73],[49,26.73],[50,26.73],[51,26.73],[52,26.73],[52,26.73],[54,26.73],[54,26.73],[55,26.73],[56,26.73],[57,26.73],[58,26.73],[59,26.73],[60,26.73],[60,26.73],[62,26.73],[63,26.73],[64,26.73]],[[46,29.73],[46,30.73],[46,31.73],[46,32.73],[46,33.73],[47,33.73],[47,34.73],[47,35.73],[47,36.73],[47,37.73],[48,37.73],[48,38.73],[48,39.73],[48,39.73],[48,40.73],[49,40.73],[49,41.73],[49,42.73],[49,43.73],[49,44.73],[49,45.73],[49,46.73],[49,47.73],[49,48.73],[49,48.73],[49,49.73],[49,50.73],[49,51.73],[49,52.73],[49,53.73],[49,53.73],[49,55.73],[49,55.73],[49,56.73],[49,57.73],[49,58.73],[49,59.73]],[[67,53.73],[68,53.73],[69,53.73],[70,53.73],[71,53.73],[72,53.73],[73,53.73],[74,52.73],[75,52.73],[76,52.73],[77,51.73],[78,50.73],[79,50.73],[79,49.73],[79,48.73],[79,47.73],[79,46.73],[79,45.73],[78,44.73],[77,44.73],[76,44.73],[75,44.73],[74,44.73],[73,44.73],[73,44.73],[72,44.73],[71,44.73],[70,44.73],[69,44.73],[68,44.73],[67,45.73],[66,45.73],[66,46.73],[65,47.73],[65,48.73],[65,49.73],[65,49.73],[65,50.73],[65,52.73],[65,52.73],[65,53.73],[66,53.73],[66,54.73],[67,55.73],[67,56.73],[68,56.73],[68,57.73],[69,57.73],[70,57.73],[70,58.73],[71,58.73],[73,58.73],[74,58.73],[77,59.73],[79,59.73],[80,59.73],[81,59.73],[82,59.73],[83,59.73],[84,59.73],[85,59.73],[86,59.73],[87,59.73],[88,59.73],[89,59.73]],[[102,58.73],[103,58.73],[103,57.73],[104,57.73],[105,56.73],[106,56.73],[107,55.73],[108,54.73],[110,53.73],[111,52.73],[113,51.73],[113,50.73],[114,49.73],[115,48.73],[116,47.73],[116,46.73],[117,44.73],[118,43.73],[118,42.73],[119,41.73],[119,39.73],[119,38.73],[119,37.73],[118,36.73],[118,36.73],[117,36.73],[115,35.73],[114,35.73],[111,35.73],[110,35.73],[110,35.73],[109,36.73],[109,37.73],[109,38.73],[109,39.73],[109,39.73],[110,39.73],[111,40.73],[113,41.73],[115,42.73],[118,43.73],[121,43.73],[123,44.73],[124,46.73],[124,47.73],[125,47.73],[125,48.73],[125,49.73],[125,50.73],[125,51.73],[125,52.73],[125,53.73],[124,53.73],[123,53.73],[121,54.73],[119,54.73],[117,54.73],[116,54.73],[115,54.73],[114,54.73],[113,54.73]],[[137,17.73],[137,18.73],[137,19.73],[137,20.73],[138,22.73],[138,23.73],[139,25.73],[139,26.73],[140,27.73],[140,29.73],[141,30.73],[141,32.73],[141,33.73],[141,35.73],[141,36.73],[141,39.73],[142,40.73],[142,41.73],[142,43.73],[142,44.73],[142,45.73],[142,46.73],[143,48.73],[143,49.73],[143,50.73],[143,51.73],[143,52.73],[144,53.73],[144,54.73],[145,55.73],[147,55.73],[148,56.73],[149,56.73],[150,56.73],[152,56.73],[153,56.73],[155,56.73],[157,56.73],[158,56.73],[160,54.73],[162,53.73],[163,52.73],[164,51.73]],[[132,33.73],[133,33.73],[134,33.73],[138,33.73],[141,33.73],[143,33.73],[145,33.73],[146,33.73],[147,33.73],[149,33.73],[151,33.73],[153,33.73],[154,33.73],[155,33.73],[156,33.73],[157,33.73],[157,33.73],[158,33.73],[159,33.73],[160,33.73]]]}";
                    executeScript("$('#CpaSignatureIndTouch').signature('draw'," + AppSig1 + ")");

                    break;
                case "AppSig2":

                    break;

            }

        }


    }
}
