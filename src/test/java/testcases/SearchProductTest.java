package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;

public class SearchProductTest {

    WebDriver driver;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions();
        driver = DriverFactory.initializeDriver();
    }

    @Test
    public void verifySearchProduct() {

        ProductsPage products = new ProductsPage(driver);

        products.searchProduct("Cucumber");

        String productName = products.getProductName();

        System.out.println(productName);
        Assert.assertTrue(productName.contains("Cucumber - 1 Kg"), "Product name does not contain 'Cucumber - 1 Kg'");
    }

    @AfterMethod
    public void tearDown() {
        actions.takeScreenshot(driver,"verifySearchProduct");
        driver.quit();
    }
}