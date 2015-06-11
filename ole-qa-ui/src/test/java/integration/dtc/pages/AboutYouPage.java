package integration.dtc.pages;

import integration.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class AboutYouPage {
    @FindBy(css = "#na1110") FluentWebElement ConfirmEmail;

    public void verifyInitialStateOfElements(Application app) {
        //statements
    }

    public void fillAndSubmit(Application app) {
        //statements
    }
}
