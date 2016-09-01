package resources.pages.agentpages.uwExpansionPages;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.fluentlenium.core.domain.FluentWebElement;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {

<<<<<<< HEAD
    @FindBy(id = "#EFTType_1") WebElement EFT1;
    //@FindBy(css = "#EFTType_2") FluentWebElement EFT2;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 2;

=======
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[2]/input[1]") FluentWebElement EFT1;
    @FindBy(xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/div[5]/div[2]/input[2]") FluentWebElement EFT2;
>>>>>>> 2730e7d969363ceff842c9f5a537dc6a87283857

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 4;
    
    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        isAt();
        List<WebElement> EFT2=getDriver().findElements(By.id("EFTType_1"));
        for(int i=0;i<EFT2.size();i++)
        {
            WebElement temp=EFT2.get(i);
            if(temp.isDisplayed())
            {
                temp.click();
                break;
            }
        }

        //EFT1.click();

<<<<<<< HEAD

        
=======
        if(EFT1.isDisplayed()&& EFT2.isDisplayed()){
                EFT1.click();
        }
>>>>>>> 2730e7d969363ceff842c9f5a537dc6a87283857
        
        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }
    
<<<<<<< HEAD
    protected void assertQuestionCount(int expectedCount) {
        //assertThat(find("input[type='text'], input[type='checkbox'], input[type='radio'], select").size(), equalTo(expectedCount));

        List<String> x = find("input[type='radio']").getIds();
        //System.out.print( x );
        
        for(int i=0; i<x.size();i++){
            System.out.println( x.get( i ) );
        }
            
        
    }
=======
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
>>>>>>> 2730e7d969363ceff842c9f5a537dc6a87283857

    
}

