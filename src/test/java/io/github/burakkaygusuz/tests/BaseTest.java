package io.github.burakkaygusuz.tests;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.burakkaygusuz.utils.PropertyUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

  protected PropertyUtil props = PropertyUtil.getInstance("config.properties");
  private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
  protected WebDriver driver;

  @BeforeMethod
  @Parameters(value = { "udid", "platformVersion" })
  public void setUp(String udid, String platformVersion) {
    try {
      URL url = new URI(props.getProperty("APP_URL")).toURL();
      final UiAutomator2Options options = createUIAutomator2Options(udid, platformVersion, url);
      DRIVER_THREAD_LOCAL.set(new RemoteWebDriver(options, false));
      driver = getDriver();
    } catch (URISyntaxException | MalformedURLException e) {
      throw new RuntimeException("Failed to initialize driver", e);
    }
  }

  @AfterMethod(alwaysRun = true)
  public synchronized void tearDown() {
    if (driver != null) {
      try {
        driver.quit();
      } finally {
        DRIVER_THREAD_LOCAL.remove();
      }
    }
  }

  private WebDriver getDriver() {
    WebDriver webDriver = DRIVER_THREAD_LOCAL.get();
    if (webDriver == null) {
      throw new WebDriverException("WebDriver has not been initialized");
    }
    return webDriver;
  }

  private UiAutomator2Options createUIAutomator2Options(String udid, String platformVersion, URL appUrl) {
    return new UiAutomator2Options()
        .setUdid(udid)
        .setPlatformVersion(platformVersion)
        .setApp(appUrl)
        .setNewCommandTimeout(Duration.ofMinutes(30))
        .setNoReset(true)
        .setSkipUnlock(true)
        .setAutoGrantPermissions(true)
        .setDisableWindowAnimation(true)
        .setClearDeviceLogsOnStart(true);
  }
}
