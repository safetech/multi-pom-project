package pages.agent.variations.planselection;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class riders_WI_PlanSelectionPage extends WizardPage{

    @FindBy(xpath = "(//a[contains(text(),'apply now')])[1]") FluentWebElement First_Plan;
    @FindBy(xpath = "(//a[contains(text(),'apply now')])[2]") FluentWebElement Second_Plan;
    @FindBy(xpath = "(//*[contains(text(),'add rider')])[2]") FluentWebElement Add_Rider;
    @FindBy(xpath = "(//*[contains(text(),'continue')])[1]") FluentWebElement Continue;
    @FindBy(xpath = "//*[@id='rider_compatibility_error_WI']/ul[1]/li/a") FluentWebElement Update_Rider_Selection;
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

    //html/body/div[3]/div/div[2]/ul[1]/li/a
//*[@id='rider_compatibility_error_WI']/ul[1]/li/a
    //*[@id='rider_compatibility_error_WI']/ul[1]/li/a/text()
    public void fillAndSubmit(Application app) {

        isAt();

    }
    public void goodComboBasicPlan() {

//----TC 0******************************************************************************

        First_Plan.click();
        Add_Rider.click();
//----TC 1******************************************************************************

        RiderChoice_OW.click();
        First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_OW.click();
//----TC 2******************************************************************************

        RiderChoice_PW.click();
        First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_PW.click();
//----TC 3******************************************************************************

        RiderChoice_QW.click();
        First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_QW.click();
//----TC 4******************************************************************************

        RiderChoice_SW.click();
        First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_SW.click();
//----TC 5******************************************************************************


            RiderChoice_OW.click();
            RiderChoice_QW.click();
            First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_QW.click();
            RiderChoice_OW.click();
//----TC 6******************************************************************************

            RiderChoice_OW.click();
            RiderChoice_SW.click();
            First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_OW.click();
            RiderChoice_SW.click();
//----TC 7******************************************************************************

            RiderChoice_OW.click();
            RiderChoice_QW.click();
            RiderChoice_SW.click();
            First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_OW.click();
            RiderChoice_QW.click();
            RiderChoice_SW.click();
//----TC 8******************************************************************************

            RiderChoice_PW.click();
            RiderChoice_QW.click();
            First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_PW.click();
            RiderChoice_QW.click();
//----TC 9******************************************************************************

            RiderChoice_PW.click();
            RiderChoice_SW.click();
            First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            isAtWhatYouNeedPage();
            Back.click();
            isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
            RiderChoice_PW.click();
            RiderChoice_SW.click();
//----TC 10******************************************************************************

        RiderChoice_PW.click();
        RiderChoice_QW.click();
        RiderChoice_SW.click();
        First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_QW.click();
        RiderChoice_PW.click();
        RiderChoice_SW.click();
//----TC 11******************************************************************************

        RiderChoice_QW.click();
        RiderChoice_SW.click();
        First_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAt();
        RiderChoice_QW.click();
        RiderChoice_SW.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

    }




//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public void badComboBasicPlan() {

    //----TC 0******************************************************************************

    RiderChoice_OW.click();
    RiderChoice_PW.click();
    First_Plan.click();
        blurAndSleep();
        Update_Rider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

    //----TC 1******************************************************************************

    RiderChoice_QW.click();
    First_Plan.click();
        blurAndSleep();
        Update_Rider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    //----TC 2******************************************************************************

    RiderChoice_SW.click();
    First_Plan.click();
        blurAndSleep();
    Update_Rider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    //----TC 3******************************************************************************

    RiderChoice_QW.click();
    First_Plan.click();
        blurAndSleep();
        Update_Rider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

}




//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public void goodComboWithCoPay() {
    //----TC 0******************************************************************************
        Second_Plan.click();
        Continue.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        Back.click();

    //----TC 1******************************************************************************
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_OW2.click();
        Second_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_OW2.click();
     //----TC 2******************************************************************************

        RiderChoice_OW2.click();
        RiderChoice_SW2.click();
        Second_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_OW2.click();
        RiderChoice_SW2.click();
     //----TC 3******************************************************************************

        RiderChoice_PW2.click();
        Second_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_PW2.click();
        //----TC 4******************************************************************************

        RiderChoice_PW2.click();
        RiderChoice_SW2.click();
        Second_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_PW2.click();
        RiderChoice_SW2.click();
     //----TC 5******************************************************************************

        RiderChoice_SW2.click();
        Second_Plan.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        isAtWhatYouNeedPage();
        Back.click();
        isAt();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
        RiderChoice_SW2.click();

    }



    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public void badComboWithCoPay(){


        RiderChoice_OW2.click();
        RiderChoice_PW2.click();
        Second_Plan.click();
        blurAndSleep();
        Update_Rider_Selection.click();
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        RiderChoice_SW2.click();
        Second_Plan.click();
        blurAndSleep();



        Update_Rider_Selection.click();
        blurAndSleep();
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
