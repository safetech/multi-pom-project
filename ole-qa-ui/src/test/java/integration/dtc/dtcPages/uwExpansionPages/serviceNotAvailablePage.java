package integration.dtc.dtcPages.uwExpansionPages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class serviceNotAvailablePage extends WizardPage {
    @FindBy(css = "div h2:first-of-type") protected FluentWebElement pageTitle;
    @FindBy(css = "#applicationId") FluentWebElement ApplicationId;
    @FindBy(css = "#DOB") FluentWebElement DOB;
    @FindBy(css = "#ZipCode") FluentWebElement ZipCode;
    @FindBy(xpath = "//a[contains(text(), 'resume application')]") public FluentWebElement ResumeApplication;

    public void fillAndSubmit(Application app) {

        isAt();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("We're sorry, the Online Enrollment Service is not available."));
    }

}
