package integration.phone.phonePages.oldOlePages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.ui.Select;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanSelectionAndStartDatePage extends WizardPage {

    FluentWebElement ReqEffectiveDate;

    public void fillAndSubmit(Application app) {

        isAt();
        getPlanCodeRadio(app.getPlanCode()).click();
        //getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());

        clickNextAndWaitForSpinnerToFinish();
    }

    private FluentWebElement getPlanCodeRadio(String planCode) {
        return findFirst(String.format("input[type='radio'][name='planCode'][value='%s']", planCode));
    }

    private Select getReqEffectiveDateSelect() {
        return (new Select(ReqEffectiveDate.getElement()));
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start Date"));
    }
}
