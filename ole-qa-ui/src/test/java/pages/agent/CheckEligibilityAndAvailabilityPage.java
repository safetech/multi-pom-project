package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckEligibilityAndAvailabilityPage extends WizardPage {

    FluentWebElement ZipCode;
    FluentWebElement DOB;
    FluentWebElement MPBED;
    FluentWebElement ReqEffectiveDate;
    FluentWebElement State;

    public void fillAndSubmit(Application app) {

        isAt();

        fill(ZipCode).with(app.getZipCode());
        blur("#ZipCode");

        try{
            Thread.sleep(3000);
        }catch(Exception e){
        }

        await().atMost(10, TimeUnit.SECONDS).until("#State").hasAttribute("value", app.getState());
        fill(DOB).with(app.getDOB());
        fill(MPBED).with(app.getMPBED());
        blur("#MPBED");



        await().atMost(5, TimeUnit.SECONDS).until("div.customer_eligibility_form #ReqEffectiveDate option").hasSize(4);
        fillSelect("div.customer_eligibility_form #ReqEffectiveDate").withIndex(1);



        clickNextAndWaitForSpinnerToFinish(5);
    }

    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Check Eligibility and Availability"));
    }


    //driver.findElement(By.xpath("//span[.contains\'Automation Testing\']")).click();

}




