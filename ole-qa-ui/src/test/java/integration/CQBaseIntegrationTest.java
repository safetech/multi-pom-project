package integration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Application;
import entity.phone.CribSheet;
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
import pages.phone.CheatPage;
import util.AnswerUtils;

import java.io.File;
import java.io.IOException;

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
        logger.info(String.format("Using driver: webdriver.firefox.bin=%s", System.getProperty("webdriver.firefox.bin")));
        driver = new FirefoxDriver();
        return driver;
    }

    /*
@Override
    public WebDriver getDefaultDriver() {
        logger.info(String.format("Using driver: webdriver.chrome.driver=%s", System.getProperty("webdriver.chrome.driver")));

        driver = new ChromeDriver();
        return driver;
    }
*/

    @After
    public void teardown(){
        executeScript("window.onbeforeunload = null;");
    }

    protected void startApp(CheatPage cheatPage, Application app, CribSheet sheet) {

        app.setAnswersWithSheetValues(sheet);
        logger.info(gson.toJson(app));

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);
    }
}

