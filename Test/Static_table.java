/*
How many rows in table
How many columns in a table
Retrive the specific row/column data
Retrive all the data from the table
print release date, version no of java language of selenium
 */



package Selenium.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Static_table {

	public static WebDriver driver;
	public static Properties prop;

	public static void main(String[] args) throws InterruptedException {

		String driverPathC = System.getProperty("user.dir")+"/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathC);
		driver = new ChromeDriver();

		//Load data from properties file
		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
			prop.load(fp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


		//How many rows in table
		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();

		System.out.println("Number of rows - "+rows);

		//How many column in table
		int column = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();

		System.out.println("Number of column - "+column);

		//Retrive the specific row/column data
		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]")).getText();

		System.out.println("Value present is - "+value);

		//Retrive all the data from the table

		for(int r=1;r<=rows;r++) {

			for (int c=1;c<=column;c++) {

				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(data+"    ");
			}

			System.out.println();
		}

		//print release date, version no of java language of selenium

		for(int r=1;r<=rows;r++) {

			String language = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td[1]")).getText();
			if(language.equals("Java")) {

				String version = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td[2]")).getText();
				String releaseDate = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td[3]")).getText();
				System.out.println();
				System.out.println(language+"   "+version+"     "+releaseDate);

			}

		}


		Thread.sleep(2000);

		driver.quit();

	}

}
