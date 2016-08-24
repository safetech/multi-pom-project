package resources.pages.agentpages.leanPages.variations;

import org.fluentlenium.core.domain.FluentWebElement;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IL_SupplementalFormPage extends WizardPage{
    
//    [, , , , , , , , , , , , , , , , , , , , , , , , , , , , , ]
   
   
    FluentWebElement IL23873;
    FluentWebElement IL23876;
    FluentWebElement IL23879;
    
    FluentWebElement IL23893;
    FluentWebElement IL23899;
    FluentWebElement IL23902;
    
    FluentWebElement IL23908;
    FluentWebElement IL23912;
    FluentWebElement IL23918;
    
    FluentWebElement IL23922;    
    FluentWebElement IL23925;
    FluentWebElement IL23927;
    
    FluentWebElement IL23930;
    FluentWebElement IL23932;
    FluentWebElement IL23940;
    
    FluentWebElement IL23944;
    FluentWebElement IL23950;
    FluentWebElement IL23952;
    
    FluentWebElement IL23954;
    FluentWebElement IL23960;    
    FluentWebElement IL23964;
    
    FluentWebElement IL23972;
    FluentWebElement IL23974;
    FluentWebElement IL23976;
    
    FluentWebElement IL23980;
    FluentWebElement IL23982;
    FluentWebElement IL23984;
    
    FluentWebElement IL23986;
    FluentWebElement IL23987;
    FluentWebElement IL23988;
    
    
    
    public void fillAndSubmit(){assertTextFieldCount(20);

        String allTextFieldIDs = find("div[class='form_row columns Centered'").getAttribute("Id");
        System.out.println(allTextFieldIDs);
    }


    protected void assertTextFieldCount(int expectedCount) {
        assertThat(find("input[type='text']").size(), equalTo(expectedCount));
    }


}
