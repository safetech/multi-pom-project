package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckEligibilityAndAvailabilityPage extends WizardPage {

    public FluentWebElement ZipCode;
    public FluentWebElement DOB;
    public FluentWebElement MPBED;
    public FluentWebElement ReqEffectiveDate;
    public FluentWebElement State;

    public void fillAndSubmit(Application app) {

        isAt();
        fill(ZipCode).with(app.getZipCode());
        blur("#ZipCode");
            try{
                Thread.sleep(10000);
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
                Thread.sleep(300);
            }catch(Exception e){
            }

        await().atMost(10, TimeUnit.SECONDS).until("div.customer_eligibility_form #ReqEffectiveDate option").hasSize(4);

        await().atMost(20, TimeUnit.SECONDS).until("div.customer_eligibility_form #ReqEffectiveDate option").hasSize(4);

        fillSelect("div.customer_eligibility_form #ReqEffectiveDate").withIndex(1);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Check Eligibility and Availability"));

    }

}




