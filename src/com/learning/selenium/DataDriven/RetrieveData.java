package com.learning.selenium.DataDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RetrieveData {
  public WebDriver driver;
  public Properties properties;
  @BeforeTest
  public void Login() throws IOException {
     properties = new Properties( );
    String location = System.getProperty("user.dir");
    FileInputStream fileInputStream = new FileInputStream(location + "/src/DataDriven/datadriven.properties");
    properties.load(fileInputStream);

    System.out.println(properties.getProperty("username"));

    String browser = properties.getProperty("browser");
    if(browser.equalsIgnoreCase("chrome")){
      System.setProperty(properties.getProperty("chromeKey"), properties.getProperty("chromeLocation"));

      driver = new ChromeDriver();
    }
    else if (browser.equalsIgnoreCase("firefox")){
     // System.setProperty("webdriver.gecko.driver", "/Users/phuongphan/Documents/Software/Selenium/geckodriver");
      System.setProperty(properties.getProperty("firefoxKey"), properties.getProperty("firefoxLocation"));
      driver = new FirefoxDriver();
    }
    else if (browser.equalsIgnoreCase("safari")){
//      System.setProperty("webdriver.safari.driver", "System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver");
      System.setProperty(properties.getProperty("safariKey"), properties.getProperty("safariLocation"));
      driver = new SafariDriver();
    }

    String baseURI = properties.getProperty("url");
    driver.get(baseURI);
  }

  @Test
  public void DashBoard(){
    System.out.println("I am at DashBoard");
  }
}
