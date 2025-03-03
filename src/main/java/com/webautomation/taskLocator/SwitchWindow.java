package com.webautomation.taskLocator;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Buka halaman utama
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Simpan window utama
        String mainWindowHandle = driver.getWindowHandle();

        // Klik tombol untuk membuka window baru
        driver.findElement(By.id("openwindow")).click();

        // Jeda 3 detik agar window baru terbuka sepenuhnya
        Thread.sleep(3000);

        // Ambil semua window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Loop untuk berpindah ke window baru
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Berpindah ke window baru: " + driver.getTitle());

                // Jeda 5 detik agar window baru terlihat
                Thread.sleep(5000);
                break;
            }
        }

        // Kembali ke window utama
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Kembali ke window utama: " + driver.getTitle());

        // Jeda sebelum menutup browser
        Thread.sleep(3000);

        // Tutup browser
        driver.quit();
    }
}
