package automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.pageOpject.ChartPage;
import com.webautomation.pageOpject.ConfirmationPage;
import com.webautomation.pageOpject.LoginPage;
import com.webautomation.pageOpject.LogoutPage;
import com.webautomation.pageOpject.ProductPage;
import com.webautomation.pageOpject.SuggestionPage;

public class Checkout {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testCheckoutDetail() throws InterruptedException {
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart("Sauce Labs Backpack");
        productPage.goToCart();
        Thread.sleep(1000);

        ChartPage chartPage = new ChartPage(driver);
        chartPage.proceedToCheckout();
        Thread.sleep(1000);

        // Scenario shipping
        SuggestionPage checkoutPage = new SuggestionPage(driver);
        checkoutPage.fillCheckoutDetails("coba12", "coba", "180202");
        checkoutPage.finishCheckout();
        Thread.sleep(2000);

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationMessage = confirmationPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!");
    }

    @AfterClass
    public void LogOut() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logOut();
        driver.quit();
    }

}
