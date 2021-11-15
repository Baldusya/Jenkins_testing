package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {
    private static final String PATH = "src/main/resources/";

    public static String propertiesParse(String fileName, String propertiesVariable) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertiesVariable);
    }
}
