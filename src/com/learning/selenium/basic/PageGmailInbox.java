package com.learning.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGmailInbox {


    public PageGmailInbox(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=':7l']/div/div[2]/span/a")
    public WebElement Inbox;

    @FindBy(xpath = "//a[@role='button']/span")
    public WebElement account;

    @FindBy(linkText = "Sign out")
    public WebElement signOut;


}
