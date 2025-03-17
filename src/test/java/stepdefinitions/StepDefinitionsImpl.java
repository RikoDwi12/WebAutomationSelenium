package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.webautomation.pageOpject.ChartPage;
import com.webautomation.pageOpject.CheckoutReview;
import com.webautomation.pageOpject.ConfirmationPage;
import com.webautomation.pageOpject.LoginPage;
import com.webautomation.pageOpject.ProductPageNew;
import com.webautomation.pageOpject.SuggestionPage;
import hook.Hooks;
import io.cucumber.java.en.*;

public class StepDefinitionsImpl {
    WebDriver driver;

    @Given("Buyer landing to ecommerce")
    public void buyer_landing_to_ecommerce() { 
        driver = Hooks.initializeDriver();
        driver.manage().window().maximize();
    }
    
   @Given("^Buyer logged to website email (.+) and password (.+)$")
public void login(String email, String password) { 
    LoginPage loginPage = new LoginPage(driver);
    String loginResult = loginPage.loginApplication(email, password);

    // if (loginResult.contains("Login berhasil")) {
    //     Assert.assertTrue(loginPage.isElementDisplayed(By.id("inventory_container")), 
    //         "Login successful: User redirected to inventory page.");
    // } else {
    //     String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    //     Assert.assertEquals(errorMessage, 
    //         "Epic sadface: Username and password do not match any user in this service", 
    //         "Login failed message mismatch!");
    // }
}
    
    @When("^Buyer add Product (.+) to cart$")
    public void buyer_add_product(String productName) { 
        ProductPageNew productListPage = new ProductPageNew(driver);
        productListPage.addToCart(productName);
    }
    
    @And("^Buyer click checkout \"([^\"]*)\"$")
    public void buyer_click_checkout(String productName) throws InterruptedException { 
        ChartPage chartPage = new ChartPage(driver);
        Assert.assertTrue(chartPage.verifyCheckoutProduct(productName));
        chartPage.goToCheckoutPage();
        Thread.sleep(1000);
    }
    
    @And("Buyer fill the form with {string}, {string}, and {string}")
    public void buyer_fill_the_form(String firstName, String lastName, String postalCode) throws InterruptedException { 
        SuggestionPage suggestionPage = new SuggestionPage(driver);
        suggestionPage.fillCheckoutDetails(firstName, lastName, postalCode);
        Thread.sleep(1000);
    }
    
    @And("^Buyer place order \"([^\"]*)\"$")
    public void buyer_place_order(String productName) throws InterruptedException { 
        CheckoutReview checkoutReview = new CheckoutReview(driver);
        Assert.assertTrue(checkoutReview.verifyProducts(productName));
        checkoutReview.getReviewText();
        Thread.sleep(1000);
    }
    
    @Then("^Buyer should see the order confirmation \"([^\"]*)\"$")
    public void buyer_should_see_the_order_confirmation(String successMessage) { 
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationMessage = confirmationPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, successMessage, "Order confirmation message mismatch!");
    }

    // @Then("^Buyer Confirmation login success$")
    // public void confirmationLoginSuccess() { 
    //     LoginPage loginPage = new LoginPage(driver);
    
    //     // Cek apakah berhasil masuk ke halaman inventory
    //     if (loginPage.isElementDisplayed(By.id("inventory_container"))) {
    //         Assert.assertTrue(true, "Login successful: User redirected to inventory page.");
    //     } 
    //     // Cek apakah ada pesan error saat login gagal
    //     else if (loginPage.isElementDisplayed(By.cssSelector("h3[data-test='error']"))) {
    //         String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    //         Assert.assertEquals(errorMessage, 
    //             "Epic sadface: Username and password do not match any user in this service", 
    //             "Login failed message mismatch!");
    //     } 
    //     // Jika tidak ada indikasi berhasil/gagal, gagal tes
    //     else {
    //         Assert.fail("Login status unknown. Neither success nor expected error message found.");
    //     }
    // }
    
    @Then("^Buyer Confirmation login success$")
public void confirmationLoginSuccess() { 
    LoginPage loginPage = new LoginPage(driver);

    // Menggunakan method yang sudah ada di LoginPage
    if (loginPage.isLoginSuccessful()) {
        Assert.assertTrue(true, "Login successful: User redirected to inventory page.");
    } 
    else if (loginPage.isLoginFailed()) {
        // Menggunakan method dari LoginPage untuk mendapatkan error message
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, 
            "Epic sadface: Username and password do not match any user in this service", 
            "Login failed message mismatch!");
    } 
    else {
        Assert.fail("Login status unknown. Neither success nor expected error message found.");
    }
}

}
