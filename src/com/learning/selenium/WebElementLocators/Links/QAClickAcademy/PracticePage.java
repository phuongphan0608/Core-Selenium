package com.learning.selenium.WebElementLocators.Links.QAClickAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticePage {

    public PracticePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    @FindBy(xpath = "//li[@class='gf-li']")
    List<WebElement> footerLinks;
}
