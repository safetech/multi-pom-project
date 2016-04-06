package resources.pages.agentPages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApplicationSubmissionPage extends WizardPage {

    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(xpath = "//form/section/div[*]/div[*]/p[1]/span/b") protected FluentWebElement applicationStatus;


    public void isApproved() {
        assertThat(applicationStatus.getText(), containsString("APPROVED"));
    }
    public void isPending() { assertThat(applicationStatus.getText(), containsString("PENDING"));}
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Application Submission"));
    }

}
