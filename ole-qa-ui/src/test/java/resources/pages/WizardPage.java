package resources.pages;

import com.github.javafaker.Faker;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import resources.utils.AnswerUtils;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class WizardPage extends FluentPage {
    public Faker faker;
    protected final static String NO = AnswerUtils.NO;
    protected final static String YES = AnswerUtils.YES;
    protected final static String UNSURE = AnswerUtils.UNSURE;
    protected final static String BLANK = AnswerUtils.BLANK;

    @FindBy(css = "section h3:first-of-type") protected FluentWebElement pageTitle;


    public FluentWebElement ZipCode;
    public FluentWebElement DOB;
    public FluentWebElement MPBED;
    public String dtcApplicationId = "";



    public void setCommonCustomerInformation(String commonCustomerInformation) {
        this.commonCustomerInformation = commonCustomerInformation;
    }

    public String commonCustomerInformation = "";

    public String getDtcApplicationId() {
        return this.dtcApplicationId;
    }    


    public void setDtcApplicationId(String dtcApplicationId) {
        this.dtcApplicationId = dtcApplicationId;
    }


    @FindBy(css = "a.action_next")
    public FluentWebElement nextButton;
    public FluentWebElement resume;
    public void blur(String selector){
        executeScript("$('"+selector+"').blur()");
    }


    private String TEXT_SUB_SELECTOR = "span[data-textsub-id='%s']";
    public String WIZARD_PAGE_NEXT_BTN_SELECTOR = "a.action_next";

    protected void waitForSpinnerToFinish() {
        waitForSpinnerToFinish(10);
    }

    protected void waitForSpinnerToFinish(int seconds) {
        await().atMost(seconds, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }

    protected void fillYesNoQuestion(FluentWebElement yesRadio, FluentWebElement noRadio, String answer) {
        if(answer.equals(YES)) {
            yesRadio.click();
        }
        if(answer.equals(NO)) {
            noRadio.click();
        }
    }

    protected void fillYesNoUnsureQuestion(FluentWebElement yesRadio, FluentWebElement noRadio, FluentWebElement unsureRadio, String answer) {
        if(answer.equals(YES)) {
            yesRadio.click();
        }
        if(answer.equals(NO)) {
            noRadio.click();
        }
        if(answer.equals(UNSURE)) {
            unsureRadio.click();
        }
    }

    protected void assertYesNoQuestion(FluentWebElement yesRadio, FluentWebElement noRadio, String answer) {
        switch (answer) {
            case YES:
                assertThat(String.format("Testing selectedness of radio with id = %s", yesRadio.getId()), yesRadio.isSelected(), equalTo(true));
                break;
            case NO:
                assertThat(String.format("Testing selectedness of radio with id = %s", noRadio.getId()), noRadio.isSelected(), equalTo(true));
                break;
            default:
                assertThat(String.format("Testing selectedness of radio with id = %s", yesRadio.getId()), yesRadio.isSelected(), equalTo(false));
                assertThat(String.format("Testing selectedness of radio with id = %s", noRadio.getId()), noRadio.isSelected(), equalTo(false));
        }
    }

    protected void assertYesNoUnsureQuestion(FluentWebElement yesRadio, FluentWebElement noRadio, FluentWebElement unsureRadio, String answer) {
        switch (answer) {
            case YES:
                assertThat(String.format("Testing selectedness of radio with id = %s", yesRadio.getId()), yesRadio.isSelected(), equalTo(true));
                break;
            case NO:
                assertThat(String.format("Testing selectedness of radio with id = %s", noRadio.getId()), noRadio.isSelected(), equalTo(true));
                break;
            case UNSURE:
                assertThat(String.format("Testing selectedness of radio with id = %s", unsureRadio.getId()), unsureRadio.isSelected(), equalTo(true));
                break;
            default:
                assertThat(String.format("Testing selectedness of radio with id = %s", yesRadio.getId()), yesRadio.isSelected(), equalTo(false));
                assertThat(String.format("Testing selectedness of radio with id = %s", noRadio.getId()), noRadio.isSelected(), equalTo(false));
                assertThat(String.format("Testing selectedness of radio with id = %s", unsureRadio.getId()), unsureRadio.isSelected(), equalTo(false));
        }
    }

    protected void assertVisibleBasedUpon(boolean shouldBeVisible, FluentWebElement... elements) {
        for(FluentWebElement element : elements) {
            assertThat(String.format("Testing visibility of %s", element.getId()),element.isDisplayed(), equalTo(shouldBeVisible));
        }
    }

    protected void assertVisible(FluentWebElement... elements) {
        assertVisibleBasedUpon(true, elements);
    }

    protected void assertHidden(FluentWebElement... elements) {
        assertVisibleBasedUpon(false, elements);
    }

    protected void fillCheckboxQuestion(FluentWebElement checkbox, String answer) {
        if(answer.equals("yes")) {
            checkbox.click();
        }
    }


    public void clickNextAndWaitForSpinnerToFinish() {
        clickNextAndWaitForSpinnerToFinish(10);
    }

    protected void clickNextAndWaitForSpinnerToFinish(int seconds) {
        nextButton.click();
        waitForSpinnerToFinish(seconds);
    }

    protected FluentWebElement getTextSubValue(String answername) {
        return findFirst(String.format(TEXT_SUB_SELECTOR, answername));
    }

    protected void assertTextSubValue(String answername, String value) {
        assertThat(getTextSubValue(answername).getText(), equalTo(value));
    }


    protected void assertHidden(FluentWebElement element) {
        assertThat(element.isDisplayed(), equalTo(false));
    }

    protected void assertBlank(FluentWebElement... elements) {
        String assertMessage = "Testing following element for blankness: %s";
        for(FluentWebElement element : elements) {
            switch (element.getTagName().toLowerCase()) {
                case "input":
                    switch (element.getAttribute("type").toLowerCase()) {
                        case "radio":
                        case "checkbox":
                            assertThat(String.format(assertMessage, element.getId()), element.isSelected(), equalTo(false));
                            break;
                        default:
                            assertThat(String.format(assertMessage, element.getId()), element.getValue(), equalTo(""));
                            break;
                    }
                    break;
                case "select":
                case "textarea":
                    assertThat(String.format(assertMessage, element.getId()), element.getValue(), equalTo(""));
                    break;
                default:
                    fail();
            }
        }
    }

    protected void assertQuestionCount(int expectedCount) {
        assertThat(find("input[type='text'], input[type='checkbox'], input[type='radio'], select").size(), equalTo(expectedCount));
    }

    public int getVisibleElementCount() {
        return Integer.parseInt(getScriptResult("$('input:visible, select:visible').length"));
    }

    public String getScriptResult(String script) {
        if (find("body > #output").size() == 0) {
            executeScript("$('body').append('<div id=\"output\" style=\"\"/>');");
            await().atMost(10, TimeUnit.SECONDS).until("body > #output").isPresent();
        }
        executeScript("$('#output').text('');");
        executeScript("$('#output').text(" + script + ");");
        return find("body > #output").getText();
    }

    protected void fillTouchSignature(String answername, String signatureVector) {

        executeScript(String.format("$('#%s').signature('draw','%s')",answername, signatureVector));

    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("What You Need"));

    }
    public void checkMarketabilityCode(String marketCode){
        isAt();
        String marketibilityError = getScriptResult("controller.model.getQuestionValue('marketabilityCode')");
        assertThat(marketibilityError, equalTo(marketCode));
    }


    public String getCommonCustomerInformation(Application app) {

        app.setAARPMembershipNumber(faker.numerify("########"+11));
        app.setPrefix(faker.letterify("?"));
        app.setFirstName(faker.lastName());
        app.setMI(faker.letterify("?"));
        app.setLastName(faker.lastName());
        app.setSuffix(faker.suffix());
        app.setAddressLine1(faker.streetAddress(false));
        app.setAddressLine2(faker.secondaryAddress());
        app.setCity(faker.citySuffix());
        app.setEmail(faker.letterify("????????"+"@"+"???"+".com"));
        app.setPhonePrimary(faker.numerify("##########"));
        app.setPhoneEvening(faker.numerify("##########"));
        app.setGender("M");
        app.setMedicareClaimNum(faker.numerify("#########"));
        app.setPartABActiveIndicator(AnswerUtils.YES);
        return commonCustomerInformation;
    }

    
}
