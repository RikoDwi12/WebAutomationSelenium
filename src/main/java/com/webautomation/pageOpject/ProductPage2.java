package com.webautomation.pageOpject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class ProductPage2 extends AbstractComponentWait {
    WebDriver driver;
    WebElement product;

    public ProductPage2(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_description")
    List<WebElement> listProducts;

    By titleProduct = By.xpath("//div[normalize-space()=\"Sauce Labs Backpack\"]");

    By buttonKeranjang = By.xpath("//div[@class='inventory_item_description']//div[@class='pricebar']//button");
    By cartLink = By.id("shopping_cart_container");

    public List<WebElement> getProductList() {
        return listProducts;
    }

    public WebElement getProductByName(String productName) {
        WebElement product = getProductList().stream()
                .filter(prod -> prod.findElement(titleProduct).getText().trim().equals(productName)).findFirst()
                .orElse(null);
        return product;
    }

    public void addToCart(String productName) throws InterruptedException {
        product = getProductByName(productName);
        product.findElement(buttonKeranjang).click();
        Thread.sleep(1000);
        driver.findElement(cartLink).click();

    }

}
