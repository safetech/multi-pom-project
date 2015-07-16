package uiValidation.agentValidation.agent;

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
    @FindBy(xpath = "//section/div[3]/div/div[1]/label[2]") protected FluentWebElement zipCodeErrorMessages;

    @FindBy(xpath = "//section/div[3]/div/div[3]/label[2]") protected FluentWebElement dobErrorMessages;
    @FindBy(xpath = "//section/div[3]/div/div[4]/label[2]") protected FluentWebElement mpbedErrorMessages;



    public void fillAndSubmit(Application app) {
        //displayErrorsAndModals();

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

        assertThat(zipCodeErrorMessages.getText(), equalTo("Required field"));
        fill(ZipCode).with("99999");
        blur("#ZipCode");
        assertThat(zipCodeErrorMessages.getText(), equalTo("Must be a valid US Zip code"));
        fill(ZipCode).with("ads1");
        blur("#ZipCode");
        assertThat(zipCodeErrorMessages.getText(), equalTo("Zip code must be 5 digits"));

        assertThat(dobErrorMessages.getText(), equalTo("Required field"));
        fill(DOB).with("ads1");
        assertThat(dobErrorMessages.getText(), equalTo("Date must be valid and in format MM/DD/YYYY"));

        assertThat(mpbedErrorMessages.getText(), equalTo("Required field"));
        fill(DOB).with("01/01/1945");
        fill(MPBED).with("01/01/1944");
        assertThat(mpbedErrorMessages.getText(), equalTo("Medical (Part B) Effective Date must be after 7/1/1966, cannot precede Date of Birth, and cannot be more than 3 months in the future"));
        fill(MPBED).with("01/05/1999");
        blur("#MPBED");
        assertThat(mpbedErrorMessages.getText(), equalTo("Date must be first of a month and in format MM/DD/YYYY"));
        fill(DOB).with("01/01/1945");
        fill(MPBED).with("01/01/2056");
        blur("#MPBED");
        assertThat(mpbedErrorMessages.getText(), equalTo("Medical (Part B) Effective Date must be after 7/1/1966, cannot precede Date of Birth, and cannot be more than 3 months in the future"));
        fill(ZipCode).with("19002");
        fill(DOB).with("19002");



        clickNextAndWaitForSpinnerToFinish();

    }


}




