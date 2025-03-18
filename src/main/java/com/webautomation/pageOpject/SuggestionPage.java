package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class SuggestionPage extends AbstractComponentWait {
    WebDriver driver;
    Actions action;

    public SuggestionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "finish")
    WebElement finishBtn;

    public void fillCheckoutDetails(String fName, String lName, String pCode) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postalCode.sendKeys(pCode);
        continueBtn.click();
    }

    // private By firstNameField = By.id("first-name");
    // private By lastNameField = By.id("last-name");
    // private By postalCodeField = By.id("postal-code");
    // private By continueButton = By.id("continue");
    // private By finishButton = By.id("finish");

    // public void fillCheckoutDetails(String firstName, String lastName, String
    // postalCode) {
    // action.sendKeys(driver.findElement(firstNameField),
    // firstName).build().perform();
    // action.sendKeys(driver.findElement(lastNameField),
    // lastName).build().perform();
    // action.sendKeys(driver.findElement(postalCodeField),
    // postalCode).build().perform();
    // driver.findElement(continueButton).click();
    // }

    // public void finishCheckout() {
    // driver.findElement(finishButton).click();
    // }
}
