package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReaders;
import utils.UIActions;
import utils.WaitUtils;

import java.time.Duration;

public class CheckOutPage {

    WebDriver driver;
    UIActions uiActions;
    WaitUtils wait;
    ProductsPage productsPage;
    CartPage cartPage;
    ConfigReaders configReaders =  new ConfigReaders();

    By placeOrder = By.xpath("//button[text()='Place Order']");
    By countryDropdown = By.xpath("//select[@style='width: 200px;']");
    By checkBox = By.cssSelector(".chkAgree");
    By proceedToCheckBox =  By.xpath("//button[text()='Proceed']");
    By successMessage = By.cssSelector(".wrapperTwo");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.uiActions = new UIActions(driver);
        this.wait = new WaitUtils(driver, Duration.ofSeconds(configReaders.getWait()));
        this.productsPage = new ProductsPage(driver);
        this.cartPage = new CartPage(driver);

    }
    public void clickPlaceOrder() {

        uiActions.click(placeOrder);
    }
    public void openAndSelectCountryDropdown(){
        uiActions.click(countryDropdown);
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText("India");

    }

    public void checkboxAndProceed(){
        uiActions.click(checkBox);
        uiActions.click(proceedToCheckBox);
    }

    public String gettext() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(successMessage).getText();
    }

    public boolean isPlaceOrderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String successMessageText = driver.findElement(successMessage).getText();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            System.out.println(successMessageText);
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}