package io.github.burakkaygusuz.tests;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.burakkaygusuz.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    protected final Properties props = PropertyUtils.getInstance().loadProperties("app.properties");
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    public WebDriver driver;

    @BeforeMethod
    @Parameters(value = {"udid", "platformVersion"})
    public void setUp(String udid, String platformVersion) throws URISyntaxException, MalformedURLException {

        URL url = new URI(props.getProperty("APP_URL")).toURL();
        final UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setApp(url)
                .noReset()
                .skipUnlock()
                .autoGrantPermissions()
                .disableWindowAnimation()
                .clearDeviceLogsOnStart();

        DRIVER_THREAD_LOCAL.set(new RemoteWebDriver(options, false));
        driver = DRIVER_THREAD_LOCAL.get();
    }

    @AfterMethod(alwaysRun = true)
    public synchronized void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
