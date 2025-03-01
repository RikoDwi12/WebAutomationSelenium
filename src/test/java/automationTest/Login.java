package automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.pageOpject.LoginPage;

public class Login {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
    }

    @Test
    public void testCheckoutDetail() throws InterruptedException {
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("albertjuntak@gmail.com", "rahulshettyacademy");
        Thread.sleep(2000);
    }
}
