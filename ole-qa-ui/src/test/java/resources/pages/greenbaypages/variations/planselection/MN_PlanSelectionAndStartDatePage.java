package resources.pages.greenbaypages.variations.planselection;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.entity.Application;
import resources.pages.WizardPage;
import resources.utils.DateUtils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MN_PlanSelectionAndStartDatePage extends WizardPage {

    FluentWebElement ReqEffectiveDate;
    @FindBy(xpath = "planCode_1") FluentWebElement BasicPlan;
    @FindBy(xpath = "planCode_2") FluentWebElement ExtendedBasicPlan;
    @FindBy(css = "#RiderChoiceXW") FluentWebElement Rider1;
    @FindBy(css = "#RiderChoiceYW") FluentWebElement Rider2;
    @FindBy(css = "#RiderChoiceVW") FluentWebElement Rider3;
    @FindBy(css = "#RiderChoiceWW") FluentWebElement Rider4;
    @FindBy(css = "#RiderChoiceZW") FluentWebElement Rider5;

    public void fillAndSubmit(Application app) {

        isAt();
        if (app.getPlanCode().equals("TW")) {
            getPlanCodeRadio(app.getPlanCode()).click();
            getRiderCodeCheckbox(app.getRider1()).click();
            getRiderCodeCheckbox(app.getRider2()).click();
        }else if (app.getPlanCode().equals("UW")) {
            getPlanCodeRadio(app.getPlanCode()).click();
        }

        getReqEffectiveDateSelect().selectByValue(app.getReqEffectiveDate());
        availableDesiredPlanStartDates(app.getExpectedReqEffectiveDates());
        
        clickNextAndWaitForSpinnerToFinish();
    }

    private FluentWebElement getPlanCodeRadio(String planCode) {
        return findFirst(String.format("input[type='radio'][name='planCode'][value='%s']", planCode));
    }
    private FluentWebElement getRiderCodeCheckbox(String planCode) {
        return findFirst(String.format("input[type='checkbox'][data-parentplan='TW'][value='%s']", planCode));
    }
    private Select getReqEffectiveDateSelect() {
        return (new Select(ReqEffectiveDate.getElement()));
    }    

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Plan Selection and Start Date"));
    }    
    
    private void availableDesiredPlanStartDates(Integer expectedAvailableDates) {
        FluentList<FluentWebElement> startDateOptions = find("#ReqEffectiveDate > option");
       if(expectedAvailableDates == startDateOptions.size()){
        switch (expectedAvailableDates) {
            case 6:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(1)));
                assertThat(startDateOptions.get(1).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(2)));
                assertThat(startDateOptions.get(2).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(3)));
                assertThat(startDateOptions.get(3).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(4)));
                assertThat(startDateOptions.get(4).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(5)));
                assertThat(startDateOptions.get(5).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(6)));
                break;
            case 5:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(1)));
                assertThat(startDateOptions.get(1).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(2)));
                assertThat(startDateOptions.get(2).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(3)));
                assertThat(startDateOptions.get(3).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(4)));
                assertThat(startDateOptions.get(4).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(5)));
                break;
            case 4:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(1)));
                assertThat(startDateOptions.get(1).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(2)));
                assertThat(startDateOptions.get(2).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(3)));
                assertThat(startDateOptions.get(3).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(4)));
                break;
            case 3:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(1)));
                assertThat(startDateOptions.get(1).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(2)));
                assertThat(startDateOptions.get(2).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(3)));
                break;
            case 2:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(1)));
                assertThat(startDateOptions.get(1).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(2)));
                break;
            case 1:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(1)));
                break;
            case 0:
                assertThat(startDateOptions.get(0).getValue(), equalTo(DateUtils.getFirstDayOfPastOrFutureMonths(0)));
                break;
            default:
                System.out.print("Not found");
                break;
            }
        }else {
          assertThat(startDateOptions.size(), equalTo(expectedAvailableDates));
       }
    }
}

