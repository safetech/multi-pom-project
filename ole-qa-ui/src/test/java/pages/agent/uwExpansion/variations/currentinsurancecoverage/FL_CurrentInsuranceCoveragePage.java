package pages.agent.uwExpansion.variations.currentinsurancecoverage;

import entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.WizardPage;
import util.DateUtils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FL_CurrentInsuranceCoveragePage extends WizardPage{

    @FindBy(css = "#CPATurned65_1") FluentWebElement CPATurned65_Yes;
    @FindBy(css = "#CPATurned65_2") FluentWebElement CPATurned65_No;
    @FindBy(css = "#CPAPartBIn6_1") FluentWebElement CPAPartBIn6_Yes;
    @FindBy(css = "#CPAPartBIn6_2") FluentWebElement CPAPartBIn6_No;
    @FindBy(css = "#MedicaidCovered_1") FluentWebElement MedicaidCovered_Yes;
    @FindBy(css = "#MedicaidCovered_2") FluentWebElement MedicaidCovered_No;
    @FindBy(css = "#MedicaidSupPremium_1") FluentWebElement MedicaidSupPremium_Yes;
    @FindBy(css = "#MedicaidSupPremium_2") FluentWebElement MedicaidSupPremium_No;
    @FindBy(css = "#Medicaidbenefit_1") FluentWebElement Medicaidbenefit_Yes;
    @FindBy(css = "#Medicaidbenefit_2") FluentWebElement Medicaidbenefit_No;

    FluentWebElement CPAMPBED;
    FluentWebElement OtherMedplanstart;
    FluentWebElement OtherMedplanend;
    @FindBy(css = "#ExistMedSupp_1") FluentWebElement ExistMedSupp_Yes;
    @FindBy(css = "#ExistMedSupp_2") FluentWebElement ExistMedSupp_No;
    FluentWebElement MSInsCompany;
    FluentWebElement MSPLAN;
    @FindBy(css = "#ExistingMedicare_1") FluentWebElement ExistingMedicare_Yes;
    @FindBy(css = "#ExistingMedicare_2") FluentWebElement ExistingMedicare_No;
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
        protected int TOTAL_POSSIBLE_QUESTION_COUNT = 34;

    public void verifyInitialStateOfElements(Application app) {
        assertYesNoQuestion(CPATurned65_Yes, CPATurned65_No, app.getCPATurned65());
        assertYesNoQuestion(CPAPartBIn6_Yes, CPAPartBIn6_No, app.getCPAPartBIn6());
        if(app.getCPAPartBIn6().equals(YES)) {
            assertHidden(CPAMPBED);
        }else if(app.getCPAPartBIn6().equals(NO)){
            assertVisible(CPAMPBED);

        }
        assertBlank(MedicaidCovered_Yes, MedicaidCovered_No);
        assertBlank(ExistingMedicare_Yes, ExistingMedicare_No);
        assertBlank(ExistMedSupp_Yes, ExistMedSupp_No);
        assertBlank(OtherInsCoverage_Yes, OtherInsCoverage_No);
        assertHidden(MedicaidSupPremium_Yes, MedicaidSupPremium_No);
        assertHidden(Medicaidbenefit_Yes, Medicaidbenefit_No);
        //TODO: Defect 437 logged in --- assertHidden(OtherMedplanstart, OtherMedplanend);
//        assertHidden(IntentReplace_Yes, IntentReplace_No);
//        assertHidden(ContinuousMedicareCoverageNoGap_Yes, ContinuousMedicareCoverageNoGap_No);
//        assertHidden(DropMedSuppForThisPlan_Yes, DropMedSuppForThisPlan_No,
        assertHidden(MSInsCompany,
                MSPLAN,
                ReplaceExistingMedSup_Yes, ReplaceExistingMedSup_No,
                OtherInsCompany,
                OtherInsType,
                OtherInsStart, OtherInsEnd,
                OtherInsReplace_Yes, OtherInsReplace_No);

    }
    public void fillAndSubmit(Application app) {

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        fillYesNoQuestion(CPATurned65_Yes, CPATurned65_No, app.getCPATurned65());
        fillYesNoQuestion(CPAPartBIn6_Yes, CPAPartBIn6_No, app.getCPAPartBIn6());
        if(app.getCPAPartBIn6().equals(YES)){
            assertThat(CPAMPBED.getElement().getAttribute("value"), equalTo(DateUtils.getFirstDayOfPastMonth(-1)));
        }
        fillYesNoQuestion(MedicaidCovered_Yes, MedicaidCovered_No, app.getMedicaidCovered());
        if(app.getMedicaidCovered().equals("yes")) {
            fillYesNoQuestion(MedicaidSupPremium_Yes, MedicaidSupPremium_No, app.getMedicaidSupPremium());
            fillYesNoQuestion(Medicaidbenefit_Yes, Medicaidbenefit_No, app.getMedicaidbenefit());
        }

        fillYesNoQuestion(ExistingMedicare_Yes, ExistingMedicare_No, app.getExistingMedicare());
        if(app.getExistingMedicare().equals("yes")) {
           // fill(OtherMedplanstart).with(app.getOtherMedplanstart());
            //fill(OtherMedplanend).with(app.getOtherMedplanend());
        }

        fillYesNoQuestion(ExistMedSupp_Yes, ExistMedSupp_No, app.getExistMedSupp());
        if(app.getExistMedSupp().equals("yes")){
            fill(MSInsCompany).with(app.getMSInsCompany());
            fill(MSPLAN).with(app.getMSPLAN());
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
