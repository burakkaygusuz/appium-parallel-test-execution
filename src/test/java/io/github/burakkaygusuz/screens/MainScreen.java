package io.github.burakkaygusuz.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.appium.java_client.AppiumBy.*;

public class MainScreen extends BaseScreen {

    private final By openMenuButtonLocator = accessibilityId("open menu");
    private final By loginMenuItemLocator = accessibilityId("menu item log in");

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
