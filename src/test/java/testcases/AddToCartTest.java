package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.CartPage;
import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;

public class AddToCartTest {

    WebDriver driver;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions();
        driver = DriverFactory.initializeDriver();

    }

    @Test
    public void verifyAddToCart() {

        ProductsPage products = new ProductsPage(driver);

        CartPage cart = new CartPage(driver);

        products.searchProduct("Brocolli");

        products.addProductToCart();

        products.clickCartIcon();

        String cartProduct = cart.getCartProductName();

        Assert.assertTrue(cartProduct.contains("Brocolli"), "Cart product name does not contain 'Brocolli - 1 Kg'");

        Assert.assertEquals(cart.getQuantity(), "1");
    }

    @AfterMethod
    public void tearDown() {
        actions.takeScreenshot(driver,"verifyAddToCart");
        driver.quit();
    }
}