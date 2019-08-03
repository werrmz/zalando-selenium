package com.werrmz.zalando_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultDriver {
	static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/weronika/Code/Selenium/chromedriver");
		
		if (driver == null) {
			driver = new ChromeDriver();
			driver.get("https://www.zalando.pl");
		}
		
		return driver;
	}
	
	public static void wait(int seconds) {
    	try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		driver.quit();
		driver = null;
	}
}
