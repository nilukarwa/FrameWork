package com.accenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver dvr;
	
	@FindBy(id="Email")
	static WebElement TextBox_username;
	
	@FindBy(id="Password")
	static WebElement TextBox_password;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	static WebElement submit_btn;
	
	public void enterLogin(String username, String password) {
		TextBox_username.sendKeys(username);
		TextBox_password.sendKeys(password);
		submit_btn.click();
	}
}