package pages.dtc.variations.planselectionandstartdate;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NV_MA_PlanSelectionAndStartDatePage extends WizardPage{

    @FindBy(xpath = "//b[contains(text(), 'ID ')]") public FluentWebElement applicationId;
    @FindBy(xpath = "//a[contains(text(), 'cancel')]") public FluentWebElement cancel;
    @FindBy(xpath = "//*[contains(text(), 'end session')]") public FluentWebElement endSession;

    public void fillAndSubmit(Application app) {

        isAt();
        clickNextAndWaitForSpinnerToFinish();
        if (app.getResumeApplication().equals(YES)){
            applicationId.getElement().getText();
            dtcApplicationId = applicationId.getElement().getText().replace("ID ","");
            app.getTestData().put("dtcApplicationId", dtcApplicationId);
            cancel.click();
            endSession.click();

        }

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start "));
    }

}
