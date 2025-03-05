package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SuggestionPage {
    WebDriver driver;
    Actions action;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public SuggestionPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    // public void fillCheckoutDetails(String firstName, String lastName, String
    // postalCode) {
    // driver.findElement(firstNameField).sendKeys(firstName);
    // driver.findElement(lastNameField).sendKeys(lastName);
    // driver.findElement(postalCodeField).sendKeys(postalCode);
    // driver.findElement(continueButton).click();
    // }

    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        action.sendKeys(driver.findElement(firstNameField), firstName).build().perform();
        action.sendKeys(driver.findElement(lastNameField), lastName).build().perform();
        action.sendKeys(driver.findElement(postalCodeField), postalCode).build().perform();
        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }
}
