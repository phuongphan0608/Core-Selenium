package com.Jira.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnIssueNormal {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:9090/");
        System.out.println("Navigating to " + driver.getTitle());

        WebElement logIn = driver.findElement(By.xpath("//a[text()='Log In']"));

        //logIn.click();

        WebElement userName = driver.findElement(By.cssSelector("#login-form-username"));
        WebElement password = driver.findElement(By.cssSelector("#login-form-password"));
        WebElement submit = driver.findElement(By.xpath("//input[@name='login']"));

        userName.sendKeys("phuongphan0608");
        password.sendKeys("0iaTW2JY0S0Q");
        submit.click();

        // create an Issue

        WebElement createIssue = waitForElementCss(driver,"#create_link");
        createIssue.click();

        WebElement summary = waitForElementCss(driver,"#summary");
        summary.sendKeys("this is a summary");
        // description field is in the iFrame
        driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));
        int count = driver.findElements(By.cssSelector("#tinymce")).size();
        WebElement description = driver.findElement(By.cssSelector("#tinymce"));

        if (count == 1) {

           description.sendKeys("this is the description ");
       }
       driver.switchTo().defaultContent();
       WebElement create = driver.findElement(By.cssSelector("#create-issue-submit"));
        create.click();

        driver.close();
        driver.quit();
    }

    public static WebElement waitForElementCss(WebDriver driver, String  locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
        return element;
    }

    public static WebElement waitForElementXPath(WebDriver driver, String  locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return element;
    }
}


