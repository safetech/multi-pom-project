package resources.pages.agentpages.uwExpansionPages;

import com.relevantcodes.extentreports.LogStatus;
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
    private FluentWebElement Email;
    private FluentWebElement PrefsConfirmEmail;
    private FluentWebElement OnlinePreferenceSignature;
    
    public void fillAndSubmit(Application app){
        isAt();
        app.getTest().log(LogStatus.INFO,"Page Checkpoint Passed");
        USMail.click();
        Online.click();

        EmailChange_No.click();
            assert(!Email.isDisplayed());

        EmailChange_Yes.click();
            Email.fill().with(app.getEmail());
            PrefsConfirmEmail.fill().with(app.getEmail());
        
        OnlinePreferenceSignature.click();
        fillTouchSignature("OnlinePreferenceSignatureTouch", app.getOnlinePreferenceSignatureTouch());
        
        app.getTest().log(LogStatus.INFO,"Clicking Next..");
        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Preferences"));
    }
}
