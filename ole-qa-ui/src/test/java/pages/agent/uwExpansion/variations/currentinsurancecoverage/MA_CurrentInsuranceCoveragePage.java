package pages.agent.uwExpansion.variations.currentinsurancecoverage;


import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class MA_CurrentInsuranceCoveragePage extends WizardPage {

@FindBy(css = "#MedicaidCovered_1") FluentWebElement MedicaidCovered_Yes;
@FindBy(css = "#MedicaidCovered_2") FluentWebElement MedicaidCovered_No;
@FindBy(css = "#MedicaidSupPremium_1") FluentWebElement MedicaidSupPremium_Yes;
@FindBy(css = "#MedicaidSupPremium_2") FluentWebElement MedicaidSupPremium_No;
@FindBy(css = "#Medicaidbenefit_1") FluentWebElement Medicaidbenefit_Yes;
@FindBy(css = "#Medicaidbenefit_2") FluentWebElement Medicaidbenefit_No;

@FindBy(id = "6monEligEnroll_1") FluentWebElement SixMonEligEnroll_Yes;
@FindBy(id = "6monEligEnroll_2") FluentWebElement SixMonEligEnroll_No;
@FindBy(id = "6monTurn65Enroll_1") FluentWebElement SixMonTurn65Enroll_Yes;
@FindBy(id = "6monTurn65Enroll_2") FluentWebElement SixMonTurn65Enroll_No;
@FindBy(id = "6monEmpCovTerm_1") FluentWebElement SixEmpCovTerm_Yes;
@FindBy(id = "6monEmpCovTerm_2") FluentWebElement SixEmpCovTerm_No;
@FindBy(id = "6monMoveOut_1") FluentWebElement SixMonMoveOut_Yes;
@FindBy(id = "6monMoveOut_2") FluentWebElement SixMonMoveOut_No;
@FindBy(id = "6monResident_1") FluentWebElement SixMonResident_Yes;
@FindBy(id = "6monResident_2") FluentWebElement SixMonResident_No;

@FindBy(css = "#ExistingMedicare_1") FluentWebElement ExistingMedicare_Yes;
@FindBy(css = "#ExistingMedicare_2") FluentWebElement ExistingMedicare_No;
FluentWebElement OtherMedplanstart;
FluentWebElement OtherMedplanend;
@FindBy(css = "#IntentReplace_1") FluentWebElement IntentReplace_Yes;
@FindBy(css = "#IntentReplace_2") FluentWebElement IntentReplace_No;
@FindBy(css = "#FirstTime_1") FluentWebElement FirstTime_Yes;
@FindBy(css = "#FirstTime_2") FluentWebElement FirstTime_No;
@FindBy(css = "#DropMedSuppForThisPlan_1") FluentWebElement DropMedSuppForThisPlan_Yes;
@FindBy(css = "#DropMedSuppForThisPlan_2") FluentWebElement DropMedSuppForThisPlan_No;

@FindBy(css = "#ExistMedSupp_1") FluentWebElement ExistMedSupp_Yes;
@FindBy(css = "#ExistMedSupp_2") FluentWebElement ExistMedSupp_No;
@FindBy(css = "#ReplaceExistingMedSup_1") FluentWebElement ReplaceExistingMedSup_Yes;
@FindBy(css = "#ReplaceExistingMedSup_2") FluentWebElement ReplaceExistingMedSup_No;

@FindBy(css = "#OtherInsCoverage_1") FluentWebElement OtherInsCoverage_Yes;
@FindBy(css = "#OtherInsCoverage_2") FluentWebElement OtherInsCoverage_No;
FluentWebElement OtherInsCompany;
FluentWebElement OtherInsType;
FluentWebElement OtherInsStart;
FluentWebElement OtherInsEnd;
@FindBy(css = "#OtherInsReplace_1") FluentWebElement OtherInsReplace_Yes;
@FindBy(css = "#OtherInsReplace_2") FluentWebElement OtherInsReplace_No;
FluentWebElement CpaSignatureInd;

protected int TOTAL_POSSIBLE_QUESTION_COUNT = 39;

public void fillAndSubmit(Application app) {

    assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

    fillYesNoQuestion(SixMonEligEnroll_Yes, SixMonEligEnroll_No, app.getSixMonEligEnroll());
    fillYesNoQuestion(SixMonTurn65Enroll_Yes, SixMonTurn65Enroll_No, app.getSixMonTurn65Enroll());
    fillYesNoQuestion(SixEmpCovTerm_Yes, SixEmpCovTerm_No, app.getSixEmpCovTerm());
    fillYesNoQuestion(SixMonMoveOut_Yes, SixMonMoveOut_No, app.getSixMonMoveOut());
    fillYesNoQuestion(SixMonResident_Yes, SixMonResident_No, app.getSixMonResident());

    fillYesNoQuestion(MedicaidCovered_Yes, MedicaidCovered_No, app.getMedicaidCovered());
    if(app.getMedicaidCovered().equals("yes")) {
        fillYesNoQuestion(MedicaidSupPremium_Yes, MedicaidSupPremium_No, app.getMedicaidSupPremium());
        fillYesNoQuestion(Medicaidbenefit_Yes, Medicaidbenefit_No, app.getMedicaidbenefit());
    }

    fillYesNoQuestion(ExistingMedicare_Yes, ExistingMedicare_No, app.getExistingMedicare());
    if(app.getExistingMedicare().equals("yes")){
        fill(OtherMedplanstart).with(app.getOtherMedplanstart());
        fill(OtherMedplanend).with(app.getOtherMedplanend());
        fillYesNoQuestion(IntentReplace_Yes, IntentReplace_No, app.getIntentReplace());
        fillYesNoQuestion(FirstTime_Yes, FirstTime_No, app.getFirstTime());
        fillYesNoQuestion(DropMedSuppForThisPlan_Yes, DropMedSuppForThisPlan_No, app.getDropMedSuppForThisPlan());
    }

    fillYesNoQuestion(ExistMedSupp_Yes, ExistMedSupp_No, app.getExistMedSupp());
    if(app.getExistMedSupp().equals("yes")){
        fillYesNoQuestion(ReplaceExistingMedSup_Yes, ReplaceExistingMedSup_No, app.getReplaceExistingMedSup());
    }

    fillYesNoQuestion(OtherInsCoverage_Yes, OtherInsCoverage_No, app.getOtherInsCoverage());
    if(app.getOtherInsCoverage().equals("yes")) {
        fill(OtherInsCompany).with(app.getOtherInsCompany());
        fill(OtherInsType).with(app.getOtherInsType());
        fill(OtherInsStart).with(app.getOtherInsStart());
        fill(OtherInsEnd).with(app.getOtherInsEnd());
        fillYesNoQuestion(OtherInsReplace_Yes, OtherInsReplace_No, app.getOtherInsReplace());
    }

    CpaSignatureInd.click();
    fillTouchSignature("CpaSignatureIndTouch", app.getCpaSignatureIndTouch());

    clickNextAndWaitForSpinnerToFinish();
}

public void isAt() {
    assertThat(pageTitle.getText(), equalTo("Current Insurance Coverage"));
}
}
