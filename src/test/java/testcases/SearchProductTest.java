package testcases;

import baseTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;

public class SearchProductTest extends BasePageTest {

    ProductsPage products;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions(driver);
        products = new ProductsPage(driver);
    }

    @Test
    public void verifySearchProduct() throws InterruptedException {

        products.searchProduct("cucumber");

        String productName = products.getProductName();

        Assert.assertTrue(productName.contains("Cucumber - 1 Kg"), "Product name does not contain 'Cucumber - 1 Kg'");
    }


}