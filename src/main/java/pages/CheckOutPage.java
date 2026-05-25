package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    By placeOrder = By.xpath("//button[text()='Place Order']");
    By countryDropdown = By.xpath("//select[@style='width: 200px;']");
    By checkBox = By.cssSelector(".chkAgree");
    By proceedToCheckBox =  By.xpath("//button[text()='Proceed']");
    By successMessage = By.cssSelector(".wrapperTwo");

    public void clickPlaceOrder() {

        driver.findElement(placeOrder).click();
    }
    public void openAndSelectCountryDropdown(){
        driver.findElement(countryDropdown).click();
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText("India");

    }

    public void checkboxAndProceed(){
        driver.findElement(checkBox).click();
         driver.findElement(proceedToCheckBox).click();
    }

    public String gettext() throws InterruptedException {
        Thread.sleep(3000);
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