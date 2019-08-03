package com.werrmz.zalando_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.werrmz.zalando_selenium.DefaultDriver;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name = "login.email")
	WebElement mailInput;
	
	@FindBy(name = "login.password")
	WebElement passwordInput;
	
	@FindBy(css = "[data-testid = login_button]")
	WebElement loginButton;
	
	@FindBy(css = "[data-testid = login_error_notification]")
	WebElement loginErrorNotification;
	
	public LoginPage() {
		driver = DefaultDriver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void login(String mail, String password) {
		mailInput.sendKeys(mail);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
	
	public Boolean isLoginErrorVisible() {
		return loginErrorNotification.isDisplayed();
	}
	
}
