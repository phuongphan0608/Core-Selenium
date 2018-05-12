package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownFlightBooking {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://spicejet.com");
        System.out.println("Navigating to " + driver.getTitle());

        PageSpiceJet pageSpiceJet = new PageSpiceJet(driver);
        Select s = new Select(pageSpiceJet.sex);
        s.selectByValue("2");


        //Dynamic dropdownList list out DropdownlistGroup ==> to identify the second items of the DropDownListGroup =>
        // Use XPath with syntax: (//xpathDefinition)[index] ; index is the position of the element
        // This solution is to deal with 2 same elements on the same page as well.

        driver.close();
        driver.quit();

    }
}
