package resources.pages.agentpages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {

    @FindBy(css = "#EFTType_1") FluentWebElement EFT1;
    @FindBy(css = "#EFTType_2") FluentWebElement EFT2;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 2;


    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        isAt();

        EFT1.click();

        
        
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }
    
    protected void assertQuestionCount(int expectedCount) {
        //assertThat(find("input[type='text'], input[type='checkbox'], input[type='radio'], select").size(), equalTo(expectedCount));

        List<String> x = find("input[type='text'], input[type='checkbox'], input[type='radio'], select").getAttributes("id");
        System.out.print( x );
        
        for(int i=0; i<x.size();i++){
            System.out.print( x.get( i ) );
        }
            
        
    }

}

