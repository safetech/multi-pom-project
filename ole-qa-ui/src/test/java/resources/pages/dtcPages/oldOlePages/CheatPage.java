package resources.pages.dtcPages.oldOlePages;

import resources.entity.dtc.CribSheet;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.utils.AnswerUtils;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheatPage extends FluentPage{

    @FindBy(css = "#page-title") FluentWebElement pageTitle;
    FluentWebElement preset_select;
    FluentWebElement state;
    FluentWebElement zip;
    FluentWebElement aarpMemid;
    FluentWebElement DOB;
    FluentWebElement effDate;
    FluentWebElement psd;
    FluentWebElement planCode;
    FluentWebElement marketability_code;
    FluentWebElement referrer;
    FluentWebElement returnURL;
    FluentWebElement HASHID;
    @FindBy(id = "WT.mc_id") FluentWebElement WT_mc_id;
    FluentWebElement applicationId;
    FluentWebElement readonly;
    FluentWebElement resume;
    FluentWebElement log_level;
    FluentWebElement cheatButton;
    FluentWebElement RiderChoice1;
    FluentWebElement RiderChoice2;
    FluentWebElement RiderChoice3;
    FluentWebElement RiderChoice4;
    FluentWebElement RiderChoice5;


    public String getUrl() {
        return "https://aarpsupplementalhealth-stg.uhc.com/ole/ms.html?cheat=true";
    }

    public void fillAndSubmit(CribSheet sheet) {
        isAt();
        fill(state).with(sheet.getState());
        fill(zip).with(sheet.getZip());
        fill(aarpMemid).with("y");
        fill(DOB).with(sheet.getDOB());
        fill(effDate).with(sheet.getEffDate());
        fill(psd).with(sheet.getPsd());
        fill(planCode).with(sheet.getPlanCode());
        fill(marketability_code).with(sheet.getMarketability_code());
        fill(referrer).with(sheet.getReferrer());
        fill(returnURL).with(sheet.getReturnURL());
        fill(HASHID).with(sheet.getHASHID());
        fill(WT_mc_id).with(sheet.getWT_mc_id());
        fill(applicationId).with(sheet.getApplicationId());
        fill(RiderChoice1).with(sheet.getRiderChoice1());
        fill(RiderChoice2).with(sheet.getRiderChoice2());
        fill(RiderChoice3).with(sheet.getRiderChoice3());
        fill(RiderChoice4).with(sheet.getRiderChoice4());
        fill(RiderChoice5).with(sheet.getRiderChoice5());

        if(!sheet.getReadonly().equals(AnswerUtils.BLANK)) {
            readonly.click();
        }
        if(!sheet.getResume().equals(AnswerUtils.BLANK)) {
            resume.click();
        }
        fill(log_level).with(sheet.getLog_level());

        cheatButton.click();
        waitForSpinnerToFinish();

    }
    public void resumeFillAndSubmit(CribSheet sheet) {
        isAt();
        fill(state).with(sheet.getState());
        fill(zip).with(sheet.getZip());
        fill(aarpMemid).with("y");
        fill(DOB).with(sheet.getDOB());
        fill(effDate).with(sheet.getEffDate());
        fill(psd).with(sheet.getPsd());
        fill(planCode).with(sheet.getPlanCode());
        fill(marketability_code).with(sheet.getMarketability_code());
        fill(referrer).with(sheet.getReferrer());
        fill(returnURL).with(sheet.getReturnURL());
        fill(HASHID).with(sheet.getHASHID());
        fill(WT_mc_id).with(sheet.getWT_mc_id());
        fill(applicationId).with(sheet.getApplicationId());
        if(!sheet.getReadonly().equals(AnswerUtils.BLANK)) {
            readonly.click();
        }
        resume.click();
        fill(log_level).with(sheet.getLog_level());

        cheatButton.click();
        waitForSpinnerToFinish();
    }
    protected void waitForSpinnerToFinish() {
        await().atMost(10, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Cheat Page"));
    }


}

