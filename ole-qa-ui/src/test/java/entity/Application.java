package entity;

import entity.phone.CribSheet;
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
    private String AgentFirstName = "";
    private String AgentMI = "";
    private String AgentLastName = "";
    private String AgentPhone = "";
    public String AgentSignatureIndTouch = "";
    public String SignatureIndTouch = "";
    public String MedicalReleaseAuthSignatureIndTouch = "";
    public String DesigneeSigTouch = "";
    public String CpaSignatureIndTouch = "";
    public String AgentRNSignatureIndTouch = "";
    public String ApplicantRNSignatureIndTouch = "";
    public String EftSignatureIndTouch = "";

    public String getCpaSignatureIndTouch() {
        return CpaSignatureIndTouch;
    }

    public void setCpaSignatureIndTouch(String cpaSignatureIndTouch) {
        CpaSignatureIndTouch = cpaSignatureIndTouch;
    }

    public String getAgentRNSignatureIndTouch() {
        return AgentRNSignatureIndTouch;
    }

    public void setAgentRNSignatureIndTouch(String agentRNSignatureIndTouch) {
        AgentRNSignatureIndTouch = agentRNSignatureIndTouch;
    }

    public String getApplicantRNSignatureIndTouch() {
        return ApplicantRNSignatureIndTouch;
    }

    public void setApplicantRNSignatureIndTouch(String applicantRNSignatureIndTouch) {
        ApplicantRNSignatureIndTouch = applicantRNSignatureIndTouch;
    }

    public String getEftSignatureIndTouch() {
        return EftSignatureIndTouch;
    }

    public void setEftSignatureIndTouch(String eftSignatureIndTouch) {
        EftSignatureIndTouch = eftSignatureIndTouch;
    }



    public String getDesigneeSigTouch() {
        return DesigneeSigTouch;
    }

    public void setDesigneeSigTouch(String designeeSigTouch) {
        DesigneeSigTouch = designeeSigTouch;
    }

    public String getMedicalReleaseAuthSignatureIndTouch() {
        return MedicalReleaseAuthSignatureIndTouch;
    }

    public void setMedicalReleaseAuthSignatureIndTouch(String medicalReleaseAuthSignatureIndTouch) {
        MedicalReleaseAuthSignatureIndTouch = medicalReleaseAuthSignatureIndTouch;
    }

    public String getSignatureIndTouch() {
        return SignatureIndTouch;
    }

    public void setSignatureIndTouch(String signatureIndTouch) {
        SignatureIndTouch = signatureIndTouch;
    }

    public String getAgentSignatureIndTouch() {
        return AgentSignatureIndTouch;
    }

    public void setAgentSignatureIndTouch(String agentSignatureIndTouch) {
        AgentSignatureIndTouch = agentSignatureIndTouch;
    }




    public String getAgentFirstName() {
        return AgentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        AgentFirstName = agentFirstName;
    }

    public String getAgentMI() {
        return AgentMI;
    }

    public void setAgentMI(String agentMI) {
        AgentMI = agentMI;
    }

    public String getAgentLastName() {
        return AgentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        AgentLastName = agentLastName;
    }

    public String getAgentPhone() {
        return AgentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        AgentPhone = agentPhone;
    }


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


    public static String[] ALL_SIGNATURES = {
            "{\"lines\":[[[69.5,42.77],[69.5,41.77],[69.5,39.77],[69.5,35.77],[69.5,31.77],[69.5,29.77],[70.5,26.77],[71.5,23.77],[72.5,21.77],[74.5,16.77],[76.5,14.77],[76.5,13.77],[77.5,13.77],[78.5,14.77],[79.5,16.77],[79.5,18.77],[79.5,19.77],[80.5,22.77],[80.5,23.77],[81.5,24.77],[81.5,25.77],[81.5,26.77],[82.5,27.77],[82.5,28.77],[82.5,29.77],[82.5,30.77],[82.5,31.77],[82.5,32.77],[82.5,33.77],[82.5,34.77],[82.5,35.77],[82.5,36.77],[82.5,37.77],[82.5,39.77]],[[75.5,37.77],[76.5,37.77],[77.5,37.77],[78.5,37.77],[79.5,37.77],[81.5,37.77],[83.5,37.77],[85.5,37.77],[86.5,37.77],[87.5,37.77],[88.5,37.77],[89.5,37.77],[89.5,35.77],[90.5,35.77],[90.5,36.77],[90.5,37.77],[90.5,38.77],[90.5,40.77],[90.5,41.77],[90.5,42.77],[90.5,43.77],[90.5,46.77],[90.5,47.77],[90.5,48.77],[90.5,49.77],[89.5,49.77]],[[94.5,37.77],[95.5,37.77],[96.5,37.77],[97.5,37.77],[98.5,37.77],[99.5,37.77],[100.5,37.77],[101.5,37.77],[102.5,37.77],[103.5,37.77],[103.5,38.77],[103.5,39.77],[103.5,40.77],[102.5,40.77],[101.5,41.77],[101.5,42.77],[100.5,42.77],[100.5,42.77],[99.5,42.77],[98.5,42.77],[97.5,42.77],[96.5,42.77],[95.5,42.77],[94.5,42.77],[93.5,42.77]],[[117.5,28.77],[117.5,32.77],[117.5,35.77],[117.5,41.77],[116.5,46.77],[116.5,50.77],[116.5,54.77],[116.5,56.77],[116.5,57.77]]]}",   // App1
            "{\"lines\":[[[69.5,42.77],[69.5,41.77],[69.5,39.77],[69.5,35.77],[69.5,31.77],[69.5,29.77],[70.5,26.77],[71.5,23.77],[72.5,21.77],[74.5,16.77],[76.5,14.77],[76.5,13.77],[77.5,13.77],[78.5,14.77],[79.5,16.77],[79.5,18.77],[79.5,19.77],[80.5,22.77],[80.5,23.77],[81.5,24.77],[81.5,25.77],[81.5,26.77],[82.5,27.77],[82.5,28.77],[82.5,29.77],[82.5,30.77],[82.5,31.77],[82.5,32.77],[82.5,33.77],[82.5,34.77],[82.5,35.77],[82.5,36.77],[82.5,37.77],[82.5,39.77]],[[75.5,37.77],[76.5,37.77],[77.5,37.77],[78.5,37.77],[79.5,37.77],[81.5,37.77],[83.5,37.77],[85.5,37.77],[86.5,37.77],[87.5,37.77],[88.5,37.77],[89.5,37.77],[89.5,35.77],[90.5,35.77],[90.5,36.77],[90.5,37.77],[90.5,38.77],[90.5,40.77],[90.5,41.77],[90.5,42.77],[90.5,43.77],[90.5,46.77],[90.5,47.77],[90.5,48.77],[90.5,49.77],[89.5,49.77]],[[94.5,37.77],[95.5,37.77],[96.5,37.77],[97.5,37.77],[98.5,37.77],[99.5,37.77],[100.5,37.77],[101.5,37.77],[102.5,37.77],[103.5,37.77],[103.5,38.77],[103.5,39.77],[103.5,40.77],[102.5,40.77],[101.5,41.77],[101.5,42.77],[100.5,42.77],[100.5,42.77],[99.5,42.77],[98.5,42.77],[97.5,42.77],[96.5,42.77],[95.5,42.77],[94.5,42.77],[93.5,42.77]],[[117.5,28.77],[117.5,32.77],[117.5,35.77],[117.5,41.77],[116.5,46.77],[116.5,50.77],[116.5,54.77],[116.5,56.77],[116.5,57.77]]]}", // app 2
            "{\"lines\":[[[136.5,14.77],[132.5,17.77],[128.5,19.77],[124.5,22.77],[121.5,25.77],[118.5,28.77],[117.5,30.77],[116.5,31.77],[115.5,33.77],[113.5,34.77],[112.5,35.77],[111.5,36.77],[110.5,37.77],[109.5,40.77],[109.5,41.77],[108.5,42.77]],[[138.5,15.77],[139.5,15.77],[140.5,18.77],[142.5,20.77],[144.5,24.77],[147.5,27.77],[148.5,30.77],[149.5,32.77],[150.5,34.77],[150.5,35.77],[151.5,36.77],[151.5,38.77],[152.5,39.77],[152.5,40.77],[153.5,40.77],[153.5,41.77],[153.5,42.77],[153.5,43.77],[153.5,44.77],[154.5,45.77],[154.5,46.77]],[[121.5,30.77],[122.5,30.77],[123.5,30.77],[128.5,30.77],[131.5,30.77],[133.5,30.77],[136.5,31.77],[137.5,31.77],[138.5,31.77],[139.5,31.77],[140.5,31.77],[141.5,31.77],[142.5,31.77],[143.5,31.77],[144.5,31.77],[145.5,31.77],[146.5,31.77]],[[165.5,35.77],[165.5,36.77],[164.5,40.77],[163.5,42.77],[161.5,49.77],[160.5,51.77],[160.5,52.77],[160.5,53.77],[160.5,54.77],[160.5,55.77],[160.5,54.77]],[[167.5,36.77],[170.5,35.77],[171.5,35.77],[172.5,35.77],[175.5,35.77],[178.5,35.77],[181.5,35.77],[183.5,35.77],[184.5,35.77],[184.5,36.77],[182.5,37.77],[181.5,38.77],[179.5,39.77],[177.5,39.77],[176.5,40.77],[175.5,40.77],[174.5,40.77],[173.5,41.77],[170.5,41.77],[167.5,41.77],[166.5,41.77],[166.5,42.77],[165.5,42.77],[164.5,42.77]],[[190.5,38.77],[189.5,39.77],[188.5,41.77],[187.5,45.77],[186.5,47.77],[186.5,48.77],[185.5,48.77],[185.5,49.77],[185.5,50.77],[185.5,48.77]],[[190.5,34.77],[192.5,34.77],[193.5,34.77],[194.5,34.77],[200.5,35.77],[204.5,36.77],[207.5,36.77],[208.5,36.77],[209.5,36.77],[209.5,37.77],[209.5,38.77],[208.5,38.77],[205.5,39.77],[202.5,40.77],[199.5,40.77],[196.5,40.77],[195.5,41.77],[194.5,41.77],[193.5,41.77],[192.5,41.77]],[[217.5,30.77],[218.5,30.77],[220.5,30.77],[224.5,30.77],[227.5,30.77],[231.5,30.77],[238.5,31.77],[243.5,33.77],[245.5,34.77],[245.5,35.77],[241.5,38.77],[237.5,40.77],[234.5,40.77],[231.5,40.77],[230.5,41.77],[231.5,41.77],[235.5,41.77],[239.5,41.77],[244.5,42.77],[246.5,42.77],[247.5,43.77],[247.5,45.77],[247.5,46.77],[247.5,47.77],[246.5,48.77],[244.5,49.77],[242.5,49.77],[241.5,49.77],[240.5,49.77],[239.5,49.77],[238.5,50.77],[233.5,50.77],[231.5,50.77],[229.5,50.77],[228.5,50.77],[227.5,50.77],[226.5,50.77],[225.5,50.77],[224.5,50.77],[223.5,50.77],[222.5,50.77],[221.5,50.77]]]}", //app 3
            "{\"lines\":[[[96.5,46.77],[97.5,42.77],[99.5,37.77],[101.5,32.77],[104.5,27.77],[107.5,22.77],[111.5,19.77],[117.5,13.77],[120.5,12.77],[120.5,12.77],[121.5,12.77],[122.5,13.77],[122.5,18.77],[123.5,22.77],[123.5,27.77],[124.5,30.77],[124.5,33.77],[124.5,36.77],[124.5,37.77],[124.5,38.77],[124.5,39.77],[124.5,40.77]],[[112.5,38.77],[113.5,37.77],[116.5,37.77],[121.5,36.77],[133.5,35.77],[135.5,35.77],[136.5,35.77],[137.5,35.77],[137.5,36.77],[137.5,38.77],[131.5,51.77],[130.5,53.77],[130.5,52.77],[130.5,51.77]],[[140.5,36.77],[141.5,36.77],[143.5,36.77],[146.5,34.77],[151.5,33.77],[155.5,32.77],[157.5,32.77],[158.5,32.77],[158.5,33.77],[158.5,34.77],[158.5,37.77],[156.5,39.77],[155.5,40.77],[153.5,40.77],[151.5,41.77],[148.5,42.77],[145.5,42.77],[141.5,42.77],[139.5,42.77],[138.5,42.77],[137.5,42.77],[138.5,42.77]],[[169.5,35.77],[169.5,36.77],[169.5,38.77],[168.5,39.77],[167.5,42.77],[166.5,44.77],[166.5,45.77],[165.5,48.77],[165.5,50.77],[164.5,51.77],[163.5,53.77],[163.5,54.77],[163.5,53.77],[163.5,52.77],[163.5,50.77]],[[171.5,32.77],[172.5,32.77],[175.5,32.77],[182.5,32.77],[188.5,32.77],[193.5,34.77],[196.5,34.77],[196.5,35.77],[196.5,36.77],[196.5,38.77],[194.5,39.77],[192.5,39.77],[189.5,41.77],[187.5,41.77],[185.5,41.77],[183.5,42.77],[176.5,42.77],[173.5,42.77],[172.5,42.77],[171.5,42.77]],[[214.5,19.77],[214.5,20.77],[214.5,22.77],[213.5,25.77],[207.5,35.77],[203.5,39.77],[201.5,43.77],[200.5,43.77],[201.5,43.77],[206.5,43.77],[211.5,43.77],[217.5,44.77],[222.5,44.77],[228.5,44.77],[230.5,44.77]],[[234.5,24.77],[234.5,25.77],[233.5,33.77],[229.5,44.77],[225.5,49.77],[225.5,51.77],[225.5,53.77],[225.5,54.77],[225.5,55.77],[224.5,55.77],[224.5,54.77]]]}", //app4
            "{\"lines\":[[[123,39.77],[123,38.77],[123,36.77],[125,33.77],[128,26.77],[132,21.77],[146,5.77],[149,3.77],[150,2.77],[150,3.77],[150,6.77],[150,10.77],[150,18.77],[150,21.77],[150,22.77],[150,23.77],[150,25.77],[150,26.77],[150,27.77],[150,28.77],[150,29.77],[150,30.77],[150,31.77],[150,32.77],[150,33.77],[150,34.77],[150,35.77],[150,36.77],[150,37.77],[149,40.77],[149,43.77],[149,44.77],[148,44.77]],[[136,29.77],[141,27.77],[145,27.77],[151,26.77],[154,26.77],[156,26.77],[158,26.77],[159,26.77],[160,26.77],[160,29.77],[160,33.77],[159,38.77],[157,43.77],[155,48.77],[155,49.77],[155,48.77],[155,46.77],[155,44.77]],[[164,25.77],[169,25.77],[170,25.77],[173,25.77],[177,25.77],[179,25.77],[180,25.77],[180,26.77],[180,27.77],[180,28.77],[179,30.77],[177,30.77],[175,31.77],[173,33.77],[170,34.77],[169,34.77],[167,35.77],[166,35.77],[167,35.77]],[[189,29.77],[189,30.77],[188,34.77],[187,39.77],[185,43.77],[184,47.77],[183,48.77],[183,49.77],[183,47.77],[183,44.77]],[[195,26.77],[196,26.77],[197,26.77],[197,26.77],[197,27.77],[197,29.77],[199,30.77],[199,32.77],[199,34.77],[199,36.77],[197,38.77],[196,39.77],[195,39.77],[195,40.77],[194,40.77],[192,40.77],[191,40.77],[190,40.77]],[[209,14.77],[219,11.77],[225,10.77],[227,10.77],[228,10.77],[227,10.77],[224,10.77]],[[210,18.77],[210,20.77],[210,21.77],[210,23.77],[210,25.77],[209,28.77],[209,30.77],[208,31.77],[208,30.77],[209,28.77],[211,27.77],[217,25.77],[221,25.77],[225,25.77],[229,31.77],[229,33.77],[229,36.77],[228,39.77],[223,42.77],[219,44.77],[213,45.77],[206,45.77],[202,45.77],[200,44.77],[201,44.77]]]}", //app 5
            "{\"lines\":[[[107,42.77],[107,40.77],[108,38.77],[112,34.77],[116,25.77],[122,16.77],[127,10.77],[131,4.77],[133,2.77],[134,2.77],[135,4.77],[136,10.77],[138,18.77],[141,24.77],[143,33.77],[144,38.77],[144,39.77],[144,40.77]],[[115,30.77],[116,30.77],[117,29.77],[125,28.77],[135,28.77],[146,28.77],[153,28.77],[158,28.77],[161,28.77],[163,28.77],[164,28.77],[165,27.77],[166,26.77],[167,26.77],[168,26.77],[167,27.77],[165,29.77],[156,39.77],[156,41.77],[156,43.77],[156,45.77],[159,47.77],[166,48.77],[174,48.77],[181,49.77],[183,49.77],[184,49.77],[184,48.77],[184,46.77],[184,45.77],[182,43.77],[180,41.77],[177,39.77],[174,39.77],[173,37.77],[173,36.77],[177,36.77],[181,36.77],[186,36.77],[189,36.77],[190,36.77],[191,36.77],[191,37.77],[191,40.77],[191,43.77],[191,51.77],[191,53.77],[191,54.77]],[[205,19.77],[205,21.77],[205,24.77],[205,28.77],[202,40.77],[201,45.77],[201,48.77],[201,52.77],[201,55.77],[201,55.77]]]}", //agent 1
            "{\"lines\":[[[128,51.77],[128,50.77],[128,49.77],[128,47.77],[130,40.77],[133,34.77],[137,25.77],[141,19.77],[143,16.77],[145,14.77],[146,14.77],[147,14.77],[148,18.77],[152,23.77],[156,32.77],[159,37.77],[162,42.77],[164,46.77],[166,49.77],[166,50.77],[166,49.77],[166,48.77],[166,46.77],[165,43.77],[163,42.77],[153,38.77],[146,38.77],[137,38.77],[129,38.77],[125,38.77],[124,38.77],[126,38.77],[134,38.77],[146,37.77],[159,34.77],[171,33.77],[179,31.77],[185,30.77],[189,30.77],[191,29.77],[191,30.77],[190,32.77],[189,36.77],[187,40.77],[187,43.77],[186,47.77],[186,52.77],[193,56.77],[198,56.77],[209,56.77],[210,55.77],[211,53.77],[211,48.77],[208,46.77],[204,44.77],[203,44.77],[203,43.77],[205,42.77],[207,41.77],[213,39.77],[231,37.77],[236,37.77],[237,37.77],[237,38.77],[236,40.77],[235,43.77],[234,45.77],[232,48.77],[232,51.77],[232,54.77],[232,54.77]],[[251,24.77],[253,24.77],[260,24.77],[269,24.77],[279,25.77],[285,28.77],[286,29.77],[286,32.77],[280,39.77],[274,42.77],[269,45.77],[268,46.77],[267,46.77],[268,46.77],[290,45.77],[306,45.77],[320,45.77],[323,45.77],[322,45.77]]]}", //agent 2
            "{\"lines\":[[[128,51.77],[128,50.77],[128,49.77],[128,47.77],[130,40.77],[133,34.77],[137,25.77],[141,19.77],[143,16.77],[145,14.77],[146,14.77],[147,14.77],[148,18.77],[152,23.77],[156,32.77],[159,37.77],[162,42.77],[164,46.77],[166,49.77],[166,50.77],[166,49.77],[166,48.77],[166,46.77],[165,43.77],[163,42.77],[153,38.77],[146,38.77],[137,38.77],[129,38.77],[125,38.77],[124,38.77],[126,38.77],[134,38.77],[146,37.77],[159,34.77],[171,33.77],[179,31.77],[185,30.77],[189,30.77],[191,29.77],[191,30.77],[190,32.77],[189,36.77],[187,40.77],[187,43.77],[186,47.77],[186,52.77],[193,56.77],[198,56.77],[209,56.77],[210,55.77],[211,53.77],[211,48.77],[208,46.77],[204,44.77],[203,44.77],[203,43.77],[205,42.77],[207,41.77],[213,39.77],[231,37.77],[236,37.77],[237,37.77],[237,38.77],[236,40.77],[235,43.77],[234,45.77],[232,48.77],[232,51.77],[232,54.77],[232,54.77]],[[251,24.77],[253,24.77],[260,24.77],[269,24.77],[279,25.77],[285,28.77],[286,29.77],[286,32.77],[280,39.77],[274,42.77],[269,45.77],[268,46.77],[267,46.77],[268,46.77],[290,45.77],[306,45.77],[320,45.77],[323,45.77],[322,45.77]]]}", //EFT 1
    };


    public String agentSignature = "";

    public String getAgentSignature() {
        return agentSignature;
    }

    public void setAgentSignature(String agentSignature) {
        this.agentSignature = agentSignature;
    }

}
