package com.webautomation.pageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class ConfirmationPage extends AbstractComponentWait {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".complete-header")
    WebElement finishBtn;

    By elementText = By.cssSelector(".complete-header");

    public String getConfirmationMessage() {
        visibilityOfElementLocated(elementText);
        return finishBtn.getText();
    }
}
