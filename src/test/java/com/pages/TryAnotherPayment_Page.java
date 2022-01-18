package com.pages;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.browserstack.DriverManager;

public class TryAnotherPayment_Page extends BasePage {
	By TryAnotherIcon = By.xpath("//div[@class='icon-frame col-2']/img");
	By DeclinedHeader = By.xpath("//span[text()='Sorry, your purchase was declined. ']");
	By DeclinedDesc = By.xpath("//p[text()=' But no worries, you can always try a different payment option. ']");
	By TryAnotherBtn = By.xpath("//button[@id='tryDifferentPayment']");
	
	/********************************************************************************************************************************/
	public WebElement get_TryAnotherBtn() {
		return DriverManager.getDriver().findElement(TryAnotherBtn);
	}
	
	/********************************************************************************************************************************/
	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "TryAnotherIcon":
			flag = waitForElementVisibility(TryAnotherIcon, waitTime);
			break;
		case "DeclinedHeader":
			flag = waitForElementVisibility(DeclinedHeader, waitTime);
			break;
		case "DeclinedDesc":
			flag = waitForElementVisibility(DeclinedDesc, waitTime);
			break;
		case "TryAnotherBtn":
			flag = waitForElementVisibility(TryAnotherBtn, waitTime);
			break;
		}

		if (flag) {
			System.out.println(message + " - exists");
		} else {
			System.out.println(message + " - do not exist");
		}

		return flag;
	}
	/********************************************************************************************************************************/
	public void clickOnElement(String type, String eleName, String ele) {

		try {
			switch (ele) {
			case "TryAnotherBtn":
				get_TryAnotherBtn().click();
				break;

			}
		} catch (ElementClickInterceptedException e1) {
			System.out.println(type + " : " + eleName + " : " + "Element is not clickable : " + e1.getMessage());
			Assert.assertTrue(false);
		} catch (NoSuchElementException e2) {
			System.out.println(type + " : " + eleName + " : " + "Element not found : " + e2.getMessage());
			Assert.assertTrue(false);
		} catch (Exception e) {
			System.out.println(type + " : " + eleName + " : " + "Exception : " + e.getMessage());
			Assert.assertTrue(false);
		}

		System.out.println("Clicked on " + type + " : " + eleName);
	}
	
	
}
