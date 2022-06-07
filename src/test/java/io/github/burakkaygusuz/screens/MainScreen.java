package io.github.burakkaygusuz.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreen extends BaseScreen {

    private final By openMenuButtonLocator = AppiumBy.accessibilityId("open menu");
    private final By loginMenuItemLocator = AppiumBy.accessibilityId("menu item log in");

    public MainScreen(AppiumDriver driver) {
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
