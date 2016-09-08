package resources.entity;

import resources.entity.phone.CribSheet;
import resources.utils.AnswerUtils;
import resources.utils.DateUtils;
import resources.utils.PlanEligibilityQuestionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class Application {

    public Application() {
    }
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
    private String GIMPBED = "";
    private String AARPMemberNumber = "";
    private String CAGuaranteedAcceptance = "";
    private String EmployerId = "";
    private String Rider1 = "";
    private String Rider2 = "";
    private String Rider3 = "";
    private String Rider4 = "";
    private String Rider5 = "";

    public String getPlanPaymentOptions() {
        return PlanPaymentOptions;
    }

    public void setPlanPaymentOptions(String planPaymentOptions) {
        PlanPaymentOptions = planPaymentOptions;
    }

    private String PlanPaymentOptions = "";
    
    
    
    public String getRider1() {
        return Rider1;
    }

    public void setRider1(String rider1) {
        Rider1 = rider1;
    }

    public String getRider2() {
        return Rider2;
    }

    public void setRider2(String rider2) {
        Rider2 = rider2;
    }

    public String getRider3() {
        return Rider3;
    }

    public void setRider3(String rider3) {
        Rider3 = rider3;
    }

    public String getRider4() {
        return Rider4;
    }

    public void setRider4(String rider4) {
        Rider4 = rider4;
    }

    public String getRider5() {
        return Rider5;
    }

    public void setRider5(String rider5) {
        Rider5 = rider5;
    }
    
    public Integer getExpectedReqEffectiveDates() {
        return ExpectedReqEffectiveDates;
    }

    public void setExpectedReqEffectiveDates(Integer expectedReqEffectiveDates) {
        ExpectedReqEffectiveDates = expectedReqEffectiveDates;
    }

    private Integer ExpectedReqEffectiveDates = 0;

    public String getEmployerId() {
        return EmployerId;
    }

    public void setEmployerId(String employerId) {
        EmployerId = employerId;
    }

    public String getGroupApp() {
        return GroupApp;
    }

    public void setGroupApp(String groupApp) {
        GroupApp = groupApp;
    }

    private String GroupApp = "";

    public String getCAGuaranteedAcceptance() {
        return CAGuaranteedAcceptance;
    }

    public void setCAGuaranteedAcceptance(String CAGuaranteedAcceptance) {
        this.CAGuaranteedAcceptance = CAGuaranteedAcceptance;
    }

    public String getAARPMemberNumber() {
        return AARPMemberNumber;
    }

    public String getInsurTermed() {
        return InsurTermed;
    }

    public void setInsurTermed(String insurTermed) {
        InsurTermed = insurTermed;
    }

    private String InsurTermed = "";

    public String getGIMPBED() {
        return GIMPBED;
    }
    public void setGIMPBED(String GIMPBED) {
        this.GIMPBED = GIMPBED;
    }
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
    public String ApplicantRNSignatureIndRequired = "";
    public String EftSignatureIndTouch = "";
    public String MedicalReleaseClaimSignatureIndTouch = "";
    public String ReplacementAgentSignInd2Touch = "";

    public String getOnlinePreferenceSignatureTouch() {
        return OnlinePreferenceSignatureTouch;
    }

    public void setOnlinePreferenceSignatureTouch(String onlinePreferenceSignatureTouch) {
        OnlinePreferenceSignatureTouch = onlinePreferenceSignatureTouch;
    }

    public String OnlinePreferenceSignatureTouch = "";
    private String BankName = "";
    private String RoutingNumber = "";
    private String SS_FormDate = "";
    private String SS_App_Signature1 = "";
    private String SS_Agent_Signature1 = "";
    private String AgencyName = "";
    private String AgencyAddress = "";
    private String AgencyPhone = "";
    private String SS_App_PrintedName = "";
    private String SS_Agent_PrintedName = "";
    private String SS_LicenseNumber = "";
    private String SS_StreetAddress = "";
    private String SS_City = "";
    private String SS_Zip = "";
    private String SS_Phone = "";
    private String SS_State = "";
    private String oleReffId = "";
    public String resumeApplication = "";
    public String applicationId = "";
    public String applicationStatus = "";
    public String MedicalReleaseAuthSignatureIndRequired = "";

    public String getIL23991Touch() {
        return IL23991Touch;
    }

    public void setIL23991Touch(String IL23991Touch) {
        this.IL23991Touch = IL23991Touch;
    }

    public String getIL23993Touch() {
        return IL23993Touch;
    }

    public void setIL23993Touch(String IL23993Touch) {
        this.IL23993Touch = IL23993Touch;
    }

    public String IL23991Touch = "";
    public String IL23993Touch = "";
    private String MailingAddressLine1 = "";
    private String MailingAddressLine2 = "";
    private String MailingCity = "";
    private String MailingState = "";
    private String MailingZipCode = "";
    private String MailingAddressCheck = "";
    private String KidneyProblem = "";
    private String EligibilitySurgery = "";
    private String EligibilityAdmitToHospPast90Days = "";
    private String NursingFacility = "";
    private String EligibilityHeartAttackTIAStroke = "";
    private String EligibilityChronicMedicalConditions = "";
    private String ContinuousMedicareCoverageNoGap = "";
    private String UnderstandAndAuthorize = "";

    public String getUnderstandAndAuthorize() {
        return UnderstandAndAuthorize;
    }

    public void setUnderstandAndAuthorize(String understandAndAuthorize) {
        UnderstandAndAuthorize = understandAndAuthorize;
    }

    public String getContinuousMedicareCoverageNoGap() {
        return ContinuousMedicareCoverageNoGap;
    }

    public void setContinuousMedicareCoverageNoGap(String continuousMedicareCoverageNoGap) {
        ContinuousMedicareCoverageNoGap = continuousMedicareCoverageNoGap;
    }

    public String getKidneyProblem() {
        return KidneyProblem;
    }

    public void setKidneyProblem(String kidneyProblem) {
        KidneyProblem = kidneyProblem;
    }

    public String getEligibilitySurgery() {
        return EligibilitySurgery;
    }

    public void setEligibilitySurgery(String eligibilitySurgery) {
        EligibilitySurgery = eligibilitySurgery;
    }

    public String getEligibilityAdmitToHospPast90Days() {
        return EligibilityAdmitToHospPast90Days;
    }

    public void setEligibilityAdmitToHospPast90Days(String eligibilityAdmitToHospPast90Days) {
        EligibilityAdmitToHospPast90Days = eligibilityAdmitToHospPast90Days;
    }

    public String getNursingFacility() {
        return NursingFacility;
    }

    public void setNursingFacility(String nursingFacility) {
        NursingFacility = nursingFacility;
    }

    public String getEligibilityHeartAttackTIAStroke() {
        return EligibilityHeartAttackTIAStroke;
    }

    public void setEligibilityHeartAttackTIAStroke(String eligibilityHeartAttackTIAStroke) {
        EligibilityHeartAttackTIAStroke = eligibilityHeartAttackTIAStroke;
    }

    public String getEligibilityChronicMedicalConditions() {
        return EligibilityChronicMedicalConditions;
    }

    public void setEligibilityChronicMedicalConditions(String eligibilityChronicMedicalConditions) {
        EligibilityChronicMedicalConditions = eligibilityChronicMedicalConditions;
    }

    public String getMailingAddressCheck() {
        return MailingAddressCheck;
    }

    public void setMailingAddressCheck(String mailingAddressCheck) {
        MailingAddressCheck = mailingAddressCheck;
    }

    public String getMailingAddressLine1() {
        return MailingAddressLine1;
    }

    public void setMailingAddressLine1(String mailingAddressLine1) {
        MailingAddressLine1 = mailingAddressLine1;
    }

    public String getMailingAddressLine2() {
        return MailingAddressLine2;
    }

    public void setMailingAddressLine2(String mailingAddressLine2) {
        MailingAddressLine2 = mailingAddressLine2;
    }

    public String getMailingCity() {
        return MailingCity;
    }

    public void setMailingCity(String mailingCity) {
        MailingCity = mailingCity;
    }

    public String getMailingState() {
        return MailingState;
    }

    public void setMailingState(String mailingState) {
        MailingState = mailingState;
    }

    public String getMailingZipCode() {
        return MailingZipCode;
    }

    public void setMailingZipCode(String mailingZipCode) {
        MailingZipCode = mailingZipCode;
    }

    public String getMedicalReleaseAuthSignatureIndRequired() {
        return MedicalReleaseAuthSignatureIndRequired;
    }

    public void setMedicalReleaseAuthSignatureIndRequired(String medicalReleaseAuthSignatureIndRequired) {
        MedicalReleaseAuthSignatureIndRequired = medicalReleaseAuthSignatureIndRequired;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }


    public String getApplicantRNSignatureIndRequired() {
        return ApplicantRNSignatureIndRequired;
    }

    public void setApplicantRNSignatureIndRequired(String applicantRNSignatureIndRequired) {
        ApplicantRNSignatureIndRequired = applicantRNSignatureIndRequired;
    }
    public String getDtcApplicationId() {
        return dtcApplicationId;
    }

    public void setDtcApplicationId(String dtcApplicationId) {
        this.dtcApplicationId = dtcApplicationId;
    }

    public String dtcApplicationId = "";

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    public String getResumeApplication() {
        return resumeApplication;
    }

    public void setResumeApplication(String resumeApplication) {
        this.resumeApplication = resumeApplication;
    }
    public String getOleReffId() {
        return oleReffId;
    }

    public void setOleReffId(String oleReffId) {
        this.oleReffId = oleReffId;
    }

    public static String[] getAllSignatures() {
        return ALL_SIGNATURES;
    }

    public static void setAllSignatures(String[] allSignatures) {
        ALL_SIGNATURES = allSignatures;
    }

    public void setAARPMemberNumber(String AARPMemberNumber) {
        this.AARPMemberNumber = AARPMemberNumber;
    }

    public String getReplacementAgentSignInd2Touch() {
        return ReplacementAgentSignInd2Touch;
    }

    public void setReplacementAgentSignInd2Touch(String replacementAgentSignInd2Touch) {
        ReplacementAgentSignInd2Touch = replacementAgentSignInd2Touch;
    }

    public String getSS_State() {
        return SS_State;
    }

    public void setSS_State(String SS_State) {
        this.SS_State = SS_State;
    }


    public String getSS_Agent_PrintedName() {
        return SS_Agent_PrintedName;
    }

    public void setSS_Agent_PrintedName(String SS_Agent_PrintedName) {
        this.SS_Agent_PrintedName = SS_Agent_PrintedName;
    }

    public String getSS_LicenseNumber() {
        return SS_LicenseNumber;
    }

    public void setSS_LicenseNumber(String SS_LicenseNumber) {
        this.SS_LicenseNumber = SS_LicenseNumber;
    }

    public String getSS_StreetAddress() {
        return SS_StreetAddress;
    }

    public void setSS_StreetAddress(String SS_StreetAddress) {
        this.SS_StreetAddress = SS_StreetAddress;
    }

    public String getSS_City() {
        return SS_City;
    }

    public void setSS_City(String SS_City) {
        this.SS_City = SS_City;
    }

    public String getSS_Zip() {
        return SS_Zip;
    }

    public void setSS_Zip(String SS_Zip) {
        this.SS_Zip = SS_Zip;
    }

    public String getSS_Phone() {
        return SS_Phone;
    }

    public void setSS_Phone(String SS_Phone) {
        this.SS_Phone = SS_Phone;
    }


    public String getSS_App_PrintedName() {
        return SS_App_PrintedName;
    }

    public void setSS_App_PrintedName(String SS_App_PrintedName) {
        this.SS_App_PrintedName = SS_App_PrintedName;
    }

    public String getAgencyPhone() {
        return AgencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        AgencyPhone = agencyPhone;
    }

    public String getAgencyName() {
        return AgencyName;
    }

    public void setAgencyName(String agencyName) {
        AgencyName = agencyName;
    }

    public String getAgencyAddress() {
        return AgencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        AgencyAddress = agencyAddress;
    }

    public String getSS_Agent_Signature1() {
        return SS_Agent_Signature1;
    }

    public void setSS_Agent_Signature1(String SS_Agent_Signature1) {
        this.SS_Agent_Signature1 = SS_Agent_Signature1;
    }

    public String getSS_FormDate() {
        return SS_FormDate;
    }

    public void setSS_FormDate(String SS_FormDate) {
        this.SS_FormDate = SS_FormDate;
    }

    public String getSS_App_Signature1() {
        return SS_App_Signature1;
    }

    public void setSS_App_Signature1(String SS_App_Signature1) {
        this.SS_App_Signature1 = SS_App_Signature1;
    }

    public String getMedicalReleaseClaimSignatureIndTouch() {
        return MedicalReleaseClaimSignatureIndTouch;
    }

    public void setMedicalReleaseClaimSignatureIndTouch(String medicalReleaseClaimSignatureIndTouch) {
        MedicalReleaseClaimSignatureIndTouch = medicalReleaseClaimSignatureIndTouch;
    }

    public String getAccountNumberConfirm() {
        return AccountNumberConfirm;
    }

    public void setAccountNumberConfirm(String accountNumberConfirm) {
        AccountNumberConfirm = accountNumberConfirm;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getRoutingNumber() {
        return RoutingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        RoutingNumber = routingNumber;
    }

    public String getRoutingNumberConfirm() {
        return RoutingNumberConfirm;
    }

    public void setRoutingNumberConfirm(String routingNumberConfirm) {
        RoutingNumberConfirm = routingNumberConfirm;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    private String RoutingNumberConfirm = "";
    private String AccountNumber = "";
    private String AccountNumberConfirm = "";
    
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

    public void  setMedicalReleaseAuthSignatureIndTouch(String medicalReleaseAuthSignatureIndTouch) {
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

    private Hashtable<String, Object> testData = new Hashtable<String, Object>();

    public Hashtable<String, java.lang.Object> getTestData() {
        return testData;
    }

    public void setTestData(Hashtable<String, java.lang.Object> testData) {
        this.testData = testData;
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
        
    public void setPaymentDetailsSummaryPageWithAppValues() {
        setBankName("BofA");
        setRoutingNumber("123123123");
        setRoutingNumberConfirm("123123123");
        setAccountNumber("23456");
        setAccountNumberConfirm("23456");
    }

    public void setDefaultPlanEligibilityQuestions(CribSheet sheet) {

        Date dob = new Date(DateUtils.convertDate(sheet.getDateOfBirth(), DateUtils.NORMALIZED_DATE_FORMAT));
        Date dpsd = new Date(DateUtils.convertDate(sheet.getDpsd(), DateUtils.NORMALIZED_DATE_FORMAT));
        Date mpbed = new Date(DateUtils.convertDate(sheet.getMedPartBdate(), DateUtils.NORMALIZED_DATE_FORMAT));

        setTurned65In6GA(PlanEligibilityQuestionUtils.hasTurned65In6GABasedUponDpsd(dob, dpsd));
        setPartBIn6GA(PlanEligibilityQuestionUtils.hasPartBIn6GABasedUponDpsd(mpbed, dpsd));
        setPlanEffIn6OfEligible(PlanEligibilityQuestionUtils.hasPlanEffIn6OfEligibleBasedUponDpsd(dob, mpbed, dpsd));
    }
    public static SimpleDateFormat NORMALIZED_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    public static String getDOBofPersonTurningAgeToday(int age) {
        Date dob = org.apache.commons.lang3.time.DateUtils.addYears(new Date(), -age);
        return NORMALIZED_DATE_FORMAT.format(dob);
    }

    public static String[] ALL_SIGNATURES = {
            "{\"lines\":[[[69.5,42.77],[69.5,41.77],[69.5,39.77],[69.5,35.77],[69.5,31.77],[69.5,29.77],[70.5,26.77],[71.5,23.77],[72.5,21.77],[74.5,16.77],[76.5,14.77],[76.5,13.77],[77.5,13.77],[78.5,14.77],[79.5,16.77],[79.5,18.77],[79.5,19.77],[80.5,22.77],[80.5,23.77],[81.5,24.77],[81.5,25.77],[81.5,26.77],[82.5,27.77],[82.5,28.77],[82.5,29.77],[82.5,30.77],[82.5,31.77],[82.5,32.77],[82.5,33.77],[82.5,34.77],[82.5,35.77],[82.5,36.77],[82.5,37.77],[82.5,39.77]],[[75.5,37.77],[76.5,37.77],[77.5,37.77],[78.5,37.77],[79.5,37.77],[81.5,37.77],[83.5,37.77],[85.5,37.77],[86.5,37.77],[87.5,37.77],[88.5,37.77],[89.5,37.77],[89.5,35.77],[90.5,35.77],[90.5,36.77],[90.5,37.77],[90.5,38.77],[90.5,40.77],[90.5,41.77],[90.5,42.77],[90.5,43.77],[90.5,46.77],[90.5,47.77],[90.5,48.77],[90.5,49.77],[89.5,49.77]],[[94.5,37.77],[95.5,37.77],[96.5,37.77],[97.5,37.77],[98.5,37.77],[99.5,37.77],[100.5,37.77],[101.5,37.77],[102.5,37.77],[103.5,37.77],[103.5,38.77],[103.5,39.77],[103.5,40.77],[102.5,40.77],[101.5,41.77],[101.5,42.77],[100.5,42.77],[100.5,42.77],[99.5,42.77],[98.5,42.77],[97.5,42.77],[96.5,42.77],[95.5,42.77],[94.5,42.77],[93.5,42.77]],[[117.5,28.77],[117.5,32.77],[117.5,35.77],[117.5,41.77],[116.5,46.77],[116.5,50.77],[116.5,54.77],[116.5,56.77],[116.5,57.77]]]}", //CPASignatureInd 1
            
            "{\"lines\":[[[119.5,45],[120.5,43],[122.5,39],[126.5,33],[132.5,27],[138.5,22],[141.5,19],[142.5,18],[143.5,17],[144.5,17],[145.5,17],[146.5,17],[147.5,20],[147.5,22],[148.5,25],[149.5,28],[150.5,35],[150.5,38],[151.5,42],[151.5,44],[151.5,45],[151.5,46]],[[133.5,37],[133.5,36],[135.5,36],[136.5,36],[137.5,36],[139.5,36],[143.5,35],[151.5,35],[155.5,35],[158.5,35],[159.5,35],[160.5,35],[161.5,35],[161.5,36],[161.5,39],[161.5,43],[161.5,46],[161.5,49],[160.5,49],[160.5,48]],[[161.5,36],[162.5,36],[162.5,35],[163.5,35],[165.5,34],[166.5,34],[167.5,34],[168.5,34],[169.5,34],[169.5,35],[169.5,36],[169.5,37],[169.5,38],[167.5,41],[166.5,42],[165.5,42],[164.5,42],[163.5,42]],[[178.5,35],[178.5,36],[178.5,37],[178.5,38],[178.5,41],[178.5,43],[178.5,46],[178.5,48]],[[178.5,34],[179.5,33],[179.5,32],[180.5,32],[181.5,32],[182.5,32],[183.5,32],[184.5,32],[185.5,32],[185.5,33],[186.5,33],[186.5,34],[186.5,36],[186.5,38],[186.5,39],[186.5,40],[185.5,40],[184.5,41],[183.5,41],[182.5,41],[181.5,41],[180.5,41],[179.5,41],[178.5,41],[177.5,41]],[[198.5,32],[198.5,31],[198.5,30],[198.5,28],[199.5,27],[200.5,27],[202.5,27],[205.5,27],[207.5,27],[208.5,28],[209.5,30],[210.5,32],[210.5,37],[210.5,40],[209.5,44],[208.5,47],[205.5,51],[204.5,52],[200.5,56],[199.5,58],[198.5,58],[197.5,58],[196.5,58],[197.5,56],[200.5,54],[202.5,53],[204.5,52],[206.5,51],[209.5,51],[210.5,51],[215.5,51],[218.5,52],[222.5,53],[224.5,54],[225.5,55],[225.5,56],[226.5,56]]]}",// SignatureIndTouch 1
            
            "{\"lines\":[[[136.5,14.77],[132.5,17.77],[128.5,19.77],[124.5,22.77],[121.5,25.77],[118.5,28.77],[117.5,30.77],[116.5,31.77],[115.5,33.77],[113.5,34.77],[112.5,35.77],[111.5,36.77],[110.5,37.77],[109.5,40.77],[109.5,41.77],[108.5,42.77]],[[138.5,15.77],[139.5,15.77],[140.5,18.77],[142.5,20.77],[144.5,24.77],[147.5,27.77],[148.5,30.77],[149.5,32.77],[150.5,34.77],[150.5,35.77],[151.5,36.77],[151.5,38.77],[152.5,39.77],[152.5,40.77],[153.5,40.77],[153.5,41.77],[153.5,42.77],[153.5,43.77],[153.5,44.77],[154.5,45.77],[154.5,46.77]],[[121.5,30.77],[122.5,30.77],[123.5,30.77],[128.5,30.77],[131.5,30.77],[133.5,30.77],[136.5,31.77],[137.5,31.77],[138.5,31.77],[139.5,31.77],[140.5,31.77],[141.5,31.77],[142.5,31.77],[143.5,31.77],[144.5,31.77],[145.5,31.77],[146.5,31.77]],[[165.5,35.77],[165.5,36.77],[164.5,40.77],[163.5,42.77],[161.5,49.77],[160.5,51.77],[160.5,52.77],[160.5,53.77],[160.5,54.77],[160.5,55.77],[160.5,54.77]],[[167.5,36.77],[170.5,35.77],[171.5,35.77],[172.5,35.77],[175.5,35.77],[178.5,35.77],[181.5,35.77],[183.5,35.77],[184.5,35.77],[184.5,36.77],[182.5,37.77],[181.5,38.77],[179.5,39.77],[177.5,39.77],[176.5,40.77],[175.5,40.77],[174.5,40.77],[173.5,41.77],[170.5,41.77],[167.5,41.77],[166.5,41.77],[166.5,42.77],[165.5,42.77],[164.5,42.77]],[[190.5,38.77],[189.5,39.77],[188.5,41.77],[187.5,45.77],[186.5,47.77],[186.5,48.77],[185.5,48.77],[185.5,49.77],[185.5,50.77],[185.5,48.77]],[[190.5,34.77],[192.5,34.77],[193.5,34.77],[194.5,34.77],[200.5,35.77],[204.5,36.77],[207.5,36.77],[208.5,36.77],[209.5,36.77],[209.5,37.77],[209.5,38.77],[208.5,38.77],[205.5,39.77],[202.5,40.77],[199.5,40.77],[196.5,40.77],[195.5,41.77],[194.5,41.77],[193.5,41.77],[192.5,41.77]],[[217.5,30.77],[218.5,30.77],[220.5,30.77],[224.5,30.77],[227.5,30.77],[231.5,30.77],[238.5,31.77],[243.5,33.77],[245.5,34.77],[245.5,35.77],[241.5,38.77],[237.5,40.77],[234.5,40.77],[231.5,40.77],[230.5,41.77],[231.5,41.77],[235.5,41.77],[239.5,41.77],[244.5,42.77],[246.5,42.77],[247.5,43.77],[247.5,45.77],[247.5,46.77],[247.5,47.77],[246.5,48.77],[244.5,49.77],[242.5,49.77],[241.5,49.77],[240.5,49.77],[239.5,49.77],[238.5,50.77],[233.5,50.77],[231.5,50.77],[229.5,50.77],[228.5,50.77],[227.5,50.77],[226.5,50.77],[225.5,50.77],[224.5,50.77],[223.5,50.77],[222.5,50.77],[221.5,50.77]]]}",//MedicalAuthSigIndTouch
            
            "{\"lines\":[[[96.5,46.77],[97.5,42.77],[99.5,37.77],[101.5,32.77],[104.5,27.77],[107.5,22.77],[111.5,19.77],[117.5,13.77],[120.5,12.77],[120.5,12.77],[121.5,12.77],[122.5,13.77],[122.5,18.77],[123.5,22.77],[123.5,27.77],[124.5,30.77],[124.5,33.77],[124.5,36.77],[124.5,37.77],[124.5,38.77],[124.5,39.77],[124.5,40.77]],[[112.5,38.77],[113.5,37.77],[116.5,37.77],[121.5,36.77],[133.5,35.77],[135.5,35.77],[136.5,35.77],[137.5,35.77],[137.5,36.77],[137.5,38.77],[131.5,51.77],[130.5,53.77],[130.5,52.77],[130.5,51.77]],[[140.5,36.77],[141.5,36.77],[143.5,36.77],[146.5,34.77],[151.5,33.77],[155.5,32.77],[157.5,32.77],[158.5,32.77],[158.5,33.77],[158.5,34.77],[158.5,37.77],[156.5,39.77],[155.5,40.77],[153.5,40.77],[151.5,41.77],[148.5,42.77],[145.5,42.77],[141.5,42.77],[139.5,42.77],[138.5,42.77],[137.5,42.77],[138.5,42.77]],[[169.5,35.77],[169.5,36.77],[169.5,38.77],[168.5,39.77],[167.5,42.77],[166.5,44.77],[166.5,45.77],[165.5,48.77],[165.5,50.77],[164.5,51.77],[163.5,53.77],[163.5,54.77],[163.5,53.77],[163.5,52.77],[163.5,50.77]],[[171.5,32.77],[172.5,32.77],[175.5,32.77],[182.5,32.77],[188.5,32.77],[193.5,34.77],[196.5,34.77],[196.5,35.77],[196.5,36.77],[196.5,38.77],[194.5,39.77],[192.5,39.77],[189.5,41.77],[187.5,41.77],[185.5,41.77],[183.5,42.77],[176.5,42.77],[173.5,42.77],[172.5,42.77],[171.5,42.77]],[[214.5,19.77],[214.5,20.77],[214.5,22.77],[213.5,25.77],[207.5,35.77],[203.5,39.77],[201.5,43.77],[200.5,43.77],[201.5,43.77],[206.5,43.77],[211.5,43.77],[217.5,44.77],[222.5,44.77],[228.5,44.77],[230.5,44.77]],[[234.5,24.77],[234.5,25.77],[233.5,33.77],[229.5,44.77],[225.5,49.77],[225.5,51.77],[225.5,53.77],[225.5,54.77],[225.5,55.77],[224.5,55.77],[224.5,54.77]]]}",//app4
            
            "{\"lines\":[[[118.5,43.77],[120.5,42.77],[123.5,38.77],[130.5,30.77],[136.5,22.77],[146.5,12.77],[150.5,8.77],[154.5,5.77],[155.5,5.77],[156.5,5.77],[157.5,5.77],[158.5,7.77],[158.5,9.77],[159.5,11.77],[160.5,15.77],[161.5,20.77],[162.5,27.77],[162.5,31.77],[163.5,37.77],[163.5,38.77],[163.5,39.77],[163.5,40.77],[163.5,41.77],[163.5,42.77],[163.5,43.77],[164.5,43.77],[164.5,44.77],[164.5,45.77]],[[146.5,36.77],[148.5,36.77],[151.5,36.77],[158.5,36.77],[164.5,36.77],[171.5,35.77],[191.5,33.77],[204.5,31.77],[219.5,29.77],[221.5,29.77],[220.5,29.77],[216.5,29.77],[214.5,29.77],[212.5,30.77],[211.5,31.77],[211.5,32.77],[212.5,33.77],[216.5,33.77],[220.5,33.77],[226.5,30.77],[228.5,29.77],[228.5,28.77],[227.5,28.77],[225.5,28.77],[224.5,28.77],[224.5,29.77],[224.5,31.77],[227.5,32.77],[230.5,35.77],[232.5,39.77],[234.5,43.77],[235.5,48.77],[235.5,52.77],[235.5,58.77],[230.5,63.77],[229.5,65.77],[227.5,65.77],[224.5,66.77],[222.5,66.77],[220.5,66.77],[219.5,64.77],[219.5,58.77],[226.5,45.77],[233.5,38.77],[243.5,29.77],[246.5,27.77],[250.5,25.77]],[[262.5,14.77],[262.5,17.77],[262.5,21.77],[262.5,27.77],[262.5,31.77],[262.5,38.77],[261.5,42.77],[261.5,44.77],[261.5,45.77]]]}",//agentpages 1
            
            "{\"lines\":[[[105.5,45],[105.5,44],[109.5,39],[119.5,25],[124.5,18],[129.5,8],[131.5,3],[133.5,0],[133.5,-1],[133.5,1],[135.5,5],[136.5,15],[138.5,27],[138.5,42],[138.5,49],[138.5,53],[138.5,56],[139.5,58],[139.5,59],[139.5,60]],[[120.5,30],[121.5,30],[127.5,29],[130.5,29],[133.5,28],[136.5,28],[137.5,28],[138.5,28],[139.5,28],[140.5,27],[141.5,27],[142.5,27],[143.5,27],[144.5,27],[145.5,27],[148.5,26],[150.5,26],[152.5,25],[153.5,24],[154.5,24],[155.5,24],[156.5,24],[157.5,24],[158.5,24],[159.5,24],[160.5,24],[160.5,23],[157.5,23],[154.5,23],[151.5,25],[149.5,26],[149.5,27],[148.5,27],[148.5,28],[149.5,29],[153.5,30],[154.5,30],[155.5,30],[156.5,29],[156.5,26],[156.5,25],[157.5,25],[158.5,26],[160.5,30],[161.5,33],[163.5,37],[164.5,41],[164.5,45],[164.5,47],[164.5,50],[164.5,51],[164.5,52],[162.5,53],[160.5,54],[155.5,55],[154.5,55],[154.5,54],[154.5,51],[154.5,47],[156.5,43],[158.5,41],[158.5,40],[159.5,40],[160.5,40],[161.5,40]],[[217.5,18],[217.5,21],[217.5,23],[217.5,26],[217.5,33],[217.5,37],[218.5,42],[218.5,46],[218.5,50],[218.5,52],[219.5,53],[219.5,54],[219.5,55]],[[199.5,20],[200.5,20],[214.5,16],[224.5,15],[230.5,14],[235.5,14],[236.5,14],[237.5,15],[237.5,22],[237.5,26],[237.5,30],[235.5,34],[229.5,41],[225.5,43],[217.5,47],[214.5,48],[217.5,47],[221.5,46],[224.5,44],[229.5,43],[231.5,43],[233.5,43],[234.5,43],[235.5,43],[235.5,44],[236.5,44],[237.5,47],[238.5,50],[239.5,52],[240.5,56],[241.5,57],[241.5,59],[242.5,59],[242.5,58]],[[248.5,23],[248.5,25],[248.5,29],[249.5,43],[249.5,55],[250.5,63],[250.5,67],[250.5,69],[250.5,68],[250.5,65]],[[249.5,25],[251.5,25],[252.5,26],[253.5,28],[256.5,33],[259.5,37],[261.5,41],[263.5,44],[266.5,46],[268.5,48],[269.5,48],[270.5,48],[270.5,47],[270.5,46],[270.5,43],[270.5,40],[270.5,30],[270.5,25],[270.5,17],[270.5,14],[270.5,9]]]}", 
            //agentpages RN
            "{\"lines\":[[[121.5,13.77],[119.5,15.77],[117.5,17.77],[112.5,23.77],[108.5,27.77],[96.5,37.77],[88.5,43.77],[81.5,52.77],[80.5,53.77],[79.5,54.77]],[[119.5,15.77],[119.5,16.77],[120.5,20.77],[121.5,25.77],[124.5,31.77],[126.5,36.77],[128.5,40.77],[129.5,44.77],[129.5,47.77],[129.5,50.77],[129.5,52.77],[129.5,54.77],[129.5,55.77],[129.5,54.77]],[[106.5,34.77],[108.5,34.77],[114.5,34.77],[121.5,34.77],[138.5,34.77],[161.5,34.77],[169.5,34.77],[170.5,34.77],[170.5,35.77],[170.5,36.77],[170.5,38.77],[170.5,39.77],[170.5,41.77],[170.5,44.77],[170.5,47.77],[170.5,48.77],[170.5,49.77],[170.5,50.77]],[[173.5,26.77],[175.5,26.77],[176.5,26.77],[176.5,27.77],[177.5,28.77],[177.5,29.77],[177.5,30.77],[177.5,31.77],[177.5,32.77],[177.5,33.77],[173.5,35.77],[171.5,35.77],[169.5,36.77],[168.5,36.77],[169.5,36.77]],[[231.5,23.77],[232.5,25.77],[232.5,31.77],[232.5,35.77],[232.5,44.77],[232.5,47.77],[232.5,50.77],[232.5,52.77],[232.5,53.77],[232.5,54.77],[232.5,55.77],[231.5,56.77],[231.5,55.77]],[[229.5,13.77],[234.5,12.77],[239.5,12.77],[244.5,11.77],[247.5,11.77],[248.5,11.77],[249.5,12.77],[249.5,13.77],[249.5,15.77],[249.5,17.77],[249.5,20.77],[249.5,25.77],[249.5,28.77],[249.5,30.77],[246.5,33.77],[242.5,35.77],[238.5,36.77],[233.5,39.77],[232.5,39.77],[237.5,38.77],[245.5,36.77],[253.5,35.77],[255.5,35.77],[256.5,35.77],[258.5,37.77],[258.5,38.77],[258.5,40.77],[258.5,44.77],[258.5,46.77],[258.5,48.77],[258.5,50.77],[258.5,51.77]],[[275.5,20.77],[275.5,21.77],[275.5,23.77],[275.5,28.77],[275.5,35.77],[275.5,43.77],[275.5,46.77],[275.5,50.77],[275.5,52.77],[275.5,53.77],[275.5,52.77]],[[276.5,19.77],[277.5,19.77],[278.5,19.77],[279.5,20.77],[279.5,22.77],[280.5,25.77],[281.5,28.77],[283.5,32.77],[285.5,34.77],[287.5,38.77],[288.5,41.77],[289.5,42.77],[289.5,44.77],[290.5,46.77],[290.5,48.77],[290.5,49.77],[290.5,50.77],[290.5,51.77],[291.5,51.77],[291.5,50.77],[291.5,47.77],[291.5,43.77],[292.5,35.77],[294.5,31.77],[294.5,24.77],[294.5,19.77],[294.5,16.77],[294.5,10.77],[294.5,7.77],[294.5,6.77]]]}", //AppRN
            "{\"lines\":[[[24.5,50],[25.5,50],[28.5,46],[32.5,41],[34.5,39],[36.5,38],[37.5,36],[38.5,36],[38.5,35],[39.5,35],[39.5,34],[40.5,34],[40.5,33],[41.5,32],[42.5,30],[43.5,29],[44.5,27],[45.5,26],[46.5,24],[47.5,23],[48.5,23],[49.5,22],[50.5,21],[51.5,21],[51.5,20],[52.5,20],[53.5,20],[55.5,20],[55.5,19],[57.5,19],[59.5,18],[61.5,18],[62.5,18],[65.5,17],[66.5,17],[68.5,17],[69.5,17],[71.5,17],[72.5,17],[72.5,16],[79.5,16],[82.5,16],[84.5,16],[86.5,16],[89.5,16],[91.5,17],[92.5,17],[93.5,18],[94.5,19],[96.5,19],[97.5,20],[99.5,20],[99.5,21],[100.5,21],[101.5,22],[102.5,23],[103.5,24],[103.5,25],[104.5,25],[104.5,26],[104.5,27],[105.5,27],[106.5,29],[107.5,31],[109.5,32],[109.5,33],[110.5,33],[110.5,34],[110.5,35],[111.5,36],[112.5,37],[112.5,38],[113.5,39],[114.5,40],[114.5,41],[115.5,42],[115.5,43],[116.5,43],[117.5,44],[117.5,45],[118.5,45],[118.5,46],[119.5,46],[119.5,47]],[[74.5,34],[75.5,34],[76.5,34],[77.5,33],[79.5,33],[80.5,33],[83.5,33],[85.5,33],[87.5,33],[91.5,33],[94.5,32],[96.5,32],[97.5,32],[100.5,31],[101.5,31],[106.5,30],[110.5,30],[120.5,30],[125.5,30],[139.5,26],[140.5,26],[141.5,26],[142.5,26],[143.5,26],[144.5,26],[145.5,26],[146.5,26],[147.5,26],[147.5,27],[147.5,28],[148.5,30],[148.5,32],[148.5,35],[148.5,36],[149.5,38],[149.5,42],[149.5,44],[150.5,45],[150.5,46],[150.5,47],[150.5,48]],[[149.5,28],[149.5,25],[150.5,25],[150.5,24],[151.5,23],[151.5,22],[152.5,21],[154.5,20],[154.5,19],[155.5,19],[156.5,19],[157.5,19],[157.5,20],[157.5,21],[157.5,22],[158.5,22],[158.5,23],[158.5,25],[158.5,26],[158.5,27],[158.5,28],[158.5,29],[158.5,30],[158.5,31],[157.5,31],[157.5,32],[157.5,33],[156.5,33],[155.5,33],[155.5,34],[154.5,34],[153.5,34],[152.5,35],[151.5,35]],[[220.5,15],[219.5,15],[215.5,15],[213.5,15],[212.5,16],[210.5,16],[210.5,17],[210.5,18],[210.5,20],[210.5,21],[210.5,23],[210.5,24],[210.5,25],[210.5,26],[213.5,28],[219.5,30],[222.5,30],[224.5,30],[227.5,30],[229.5,29],[230.5,28],[231.5,27],[231.5,26],[229.5,26],[227.5,27],[222.5,29],[220.5,31],[216.5,33],[213.5,34],[211.5,36],[208.5,39],[207.5,40],[207.5,41],[207.5,42],[207.5,43],[207.5,44],[207.5,46],[208.5,47],[209.5,48],[212.5,50],[216.5,51],[222.5,52],[226.5,52],[232.5,52],[236.5,52],[237.5,51],[238.5,50],[239.5,48],[241.5,46],[243.5,43],[244.5,42],[246.5,39],[247.5,38],[248.5,36],[248.5,35],[249.5,35],[250.5,35],[250.5,34],[251.5,34]],[[279.5,16],[279.5,17],[279.5,18],[279.5,19],[279.5,20],[279.5,21],[279.5,23],[278.5,28],[278.5,34],[278.5,38],[278.5,42],[277.5,44],[277.5,45],[277.5,46],[277.5,47],[277.5,48],[277.5,49],[277.5,50],[277.5,48]],[[280.5,19],[281.5,19],[282.5,19],[282.5,18],[284.5,17],[287.5,17],[292.5,15],[295.5,13],[298.5,11],[299.5,9]],[[279.5,38],[281.5,38],[287.5,35],[290.5,33],[292.5,31],[293.5,31],[293.5,30],[294.5,30]],[[317.5,14],[318.5,14],[319.5,14],[321.5,14],[322.5,14],[324.5,14],[325.5,14],[326.5,14],[327.5,14],[328.5,14],[329.5,14],[330.5,14],[331.5,14],[332.5,14],[333.5,14],[335.5,14],[336.5,13],[338.5,13],[339.5,13],[342.5,13],[348.5,13],[354.5,13],[359.5,13],[361.5,13],[363.5,13],[364.5,13],[365.5,13],[367.5,13],[368.5,13],[371.5,13],[374.5,13],[381.5,13],[390.5,13],[397.5,14],[399.5,14],[401.5,14],[402.5,14],[403.5,14],[404.5,14],[405.5,14],[407.5,14],[408.5,14],[410.5,14],[411.5,14],[413.5,14],[419.5,14],[421.5,13],[424.5,13],[425.5,13],[426.5,13],[427.5,12],[428.5,12],[429.5,12],[430.5,12],[431.5,12],[431.5,11],[432.5,11],[433.5,11],[434.5,11]],[[382.5,16],[382.5,17],[382.5,23],[382.5,27],[385.5,39],[385.5,41],[385.5,42],[386.5,43],[386.5,44],[386.5,45],[386.5,46],[386.5,47],[386.5,48],[386.5,49],[386.5,50],[387.5,50],[387.5,51]]]}", //EftSignatureIndTouch
            "{\"lines\":[[[48.5,37],[48.5,36],[50.5,35],[57.5,32],[67.5,27],[80.5,19],[90.5,13],[95.5,10],[98.5,8],[101.5,7],[101.5,6],[101.5,9],[101.5,11],[101.5,14],[100.5,17],[100.5,19],[100.5,21],[101.5,21],[104.5,21],[112.5,19],[116.5,17],[122.5,15],[128.5,13],[132.5,12],[133.5,11],[133.5,12],[133.5,13],[132.5,19],[130.5,22],[128.5,26],[127.5,29],[125.5,32],[124.5,35],[123.5,37],[123.5,38],[123.5,40],[122.5,41],[121.5,43],[121.5,44],[120.5,44],[120.5,45],[120.5,46]],[[150.5,18],[149.5,19],[148.5,22],[145.5,29],[143.5,33],[142.5,35],[142.5,36],[141.5,37],[141.5,38]],[[144.5,21],[145.5,21],[146.5,20],[147.5,19],[151.5,18],[163.5,17],[171.5,15],[172.5,15],[172.5,16],[172.5,17],[171.5,18],[168.5,21],[165.5,23],[163.5,25],[161.5,25],[156.5,26],[155.5,26],[154.5,26],[158.5,26],[160.5,27],[163.5,27],[163.5,28],[165.5,29],[165.5,30],[166.5,31],[166.5,32],[166.5,33],[166.5,34],[166.5,36],[166.5,37],[166.5,38],[166.5,39],[166.5,40],[166.5,42],[165.5,43],[165.5,44],[165.5,45],[164.5,46],[164.5,47],[164.5,48],[163.5,49],[163.5,50]],[[217.5,17],[216.5,17],[215.5,17],[212.5,17],[209.5,18],[205.5,20],[199.5,21],[194.5,23],[193.5,24],[193.5,25],[193.5,27],[193.5,31],[194.5,36],[198.5,40],[201.5,43],[205.5,45],[212.5,47],[215.5,47],[217.5,47],[219.5,45],[220.5,44],[221.5,42],[221.5,41],[221.5,40]],[[246.5,9],[245.5,9],[244.5,9],[242.5,10],[240.5,10],[240.5,11],[240.5,12],[240.5,13],[240.5,14],[240.5,15],[241.5,17],[242.5,18],[243.5,19],[244.5,19],[244.5,20],[245.5,20],[245.5,21],[245.5,23],[245.5,25],[245.5,27],[245.5,29],[245.5,32],[244.5,33],[243.5,35],[242.5,36],[240.5,38],[239.5,38],[238.5,38],[237.5,38],[236.5,37],[235.5,35],[234.5,34],[234.5,32],[234.5,30],[234.5,29],[234.5,28]]]}", // Medical Release Claim Signature
            "{\"lines\":[[[123.5,16],[124.5,15],[125.5,14],[125.5,13],[125.5,12],[125.5,10],[125.5,9],[124.5,9],[123.5,9],[122.5,9],[118.5,12],[115.5,13],[115.5,14],[115.5,15],[115.5,17],[115.5,19],[115.5,22],[115.5,26],[115.5,29],[115.5,31],[115.5,35],[115.5,38],[115.5,40],[111.5,46],[110.5,46],[109.5,46],[107.5,46],[106.5,46],[97.5,45],[92.5,44],[84.5,42],[83.5,42],[83.5,41],[84.5,41],[85.5,39],[90.5,38],[95.5,36],[96.5,36],[98.5,35],[100.5,35],[102.5,35],[103.5,35],[104.5,35],[106.5,35],[107.5,36],[108.5,36],[109.5,36],[110.5,37],[111.5,37],[112.5,37],[113.5,37],[114.5,38],[115.5,38],[117.5,38],[119.5,38],[121.5,38],[122.5,38],[123.5,38],[124.5,38],[124.5,39],[125.5,40],[125.5,41],[125.5,42],[125.5,43],[125.5,44],[125.5,45],[125.5,47],[125.5,48],[125.5,49],[125.5,49],[128.5,49],[131.5,49],[136.5,50],[139.5,51],[141.5,51],[142.5,51],[144.5,51],[145.5,51],[145.5,50],[146.5,50],[146.5,49]],[[180.5,43],[180.5,42],[180.5,41],[180.5,40],[179.5,40],[175.5,40],[171.5,40],[168.5,40],[167.5,40],[167.5,41],[167.5,42],[167.5,44],[167.5,45],[167.5,46],[169.5,47],[171.5,48],[173.5,48],[175.5,48],[176.5,48],[177.5,48],[178.5,48],[179.5,48],[180.5,46],[180.5,45],[181.5,43],[181.5,42],[181.5,41],[181.5,42],[182.5,43],[182.5,45],[182.5,46],[182.5,47],[183.5,48],[184.5,49],[185.5,49],[186.5,49],[186.5,50],[187.5,50],[190.5,50],[190.5,49],[192.5,49],[193.5,48],[194.5,47],[195.5,46],[195.5,45],[196.5,44],[197.5,42],[197.5,41],[198.5,41],[198.5,40],[198.5,39],[199.5,39],[199.5,38],[199.5,37],[199.5,38],[199.5,40],[199.5,42],[199.5,44],[199.5,45],[199.5,46],[199.5,47],[199.5,48],[199.5,49],[199.5,50],[199.5,51],[199.5,52],[199.5,53],[199.5,54],[199.5,55],[199.5,56],[199.5,57],[199.5,55],[200.5,50],[201.5,46],[202.5,42],[202.5,40],[202.5,38],[203.5,37],[203.5,35],[203.5,33],[204.5,32],[204.5,30],[205.5,29],[205.5,28],[207.5,28],[207.5,27],[208.5,27],[209.5,28],[209.5,29],[209.5,30],[209.5,31],[210.5,33],[210.5,34],[210.5,35],[210.5,36],[209.5,36],[209.5,37],[207.5,37],[206.5,38],[204.5,40],[203.5,40],[204.5,40],[205.5,40],[206.5,40],[207.5,40],[208.5,40],[208.5,39],[209.5,39],[210.5,39],[212.5,38],[213.5,37],[214.5,37],[214.5,36],[215.5,36],[215.5,35],[216.5,34],[216.5,33],[217.5,32],[218.5,32],[218.5,35],[218.5,39],[218.5,46],[218.5,50],[218.5,54],[218.5,60],[218.5,63],[218.5,66],[218.5,68],[218.5,65],[218.5,54],[218.5,45],[220.5,32],[221.5,28],[222.5,23],[222.5,22],[222.5,20],[223.5,20],[223.5,19],[224.5,18],[225.5,18],[226.5,18],[226.5,19],[226.5,21],[226.5,23],[226.5,25],[226.5,27],[226.5,30],[226.5,31],[226.5,32],[226.5,34],[226.5,35],[225.5,35],[225.5,36],[224.5,36],[224.5,37],[223.5,37],[223.5,38],[222.5,38],[221.5,38],[220.5,37],[220.5,36],[220.5,37],[221.5,37],[222.5,37],[222.5,38],[223.5,38],[224.5,38],[224.5,39],[225.5,39],[225.5,40],[225.5,41],[226.5,41],[227.5,41],[227.5,42],[228.5,42],[228.5,43],[229.5,43],[230.5,43],[230.5,44],[231.5,44],[233.5,44],[234.5,44],[235.5,44],[236.5,44],[236.5,43],[237.5,42],[237.5,41],[238.5,41]],[[285.5,21],[285.5,22],[285.5,24],[285.5,26],[285.5,30],[285.5,34],[285.5,37],[285.5,38],[285.5,40],[285.5,42],[285.5,43],[285.5,44],[285.5,45],[284.5,46],[284.5,47],[284.5,48],[284.5,49],[283.5,49]]]}",//SupplementalForm applicatnt Sig 1
            
            "{\"lines\":[[[61.5,16],[60.5,16],[58.5,15],[57.5,14],[55.5,14],[55.5,13],[53.5,13],[52.5,13],[52.5,12],[52.5,13],[52.5,14],[52.5,15],[52.5,16],[52.5,17],[52.5,18],[52.5,19],[52.5,20],[52.5,21],[53.5,21],[53.5,22],[54.5,22],[56.5,22],[57.5,22],[58.5,22],[59.5,22],[60.5,22],[61.5,23],[61.5,24],[63.5,25],[63.5,26],[63.5,28],[64.5,29],[64.5,30],[64.5,31],[64.5,32],[64.5,33],[63.5,33],[61.5,34],[60.5,34],[59.5,34],[58.5,34],[57.5,34],[56.5,34],[55.5,34],[54.5,34],[53.5,34],[52.5,34],[51.5,34],[50.5,34],[49.5,34],[49.5,33]],[[75.5,17],[74.5,16],[74.5,17],[73.5,18],[73.5,20],[73.5,23],[73.5,25],[73.5,26],[73.5,27],[73.5,28],[73.5,30],[73.5,31],[73.5,32],[73.5,33],[74.5,34],[75.5,34],[76.5,34],[77.5,34],[78.5,34],[79.5,34]],[[104.5,31],[103.5,25],[103.5,23],[102.5,20],[102.5,19],[102.5,17],[102.5,15],[102.5,13],[102.5,12],[102.5,11],[102.5,10],[102.5,9],[102.5,8],[102.5,7],[103.5,7],[104.5,7],[105.5,7],[106.5,8],[107.5,9],[107.5,10],[108.5,11],[108.5,12],[108.5,13],[109.5,15],[109.5,16],[109.5,17],[109.5,18],[109.5,19],[110.5,20],[110.5,22],[110.5,23],[111.5,24],[111.5,25]],[[107.5,20],[108.5,20],[109.5,20],[110.5,20],[111.5,20]],[[127.5,12],[125.5,12],[124.5,12],[123.5,12],[123.5,13],[123.5,14],[123.5,16],[123.5,17],[123.5,18],[123.5,19],[123.5,20],[123.5,21],[123.5,22],[124.5,22],[125.5,22],[126.5,21],[126.5,20],[126.5,19],[126.5,18],[127.5,19],[127.5,20],[127.5,22],[127.5,26],[127.5,27],[127.5,29],[126.5,31],[126.5,33],[125.5,34],[125.5,35],[124.5,38],[123.5,38],[123.5,39],[120.5,36],[119.5,33],[119.5,31],[119.5,30],[119.5,29],[119.5,28],[119.5,27],[119.5,26]],[[149.5,11],[149.5,12],[149.5,13],[149.5,16],[150.5,21],[151.5,25],[151.5,28],[151.5,31],[151.5,33],[151.5,34]]]}", //AgentSig 1
            "{\"lines\":[[[58.5,38],[59.5,38],[61.5,35],[65.5,31],[69.5,24],[74.5,18],[78.5,12],[81.5,10],[82.5,10],[82.5,11],[82.5,16],[83.5,20],[83.5,26],[84.5,34],[85.5,39],[85.5,40],[85.5,41],[85.5,42]],[[66.5,32],[65.5,32],[68.5,32],[78.5,32],[86.5,33],[93.5,34],[96.5,35],[97.5,35],[98.5,35],[99.5,35],[100.5,35],[99.5,35],[98.5,35],[96.5,35],[94.5,36],[93.5,36],[93.5,37],[93.5,38],[94.5,38],[95.5,38],[96.5,38],[97.5,38],[98.5,38],[99.5,38],[100.5,37],[100.5,36],[100.5,35],[101.5,35],[102.5,36],[103.5,38],[105.5,40],[105.5,42],[106.5,43],[106.5,44],[106.5,45],[106.5,46],[106.5,47],[106.5,48],[105.5,49],[104.5,50],[103.5,50],[102.5,50],[100.5,50],[99.5,50],[99.5,49],[98.5,48],[98.5,47],[98.5,46],[98.5,45],[98.5,44],[99.5,43],[101.5,43],[102.5,43],[103.5,43],[104.5,43],[105.5,43],[107.5,43],[108.5,43],[108.5,44],[108.5,45]],[[16.5,31],[17.5,31],[17.5,30],[18.5,28],[20.5,25],[21.5,20],[24.5,12],[25.5,8],[27.5,5],[28.5,3],[29.5,3],[30.5,4],[30.5,6],[31.5,10],[31.5,13],[31.5,17],[31.5,18],[32.5,21],[32.5,22],[32.5,23],[33.5,23],[33.5,24],[33.5,25],[33.5,26],[33.5,28],[33.5,29],[33.5,26],[35.5,21],[37.5,17],[37.5,14],[38.5,13],[38.5,12],[39.5,12],[40.5,13],[41.5,16],[42.5,18],[42.5,22],[43.5,24],[44.5,26],[45.5,29],[45.5,30],[45.5,29],[44.5,27],[44.5,26],[44.5,24],[44.5,22],[44.5,21],[45.5,19],[47.5,17],[49.5,15],[50.5,14],[51.5,14],[51.5,13],[52.5,13],[53.5,13],[54.5,12],[55.5,12],[56.5,11],[56.5,11],[57.5,11],[58.5,11]]]}", // AR Agent Sig

    "{\"lines\":[[[64.5,11],[63.5,11],[58.5,10],[52.5,10],[43.5,10],[35.5,11],[31.5,11],[30.5,12],[31.5,12],[38.5,13],[48.5,14],[54.5,15],[58.5,15],[59.5,15],[59.5,16],[52.5,20],[33.5,26],[20.5,31],[17.5,32],[15.5,33],[17.5,33],[26.5,33],[48.5,36],[76.5,41],[92.5,43],[98.5,43],[98.5,44]],[[86.5,16],[86.5,17],[86.5,19],[86.5,22],[86.5,26],[85.5,29],[85.5,32],[85.5,33]],[[87.5,15],[88.5,15],[90.5,15],[97.5,16],[106.5,17],[111.5,18],[114.5,19],[115.5,19],[115.5,20],[116.5,22],[117.5,24],[117.5,26],[116.5,29],[114.5,30],[110.5,31],[104.5,32],[98.5,32],[93.5,33],[87.5,33],[86.5,33]],[[140.5,15],[141.5,15],[146.5,14],[162.5,12],[186.5,11],[232.5,9]],[[197.5,14],[197.5,16],[196.5,20],[194.5,27],[192.5,34],[191.5,40],[190.5,44],[190.5,46],[191.5,45],[193.5,44],[196.5,42],[199.5,41],[201.5,39],[204.5,38],[206.5,38],[207.5,38],[210.5,38],[211.5,38],[213.5,38],[214.5,38],[215.5,38],[215.5,37],[215.5,36],[215.5,35],[214.5,35],[213.5,35],[212.5,36],[211.5,37],[211.5,38],[210.5,38],[210.5,39],[210.5,40],[211.5,41],[211.5,42],[211.5,43],[212.5,43],[212.5,44],[213.5,44],[213.5,45],[215.5,46],[216.5,46],[218.5,47],[221.5,47],[223.5,48],[227.5,48],[228.5,48],[230.5,48],[232.5,48],[234.5,46],[236.5,45],[236.5,44],[237.5,43],[237.5,42],[237.5,41],[237.5,40],[237.5,39],[237.5,38],[237.5,37],[238.5,37],[238.5,38],[239.5,39],[239.5,40],[239.5,42],[240.5,43],[241.5,45],[241.5,46],[241.5,47],[241.5,48],[241.5,47],[241.5,43],[243.5,42],[244.5,41],[246.5,41],[247.5,41],[247.5,40],[248.5,40],[249.5,40],[250.5,40],[251.5,40],[252.5,40],[253.5,40],[254.5,40],[255.5,40],[256.5,40],[257.5,39],[258.5,39],[259.5,39],[260.5,39],[261.5,39],[262.5,39],[263.5,38],[264.5,38],[264.5,39],[264.5,40],[264.5,42],[264.5,43],[264.5,45],[264.5,47],[264.5,48],[264.5,49],[264.5,48],[264.5,45],[268.5,42],[270.5,40],[272.5,39],[274.5,38],[275.5,39],[276.5,40],[277.5,41],[277.5,42],[277.5,43],[278.5,43],[279.5,43],[280.5,42],[281.5,41],[282.5,40],[284.5,40],[285.5,40],[285.5,39],[285.5,40],[286.5,41],[286.5,42],[286.5,43],[286.5,44],[285.5,45],[285.5,46],[285.5,47],[285.5,48],[286.5,48],[288.5,48],[291.5,47],[294.5,46],[298.5,45],[300.5,45],[301.5,44],[302.5,44],[302.5,43],[303.5,42],[304.5,41],[304.5,40],[305.5,38],[306.5,38],[305.5,38],[304.5,39],[304.5,40],[305.5,40],[305.5,41],[305.5,42],[305.5,43],[305.5,44],[305.5,45],[305.5,46],[305.5,47],[306.5,48],[306.5,49],[306.5,50],[306.5,51],[305.5,51],[304.5,51],[303.5,51],[302.5,51],[302.5,50],[302.5,49],[303.5,49],[303.5,48],[304.5,48],[305.5,47],[308.5,46],[309.5,46],[310.5,46],[311.5,46],[313.5,46],[317.5,46],[322.5,46],[333.5,44],[339.5,44],[344.5,42],[350.5,41],[351.5,40],[352.5,40],[353.5,40]]]}",// Electronic Delivery Terms Sig
            
            "{\"lines\":[[[56.5,16],[56.5,17],[55.5,19],[54.5,22],[52.5,28],[50.5,35],[45.5,46],[44.5,51],[43.5,54],[43.5,56]],[[74.5,17],[74.5,18],[74.5,20],[74.5,22],[72.5,25],[70.5,29],[66.5,35],[64.5,40],[61.5,44],[60.5,46],[60.5,47],[59.5,48],[60.5,48],[62.5,48],[63.5,48],[68.5,48],[72.5,48],[75.5,48],[79.5,48],[80.5,48],[81.5,48],[82.5,48],[83.5,48],[83.5,47]],[[96.5,24],[97.5,24],[99.5,23],[101.5,22],[104.5,22],[105.5,22],[106.5,22],[106.5,23],[106.5,24],[106.5,27],[107.5,29],[107.5,32],[107.5,36],[105.5,37],[102.5,39],[100.5,40],[97.5,40],[94.5,41],[93.5,41],[92.5,41],[91.5,41],[90.5,41],[90.5,40],[92.5,40],[93.5,40],[98.5,40],[101.5,40],[104.5,40],[105.5,40],[106.5,40],[107.5,41],[108.5,41],[108.5,42],[109.5,42],[109.5,43],[110.5,43],[111.5,45]],[[114.5,25],[116.5,24],[118.5,22],[122.5,21],[128.5,20],[131.5,20],[132.5,20],[132.5,21],[131.5,23],[129.5,25],[126.5,26],[125.5,28],[123.5,28],[122.5,29],[123.5,29],[126.5,29],[127.5,29],[128.5,29],[130.5,31],[130.5,33],[131.5,36],[131.5,38],[128.5,42],[127.5,44],[124.5,45],[122.5,46],[121.5,46],[119.5,46],[117.5,46],[116.5,46],[115.5,46],[115.5,45]],[[153.5,27],[153.5,26],[152.5,26],[152.5,25],[152.5,24],[151.5,24],[150.5,24],[149.5,24],[148.5,24],[147.5,24],[145.5,25],[144.5,26],[143.5,27],[142.5,29],[141.5,30],[140.5,32],[140.5,33],[140.5,34],[141.5,34],[142.5,34],[144.5,34],[145.5,34],[150.5,30],[151.5,29],[151.5,30],[151.5,32],[150.5,34],[148.5,38],[145.5,42],[142.5,46],[139.5,48],[138.5,49],[138.5,50]],[[171.5,30],[171.5,29],[170.5,29],[169.5,28],[168.5,28],[167.5,27],[166.5,27],[165.5,26],[164.5,26],[161.5,26],[159.5,27],[158.5,28],[157.5,30],[157.5,31],[157.5,33],[158.5,33],[162.5,33],[164.5,33],[165.5,33],[166.5,32],[167.5,31],[168.5,31],[169.5,30],[170.5,30],[170.5,31],[170.5,32],[168.5,35],[166.5,38],[165.5,39],[163.5,41],[162.5,43],[162.5,44],[161.5,44],[160.5,44],[160.5,45],[159.5,45],[159.5,46]],[[186.5,31],[185.5,32],[183.5,34],[181.5,37],[177.5,44],[176.5,47],[176.5,49],[175.5,50]],[[206.5,24],[207.5,24],[211.5,25],[215.5,26],[220.5,26],[225.5,26],[231.5,26],[237.5,26],[242.5,26],[245.5,25],[246.5,25]],[[228.5,27],[228.5,28],[228.5,29],[227.5,32],[226.5,37],[224.5,42],[222.5,48],[220.5,50],[220.5,52],[219.5,52]],[[242.5,43],[243.5,43],[243.5,44],[243.5,45],[243.5,46],[243.5,47],[243.5,48],[244.5,48],[246.5,49],[247.5,49],[248.5,49],[249.5,49],[250.5,46],[250.5,45],[250.5,44],[250.5,43],[249.5,43],[248.5,43],[247.5,43],[246.5,43],[246.5,44],[245.5,44],[245.5,45],[246.5,45],[247.5,45],[248.5,45],[249.5,45],[250.5,45]],[[258.5,45],[258.5,46],[258.5,47],[258.5,48],[259.5,48],[259.5,49],[260.5,49],[261.5,49],[264.5,49],[268.5,47],[269.5,46],[270.5,44],[271.5,42],[272.5,41],[272.5,40],[273.5,40],[273.5,41],[274.5,41],[275.5,41],[276.5,42],[279.5,43],[281.5,43],[282.5,43],[283.5,43],[283.5,42],[283.5,41],[282.5,41],[279.5,41],[278.5,42],[277.5,43],[277.5,44],[276.5,45],[276.5,46],[276.5,48],[276.5,49],[277.5,50],[281.5,50],[292.5,52],[305.5,52],[313.5,52],[316.5,52],[317.5,52],[317.5,51],[318.5,49],[318.5,46],[319.5,37],[320.5,29],[320.5,23],[321.5,15],[321.5,10],[321.5,7],[321.5,6],[321.5,7],[321.5,8],[320.5,10],[319.5,17],[318.5,24],[316.5,34],[316.5,47],[316.5,52],[317.5,54],[317.5,56],[317.5,57],[318.5,56],[318.5,55],[319.5,53],[320.5,51],[321.5,47],[324.5,44],[327.5,41],[329.5,40],[330.5,40],[331.5,40],[332.5,40],[333.5,40],[335.5,43],[338.5,47],[341.5,51],[343.5,55],[343.5,57],[344.5,59]]]}",//IL 23991 Supp Form sig

            "{\"lines\":[[[74.5,9],[74.5,10],[73.5,14],[71.5,18],[68.5,25],[65.5,33],[61.5,46],[60.5,51],[59.5,54],[58.5,56],[58.5,57],[58.5,58]],[[72.5,48],[71.5,48],[71.5,49],[70.5,49],[70.5,48],[71.5,46],[72.5,44],[75.5,41],[77.5,39],[78.5,38],[79.5,38],[79.5,40],[79.5,43],[79.5,45],[79.5,47],[78.5,48],[78.5,49],[79.5,48],[81.5,47],[87.5,43],[89.5,41],[90.5,39],[91.5,38],[91.5,39],[90.5,39],[90.5,40],[90.5,41],[90.5,42],[91.5,43],[92.5,45],[93.5,46],[93.5,48],[92.5,48],[90.5,48],[88.5,48],[86.5,48],[85.5,48],[85.5,47],[86.5,46],[90.5,45],[94.5,44],[96.5,44],[99.5,44],[100.5,43],[101.5,43],[101.5,44],[101.5,45],[101.5,46],[102.5,48],[103.5,48],[104.5,48],[105.5,48],[107.5,47],[108.5,46],[109.5,45],[111.5,43],[112.5,43],[112.5,45],[113.5,47],[113.5,49],[116.5,51],[117.5,52],[118.5,52],[119.5,51],[120.5,51],[122.5,49],[123.5,48],[125.5,47],[125.5,46],[125.5,45],[126.5,44],[127.5,44],[128.5,44],[129.5,44],[130.5,44],[130.5,45],[131.5,46],[131.5,47],[131.5,48],[130.5,48],[131.5,48],[134.5,48],[135.5,48],[137.5,47],[138.5,46],[138.5,45],[138.5,44],[139.5,44],[140.5,45],[140.5,46],[140.5,47],[140.5,48],[141.5,48],[142.5,47],[143.5,46],[145.5,45],[146.5,45],[148.5,45],[149.5,45],[150.5,45],[150.5,46],[151.5,47],[151.5,48],[153.5,48],[154.5,49],[154.5,50],[155.5,50],[156.5,49],[157.5,48],[159.5,47],[160.5,46],[161.5,45],[162.5,45],[163.5,45],[163.5,46],[164.5,46],[165.5,46],[172.5,46],[188.5,47],[196.5,47],[198.5,47],[198.5,46],[198.5,44],[197.5,43],[196.5,43],[195.5,42],[193.5,42],[191.5,42],[186.5,45],[183.5,46],[182.5,48],[181.5,49],[180.5,50],[181.5,50],[185.5,50],[191.5,50],[203.5,48],[217.5,47],[225.5,46],[226.5,46]],[[257.5,22],[258.5,22],[258.5,25],[258.5,29],[258.5,35],[258.5,40],[258.5,43],[258.5,46],[258.5,48],[258.5,49],[258.5,50],[257.5,51],[257.5,52],[256.5,52]],[[251.5,12],[252.5,12],[255.5,12],[259.5,12],[263.5,12],[267.5,14],[269.5,15],[271.5,17],[272.5,19],[272.5,21],[272.5,22],[272.5,23],[270.5,24],[266.5,27],[260.5,29],[257.5,30],[255.5,32],[254.5,33],[255.5,33],[257.5,33],[260.5,35],[261.5,37],[263.5,39],[264.5,42],[264.5,44],[264.5,45],[263.5,45],[262.5,44],[262.5,42],[264.5,39],[267.5,37],[270.5,35],[273.5,34],[274.5,34],[275.5,34],[275.5,35],[275.5,36],[275.5,37],[274.5,37],[274.5,38],[274.5,39],[274.5,40],[275.5,40],[276.5,40],[277.5,40],[277.5,41],[278.5,41],[279.5,41],[280.5,41],[281.5,41],[282.5,41],[283.5,41],[284.5,41],[284.5,40],[285.5,40],[285.5,39],[286.5,39],[286.5,38],[286.5,37],[286.5,38],[285.5,38],[284.5,40],[283.5,41],[282.5,42],[282.5,43],[282.5,44],[283.5,44],[284.5,44],[287.5,43],[288.5,41],[289.5,39],[289.5,38],[288.5,38],[288.5,39],[289.5,39],[292.5,39],[297.5,39],[300.5,39],[302.5,39],[302.5,38],[301.5,37],[300.5,37],[297.5,37],[295.5,37],[293.5,37],[292.5,37],[291.5,38],[291.5,39],[291.5,40],[292.5,40],[294.5,40],[296.5,40],[299.5,38],[301.5,36],[303.5,32],[306.5,26],[308.5,21],[309.5,19],[309.5,18],[309.5,20],[308.5,24],[305.5,29],[302.5,34],[300.5,39],[298.5,42],[297.5,44],[297.5,45],[298.5,44],[302.5,42],[305.5,40],[307.5,37],[309.5,35],[310.5,34],[310.5,35],[311.5,36],[311.5,37],[311.5,38],[312.5,38],[313.5,38],[315.5,36],[316.5,36],[316.5,35],[317.5,35],[317.5,36],[319.5,36],[323.5,38],[328.5,39],[331.5,39],[333.5,39],[334.5,39],[335.5,39],[335.5,38],[335.5,37],[335.5,36],[335.5,35],[335.5,34],[334.5,34],[333.5,33],[332.5,33],[331.5,33],[330.5,33],[328.5,33],[327.5,34],[326.5,36],[324.5,37],[324.5,39],[324.5,40],[325.5,40],[326.5,40],[328.5,40],[330.5,40],[334.5,39],[335.5,37],[337.5,36],[338.5,34],[339.5,34],[339.5,33],[340.5,33],[340.5,37],[340.5,39],[342.5,41],[350.5,47],[353.5,50],[353.5,49],[354.5,46],[355.5,43],[356.5,42],[356.5,40],[357.5,39],[357.5,38],[358.5,38],[360.5,38],[365.5,38],[370.5,38],[381.5,35],[393.5,32],[395.5,31]]]}" //Insurance Producer 23993 Sig
            
    };
}
