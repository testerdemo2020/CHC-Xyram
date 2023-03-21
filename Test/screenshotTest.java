package Selenium.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testScripts.BaseClass;

public class screenshotTest extends BaseClass{
	
	
	@Test
	
	public void test1() {
		
		WebElement src = driver.findElement(By.xpath("//a[normalize-space()='Software Testing']"));
		
		takeFullScreenshot("fullscreen");
		takeElementScreenShot(src, "ElementScrn");
		src.click();
	}

}
