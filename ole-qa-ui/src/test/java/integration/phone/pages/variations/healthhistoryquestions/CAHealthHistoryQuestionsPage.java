package integration.phone.pages.variations.healthhistoryquestions;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CAHealthHistoryQuestionsPage extends WizardPage {

    public void fillAndSubmit(Application app) {

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Health History Questions"));
    }
}
