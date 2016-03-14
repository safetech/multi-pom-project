package integration.agent.agentPages.uwExpansionPages.variations.checkeligibility;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ME_CA_FL_CheckEligibilityAndAvailabilityPage extends WizardPage {

    public FluentWebElement ZipCode;
    public FluentWebElement DOB;
    public FluentWebElement MPBED;
    public FluentWebElement ReqEffectiveDate;
    public FluentWebElement State;

    //.tooltip
    @FindBy(xpath = "//*[@id='block']/div[3]/div/div[5]/a") FluentWebElement helpToolTip;

    public void fillAndSubmit(Application app) {

        isAt();
        fill(ZipCode).with(app.getZipCode());
        blur("#ZipCode");
            try{
                Thread.sleep(5000);
            }catch(Exception e){
            }
        await().atMost(10, TimeUnit.SECONDS).until("#State").hasAttribute("value", app.getState());
        fill(DOB).with(app.getDOB());
        blur("#DOB");
            try{
                Thread.sleep(300);
            }catch(Exception e){
            }
        fill(MPBED).with(app.getMPBED());
        blur("#MPBED");
            try{
                Thread.sleep(3000);
            }catch(Exception e){
            }

        fillSelect("div.customer_eligibility_form #ReqEffectiveDate").withIndex(3);
        try{
            Thread.sleep(5000);
        }catch(Exception e){
        }

        helpToolTip.click();
        blur("#ReqEffectiveDate");
        try{
            Thread.sleep(5000);
        }catch(Exception e){
        }
            waitForSpinnerToFinish(10);
            clickNextAndWaitForSpinnerToFinish();

    }

    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Check Eligibility and Availability"));

    }

}



