package myTests;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kona on 4/13/2014.
 */
public class WebDriverTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    /* SauceLab
    private WebDriver driver;
    */

    @Before
    public void setUp() throws Exception {
        // Choose the browser, version, and platform to test
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("version", "5");
        //capabilities.setCapability("platform", Platform.XP);
        // Create the connection to Sauce Labs to run the tests
       // this.driver = new RemoteWebDriver(
             //   new URL("http://mtest1:e55c18d3-f3b5-4d1d-9165-0a5f1aa3bcbe@ondemand.saucelabs.com:80/wd/hub"),
               // capabilities);

        driver = new FirefoxDriver();
        baseUrl = "https://www.linkedin.com";
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void basic() throws Exception {
        // Make the browser get the page and check its title
        driver.get(baseUrl);
        assertEquals("World's Largest Professional Network | LinkedIn", driver.getTitle());


    }

    @Test
    public void loginSuccess() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("session_key-login")).clear();
        driver.findElement(By.id("session_key-login")).sendKeys("mtest1.mtest1@gmail.com");
        driver.findElement(By.id("session_password-login")).clear();
        driver.findElement(By.id("session_password-login")).sendKeys("bogra123");
        driver.findElement(By.id("signin")).click();
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Profile")).click();
        driver.findElement(By.linkText("Network")).click();
        driver.findElement(By.linkText("Jobs")).click();
        assertEquals("People You May Know", driver.findElement(By.linkText("People You May Know")).getText());
    }



    @After
    public void tearDown() throws Exception {
       driver.quit();
    }
}
