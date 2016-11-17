package resources;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.List;

public class methodEvaluator {

@Test
public void mtest(){

    WebDriver driver;
    ProfilesIni profile = new ProfilesIni();
    FirefoxProfile ffprofile = profile.getProfile("Selenium");
    driver = new FirefoxDriver(ffprofile);
    
    
    driver.get("https://aarpsupplementalhealth-stg.uhc.com/ole/ms-agent.html?cheat=true");
    
        List<WebElement> findElement = driver.findElements(By.tagName("select"));
    System.out.println(findElement.size());

    driver.close();
}
      



}
