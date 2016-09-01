package resources.pages.agentpages.uwExpansionPages.variations.authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import resources.pages.WizardPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AuthorizationPage extends WizardPage{

    private FluentWebElement SignatureInd;
    FluentWebElement MedicalReleaseClaimSignatureInd;
    private FluentWebElement MedicalReleaseAuthSignatureInd;

    public void fillAndSubmit(Application app) {
        isAt();
        SignatureInd.click();
        fillTouchSignature("SignatureIndTouch",  app.getSignatureIndTouch());
<<<<<<< HEAD
        List<WebElement> mras=getDriver().findElements(By.id("MedicalReleaseAuthSignatureInd"));
        for(WebElement element: mras)
        {
            if(element.isDisplayed())
            {
                element.click();
                break;
            }
        }
        //MedicalReleaseAuthSignatureInd.click();
        fillTouchSignature("MedicalReleaseAuthSignatureIndTouch", app.getMedicalReleaseAuthSignatureIndTouch());
=======
>>>>>>> 2730e7d969363ceff842c9f5a537dc6a87283857

        if(app.getMedicalReleaseAuthSignatureIndRequired().equals("Required")){
            MedicalReleaseAuthSignatureInd.click();
            fillTouchSignature("MedicalReleaseAuthSignatureIndTouch",  app.getMedicalReleaseAuthSignatureIndTouch());
        }

        MedicalReleaseClaimSignatureInd.click();
        fillTouchSignature("MedicalReleaseClaimSignatureIndTouch",  app.getMedicalReleaseClaimSignatureIndTouch());
        clickNextAndWaitForSpinnerToFinish();
        
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Authorization"));
    }
}
