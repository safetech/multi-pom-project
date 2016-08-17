package resources.pages.agentpages.uwExpansionPages;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentDetailsSummaryPage extends WizardPage{

    private FluentWebElement BankName;
    private FluentWebElement RoutingNumber;
    private FluentWebElement RoutingNumberConfirm;
    private FluentWebElement AccountNumber;
    private FluentWebElement AccountNumberConfirm;
    private @FindBy(css = "#AccountType_1") FluentWebElement AccountTypeChecking;
    private  FluentWebElement EftSignatureInd;
    public void fillAndSubmit(Application app) {

        isAt();

        fill(BankName).with(app.getBankName());
        fill(RoutingNumber).with(app.getRoutingNumber());
        fill(RoutingNumberConfirm).with(app.getRoutingNumberConfirm());
        fill(AccountNumber).with(app.getAccountNumber());
        fill(AccountNumberConfirm).with(app.getAccountNumberConfirm());
        
        AccountTypeChecking.click();
        EftSignatureInd.click();
        fillTouchSignature("EftSignatureIndTouch", app.getEftSignatureIndTouch());
        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Payment Details Summary"));
    }
}
