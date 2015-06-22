package pages.agent;


import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReviewAndSubmitPage extends WizardPage {

    FluentWebElement requiredlink;

    public void fillAndSubmit(Application app) {

        isAt();

        requiredlink.click();

        click(WIZARD_PAGE_NEXT_BTN_SELECTOR);

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Review and Submit"));
    }

}
