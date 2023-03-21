package testScript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.Page_login;
import utilities.ReadConfig;


public class TC_01_Login extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException {
		
		ReadConfig prop = new ReadConfig();
		logger.info("TestCase for login started");
				
		logger.info("Navigate to Login page");
		
		//Create object for login page class
		Page_login login = new Page_login(getDriver());
		
		login.enterEmail(prop.getDrEmailId());
		logger.info("Email entered");
		login.enterPassword(prop.getDrPassword());
		logger.info("Password entered");
		login.ClicktoSignIn();
		Thread.sleep(1000);
		logger.info("Login Successfully");
		takeScreenshot("HomePage");
		logger.info("Screenshot taken for homepage");
		Assert.assertEquals("Clock Health",driver.getTitle(), "Test Case failed");
		logger.info("TestCase 1 ended");

	}

}
