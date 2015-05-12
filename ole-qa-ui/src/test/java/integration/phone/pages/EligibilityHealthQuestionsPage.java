package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EligibilityHealthQuestionsPage extends WizardPage{

    @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
    @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
    @FindBy(css = "#SurgeryNeeded_1") FluentWebElement SurgeryNeeded_Yes;
    @FindBy(css = "#SurgeryNeeded_2") FluentWebElement SurgeryNeeded_No;

    public void fillAndSubmit(Application app) {
        fillYesNoQuestion(ESRD_Yes, ESRD_No, app.getESRD());
        fillYesNoQuestion(SurgeryNeeded_Yes, SurgeryNeeded_No, app.getSurgeryNeeded());
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Eligibility Health Questions"));
    }
}
