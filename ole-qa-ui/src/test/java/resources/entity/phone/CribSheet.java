package resources.entity.phone;

import com.github.javafaker.Faker;
import resources.utils.DateUtils;
import java.util.Random;

import static resources.utils.AnswerUtils.BLANK;
import static resources.utils.DateUtils.randBetween;

public class CribSheet{

    private Faker faker;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

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

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
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

    public String getQrIndicator() {
        return qrIndicator;
    }

    public void setQrIndicator(String qrIndicator) {
        this.qrIndicator = qrIndicator;
    }

    private String prefix = "";
    private String firstName = "";
    private String middleInitial = "";
    private String lastName = "";
    private String suffix = "";
    private String addressLine1 = "";
    private String addressLine2 = "";
    private String city = "";
    private String state = "";
    private String zip = "";
    private String membershipNumber = "";
    private String dateOfBirth = "";
    private String gender = "";
    private String dayPhone = "";
    private String eveningPhone = "";
    private String email = "";
    private String medPartBdate = "";
    private String planCode = "";
    private String dpsd = "";
    private String hcsgApplicationId = "";
    private String sourceCode = "";
    private String agentFullName = "";
    private String qrIndicator = "N";
    private String RiderChoice1 = "";
    private String RiderChoice2 = "";
    private String RiderChoice3 = "";
    private String RiderChoice4 = "";
    private String RiderChoice5 = "";
    public String navigateTo = "";
    public String GRSId = "";

    public String getGRSId() {
        return GRSId;
    }

    public void setGRSId(String GRSId) {
        this.GRSId = GRSId;
    }

    public String getNavigateTo() {
        return navigateTo;
    }

    public void setNavigateTo(String navigateTo) {
        this.navigateTo = navigateTo;
    }
    public Faker getFaker() {
        return faker;
    }

    public String getRiderChoice1() {
        return RiderChoice1;
    }

    public void setRiderChoice1(String riderChoice1) {
        RiderChoice1 = riderChoice1;
    }

    public String getRiderChoice2() {
        return RiderChoice2;
    }

    public void setRiderChoice2(String riderChoice2) {
        RiderChoice2 = riderChoice2;
    }

    public String getRiderChoice3() {
        return RiderChoice3;
    }

    public void setRiderChoice3(String riderChoice3) {
        RiderChoice3 = riderChoice3;
    }

    public String getRiderChoice4() {
        return RiderChoice4;
    }

    public void setRiderChoice4(String riderChoice4) {
        RiderChoice4 = riderChoice4;
    }

    public String getRiderChoice5() {
        return RiderChoice5;
    }

    public void setRiderChoice5(String riderChoice5) {
        RiderChoice5 = riderChoice5;
    }

    public void setRandomNameGenderAndMembershipNumber() {
        this.setPrefix(this.getRandomPrefix());
        this.setFirstName(this.faker.firstName());
        this.setMiddleInitial(this.faker.letterify("?"));
        this.setLastName(this.faker.lastName());
        this.setSuffix(this.getRandomSuffix());
        this.setGender(this.getRandomGender());
        this.setMembershipNumber(BLANK);//faker.numerify("#########")
    }


    private String getRandomGender() {
        return this.getRandomItemInArray(ALL_GENDERS);
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

    private String getRandomItemInArray(String[] array){
        Random rand = new Random();
        int randomIndex = randBetween(0, array.length - 1);
        return array[randomIndex];
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
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

    public CribSheet() {}
    public CribSheet(Faker faker) {
        this.setFaker(faker);
    }

    public void setDpsdToFirstDayOfFutureMonth(int numOfMonths) {
        this.setDpsd(DateUtils.convertDate(DateUtils.getFirstDayOfFutureMonth(numOfMonths), DateUtils.COMPAS_DATE_FORMAT));
    }


}
