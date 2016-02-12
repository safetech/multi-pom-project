package integration.dtc.dtcPages.oldOlePages;

import entity.Application;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResumeApplicationPage extends WizardPage {

    public void fillAndSubmit(Application app) {

        isAt();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Resume Application"));
    }

}
