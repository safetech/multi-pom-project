package resources.pages.phonepages.oldOlePages.variations.pastandcurrentcoverage;

import resources.entity.Application;import resources.pages.WizardPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MO_PastAndCurrentInsuranceCoveragePage extends WizardPage {

    @FindBy(css = "#UnderstandPandC_1") FluentWebElement UnderstandPandC_Yes;
    @FindBy(css = "#UnderstandPandC_2") FluentWebElement UnderstandPandC_No;
    @FindBy(css = "#MedicaidCovered_1") FluentWebElement MedicaidCovered_Yes;
    @FindBy(css = "#MedicaidCovered_2") FluentWebElement MedicaidCovered_No;
    @FindBy(css = "#MedicaidSupPremium_1") FluentWebElement MedicaidSupPremium_Yes;
    @FindBy(css = "#MedicaidSupPremium_2") FluentWebElement MedicaidSupPremium_No;
    @FindBy(css = "#Medicaidbenefit_1") FluentWebElement Medicaidbenefit_Yes;
    @FindBy(css = "#Medicaidbenefit_2") FluentWebElement Medicaidbenefit_No;
    FluentWebElement OtherMedplanstart;
    FluentWebElement OtherMedplanend;
    @FindBy(css = "#IntentReplace_1") FluentWebElement IntentReplace_Yes;
    @FindBy(css = "#IntentReplace_2") FluentWebElement IntentReplace_No;
    @FindBy(css = "#FirstTime_1") FluentWebElement FirstTime_Yes;
    @FindBy(css = "#FirstTime_2") FluentWebElement FirstTime_No;
    @FindBy(css = "#DropMedSuppForThisPlan_1") FluentWebElement DropMedSuppForThisPlan_Yes;
    @FindBy(css = "#DropMedSuppForThisPlan_2") FluentWebElement DropMedSuppForThisPlan_No;
    @FindBy(css = "#ReplaceExistingMedSup_1") FluentWebElement ReplaceExistingMedSup_Yes;
    @FindBy(css = "#ReplaceExistingMedSup_2") FluentWebElement ReplaceExistingMedSup_No;
    @FindBy(css = "#ExistingMedicare_1") FluentWebElement ExistingMedicare_Yes;
    @FindBy(css = "#ExistingMedicare_2") FluentWebElement ExistingMedicare_No;
    @FindBy(css = "#ExistMedSupp_1") FluentWebElement ExistMedSupp_Yes;
    @FindBy(css = "#ExistMedSupp_2") FluentWebElement ExistMedSupp_No;
    @FindBy(css = "#OtherInsCoverage_1") FluentWebElement OtherInsCoverage_Yes;
    @FindBy(css = "#OtherInsCoverage_2") FluentWebElement OtherInsCoverage_No;
    FluentWebElement MOPlanCode;
    FluentWebElement MOAnniversaryDate;
    FluentWebElement OtherInsCompany;
    FluentWebElement OtherInsType;
    FluentWebElement OtherInsStart;
    FluentWebElement OtherInsEnd;
    @FindBy(css = "#OtherInsReplace_1") FluentWebElement OtherInsReplace_Yes;
    @FindBy(css = "#OtherInsReplace_2") FluentWebElement OtherInsReplace_No;
    FluentWebElement CpaSignatureInd;

    protected int TOTAL_POSSIBLE_QUESTION_COUNT = 33;

    public void verifyInitialStateOfElements(Application app) {
        isAt();
        assertQuestionCount(TOTAL_POSSIBLE_QUESTION_COUNT);

        assertBlank(UnderstandPandC_Yes, UnderstandPandC_No);

        assertBlank(MedicaidCovered_Yes, MedicaidCovered_No);
        assertHidden(MedicaidSupPremium_Yes,
            MedicaidSupPremium_No,
            Medicaidbenefit_Yes,
            Medicaidbenefit_No);

        assertBlank(ExistingMedicare_Yes, ExistingMedicare_No);
        assertHidden(OtherMedplanstart,
            OtherMedplanend,
            IntentReplace_Yes,
            IntentReplace_No,
            FirstTime_Yes,
            FirstTime_No,
            DropMedSuppForThisPlan_Yes,
            DropMedSuppForThisPlan_No);

        assertBlank(ExistMedSupp_Yes, ExistMedSupp_No);
        assertHidden(ReplaceExistingMedSup_Yes,
            ReplaceExistingMedSup_No,
                MOPlanCode,
                MOAnniversaryDate);

        assertBlank(OtherInsCoverage_Yes, OtherInsCoverage_No);
        assertHidden(OtherInsCompany,
            OtherInsType,
            OtherInsStart,
            OtherInsEnd,
            OtherInsReplace_Yes,
            OtherInsReplace_No);

        assertBlank(CpaSignatureInd);

    }

    public void fillAndSubmit(Application app) {

        verifyInitialStateOfElements(app);

        UnderstandPandC_Yes.click();

      fillYesNoQuestion(MedicaidCovered_Yes, MedicaidCovered_No, app.getMedicaidCovered());
         if(app.getMedicaidCovered().equals(YES)) {
            fillYesNoQuestion(MedicaidSupPremium_Yes, MedicaidSupPremium_No, app.getMedicaidSupPremium());
            fillYesNoQuestion(Medicaidbenefit_Yes, Medicaidbenefit_No, app.getMedicaidbenefit());
        }

        fillYesNoQuestion(ExistingMedicare_Yes, ExistingMedicare_No, app.getExistingMedicare());
        if(app.getExistingMedicare().equals(YES)){
            fill(OtherMedplanstart).with(app.getOtherMedplanstart());
            fill(OtherMedplanend).with(app.getOtherMedplanend());
            fillYesNoQuestion(IntentReplace_Yes, IntentReplace_No, app.getIntentReplace());
            fillYesNoQuestion(FirstTime_Yes, FirstTime_No, app.getFirstTime());
            fillYesNoQuestion(DropMedSuppForThisPlan_Yes, DropMedSuppForThisPlan_No, app.getDropMedSuppForThisPlan());
        }

        fillYesNoQuestion(ExistMedSupp_Yes, ExistMedSupp_No, app.getExistMedSupp());
        if(app.getExistMedSupp().equals(YES)){
            fillYesNoQuestion(ReplaceExistingMedSup_Yes, ReplaceExistingMedSup_No, app.getReplaceExistingMedSup());
            fill(MOPlanCode).with(app.getMOPlanCode());
            fill(MOAnniversaryDate).with(app.getMOAnniversaryDate());
        }

        fillYesNoQuestion(OtherInsCoverage_Yes, OtherInsCoverage_No, app.getOtherInsCoverage());
        if(app.getOtherInsCoverage().equals(YES)) {
            fill(OtherInsCompany).with(app.getOtherInsCompany());
            fill(OtherInsType).with(app.getOtherInsType());
            fill(OtherInsStart).with(app.getOtherInsStart());
            fill(OtherInsEnd).with(app.getOtherInsEnd());
            fillYesNoQuestion(OtherInsReplace_Yes, OtherInsReplace_No, app.getOtherInsReplace());
        }

        CpaSignatureInd.click();

        verifyStateOfElementAfterAnswers(app);

        clickNextAndWaitForSpinnerToFinish();
    }

    public void verifyStateOfElementAfterAnswers(Application app) {

        assertThat(UnderstandPandC_Yes.isSelected(), equalTo(true));

        assertVisible(MedicaidCovered_Yes, MedicaidCovered_No);
        assertYesNoQuestion(MedicaidCovered_Yes, MedicaidCovered_No, app.getMedicaidCovered());
        assertVisibleBasedUpon(app.getMedicaidCovered().equals(YES),
            MedicaidSupPremium_Yes,
            MedicaidSupPremium_No,
            Medicaidbenefit_Yes,
            Medicaidbenefit_No);

        assertVisible(ExistingMedicare_Yes, ExistingMedicare_No);
        assertYesNoQuestion(ExistingMedicare_Yes, ExistingMedicare_No, app.getExistingMedicare());
        assertVisibleBasedUpon(app.getExistingMedicare().equals(YES),
            OtherMedplanstart,
            OtherMedplanend,
            IntentReplace_Yes,
            IntentReplace_No,
            FirstTime_Yes,
            FirstTime_No,
            DropMedSuppForThisPlan_Yes,
            DropMedSuppForThisPlan_No);
        assertThat(OtherMedplanstart.getValue(), equalTo(app.getOtherMedplanstart()));
        assertThat(OtherMedplanend.getValue(), equalTo(app.getOtherMedplanend()));

        assertVisible(ExistMedSupp_Yes, ExistMedSupp_No);
        assertYesNoQuestion(ExistMedSupp_Yes, ExistMedSupp_No, app.getExistMedSupp());
        assertVisibleBasedUpon(app.getExistMedSupp().equals(YES),
            ReplaceExistingMedSup_Yes,
            ReplaceExistingMedSup_No,
            MOPlanCode,
            MOAnniversaryDate);

        assertVisible(OtherInsCoverage_Yes, OtherInsCoverage_No);
        assertYesNoQuestion(OtherInsCoverage_Yes, OtherInsCoverage_No, app.getOtherInsCoverage());
        assertVisibleBasedUpon(app.getOtherInsCoverage().equals(YES),
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

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Past and Current Insurance Coverage"));
    }
}
