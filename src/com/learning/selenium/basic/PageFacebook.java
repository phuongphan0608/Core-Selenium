package com.learning.selenium.basic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFacebook {


    public PageFacebook(ChromeDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(id = "loginbutton")
    public WebElement login;

    @FindBy(xpath = "//*[@id='password']/div[2]/div[2]")
    public  WebElement warningMessage;

    @FindBy(xpath = "//span[contains(text(), 'Next')]")
    public WebElement next;


}
