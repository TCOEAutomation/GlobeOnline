package com.pages;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.browserstack.DriverManager;

public class PendingPaymentPage extends BasePage{
	By orderID = By.xpath("//div[@class='reference-number']/span");
	By PendingHeader = By.xpath("(//span[text()='Pending Payment '])[1]");
	By OrderDetailsHeader = By.xpath("(//span[text()='Order details'])[1]");
	By PrintIcon = By.xpath("//div[@class='print-icon']/img");
	By RefNumHeader = By.xpath("(//span[text()='Reference number'])[1]");
	By RefNumVal = By.xpath("//div[@class='reference-number']/span");
	By CopyIcon = By.xpath("//div[@class='reference-img']/img");
	By CompleterTranLbl = By.xpath("(//span[text()='To complete your transaction'])[1]");
	By GoImg = By.xpath("(//img[@alt='Go Store'])[1]");
	By ShowImg = By.xpath("(//img[@alt='Present QR Code'])[1]");
	By PayImg = By.xpath("(//img[@alt='Pay'])[1]");
	By GoHeader = By.xpath("(//span[text()='Go'])[1]");
	By GoDesc = By.xpath("(//p[text()='to your nearest'])[1]");
	By ShowHeader = By.xpath("(//span[text()='Show'])[1]");
	By ShowDesc = By.xpath("(//p[text()='the reference code provided below.'])[1]");
	By PayHeader = By.xpath("(//span[text()='Pay'])[1]");
	By PayDesc = By.xpath("(//p[text()='the total amount due:'])[1]");
	By PurSummaryHeader = By.xpath("(//span[text()='Purchase Summary'])[1]");
	By ShippingAddLbl = By.xpath("(//span[text()='Shipping address'])[1]");
	By ShippingAddVal = By.xpath("//div[@class='value']/span");
	By PayMethodLbl = By.xpath("(//span[text()='Payment method'])[1]");
	By PayMethodVal = By.xpath("(//div[@class='payment-method-value']/span)[1]");
	By AmountLbl = By.xpath("(//span[text()='Amount to pay'])[1]");
	By AmountVal = By.xpath("(//div[@class='payment-method-value']/span)[2]");
	By ItemOrderLbl = By.xpath("(//span[text()='Item ordered'])[1]");
	By ItemImg1 = By.xpath("(//img[@class='globeImage1'])[1]");
	By CartTitle1 = By.xpath("//div[@class='cardtitleheading']");
	By ProdName1 = By.xpath("(//div[@class='rightDetails']//div[@class='sub-heading'])[1]");
	By ProdDesc1 = By.xpath("(//div[@class='description']//span)[1]");
	By OTCReminderImg = By.xpath("//img[@alt='OTC Reminder']");
	By OTCReminderHdr = By.xpath("(//span[text()='Reminder'])[1]");
	By OTCReminderDesc = By.xpath("(//p[text()='Also a reminder that order should be paid within 48 hrs'])[1]");
	
	
	
	/********************************************************************************************************************************/
	public WebElement get_PendingPaymentOrderID() {
		return DriverManager.getDriver().findElement(orderID);
	}
	public WebElement get_PrintIcon() {
		return DriverManager.getDriver().findElement(PrintIcon);
	}
	public WebElement get_CopyIcon() {
		return DriverManager.getDriver().findElement(CopyIcon);
	}
	
