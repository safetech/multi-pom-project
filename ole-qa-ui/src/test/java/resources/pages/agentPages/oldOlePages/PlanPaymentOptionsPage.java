package resources.pages.agentpages.oldOlePages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;
import resources.utils.DateUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {

    @FindBy(css = "#EFTType_1") FluentWebElement EFT1;
    @FindBy(css = "#EFTType_2") FluentWebElement EFT2;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[2]/div/div[1]/aside/div/p[6]/b") FluentWebElement RequestedEffectiveDate;
    @FindBy(css = "#PaymentChoice_1") FluentWebElement PaymentChoice_Eft;
    @FindBy(css = "#PaymentChoice_2") FluentWebElement PaymentChoice_CouponBook;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[6]/div[2]/input") FluentWebElement EFTOption;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 4;

    public void fillAndSubmit(Application app) {

        
        long days=TimeUnit.DAYS.convert((new Date(DateUtils.customizeDaysInNormalForat(29)).getTime()-new Date(RequestedEffectiveDate.getText()).getTime() ),TimeUnit.MILLISECONDS);
        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
         
        if(days < 45){
            EFT1.click();
         }else{
           if(PaymentChoice_Eft.isDisplayed() && PaymentChoice_CouponBook.isDisplayed()){
             PaymentChoice_Eft.click();
             if(PaymentChoice_Eft.isSelected()){
                 EFTOption.click();
             }else{
                 assert(!EFTOption.isDisplayed());
             }
            }
         }

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }
}

