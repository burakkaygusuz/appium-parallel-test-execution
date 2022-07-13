package io.github.burakkaygusuz.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainScreen extends BaseScreen {

    private final By openMenuButtonLocator = AppiumBy.accessibilityId("open menu");
    private final By loginMenuItemLocator = AppiumBy.accessibilityId("menu item log in");

    public MainScreen(WebDriver driver) {
        super(driver);
    }

    public MainScreen openMenu() {
        click(loginMenuItemLocator);
        return this;
    }

    public void goToLoginPage() {
        click(openMenuButtonLocator);
    }

}
