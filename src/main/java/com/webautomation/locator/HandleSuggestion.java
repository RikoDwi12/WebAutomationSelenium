package com.webautomation.locator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSuggestion {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(4000);

        driver.findElement(By.xpath("(//*[@id='autosuggest'])[1]")).sendKeys("ind");

        Thread.sleep(3000);

        List<WebElement> country = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement webElement : country) {
            System.out.println("Ini adalah negara " + webElement.getText());
            if (webElement.getText().equals("Indonesia")) {
                webElement.click();
                break;
            }
        }

        driver.quit();
    }
}
