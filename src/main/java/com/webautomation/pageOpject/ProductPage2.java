package com.webautomation.pageOpject;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class ProductPage2 extends AbstractComponentWait {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage2(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_description")
    List<WebElement> listProducts;

    By cartLink = By.id("shopping_cart_container");

    public List<WebElement> getProductList() {
        return listProducts;
    }

    public Optional<WebElement> getProductByName(String productName) {
        return getProductList().stream()
                .filter(prod -> prod.findElement(By.className("inventory_item_name")).getText().trim()
                        .equalsIgnoreCase(productName))
                .findFirst();
    }

    public void addToCart(String productName) {
        WebElement product = getProductByName(productName)
                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan: " + productName));

        WebElement addToCartButton = product.findElement(By.cssSelector(".pricebar button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

        WebElement cartButton = driver.findElement(cartLink);
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }
}
