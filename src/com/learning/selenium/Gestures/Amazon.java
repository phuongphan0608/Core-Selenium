package com.learning.selenium.Gestures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Amazon {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        System.out.println("Navigating to " + driver.getTitle());


        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[text()='Hello. Sign in']"))).build().perform();

        action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();

        WebElement searchTextbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        action.moveToElement(searchTextbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        action.moveToElement(searchTextbox).contextClick().build().perform();

//        https://www.amazon.com/gp/site-directory/ref=nav_shopall_btn/131-0568868-4203421
        //action.perform();


        driver.close();
        driver.quit();
    }

}
