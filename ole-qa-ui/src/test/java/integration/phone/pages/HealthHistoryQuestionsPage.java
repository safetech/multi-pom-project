package integration.phone.pages;

import integration.phone.entity.Application;
import org.fluentlenium.core.domain.FluentWebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HealthHistoryQuestionsPage extends WizardPage{

    FluentWebElement aneurysm;
    FluentWebElement sclerosis;
    FluentWebElement artery;
    FluentWebElement atrial;
    FluentWebElement cardiomyopathy;
    FluentWebElement carotid;
    FluentWebElement CHF;
    FluentWebElement CAD;
    FluentWebElement heart_attack;
    FluentWebElement PVD;
    FluentWebElement stroke;
    FluentWebElement diabetes_child;
    FluentWebElement ventricular;
    FluentWebElement COPD;
    FluentWebElement emphysema;
    FluentWebElement othercancer;
    FluentWebElement leukemia;
    FluentWebElement melanoma;
    FluentWebElement renalfailure;
    FluentWebElement polycystic;
    FluentWebElement renal;
    FluentWebElement cirrhosis;
    FluentWebElement bonemarrow;
    FluentWebElement pancreatitis;
    FluentWebElement esophageal_varices;
    FluentWebElement amputation;
    FluentWebElement rheumatoid;
    FluentWebElement spinal_stenosis;
    FluentWebElement alcohol;
    FluentWebElement drug;
    FluentWebElement paraplegia;
    FluentWebElement bipolar;
    FluentWebElement schizophrenia;
    FluentWebElement macular;
    FluentWebElement ALS;
    FluentWebElement alzheimers;
    FluentWebElement multiple_sclerosis;
    FluentWebElement parkinsons;
    FluentWebElement nervous_condition;
    FluentWebElement AIDS;
    FluentWebElement HIV;

    public void fillAndSubmit(Application app) {

        isAt();

        fillCheckboxQuestion(aneurysm, app.getAneurysm());
        fillCheckboxQuestion(sclerosis, app.getSclerosis());
        fillCheckboxQuestion(artery, app.getArtery());
        fillCheckboxQuestion(atrial, app.getAtrial());
        fillCheckboxQuestion(cardiomyopathy, app.getCardiomyopathy());
        fillCheckboxQuestion(carotid, app.getCarotid());
        fillCheckboxQuestion(CHF, app.getCHF());
        fillCheckboxQuestion(CAD, app.getCAD());
        fillCheckboxQuestion(heart_attack, app.getHeart_attack());
        fillCheckboxQuestion(PVD, app.getPVD());
        fillCheckboxQuestion(stroke, app.getStroke());
        fillCheckboxQuestion(ventricular, app.getVentricular());
        fillCheckboxQuestion(diabetes_child, app.getDiabetes_child());
        fillCheckboxQuestion(COPD, app.getCOPD());
        fillCheckboxQuestion(emphysema, app.getEmphysema());
        fillCheckboxQuestion(othercancer, app.getOthercancer());
        fillCheckboxQuestion(leukemia, app.getLeukemia());
        fillCheckboxQuestion(melanoma, app.getMelanoma());
        fillCheckboxQuestion(renalfailure, app.getRenalfailure());
        fillCheckboxQuestion(polycystic, app.getPolycystic());
        fillCheckboxQuestion(renal, app.getRenal());
        fillCheckboxQuestion(cirrhosis, app.getCirrhosis());
        fillCheckboxQuestion(bonemarrow, app.getBonemarrow());
        fillCheckboxQuestion(pancreatitis, app.getPancreatitis());
        fillCheckboxQuestion(amputation, app.getAmputation());
        fillCheckboxQuestion(esophageal_varices, app.getEsophageal_varices());
        fillCheckboxQuestion(rheumatoid, app.getRheumatoid());
        fillCheckboxQuestion(spinal_stenosis, app.getSpinal_stenosis());
        fillCheckboxQuestion(alcohol, app.getAlcohol());
        fillCheckboxQuestion(drug, app.getDrug());
        fillCheckboxQuestion(paraplegia, app.getParaplegia());
        fillCheckboxQuestion(bipolar, app.getBipolar());
        fillCheckboxQuestion(schizophrenia, app.getSchizophrenia());
        fillCheckboxQuestion(macular, app.getMacular());
        fillCheckboxQuestion(ALS, app.getALS());
        fillCheckboxQuestion(alzheimers, app.getAlzheimers());
        fillCheckboxQuestion(multiple_sclerosis, app.getMultiple_sclerosis());
        fillCheckboxQuestion(parkinsons, app.getParkinsons());
        fillCheckboxQuestion(nervous_condition, app.getNervous_condition());
        fillCheckboxQuestion(AIDS, app.getAIDS());
        fillCheckboxQuestion(HIV, app.getHIV());

        clickNextAndWaitForSpinnerToFinish();

    }

    public void isAt() {
        assertThat(pageTitle.getText(), equalTo("Health History Questions"));
    }
}
