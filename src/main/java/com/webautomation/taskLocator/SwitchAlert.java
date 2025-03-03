package com.webautomation.taskLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchAlert {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132\\chromedriver.exe");

        // Inisialisasi WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Memaksimalkan jendela browser

        // Buka halaman
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Masukkan teks ke dalam input field
        driver.findElement(By.id("name")).sendKeys("CekAlret");

        // Klik tombol Alert
        driver.findElement(By.id("alertbtn")).click();

        // Ambil teks dari alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Teks dari alert: " + alertText);

        // Tunggu 2 detik agar alert terlihat sebelum ditutup
        Thread.sleep(2000);

        // Klik OK pada alert
        driver.switchTo().alert().accept();

        // Tutup browser
        driver.quit();
    }
}
