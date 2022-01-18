package com.pages;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.browserstack.DriverManager;

public class OrderDetailsPage extends BasePage {

	By referenceNumber = By.xpath("//span[@class='refNo']");
	By orderActiveStatus = By.xpath("(//div[contains(@class,'show-active-title')])[1]/span");
	By completedDate = By.xpath("//div[contains(@class,'show-active-title')]/following-sibling::div");
	By productName = By.xpath("//div[contains(@class,'card-description')] //div[contains(@class,'sub-heading')]");
	By quantity = By.xpath("//div[contains(@class,'row unit-section')]/div/span");
	By productImage = By.xpath("//img[contains(@class,'globeImage')]");
	By updateDate = By.xpath("//div[contains(@class,'order-recieved-data')]");
	By dateOrdered = By.xpath("(//div[contains(@class,'grab')])[1]/span");
	By paymentMethod = By.xpath("(//div[contains(@class,'grab')])[2]/span");
	By amountPaid = By.xpath("(//div[contains(@class,'grab')])[3]/span");
	By shippingAddress = By.xpath("//div[text()='Ship to this address']/following-sibling::div");
	By estDayOfDelivery = By.xpath("//div[text()='Estimated day of delivery']/following-sibling::div");

	/********************************************************************************************************************************/
	public WebElement get_referenceNumber() {
		return DriverManager.getDriver().findElement(referenceNumber);
	}

	/********************************************************************************************************************************/
	public WebElement get_orderActiveStatus() {
		return DriverManager.getDriver().findElement(orderActiveStatus);
	}

	/********************************************************************************************************************************/
	public WebElement get_completedDate() {
		return DriverManager.getDriver().findElement(completedDate);
	}

	/********************************************************************************************************************************/
	public WebElement get_productName() {
		return DriverManager.getDriver().findElement(productName);
	}

	/********************************************************************************************************************************/
	public WebElement get_quantity() {
		return DriverManager.getDriver().findElement(quantity);
	}

	/********************************************************************************************************************************/
	public WebElement get_updateDate() {
		return DriverManager.getDriver().findElement(updateDate);
	}

	/********************************************************************************************************************************/
	public WebElement get_dateOrdered() {
		return DriverManager.getDriver().findElement(dateOrdered);
	}

	/********************************************************************************************************************************/
	public WebElement get_paymentMethod() {
		return DriverManager.getDriver().findElement(paymentMethod);
	}

	/********************************************************************************************************************************/
	public WebElement get_amountPaid() {
		return DriverManager.getDriver().findElement(amountPaid);
	}

	/********************************************************************************************************************************/
	public WebElement get_shippingAddress() {
		return DriverManager.getDriver().findElement(shippingAddress);
	}

	/********************************************************************************************************************************/
	public WebElement get_estDayOfDelivery() {
		return DriverManager.getDriver().findElement(estDayOfDelivery);
	}

	/********************************************************************************************************************************/
	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
//		case "privacyAccept":
//			flag = waitForElementVisibility(privacyAccept, waitTime);
//			break;

		}

		if (flag) {
			System.out.println(message + " - exists");
		} else {
			System.out.println(message + " - do not exist");
		}

		return flag;
	}

	/********************************************************************************************************************************/
	public boolean isClickable(String element, int waitTime) {

		boolean flag = false;

		switch (element) {
//		case "link_LTE_Advanced":
//			flag = waitForElementClickable(link_LTE_Advanced, waitTime);
//			break;

		}

		return flag;
	}

	/********************************************************************************************************************************/
	public void moveToElement(String element) {

		WebElement ele = null;

		switch (element) {
//		case "menuBuy":
//			ele = DriverManager.getDriver().findElement(link_MenuBuy);
//			break;

		}

		try {
			Actions a = new Actions(DriverManager.getDriver());
			Thread.sleep(500L);
			a.moveToElement(ele).build().perform();
		} catch (Exception e) {

		}
	}

	/********************************************************************************************************************************/
	public void clickOnElement(String type, String eleName, String ele) {

		try {
			switch (ele) {
//			case "menuBuy":
//				get_menuBuy().click();
//				break;

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

	/********************************************************************************************************************************/
	public String getAttributeValue(String ele, String attribute) {
		String text = "";

		try {
			switch (ele) {
			case "productImage":
				text = DriverManager.getDriver().findElement(productImage).getAttribute(attribute);
				break;

			}

		} catch (NoSuchElementException e) {
			System.out.println("Element : " + ele.toString() + " : " + "not found : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Method : getText - Error : " + e.getMessage());
		}

		return text;
	}

}
