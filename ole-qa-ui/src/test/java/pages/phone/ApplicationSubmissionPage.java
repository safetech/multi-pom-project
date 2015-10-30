package pages.phone;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApplicationSubmissionPage extends WizardPage {

    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement pageBorderContent;


    public void isApproved() {
        isAt();
        assertThat(pageBorderContent.getText(), containsString("APPROVED"));
    }
    public void isPending() {
        assertThat(pageBorderContent.getText(), containsString("PENDING"));
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Application Submission"));
    }

}
