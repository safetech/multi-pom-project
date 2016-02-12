package integration.phone.phonePages.oldOlePages.variations.agentverification;

import entity.Application;
import integration.phone.phonePages.oldOlePages.AgentVerificationPage;
import org.fluentlenium.core.domain.FluentWebElement;

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
