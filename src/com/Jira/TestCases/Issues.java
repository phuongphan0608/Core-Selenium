package com.Jira.TestCases;

import com.Jira.Common.Login;
import com.Jira.Common.SetUp;
import com.Jira.PageObjectsFactory.CreateIssueDialog;
import com.Jira.PageObjectsFactory.Index;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Issues extends Login {



  @Test
  public void CreateAnIssue(){

    Login();

    CreateIssueDialog createIssueDialog = new CreateIssueDialog(SetUp.driver);
    createIssueDialog.createIssue(SetUp.driver, "This is a summary", "This is a description");
    System.out.println("oh yeah");
  }

}
