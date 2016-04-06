package resources.pages.agentPages.oldOlePages.variations.eligibilityhealthquestions;

import resources.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import resources.pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CA_EligibilityHealthQuestionsPage extends WizardPage {

    @FindBy(css = "#ESRD_1") FluentWebElement ESRD_Yes;
    @FindBy(css = "#ESRD_2") FluentWebElement ESRD_No;
    @FindBy(css = "#ESRD_3") FluentWebElement ESRD_Maybe;
    @FindBy(css = "#Eligdialysis_1") FluentWebElement Eligdialysis_Yes;
    @FindBy(css = "#Eligdialysis_2") FluentWebElement Eligdialysis_No;
    @FindBy(css = "#Eligdialysis_3") FluentWebElement Eligdialysis_Maybe;
    @FindBy(css = "#EligRecdialysis_1") FluentWebElement EligRecdialysis_Yes;
    @FindBy(css = "#EligRecdialysis_2") FluentWebElement EligRecdialysis_No;
    @FindBy(css = "#EligRecdialysis_3") FluentWebElement EligRecdialysis_Maybe;
    @FindBy(css = "#EligHospital_1") FluentWebElement EligHospital_Yes;
    @FindBy(css = "#EligHospital_2") FluentWebElement EligHospital_No;
    @FindBy(css = "#EligHospital_3") FluentWebElement EligHospital_Maybe;
    @FindBy(css = "#EligSurgery_1") FluentWebElement EligSurgery_Yes;
    @FindBy(css = "#EligSurgery_2") FluentWebElement EligSurgery_No;
    @FindBy(css = "#EligSurgery_3") FluentWebElement EligSurgery_Maybe;
    @FindBy(css = "#EligOrgan_1") FluentWebElement EligOrgan_Yes;
    @FindBy(css = "#EligOrgan_2") FluentWebElement EligOrgan_No;
    @FindBy(css = "#EligOrgan_3") FluentWebElement EligOrgan_Maybe;
    @FindBy(css = "#EligSpine_1") FluentWebElement EligSpine_Yes;
    @FindBy(css = "#EligSpine_2") FluentWebElement EligSpine_No;
    @FindBy(css = "#EligSpine_3") FluentWebElement EligSpine_Maybe;
    @FindBy(css = "#Eligjoint_1") FluentWebElement Eligjoint_Yes;
    @FindBy(css = "#Eligjoint_2") FluentWebElement Eligjoint_No;
    @FindBy(css = "#Eligjoint_3") FluentWebElement Eligjoint_Maybe;
    @FindBy(css = "#EligCancer_1") FluentWebElement EligCancer_Yes;
    @FindBy(css = "#EligCancer_2") FluentWebElement EligCancer_No;
    @FindBy(css = "#EligCancer_3") FluentWebElement EligCancer_Maybe;
    @FindBy(css = "#EligHeart_1") FluentWebElement EligHeart_Yes;
    @FindBy(css = "#EligHeart_2") FluentWebElement EligHeart_No;
    @FindBy(css = "#EligHeart_3") FluentWebElement EligHeart_Maybe;
    @FindBy(css = "#EligVascular_1") FluentWebElement EligVascular_Yes;
    @FindBy(css = "#EligVascular_2") FluentWebElement EligVascular_No;
    @FindBy(css = "#EligVascular_3") FluentWebElement EligVascular_Maybe;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 33;

    public void verifyInitialStateOfElements(Application app) {
        assertBlank(
            ESRD_Yes,
            ESRD_No,
            ESRD_Maybe,
            Eligdialysis_Yes,
            Eligdialysis_No,
            Eligdialysis_Maybe,
            EligRecdialysis_Yes,
            EligRecdialysis_No,
            EligRecdialysis_Maybe,
            EligHospital_Yes,
            EligHospital_No,
            EligHospital_Maybe,
            EligSurgery_Yes,
            EligSurgery_No,
            EligSurgery_Maybe,
            EligOrgan_Yes,
            EligOrgan_No,
            EligOrgan_Maybe,
            EligSpine_Yes,
            EligSpine_No,
            EligSpine_Maybe,
            Eligjoint_Yes,
            Eligjoint_No,
            Eligjoint_Maybe,
            EligCancer_Yes,
            EligCancer_No,
            EligCancer_Maybe,
            EligHeart_Yes,
            EligHeart_No,
            EligHeart_Maybe,
            EligVascular_Yes,
            EligVascular_No,
            EligVascular_Maybe);

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {
        verifyInitialStateOfElements(app);
        fillYesNoUnsureQuestion(ESRD_Yes, ESRD_No, ESRD_Maybe, app.getESRD());
        fillYesNoUnsureQuestion(Eligdialysis_Yes, Eligdialysis_No, Eligdialysis_Maybe, app.getEligdialysis());
        fillYesNoUnsureQuestion(EligRecdialysis_Yes, EligRecdialysis_No, EligRecdialysis_Maybe, app.getEligRecdialysis());
        fillYesNoUnsureQuestion(EligHospital_Yes, EligHospital_No, EligHospital_Maybe, app.getEligHospital());
        fillYesNoUnsureQuestion(EligSurgery_Yes, EligSurgery_No, EligSurgery_Maybe, app.getEligSurgery());
        fillYesNoUnsureQuestion(EligOrgan_Yes, EligOrgan_No, EligOrgan_Maybe, app.getEligOrgan());
        fillYesNoUnsureQuestion(EligSpine_Yes, EligSpine_No, EligSpine_Maybe, app.getEligSpine());
        fillYesNoUnsureQuestion(Eligjoint_Yes, Eligjoint_No, Eligjoint_Maybe, app.getEligjoint());
        fillYesNoUnsureQuestion(EligCancer_Yes, EligCancer_No, EligCancer_Maybe, app.getEligCancer());
        fillYesNoUnsureQuestion(EligHeart_Yes, EligHeart_No, EligHeart_Maybe, app.getEligHeart());
        fillYesNoUnsureQuestion(EligVascular_Yes, EligVascular_No, EligVascular_Maybe, app.getEligVascular());

        verifyStateOfElementAfterAnswers(app);
        clickNextAndWaitForSpinnerToFinish();


    }

    public void verifyStateOfElementAfterAnswers(Application app) {

        assertVisible(
            ESRD_Yes,
            ESRD_No,
            ESRD_Maybe,
            Eligdialysis_Yes,
            Eligdialysis_No,
            Eligdialysis_Maybe,
            EligRecdialysis_Yes,
            EligRecdialysis_No,
            EligRecdialysis_Maybe,
            EligHospital_Yes,
            EligHospital_No,
            EligHospital_Maybe,
            EligSurgery_Yes,
            EligSurgery_No,
            EligSurgery_Maybe,
            EligOrgan_Yes,
            EligOrgan_No,
            EligOrgan_Maybe,
            EligSpine_Yes,
            EligSpine_No,
            EligSpine_Maybe,
            Eligjoint_Yes,
            Eligjoint_No,
            Eligjoint_Maybe,
            EligCancer_Yes,
            EligCancer_No,
            EligCancer_Maybe,
            EligHeart_Yes,
            EligHeart_No,
            EligHeart_Maybe,
            EligVascular_Yes,
            EligVascular_No,
            EligVascular_Maybe);
        assertYesNoUnsureQuestion(ESRD_Yes, ESRD_No, ESRD_Maybe, app.getESRD());
        assertYesNoUnsureQuestion(Eligdialysis_Yes, Eligdialysis_No, Eligdialysis_Maybe, app.getEligdialysis());
        assertYesNoUnsureQuestion(EligRecdialysis_Yes, EligRecdialysis_No, EligRecdialysis_Maybe, app.getEligRecdialysis());
        assertYesNoUnsureQuestion(EligHospital_Yes, EligHospital_No, EligHospital_Maybe, app.getEligHospital());
        assertYesNoUnsureQuestion(EligSurgery_Yes, EligSurgery_No, EligSurgery_Maybe, app.getEligSurgery());
        assertYesNoUnsureQuestion(EligOrgan_Yes, EligOrgan_No, EligOrgan_Maybe, app.getEligOrgan());
        assertYesNoUnsureQuestion(EligSpine_Yes, EligSpine_No, EligSpine_Maybe, app.getEligSpine());
        assertYesNoUnsureQuestion(Eligjoint_Yes, Eligjoint_No, Eligjoint_Maybe, app.getEligjoint());
        assertYesNoUnsureQuestion(EligCancer_Yes, EligCancer_No, EligCancer_Maybe, app.getEligCancer());
        assertYesNoUnsureQuestion(EligHeart_Yes, EligHeart_No, EligHeart_Maybe, app.getEligHeart());
        assertYesNoUnsureQuestion(EligVascular_Yes, EligVascular_No, EligVascular_Maybe, app.getEligVascular());

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Eligibility Health Questions"));
    }
}

