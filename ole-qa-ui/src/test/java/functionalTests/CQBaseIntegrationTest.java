package functionaltests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import resources.entity.Application;
import resources.entity.phone.CribSheet;
import resources.pages.phonepages.oldOlePages.CheatPage;
import org.apache.commons.io.FileUtils;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.adapter.util.SharedDriver;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import resources.utils.AnswerUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;







import static org.slf4j.LoggerFactory.getLogger;

@SharedDriver(type = SharedDriver.SharedType.PER_CLASS)
public class CQBaseIntegrationTest extends FluentTest {

    public WebDriver driver;
    protected final Logger logger = getLogger(this.getClass());
    protected Gson gson = new GsonBuilder().create();
    protected Application app;
    protected String NO = AnswerUtils.NO;
    protected String YES = AnswerUtils.YES;
    protected String UNSURE = AnswerUtils.UNSURE;
    protected String BLANK = AnswerUtils.BLANK;
    //Comment the below 3 lines if your not using Browser Stack
    public static final String USERNAME = "holleyrussell1";
    public static final String AUTOMATE_KEY = "e1hxsgqbj5542GMQCAev";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";


    @Rule
    public TestRule testWatcher = new TestWatcher() {
        @Override
        public void failed(Throwable e, Description test){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                // make sure target directory exists
                new File("target/surefire-reports/").mkdirs();
                String path = String.format("target/surefire-reports/screenshot-%s.png", test.getMethodName());
                logger.info(String.format("Saving screenshot to %s", path));
                FileUtils.copyFile(scrFile, new File(path));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };

    @Override
    public WebDriver getDefaultDriver() {
 //       logger.info(String.format("Using driver: webdriver.firefox.bin=%s", System.getProperty("webdriver.firefox.bin")));
//        Comment the below lines if your not using Browser Stack
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "IE");
////        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "11");
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "7");
//        caps.setCapability("browserstack.debug", "true");
//        //caps.setCapability("local", "true");
//        caps.setCapability("acceptSslCert", "true");
//        caps.setCapability("checkURL", "false");
//
//        try {
//            driver = new RemoteWebDriver(new java.net.URL(URL), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        //Comment the below line to run test in browser stack
       driver = new FirefoxDriver();
        return driver;

    }

    @After
    public void teardown(){
        executeScript("window.onbeforeunload = null;");
    }

    protected void startApp(resources.pages.phonepages.uwExpansionPages.CheatPage cheatPage, Application app, CribSheet sheet) {

        app.setAnswersWithSheetValues(sheet);
        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
    }

    protected void startApp(CheatPage cheatPage, Application app, CribSheet sheet) {

        app.setAnswersWithSheetValues(sheet);
        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
    }

    public String getScriptResult(String script) {
        if (find("body > #output").size() == 0) {
            executeScript("$('body').append('<div id=\"output\"/>');");
            await().atMost(10, TimeUnit.SECONDS).until("body > #output").isPresent();
        }
        executeScript("$('#output').text('');");
        executeScript("$('#output').text(" + script + ");");
        return find("body > #output").getText();
    }
}


