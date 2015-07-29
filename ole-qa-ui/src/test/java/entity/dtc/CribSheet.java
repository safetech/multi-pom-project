package entity.dtc;

import com.github.javafaker.Faker;
import util.DateUtils;

public class CribSheet {

    private Faker faker;

    public Faker getFaker() {
        return faker;
    }

    public String getPreset_select() {
        return preset_select;
    }

    public void setPreset_select(String preset_select) {
        this.preset_select = preset_select;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAarpMemid() {
        return aarpMemid;
    }

    public void setAarpMemid(String aarpMemid) {
        this.aarpMemid = aarpMemid;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEffDate() {
        return effDate;
    }

    public void setEffDate(String effDate) {
        this.effDate = effDate;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getMarketability_code() {
        return marketability_code;
    }

    public void setMarketability_code(String marketability_code) {
        this.marketability_code = marketability_code;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getHASHID() {
        return HASHID;
    }

    public void setHASHID(String HASHID) {
        this.HASHID = HASHID;
    }

    public String getWT_mc_id() {
        return WT_mc_id;
    }

    public void setWT_mc_id(String WT_mc_id) {
        this.WT_mc_id = WT_mc_id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getLog_level() {
        return log_level;
    }

    public void setLog_level(String log_level) {
        this.log_level = log_level;
    }

    private String preset_select = "";
    private String state = "";
    private String zip = "";
    private String aarpMemid = "";
    private String DOB = "";
    private String effDate = "";
    private String psd = "";
    private String planCode = "";
    private String marketability_code = "";
    private String referrer = "";
    private String returnURL = "";
    private String HASHID = "";
    private String WT_mc_id = "";
    private String applicationId = "";
    private String readonly = "";
    private String resume = "";
    private String log_level = "";
    private String AgentId = "";
    private String AgentMedSuppStates = "";


    public String getAgentId() {
        return AgentId;
    }

    public void setAgentId(String agentId) {
        AgentId = agentId;
    }

    public String getAgentMedSuppStates() {
        return AgentMedSuppStates;
    }

    public void setAgentMedSuppStates(String agentMedSuppStates) {
        AgentMedSuppStates = agentMedSuppStates;
    }



    public void setStateZip(String state, String zip) {
        this.setState(state);
        this.setZip(zip);
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    public CribSheet() {}
    public CribSheet(Faker faker) {
        this.setFaker(faker);
    }

    public void setDpsdToFirstDayOfFutureMonth(int numOfMonths) {
        this.setPsd(DateUtils.convertDate(DateUtils.getFirstDayOfFutureMonth(numOfMonths), DateUtils.COMPAS_DATE_FORMAT));
    }


}
