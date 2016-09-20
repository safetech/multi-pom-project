package resources;

import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;
import resources.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class playGroundForTestingMethods extends WizardPage{

    @FindBy(xpath = "html/body/div[2]/div[1]/div[2]/div/div[1]/aside/div/p[6]/b")
    FluentWebElement RequestedEffectiveDate;
    @Test
   public void CodingExercise() {
//        List<String> s1 = new ArrayList<String>();
//        s1.add("Joe");
//        s1.add("Kapil");
//        s1.add("danush");
//
//        List<String> s2 = Arrays.asList("Joe", "Kapil", "Sunil","hjgjghjgj");
////
//        if (s1.get(0).equals(s2.get(0))) {
//            System.out.print(s1.get(0));
//        }
//

//
//        int i = 0;
//        int j = 0;
//        while (i < s1.size() && j < s2.size()) {
//
//            if (s1.get(i).equals(s2.get(j))) {
//                System.out.print(s1.get(i));
//            } else
//                System.out.print(s2.get(j)+s1.get(i));
//            i++;
//            j++;
//        }


//        List<String> arrayList1= Arrays.asList("Joe", "kapil","danush");
//        List<String> arrayList2 = Arrays.asList("Joe", "kapil","Sunil");
//        
//        List<String> commonElements = new ArrayList<String>(arrayList1);
//        commonElements.retainAll(arrayList2);
//        System.out.println("common elements -> "+commonElements);
//        
//        List<String> uniqueElementsInFirstList = new ArrayList<String>(arrayList1);
//        uniqueElementsInFirstList.removeAll(arrayList2);
//        System.out.println("unique elements in first list ->"+ uniqueElementsInFirstList);
//   

        long days= TimeUnit.DAYS.convert((new Date(DateUtils.customizeDaysInNormalForat(29)).getTime()-new Date(RequestedEffectiveDate.getText()).getTime() ),TimeUnit.MILLISECONDS);
        System.out.println(days);
        
        
//        System.out.print(resources.utils.DateUtils.getDOBofPersonTurningAgeToday(65));
        assertTextFieldCount(31);

        List<String> x = find("div[class='form_row columns Centered']").find("input[type='text']").getAttributes("id");
        System.out.println(x);

    }


        public void assertTextFieldCount(int expectedCount) {
            assertThat(find("input[type='text']").size(), equalTo(expectedCount));
        }
        
    
}
            

        
        

        
    
    
    

