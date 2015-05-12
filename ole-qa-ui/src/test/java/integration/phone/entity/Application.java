package integration.phone.entity;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class Application {

    public String getAARPMembershipNumber() {
        return AARPMembershipNumber;
    }

    public void setAARPMembershipNumber(String AARPMembershipNumber) {
        this.AARPMembershipNumber = AARPMembershipNumber;
    }

    private String AARPMembershipNumber = "";
    private String MedicareClaimNum = "";
    private String MPAED = "";
    private String MPBED = "";
    private String PartABActiveIndicator = "";
    private String Turned65In6GA = "";
    private String PartBIn6GA = "";
    private String PlanEffIn6OfEligible = "";
    private String LostCoverage = "";
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

    public String getHCSGApplicationId() {
        return HCSGApplicationId;
    }

    public void setHCSGApplicationId(String HCSGApplicationId) {
        this.HCSGApplicationId = HCSGApplicationId;
    }

    private String HCSGApplicationId = "";

    public Application() { }

    public Application(CribSheet sheet) {
        setAARPMembershipNumber(sheet.getMembershipNumber());
        setHCSGApplicationId(sheet.getHcsgApplicationId());
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
}
