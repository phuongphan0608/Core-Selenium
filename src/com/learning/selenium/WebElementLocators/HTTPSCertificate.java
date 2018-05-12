package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPSCertificate {

  public static void main(String[] args) {

    // Create Profile for Chrome Driver

    // Desired Capapilities accept SSL
    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
    //desiredCapabilities.acceptInsecureCerts();
    desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

    // Set Chrome Option of local Chrome Browser
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.merge(desiredCapabilities);
;
    System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
    WebDriver driver = new ChromeDriver(chromeOptions);

    driver.get("");
    System.out.println("Navigating to " + driver.getTitle());
    driver.close();
    driver.quit();
  }
}
