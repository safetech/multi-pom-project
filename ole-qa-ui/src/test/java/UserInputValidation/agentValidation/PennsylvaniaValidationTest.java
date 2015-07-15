package UserInputValidation.agentValidation;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.agent.CribSheet;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.agent.*;
import pages.agent.variations.currentinsurancecoverage.FL_CurrentInsuranceCoveragePage;
import pages.agent.variations.planapplication.NV_PlanApplicationQuestionsPage;
import pages.agent.variations.replacenotice.RN078Page;
import queries.SubmissionQuery;
import util.DateUtils;

public class PennsylvaniaValidationTest extends CQBaseIntegrationTest {
    @Page public CheatPage cheatPage;
    @Page public CheckEligibilityAndAvailabilityPage checkEligibilityAndAvailabilityPage;
    @Page public PlanSelectionPage planSelectionPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public CustomerInformationPage customerInformationPage;
    @Page public NV_PlanApplicationQuestionsPage planApplicationQuestionsPage;
    @Page public FL_CurrentInsuranceCoveragePage currentInsuranceCoveragePage;
    @Page public AuthorizationPage authorizationPage;
    @Page public AgentVerificationPage agentVerificationPage;
    @Page public RN078Page replacementNotice;
    @Page public PaymentDetailsSummaryPage paymentDetailsSummaryPage;
    @Page public PlanPaymentOptionsPage planPaymentOptionsPage;
    @Page public ReviewAndSubmitPage reviewAndSubmitPage;
    @Page public ApplicationSubmissionPage applicationSubmissionPage;

    public SubmissionQuery submissionQuery;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        expectedSubmissionResult = new SubmissionResult();
    }


    @Test
    public void test_pennsylvania_field_business_modals_errors_validations() throws Exception {

        sheet.setRandomNameGenderAndMembershipNumber();
        sheet.setRandomAddress("PA", "19002");
        sheet.setRandomContactInfo();
        sheet.setRandomCallCenterInfo();
        sheet.setDateOfBirth(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setMedPartBdate("2012-04-01");
        sheet.setDpsdToFirstDayOfFutureMonth(1);
        sheet.setPlanCode("F01");

        Application app = new Application();

        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.isAt();
        cheatPage.fillAndSubmit(sheet);

        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
        planSelectionPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        planApplicationQuestionsPage.fillAndSubmit(app);
        whatYouNeedPage.fillAndSubmit(app);
        currentInsuranceCoveragePage.fillAndSubmit(app);
        authorizationPage.fillAndSubmit(app);
        agentVerificationPage.fillAndSubmit(app);
        replacementNotice.fillAndSubmit(app);
        paymentDetailsSummaryPage.fillAndSubmit(app);
        reviewAndSubmitPage.fillAndSubmit(app);
        applicationSubmissionPage.isPending();

    }

}
