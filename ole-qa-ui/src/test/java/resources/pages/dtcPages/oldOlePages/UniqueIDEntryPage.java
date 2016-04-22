package resources.pages.dtcpages.oldOlePages;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniqueIDEntryPage extends WizardPage {

    @FindBy(css = "#applicationId") FluentWebElement ApplicationId;
    @FindBy(css = "#DOB") FluentWebElement DOB;
    @FindBy(css = "#ZipCode") FluentWebElement ZipCode;
    @FindBy(xpath = "//a[contains(text(), 'resume application')]") public FluentWebElement ResumeApplication;

    public void fillAndSubmit(Application app) {

        isAt();
        fill(ApplicationId).with((String)app.getTestData().get("dtcApplicationId"));
        fill(DOB).with(app.getDOBofPersonTurningAgeToday(69));
        fill(ZipCode).with("32065");
        ResumeApplication.click();
        waitForSpinnerToFinish(10);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Unique ID Entry"));
    }

}
