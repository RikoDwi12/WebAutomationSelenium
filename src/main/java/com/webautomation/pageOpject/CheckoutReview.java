package com.webautomation.pageOpject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class CheckoutReview extends AbstractComponentWait {
    WebDriver driver;

    public CheckoutReview(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> listProducts;
    // By elementText = By.cssSelector("inventory_item_name");

    public void getReviewText() {
        finishBtn.click();
    }

    public Boolean verifyProducts(String productName) {
        Boolean match = listProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

        return match;

    }

    // public boolean validateReview(String expectedText) {
    // String actualText = getReviewText();
    // return actualText.equals(expectedText);
    // }
}
