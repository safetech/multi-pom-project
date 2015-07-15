package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(xpath = "//section/div[3]/div/div[1]/label[2]") protected FluentWebElement zipErrorRequiredField;
    @FindBy(xpath = "//section/div[3]/div/div[3]/label[2]") protected FluentWebElement dobErrorRequiredField;
    @FindBy(xpath = "//section/div[3]/div/div[4]/label[2]") protected FluentWebElement mpbedErrorRequiredField;



    public void fillAndSubmit(Application app) {
        displayErrorsAndModals();
        //identify errors identifiers and execute first tc

        isAt();
        fill(ZipCode).with(app.getZipCode());
        blur("#ZipCode");
            try{
                Thread.sleep(5000);
            }catch(Exception e){
            }
        await().atMost(20, TimeUnit.SECONDS).until("#State").hasAttribute("value", app.getState());
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
        await().atMost(5, TimeUnit.SECONDS).until("div.customer_eligibility_form #ReqEffectiveDate option").hasSize(4);
        fillSelect("div.customer_eligibility_form #ReqEffectiveDate").withIndex(1);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Check Eligibility and Availability"));

    }

    public void displayErrorsAndModals() {

        clickNextAndWaitForSpinnerToFinish();
        assertThat(zipErrorRequiredField.getText(), equalTo("Required field"));
        assertThat(dobErrorRequiredField.getText(), equalTo("Required field"));
        assertThat(mpbedErrorRequiredField.getText(), equalTo("Required field"));

    }


}




