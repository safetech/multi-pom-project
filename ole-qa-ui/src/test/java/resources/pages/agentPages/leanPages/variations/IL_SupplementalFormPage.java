package resources.pages.agentpages.leanPages.variations;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IL_SupplementalFormPage extends WizardPage{

    private @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    private @FindBy(css = "#IL23873") FluentWebElement ApplicantsName;
    private @FindBy(css = "#IL23876") FluentWebElement CertificateNumber;
    private @FindBy(css = "#IL23879") FluentWebElement NameOfExistingInsurer;
    private @FindBy(css = "#IL23881") FluentWebElement ExpirationDateOfExistingInsurance;
    
    private @FindBy(css = "#IL23893") FluentWebElement Benefits60Days_ExistingCoverage;
    private @FindBy(css = "#IL23899") FluentWebElement AARPMedicareSupplementPays;
    private @FindBy(css = "#IL23902") FluentWebElement Benefits60Days_YouPay;
    
    private @FindBy(css = "#IL23908") FluentWebElement Benefits61To90_ExistingCoverage;
    private @FindBy(css = "#IL23912") FluentWebElement Benefits61To90_AarpYouPay;

    private @FindBy(css = "#IL23918") FluentWebElement Benefits91To150_ExistingCoverage;
    private @FindBy(css = "#IL23922") FluentWebElement Benefits91To150_YouPay;
    
    private @FindBy(css = "#IL23925") FluentWebElement Benefits151To365_ExistingCoverage;
    private @FindBy(css = "#IL23927") FluentWebElement Benefits151To365_YouPay;
    
    private @FindBy(css = "#IL23930") FluentWebElement Beyond365_ExistingCoverage;
    private @FindBy(css = "#IL23932") FluentWebElement Beyond365_YouPay;

    private @FindBy(css = "#IL23940") FluentWebElement First20_ExistingCoverage;
    private @FindBy(css = "#IL23944") FluentWebElement First20_YouPay;

    private @FindBy(css = "#IL23950") FluentWebElement Additional80_ExstingCoverage;
    private @FindBy(css = "#IL23952") FluentWebElement Additional80_AarpMedSuppPays;
    private @FindBy(css = "#IL23954") FluentWebElement Additional80_YouPay;

    private @FindBy(css = "#IL23960") FluentWebElement Beyond100_ExistingCoverage;
    private @FindBy(css = "#IL23964") FluentWebElement Beyond100_YouPay;
    
    private @FindBy(css = "#IL23972") FluentWebElement MedicalExpense_ExistingCoverage;
    private @FindBy(css = "#IL23974") FluentWebElement MedicalExpense_AarpMedSuppPays;
    private @FindBy(css = "#IL23976") FluentWebElement MedicalExpense_YouPay;
        
    private @FindBy(css = "#IL23980") FluentWebElement PrescriptionDrugs_Benefits;
    private @FindBy(css = "#IL23982") FluentWebElement PrescriptionDrugs_ExistingCoverage;
    private @FindBy(css = "#IL23984") FluentWebElement PrescriptionDrugs_YouPay;
    
    private @FindBy(css = "#IL23986") FluentWebElement PrescriptionMedicare_ExistingCoverage;
    private @FindBy(css = "#IL23987") FluentWebElement PrescriptionMedicare_AarpMedSuppPays;
    private @FindBy(css = "#IL23988") FluentWebElement PrescriptionMedicare_YouPay;
    
    
    private @FindBy(css = "#IL23991") FluentWebElement IL23991Touch;
    private @FindBy(css = "#IL23993") FluentWebElement IL23993Touch;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 33;
    public void fillAndSubmit(Application app){
        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        
        fill(ApplicantsName).with("ApplicantsName");
        fill(CertificateNumber).with("01212121");
        fill(NameOfExistingInsurer).with("NameOfExistingInsurer");      
        fill(ExpirationDateOfExistingInsurance).with("05/05/5454");
        
        fill(Benefits60Days_ExistingCoverage).with("Benefits60Days_ExistingCoverage");
        fill(AARPMedicareSupplementPays).with("1000");
        fill(Benefits60Days_YouPay).with("60");

        fill(Benefits61To90_ExistingCoverage).with( "Benefits61To90_ExistingCoverage" );
        fill(Benefits61To90_AarpYouPay).with("61-90");

        fill(Benefits91To150_ExistingCoverage).with("Benefits91To150_ExistingCoverage");
        fill(Benefits91To150_YouPay).with("91-155");

        fill(Benefits151To365_ExistingCoverage).with("Benefits151To365_ExistingCoverage");
        fill(Benefits151To365_YouPay).with("$630.00");        
        
        fill(Beyond365_ExistingCoverage).with("Beyond365_ExistingCoverage");
        fill(Beyond365_YouPay).with("365");

        fill(First20_ExistingCoverage).with("First20_ExistingCoverage");
        fill(First20_YouPay).with("00000");        
        
        fill(Additional80_ExstingCoverage).with("Additional80_ExstingCoverage");
        fill(Additional80_AarpMedSuppPays).with("Additional80_AarpMedSuppPays");
        fill(Additional80_YouPay).with("+80");

        fill(Beyond100_ExistingCoverage).with("Beyond100_ExistingCoverage");
        fill(Beyond100_YouPay).with("100 +");

        fill(MedicalExpense_ExistingCoverage).with("MedicalExpense_ExistingCoverage");
        fill(MedicalExpense_AarpMedSuppPays).with("MedicalExpense_AarpMedSuppPays");
        fill(MedicalExpense_YouPay).with("9010");        
        
        fill(PrescriptionDrugs_Benefits).with("PrescriptionDrugs_Benefits");
        fill(PrescriptionDrugs_ExistingCoverage).with("PrescriptionDrugs_ExistingCoverage");
        fill(PrescriptionDrugs_YouPay).with("900000000000");

        fill(PrescriptionMedicare_ExistingCoverage).with("PrescriptionMedicare_ExistingCoverage");
        fill(PrescriptionMedicare_AarpMedSuppPays).with("PrescriptionMedicare_AarpMedSuppPays");
        fill(PrescriptionMedicare_YouPay).with("01010100000");

        IL23991Touch.click();
        fillTouchSignature("IL23991Touch", app.getIL23991Touch());        
        
        IL23993Touch.click();
        fillTouchSignature("IL23993Touch", app.getIL23993Touch());
        
        clickNextAndWaitForSpinnerToFinish();

    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Supplemental Form"));
    }

}
