package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownLoopingButton {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(4000);

        /*
         * Menambahkan passenger
         */
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Child
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncChd")).click();
        }

        Thread.sleep(4000);

        // Decrease adult
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefDecAdt")).click();
        }

        Thread.sleep(4000);

        driver.findElement(By.id("btnclosepaxoption")).click();

        Thread.sleep(4000);

        driver.quit();
    }
}
