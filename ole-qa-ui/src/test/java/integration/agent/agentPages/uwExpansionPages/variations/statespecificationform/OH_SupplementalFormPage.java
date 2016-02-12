package integration.agent.agentPages.uwExpansionPages.variations.statespecificationform;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OH_SupplementalFormPage extends WizardPage {

    @FindBy(css = "#OH23010") FluentWebElement SS_FormDate;
    @FindBy(css = "#OH23020") FluentWebElement SS_Agent_PrintedName;
    @FindBy(css = "#OH23025") FluentWebElement SS_LicenseNumber;
    @FindBy(css = "#OH23035") FluentWebElement SS_StreetAddress;
    @FindBy(css = "#OH23040") FluentWebElement SS_City;
    @FindBy(css = "#OH23045") FluentWebElement SS_State;
    @FindBy(css = "#OH23050") FluentWebElement SS_Zip;
    @FindBy(css = "#OH23055") FluentWebElement SS_Phone;
    @FindBy(css = "#OH23065") FluentWebElement SS_App_PrintedName;
    @FindBy(css = "#OH23016Touch") FluentWebElement SS_App_Signature1;
    FluentWebElement OH23016;
    @FindBy(css = "#OH23061Touch") FluentWebElement SS_Agent_Signature1;
    FluentWebElement OH23061;

    public void fillAndSubmit(Application app) {

        isAt();
        fill(SS_FormDate).with(app.getSS_FormDate());

        OH23016.click();
        fillTouchSignature("OH23016Touch",  app.getSS_App_Signature1());

        fill(SS_App_PrintedName).with(app.getSS_App_PrintedName());
        fill(SS_Agent_PrintedName).with(app.getSS_Agent_PrintedName());
        fill(SS_LicenseNumber).with(app.getSS_LicenseNumber());
        fill(SS_StreetAddress).with(app.getSS_StreetAddress());
        fill(SS_City).with(app.getSS_City());
        (new Select(SS_State.getElement())).selectByValue(app.getSS_State());

        fill(SS_Zip).with(app.getSS_Zip());
        fill(SS_Phone).with(app.getSS_Phone());

        OH23061.click();
        fillTouchSignature("OH23061Touch", app.getSS_Agent_Signature1());

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Supplemental Form"));
    }
}
