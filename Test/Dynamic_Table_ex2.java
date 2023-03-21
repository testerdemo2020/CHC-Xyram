package Selenium.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dynamic_Table_ex2 {

	public static WebDriver driver;
	public static Properties prop;
	

	public static void main(String[] args) throws InterruptedException {

		String driverPathC = System.getProperty("user.dir")+"/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathC);
		driver = new ChromeDriver();

		Actions action = new Actions(driver);

		//Data read from properties file

		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
			prop.load(fp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.get(prop.getProperty("Url1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		
		System.out.println("Total number of rows :- "+totalRows.size());
		
		List<WebElement> totalColumn = driver.findElements(By.xpath("//table[@class='dataTable']//thead//th"));
		System.out.println("Total number of rows :- "+totalColumn.size());
		
		action.sendKeys(Keys.END).build().perform();
		
		
		
		
		Thread.sleep(2000);

		driver.quit();

	}

}
