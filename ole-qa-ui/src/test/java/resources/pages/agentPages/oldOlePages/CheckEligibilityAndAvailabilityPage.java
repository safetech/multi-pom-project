package resources.pages.agentpages.oldOlePages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckEligibilityAndAvailabilityPage extends WizardPage {

    public FluentWebElement ZipCode;
    public FluentWebElement DOB;
    public FluentWebElement MPBED;
    public FluentWebElement ReqEffectiveDate;
    @FindBy(css = "#State") FluentWebElement State;


    public void fillAndSubmit(Application app) {

        isAt();
        fill(ZipCode).with(app.getZipCode());

            blur("#ZipCode");
        try{
            Thread.sleep(5000);
        }catch(Exception e){
        }
        getDriver().findElement(By.id("ZipCode")).sendKeys(Keys.TAB);
        
        while (State.getValue().equals( null )){
            getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            if(State.getValue().equals( app.getState())){
                break;
            }
            if(State.getValue().equals( "" )){
                fill(ZipCode).with("08406");
                getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                assert(State.getValue().equals( "NJ" ));
            }
            fill(ZipCode).with(app.getZipCode());
            assert(State.getValue().equals( app.getState()));
        }

        fill(DOB).with(app.getDOB());
        blur("#DOB");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
        fill(MPBED).with(app.getMPBED());
        blur("#MPBED");
        try{
            Thread.sleep(300);
        }catch(Exception e){
        }

        await().atMost(20, TimeUnit.SECONDS).until("div.customer_eligibility_form #ReqEffectiveDate option").hasSize(4);

        fillSelect("div.customer_eligibility_form #ReqEffectiveDate").withIndex(1);
        blur("#ReqEffectiveDate");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
        blur("#ReqEffectiveDate");
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickNextAndWaitForSpinnerToFinish();
    }
    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Check Eligibility and Availability"));

    }
    public void isNotAuthorizedToSell() {
        assertThat(pageTitle.getText(), equalTo("You are not authorized to sell AARP Medicare Supplement insurance Plans in this state"));

    }
}




