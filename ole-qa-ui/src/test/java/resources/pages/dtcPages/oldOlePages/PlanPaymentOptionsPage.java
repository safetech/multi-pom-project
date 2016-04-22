package resources.pages.dtcpages.oldOlePages;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlanPaymentOptionsPage extends WizardPage {

    @FindBy(css = "#PaymentChoice_1") FluentWebElement CouponBook;
    @FindBy(css = "#PaymentChoice_1") FluentWebElement AutomaticPayment;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 5;


    public void fillAndSubmit(Application app) {

        isAt();

        CouponBook.click();

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Payment Options"));
    }
}

