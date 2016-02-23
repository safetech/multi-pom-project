package integration.agent.agentPages.uwExpansionPages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhatYouNeedPage extends WizardPage {

    @FindBy(css = "#pageborder") FluentWebElement pageBorderContent;
    @FindBy(css = "#text_10_0") FluentWebElement PlanOverview;
    @FindBy(css = "#text_11_0") FluentWebElement BenefitsTable;
    @FindBy(css = "#text_1_0") FluentWebElement RulesAndDisclousures;
    @FindBy(css = "#text_12_0") FluentWebElement YourGuideToAARPMedicareSupplementInsurancePlans;
    @FindBy(css = "#text_2_0") FluentWebElement GuideToHealthInsuranceForPeopleWithMedicare;
    @FindBy(css = "#colctrl_showhide>p>a") FluentWebElement ImportantDisclousures;
    @FindBy(css = "#AgentKitProvided") FluentWebElement AgentKitProvided;
    @FindBy(css = "#signatureType_3") FluentWebElement TouchSign;


    public void fillAndSubmit(Application app) {
        isAt();

        AgentKitProvided.click();
        TouchSign.click();
        await().atMost(5, TimeUnit.SECONDS).until(".right").withText().startsWith("*An enrollment kit").isPresent();

        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {

         assertThat(pageTitle.getText(), equalTo("What You Need"));
    }

}
