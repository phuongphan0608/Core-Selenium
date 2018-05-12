package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ValidateElement {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com");
        System.out.println("Navigating to " + driver.getTitle());

        WebElement elementMultiCity = driver.findElement(By.xpath("//label[@for='switch__input_3']"));
        elementMultiCity.click();

        WebElement elementFrom = driver.findElement(By.id("//input[@id='js-multiCitySearchFrom_1']"));
        if(elementFrom.isDisplayed()){
            elementFrom.click();
        }


        List<WebElement> elementList= driver.findElements(By.xpath(" //li[@class='ui-menu-item']"));
        for (int i=0; i<elementList.size(); i++)
        {
            String citi = elementList.get(i).getAttribute("aria-label");
        }


    }
}
