package com.learning.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {

    @Test
    public void testcase1() {

//        System.setProperty("webdriver.safari.driver", "System/Library/CoreServices/SafariSupport.bundle/Contents/MacOS/safaridriver");
//        WebDriver driver = new SafariDriver();
//
        System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://gmail.com");
        System.out.println("Navigating to gmail");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("phuongphan06081@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();
        //<span class="RveJvd snByac">Next</span>

//        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement element = driver.findElement(By.xpath("//input[@type='password']"));
        CommonMethods.waitForElement(driver,element);

        //element.sendKeys("b5XHxa9EmRmB");
       // wrong pass
        element.sendKeys("worngpass");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();

       // element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']/div[2]/div[2]")));
        //element = driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]"));
        //driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.xpath("//*[@id='password']/div[2]/div[2]")).getAttribute("innerText"));

        // correct pass
       // element.clear();
        //element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        element.sendKeys("b5XHxa9EmRmB");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();





        //element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=':i']/span")));

        System.out.println(element.getTagName());

        System.out.println("You are logged in " + driver.getTitle());
        driver.close();
        driver.quit();
    }


}
