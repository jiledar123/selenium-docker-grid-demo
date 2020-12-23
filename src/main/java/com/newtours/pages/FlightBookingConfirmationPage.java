package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightBookingConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement confirmationText;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> priceList;


    public  FlightBookingConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(confirmationText));
        System.out.println(this.confirmationText.getText());
        String price = this.priceList.get(1).getText();
        return price;

    }
}
