package resources.pages.agentpages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {
    @FindBy(css = "#PaymentChoice_1") FluentWebElement EFT1;
    @FindBy(css = "#PaymentChoice_2") FluentWebElement CouponBook;
    @FindBy(css = "#EFTType_1") FluentWebElement EFTOption;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 5;
    
    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        isAt();
        if(EFT1.isDisplayed() && CouponBook.isDisplayed()){
                EFT1.click();
        }
        
        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }

}

