package pages.agent.uwExpansion;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ReviewAndSubmitPage extends WizardPage {

    FluentWebElement requiredlink;
    @FindBy(css = "#page-title") protected FluentWebElement pageTitle;
    @FindBy(css = "#pageborder") protected FluentWebElement applicationStatus;

    public void fillAndSubmit(Application app) {

        isAt();
        requiredlink.click();
            closeSpecificBrowser(1);

        click(WIZARD_PAGE_NEXT_BTN_SELECTOR);
        await().atMost(30, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }

    public void closeSpecificBrowser(int Brow){
        ArrayList<String> windows = new ArrayList<String> (getDriver().getWindowHandles());
        String baseWindowHdl = getDriver().getWindowHandle();
        getDriver().switchTo().window(windows.get(Brow));
        getDriver().close();
        getDriver().switchTo().window(baseWindowHdl);
    }

}
