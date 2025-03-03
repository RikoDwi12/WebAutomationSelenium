package com.webautomation.taskLocator;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTab {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\chromedriver-win132/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("opentab")).click();
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Ini adalah windows" + windows);

        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        Thread.sleep(5000);

        driver.switchTo().window(childId);

        Thread.sleep(3000);

        driver.switchTo().window(parentId);

        Thread.sleep(3000);

        driver.switchTo().window(parentId);

        Thread.sleep(3000);

        driver.switchTo().window(parentId);

        Thread.sleep(3000);

        driver.switchTo().window(parentId);

    }
}
