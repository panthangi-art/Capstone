package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;

public class MultipleProductsTest {

    WebDriver driver;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions();
        driver = DriverFactory.initializeDriver();
    }

    @Test
    public void verifyMultipleProducts() {

        ProductsPage products =
                new ProductsPage(driver);

        products.searchProduct("Cucumber");
        products.addProductToCart();

        driver.navigate().refresh();

        products.searchProduct("Tomato");
        products.addProductToCart();

        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown() {
        actions.takeScreenshot(driver,"verifyMultipleProducts");
        driver.quit();
    }
}