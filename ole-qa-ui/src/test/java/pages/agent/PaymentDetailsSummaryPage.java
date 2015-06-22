package pages.agent;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentDetailsSummaryPage extends WizardPage{

    FluentWebElement BankName;
    FluentWebElement RoutingNumber;
    FluentWebElement RoutingNumberConfirm;
    FluentWebElement AccountNumber;
    FluentWebElement AccountNumberConfirm;
    @FindBy(css = "#AccountType_1") FluentWebElement AccountTypeChecking;
    FluentWebElement EftSignatureInd;
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
