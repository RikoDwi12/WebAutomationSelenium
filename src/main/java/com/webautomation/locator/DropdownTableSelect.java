package com.webautomation.locator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownTableSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        /*
         * Scenario select From
         * Delhi =
         * //div[@id="dropdownGroup1"]//child::div[@class="dropdownDiv"]//child::ul[1]//
         * child::li//child::a[@value="DEL"]
         */

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // WebElement countryDelhi =
        // driver.findElement(By.xpath("//div[@id='dropdownGroup1']//child::div[@class='dropdownDiv']//child::ul[1]//child::li//child::a[@value='Bengalure']"));

        List<WebElement> options = driver.findElements(
                By.xpath("//div[@id='dropdownGroup1']//child::div[@class='dropdownDiv']//child::ul[1]//child::li"));
        System.out.println("ini adldaj options" + options);

        for (WebElement element : options) {
            System.out.println("list country" + element.getText());
            if (element.getText().equals("Durgapur (RDP)")) {
                element.click();
                break;
            }
        }

        Thread.sleep(4000);

        driver.quit();
    }
}
