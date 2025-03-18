package com.webautomation.taskLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption1")).click();
        driver.findElement(By.id("checkBoxOption2")).click();
        driver.findElement(By.id("checkBoxOption3")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
