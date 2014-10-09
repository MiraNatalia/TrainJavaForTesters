package com.example.tests;

import org.hamcrest.*;

import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignupTest extends TestBase {

	private static final String USERNAME_IS_ALREADY_BEING_USED = "That username is already being used.";
	public User user = new User().setLogin("testuser1")
			.setEmail("testuser1@localhost.localdomain")
			.setPassword("123456");
	private JamesHelper jamesHelper;
	private AccountHelper accountHelper;
	
	
	@BeforeClass
	public void createUser() {
		jamesHelper = app.getJamesManager();
		accountHelper = app.getAccountHelper();
		
		if(!jamesHelper.doesUserExist(user.login)) {
			jamesHelper.createUser(user.login, user.password);
		}
	}
	
	@AfterClass
	public void deleteUser() {
		if(jamesHelper.doesUserExist(user.login)) {
			jamesHelper.deleteUser(user.login);
		}
		
		accountHelper.deleteUser(user);
	}
	
	@Test
	public void newUserShouldSignup() {
		try {
			accountHelper.signup(user);
		} catch (Exception e) {
			org.testng.Assert.fail("Exception not expected");
		}
		accountHelper.login(user);
		MatcherAssert.assertThat(accountHelper.getLoggedUser(), Matchers.equalTo(user.login));
	}
	
//	@Test
//	public void existingUserShouldNotSignup() {
//		try {
//			accountHelper.signup(user);
//		} catch (Exception e) {
//			MatcherAssert.assertThat(e.getMessage(), Matchers.containsString(USERNAME_IS_ALREADY_BEING_USED));
//			return;
//		}
//		org.testng.Assert.fail("Exception expected");
//	}
}
