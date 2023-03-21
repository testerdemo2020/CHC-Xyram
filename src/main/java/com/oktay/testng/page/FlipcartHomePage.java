package com.oktay.testng.page;

import com.oktay.testng.constants.FlipcartHomePage_Constants;
import com.oktay.testng.util.BasePageUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/*
 *  Created by oktayuyar on 5.11.2018
 */
public class FlipcartHomePage extends BasePageUtil implements FlipcartHomePage_Constants {

    public FlipcartHomePage(WebDriver driver) {
        super(driver);
    }

    public FlipcartLoginPage callLoginPage() {
        Assert.assertTrue(getTitle().equals(txtHomePageTitle));
        clickElement(btnLoginPage);
        Assert.assertTrue(getTitle().equals(txtLoginPageTitle));
        return new FlipcartLoginPage(driver);
    }

}
