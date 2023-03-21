/*

1.Launch the web-site - https://www.makemytrip.com/ 
2.Click on “Flights” 
3.Choose From and To Values 
4.Select the Travel date 
5.Click Search 6.Print the “Price” values in ascending order 
7.Choose the lowest fare bus and capture screenshot 
8.Click “Select seats” button and put explicit wait. 
9.Click the required seat 10.Click “Book Seat” 
11.Assert the From and To Value 
12.Close the browser

 */
package Selenium.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;

		String url = "https://www.makemytrip.com/";
		String driverPath = System.getProperty("user.dir")+"/driver/msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();

		//Using Chrome browser
		/*
		 * String driverPathC =
		 * System.getProperty("user.dir")+"/driver/chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", driverPathC); driver = new
		 * ChromeDriver();
		 */		 

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Launch the web-site - https://www.makemytrip.com/
		driver.get(url);
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//main[@class='landingContainer']")).click();
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

		driver.close();
		
		driver.switchTo().window(newTb.get(0));
		
		//Click on “Flights”
		driver.findElement(By.xpath("//ul[@class='makeFlex font12']//a[@class='active makeFlex hrtlCenter column']")).click();

		//Choose From and To Values
		
		WebElement fromCity = driver.findElement(By.id("fromCity"));

		System.out.println("Element is display (From) :- "+fromCity.isDisplayed());
		
		fromCity.sendKeys("delhi",Keys.TAB);

		WebElement toCity = driver.findElement(By.id("toCity"));

		System.out.println("Element is display (to) :- "+toCity.isDisplayed());
		
		toCity.sendKeys("Bangalore", Keys.TAB);
		
		//From and to Date from calender 
		
		WebElement fromDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Tue Jun 04 2021']"));
		System.out.println("From date is enabled: "+fromDate.isEnabled());
		fromDate.click();
		
		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
		WebElement toDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Tue Jun 08 2021']"));
		System.out.println("To date is enabled: "+toDate.isEnabled());
		toDate.click();
		
		Thread.sleep(2000);
		
		//Click Search
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		
		Thread.sleep(2000);
		
		//Print the “Price” values in ascending order
		
		List<WebElement> listDetails = driver.findElements(By.id("listing-id"));
		
		System.out.println("How many sheet in one page :-"+listDetails.size());
		
		Thread.sleep(2000);
		
		//Click on book now button
		driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		







	}

}
