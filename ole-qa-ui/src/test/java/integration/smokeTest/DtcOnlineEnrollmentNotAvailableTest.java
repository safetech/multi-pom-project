package integration.smokeTest;

import com.github.javafaker.Faker;
import entity.dtc.CribSheet;
import integration.CQBaseIntegrationTest;
import integration.dtc.dtcPages.uwExpansionPages.serviceNotAvailablePage;
import integration.dtc.dtcPages.uwExpansionPages.CheatPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;


public class DtcOnlineEnrollmentNotAvailableTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public serviceNotAvailablePage ServiceNotAvailablePage;

    private Faker faker;
    protected CribSheet sheet;

    @Before
    public void setup() {
                faker = new Faker();
        sheet = new CribSheet(faker);
    }

    @Test
    public void DtcAmericanSamoaNotAvailableTest() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(-7));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");
        sheet.setState("AS");
        sheet.setZip("96799");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        ServiceNotAvailablePage.isAt();

    }
    @Test
    public void DtcGuamNotAvailableTest() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");
        sheet.setState("GU");
        sheet.setZip("96910");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        ServiceNotAvailablePage.isAt();
    }
    @Test
    public void DtcMarshalIslandsNotAvailableTest() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");
        sheet.setState("MH");
        sheet.setZip("96950");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        ServiceNotAvailablePage.isAt();
    }
    @Test
    public void DtcVirginIslandsNotAvailableTest() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");
        sheet.setState("VI");
        sheet.setZip("00801");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        ServiceNotAvailablePage.isAt();
    }
    @Test
    public void DtcPuertoRicoNotAvailableTest() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(65));
        sheet.setEffDate(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        sheet.setPsd(DateUtils.getFirstDayOfPastOrFutureMonths(3));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");
        sheet.setState("PR");
        sheet.setZip("00901");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        ServiceNotAvailablePage.isAt();
    }
}
