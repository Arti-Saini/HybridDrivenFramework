package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;

public class PIM_AddEmployee_Page extends PredefinedActions {

	public void clickOnPIM() {
		driver.findElement(By.xpath("//a[@class='collapsible-header waves-effect waves-orange active']")).click();
	}
	public void clickOnAddEmployee() {
		driver.findElement(By.xpath("//span[@combinedmenutitle='PIM > Employee List']")).click();
	}
	public PIM_AddEmployee_Page setEmpFirstName(String firstName) {
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(firstName);
		return this;	
	}
	public PIM_AddEmployee_Page setEmpMiddleName(String middleName) {
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(middleName);
		return this;	
	}
	public PIM_AddEmployee_Page setEmpLastName(String lastName) {
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lastName);
		return this;	
	}
	public PIM_AddEmployee_Page setEmpLocation(String location) {
		driver.findElement(By.xpath("//button[@data-id='location']")).click();
		driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a")).click();   //need 
		return this;	
	}
	public PIM_AddEmployee_Page clickOnNext() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}
	public void addEmployeeDetails(String firstName,String middleName,String lastName, String location) {
		setEmpFirstName(firstName);
		setEmpMiddleName(middleName);
		setEmpLastName(lastName);
		setEmpLocation(location);
		
	}
	
	public PIM_AddEmployee_Page setHobies(String hobies) {
		driver.findElement(By.xpath("//input[@id='5']")).sendKeys(hobies);
		return this;
	}
	
	public PIM_AddEmployee_Page selectWorkShift(String shiftValue) {
		
		try {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
			}
		catch(StaleElementReferenceException staleException) {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();	
		}
//WebElement e = driver.findElement(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"'")).click();
		/*while(!e.isDisplayed()) {
			e = driver.findElement("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']")).click();*/
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOf(e));
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='"+shiftValue+"']")));
			e.click();
			return this;
	
	}
	public PIM_AddEmployee_Page effectiveFrom(String date) {
		driver.findElement(By.xpath("//input[contains(@class,'ng-valid-date ng-touched')]//following-sibling::i")).click();
		driver.findElement(By.xpath("//input[(@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='\"+date+\"'][contains@class,'--infocus')]")).click();
		return this;
	}
	public PIM_AddEmployee_Page selectRegion(String region) {
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/ul/li["+region+"]")).click();
	return this;
	}
	public PIM_AddEmployee_Page selectFTE(String fte) {
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/ul/li["+fte+"]")).click();
		return this;
	}
	public PIM_AddEmployee_Page selectTemporaryDepartment(String department) {
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/ul/li["+department+"]")).click();
		return this;
	}
	public PIM_AddEmployee_Page clickOnSave() {
		driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right']")).click();
		return this;
	}
}
