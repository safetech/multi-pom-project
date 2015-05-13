package integration.phone.pages.variations.pastandcurrentcoverage;

import integration.phone.entity.Application;
import integration.phone.pages.PlanApplicationQuestions;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class PAPlanApplicationQuestions extends PlanApplicationQuestions {

    @FindBy(css = "#LostCoverage_1") FluentWebElement LostCoverage_Yes;
    @FindBy(css = "#LostCoverage_2") FluentWebElement LostCoverage_No;

    public void fillAndSubmit(Application app) {

        fillYesNoQuestion(LostCoverage_Yes, LostCoverage_No, app.getLostCoverage());
        fillYesNoQuestion(TobaccoUse_Yes, TobaccoUse_No, app.getTobaccoUse());

        clickNextAndWaitForSpinnerToFinish();
    }
}
