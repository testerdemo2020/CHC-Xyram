package pageClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_login {

	WebDriver driver;
	static Boolean eval;
	String ee;

	public Page_login(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//All element locators in Register and login page
	
	@FindBy(css = "#mat-input-0")
	@CacheLookup
	private WebElement username;
	
	@FindBy(css = "#mat-input-1")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(xpath="//img[contains(@class,'chc-logo')]")
	@CacheLookup
	private WebElement chcLogo;

	public void enterEmail(String Name) {

		username.sendKeys(Name);
	}
	
	public void enterPassword(String pwd) {

		password.sendKeys(pwd);
	}
	
	public void ClicktoSignIn() {

		signIn.click();
	}
}


