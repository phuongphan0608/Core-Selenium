package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookies {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.get("");
    System.out.println("Navigating to " + driver.getTitle());
    driver.manage().window().maximize();

    // delete cookies
    driver.manage().deleteAllCookies();
    driver.manage().deleteCookieNamed("sessionKey");

    // Click on any link after deleting cookie, Login page returns.
    // verify login URL

    driver.close();
    driver.quit();
  }

}
