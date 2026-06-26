package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static Properties initProperties(){

        properties = new Properties();

        try{
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return properties;
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
