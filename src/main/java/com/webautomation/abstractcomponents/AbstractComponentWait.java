package com.webautomation.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// destructuring untuk wait element / gantinnya Thread.sleep
public class AbstractComponentWait {
    WebDriver driver;

    public AbstractComponentWait(WebDriver driver) {
        this.driver = driver;
    }

    public void visibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
