package io.github.burakkaygusuz.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainScreen extends BaseScreen {

    private final By openMenuButtonLocator = AppiumBy.accessibilityId("open menu");
    private final By loginMenuItemLocator = AppiumBy.accessibilityId("menu item log in");

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public MainScreen openMenu() {
        final WebElement openMenuButton = wait.until(ExpectedConditions.elementToBeClickable(openMenuButtonLocator));
        openMenuButton.click();
        return this;
    }

    public void goToLoginPage() {
        final WebElement loginMenuItem = wait.until(ExpectedConditions.elementToBeClickable(loginMenuItemLocator));
        loginMenuItem.click();
    }

}
