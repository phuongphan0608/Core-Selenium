package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions/");
        System.out.println("Navigating to " + driver.getTitle());

        // Handle calendar
        // Input = Month, day
        // Select a date
        WebElement calendar = driver.findElement(By.xpath("//input[@id='travel_date']"));



        // Select Month = April
        calendar.click();
        WebElement current = driver.findElement(By.cssSelector("[class ='datepicker-days'] [class = 'datepicker-switch']"));

        // Select Year 2018



        WebElement next = driver.findElement(By.cssSelector("[class ='datepicker-days'] [class = 'next']"));

        while (!current.getText().contains("April")) {
            next.click();
        }

        // Select December 23
        List<WebElement> days = driver.findElements(By.cssSelector(".day"));
        String day;
        for (int i = 0; i < days.size(); i++) {
            day = days.get(i).getText();
            if (day.equals("23")) {
                days.get(i).click();
                break;
            }
        }

        System.out.println("Travel date = " + calendar.getAttribute("value"));
        Thread.sleep(5000L);
        driver.close();
        driver.quit();
    }

}
