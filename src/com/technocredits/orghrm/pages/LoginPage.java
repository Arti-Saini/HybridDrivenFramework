package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class LoginPage extends PredefinedActions {
	
	public boolean isLogoDisplayed() {
		return driver.findElement(By.xpath("//img")).isDisplayed();
		
	}
	public boolean isLogoPanelDisplayed() {
		return driver.findElement(By.xpath("//div[@id='logInPanelHeading']")).isDisplayed();
	}
	public void enterCredential(String userName, String password) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	}
	public MenuPage clickOnLoginButton() {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		return new MenuPage();
	}
	public String getErrorLoginMessageAsEmptyPassword() {
		return driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
	}

	public String getErrorLoginMessageAsEmptyUserName() {
		return driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
	}
	
	public String getErrorLoginMessageAsEmptyUserNameAndPassword() {
		return driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
	}
	
	public String getErrorLoginMessageAsWrongCredential() {
		return driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	}

}
