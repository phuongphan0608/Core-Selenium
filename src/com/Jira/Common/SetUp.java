package com.Jira.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SetUp extends Base{

  public static WebDriver driver;
  public final static String baseURI = "http://localhost:9090";
  public final static String username = "phuongphan0608";
  public final static String password = "0iaTW2JY0S0Q";


  public SetUp() {
    this.driver = Base.constructDriver(this.driver);
    navigateTo();
  }

//  public SetUp() {
//    this("http://localhost:9090", "phuongphan0608", "0iaTW2JY0S0Q");
//  }

  private void navigateTo() {
    driver.get(baseURI);

  }

}
