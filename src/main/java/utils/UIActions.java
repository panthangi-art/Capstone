package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class UIActions {
    WebDriver driver;
    WebDriverWait wait;
    public UIActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clearAndType(By element, String text) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void selectByVisibleText(By element, String value){
        WebElement dropdown = driver.findElement(element);
        Select select  = new Select(dropdown);
        select.selectByVisibleText(value);
    }


    public static String takeScreenshot(WebDriver driver,
                                           String testName)
            throws IOException {

        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String path =
                "screenshots/" + testName + ".png";

        File dest = new File(path);

        FileUtils.copyFile(src, dest);

        return path;
    }
}