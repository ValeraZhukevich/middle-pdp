package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties properties = new Properties();

    private static void loadProperties() {
        properties.putAll(loadPropertiesFromFile());
    }

    private static Properties loadPropertiesFromFile() {
        try (InputStream inputStream =
                     Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        if (properties.isEmpty()) {
            loadProperties();
        }
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

}
