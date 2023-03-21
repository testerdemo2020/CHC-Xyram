package Selenium.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickers {

	public static WebDriver driver;
	static String year = "2022";
	static String month = "July";
	static String date = "15";

	public static void main(String[] args) throws InterruptedException {

		String driverPathC = System.getProperty("user.dir") + "/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathC);
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[normalize-space()='Date']")).click();

		while (true) {

			String str = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();

			String[] data = str.split(" ");
			String mm = data[0];
			String yy = data[1];

			if (mm.equalsIgnoreCase(month) && yy.equals(year)) {
				break;
			} else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}

		List<WebElement> datePick = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

		for (WebElement dt : datePick) {

			String dd = dt.getText();
			if (dd.equals(date)) {

				dt.click();

			}
		}

		
		  Thread.sleep(2000); 
		  driver.close();
		 

	}

}
