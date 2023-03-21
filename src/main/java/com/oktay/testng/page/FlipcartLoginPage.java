package com.oktay.testng.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.oktay.testng.constants.FlipcartLoginPage_Constants;
import com.oktay.testng.util.BasePageUtil;

/*
 *  Created by oktayuyar on 5.11.2018
 */
public class FlipcartLoginPage extends BasePageUtil implements FlipcartLoginPage_Constants {

	public FlipcartLoginPage(WebDriver driver) {
		super(driver);
	}

	public FlipcartHomePage successfulLogin() {
		setText(emailMobileTxt, invalidEmailNumber);
		setText(passwordTxt, validPassword);
		clickElement(loginBtn);
		Assert.assertTrue(getTitle().equals(txtHomePageTitle));
		return new FlipcartHomePage(driver);
	}

	public FlipcartHomePage unsuccessfulLogin() {
		setText(txtEmail, invalidEmailNumber);
		setText(txtPassword, invalidPassword);
		clickElement(btnSignIn);
		Assert.assertTrue(getTitle().equals(txtHomePageTitle));
		return new FlipcartHomePage(driver);
	}

}
