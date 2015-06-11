package pages.phone.variations.authorizationandverification;

import entity.Application;
import pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NVAuthorizationAndVerificationPage extends WizardPage {

    @FindBy(css = "#UnderstandAuth_1") FluentWebElement UnderstandAuth_Yes;
    @FindBy(css = "#UnderstandAuth_2") FluentWebElement UnderstandAuth_No;
    @FindBy(name = "StateAux") FluentWebElement AuxState;
    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;
    FluentWebElement DesignateLapse;
    FluentWebElement FirstNameAux;
    FluentWebElement MiddleNameAux;
    FluentWebElement LastNameAux;
    FluentWebElement AddressLine1Aux;
    FluentWebElement CityAux;
    FluentWebElement StateAux;
    FluentWebElement ZipCodeAux;
    FluentWebElement PhoneNumberAux;

    FluentWebElement DesigneeSig;

    public void fillAndSubmit(Application app) {

        isAt();;

        UnderstandAuth_Yes.click();
        SignatureInd.click();
        MedicalReleaseAuthSignatureInd.click();

        if((app.getDesignateLapse()).equalsIgnoreCase("NO")) {
            fill(FirstNameAux).with(app.getAuxFirstName());
            fill(MiddleNameAux).with(app.geAuxtMI());
            fill(LastNameAux).with(app.getAuxLastName());
            fill(AddressLine1Aux).with(app.getAuxAddressLine1());
            fill(CityAux).with(app.getAuxCity());
            (new Select(AuxState.getElement())).selectByValue(app.getAuxState());
            fill(ZipCodeAux).with(app.getAuxZipCode());
            fill(PhoneNumberAux).with(app.getAuxPhonePrimary());

        }else if((app.getDesignateLapse()).equalsIgnoreCase("YES"))
            DesignateLapse.click();

        DesigneeSig.click();

        clickNextAndWaitForSpinnerToFinish();

    }
    private Select AuxState(Application app) {
        return new Select((WebElement) AuxState(app));
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}
