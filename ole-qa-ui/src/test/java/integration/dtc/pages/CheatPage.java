package integration.dtc.pages;

import integration.entity.CribSheet;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheatPage extends FluentPage{

    @FindBy(css = "#page-title")
    FluentWebElement pageTitle;
    FluentWebElement state;
    FluentWebElement zip;
    FluentWebElement aarpMemid;
    FluentWebElement DOB;
    FluentWebElement effDate;
    FluentWebElement psd;
    FluentWebElement planCode;
    FluentWebElement cheatButton;

    public String getUrl() {
        return "https://aarpsupplementalhealth-stg.uhc.com/ole/ms.html?cheat=true";
    }

    public void fillAndSubmit(CribSheet sheet) {
        isAt();

        fill(state).with(sheet.getState());
        fill(zip).with(sheet.getZip());
        fill(aarpMemid).with("y");
        fill(DOB).with(sheet.getDateOfBirth());
        fill(effDate).with(sheet.getMedPartBdate());
        fill(psd).with(sheet.getDpsd());
        fill(planCode).with(sheet.getPlanCode());

        cheatButton.click();
        waitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Cheat Page"));
    }

    protected void waitForSpinnerToFinish() {
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }


}
