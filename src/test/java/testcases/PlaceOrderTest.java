package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.CartPage;
import pages.CheckOutPage;
import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;
import utils.WaitUtils;

public class PlaceOrderTest {

    WebDriver driver;
    WaitUtils wait;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions();
        driver = DriverFactory.initializeDriver();
    }

    @Test
    public void verifyPlaceOrder() throws InterruptedException {
        wait = new WaitUtils(driver);

        ProductsPage products = new ProductsPage(driver);

        CartPage cart = new CartPage(driver);

        CheckOutPage checkout = new CheckOutPage(driver);

        products.searchProduct("Cucumber");

        products.addProductToCart();

        products.clickCartIcon();

        cart.clickProceedToCheckout();

        checkout.clickPlaceOrder();

        checkout.openAndSelectCountryDropdown();

        checkout.checkboxAndProceed();

        String message = checkout.gettext();

        Assert.assertTrue(checkout.isPlaceOrderDisplayed(), message + "Place Order is failed");
    }



    @AfterMethod
    public void tearDown() {
        actions.takeScreenshot(driver,"verifyPlaceOrder");
        driver.quit();
    }
}