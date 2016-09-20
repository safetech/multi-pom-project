package resources.pages.dtcpages.oldOlePages;

import resources.entity.Application;
import resources.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

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

    public void fillAndSubmit(Application app) {

        isAt();
        PlanOverview.click();
        closeSpecificBrowser(1);
        BenefitsTable.click();
        closeSpecificBrowser(1);
        RulesAndDisclousures.click();
        closeSpecificBrowser(1);
        YourGuideToAARPMedicareSupplementInsurancePlans.click();
        closeSpecificBrowser(1);
        GuideToHealthInsuranceForPeopleWithMedicare.click();
        closeSpecificBrowser(1);
        ImportantDisclousures.click();
        closeSpecificBrowser(1);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("What You Need"));

    }

}
