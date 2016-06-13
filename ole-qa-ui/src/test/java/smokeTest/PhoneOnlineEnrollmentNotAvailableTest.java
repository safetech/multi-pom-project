package smokeTest;

import com.github.javafaker.Faker;
import resources.entity.phone.CribSheet;
import resources.entity.Application;
import resources.pages.phonepages.uwExpansionPages.CheatPage;
import resources.pages.phonepages.uwExpansionPages.CustomerInformationPage;
import resources.pages.phonepages.uwExpansionPages.VoiceSignatureInstructionsPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.utils.DateUtils;
import functionalAndIntegrationTests.CQBaseIntegrationTest;

public class PhoneOnlineEnrollmentNotAvailableTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public VoiceSignatureInstructionsPage voiceSignatureInstructionsPage;
    @Page public CustomerInformationPage customerInformationPage;
    private CribSheet sheet;
    public Application app;
    private Faker faker;

    @Before
    public void setup(){
        faker = new Faker();

        sheet = new CribSheet(faker);
            sheet.setRandomNameGenderAndMembershipNumber();
            sheet.setRandomContactInfo();
            sheet.setRandomCallCenterInfo();
            sheet.setDpsdToFirstDayOfFutureMonth(1);
            sheet.setPlanCode("F01");

        app = new Application();

    }
    @Test
    public void PhoneAmericanSamoaNotAvailableTest() throws Exception {
        //sheet.setRandomAddress("", "");
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setDpsdToFirstDayOfFutureMonth(3);

        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.checkMarketabilityCode("M14M43AGMMCA02_01D");

    }
    @Test
    public void PhoneGuamNotAvailableTest() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setDpsdToFirstDayOfFutureMonth(3);
        sheet.setRandomAddress("GU", "96910");

        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.checkMarketabilityCode("M14M43AGMMCA02_01D");

    }
    @Test
    public void PhoneMarshalIslandsNotAvailableTest() throws Exception {

        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setDpsdToFirstDayOfFutureMonth(3);
        sheet.setRandomAddress("GU", "96910");

        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.checkMarketabilityCode("M14M43AGMMCA02_01D");

    }
    @Test
    public void PhoneVirginIslandsNotAvailableTest() throws Exception {
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setDpsdToFirstDayOfFutureMonth(3);
        sheet.setState("VI");
        sheet.setZip("00801");
        app.setFirstName(faker.letterify("?????????"));

        startApp(cheatPage, app, sheet);
        voiceSignatureInstructionsPage.checkMarketabilityCode("M14M43AGMMCA02_01D");

    }
}
