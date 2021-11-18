package com.technocredits.orghrm.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployee_Page;

/*1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Login with username and password 
3. Verify ""Dashboard"" as Title(Tab Level) Display Dashboard page
4. Go to PIM--> Add employee button
5. Add all details in form and add employee
6. Go to PIM--> Employee list
7. Verify recently added employee should be displayed on Employee list*/
public class PIM_AddEmployeeTest extends TestBase {

	private MenuPage menuPage;

	@BeforeMethod
	public void setup() {
		menuPage = super.setUp();
	}

	@Test
	public void VerifyPIMAddEmployee() throws InterruptedException {
		System.out.println("Step2- Navigate to PIM Add Employee");
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployee_Page page = new PIM_AddEmployee_Page();
		
		System.out.println("Step3- Add Employee Details");
		page.addEmployeeDetails("Arti", "S", "Gahlot", "Canadian Regional HQ");
		
		System.out.println("Step4- Click on next");
		page.clickOnNext();
		
		System.out.println("Step5- Set hobbies");
		page.setHobies("Learning");
		
		System.out.println("Step6- Click on next");
		page.clickOnNext();
		Thread.sleep(5000);
		
		System.out.println("Step7- Select workShift");
		page.selectWorkShift("General");
		// page.effectiveFrom("13");
		
		System.out.println("Step8- Select Region");
		page.selectRegion("3");
		
		System.out.println("Step9- Select FTE");
		page.selectFTE("3");
		
		System.out.println("Step10- Select Temporary Department");
		page.selectTemporaryDepartment("3");
		
		System.out.println("Step11- Tap on save");
		page.clickOnSave();
	}

	// @AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}
