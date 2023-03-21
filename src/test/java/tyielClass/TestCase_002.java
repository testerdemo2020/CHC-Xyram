package tyielClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase_002 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
	

		String url = "https://www.facebook.com/login/";
		String driverPathC = System.getProperty("user.dir")+"/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathC);
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//Launch the web site
		driver.get(url);
		
		WebElement textEmailId = driver.findElement(By.name("email"));
		
		WebElement textPassword = driver.findElement(By.id("pass"));
		
		WebElement buttonSubmit = driver.findElement(By.name("login"));
		
		textEmailId.sendKeys("tester.2020demo@gmail.com");
		
		textPassword.sendKeys("Tester");
		
		buttonSubmit.submit();
		
		//driver.quit();

	}

}
