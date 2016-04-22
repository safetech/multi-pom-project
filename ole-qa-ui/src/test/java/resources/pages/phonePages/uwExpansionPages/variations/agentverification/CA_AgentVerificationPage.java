package resources.pages.phonepages.uwExpansionPages.variations.agentverification;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import resources.pages.phonepages.oldOlePages.AgentVerificationPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_AgentVerificationPage extends AgentVerificationPage {

    FluentWebElement DidNotAssistAnsweringQuestions;

    public void fillAndSubmit(Application app) {

        isAt();

        fill(app);

        DidNotAssistAnsweringQuestions.click();

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Agent Verification"));
    }
}