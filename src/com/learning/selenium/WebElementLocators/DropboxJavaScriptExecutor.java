package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropboxJavaScriptExecutor {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver",
                       "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.get("http://ksrtc.in/oprs-web/");
    System.out.println("Navigating to " + driver.getTitle());

    //Scenario: Enter BENG, select BENGALURU INTERNATION AIPORT
    WebElement from = driver.findElement(By.cssSelector("input#fromPlaceName"));
    from.sendKeys("BENG");
    from.sendKeys(Keys.DOWN);

    String expectedFrom = "BENGALURU INTERNATION AIPORT";

    JavascriptExecutor js = (JavascriptExecutor) driver;
    String script = "return document.getElementById('fromPlaceName').value;";
    String text = (String) js.executeScript(script);
    System.out.println("Before searching " + text);

    int i = 0;

    while (!text.equalsIgnoreCase(expectedFrom) && (i<10)) {
      from.sendKeys(Keys.DOWN);
      text = (String) js.executeScript(script);
      i++;
    }

    if (i>=10){
      System.out.println("Element not found");
    }
    System.out.println("After searching " + text);
    driver.close();
    driver.quit();
  }


}
