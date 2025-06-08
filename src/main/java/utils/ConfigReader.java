package utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    static {
        properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream("src/main/resources/config.properties")){
            properties.load(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowser(){
        return properties.getProperty("browser");
    }

    public static String getBaseUrl(){
        return properties.getProperty("baseUrl");
    }

}
