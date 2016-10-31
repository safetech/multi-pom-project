package resources.pages.agentpages.uwExpansionPages;

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

public class PlanSelectionPage extends WizardPage{

    @FindBy(xpath = "(//a[contains(text(),'apply now')])[1]") FluentWebElement First_Plan;
    @FindBy(xpath = "(//a[contains(text(),'apply now')])[2]") FluentWebElement Second_Plan;
    @FindBy(xpath = "//*[@id='block']/div[3]/p[4]/a") FluentWebElement ChangeEligibilityAndAvailabilityInformation;

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
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/p[3]/b") FluentWebElement DobPsdMpbedContainer;
    
    

    public void fillAndSubmit(Application app) {

        isAt();
        ChangeEligibilityAndAvailabilityInformation.click();
        clickNextAndWaitForSpinnerToFinish();
        
        (new WebDriverWait(getDriver(), 10)).until( new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return First_Plan.isDisplayed();
            }
        });

        await().atMost(10, TimeUnit.SECONDS).until("#OleRateTable tbody tr").isPresent();
        await().atMost(5, TimeUnit.SECONDS).until(".OleRateTable").withText("Plan").hasSize();
        
        
        assert(DobPsdMpbedContainer).getText().contains(app.getDOB());
        assert(DobPsdMpbedContainer).getText().contains(app.getMPBED());
        Second_Plan.click();

        blur("apply");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
        }

    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection"));
    }

}
