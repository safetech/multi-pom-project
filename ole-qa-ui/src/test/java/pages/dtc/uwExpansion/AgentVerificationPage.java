package pages.dtc.uwExpansion;

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

    public void fillAndSubmit(Application app) {

        isAt();

        fill(app);

        clickNextAndWaitForSpinnerToFinish();

    }

    protected void fill(Application app) {
        fill(AgentOtherInsPoliciesSold).with(app.getAgentOtherInsPoliciesSold());
        fill(AgentPoliciesInForce).with(app.getAgentPoliciesInForce());
        fill(AgentPoliciesSoldNotInForce).with(app.getAgentPoliciesSoldNotInForce());
        AgentSignatureInd.click();
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Agent Verification"));
    }
}
