package pages.preference;

import entity.preference.CribSheet;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheatPage extends FluentPage{

    @FindBy(xpath = "//*[contains(text(), 'Email Communication Preferences Cheat Page')]") public FluentWebElement pageTitle;
    FluentWebElement token;
    FluentWebElement email;
    FluentWebElement transactionid;
    FluentWebElement product;
    FluentWebElement CheatButton;


    public String getUrl() {
        return "https://aarpsupplementalhealth-tst.uhc.com/pc/preferencecenter.cheat.html";
    }

    public void fillAndSubmit(CribSheet sheet) {
        isAt();
        fill(token).with(sheet.getToken());
        fill(email).with(sheet.getEmail());
        fill(transactionid).with(sheet.getTransactionid());
        fill(product).with(sheet.getProduct());
        CheatButton.click();
        waitForSpinnerToFinish();
    }

    protected void waitForSpinnerToFinish() {
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Email Communication Preferences Cheat Page"));
    }



}

