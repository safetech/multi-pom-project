package integration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.time.DateUtils;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.adapter.util.SharedDriver;
import org.fluentlenium.core.Fluent;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static javax.json.Json.createReader;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@SharedDriver(type = SharedDriver.SharedType.PER_CLASS)
public class CQBaseIntegrationTest extends FluentTest {

    public WebDriver driver;
    protected final Logger logger = getLogger(this.getClass());
    protected Gson gson = new GsonBuilder().create();

    @Override
    public WebDriver getDefaultDriver() {
        logger.info(String.format("Using driver: webdriver.firefox.bin=%s", System.getProperty("webdriver.firefox.bin")));
        driver = new FirefoxDriver();
        return driver;
    }

    @After
    public void teardown(){
        executeScript("window.onbeforeunload = null;");
    }

}