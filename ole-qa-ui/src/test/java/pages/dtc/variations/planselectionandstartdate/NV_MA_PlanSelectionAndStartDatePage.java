package pages.dtc.variations.planselectionandstartdate;

import entity.Application;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NV_MA_PlanSelectionAndStartDatePage extends WizardPage{

    public void fillAndSubmit(Application app) {

        isAt();

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start Date"));
    }
}
