package com.searchmodule.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchTxt;
    @FindBy(name = "btnK")
    private WebElement searchBtn;
    @FindBy(id = "result-stats")
    private WebElement resultStats;
    @FindBy(className = "rc")
    private List<WebElement> results;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://google.com/");
    }

    public void doSearch(String searchKey) {
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        this.searchTxt.sendKeys(searchKey);
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        this.searchBtn.click();
    }

    public int getResult() {
        wait.until(ExpectedConditions.visibilityOf(resultStats));
        System.out.println(this.results.size());
        int resultCount = this.results.size();
        return resultCount;
    }

}
