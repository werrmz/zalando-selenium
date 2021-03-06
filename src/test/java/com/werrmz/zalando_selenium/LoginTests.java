package com.werrmz.zalando_selenium;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import com.werrmz.zalando_selenium.pages.*;

public class LoginTests {
	WebDriver driver;
	
	final HomePage homePage = new HomePage();
	final LoginPage loginPage = new LoginPage();
	
	@Before
	public void setup() {
		System.out.println("LoginTests Setup");
		driver = DefaultDriver.getDriver();
	}
	
	@Test
	public void loginSuccessfully() {
		// Given
		String mail = "secret@gmail.com";
		String password = "correct-password";
		
		// When
		homePage.loginButtonClick();
		DefaultDriver.wait(1);
		loginPage.login(mail, password);
		DefaultDriver.wait(3);
		
		// Then
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.equals("https://www.zalando.pl/myaccount/"));
		assertTrue(driver.getPageSource().contains("Witaj Weronika"));
	}
	
	@Test
	public void loginUnsuccessfully() {
		// Given
		String mail = "secret@gmail.com";
		String password = "incorrect-password";
		
		// When
		homePage.loginButtonClick();
		DefaultDriver.wait(1);
		loginPage.login(mail, password);
		DefaultDriver.wait(3);
		
		// Then
		Boolean isLoginErrorVisible = loginPage.isLoginErrorVisible();
		assertTrue(isLoginErrorVisible);
	}
	
	@After                    
    public void quit() {
		DefaultDriver.close();
	}
}
