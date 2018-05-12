package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Template {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("");
        System.out.println("Navigating to " + driver.getTitle());
        driver.close();
        driver.quit();
    }
}
