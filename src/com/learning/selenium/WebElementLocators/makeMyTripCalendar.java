package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class makeMyTripCalendar {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");
        System.out.println("Navigating to " + driver.getTitle());

        // Handle calendar
        // Input = Month, day
        // Select a date
        WebElement calendar = driver.findElement(By.cssSelector("[mt-id ='departDate']"));

        // Select Month = April
        calendar.click();

        // Scope driver : work on left calendar only

        WebElement leftCalendar = driver.findElement(By.xpath("//div[contains(@class,'corner-left')]"));
        WebElement currentDate = leftCalendar.findElement(By.xpath("//div[@class='ui-datepicker-title']"));

//        WebElement currentDate = driver.findElement(By.xpath("//div[contains(@class,'corner-left')]/div[@class='ui-datepicker-title']"));
        WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
        String text = currentDate.getText();
        while (!currentDate.getText().contains("MARCH"))
        {
            next.click();
            next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
            currentDate = driver.findElement(By.xpath("//div[contains(@class,'corner-left')]/div[@class='ui-datepicker-title']"));
//            text = currentDate.getText();
        }

        // Select Day = 23


        List<WebElement> days = leftCalendar.findElements(By.cssSelector("[data-handler='selectDay']"));
        Iterator<WebElement> iterator = days.iterator();

        String strDay;
        WebElement day;
        while (iterator.hasNext()){
            day = iterator.next();
            strDay = day.getText();
            if (strDay.equalsIgnoreCase("23"))
            {
                day.click();
                break;
            }

        }

        System.out.println("currentDate" +currentDate.getText());



        driver.close();
        driver.quit();
    }
}
