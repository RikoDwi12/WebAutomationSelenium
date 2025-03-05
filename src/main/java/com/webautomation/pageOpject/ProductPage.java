package com.webautomation.pageOpject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;

    // Menggunakan className yang benar
    private By productList = By.className("inventory_item");
    private By cartLink = By.id("shopping_cart_container");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        List<WebElement> products = driver.findElements(productList);
        for (WebElement product : products) {
            try {
                // Ambil nama produk dari dalam elemen yang sesuai
                WebElement nameElement = product.findElement(By.className("inventory_item_name"));
                String name = nameElement.getText().trim();

                if (name.equalsIgnoreCase(productName)) {
                    // Cari tombol "Add to Cart" di dalam produk yang sama
                    WebElement addToCartBtn = product.findElement(By.cssSelector("button.btn_inventory"));
                    addToCartBtn.click();
                    System.out.println("Produk '" + productName + "' berhasil ditambahkan ke keranjang.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Gagal menambahkan produk: " + e.getMessage());
            }
        }
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
