package UserInputValidation.agentValidation;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import pages.agent.*;
import pages.agent.variations.currentinsurancecoverage.FL_CurrentInsuranceCoveragePage;
import pages.agent.variations.planapplication.NV_PlanApplicationQuestionsPage;
import pages.agent.variations.replacenotice.RN078Page;

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


    private Faker faker;
    private entity.agent.CribSheet sheet;



    @Test
    public void test_pennsylvania_field_business_modals_errors_validations() throws Exception {

        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.isAt();
        cheatPage.fillAndSubmit(sheet);

        planSelectionPage.fillAndSubmit(app);
        customerInformationPage.fillAndSubmit(app);
        checkEligibilityAndAvailabilityPage.fillAndSubmit(app);
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
