package testcases;

import baseTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.CartPage;
import pages.CheckOutPage;
import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;
import utils.WaitUtils;

import java.io.IOException;

import static baseTest.BasePageTest.driver;

public class PlaceOrderTest extends BasePageTest {


    ProductsPage products;
    CartPage cart;
    CheckOutPage checkout;
    UIActions actions;
    @BeforeMethod
    public void setup() {
        actions = new UIActions(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckOutPage(driver);

    }

    @Test
    public void verifyPlaceOrder() throws InterruptedException {

        products.searchProduct("cucumber");

        products.addProductToCart();

        products.clickCartIcon();

        cart.clickProceedToCheckout();

        checkout.clickPlaceOrder();

        checkout.openAndSelectCountryDropdown();

        checkout.checkboxAndProceed();

        String message = checkout.gettext();

        Assert.assertTrue(checkout.isPlaceOrderDisplayed(), message + "Place Order is failed");
    }




}