package com.learning.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverBasicMethods {

    @BeforeTest

    public void setUp() {
        System.out.println("This is setup section");
    }

    @Test
    public void TestCase() {
        System.out.println("This is the first test case");
        // Create a web driver
//        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
//        WebDriver webDriver = new ChromeDriver();


//        System.setProperty("webdriver.gecko.driver", "/Users/phuongphan/Documents/Software/Selenium/geckodriver");
//        WebDriver webDriver = new FirefoxDriver();
//        webDriver.get("http://gmail.com");

        System.setProperty("webdriver.safari.driver", "System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver");
        WebDriver webDriver = new SafariDriver();
        webDriver.get("http://gmail.com");

        // Validate if users are landed on the correct URL
        System.out.println("Current URL is " + webDriver.getCurrentUrl());
        System.out.println("Current page is " + webDriver.getPageSource());
        webDriver.get("http://yahoo.com");
        webDriver.navigate().back();
        webDriver.close();
        // close all browsers/
        webDriver.quit();
    }



}
