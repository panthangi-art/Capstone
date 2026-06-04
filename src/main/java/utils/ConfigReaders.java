package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaders {

    public static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getPageURL() {
        return properties.getProperty("app.url");
    }
    public  String getBrowser() {

        return properties.getProperty("browser");
    }
    public int getWait() {
        String time =  properties.getProperty("implicit.wait");
        return Integer.parseInt(time);
    }
}