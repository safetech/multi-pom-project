package integration;

import org.apache.commons.lang3.time.DateUtils;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.adapter.util.SharedDriver;
import org.fluentlenium.core.Fluent;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

@SharedDriver(type = SharedDriver.SharedType.PER_CLASS)
public class CQBaseIntegrationTest extends FluentTest {

    public WebDriver driver;

    @Override
    public WebDriver getDefaultDriver() {
        //You need to point this to your local FF29 installation which you can download at
        //https://ftp.mozilla.org/pub/mozilla.org/firefox/releases/29.0.1/mac/en-US/
        System.setProperty("webdriver.firefox.bin", "/Users/dpfeffe1/dev/apps/firefox/firefox-29/Firefox.app/Contents/MacOS/firefox");
        driver = new FirefoxDriver();
        return driver;
    }

    @After
    public void teardown(){
        executeScript("window.onbeforeunload = null;");
    }

}