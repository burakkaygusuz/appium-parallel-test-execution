package io.github.burakkaygusuz.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {

    private final By headerTextLocator = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
    private final By usernameInputFieldLocator = AppiumBy.accessibilityId("Username input field");
    private final By passwordInputFieldLocator = AppiumBy.accessibilityId("Password input field");
    private final By loginButtonLocator = AppiumBy.accessibilityId("Login button");

    public LoginScreen(AppiumDriver driver) {
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
