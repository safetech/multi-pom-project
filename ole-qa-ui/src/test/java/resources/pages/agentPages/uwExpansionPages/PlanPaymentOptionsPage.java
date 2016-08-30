package resources.pages.agentpages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {

    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[2]/input[1]") FluentWebElement EFT1;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[2]/input[2]") FluentWebElement EFT2;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 4;
    
    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        isAt();

        if(EFT1.isDisplayed()&& EFT2.isDisplayed()){
                EFT1.click();
        }
        
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }
    
//    protected void assertQuestionCount(int expectedCount) {
//        //assertThat(find("input[type='text'], input[type='checkbox'], input[type='radio'], select").size(), equalTo(expectedCount));
//
////        List<String> x = find("input[type='text'], input[type='checkbox'], input[type='radio'], select").getAttributes("id");
////        System.out.print( x );
////        
////        for(int i=0; i<x.size();i++){
////            System.out.print( x.get( i ) );
////        }
////            
//        
//    }

    
}

