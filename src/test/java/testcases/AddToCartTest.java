package testcases;

import baseTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.CartPage;
import pages.ProductsPage;
import utils.DriverFactory;
import utils.UIActions;

import java.io.IOException;

public class AddToCartTest extends BasePageTest {


    UIActions actions;
    ProductsPage products;
    CartPage cart;
    @BeforeMethod
    public void setup() {
        actions = new UIActions(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
    }

    @Test
    public void verifyAddToCart() throws InterruptedException {

        products.searchProduct("Brocolli");

        products.addProductToCart();

        products.clickCartIcon();

        String cartProduct = cart.getCartProductName();

        Assert.assertTrue(cartProduct.contains("Brocolli"), "Cart product name does not contain 'Brocolli - 1 Kg'");

        Assert.assertEquals(cart.getQuantity(), "1");
        System.out.println("Product added to cart successfully with correct quantity.");
    }


}