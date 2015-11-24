package pages.dtc.uwExpansion;

import entity.dtc.CribSheet;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanSelectionAndStartDatePage extends WizardPage{
    @FindBy(xpath = "//*[@id='block']/div[3]/h3") protected FluentWebElement planStartDate;

    public void fillAndSubmit(CribSheet sheet) {

        isAt();

        assertThat(planStartDate.getElement().getText(), equalTo((sheet.getPsd())));

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start Date"));
    }
}
