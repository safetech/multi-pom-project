package integration.dtc.submission;

import com.github.javafaker.Faker;
import integration.CQBaseIntegrationTest;
import pages.dtc.*;
import entity.Application;
import entity.dtc.CribSheet;
import entity.SubmissionResult;
import queries.SubmissionQuery;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import util.DateUtils;

public class NevadaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;
    @Page public WhatYouNeedPage whatYouNeedPage;
    @Page public ElectronicSignatureAndDocumentConsentPage electronicSignatureAndDocumentConsentPage;
    @Page public AboutYouPage aboutYouPage;
    @Page public PlanSelectionAndStartDatePage planSelectionAndStartDatePage;

    public SubmissionQuery submissionQuery;
    private Faker faker;
    protected CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        submissionQuery = new SubmissionQuery();
        faker = new Faker();
        sheet = new CribSheet(faker);
        sheet.setState("NV");
        sheet.setZip("89001");

        expectedSubmissionResult = new SubmissionResult();
    }

    @Test
    public void test_nevada_health_history_underwriting_with_designeeSig_with_rn() throws Exception {

        sheet.setAarpMemid("y");
        sheet.setDOB(DateUtils.getDOBofPersonTurningAgeToday(69));
        sheet.setEffDate("01/01/2014");
        sheet.setPsd(DateUtils.getFirstDayOfFutureMonth(1));
        sheet.setPlanCode("A");
        sheet.setReferrer("uLayer");

        Application app = new Application();
        //TestData
        app.setAARPMembershipNumber("1234567890");
        app.setPrefix("MR");
        app.setFirstName("Bob");
        app.setMI("N");
        app.setLastName("Automation");
        app.setSuffix("PHD");
        app.setAddressLine1("111 Street dr");
        app.setAddressLine2("apt #123");
        app.setCity("Horsham");
        app.setEmail("test@uhc.com");
        app.setConfirmEmail("test@uhc.com");
        app.setPhonePrimary("9874562345");
        app.setPhoneEvening("1234561234");
        app.setGender("M");
        app.setMedicareClaimNum("123123123A");
        app.setMPAED("01/01/2010");
        app.setPartABActiveIndicator(YES);


        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
        whatYouNeedPage.isAt();
        whatYouNeedPage.clickNextAndWaitForSpinnerToFinish();
        electronicSignatureAndDocumentConsentPage.isAt();
        electronicSignatureAndDocumentConsentPage.clickNextAndWaitForSpinnerToFinish();
        aboutYouPage.isAt();
        aboutYouPage.fillAndSubmit(app, sheet);
        planSelectionAndStartDatePage.isAt();


//        expectedSubmissionResult.setPendingInfo("UNDERWRITING", "REVIEW FOR POSSIBLE ESRD");
//        submissionQuery.verifySubmissionData(app, expectedSubmissionResult);
//        submissionQuery.verifyAdjudicationData(app, expectedSubmissionResult);

    }

}
