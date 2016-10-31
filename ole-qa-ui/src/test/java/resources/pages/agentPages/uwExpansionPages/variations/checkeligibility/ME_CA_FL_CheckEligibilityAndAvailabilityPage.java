package resources.pages.agentpages.uwExpansionPages.variations.checkeligibility;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.entity.Application;
import resources.pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ME_CA_FL_CheckEligibilityAndAvailabilityPage extends WizardPage {

    public FluentWebElement ZipCode;
    public FluentWebElement DOB;
    public FluentWebElement MPBED;
    public FluentWebElement ReqEffectiveDate;
    public FluentWebElement State;

    @FindBy(xpath = "//*[@id='block']/div[3]/div/div[5]/a") FluentWebElement helpToolTip;

    public void fillAndSubmit(Application app) throws InterruptedException {

        isAt();
        fill(ZipCode).with(app.getZipCode());
        blur("#ZipCode");
            try{
                Thread.sleep(5000);
            }catch(Exception e){
            }
        
        
//        await().atMost(10, TimeUnit.SECONDS).until("#State").hasAttribute("value", app.getState());
       if(State.getValue().equals("")){
           fill(ZipCode).with("08406");
           blur("#ZipCode");
           try{
               Thread.sleep(2000);
           }catch(Exception e){
           }
           fill(ZipCode).with(app.getZipCode());
           blur("#ZipCode");
           try{
               Thread.sleep(2000);
           }catch(Exception e){
           }
                if(State.getValue().equals( null)){
                    fill(ZipCode).with(app.getZipCode());   
           }
       }
        
        
        fill(DOB).with(app.getDOB());
        blur("#DOB");
            try{
                Thread.sleep(300);
            }catch(Exception e){
            }
        fill(MPBED).with(app.getMPBED()+"\t");
        blur("#MPBED");
            try{
                Thread.sleep(3000);
            }catch(Exception e){
            }

        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();

        Thread.sleep(2000);
        
        fillSelect("div.customer_eligibility_form #ReqEffectiveDate").withIndex(2);
        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
        (new WebDriverWait(getDriver(), 10)).until( new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return helpToolTip.isDisplayed();
            }
        });
        clickNextAndWaitForSpinnerToFinish();

    }

    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Check Eligibility and Availability"));

    }

}




