package resources.pages.agentpages.leanPages.variations;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IL_EligibilityHealthQuestionsPage extends WizardPage {

    @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
    @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
    @FindBy(css = "#SurgeryNeeded_1") FluentWebElement SurgeryNeeded_Yes;
    @FindBy(css = "#SurgeryNeeded_2") FluentWebElement SurgeryNeeded_No;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 4;

    public void verifyInitialStateOfElements(Application app) {
        assertBlank(ESRD_Yes, ESRD_No, SurgeryNeeded_Yes, SurgeryNeeded_No);
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {

        isAt();

        verifyInitialStateOfElements(app);

        fillYesNoQuestion(ESRD_Yes, ESRD_No, app.getESRD());
        fillYesNoQuestion(SurgeryNeeded_Yes, SurgeryNeeded_No, app.getSurgeryNeeded());

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {

        assertVisible(ESRD_Yes,
            ESRD_No,
            SurgeryNeeded_Yes,
            SurgeryNeeded_No);
        assertYesNoQuestion(ESRD_Yes, ESRD_No, app.getESRD());
        assertYesNoQuestion(SurgeryNeeded_Yes, SurgeryNeeded_No, app.getSurgeryNeeded());

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Eligibility Health Questions"));
    }
}

