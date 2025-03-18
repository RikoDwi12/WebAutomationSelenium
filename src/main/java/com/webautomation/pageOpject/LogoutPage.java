package com.webautomation.pageOpject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    WebDriver driver;

    // Lokator elemen
    private By HamburgerButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private By ElementHumberger = By.xpath("//nav[@class='bm-item-list']//a[@data-test='inventory-sidebar-link']");
    private By LogoutButton = By.id("logout_sidebar_link");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() {
        driver.findElement(HamburgerButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ElementHumberger));
        driver.findElement(LogoutButton).click();
    }
}
