package com.webautomation.taskLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Buka URL target
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Tunggu agar halaman termuat dengan baik
        Thread.sleep(2000);

        // Temukan dropdown berdasarkan ID
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));

        Select dropdown = new Select(staticDropdown);

        dropdown.selectByVisibleText("Option2");
        System.out.println("ini return value nya" + dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("option2");
        dropdown.selectByIndex(2);

        driver.quit();

        // // Tambahkan jeda sebelum mengklik dropdown
        // Thread.sleep(1000);
        // dropdown.click(); // Klik dropdown untuk membuka pilihan

        // // Gunakan Select class untuk mengelola dropdown
        // Select select = new Select(dropdown);

        // // Tambahkan jeda sebelum memilih opsi
        // Thread.sleep(1000);
        // select.selectByVisibleText("Option1"); // Pilih "Option1"

        // // Tambahkan jeda setelah memilih
        // Thread.sleep(2000);

        // // Cetak opsi yang dipilih untuk verifikasi
        // WebElement selectedOption = select.getFirstSelectedOption();
        // System.out.println("Opsi yang dipilih: " + selectedOption.getText());

        // // Tambahkan jeda sebelum menutup browser agar hasil terlihat
        // Thread.sleep(3000);

        // Tutup browser
        driver.quit();
    }
}
