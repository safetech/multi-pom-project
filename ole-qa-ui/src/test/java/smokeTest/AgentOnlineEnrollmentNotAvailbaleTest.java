package smokeTest;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.agent.CribSheet;
import functionalTests.CQBaseIntegrationTest;
import resources.pages.agentPages.oldOlePages.CheckEligibilityAndAvailabilityPage;
import resources.pages.agentPages.uwExpansionPages.CheatPage;
import resources.pages.agentPages.uwExpansionPages.PlanSelectionPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.utils.DateUtils;

public class AgentOnlineEnrollmentNotAvailbaleTest extends CQBaseIntegrationTest{

    @Page CheatPage cheatPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;

    private Faker faker;
    private CribSheet sheet;


    @Before
    public void setup() {
        faker = new Faker();
        sheet = new CribSheet(faker);
        app = new Application();

    }

    @Test
    public void AgentAmericanSamoaNotAvailableTest() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[AS| GU| MH| VI]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("AS");
        app.setZipCode("96799");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(0));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("M14M43AGMMCA02_01D");
    }
    @Test
    public void AgentGuamNotAvailableTest() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[AS| GU| MH| VI]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("GU");
        app.setZipCode("96910");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(0));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("M14M43AGMMCA02_01D");
    }
    @Test
    public void AgentMarshalIslandsNotAvailableTest() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[AS| GU| MH| VI| PR]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("MH");
        app.setZipCode("96950");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(0));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("M14M43AGMMCA02_01D");
    }
    @Test
    public void AgentVirginIslandsNotAvailableTest() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[AS| GU| MH| VI]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("VI");
        app.setZipCode("00801");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(0));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("M14M43AGMMCA02_01D");
        checkEligibilityAndAvailabilityPage.isNotAuthorizedToSell();
    }

    @Test
    public void AgentPuertoRicoNotAvailableTest() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[AS| GU| MH| VI| PR]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail(this.faker.letterify("??????????")+"@"+this.faker.letterify("gmail")+".com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");
        app.setState("PR");
        app.setZipCode("00901");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(65));
        app.setMPBED(DateUtils.getFirstDayOfPastOrFutureMonths(0));
        app.setMPAED(DateUtils.getFirstDayOfPastOrFutureMonths(0));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("M14M43AGMMCA02_01D");
        checkEligibilityAndAvailabilityPage.isNotAuthorizedToSell();
    }
}
