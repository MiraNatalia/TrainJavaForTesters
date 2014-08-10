package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager pMyManager) {
		super(pMyManager);
		// TODO Auto-generated constructor stub
	}

	public void submitContactForm() {
		driver.findElement(By.name("submit")).click();
	}

	public void openAddNewContactPage() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ContactData contactData) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname"))
				.sendKeys(contactData.firstName);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contactData.lastName);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contactData.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contactData.homePhone);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contactData.mobilePhone);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contactData.workPhone);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contactData.email1);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contactData.email2);
		new Select(driver.findElement(By.name("bday")))
				.selectByVisibleText(contactData.birthDD);
		new Select(driver.findElement(By.name("bmonth")))
				.selectByVisibleText(contactData.birthMM);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contactData.birthYYYY);
		new Select(driver.findElement(By.name("new_group")))
				.selectByVisibleText(contactData.contactGroup);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contactData.address2);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2"))
				.sendKeys(contactData.mobilePhone2);
	}

}
