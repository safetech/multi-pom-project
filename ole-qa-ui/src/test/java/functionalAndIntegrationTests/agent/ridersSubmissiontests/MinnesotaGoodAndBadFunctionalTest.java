package functionalAndIntegrationTests.agent.ridersSubmissiontests;

import com.github.javafaker.Faker;
import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.agent.CribSheet;
import functionalAndIntegrationTests.CQBaseIntegrationTest;
import resources.pages.agentpages.oldOlePages.*;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import resources.pages.agentpages.oldOlePages.variations.currentinsurancecoverage.AR_PA_OR_CurrentInsuranceCoveragePage;
import resources.pages.agentpages.oldOlePages.variations.planapplication.AR_PA_PlanApplicationQuestionsPage;
import resources.pages.agentpages.oldOlePages.variations.planselection.riders_MN_PlanSelectionPage;
import resources.pages.agentpages.oldOlePages.variations.replacenotice.RN034_AR_Page;
import queries.SubmissionQueryAgent;
import resources.utils.DateUtils;

public class MinnesotaGoodAndBadFunctionalTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public riders_MN_PlanSelectionPage planSelectionPage;
    @Page public CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public AR_PA_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public EligibilityHealthQuestionsPage eligibilityHealthQuestionsPage;
    @Page public AR_PA_OR_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public AuthorizationPage authorizationPage;
    @Page public RN034_AR_Page replacementNotice;
    @Page public HealthHistoryQuestionsPage healthHistoryQuestionsPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQueryAgent submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQueryAgent();
        faker = new Faker();
        sheet = new CribSheet(faker);

        expectedSubmissionResult = new SubmissionResult();
    }
    @Test
    public void test_minnesota_basic_plan() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| WI| MN]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        Application app = new Application();

        app.setState("MN");
        app.setZipCode("55445");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(67));
        app.setMPBED("05/01/2012");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.isAt();
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);

        planSelectionPage.isAt();
        planSelectionPage.goodComboBasicPlan();
        planSelectionPage.badComboBasicPlan();


    }
    @Test
    public void test_minnesota_extended_plan() throws Exception {

        sheet.setAgentId("Test");
        sheet.setAgentMedSuppStates("[NV| CA| MA| FL| NY| OH| AR| WI| MN]");
        sheet.setAgentCertificationYears("[2014 |2015| 2016]");
        sheet.setMarketability_code(BLANK);
        sheet.setSiteId("UHP");
        sheet.setAgentNPN(BLANK);
        sheet.setAgentName("BOB DOBBS");
        sheet.setAgentEmail("bob@dobbsco.com");
        sheet.setAgentPartyId("54321");
        sheet.setReferrer("ulayer");

        Application app = new Application();

        app.setState("MN");
        app.setZipCode("55445");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(67));
        app.setMPBED("05/01/2012");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.isAt();
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);

        planSelectionPage.isAt();
        planSelectionPage.goodComboExtendedBasicPlan();


    }

}
