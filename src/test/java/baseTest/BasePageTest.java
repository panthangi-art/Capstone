package baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import utils.ConfigReaders;
import utils.DriverFactory;



public class BasePageTest {
    ConfigReaders config;
    public static WebDriver driver;

    @BeforeClass
    public void initializeDriver() {

        config = new ConfigReaders();
        driver = DriverFactory.initializeDriver(config.getBrowser());
        driver.get(config.getPageURL());

    }

    @AfterClass
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }

        } catch (Exception e) {
            System.out.println("Error during driver teardown: " + e.getMessage());
        }
    }


}