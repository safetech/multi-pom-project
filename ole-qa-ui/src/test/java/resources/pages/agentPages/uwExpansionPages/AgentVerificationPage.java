package resources.pages.agentpages.uwExpansionPages;

import org.fluentlenium.core.domain.FluentWebElement;
import resources.entity.Application;
import resources.pages.WizardPage;

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
    FluentWebElement DidNotAssistAnsweringQuestions;
    protected int TOTAL_POSSIBLE_QUESTION_COUNT;
    public void fillAndSubmit(Application app) {

        TOTAL_POSSIBLE_QUESTION_COUNT=app.getState().equals("CA")?9:8;
        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
        
        fill(AgentOtherInsPoliciesSold).with(app.getAgentOtherInsPoliciesSold());
        fill(AgentPoliciesInForce).with(app.getAgentPoliciesInForce());
        fill(AgentPoliciesSoldNotInForce).with(app.getAgentPoliciesSoldNotInForce());
        if(app.getState().equals("CA")){
        DidNotAssistAnsweringQuestions.click();
        }
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
