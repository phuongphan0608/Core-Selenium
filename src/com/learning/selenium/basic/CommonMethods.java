package com.learning.selenium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

    WebDriver webDriver;
    WebElement webElement;

    public CommonMethods(WebDriver webDriver, WebElement webElement) {
        this.webDriver = webDriver;
        this.webElement = webElement;
    }

    public static void waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
