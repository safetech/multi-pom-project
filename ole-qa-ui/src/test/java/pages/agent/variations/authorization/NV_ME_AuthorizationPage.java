package pages.agent.variations.authorization;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NV_ME_AuthorizationPage extends WizardPage {

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

        SignatureInd.click();
        fillTouchSignature("SignatureIndTouch",  app.getSignatureIndTouch());
        MedicalReleaseAuthSignatureInd.click();
        fillTouchSignature("MedicalReleaseAuthSignatureIndTouch", app.getMedicalReleaseAuthSignatureIndTouch());
        DesigneeSig.click();
        fillTouchSignature("DesigneeSigTouch", app.getDesigneeSigTouch());

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }

}