package io.github.burakkaygusuz.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainScreen extends BaseScreen {

    private final By viewMenuLocator;
    private final By loginMenuItemLocator;

    public MainScreen(WebDriver driver) {
        super(driver);

        viewMenuLocator = accessibilityId("View menu");
        loginMenuItemLocator = linkText("Log In");
    }

    public MainScreen viewMenu() {
        wait.until(elementToBeClickable(viewMenuLocator)).click();
        return this;
    }

    public void goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginMenuItemLocator)).click();
    }
}
