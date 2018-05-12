package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSpiceJet {

    public PageSpiceJet(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "ctl00_mainContent_ddl_Adult")
    WebElement sex;
}
