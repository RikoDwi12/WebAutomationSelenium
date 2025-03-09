package com.webautomation.pageOpject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponentWait;

public class CheckoutReview extends AbstractComponentWait {
    WebDriver driver;

    public CheckoutReview(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    WebElement finishBtn;

    public void Review() {
        finishBtn.click();
    }
}
