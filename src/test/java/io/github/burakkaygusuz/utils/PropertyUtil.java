package io.github.burakkaygusuz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import io.github.burakkaygusuz.exceptions.PropertyUtilException;

public class PropertyUtil {

  private static final AtomicReference<PropertyUtil> instance = new AtomicReference<>(null);
  private final Properties properties;

  private PropertyUtil(String fileName) {
    this.properties = new Properties();
    try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
      properties.load(inputStream);
    } catch (IOException e) {
      throw new PropertyUtilException("Error loading properties file: " + fileName);
    }
  }

  public static PropertyUtil getInstance(String fileName) {
    if (instance.get() == null) {
      instance.compareAndSet(null, new PropertyUtil(fileName));
    }
    return instance.get();
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
