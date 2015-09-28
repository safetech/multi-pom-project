package integration.agentRider;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.agent.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.agent.*;
import pages.agent.variations.currentinsurancecoverage.AR_PA_OR_CurrentInsuranceCoveragePage;
import pages.agent.variations.planapplication.AR_PA_PlanApplicationQuestionsPage;
import pages.agent.variations.planselection.riders_WI_PlanSelectionPage;
import pages.agent.variations.replacenotice.RN034_AR_Page;
import queries.SubmissionQueryAgent;
import util.DateUtils;

public class WisconsinFunctionalTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public riders_WI_PlanSelectionPage planSelectionPage;
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

    //TODO: Add Riders submissions for Agent, Phone and Dtc only need one TC.
    @Test
    public void test_wisconson_basic_plan_with_good_combo() throws Exception {

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

        app.setState("WI");
        app.setZipCode("54001");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(69));
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
    public void test_wisconson_basic_plan_with_CoPay_good_combo() throws Exception {

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

        app.setState("WI");
        app.setZipCode("54001");
        app.setDOB(DateUtils.getDOBInNormalDateFormat(69));
        app.setMPBED("05/01/2012");

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.isAt();
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);

        planSelectionPage.isAt();
        planSelectionPage.goodComboWithCoPay();
        planSelectionPage.badComboWithCoPay();

    }

}
