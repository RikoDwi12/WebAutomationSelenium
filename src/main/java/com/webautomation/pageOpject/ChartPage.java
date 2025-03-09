package com.webautomation.pageOpject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class ChartPage extends AbstractComponentWait {
    WebDriver driver;

    public ChartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // private By checkoutButton = By.id("checkout");
    @FindBy(id = "checkout")
    WebElement btnCheckout;

    // .inventory_item_name
    @FindBy(css = ".inventory_item_name")
    List<WebElement> listProducts;

    By rowButton = By.id("checkout");

    public void goToCheckoutPage() {
        visibilityOfElementLocated(rowButton);
        btnCheckout.click();
    }

    public Boolean verifyCheckoutProduct(String productName) {
        visibilityOfElementLocated(rowButton);
        Boolean match = listProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

        return match;
    }
}
