package com.technocredits.orghrm.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

/*1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Login using valid credentials
3. Verify User profile is displayed
4. Click on Arrow icon on profile
5. Verify user menu total 3 options are displayed (About, Change Password & Logout) on after click on Arrow.
6. Click on About
7. Verify Employee is more than 0
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.*/
public class UserProfilePage extends PredefinedActions {

	public boolean isProfileDisplayed() {
		return driver.findElement(By.xpath("//img[@class='circle account-photo']")).isDisplayed();
	}

	public void clickOnDropDown() {
		driver.findElement(By.xpath("//a[@id='user-dropdown']")).click();
	}

	public List<String> getListOfUserDropDown() {
		return getTextOfAllElements("//ul[@id='user_menu']/li/a");
	}

	public int getTotalAvailableOptions() {
		return getListOfUserDropDown().size();
	}

	public void clickOnAbout() {
		driver.findElement(By.xpath("//a[text()='About']")).click();
	}

	public void verifyEmployeesMoreThanZero() {
		System.out.println("Step7- Verify employees more than 0");
	}

	public List<String> listOfAboutOptions() {
		return getTextOfAllElements("//div[@id='companyInfo']//p");
	}

	public void clickOnOk() {
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
	}

}
