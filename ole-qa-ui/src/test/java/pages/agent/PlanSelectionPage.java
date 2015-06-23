package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanSelectionPage extends WizardPage{

    @FindBy(xpath = "//table/tbody/tr[1]/td[*]/a") FluentWebElement First_Plan;
    public void fillAndSubmit(Application app) {

        isAt();

        First_Plan.click();

        try{
            Thread.sleep(3000);
        }catch(Exception e){
        }
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection"));
    }
}
