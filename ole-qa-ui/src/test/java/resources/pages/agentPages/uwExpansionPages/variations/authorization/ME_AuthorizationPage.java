package resources.pages.agentpages.uwExpansionPages.variations.authorization;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ME_AuthorizationPage extends WizardPage {

    @FindBy(name = "StateAux") FluentWebElement AuxState;
    FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseAuthSignatureInd;
    FluentWebElement DesignateLapse;
    FluentWebElement FirstNameAux;
    FluentWebElement MiddleNameAux;
    FluentWebElement LastNameAux;
    FluentWebElement AddressLine1Aux;
    FluentWebElement CityAux;
    FluentWebElement ZipCodeAux;
    FluentWebElement PhoneNumberAux;
    FluentWebElement DesigneeSig;


    public void fillAndSubmit(Application app) {

        isAt();
        SignatureInd.click();
        fillTouchSignature("SignatureIndTouch", app.getSignatureIndTouch());

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
        fillTouchSignature("DesigneeSigTouch", app.getDesigneeSigTouch());

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }

}
