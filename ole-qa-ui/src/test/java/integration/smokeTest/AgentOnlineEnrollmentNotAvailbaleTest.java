package integration.smokeTest;

import com.github.javafaker.Faker;
import entity.Application;
import entity.agent.CribSheet;
import integration.CQBaseIntegrationTest;
import integration.agent.agentPages.oldOlePages.CheckEligibilityAndAvailabilityPage;
import integration.agent.agentPages.uwExpansionPages.CheatPage;
import integration.agent.agentPages.uwExpansionPages.PlanSelectionPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

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
    public void PhoneAmericanSamoaNotAvailableTest() throws Exception {

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

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.checkMarketabilityCode("M14M43AGMMCA02_01D");

    }
}
