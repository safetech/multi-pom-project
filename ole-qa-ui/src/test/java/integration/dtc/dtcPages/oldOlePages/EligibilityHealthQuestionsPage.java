package integration.dtc.dtcPages.oldOlePages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EligibilityHealthQuestionsPage extends WizardPage {

    @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
    @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
    @FindBy(css = "#SurgeryNeeded_1") FluentWebElement SurgeryNeeded_Yes;
    @FindBy(css = "#SurgeryNeeded_2") FluentWebElement SurgeryNeeded_No;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 4;


    public void fillAndSubmit(Application app) {

        isAt();

        fillYesNoQuestion(ESRD_Yes, ESRD_No, app.getESRD());
        fillYesNoQuestion(SurgeryNeeded_Yes, SurgeryNeeded_No, app.getSurgeryNeeded());

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Eligibility Health Questions"));
    }
}

