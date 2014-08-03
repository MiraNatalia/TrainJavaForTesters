package com.example.tests;
import org.testng.annotations.Test;

public class DublicateOfGroupCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "Group 2";
    group.header = "Header 2";
    group.footer = "Footer 2";
    fillGroupForm(group);
    submitGroupCreation();
    returnToGoupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGoupsPage();
  }
}
