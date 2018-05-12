package com.Jira.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

  public static WebDriver constructDriver (WebDriver driver){
    System.setProperty("webdriver.chrome.driver",
                       "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
    driver= new ChromeDriver();
    return driver;
  }
}
