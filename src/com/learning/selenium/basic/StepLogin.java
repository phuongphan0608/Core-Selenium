package com.learning.selenium.basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StepLogin {

    public ChromeDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        driver  = new ChromeDriver();
        driver.get("http://facebook.com");
        System.out.println("Navigating to facebook");
    }
    @Test
    public void stepLogin(){
        PageFacebook pageHome = new PageFacebook(driver);
        pageHome.email.sendKeys("phuongphan06081@gmail.com");
        pageHome.password.sendKeys("123456654");
        pageHome.next.click();

        System.out.println(pageHome.warningMessage);

        CommonMethods.waitForElement(driver,pageHome.password);
        pageHome.password.sendKeys("b5XHxa9EmRmB");
        pageHome.next.click();

        pageHome.login.click();
        System.out.println(driver.getTitle());

    }

    @AfterTest

    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
