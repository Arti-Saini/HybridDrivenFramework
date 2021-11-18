package com.technocredits.orghrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;
import com.technocredits.orghrm.pages.UserProfilePage;

/*1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Login using valid credentials
3. Verify User profile is displayed
4. Click on Arrow icon on profile
5. Verify user menu total 3 options are displayed (About, Change Password & Logout) on after click on Arrow.
6. Click on About
7. 
8. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
9. Click on OK button on popup.*/
public class UserProfileTest {

	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		System.out.println("Step1- Lauch OrgHrm Application");
		PredefinedActions.start("https://artisaini-trials72.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage();
		System.out.println("Step2- Enter username and password");
		loginPage.enterCredential("Admin", "6XgvE8L@yV");
		System.out.println("Step3- User click on Login button on Login Page");
		loginPage.clickOnLoginButton();
	}

	@Test
	public void verifyUserProfileDropDown() {
		System.out.println("Step4- Verify User profile is displayed");
		UserProfilePage userProfilePage = new UserProfilePage();
		boolean isProfileDisplayed = userProfilePage.isProfileDisplayed();
		softAssert.assertTrue(isProfileDisplayed, "Profile not displayed");

		System.out.println("Step5- Click on Arrow icon on profile");
		userProfilePage.clickOnDropDown();

		System.out.println("Step6- Verify menu total options");
		userProfilePage.getTotalAvailableOptions();

		System.out.println("Step7- Click on about");
		userProfilePage.clickOnAbout();

		System.out.println("Step8- Company details");
		userProfilePage.listOfAboutOptions();

		System.out.println("Step9- Click on Ok");
		userProfilePage.clickOnOk();

	}

	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}

}
