package io.github.burakkaygusuz.tests;

import io.github.burakkaygusuz.screens.LoginScreen;
import io.github.burakkaygusuz.screens.MainScreen;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        MainScreen mainScreen = new MainScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

        mainScreen.openMenu().goToLoginPage();
        assertThat(loginScreen.getHeaderText()).isEqualTo("Login");
        loginScreen.doLogin("bob@example.com", "10203040");
    }
}