package com.accenture.tests;

import org.testng.annotations.Test;
import com.accenture.pages.HomePage;
import com.accenture.pages.LoginPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class LoginTest {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	
	@Test
	public void testLogin() {
		driver.get("http://demowebshop.tricentis.com/");
		hp.doLogin();
		lp.enterLogin("myname@test.com", "myname123");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PDC2B-Training.pdc2b\\Downloads\\Selenium Drivers\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		hp = PageFactory.initElements(driver, HomePage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
	}
}