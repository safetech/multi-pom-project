package entity.agent;

import com.github.javafaker.Faker;
import util.DateUtils;
import java.util.Random;

import static util.DateUtils.randBetween;

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
    private String AgentCertificationYears = "";
    private String SiteId = "";
    private String AgentNPN = "";
    private String AgentName = "";
    private String AgentEmail = "";
    private String AgentPartyId = "";
    private String CloakedInd = "";
    private String prefix = "";
    private String firstName = "";
    private String middleInitial = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayPhone() {
        return dayPhone;
    }

    public void setDayPhone(String dayPhone) {
        this.dayPhone = dayPhone;
    }

    public String getEveningPhone() {
        return eveningPhone;
    }

    public void setEveningPhone(String eveningPhone) {
        this.eveningPhone = eveningPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMedPartBdate() {
        return medPartBdate;
    }

    public void setMedPartBdate(String medPartBdate) {
        this.medPartBdate = medPartBdate;
    }

    public String getDpsd() {
        return dpsd;
    }

    public void setDpsd(String dpsd) {
        this.dpsd = dpsd;
    }

    public String getHcsgApplicationId() {
        return hcsgApplicationId;
    }

    public void setHcsgApplicationId(String hcsgApplicationId) {
        this.hcsgApplicationId = hcsgApplicationId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getAgentFullName() {
        return agentFullName;
    }

    public void setAgentFullName(String agentFullName) {
        this.agentFullName = agentFullName;
    }

    public static String[] getAllGenders() {
        return ALL_GENDERS;
    }

    public static void setAllGenders(String[] allGenders) {
        ALL_GENDERS = allGenders;
    }

    public static String[] getAllPrefixes() {
        return ALL_PREFIXES;
    }

    public static void setAllPrefixes(String[] allPrefixes) {
        ALL_PREFIXES = allPrefixes;
    }

    public static String[] getAllSuffixes() {
        return ALL_SUFFIXES;
    }

    public static void setAllSuffixes(String[] allSuffixes) {
        ALL_SUFFIXES = allSuffixes;
    }

    public static String[] getAllCities() {
        return ALL_CITIES;
    }

    public static void setAllCities(String[] allCities) {
        ALL_CITIES = allCities;
    }

    private String lastName = "";
    private String suffix = "";
    private String addressLine1 = "";
    private String addressLine2 = "";
    private String city = "";
    private String membershipNumber = "";
    private String dateOfBirth = "";
    private String gender = "";
    private String dayPhone = "";
    private String eveningPhone = "";
    private String email = "";
    private String medPartBdate = "";
    private String dpsd = "";
    private String hcsgApplicationId = "";
    private String sourceCode = "";
    private String agentFullName = "";

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

    public String getAgentCertificationYears() {
        return AgentCertificationYears;
    }

    public void setAgentCertificationYears(String agentCertificationYears) {
        AgentCertificationYears = agentCertificationYears;
    }
    private String getRandomGender() {
        return this.getRandomItemInArray(ALL_GENDERS);
    }

    public String getSiteId() {
        return SiteId;
    }

    public void setSiteId(String siteId) {
        SiteId = siteId;
    }

    public String getAgentNPN() {
        return AgentNPN;
    }

    public void setAgentNPN(String agentNPN) {
        AgentNPN = agentNPN;
    }

    public String getAgentName() {
        return AgentName;
    }

    public void setAgentName(String agentName) {
        AgentName = agentName;
    }

    public String getAgentEmail() {
        return AgentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        AgentEmail = agentEmail;
    }

    public String getAgentPartyId() {
        return AgentPartyId;
    }

    public void setAgentPartyId(String agentPartyId) {
        AgentPartyId = agentPartyId;
    }

    public String getCloakedInd() {
        return CloakedInd;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setCloakedInd(String cloakedInd) {
        CloakedInd = cloakedInd;
    }
    private String getRandomItemInArray(String[] array){
        Random rand = new Random();
        int randomIndex = randBetween(0, array.length - 1);
        return array[randomIndex];
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


    public void setRandomNameGenderAndMembershipNumber() {
        this.setPrefix(this.getRandomPrefix());
        this.setFirstName(this.faker.firstName());
        this.setMiddleInitial(this.faker.letterify("?"));
        this.setLastName(this.faker.lastName());
        this.setSuffix(this.getRandomSuffix());
        this.setGender(this.getRandomGender());
        this.setMembershipNumber(faker.numerify("#########"));
    }

    public void setRandomAddress(String state, String zip) {
        this.setAddressLine1(faker.streetAddress(false));
        this.setAddressLine2(faker.secondaryAddress());
        this.setCity(this.getRandomCity());
        this.setState(state);
        this.setZip(zip);
    }

    public void setRandomContactInfo() {
        this.setDayPhone(faker.numerify("##########"));
        this.setEveningPhone(faker.numerify("##########"));
        this.setEmail(String.format("%s.%s@testmail.com", faker.letterify("????"), faker.letterify("????")));
    }

    public void setRandomCallCenterInfo() {
        this.setSourceCode(faker.bothify("???"));
        this.setHcsgApplicationId(faker.bothify("#-???????").toUpperCase());
        this.setAgentFullName(String.format("%s %s %s", faker.firstName(), faker.firstName(), faker.lastName()));
    }

    public static String[] ALL_GENDERS = {"M", "F", "U"};
    public static String[] ALL_PREFIXES = {"", "Dr", "Miss", "Mr", "Mrs", "Ms"};
    public static String[] ALL_SUFFIXES = {"", "I", "II", "III", "IV", "Jr", "Sr"};
    public static String[] ALL_CITIES = {"Horsham", "Upper Dublin", "New York", "Dallas", "Palm Beach", "Allentown", "Pheonix", "Los Angeles", "San Diego", "Detroit", "Paris", "Ambler", "Orlando", "St Louis", "Toronto", "Feasterville", "State College", "Pittsburgh", "Canton"};

    public String getRandomPrefix() {
        return this.getRandomItemInArray(ALL_PREFIXES);
    }

    public String getRandomSuffix() {
        return this.getRandomItemInArray(ALL_SUFFIXES);
    }

    public String getRandomCity() {
        return this.getRandomItemInArray(ALL_CITIES);
    }
}
