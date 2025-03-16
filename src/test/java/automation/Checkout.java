package automation;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webautomation.pageOpject.ChartPage;
import com.webautomation.pageOpject.CheckoutReview;
import com.webautomation.pageOpject.ConfirmationPage;
import com.webautomation.pageOpject.LoginPage;
import com.webautomation.pageOpject.LogoutPage;
import com.webautomation.pageOpject.ProductPageNew;
import com.webautomation.pageOpject.SuggestionPage;

public class Checkout {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win134/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "dataTestMapping")
    public void testCheckoutDetail(HashMap<String, String> input) throws InterruptedException {
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApplication(input.get("userEmail"), input.get("password"));
        Thread.sleep(2000);

        // list product
        String productName = input.get("productName");
        ProductPageNew productListPage = new ProductPageNew(driver);
        productListPage.addToCart(productName);

        // driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        // chart page / confirmation go to checkout
        ChartPage chartPage = new ChartPage(driver);
        Assert.assertTrue(chartPage.verifyCheckoutProduct(productName));
        chartPage.goToCheckoutPage();
        Thread.sleep(1000);

        // scenarioShiiping
        SuggestionPage suggestionPage = new SuggestionPage(driver);
        suggestionPage.fillCheckoutDetails(input.get("firstName"), input.get("lastName"), input.get("postalCode"));
        Thread.sleep(1000);

        CheckoutReview checkoutReview = new CheckoutReview(driver);
        Assert.assertTrue(checkoutReview.verifyProducts(productName));
        checkoutReview.getReviewText();

        Thread.sleep(1000);

        // confirmation
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

    // Mapping
    @DataProvider
    public Object[][] dataTestMapping() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("userEmail", "standard_user");
        map.put("password", "secret_sauce");
        map.put("productName", "Sauce Labs Bike Light");
        map.put("firstName", "John");
        map.put("lastName", "Doe");
        map.put("postalCode", "12345");

        return new Object[][] { { map } };
    }

    // @DataProvider
    // public Object[][] dataSendObjects() {
    // HashMap<String, String> map = new HashMap<String, String>();
    // map.put("firstName", "standard_user");
    // map.put("lastName", "secret_sauce");
    // map.put("postalCode", "secret_sauce");

    // return new Object[][] { { map } };
    // }

}
