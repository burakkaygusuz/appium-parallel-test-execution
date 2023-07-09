package io.github.burakkaygusuz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    private static PropertyUtils instance;
    private final Properties properties = new Properties();

    private PropertyUtils() {
    }

    public static synchronized PropertyUtils getInstance() {
        if (instance == null)
            instance = new PropertyUtils();
        return instance;
    }

    public Properties loadProperties(String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
