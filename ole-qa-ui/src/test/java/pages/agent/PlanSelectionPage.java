package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanSelectionPage extends WizardPage{

    @FindBy(css = "#a[data-plancode='F']") FluentWebElement Plan_F;
    public void fillAndSubmit(Application app) {

        isAt();
        click("a[data-plancode='F']");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
        }
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection"));
    }
}
