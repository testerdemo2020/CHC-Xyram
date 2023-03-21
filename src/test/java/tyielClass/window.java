package tyielClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testScript.BaseClass;

public class window extends BaseClass{

	@Test

	public void flipcartWindowHandel() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		
		System.out.println(driver.getTitle());
		
		ArrayList<String> newWin = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newWin.get(0));		
		System.out.println(newWin.size());
		WebElement pageVerify = driver.findElement(By.xpath("//span[@class='_36KMOx']//span[contains(text(),'Login')]"));
		
		System.out.println("Current page verified with this text := "+pageVerify.getText());
		
		//By loginButton = By.xpath("//*[contains(text(),'Login')]");
		By emailMobileTxt = By.xpath("//*[@class='IiD88i _351hSN']/input[@type='text']");
		By passwordTxt = By.xpath("//*[@class='IiD88i _351hSN']//input[@type=\"password\"]");
		By loginBtn = By.xpath("//*[@type='submit']/span[contains(text(),'Login')]");

		//driver.findElement(loginButton).click();
		Thread.sleep(1000);
		driver.findElement(emailMobileTxt).sendKeys("9650272999");
		driver.findElement(passwordTxt).sendKeys("alok0235");
		driver.findElement(loginBtn).click();
		
		System.out.println("Homepage title is:- "+driver.getTitle());

		Thread.sleep(1000);
		
		Actions action = new Actions(driver);
		
		List<WebElement> mouserHover = driver.findElements(By.xpath("//*[@class='eFQ30H']"));
		
		for (WebElement webElement : mouserHover) {
			
			
			
		}

		/*Set<String> s =driver.getWindowHandles();

		for (String i : s) {

			String w = driver.switchTo().window(i).getTitle();

			Thread.sleep(3000);
*/

			/*
			 * if(w.contains("SeleniumHQ Browser Automation")) { 
			 * String c = driver.switchTo().window(i).getTitle();
			 * driver.findElement(By.xpath("//nav[@id='navbar']//a[@class='nav-item'][5]")).
			 * click();
			 * Thread.sleep(3000);
			 * driver.close(); }
			 */

		

	}
}
