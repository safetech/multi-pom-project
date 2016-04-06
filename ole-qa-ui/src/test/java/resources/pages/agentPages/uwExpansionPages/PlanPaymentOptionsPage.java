package resources.pages.agentPages.uwExpansionPages;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {

    @FindBy(css = "#EFTType_1") FluentWebElement EFT1;
    @FindBy(css = "#EFTType_2") FluentWebElement EFT2;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 2;


    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        isAt();

        EFT1.click();

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }
}

