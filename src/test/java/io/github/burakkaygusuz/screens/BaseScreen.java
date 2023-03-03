package io.github.burakkaygusuz.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BaseScreen {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator) {
        WebElement element = wait.until(visibilityOfElementLocated(locator));
        wait.until(elementToBeClickable(element)).click();
    }

    protected String getText(By locator) {
        return wait.until(visibilityOfElementLocated(locator)).getText();
    }

    protected void sendKeys(By locator, CharSequence keysToSend) {
        wait.until(visibilityOfElementLocated(locator)).sendKeys(keysToSend);
    }
}
