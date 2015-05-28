package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReviewAndSubmitPage extends WizardPage{

    public void fillAndSubmit(Application app) {

        isAt();
        nextButton.click();
        waitForSpinnerToFinish(20);

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Review and Submit"));
    }
}
