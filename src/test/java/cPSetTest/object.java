package cPSetTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class object {
	
	WebDriver driver;
	
	@FindBy(id ="search")
	private WebElement search;
	@FindBy(partialLinkText ="javascript:void(0)")
	private WebElement searchButton;
	@FindBy(xpath="")
	private WebElement z;
	@FindBy(xpath="")
	private WebElement a;
	@FindBy(xpath="")
	private WebElement b;
	@FindBy(xpath="")
	private WebElement c;

}
