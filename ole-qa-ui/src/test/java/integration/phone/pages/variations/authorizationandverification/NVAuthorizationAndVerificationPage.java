package integration.phone.pages.variations.authorizationandverification;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NVAuthorizationAndVerificationPage extends WizardPage{

    @FindBy(css = "#UnderstandAuth_1") FluentWebElement UnderstandAuth_Yes;
    @FindBy(css = "#UnderstandAuth_2") FluentWebElement UnderstandAuth_No;
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
            click("option", withText(app.getAuxState()));
            fill(ZipCodeAux).with(app.getAuxZipCode());
            fill(PhoneNumberAux).with(app.getAuxPhonePrimary());

        }else if((app.getDesignateLapse()).equalsIgnoreCase("YES"))
            DesignateLapse.click();

        DesigneeSig.click();

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization and Verification"));
    }
}
