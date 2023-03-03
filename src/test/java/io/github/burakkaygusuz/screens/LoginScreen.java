package io.github.burakkaygusuz.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.appium.java_client.AppiumBy.*;

public class LoginScreen extends BaseScreen {

    private final By headerTextLocator = xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
    private final By usernameInputFieldLocator = accessibilityId("Username input field");
    private final By passwordInputFieldLocator = accessibilityId("Password input field");
    private final By loginButtonLocator = accessibilityId("Login button");

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getText(headerTextLocator);
    }

    public void doLogin(String username, String password) {
        sendKeys(usernameInputFieldLocator, username);
        sendKeys(passwordInputFieldLocator, password);
        click(loginButtonLocator);
    }
}