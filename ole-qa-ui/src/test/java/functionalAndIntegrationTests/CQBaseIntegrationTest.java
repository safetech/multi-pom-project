package functionalAndIntegrationTests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.slf4j.Logger;
import resources.entity.Application;
import resources.entity.phone.CribSheet;
import resources.pages.phonepages.oldOlePages.CheatPage;
import resources.utils.AnswerUtils;
import resources.utils.PropertyUtils;

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
    protected static String BLANK = AnswerUtils.BLANK;
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
//        logger.info(String.format("Using driver: webdriver.firefox.driver=%s", System.getProperty("~/Application/x/Firefox.app")));

    @Override
    public WebDriver getDefaultDriver() {


//     System.setProperty("webdriver.chrome.driver", "C:\\temp\\Apps\\Chromedriver\\chromedriver.exe");
//     driver=new ChromeDriver();
//      return driver;

        if(PropertyUtils.getProperty( "Browser" ).equals( "Firefox" )){
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffprofile = profile.getProfile("Selenium");
        driver = new FirefoxDriver(ffprofile);
//        driver.manage().window().maximize();
        }else {
        System.setProperty("webdriver.chrome.driver","/Users/sislam13/dev/apps/chrome/chrome-46/chromedriver");
        driver = new ChromeDriver(  );
        }
        
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


