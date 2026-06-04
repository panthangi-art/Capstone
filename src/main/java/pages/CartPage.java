package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReaders;
import utils.UIActions;
import utils.WaitUtils;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    UIActions uiActions;
    WaitUtils wait;
    ConfigReaders configReaders = new ConfigReaders();
    public CartPage(WebDriver driver) {
        this.driver = driver;
        uiActions = new UIActions(driver);
        wait = new WaitUtils(driver, Duration.ofSeconds(configReaders.getWait()));
    }
    By cartIconLink = By.xpath("//a[@class='cart-icon']");
    By cartProduct =
            By.xpath("//p[@class='product-name']");

    By quantity =
            By.xpath("//td[3]/strong");

    By proceedToCheckout =
            By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public void openCart() {
        uiActions.click(cartIconLink);
    }

    public String getCartProductName() {
        return driver.findElement(cartProduct).getText();
    }

    public String getQuantity() {
        return driver.findElement(quantity).getText();
    }

    public void clickProceedToCheckout() throws InterruptedException {
        Thread.sleep(1000);
        wait.waitForElementToBeVisible(proceedToCheckout);
        uiActions.click(proceedToCheckout);

    }


}
