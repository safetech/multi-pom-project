package resources.pages.agentpages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {
    @FindBy(css = "#PaymentChoice_1") FluentWebElement PaymentChoice_Eft;
    @FindBy(css = "#PaymentChoice_2") FluentWebElement PaymentChoice_CouponBook;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[6]/div[2]/input") FluentWebElement EFTOption;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 5;
    
    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        isAt();
        if(PaymentChoice_Eft.isDisplayed() && PaymentChoice_CouponBook.isDisplayed()){
                PaymentChoice_Eft.click();
            if(PaymentChoice_Eft.isSelected()){
                EFTOption.click();
            }else{
                assert(!EFTOption.isDisplayed());
            }
                
        }
        
        
        
        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }

}

