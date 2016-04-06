package resources.pages.agentPages.oldOlePages.variations.planselection;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class iTest_MN_PlanSelectionPage extends WizardPage{

    @FindBy(xpath = "(//a[contains(text(),'apply now')])[1]") FluentWebElement basicPlan;
    @FindBy(xpath = "(//a[contains(text(),'apply now')])[2]") FluentWebElement basicPlanWithCoPay;
    @FindBy(xpath = "(//*[contains(text(),'add rider')])[2]") FluentWebElement Add_Rider;
    @FindBy(xpath = "(//*[contains(text(),'continue')])[1]") FluentWebElement Continue;
    @FindBy(xpath = "//*[@id='rider_compatibility_error_WI']/ul[1]/li/a") FluentWebElement Update_Rider_Selection;
    @FindBy(xpath = "//*[@id='rider_compatibility_error_MN']/ul[1]/li/a") FluentWebElement Update_MNRider_Selection;
    @FindBy(css = ".button.arrow.left.action_back") FluentWebElement Back;

    @FindBy(xpath = "//*[@id='RiderChoiceXW']") FluentWebElement RiderChoice_XW;
    @FindBy(xpath = "//*[@id='RiderChoiceYW']") FluentWebElement RiderChoice_YW;
    @FindBy(xpath = "//*[@id='RiderChoiceVW']") FluentWebElement RiderChoice_VW;
    @FindBy(xpath = "//*[@id='RiderChoiceWW']") FluentWebElement RiderChoice_WW;
    @FindBy(xpath = "//*[@id='RiderChoiceZW']") FluentWebElement RiderChoice_ZW;

    @FindBy(xpath = "//*[@id='RiderChoiceOW']") FluentWebElement RiderChoice_OW;
    @FindBy(xpath = "//*[@id='RiderChoicePW']") FluentWebElement RiderChoice_PW;
    @FindBy(xpath = "//*[@id='RiderChoiceQW']") FluentWebElement RiderChoice_QW;
    @FindBy(xpath = "//*[@id='RiderChoiceSW']") FluentWebElement RiderChoice_SW;

    @FindBy(xpath = "(//*[@id='RiderChoiceOW'])[2]") FluentWebElement RiderChoice_OW2;
    @FindBy(xpath = "(//*[@id='RiderChoicePW'])[2]") FluentWebElement RiderChoice_PW2;
    @FindBy(xpath = "(//*[@id='RiderChoiceSW'])[2]") FluentWebElement RiderChoice_SW2;


    public void fillAndSubmit(Application app) {

        isAt();

    }

    public void selectRider1And2FullUWwithRn() {
        RiderChoice_XW.click();
        RiderChoice_YW.click();
        basicPlan.click();
        waitForSpinnerToFinish();
    }

    public void selectBasicPlanRider34And5WithFullUWAndRn() {
        RiderChoice_VW.click();
        RiderChoice_WW.click();
        RiderChoice_ZW.click();
        basicPlan.click();
        waitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection"));
    }

    public void blurAndSleep() {
        blur(".button.yellow.arrow.action_close.btn2");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
    }
    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }
}


