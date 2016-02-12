package integration.phone.phonePages.uwExpansionPages.variations.planselection;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MN_Riders_PlanSelectionPage extends WizardPage {

    @FindBy(xpath = "//*[@id='planCode_1']") FluentWebElement basicPlan;
     @FindBy(xpath = "//*[@id='planCode_2']") FluentWebElement basicPlanWithCoPay;
    @FindBy(xpath = "(//*[contains(text(),'add rider')])[1]") FluentWebElement Add_Rider;
    @FindBy(xpath = "(//*[contains(text(),'continue')])[1]") FluentWebElement Continue;
    @FindBy(xpath = "//*[@id='rider_compatibility_error_WI']/ul[1]/li/a") FluentWebElement Update_Rider_Selection;
    @FindBy(xpath = "//*[@id='rider_compatibility_error_MN']/ul[1]/li/a") FluentWebElement Update_MNRider_Selection;


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

    @FindBy(xpath = "(//*[@id='RiderChoiceOW'])[2]") FluentWebElement RiderChoice_OW2;
    @FindBy(xpath = "(//*[@id='RiderChoicePW'])[2]") FluentWebElement RiderChoice_PW2;
    @FindBy(xpath = "(//*[@id='RiderChoiceSW'])[2]") FluentWebElement RiderChoice_SW2;

    FluentWebElement ReqEffectiveDate;

   public void goodComboBasicPlan(Application app) {
        //----TC 1******************************************************************************

        isAt();

        basicPlan.click();

        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Add_Rider.click();

        //----TC 2******************************************************************************
        isAt();

        basicPlan.click();
        RiderChoice_XW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_XW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 3******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_YW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_YW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 4******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_VW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_VW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 5******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_WW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_WW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 6******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_ZW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_ZW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 7******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_XW.click();
        RiderChoice_YW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_XW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 8******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        //   RiderChoice_YW.click();
        RiderChoice_VW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_VW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 9******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_WW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_WW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 10******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_ZW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_ZW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 11******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_VW.click();
        RiderChoice_WW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_YW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 12******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_WW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 13******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_ZW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_VW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 14******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_WW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_WW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 15******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_YW.click();
        RiderChoice_VW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_VW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 16******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_WW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_YW.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 17******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_VW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

        //----TC 18******************************************************************************

        isAt();

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        basicPlan.click();
        RiderChoice_YW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        clickNextAndWaitForSpinnerToFinish();
        isAtPlanQuestion();
        Back.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_YW.click();
        RiderChoice_VW.click();
        RiderChoice_WW.click();
        RiderChoice_ZW.click();


   }

        //----******************************************************************************


    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


    public void badComboBasicPlan(Application app) {

         //----TC 1******************************************************************************

         blurAndSleep();

         isAt();

         basicPlan.click();
         RiderChoice_XW.click();
         RiderChoice_VW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_VW.click();


         //----TC 2******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_WW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_WW.click();


         //----TC 3******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_ZW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_ZW.click();


         //----TC 4******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_YW.click();
         RiderChoice_VW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_VW.click();

         //----TC 5******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_WW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_WW.click();

         //----TC 6******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_ZW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_ZW.click();

         //----TC 7******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_VW.click();
         RiderChoice_WW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

         //----TC 8******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_ZW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_VW.click();


         //----TC 9******************************************************************************

         isAt();

         basicPlan.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_WW.click();


         //----TC 10******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_VW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_YW.click();

         //----TC 11******************************************************************************

         isAt();

         basicPlan.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_ZW.click();

         //----TC 12******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_WW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();


         //----TC 13******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_ZW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_VW.click();

         //----TC 14******************************************************************************

         isAt();

         basicPlan.click();
         RiderChoice_VW.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
         clickNextAndWaitForSpinnerToFinish();
         blurAndSleep();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         Update_MNRider_Selection.click();
         await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
         RiderChoice_XW.click();

    }

         //---------******************************************************************************


     //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

     public void goodComboExtendedBasicPlan() {

          //----TC 0******************************************************************************

          blurAndSleep();

          basicPlanWithCoPay.click();
          await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
          clickNextAndWaitForSpinnerToFinish();
          Back.click();
          blurAndSleep();
          basicPlanWithCoPay.click();
          await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

     }


     //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


    private Select getReqEffectiveDateSelect() {
        return (new Select(ReqEffectiveDate.getElement()));
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start Date"));
    }


    public void isAtPlanQuestion() {
        assertThat(pageTitle.getText(), equalTo("Plan Application Questions"));

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
