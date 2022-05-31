package io.github.burakkaygusuz.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginScreen extends BaseScreen {

    private final By headerTextLocator = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
    private final By usernameInputFieldLocator = AppiumBy.accessibilityId("Username input field");
    private final By passwordInputFieldLocator = AppiumBy.accessibilityId("Password input field");
    private final By loginButtonLocator = AppiumBy.accessibilityId("Login button");

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        WebElement headerText = wait.until(ExpectedConditions.visibilityOfElementLocated(headerTextLocator));
        return headerText.getText();
    }

    public void doLogin(String username, String password) {
        final WebElement usernameInputField = wait.until(ExpectedConditions.presenceOfElementLocated(usernameInputFieldLocator));
        usernameInputField.sendKeys(username);
        final WebElement passwordInputField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordInputFieldLocator));
        passwordInputField.sendKeys(password);
        final WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
    }

}
