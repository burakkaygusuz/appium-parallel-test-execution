package io.github.burakkaygusuz.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private final ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();
    public AppiumDriver driver;

    @BeforeMethod
    @Parameters({"udid", "platformVersion"})
    @SneakyThrows(MalformedURLException.class)
    public void setUp(@Optional("udid") String udid, @Optional("platformVersion") String platformVersion) {

        URL url = new URL("https://github.com/saucelabs/my-demo-app-rn/releases/download/v1.3.0/Android-MyDemoAppRN.1.3.0.build-244.apk");
        final UiAutomator2Options options = new UiAutomator2Options().setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setApp(url)
                .setNoReset(false)
                .skipUnlock()
                .setAutoGrantPermissions(true);

        driverThreadLocal.set(new AndroidDriver(new URL("http://localhost:4723"), options));
        driver = driverThreadLocal.get();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driverThreadLocal.remove();
    }
}
