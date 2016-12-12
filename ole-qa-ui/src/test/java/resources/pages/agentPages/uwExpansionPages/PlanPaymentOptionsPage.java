package resources.pages.agentpages.uwExpansionPages;

import com.relevantcodes.extentreports.LogStatus;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {
    @FindBy(css = "#PaymentChoice_1") FluentWebElement PaymentChoice_Eft;
    
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[6]/div[2]/input") FluentWebElement EFTOption;

    @FindBy(css = "#PaymentChoice_2") FluentWebElement AutomaticPayment;
    @FindBy(css = "#EFTType_1") FluentWebElement ReoccuringPayments;
    @FindBy(css = "#EFTType_2") FluentWebElement OneTimePayments;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[2]/input[1]") FluentWebElement EFT;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[6]/div[2]/input") FluentWebElement PaymentChoiceEFT;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[2]/input[2]") FluentWebElement CouponBook;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[4]/div[2]/input[1]") FluentWebElement EFTwithin40days;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[4]/div[2]/input[1]") FluentWebElement Couponwithin40days;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 5;
    //TODO: update this page
    public void  fillAndSubmit(Application app) {
        assert((find("input[type='text'], input[type='checkbox'], input[type='radio'], select").size()==4)||(find("input[type='text'], input[type='checkbox'], input[type='radio'], select").size()==5));
        app.getTest().log(LogStatus.INFO, "Question Count: "+String.valueOf(TOTAL_POSSIBLE_QUESTION_COUNT));
        isAt();
        app.getTest().log(LogStatus.INFO, "Page Checkpoint Passed");
        try {
            if(app.getPlanPaymentOptions().equals("Recurring")) {
                EFTwithin40days.click();
            }
            else if (app.getPlanPaymentOptions().equals("OneTime")){
                Couponwithin40days.click();
            }
        }
        catch (Exception e){
            
        }
        try {
            if(app.getPlanPaymentOptions().equals("Recurring")) {
                EFT.click();
                PaymentChoiceEFT.click();
            }
            else if (app.getPlanPaymentOptions().equals("OneTime")){
                CouponBook.click();
            }
        }
        catch (Exception e){
            
        }
        app.getTest().log(LogStatus.INFO, "Clicking Next..");
        clickNextAndWaitForSpinnerToFinish();
        }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }


}

