package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerInformationPage extends WizardPage{

    FluentWebElement MedicareClaimNum;
    FluentWebElement MPAED;
    FluentWebElement MPBED;
    @FindBy(css = "#PartABActiveIndicator_1") FluentWebElement PartABActiveIndicator_Yes;
    @FindBy(css = "#PartABActiveIndicator_2") FluentWebElement PartABActiveIndicator_No;

    public void fillAndSubmit(Application app) {

        fill(MedicareClaimNum).with(app.getMedicareClaimNum());
        fill(MPAED).with(app.getMPAED());
        fill(MPBED).with(app.getMPBED());
        fillYesNoQuestion(PartABActiveIndicator_Yes, PartABActiveIndicator_No, app.getPartABActiveIndicator());

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Customer Information"));
    }
}
