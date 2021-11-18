package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;

/*Verify the Pagination Functionality

"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as ""your username""
5. User able to enter password as ""your password""
6. Verify ""Dashboard"" as Title(Tab Level) Display Dashboard page
7. Verify total 11 widget's are disply on Dashboard page
8. Verify ""Quick Access"", ""Buzz Latest Posts"", ""Employee Job Details"", ""My Actions"", ""Headcount by Location"", ""Time At Work"", ""Employees on Leave Today"", ""Performance Quick Feedback"", ""Annual basic payment by Location"", ""Latest Documents"" and ""Latest News"" is displayed on Dashboard Page
"


//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='21'][contains(@class,'--infocus')]
*/

public class DashboardTest extends TestBase {

	@BeforeClass
	public void setup() {
		super.setUp();
	}

	@Test
	public void verifyWidgetsTest() {

		System.out.println("Step4 - Verify Dashboard page title should be Dashboard");
		DashboardPage dashboardPage = new DashboardPage();

		String expectedDashboardPageHeaderTitle = "Dashboard";
		String actualDashboardPageHeaderTitle = dashboardPage.getPageHeaderTitle();
		softAssert.assertEquals(actualDashboardPageHeaderTitle, expectedDashboardPageHeaderTitle);

		String expectedDashboardPageTitle = "Dashboard";
		String actualDashboardPageTitle = dashboardPage.getPageTitle();
		softAssert.assertEquals(actualDashboardPageTitle, expectedDashboardPageTitle);

		System.out.println("Step5- Verify total 12 widget's are disply on Dashboard page");
		int totalWidgets = dashboardPage.getTotalWidgets();
		softAssert.assertEquals(totalWidgets, 12);
		softAssert.assertAll();

		System.out.println("Step6- Verify Widgets name");
		List<String> expectedWidgetsList = new ArrayList<String>();
		expectedWidgetsList.add("Quick Access");
		expectedWidgetsList.add("Buzz Latest Posts");
		expectedWidgetsList.add("Employee Job Details");
		expectedWidgetsList.add("My Actions");
		expectedWidgetsList.add("Headcount by Location");
		expectedWidgetsList.add("Employees on Leave Today");
		expectedWidgetsList.add("Time At Work");
		expectedWidgetsList.add("Performance Quick Feedback");
		expectedWidgetsList.add("Annual basic payment by Location");
		expectedWidgetsList.add("Latest Documents");
		expectedWidgetsList.add("Latest News");
		expectedWidgetsList.add("Yearly New Hires");

		List<String> actualWidgetsList = dashboardPage.getAllWidgetsText();
		System.out.println("Step7- Verify widgets names");
		Assert.assertTrue(actualWidgetsList.equals(expectedWidgetsList));
	}

	@AfterClass
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}
