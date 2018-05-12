package com.learning.selenium.Gestures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://jqueryui.com/droppable/");
        System.out.println("Navigating to " + driver.getTitle());

        int howManyFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println("howManyFrame = "+ howManyFrame);

        System.out.println("You are at " + driver.getTitle());

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);


        WebElement dragItem = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
        WebElement dropItem = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));


        Actions a = new Actions(driver);
        a.moveToElement(dragItem).clickAndHold().moveToElement(dropItem).release().build().perform();

        // Swith back to main window.
        driver.switchTo().defaultContent();

        WebElement dragNavigation = driver.findElement(By.xpath("//a[@href='http://jqueryui.com/draggable/']"));
        dragNavigation.click();

        System.out.println("You are at " + driver.getTitle());

        driver.close();
        driver.quit();



    }
}
