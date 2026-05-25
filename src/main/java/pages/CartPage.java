package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartProduct =
            By.xpath("//p[@class='product-name']");

    By quantity =
            By.xpath("//td[3]/strong");

    By proceedToCheckout =
            By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public String getCartProductName() {
        return driver.findElement(cartProduct).getText();
    }

    public String getQuantity() {

        return driver.findElement(quantity).getText();
    }

    public void clickProceedToCheckout() {

        driver.findElement(proceedToCheckout).click();
    }


}