package com.oktay.testng.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


//import utilities.ReadConfig;

/*
 *  Created 5.11.2022
 */
public class BaseTest {

	public WebDriver driver;
	String date = new SimpleDateFormat("yyyy-MM-dd/hhmmss").format(new Date());
	public static Logger logger;
	//ReadConfig prop = new ReadConfig();
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("firefox"))

			driver.manage().window().fullscreen();
		//driver.navigate().to(URL_FLIPKART);

		logger = Logger.getLogger("ClockHealth");
		PropertyConfigurator.configure("log4j.properties");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	//Take Full screen ScreenShot
	public void takeScreenshot(String Filename) {

		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourchPath = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir")+"\\screenshots\\"+Filename+"_"+date+".png");
		try {
			FileUtils.copyFile(sourchPath, destinationPath);
		} catch (IOException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		}

	}
	//Take particular element screen ScreenShot

	public void takeElementScreenShot(WebElement element, String Filename) {

		File sourchPath = element.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir")+"\\screenshots\\"+Filename+"_"+date+".png");
		try {
			FileUtils.copyFile(sourchPath, destinationPath);
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			System.out.println("File location not found");
			e.printStackTrace();
		}

	}
}
