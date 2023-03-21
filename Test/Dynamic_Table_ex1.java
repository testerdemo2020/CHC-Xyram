package Selenium.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dynamic_Table_ex1 {

	public static WebDriver driver;
	public static Properties prop;
	public static int number;

	public static void main(String[] args) throws InterruptedException {

		String driverPathC = System.getProperty("user.dir")+"/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathC);
		driver = new ChromeDriver();

		Actions action = new Actions(driver);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
			prop.load(fp);
		} catch (IOException e) {

			e.printStackTrace();
		}


		driver.get(prop.getProperty("Url_dynamic_table"));
		//Enter username
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys(prop.getProperty("username"));

		//Enter Password
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(prop.getProperty("password"));

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		//Go to sale option
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();

		Thread.sleep(2000);

		//click to order button
		driver.findElement(By.xpath("//ul[@id='collapse26']//a[contains(text(),'Order')]")).click();

		action.sendKeys(Keys.END).build().perform();

		//Total numbers of page in the table
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
		System.out.println(text);
		int total_page = Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Page")-1));
		System.out.println("Total number of pages - "+total_page);

		//Fine all rows from each page
		for(int r=1;r<=2;r++) {

			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));

			System.out.println("Active page is :- "+activePage.getText());

			activePage.click();//Click all active page

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();

			System.out.println("Total number of rows in active page - "+rows);

			//Read all the rows data from each page
			for(int ro=1;ro<=rows;ro++) {

				String orderID = 
						driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+ro+"]//td[2]")).getText();

				String Customer = 
						driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+ro+"]//td[3]")).getText();

				String Status = 
						driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+ro+"]//td[4]")).getText();
				//Read data as depends on status like pending/or done
				if(Status.equals("Pending")) {
					
					System.out.println(orderID+"         "+Customer+"                    "+Status);
				}
			}

			String pageno = Integer.toString(r+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//a[text()='"+pageno+"']")).click();
		}

		Thread.sleep(2000);

		driver.quit();

	}

}
