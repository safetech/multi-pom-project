package integration.agent.agentPages.uwExpansionPages.variations.statespecificationform;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupplementalFormPage extends WizardPage {

    @FindBy(css = "#FL23830") FluentWebElement SS_FormDate;
    @FindBy(css = "#FL23841Touch") FluentWebElement SS_App_Signature1;
    @FindBy(css = "#FL23846Touch") FluentWebElement SS_Agent_Signature1;
    FluentWebElement FL23841;
    FluentWebElement FL23846;

    @FindBy(css = "#FL23850")  FluentWebElement AgencyName;
    @FindBy(css = "#FL23855")  FluentWebElement AgencyAddress;
    @FindBy(css = "#FL23860")  FluentWebElement AgencyPhone;
    FluentWebElement ApplicantAddress;

    public void fillAndSubmit(Application app) {

        isAt();
        fill(SS_FormDate).with(app.getSS_FormDate());

        FL23841.click();
        fillTouchSignature("FL23841Touch",  app.getSS_App_Signature1());
        FL23846.click();
        fillTouchSignature("FL23846Touch", app.getSS_Agent_Signature1());

        fill(AgencyName).with(app.getAgencyName());
        fill(AgencyAddress).with(app.getAgencyAddress());
        fill(AgencyPhone).with(app.getAgencyPhone());

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Supplemental Form"));
    }
}
