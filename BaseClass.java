package com.neotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;

	public static void setUp() throws InterruptedException {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		String browser = ConfigsReader.getProperty("browser");
		// System.out.println(browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			// System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			// System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		String website = ConfigsReader.getProperty("url");
		driver.get(website);
	}
	
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
