package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReaders;
import utils.UIActions;
import utils.WaitUtils;

public class ProductsPage {

    WebDriver driver;
    UIActions uiActions;
    WaitUtils wait;
    ConfigReaders configReaders =  new ConfigReaders();

    By search = By.xpath("//input[@type='search']");

    By searchButton = By.xpath("//button[@type='submit']");

    By products = By.xpath("//h4[@class='product-name']");

    By productInResult = By.xpath("//h4[@class='product-name' and text()='Cucumber - 1 Kg']");

    By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");

    By cartIcon = By.xpath("//img[@alt='Cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.uiActions =  new UIActions(driver);
        this.wait = new WaitUtils(driver, Duration.ofSeconds(configReaders.getWait()));

    }

    public void searchProduct(String value) throws InterruptedException {

        uiActions.clearAndType(search, value);
        uiActions.click(searchButton);

        // Wait for results to be visible (first product)
        Thread.sleep(1000);
        wait.waitForElementToBePresent(productInResult);
        System.out.println("Searching for product " + driver.findElement(products).getText());
    }

    public String getProductName()  {
        String name = driver.findElement(productInResult).getText();
        if (name.contains("Cucumber")) {
            System.out.println("Product found: " + name);
        } else {
            System.out.println("Product not found in search results.");
        }
        return name;
    }
    public void addProductToCart() {

        try {

            wait.waitForElementToBePresent(productInResult);
            driver.findElement(addToCartBtn).click();

        } catch (StaleElementReferenceException e) {

            System.out.println("Element became stale, retrying...");

            if (driver.findElement(addToCartBtn).isDisplayed()) {

                wait.waitForElementToBePresent(productInResult);
                driver.findElement(addToCartBtn).click();
                System.out.println("Element clicked successfully after retry.");

            } else {

                System.out.println("Element is not visible.");
            }
        }
    }


    public void clickCartIcon() {

        driver.findElement(cartIcon).click();
    }


}