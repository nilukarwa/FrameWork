package com.accenture.cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinationLogin<driver> {
	WebDriver driver;
	@Given("^When I am on the Tricentis login page$")
	public void when_I_am_on_the_Tricentis_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PDC2B-Training.pdc2b\\Downloads\\Selenium Drivers\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com/");
	}

	@When("^I give abc and xyz$")
	public void i_give_abc_and_xyz() throws Throwable {
		System.out.println("Enter username and password");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("abc");
		driver.findElement(By.id("Password")).sendKeys("xyz");
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
		System.out.println("Click on Login button");
	}

	@Then("^I should be able to login$")
	public void i_should_be_able_to_login() throws Throwable {
		System.out.println("Login is successful");
		String s = driver.getTitle();
		Assert.assertEquals("Demo Web Shop. Login ", s);
	}
}