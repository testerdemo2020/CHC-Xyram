package com.oktay.testng.constants;

import org.openqa.selenium.By;

/*
 *  Created by oktayuyar on 5.11.2018
 */
public interface FlipcartLoginPage_Constants extends General_Constants{

	public String txtHomePageTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books &amp; More. Best Offers!";
	//public String txtLoginPageTitle = "Amazon Sign In";
	
	//Flipkart login elements
	public By loginButton = By.xpath("//*[contains(text(),'Login')]");
	public By emailMobileTxt = By.xpath("//*[@class='IiD88i _351hSN']/input[@type='text']");
	public By passwordTxt = By.xpath("//*[@class='IiD88i _351hSN']//input[@type=\"password\"]");
	public By loginBtn = By.xpath("//*[@type='submit']/span[contains(text(),'Login')]");
	
	//Amezon login elements
	public By txtEmail = By.id("ap_email");
	public By txtPassword = By.id("ap_password");
	public By btnSignIn = By.id("signInSubmit");
}