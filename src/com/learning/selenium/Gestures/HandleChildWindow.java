package com.learning.selenium.Gestures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleChildWindow {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://gmail.com");
        System.out.println("Navigating to " + driver.getTitle());

        WebElement help = driver.findElement(By.xpath("//a[text()='Help']"));

        help.click();
        System.out.println("New windows title is " + driver.getTitle());

        Set<String> windowIds =  driver.getWindowHandles();

        Iterator<String> iterator = windowIds.iterator();
        String parentId = iterator.next();
        String childId= iterator.next();

        System.out.println("parentId" + parentId);
        System.out.println("childId" +childId);
        Thread.sleep(3000L);
        System.out.println(driver.getTitle());

        driver.switchTo().window(childId);

        Thread.sleep(3000L);
        System.out.println(driver.getTitle());

        // switch back to original windows before working as normal
        driver.switchTo().window(parentId);

        driver.close();
        driver.quit();

    }
}
