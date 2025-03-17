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

    // Locator untuk halaman setelah login sukses
    By inventoryPage = By.id("inventory_container");

    // Locator untuk pesan error saat login gagal
    By errorMessage = By.cssSelector("h3[data-test='error']");

    public String loginApplication(String email, String password) {
        visibilityOfElementLocated(By.id("user-name"));
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();

        if (isLoginSuccessful()) {
            return "Login berhasil: " + driver.findElement(inventoryPage).getText();
        } else if (isLoginFailed()) {
            return "Login gagal: " + getErrorMessage();
        }
        return "Login status tidak diketahui.";
    }

    // ✅ Metode untuk cek login sukses
    public boolean isLoginSuccessful() {
        return isElementDisplayed(inventoryPage);
    }

    // ✅ Metode untuk cek login gagal
    public boolean isLoginFailed() {
        return isElementDisplayed(errorMessage);
    }
    
    // ✅ Metode untuk mendapatkan pesan error
    public String getErrorMessage() {
        if (isLoginFailed()) {
            return driver.findElement(errorMessage).getText();
        }
        return "";
    }

    // Helper method untuk mengecek apakah elemen ada di halaman
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}