package myTests;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kona on 4/13/2014.
 */
public class WebDriverTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("version", "5");
        capabilities.setCapability("platform", Platform.XP);
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://mtest1:e55c18d3-f3b5-4d1d-9165-0a5f1aa3bcbe@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    @Test
    public void basic() throws Exception {
        // Make the browser get the page and check its title
        driver.get("https://www.linkedin.com/");
        assertEquals("World's Largest Professional Network | LinkedIn", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
