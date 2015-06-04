package integration.phone.pages.variations.agentverification;

import integration.phone.entity.Application;
import integration.phone.pages.AgentVerificationPage;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CAAgentVerificationPage extends AgentVerificationPage {

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
