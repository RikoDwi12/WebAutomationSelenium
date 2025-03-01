package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By usernameField = By.xpath("//input[@id=\"inputUsername\"]");
    private By passwordField = By.xpath("//input[@placeholder=\"Password\"]");
    private By loginButton = By.cssSelector("button[type=\"submit\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }
}
