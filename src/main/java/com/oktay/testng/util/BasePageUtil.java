package com.oktay.testng.util;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.oktay.testng.constants.General_Constants;


/*
 *  Created by oktayuyar on 5.11.2018
 */
public class BasePageUtil implements General_Constants {

    protected WebDriver driver;

    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public void clickElement(By by) {
        find(by).click();
    }

    public void waitAndClickElement(By by) {
        //WebElement element;
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        find(by).click();
    }

    public void click(By by) {
        driver.findElement(by).click();
       
    }

    public void clickWebElement(WebElement webElement) {
        webElement.click();
    }

    public WebElement clickWithJs(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return element;
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void setText(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public WebElement find(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public void controlSearchPage(String pageNumber) {
        if (driver.getCurrentUrl().contains("page=" + pageNumber)) {
        } else {
            Assert.fail(pageNumber + " nolu sayfaya geçilemedi!");
        }
    }

    public void findElementFromListAndClick(By by, int index) {
        List<WebElement> el = driver.findElements(by);
        for (int i = 0; i < el.size(); i++) {
            System.out.println(i);
            if (i == (index - 1)) {
                clickWebElement(el.get(i));
            }
        }
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
