package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AgentVerificationPage extends WizardPage{

    FluentWebElement AgentOtherInsPoliciesSold;
    FluentWebElement AgentPoliciesInForce;
    FluentWebElement AgentPoliciesSoldNotInForce;
    FluentWebElement AgentSignatureInd;

    public void fillAndSubmit(Application app) {

        isAt();

        fill(AgentOtherInsPoliciesSold).with(app.getAgentOtherInsPoliciesSold());
        fill(AgentPoliciesInForce).with(app.getAgentPoliciesInForce());
        fill(AgentPoliciesSoldNotInForce).with(app.getAgentPoliciesSoldNotInForce());
        AgentSignatureInd.click();

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Agent Verification"));
    }
}
