package resources.pages.agentpages.uwExpansionPages.variations.planselection;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class riders_MN_PlanSelectionPage extends WizardPage{

    @FindBy(xpath = "(//a[contains(text(),'apply now')])[1]") FluentWebElement basicPlan;
    @FindBy(xpath = "(//a[contains(text(),'apply now')])[2]") FluentWebElement basicPlanWithCoPay;
    @FindBy(xpath = "(//*[contains(text(),'add ridersSubmissiontests')])[2]") FluentWebElement Add_Rider;
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
        basicPlan.click();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

    }
    public void goodComboBasicPlan() {

//----TC 0******************************************************************************

        basicPlan.click();
        Add_Rider.click();
//----TC 1******************************************************************************

        RiderChoice_XW.click();
        basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_XW.click();
//----TC 2******************************************************************************

        RiderChoice_YW.click();
        basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_YW.click();
//----TC 3******************************************************************************

        RiderChoice_VW.click();
        basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_VW.click();
//----TC 4******************************************************************************

        RiderChoice_WW.click();
        basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_WW.click();
//----TC 5******************************************************************************

        RiderChoice_ZW.click();
        basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_ZW.click();
//----TC 6******************************************************************************

            RiderChoice_XW.click();
            RiderChoice_YW.click();
            basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_XW.click();
            RiderChoice_YW.click();
//----TC 7******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_VW.click();
            basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_YW.click();
            RiderChoice_VW.click();
//----TC 8******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_WW.click();
            basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_YW.click();
            RiderChoice_WW.click();
//----TC 9******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_YW.click();
            RiderChoice_ZW.click();
//----TC 10******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_VW.click();
            RiderChoice_WW.click();
            basicPlan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_YW.click();
            RiderChoice_VW.click();
            RiderChoice_WW.click();
//----TC 11******************************************************************************

            RiderChoice_VW.click();
            RiderChoice_WW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_VW.click();
            RiderChoice_WW.click();
//----TC 12******************************************************************************

            RiderChoice_VW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAt();
            RiderChoice_VW.click();
            RiderChoice_ZW.click();
//----TC 13******************************************************************************

            RiderChoice_WW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAt();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();
//----TC 14******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_VW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAt();
            RiderChoice_YW.click();
            RiderChoice_VW.click();
            RiderChoice_ZW.click();
//----TC 15******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAt();
            RiderChoice_YW.click();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();
//----TC 16******************************************************************************

            RiderChoice_VW.click();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAt();
            RiderChoice_VW.click();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();
//----TC 17******************************************************************************

            RiderChoice_YW.click();
            RiderChoice_VW.click();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();
            basicPlan.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAt();
            RiderChoice_YW.click();
            RiderChoice_VW.click();
            RiderChoice_WW.click();
            RiderChoice_ZW.click();

    }

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public void badComboBasicPlan() {

    //----TC 1******************************************************************************

        RiderChoice_XW.click();
        RiderChoice_VW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_VW.click();

    //----TC 2********STILL ACTIVE = XW *********************************************************************

        RiderChoice_WW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_WW.click();
    //----TC 3********STILL ACTIVE = XW **********************************************************************

        RiderChoice_ZW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_ZW.click();
    //----TC 4**********STILL ACTIVE = XW ********************************************************************

        RiderChoice_YW.click();
        RiderChoice_VW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_VW.click();


     //----TC 5**********STILL ACTIVE = XW, YW ********************************************************************

        RiderChoice_WW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_WW.click();

     //----TC 6*********STILL ACTIVE = XW, YW *********************************************************************

        RiderChoice_ZW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_ZW.click();
     //----TC 7**********STILL ACTIVE = XW, YW ********************************************************************

        RiderChoice_VW.click();
        RiderChoice_WW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

     //----TC 8********STILL ACTIVE = XW, YW, WW **********************************************************************

        RiderChoice_ZW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_VW.click();


     //----TC 9******************************************************************************


        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_WW.click();
     //----TC 10******************************************************************************


        RiderChoice_VW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_YW.click();


     //----TC 11*************** XW VW ZW *******************************************************


        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_ZW.click();

    //**********************TC 12******************************************************************************


        RiderChoice_WW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

    //----TC 13******************************************************************************

        RiderChoice_ZW.click();
        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_VW.click();
    //----TC 14******************************************************************************

        basicPlan.click();
        blurAndSleep();
        Update_MNRider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_XW.click();

}

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public void goodComboExtendedBasicPlan() {
    //----TC 0******************************************************************************
        basicPlanWithCoPay.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();
        blurAndSleep();
        basicPlanWithCoPay.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

    }

    public void isAtWhatYouNeedPage() {
        assertThat(pageTitle.getText(), equalTo("What You Need"));
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
