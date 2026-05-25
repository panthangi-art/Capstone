package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import utils.DriverFactory;
import utils.UIActions;

public class NavigationTest {

    WebDriver driver;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions();
        driver = DriverFactory.initializeDriver();
    }

    @Test
    public void verifyNavigation() {

        String expectedUrl =
                "https://rahulshettyacademy.com/seleniumPractise/#/";

        driver.navigate().refresh();

        driver.navigate().back();

        driver.navigate().forward();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                expectedUrl);
    }

    @AfterMethod
    public void tearDown() {
        actions.takeScreenshot(driver,"verifyNavigation");
        driver.quit();
    }
}