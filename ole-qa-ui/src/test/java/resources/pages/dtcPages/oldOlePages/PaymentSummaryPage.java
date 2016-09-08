package resources.pages.dtcpages.oldOlePages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentSummaryPage extends WizardPage{

    
    private FluentWebElement RoutingNumber;
    private FluentWebElement RoutingNumberConfirm;
    private FluentWebElement AccountNumber;
    private FluentWebElement AccountNumberConfirm;
    private @FindBy(css = "#AccountType_1") FluentWebElement AccountTypeChecking;
    private  FluentWebElement EftSignatureInd;
    public void fillAndSubmit(Application app) {

        isAt();
        
        fill(RoutingNumber).with(app.getRoutingNumber());
        fill(RoutingNumberConfirm).with(app.getRoutingNumberConfirm());
        fill(AccountNumber).with(app.getAccountNumber());
        fill(AccountNumberConfirm).with(app.getAccountNumberConfirm());
        AccountTypeChecking.click();
        
        EftSignatureInd.click();
        clickNextAndWaitForSpinnerToFinish();
    }
    
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Payment Summary"));
    }
}
