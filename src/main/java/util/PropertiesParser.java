package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesParser {
    private static final String ROOT_PATH = Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
            .getResource("")).getPath();

    public String localizationParse() {
        Properties localizationProps = new Properties();
        String localizationConfigPath = ROOT_PATH + "localization.properties";
        try {
            localizationProps.load(new FileInputStream(localizationConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localizationProps.getProperty("language");
    }

    public String inputDataParse(String game) {
        Properties inputDataProps = new Properties();
        String inputDataConfigPath = ROOT_PATH + "input_data.properties";
        try {
            inputDataProps.load(new FileInputStream(inputDataConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputDataProps.getProperty(game);
    }
}
