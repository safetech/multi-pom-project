package pages.agent.variations.authorization;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NV_AuthorizationPage extends WizardPage {

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

        String AppSig1 = "{\"lines\":[[[25,25.73],[25,26.73],[26,26.73],[28,26.73],[29,26.73],[31,26.73],[32,26.73],[33,26.73],[34,26.73],[34,26.73],[36,26.73],[36,26.73],[37,26.73],[38,26.73],[39,26.73],[40,26.73],[41,26.73],[42,26.73],[42,26.73],[43,26.73],[44,26.73],[46,26.73],[47,26.73],[47,26.73],[48,26.73],[49,26.73],[50,26.73],[51,26.73],[52,26.73],[52,26.73],[54,26.73],[54,26.73],[55,26.73],[56,26.73],[57,26.73],[58,26.73],[59,26.73],[60,26.73],[60,26.73],[62,26.73],[63,26.73],[64,26.73]],[[46,29.73],[46,30.73],[46,31.73],[46,32.73],[46,33.73],[47,33.73],[47,34.73],[47,35.73],[47,36.73],[47,37.73],[48,37.73],[48,38.73],[48,39.73],[48,39.73],[48,40.73],[49,40.73],[49,41.73],[49,42.73],[49,43.73],[49,44.73],[49,45.73],[49,46.73],[49,47.73],[49,48.73],[49,48.73],[49,49.73],[49,50.73],[49,51.73],[49,52.73],[49,53.73],[49,53.73],[49,55.73],[49,55.73],[49,56.73],[49,57.73],[49,58.73],[49,59.73]],[[67,53.73],[68,53.73],[69,53.73],[70,53.73],[71,53.73],[72,53.73],[73,53.73],[74,52.73],[75,52.73],[76,52.73],[77,51.73],[78,50.73],[79,50.73],[79,49.73],[79,48.73],[79,47.73],[79,46.73],[79,45.73],[78,44.73],[77,44.73],[76,44.73],[75,44.73],[74,44.73],[73,44.73],[73,44.73],[72,44.73],[71,44.73],[70,44.73],[69,44.73],[68,44.73],[67,45.73],[66,45.73],[66,46.73],[65,47.73],[65,48.73],[65,49.73],[65,49.73],[65,50.73],[65,52.73],[65,52.73],[65,53.73],[66,53.73],[66,54.73],[67,55.73],[67,56.73],[68,56.73],[68,57.73],[69,57.73],[70,57.73],[70,58.73],[71,58.73],[73,58.73],[74,58.73],[77,59.73],[79,59.73],[80,59.73],[81,59.73],[82,59.73],[83,59.73],[84,59.73],[85,59.73],[86,59.73],[87,59.73],[88,59.73],[89,59.73]],[[102,58.73],[103,58.73],[103,57.73],[104,57.73],[105,56.73],[106,56.73],[107,55.73],[108,54.73],[110,53.73],[111,52.73],[113,51.73],[113,50.73],[114,49.73],[115,48.73],[116,47.73],[116,46.73],[117,44.73],[118,43.73],[118,42.73],[119,41.73],[119,39.73],[119,38.73],[119,37.73],[118,36.73],[118,36.73],[117,36.73],[115,35.73],[114,35.73],[111,35.73],[110,35.73],[110,35.73],[109,36.73],[109,37.73],[109,38.73],[109,39.73],[109,39.73],[110,39.73],[111,40.73],[113,41.73],[115,42.73],[118,43.73],[121,43.73],[123,44.73],[124,46.73],[124,47.73],[125,47.73],[125,48.73],[125,49.73],[125,50.73],[125,51.73],[125,52.73],[125,53.73],[124,53.73],[123,53.73],[121,54.73],[119,54.73],[117,54.73],[116,54.73],[115,54.73],[114,54.73],[113,54.73]],[[137,17.73],[137,18.73],[137,19.73],[137,20.73],[138,22.73],[138,23.73],[139,25.73],[139,26.73],[140,27.73],[140,29.73],[141,30.73],[141,32.73],[141,33.73],[141,35.73],[141,36.73],[141,39.73],[142,40.73],[142,41.73],[142,43.73],[142,44.73],[142,45.73],[142,46.73],[143,48.73],[143,49.73],[143,50.73],[143,51.73],[143,52.73],[144,53.73],[144,54.73],[145,55.73],[147,55.73],[148,56.73],[149,56.73],[150,56.73],[152,56.73],[153,56.73],[155,56.73],[157,56.73],[158,56.73],[160,54.73],[162,53.73],[163,52.73],[164,51.73]],[[132,33.73],[133,33.73],[134,33.73],[138,33.73],[141,33.73],[143,33.73],[145,33.73],[146,33.73],[147,33.73],[149,33.73],[151,33.73],[153,33.73],[154,33.73],[155,33.73],[156,33.73],[157,33.73],[157,33.73],[158,33.73],[159,33.73],[160,33.73]]]}";
        SignatureInd.click();
        executeScript("$('#SignatureIndTouch').signature('draw'," + AppSig1 + ")");

        MedicalReleaseAuthSignatureInd.click();
        executeScript("$('#MedicalReleaseAuthSignatureIndTouch').signature('draw'," + AppSig1 + ")");

        DesigneeSig.click();
        executeScript("$('#DesigneeSigTouch').signature('draw',"+AppSig1+")");

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
