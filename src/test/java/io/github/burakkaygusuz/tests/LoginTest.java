package io.github.burakkaygusuz.tests;

import io.appium.java_client.AppiumBy;
import io.github.burakkaygusuz.screens.LoginScreen;
import io.github.burakkaygusuz.screens.MainScreen;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        MainScreen mainScreen = new MainScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

        mainScreen.viewMenu().goToLoginPage();
        assertThat(loginScreen.getHeaderText()).isEqualTo("Login");
        loginScreen.doLogin("bod@example.com", "10203040");

        assertThat(driver.findElement(AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV")).getText()).isEqualTo("Products");
    }
}