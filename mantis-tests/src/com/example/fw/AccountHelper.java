package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase {

	public AccountHelper(ApplicationManager pMyManager) {
		super(pMyManager);		
	}

	public void signup(User user) throws Exception {
		openUrl("/");

		click(By.linkText("Signup for a new account"));
		//click(By.cssSelector("span.bracket-link"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));
		
		WebElement errorElement = findElement(By.cssSelector("table.width50 tbody tr td p"));
		
		if(errorElement != null) {
			throw new Exception(errorElement.getText());
		}
				
		click(By.linkText("Proceed"));
		
		pauseHelper(30000);
		
		Msg msg = myManager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationMailLink = msg.getConfirmationLinkFromMail();
		
		openAbsoluteUrl(confirmationMailLink);
		
		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		
		click(By.cssSelector("input.button"));
		
	}

	public String getLoggedUser() {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		if(element != null) {
			return element.getText();
		}
		return null;
	}

	public void login(User user) {
		openUrl("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		
		click(By.cssSelector("input.button"));
	}
	
	public void deleteUser(User user) {
		openUrl("/login_page.php");		
		type(By.name("username"), "administrator");
		type(By.name("password"), "root");
		click(By.cssSelector("input.button"));
		click(By.linkText("Manage Users"));
		click(By.linkText(user.login));
		click(By.xpath("//input[@value='Delete User']"));
		click(By.cssSelector("input.button"));
		click(By.linkText("Proceed"));		
	}

}
