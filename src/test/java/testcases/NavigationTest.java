package testcases;

import baseTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import utils.ConfigReaders;
import utils.DriverFactory;
import utils.UIActions;

import java.io.IOException;

public class NavigationTest extends BasePageTest {

    UIActions actions;
    ConfigReaders configReaders;
    @BeforeMethod
    public void setup() {
        actions = new UIActions(driver);
        configReaders = new ConfigReaders();
    }

    @Test
    public void verifyNavigation() {

        String expectedUrl =  configReaders.getPageURL();
        driver.navigate().refresh();

        driver.navigate().back();

        driver.navigate().forward();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                expectedUrl);
    }


}