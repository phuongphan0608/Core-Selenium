package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageEchoHTMLRadio {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.echoecho.com/htmlforms10.htm");
        System.out.println("Navigating to " + driver.getTitle());
        List<WebElement> elements =   driver.findElements(By.xpath("//input[@name='group1']"));


        for (int i=0; i<elements.size(); i++)
        {
            System.out.println(elements.get(i).getAttribute("value"));
        }

    }
}
