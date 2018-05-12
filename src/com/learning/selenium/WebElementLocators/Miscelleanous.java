package com.learning.selenium.WebElementLocators;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

import java.io.File;
import java.io.IOException;

public class Miscelleanous  {

  public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.get("http://google.com");

    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String location = System.getProperty("user.dir");
    FileUtils.copyFileToDirectory(src, new File(location + "/Screenshots/screenshot.png"));
    System.out.println("Navigating to " + driver.getTitle());

    //WindowsUtils.killByName("Microsoft Excel");
   // WindowsUtils.killPID("3615");

    driver.close();
    driver.quit();
  }
}
