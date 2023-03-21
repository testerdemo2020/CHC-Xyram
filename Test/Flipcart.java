package Selenium.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Flipcart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
	

		String url = "https://www.flipkart.com/";
		//Using Edge browser
		/*
		 * String driverPath =
		 * System.getProperty("user.dir")+"/driver/msedgedriver.exe";
		 * System.setProperty("webdriver.edge.driver", driverPath); driver = new
		 * EdgeDriver();
		 */
		//Using Chrome browser
		String driverPathC = System.getProperty("user.dir")+"/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathC);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Launch the web-site - https://www.flipkart.com/
		driver.get(url);

		//close the current popup window using Actions class
		Actions actions = new Actions(driver);

		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();

		sendEsc.perform();

		//Search any product
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("running shoes");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);

		//Store all rows from the current page
		List<WebElement> pageRows= driver.findElements(By.xpath("//div[@class='_13oc-S']"));

		System.out.println("Total number of rows = "+pageRows.size());
		
		
		//Selected product detail displayed 

		WebElement detailProduct = driver.findElement(By.xpath("//div[@class='_13oc-S']//div[@data-id]"));

		System.out.println(detailProduct.getText());

		detailProduct.click();
		
		System.out.println("Product search and seleted");
		
		System.out.println("Page title of parent tab: "+driver.getTitle());

		// hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

		Thread.sleep(3000);
		
		//Product size selected
		driver.findElement(By.cssSelector("#swatch-3-size")).click();
		
		//Click on the all to cart button
		driver.findElement(By.xpath("//li[@class='col col-6-12']/button")).click();
		
		System.out.println("Product added to the cart");
		
		driver.quit();
		
			


	}

}
