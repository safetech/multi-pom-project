package resources.pages.phonePages.uwExpansionPages.variations.planselection;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MN_iTest_PlanSelectionPage extends WizardPage {

     @FindBy(xpath = "//*[@id='planCode_1']") FluentWebElement basicPlan;
     @FindBy(xpath = "//*[@id='planCode_2']") FluentWebElement basicPlanWithCoPay;
     @FindBy(xpath = "(//*[contains(text(),'add ridersSubmissionTests')])[/]") FluentWebElement Add_Rider;
     @FindBy(xpath = "(//*[contains(text(),'continue')])[1]") FluentWebElement Continue;
     @FindBy(xpath = "//*[@id='rider_compatibility_error_MN']/ul[1]/li/a") FluentWebElement Update_Rider_Selection;
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
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start Date"));
    }

     public void blurAndSleep() {
          try{
               Thread.sleep(1000);
          }catch(Exception e){
          }
     }
     public void blur(String selector){
          executeScript("$('"+selector+"').blur()");
     }
    public void basicPlanGaNoRiderNoRnNoQr() {
        isAt();
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        waitForSpinnerToFinish();
    }
    public void basicPlanGaRider23And4NoRnNoQr() {
        isAt();
        basicPlan.click();
        RiderChoice_XW.click();
        RiderChoice_YW.click();
        RiderChoice_VW.click();
        clickNextAndWaitForSpinnerToFinish();
        blurAndSleep();
        Update_Rider_Selection.click();
        RiderChoice_XW.click();
        RiderChoice_WW.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    public void extendedPlanFullUwWithRnQr() {
        isAt();
        basicPlanWithCoPay.click();


        clickNextAndWaitForSpinnerToFinish();
    }
    public void basicPlanGaRider234And5NoRnNoQr() {
        isAt();
        basicPlan.click();
        RiderChoice_YW.click();
        RiderChoice_VW.click();
        RiderChoice_WW.click();
        RiderChoice_ZW.click();

        clickNextAndWaitForSpinnerToFinish();
    }
}
