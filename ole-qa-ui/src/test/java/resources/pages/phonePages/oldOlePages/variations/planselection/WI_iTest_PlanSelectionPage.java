package resources.pages.phonepages.oldOlePages.variations.planselection;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WI_iTest_PlanSelectionPage extends WizardPage{

    @FindBy(xpath = "//*[@id='planCode_1']") FluentWebElement basicPlan;
    @FindBy(xpath = "//*[@id='planCode_2']") FluentWebElement basicPlanWithCoPay;
    @FindBy(xpath = "(//*[contains(text(),'add ridersSubmissiontests')])[/]") FluentWebElement Add_Rider;
    @FindBy(xpath = "(//*[contains(text(),'continue')])[1]") FluentWebElement Continue;
    @FindBy(xpath = "//*[@id='rider_compatibility_error_WI']/ul[1]/li/a") FluentWebElement Update_Rider_Selection;
    @FindBy(css = ".button.action_back") FluentWebElement Back;
    @FindBy(xpath = "//*[@id='RiderChoiceXW']") FluentWebElement RiderChoice_XW;
    @FindBy(xpath = "//*[@id='RiderChoiceYW']") FluentWebElement RiderChoice_YW;
    @FindBy(xpath = "//*[@id='RiderChoiceVW']") FluentWebElement RiderChoice_VW;
    @FindBy(xpath = "//*[@id='RiderChoiceWW']") FluentWebElement RiderChoice_WW;
    @FindBy(xpath = "//*[@id='RiderChoiceZW']") FluentWebElement RiderChoice_ZW;
    @FindBy(xpath = "//*[@id='RiderChoiceOW']") FluentWebElement RiderChoice_OW;
    @FindBy(xpath = "//*[@id='RiderChoicePW']") FluentWebElement RiderChoice_PW;
    @FindBy(xpath = "//*[@id='RiderChoiceQW']") FluentWebElement RiderChoice_QW;
    @FindBy(xpath = "//*[@id='RiderChoiceSW']") FluentWebElement RiderChoice_SW;
    @FindBy(xpath = "//*[@id='RiderChoiceOW' and @data-parentplan = 'NW']") FluentWebElement RiderChoice_OW2;
    @FindBy(xpath = "//*[@id='RiderChoicePW' and @data-parentplan = 'NW']") FluentWebElement RiderChoice_PW2;
    @FindBy(xpath = "//*[@id='RiderChoiceSW' and @data-parentplan = 'NW']") FluentWebElement RiderChoice_SW2;

    public void fillAndSubmit(Application app) {

        isAt();

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
    public void basicPlanRiderOneAndThree() {
        isAt();
        basicPlan.click();
        RiderChoice_OW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_QW.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    public void basicPlanRiderTwoAndFour() {
        isAt();
        basicPlan.click();
        RiderChoice_PW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_SW.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    public void basicPlanCoPayRiderOneAndFour() {
        isAt();
        basicPlanWithCoPay.click();
        RiderChoice_OW2.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_SW2.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    public void basicPlanCoPayRiderTwoAndFour() {
        isAt();
        basicPlanWithCoPay.click();
        RiderChoice_PW2.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_SW2.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    public void basicPlanCoPayNoRiderQr() {
        isAt();
        basicPlanWithCoPay.click();
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        clickNextAndWaitForSpinnerToFinish();
    }
}
