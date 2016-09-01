package resources.pages.greenbaypages;

import resources.pages.WizardPage;
import resources.utils.PropertyUtils;

public class LandingPage extends WizardPage {

    public  String getUrl() {
        return PropertyUtils.getProperty("greenbay.url");
    }


}
