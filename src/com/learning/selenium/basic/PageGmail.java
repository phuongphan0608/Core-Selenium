package com.learning.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGmail {


    public PageGmail(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='password']/div[2]/div[2]")
    public  WebElement warningMessage;

    @FindBy(xpath = "//span[contains(text(), 'Next')]")
    public WebElement next;

}
