package integration.agent.agentPages.oldOlePages;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AgentVerificationPage extends WizardPage {

    protected FluentWebElement AgentOtherInsPoliciesSold;
    protected FluentWebElement AgentPoliciesInForce;
    protected FluentWebElement AgentPoliciesSoldNotInForce;
    protected FluentWebElement AgentSignatureInd;
    protected FluentWebElement AgentFirstName;
    protected FluentWebElement AgentMI;
    protected FluentWebElement AgentLastName;
    protected FluentWebElement AgentPhone;
    protected FluentWebElement AgentSignatureIndTouch;

    public void fillAndSubmit(Application app) {

        isAt();

        fill(AgentOtherInsPoliciesSold).with(app.getAgentOtherInsPoliciesSold());
        fill(AgentPoliciesInForce).with(app.getAgentPoliciesInForce());
        fill(AgentPoliciesSoldNotInForce).with(app.getAgentPoliciesSoldNotInForce());
        fill(AgentFirstName).with(app.getAgentFirstName());
        fill(AgentMI).with(app.getAgentMI());
        fill(AgentLastName).with(app.getAgentLastName());
        fill(AgentPhone).with(app.getAgentPhone());

        AgentSignatureInd.click();
        fillTouchSignature("AgentSignatureIndTouch", app.getAgentSignatureIndTouch());

        clickNextAndWaitForSpinnerToFinish();
    }
    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Agent Verification"));
    }
}
