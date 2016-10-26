package resources.pages.phonepages.uwExpansionPages.variations.agentverification;

import org.openqa.selenium.support.FindBy;
import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import resources.pages.phonepages.oldOlePages.AgentVerificationPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AgentVerificationPage extends AgentVerificationPage {

    FluentWebElement DidNotAssistAnsweringQuestions;
    @FindBy (xpath = "html/body/div[2]/div[1]/div[1]/form/section/div[3]/p[4]") FluentWebElement AgentFullName;

    public void fillAndSubmit(Application app) {

        isAt();

        fill(app);
        DidNotAssistAnsweringQuestions.click();
        assert(AgentFullName.getText().equals(app.getAgentFullName()));

        clickNextAndWaitForSpinnerToFinish();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Agent Verification"));
    }

}
