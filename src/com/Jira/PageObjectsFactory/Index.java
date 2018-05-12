package com.Jira.PageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Index {

    public Index(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[text()='Log In']")
    WebElement logIn;

    @FindBy (css = "#login-form-username")
    WebElement userName;

    @FindBy (css = "#login-form-password")
    WebElement password;

    @FindBy (xpath = "//input[@name='login']")
    WebElement submit;

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();
    }


}


