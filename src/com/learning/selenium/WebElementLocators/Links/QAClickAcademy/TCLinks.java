package com.learning.selenium.WebElementLocators.Links.QAClickAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class TCLinks {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");
        System.out.println("Navigating to " + driver.getTitle());

        PracticePage pratisePage = new PracticePage(driver);
        int noOfLink = pratisePage.links.size();
        System.out.println("noOfLink = " + noOfLink);

        int noOfFooterLink = pratisePage.footerLinks.size();
        System.out.println("noOfFooterLink = "+ noOfFooterLink);

        // click all links in the footer section
        Iterator<WebElement> iterator = pratisePage.footerLinks.iterator();
        iterator.next();
        WebElement link;

        for (int i=0; i<noOfFooterLink; i++)
        {
           if (iterator.hasNext()){
            String clickOnLinkTab = Keys.chord(Keys.SHIFT,Keys.COMMAND,Keys.ENTER);
            link = iterator.next().findElement(By.tagName("a"));

            System.out.println("Link is " + link.getText());
            link.sendKeys(clickOnLinkTab);
            }

        }

        // MOve to each windows and print window titles

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator1 = windows.iterator();
        String id;
        for(int i=0; i<windows.size(); i++){
            if(iterator1.hasNext()) {
                id = iterator1.next();
                driver.switchTo().window(id);
                System.out.println("Title is "+ driver.getTitle() + "\n");
            }
        }

        driver.close();
        driver.quit();

    }
}
