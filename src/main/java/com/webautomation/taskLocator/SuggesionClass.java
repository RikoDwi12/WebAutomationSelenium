package com.webautomation.taskLocator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuggesionClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("ocea");

        Thread.sleep(3000);

        List<WebElement> contry = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

        for (WebElement webElement : contry) {
            System.out.println("Ini adalah negara " + webElement.getText());
            if (webElement.getText().equalsIgnoreCase("British Indian Ocean Territory")) {
                webElement.click();
                break;
            }
        }

        driver.quit();

        // MAU TANYA MAS BEDANNYA CODE DARI GPT SAMA YG DIJELASIN APA WKWK ? LEBIH CEPET
        // ATO LEBIH GAMPANG MAINTENANCE NYA KALO CODE YANG DIJELASIN ??

        // WebElement inputBox = driver.findElement(By.id("autocomplete"));

        // inputBox.sendKeys("indi");

        // Thread.sleep(2000);

        // // Ambil semua opsi yang muncul
        // List<WebElement> options =
        // driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

        // for (WebElement option : options) {
        // // menggunakan equalsIgnoreCase mengabaikan huruf besar dan kecil
        // if (option.getText().equalsIgnoreCase("india")) {
        // option.click();
        // break;
        // }
        // }

        // // Verifikasi bahwa input box telah terisi "India"
        // String selectedValue = inputBox.getAttribute("value");
        // if (selectedValue.equals("India")) {
        // System.out.println("Negara berhasil dipilih: " + selectedValue);
        // } else {
        // System.out.println("Negara tidak ditemukan.");
        // }

        // // Tutup browser
        // driver.quit();
    }
}
