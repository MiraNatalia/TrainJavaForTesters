package com.example.tests;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.navigationHelper.openMainPage();
    app.navigationHelper.openGroupsPage();
    app.groupHelper.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "Group 1";
    group.header = "Header 1";
    group.footer = "Footer 1";
    app.groupHelper.fillGroupForm(app, this, group);
    app.groupHelper.submitGroupCreation();
    app.groupHelper.returnToGoupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.navigationHelper.openMainPage();
    app.navigationHelper.openGroupsPage();
    app.groupHelper.initGroupCreation();
    app.groupHelper.fillGroupForm(app, this, new GroupData("", "", ""));
    app.groupHelper.submitGroupCreation();
    app.groupHelper.returnToGoupsPage();
  }
}
