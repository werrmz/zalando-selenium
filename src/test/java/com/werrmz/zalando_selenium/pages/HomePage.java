package com.werrmz.zalando_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.werrmz.zalando_selenium.DefaultDriver;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText = "Zaloguj się") 
	WebElement loginButton;
	
	public HomePage() {
		driver = DefaultDriver.getDriver();
		
		PageFactory.initElements(driver, this);
	}
	
	public void loginButtonClick()  {   
		loginButton.click();
		
	}
}
