package com.Jira.Common;

import com.Jira.PageObjectsFactory.Index;

public class Login extends SetUp {

  public void Login(){

    //SetUp setUp = new SetUp();
    Index index = new Index( SetUp.driver);
    index.login(SetUp.username, SetUp.password);
  }
}
