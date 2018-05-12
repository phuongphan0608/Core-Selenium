package com.learning.selenium.basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StepLoginGmail {

    public ChromeDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        driver  = new ChromeDriver();
        driver.get("http://gmail.com");
        System.out.println("Navigating to gmail");
    }
    @Test
    public void stepLogin(){
        PageGmail pageSignIn = new PageGmail(driver);
        PageGmailInbox pageGmailInbox = new PageGmailInbox(driver);
        //pageHome.email.sendKeys("phuongphan06081@gmail.com");
        pageSignIn.email.sendKeys(new String[] { "phuongphan06081@gmail.com" });
        pageSignIn.next.click();

        // Type wrong password
        CommonMethods.waitForElement(driver,pageSignIn.password);
        pageSignIn.password.sendKeys(new String[] {"123456654"});
        pageSignIn.next.click();

        CommonMethods.waitForElement(driver,pageSignIn.warningMessage);

        System.out.println(pageSignIn.warningMessage.getAttribute("innerText"));

        CommonMethods.waitForElement(driver,pageSignIn.password);
        pageSignIn.password.sendKeys(new String[] {"b5XHxa9EmRmB"});
        pageSignIn.next.click();


       CommonMethods.waitForElement(driver,pageGmailInbox.Inbox);
        System.out.println(driver.getTitle());

        pageGmailInbox.account.click();
        CommonMethods.waitForElement(driver,pageGmailInbox.signOut);
        pageGmailInbox.signOut.click();


    }

    @AfterTest

    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
