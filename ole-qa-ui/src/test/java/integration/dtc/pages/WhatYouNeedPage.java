package integration.dtc.pages;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhatYouNeedPage extends WizardPage {

    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement pageBorderContent;
    @FindBy(css = "#text_10_0") protected FluentWebElement PlanOverview;
    @FindBy(css = "#text_11_0") protected FluentWebElement BenefitsTable;
    @FindBy(css = "#text_1_0") protected FluentWebElement RulesAndDisclousures;
    @FindBy(css = "#text_12_0") protected FluentWebElement YourGuideToAARPMedicareSupplementInsurancePlans;
    @FindBy(css = "#text_2_0") protected FluentWebElement GuideToHealthInsuranceForPeopleWithMedicare;
    @FindBy(css = "#colctrl_showhide>p>a") protected FluentWebElement ImportantDisclousures;

    public void fillAndSubmit(Application app) {

        isAt();
        PlanOverview.click();
        BenefitsTable.click();
        RulesAndDisclousures.click();
        YourGuideToAARPMedicareSupplementInsurancePlans.click();
        GuideToHealthInsuranceForPeopleWithMedicare.click();
        ImportantDisclousures.click();

        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("What You Need"));
    }
}
