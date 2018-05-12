package com.learning.selenium.WebElementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class Table {

  @Test
  public void Test(){
    System.setProperty("webdriver.chrome.driver", "/Users/phuongphan/Documents/Software/Selenium/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.get("http://www.cricbuzz.com/live-cricket-scorecard/20102/dd-vs-srh-42nd-match-indian-premier-league-2018");
    System.out.println("Navigating to " + driver.getTitle());

    WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr'"));

    List<WebElement> rows = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
    int countRow = rows.size();
    System.out.println("countRow" + countRow);
    Iterator<WebElement> iterator = rows.iterator();
    WebElement row;// = iterator.next();
    WebElement cellR, cellExtra;// = row.findElement(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));
    int sum = 0;
    int countScore, countExtra;
    while (iterator.hasNext()){
      row = iterator.next();

//      cellR = row.findElement(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));

      countScore = row.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']")).size();
      countExtra = row.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-bold cb-text-black text-right']")).size();
      if (countScore ==1){
              cellR = row.findElement(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));
        System.out.println("score = " + cellR.getText());
        sum += Integer.parseInt(cellR.getText());
      }else if (countExtra ==1){
        cellExtra = row.findElement(By.cssSelector("div[class='cb-col cb-col-8 text-bold cb-text-black text-right']"));
        sum += Integer.parseInt(cellExtra.getText());
      }else {
        break;
      }
    }
    System.out.println("Total score = " + sum);

    WebElement total = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div"));
    int totalScore = Integer.parseInt(total.getText());
    System.out.println("Expected score = " +totalScore);
    Assert.assertEquals(totalScore,sum);
    driver.close();
    driver.quit();
  }
}
