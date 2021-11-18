package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class LoginTest {

	@BeforeMethod
	public void setup() {
		PredefinedActions.start("https://artisaini-trials72.orangehrmlive.com/");
	}

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void loginTest() {
		System.out.println("Step2- Verify Logo display on login page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo not displayed");

		System.out.println("Step3- Verify Login Panel displayed on Login Page");
		boolean isLogoPanelDisplayed = loginPage.isLogoPanelDisplayed();
		softAssert.assertTrue(isLogoPanelDisplayed, "LogoPanel not displayed");

		System.out.println("Step4- User able to enter username and password");
		loginPage.enterCredential("Admin", "6XgvE8L@yV");
		softAssert.assertAll();

		System.out.println("Step5- User click on Login button on Login Page");
		loginPage.clickOnLoginButton();
	}

	@Test
	public void loginTestWithoutPassword() {
		LoginPage loginPage = new LoginPage();
		System.out.println("Step6- User able to enter username and password");
		loginPage.enterCredential("Admin", "");
		softAssert.assertAll();

		System.out.println("Step7- User click on Login button on Login Page");
		loginPage.clickOnLoginButton();
		String expectedErrorMessage = "Password cannot be empty";
		String actualErrorMessage = loginPage.getErrorLoginMessageAsEmptyPassword();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Test
	public void loginTestWithoutUserName() {
		LoginPage loginPage = new LoginPage();
		System.out.println("Step8- User able to enter username and password");
		loginPage.enterCredential("", "6XgvE8L@yV");
		softAssert.assertAll();

		System.out.println("Step9- User click on Login button on Login Page");
		loginPage.clickOnLoginButton();
		String expectedErrorMessage = "Username cannot be empty";
		String actualErrorMessage = loginPage.getErrorLoginMessageAsEmptyUserName();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Test
	public void loginTestWithoutUserNameAndPassword() {
		LoginPage loginPage = new LoginPage();
		System.out.println("Step10- User able to enter username and password");
		loginPage.enterCredential("", "");
		softAssert.assertAll();

		System.out.println("Step11- User click on Login button on Login Page");
		loginPage.clickOnLoginButton();
		String expectedErrorMessage = "Username cannot be empty";
		String actualErrorMessage = loginPage.getErrorLoginMessageAsEmptyUserNameAndPassword();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Test
	public void loginWithWrongUserAndPassword() {
		LoginPage loginPage = new LoginPage();
		System.out.println("Step12- User able to enter username and password");
		loginPage.enterCredential("bmbc", "gsiakksjhxa");
		softAssert.assertAll();

		System.out.println("Step13- User click on Login button on Login Page");
		loginPage.clickOnLoginButton();
		String expectedErrorMessage = "Invalid Credentials";
		String actualErrorMessage = loginPage.getErrorLoginMessageAsWrongCredential();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}
