package com.Jira.PageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIssueDialog {

  public CreateIssueDialog(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "#create_link")
  WebElement createIssue;

  @FindBy(css = "#summary")
  WebElement summary;

  @FindBy(css = "#tinymce")
  WebElement description;

  @FindBy(css = "#create-issue-submit")
  WebElement submitIssue;

  @FindBy(xpath = "//a[@class='issue-created-key issue-link']")
  WebElement createdIssueId;

  @FindBy (xpath = "//h1[text()='System Dashboard']")
  WebElement dashboardTitle;

  private int findFrameIdOfElement(WebDriver driver, By by) {

    int countFrame = driver.findElements(By.tagName("iframe")).size();

    int frameId;
    for (frameId = 0; frameId < countFrame; frameId++) {
      driver.switchTo().frame(frameId);
      int countElement = driver.findElements(by).size();
      if (countElement == 1) {
        driver.switchTo().defaultContent();
        return frameId;
      }
      driver.switchTo().defaultContent();
    }

    return -1;
  }

  public void createIssue(WebDriver driver, String summary, String description) {
    if(  waitForElement(driver,"#create_link")) {
      createIssue.click();
    }
    if (waitForElement(driver, "#summary")) {
      this.summary.sendKeys(summary);
    }
    int frameIdContainDescription = findFrameIdOfElement(driver, By.cssSelector("#tinymce"));
    if (frameIdContainDescription != -1) {
      driver.switchTo().frame(frameIdContainDescription);
      this.description.sendKeys(description);
      driver.switchTo().defaultContent();
    }
    driver.switchTo().defaultContent();
    this.submitIssue.click();
    System.out.println("You are at " + driver.getTitle());
    System.out.println("An issue is created successfully");


  }

  private boolean waitForElement(WebDriver driver, String css) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    String
        foundElement =
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css))).getTagName();
    if (!foundElement.equals(null)) {
      return true;
    } else {
      return false;
    }
  }
}


