package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader () {}

    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";


    static {
        try {
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace(); //this will print the error location'
        }
    }

    public static String getProperty (String keyName) {
        return  properties.getProperty(keyName);
    }

}



