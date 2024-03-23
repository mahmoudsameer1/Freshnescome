package com.Freshness.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	String browserName = "Chrome";
	String URL ="https://e-commerce-kib.netlify.app/";

	public static WebDriver getDriver() {

		return driver;
	}

	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		
		if (browserName.equalsIgnoreCase("Chrome")) {
	        ChromeOptions chromeOptions = new ChromeOptions();
//	        chromeOptions.addArguments("--headless");
	        driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(URL);
	}
}
