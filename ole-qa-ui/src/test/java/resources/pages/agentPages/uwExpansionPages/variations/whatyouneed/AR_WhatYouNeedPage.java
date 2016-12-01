package resources.pages.agentpages.uwExpansionPages.variations.whatyouneed;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AR_WhatYouNeedPage extends WizardPage {

    @FindBy(css = "#pageborder") FluentWebElement pageBorderContent;
    @FindBy(css = "#text_10_0") FluentWebElement PlanOverview;
    @FindBy(css = "#text_11_0") FluentWebElement BenefitsTable;
    @FindBy(css = "#text_1_0") FluentWebElement RulesAndDisclousures;
    @FindBy(css = "#text_40_0") FluentWebElement YourGuideToAARPMedicareSelectAndSupplementInsurancePlans;
    @FindBy(css = "#text_2_0") FluentWebElement GuideToHealthInsuranceForPeopleWithMedicare;
    @FindBy(css = "#colctrl_showhide>p>a") FluentWebElement ImportantDisclousures;
    @FindBy(css = "#AgentKitProvided") FluentWebElement AgentKitProvided;
    @FindBy(css = "#signatureType_3") FluentWebElement TouchSign;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[2]/div/div[1]/aside/div/p[6]/b") FluentWebElement RequestedEffectiveDate;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[2]/div/div[1]/aside/div/p[3]/b") FluentWebElement SelectedPlan;


    public void fillAndSubmit(Application app) {
        isAt();
        app.getTest().log(LogStatus.INFO,"Page checkpoint passed");
        app.setReqEffectiveDate(RequestedEffectiveDate.getText());
        assertThat(SelectedPlan.getText(),equalTo("Plan B"));
        
        PlanOverview.click();
        closeSpecificBrowser(1);
        BenefitsTable.click();
        closeSpecificBrowser(1);
        RulesAndDisclousures.click();
        closeSpecificBrowser(1);
        YourGuideToAARPMedicareSelectAndSupplementInsurancePlans.click();
        closeSpecificBrowser(1);
        GuideToHealthInsuranceForPeopleWithMedicare.click();
        closeSpecificBrowser(1);
        
        AgentKitProvided.click();
        TouchSign.click();
        await().atMost(5, TimeUnit.SECONDS).until(".right").withText().startsWith("*An enrollment kit").isPresent();


        app.getTest().log(LogStatus.INFO,"Clicking Next..");
        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {

         assertThat(pageTitle.getText(), equalTo("What You Need"));
    }

}
