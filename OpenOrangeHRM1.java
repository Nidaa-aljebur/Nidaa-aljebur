package com.neotech.lesson05;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenOrangeHRM1 {
//	Open Chrome browser
//	Navigate to https://hrm.neotechacademy.com/
//	Print the title of the page
//	Close the browser


	public static void main(String[] args) throws IOException, InterruptedException  {
		
		String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
		
		//This is just optional to check
		System.out.println(filePath);
		
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		
		//Starting with Selenium testing process
		
		WebDriver driver = null;
		
		if (prop.getProperty("browser").equals("chrome")) {
			//open chrome browser
			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (prop.getProperty("browser").equals("firefox")) {
			//open firefox browser
			//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if (driver != null) {
			String website = prop.getProperty("url");
			driver.get(website);
			
			String title = driver.getTitle();
			System.out.println("Title: " + title);
			
			Thread.sleep(3000);
			
			driver.quit();
		} else {
			System.out.println("unsupported browser!");
		}
	}

}
