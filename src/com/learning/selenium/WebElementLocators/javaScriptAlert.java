package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptAlert {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
        System.out.println("Navigating to " + driver.getTitle());

        WebElement element = driver.findElement(By.cssSelector("input[value='Confirmation Alert']"));
        element.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();


        driver.quit();
    }
}
