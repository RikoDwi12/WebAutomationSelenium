package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class LoginPage extends AbstractComponentWait {
    WebDriver driver;

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

    // ✅ Tambahkan elemen yang muncul saat login sukses
    By inventoryPage = By.id("inventory_container");

    // ✅ Tambahkan elemen yang muncul saat login gagal
    By errorMessage = By.cssSelector(".error-message-container");

    public void loginApplication(String email, String password) {
        visibilityOfElementLocated(By.id("user-name"));
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
    }

    // ✅ Cek apakah login berhasil
    public boolean isLoginSuccessful() {
        return isElementDisplayed(inventoryPage);
    }

    // ✅ Cek apakah login gagal
    public boolean isLoginFailed() {
        return isElementDisplayed(errorMessage);
    }

    // ✅ Helper method untuk mengecek apakah elemen ada di halaman
    public boolean isElementDisplayed(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
