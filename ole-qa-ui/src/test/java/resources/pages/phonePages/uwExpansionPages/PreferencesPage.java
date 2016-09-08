package resources.pages.phonepages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PreferencesPage extends WizardPage{


    private @FindBy(css = "#ElectronicDeliveryInd_1") FluentWebElement Online;
    private @FindBy(css = "#ElectronicDeliveryInd_2") FluentWebElement USMail;
    private @FindBy(css = "#EmailChange_1") FluentWebElement EmailChange_Yes;
    private @FindBy(css = "#EmailChange_2") FluentWebElement EmailChange_No;
    private @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[1]/input") FluentWebElement Email;

    private FluentWebElement ConfirmEmail;
    
    private FluentWebElement OnlinePreferenceSignature;
    
    public void fillAndSubmit(Application app){
        isAt();
        USMail.click();
        Online.click();

        EmailChange_No.click();
            assert(!Email.isDisplayed());

        EmailChange_Yes.click();
            Email.fill().with(app.getEmail());
        ConfirmEmail.fill().with(app.getEmail());
        
        OnlinePreferenceSignature.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Preferences"));
    }
}
