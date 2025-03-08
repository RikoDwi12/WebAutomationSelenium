package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class LoginPage extends AbstractComponentWait {
    // ini kodingan lama
    WebDriver driver;

    // private By usernameField = By.id("user-name");
    // private By passwordField = By.id("password");
    // private By loginButton = By.id("login-button");

    // public LoginPage(WebDriver driver) {
    // this.driver = driver;
    // }

    // public void login(String username, String password) {
    // driver.findElement(usernameField).sendKeys(username);
    // driver.findElement(passwordField).sendKeys(password);

    // driver.findElement(loginButton).click();
    // }

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement userEmail;

    @FindBy(id = "password")
    WebElement userPassword;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    By cartButton = By.id("user-name");

    public void loginApplication(String email, String password) {
        visibilityOfElementLocated(cartButton);
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
    }

}
