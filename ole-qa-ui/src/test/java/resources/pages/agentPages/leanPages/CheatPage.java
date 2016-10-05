package resources.pages.agentpages.leanPages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.entity.agent.CribSheet;
import resources.utils.AnswerUtils;
import resources.utils.PropertyUtils;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheatPage extends FluentPage{

    @FindBy(css = "#page-title") FluentWebElement pageTitle;
    @FindBy(css = "#AgentID") FluentWebElement AgentID;

    FluentWebElement preset_select;

    FluentWebElement resume;
    FluentWebElement cheatButton;
    
    public String getUrl() {
        return PropertyUtils.getProperty("agentLean.urls");
    }

    public void fillAndSubmit(CribSheet sheet) {
        isAt();
        fill(AgentID).with(sheet.getAgentID());
        
        if(!sheet.getResume().equals(AnswerUtils.BLANK)) {
            resume.click();
        }
        cheatButton.click();
        waitForSpinnerToFinish();
    }

    protected void waitForSpinnerToFinish() {
        await().atMost(7, TimeUnit.SECONDS).until("#loading_fader").areNotDisplayed();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Cheat Page"));
    }

}
