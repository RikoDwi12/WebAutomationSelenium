package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By usernameField = By.id("user-name");
    // private By usernameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.id("password");
    // private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.id("login-button");
    // private By loginButton = By.xpath(null)

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }
}
