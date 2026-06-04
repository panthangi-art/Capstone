package testcases;

import baseTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;

import java.io.IOException;

public class MultipleProductsTest extends BasePageTest {


    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions(driver);

    }

    @Test
    public void verifyMultipleProducts() throws InterruptedException {

        ProductsPage products =
                new ProductsPage(driver);

        products.searchProduct("cucumber");
        products.addProductToCart();


        products.searchProduct("Tomato");
        products.addProductToCart();

        Assert.assertTrue(true);
    }


}