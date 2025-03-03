package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        // case dropdown tanpa click pake select
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(staticDropdown);
        System.out.println("All option" + dropdown.getAllSelectedOptions().size());
        System.out.println("First option" + dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println("AED" + dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("USD");

        dropdown.selectByIndex(1);

        driver.quit();
    }
}
