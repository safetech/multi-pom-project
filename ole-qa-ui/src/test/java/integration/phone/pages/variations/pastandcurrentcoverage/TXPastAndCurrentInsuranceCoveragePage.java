package integration.phone.pages.variations.pastandcurrentcoverage;

import integration.phone.entity.Application;
import integration.phone.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TXPastAndCurrentInsuranceCoveragePage extends WizardPage{

    @FindBy(css = "#UnderstandPandC_1") FluentWebElement UnderstandPandC_Yes;
    @FindBy(css = "#UnderstandPandC_2") FluentWebElement UnderstandPandC_No;
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
    FluentWebElement OtherMedplanstart;
    FluentWebElement OtherMedplanend;
    @FindBy(css = "#FirstTime_1") FluentWebElement FirstTime_Yes;
    @FindBy(css = "#FirstTime_2") FluentWebElement FirstTime_No;
    @FindBy(css = "#DropMedSuppForThisPlan_1") FluentWebElement DropMedSuppForThisPlan_Yes;
    @FindBy(css = "#DropMedSuppForThisPlan_2") FluentWebElement DropMedSuppForThisPlan_No;
    @FindBy(css = "#ExistMedSupp_1") FluentWebElement ExistMedSupp_Yes;
    @FindBy(css = "#ExistMedSupp_2") FluentWebElement ExistMedSupp_No;
    FluentWebElement MSInsCompany;
    FluentWebElement MSPLAN;
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

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 36;

    public void verifyInitialStateOfElements(Application app) {

        assertYesNoQuestion(CPATurned65_Yes, CPATurned65_No, app.getCPATurned65());
        assertYesNoQuestion(CPAPartBIn6_Yes, CPAPartBIn6_No, app.getCPAPartBIn6());

        assertBlank(UnderstandPandC_Yes, UnderstandPandC_No);
        assertBlank(MedicaidCovered_Yes, MedicaidCovered_No);
        assertHidden(MedicaidSupPremium_Yes,
                MedicaidSupPremium_No,
                Medicaidbenefit_Yes,
                Medicaidbenefit_No);

        assertBlank(OtherMedplanstart, OtherMedplanend);
        assertHidden(FirstTime_Yes,
                FirstTime_No,
                DropMedSuppForThisPlan_Yes,
                DropMedSuppForThisPlan_No);

        assertBlank(ExistMedSupp_Yes, ExistMedSupp_No);
        assertHidden(ReplaceExistingMedSup_Yes,
                ReplaceExistingMedSup_No);

        assertBlank(OtherInsCoverage_Yes, OtherInsCoverage_No);
        assertHidden(OtherInsCompany,
                OtherInsType,
                OtherInsStart,
                OtherInsEnd,
                OtherInsReplace_Yes,
                OtherInsReplace_No);

        assertBlank(CpaSignatureInd);

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

    public void fillAndSubmit(Application app) {

        UnderstandPandC_Yes.click();

        fillYesNoQuestion(CPATurned65_Yes, CPATurned65_No, app.getCPATurned65());
        fillYesNoQuestion(CPAPartBIn6_Yes, CPAPartBIn6_No, app.getCPAPartBIn6());
        fillYesNoQuestion(MedicaidCovered_Yes, MedicaidCovered_No, app.getMedicaidCovered());

        fillYesNoQuestion(MedicaidSupPremium_Yes, MedicaidSupPremium_No, app.getMedicaidSupPremium());
        fillYesNoQuestion(Medicaidbenefit_Yes, Medicaidbenefit_No, app.getMedicaidbenefit());

        fill(OtherMedplanstart).with(app.getOtherMedplanstart());
        fill(OtherMedplanend).with(app.getOtherMedplanend());

        if (app.getOtherMedplanstart().equals("")) {
            assertHidden(FirstTime_Yes, FirstTime_No,
                    DropMedSuppForThisPlan_Yes,
                    DropMedSuppForThisPlan_No);
        } else {

                fillYesNoQuestion(FirstTime_Yes, FirstTime_No, app.getFirstTime());
                fillYesNoQuestion(DropMedSuppForThisPlan_Yes, DropMedSuppForThisPlan_No, app.getDropMedSuppForThisPlan());
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

        clickNextAndWaitForSpinnerToFinish();
    }
    public void verifyStateOfElementAfterAnswers(Application app) {

        assertThat(UnderstandPandC_Yes.isSelected(), equalTo(true));

        assertVisible(MedicaidCovered_Yes, MedicaidCovered_No);
        assertYesNoQuestion(MedicaidCovered_Yes, MedicaidCovered_No, app.getMedicaidCovered());
        assertVisibleBasedUpon(app.getMedicaidCovered().equals("yes"),
                MedicaidSupPremium_Yes,
                MedicaidSupPremium_No,
                Medicaidbenefit_Yes,
                Medicaidbenefit_No);
        assertYesNoQuestion(MedicaidSupPremium_Yes, MedicaidSupPremium_No, app.getMedicaidCovered());
        assertYesNoQuestion(Medicaidbenefit_Yes, Medicaidbenefit_No, app.getMedicaidCovered());

        assertVisibleBasedUpon(app.getExistingMedicare().equals("yes"),
                OtherMedplanstart,
                OtherMedplanend,
                FirstTime_Yes,
                FirstTime_No,
                DropMedSuppForThisPlan_Yes,
                DropMedSuppForThisPlan_No);
        assertThat(OtherMedplanstart.getValue(), equalTo(app.getOtherMedplanstart()));
        assertThat(OtherMedplanend.getValue(), equalTo(app.getOtherMedplanend()));
        assertYesNoQuestion(FirstTime_Yes, FirstTime_No, app.getFirstTime());
        assertYesNoQuestion(DropMedSuppForThisPlan_Yes, DropMedSuppForThisPlan_No, app.getDropMedSuppForThisPlan());

        assertVisible(ExistMedSupp_Yes, ExistMedSupp_No);
        assertYesNoQuestion(ExistMedSupp_Yes, ExistMedSupp_No, app.getExistMedSupp());
        assertVisibleBasedUpon(app.getExistMedSupp().equals("yes"),
                ReplaceExistingMedSup_Yes,
                ReplaceExistingMedSup_No);
        assertYesNoQuestion(ReplaceExistingMedSup_Yes, ReplaceExistingMedSup_No, app.getReplaceExistingMedSup());

        assertVisible(OtherInsCoverage_Yes, OtherInsCoverage_No);
        assertYesNoQuestion(OtherInsCoverage_Yes, OtherInsCoverage_No, app.getOtherInsCoverage());
        assertVisibleBasedUpon(app.getOtherInsCoverage().equals("yes"),
                OtherInsCompany,
                OtherInsType,
                OtherInsStart,
                OtherInsEnd,
                OtherInsReplace_Yes,
                OtherInsReplace_No);
        assertThat(OtherInsCompany.getValue(), equalTo(app.getOtherInsCompany()));
        assertThat(OtherInsType.getValue(), equalTo(app.getOtherInsType()));
        assertThat(OtherInsStart.getValue(), equalTo(app.getOtherInsStart()));
        assertThat(OtherInsEnd.getValue(), equalTo(app.getOtherInsEnd()));
        assertYesNoQuestion(OtherInsReplace_Yes, OtherInsReplace_No, app.getOtherInsReplace());

        assertThat(CpaSignatureInd.isSelected(), equalTo(true));

        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);
    }

}