	/********************************************************************************************************************************/	
	public void clickOnElement(String type, String eleName, String ele) {

		try {
			switch (ele) {
			case "PrintIcon":
				get_PrintIcon().click();
				break;
			case "CopyIcon":
				get_CopyIcon().click();
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
	/********************************************************************************************************************************/
	public void scroll_vertical(int y_Axis) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(0," + y_Axis + ")", "");
	}
	
	/*****************************************************************************************************************************************/
	public String getText(String ele) {
		String text = "";

		try {
			switch (ele) {
			case "ShippingAddVal":
				text = DriverManager.getDriver().findElement(ShippingAddVal).getText();
				break;
			case "PayMethodVal":
				text = DriverManager.getDriver().findElement(PayMethodVal).getText();
				break;
			case "AmountVal":
				text = DriverManager.getDriver().findElement(AmountVal).getText();
				break;
			case "ProdName1":
				text = DriverManager.getDriver().findElement(ProdName1).getText();
				break;
			case "orderID":
				text = DriverManager.getDriver().findElement(orderID).getText();
				break;
			}
			

		} catch (NoSuchElementException e) {
			System.out.println("Element : " + ele.toString() + " : " + "not found : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Method : getText - Error : " + e.getMessage());
		}

		return text;
	}
	
	/********************************************************************************************************************************/
	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "PendingHeader":
			flag = waitForElementVisibility(PendingHeader, waitTime);
			break;
		case "OrderDetailsHeader":
			flag = waitForElementVisibility(OrderDetailsHeader, waitTime);
			break;
		case "PrintIcon":
			flag = waitForElementVisibility(PrintIcon, waitTime);
			break;
		case "RefNumHeader":
			flag = waitForElementVisibility(RefNumHeader, waitTime);
			break;
		case "RefNumVal":
			flag = waitForElementVisibility(RefNumVal, waitTime);
			break;
		case "CopyIcon":
			flag = waitForElementVisibility(CopyIcon, waitTime);
			break;
		case "CompleterTranLbl":
			flag = waitForElementVisibility(CompleterTranLbl, waitTime);
			break;
		case "GoImg":
			flag = waitForElementVisibility(GoImg, waitTime);
			break;
		case "ShowImg":
			flag = waitForElementVisibility(ShowImg, waitTime);
			break;
		case "PayImg":
			flag = waitForElementVisibility(PayImg, waitTime);
			break;
		case "GoHeader":
			flag = waitForElementVisibility(GoHeader, waitTime);
			break;
		case "GoDesc":
			flag = waitForElementVisibility(GoDesc, waitTime);
			break;
		case "ShowHeader":
			flag = waitForElementVisibility(ShowHeader, waitTime);
			break;
		case "ShowDesc":
			flag = waitForElementVisibility(ShowDesc, waitTime);
			break;
		case "PayHeader":
			flag = waitForElementVisibility(PayHeader, waitTime);
			break;
		case "PayDesc":
			flag = waitForElementVisibility(PayDesc, waitTime);
			break;
		case "PurSummaryHeader":
			flag = waitForElementVisibility(PurSummaryHeader, waitTime);
			break;
		case "ShippingAddLbl":
			flag = waitForElementVisibility(ShippingAddLbl, waitTime);
			break;
		case "ShippingAddVal":
			flag = waitForElementVisibility(ShippingAddVal, waitTime);
			break;
		case "PayMethodLbl":
			flag = waitForElementVisibility(PayMethodLbl, waitTime);
			break;
		case "PayMethodVal":
			flag = waitForElementVisibility(PayMethodVal, waitTime);
			break;
		case "AmountLbl":
			flag = waitForElementVisibility(AmountLbl, waitTime);
			break;
		case "AmountVal":
			flag = waitForElementVisibility(AmountVal, waitTime);
			break;
		case "ItemOrderLbl":
			flag = waitForElementVisibility(ItemOrderLbl, waitTime);
			break;
		case "ItemImg1":
			flag = waitForElementVisibility(ItemImg1, waitTime);
			break;
		case "CartTitle1":
			flag = waitForElementVisibility(CartTitle1, waitTime);
			break;
		case "ProdName1":
			flag = waitForElementVisibility(ProdName1, waitTime);
			break;
		case "ProdDesc1":
			flag = waitForElementVisibility(ProdDesc1, waitTime);
			break;
		case "OTCReminderImg":
			flag = waitForElementVisibility(OTCReminderImg, waitTime);
			break;
		case "OTCReminderHdr":
			flag = waitForElementVisibility(OTCReminderHdr, waitTime);
			break;
		case "OTCReminderDesc":
			flag = waitForElementVisibility(OTCReminderDesc, waitTime);
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
