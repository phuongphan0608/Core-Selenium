package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeDriver {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");
        System.out.println("Navigating to " + driver.getTitle());

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int noOfLink = footerDriver.findElements(By.tagName("a")).size();

        System.out.println("noOfLink = " + noOfLink);

        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]"));
        int noOfLinkInColumn = columnDriver.findElements(By.tagName("a")).size();
        System.out.println("noOfLinkInColumn = " + noOfLinkInColumn);


    }
}
