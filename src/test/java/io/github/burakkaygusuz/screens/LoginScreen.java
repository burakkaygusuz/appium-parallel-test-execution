package io.github.burakkaygusuz.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginScreen extends BaseScreen {

    private final By headerTextLocator;
    private final By usernameInputFieldLocator;
    private final By passwordInputFieldLocator;
    private final By loginButtonLocator;

    public LoginScreen(WebDriver driver) {
        super(driver);

        headerTextLocator = id("com.saucelabs.mydemoapp.android:id/loginTV");
        usernameInputFieldLocator = id("com.saucelabs.mydemoapp.android:id/nameET");
        passwordInputFieldLocator = id("com.saucelabs.mydemoapp.android:id/passwordET");
        loginButtonLocator = id("com.saucelabs.mydemoapp.android:id/loginBtn");
    }

    public String getHeaderText() {
        return wait.until(visibilityOfElementLocated(headerTextLocator)).getText();
    }

    public void doLogin(String username, String password) {
        wait.until(visibilityOfElementLocated(usernameInputFieldLocator)).sendKeys(username);
        wait.until(visibilityOfElementLocated(passwordInputFieldLocator)).sendKeys(password);
        wait.until(elementToBeClickable(loginButtonLocator)).click();
    }
}