package com.webautomation.scenarioTask;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutProduct {
        public static void main(String[] args) throws InterruptedException {
                // Setup Driver
                System.setProperty("webdriver.chrome.driver",
                                "C:\\chromedriver-win132/chromedriver.exe");

                WebDriver driver = new ChromeDriver();
                driver.get("https://www.saucedemo.com/");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

                // wait gantinnya thread
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

                // scenario login
                driver.findElement(By.id("user-name")).sendKeys("standard_user");
                driver.findElement(By.id("password")).sendKeys("secret_sauce");

                driver.findElement(By.id("login-button")).click();

                // List Product
                List<WebElement> listProduct = driver.findElements(By.cssSelector(".inventory_item"));

                String productName = "Sauce Labs Backpack";

                WebElement product = listProduct.stream()
                                .filter(prod -> prod.findElement(By.className("inventory_item_name")).getText()
                                                .equals(productName))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan: " + productName));

                // mendapatakan looping web element dari product
                // div[@class='inventory_item_description']//child::div//child::button[@class='btn
                // btn_primary btn_small btn_inventory ']

                // button add to cart
                product.findElement(By.xpath(
                                "//div[@class='inventory_item_description']//child::div//child::button[@class='btn btn_primary btn_small btn_inventory ']"))
                                .click();

                // product.findElement(By.xpath(".//button[contains(@class,
                // 'btn_inventory')]")).click();

                System.out.println("list product" + product);
                Thread.sleep(2000);

                // wait
                WebElement cartButton = wait
                                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart_link")));
                cartButton.click();

                driver.findElement(By.cssSelector(".shopping_cart_link")).click();
                Thread.sleep(2000);
                // wait
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
                driver.findElement(By.id("checkout")).click();

                // mengisi form
                Actions action = new Actions(driver);
                action.sendKeys(driver.findElement(By.id("first-name")), "CekCekCek").build().perform();
                action.sendKeys(driver.findElement(By.id("last-name")), "CekLastName").build().perform();
                action.sendKeys(driver.findElement(By.id("postal-code")), "CekLastName").build().perform();

                // klik button submit
                driver.findElement(By.id("continue")).click();
                Thread.sleep(2000);

                // wait
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='finish']")));
                // klik button finish
                driver.findElement(By.xpath("//button[@id='finish']")).click();
        }
}
