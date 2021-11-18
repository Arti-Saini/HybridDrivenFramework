package com.technocredits.orghrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;
import com.technocredits.orghrm.pages.MenuPage;

public class TestBase {
	
	SoftAssert softAssert = new SoftAssert();
	public MenuPage setUp() {
		System.out.println("Step1- Lauch OrgHrm Application");
		PredefinedActions.start("https://artisaini-trials72.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage();
		System.out.println("Step2- Enter username and password");
		loginPage.enterCredential("Admin", "6XgvE8L@yV");
		System.out.println("Step3- User click on Login button on Login Page");
		return loginPage.clickOnLoginButton();
	}

	
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}


}
