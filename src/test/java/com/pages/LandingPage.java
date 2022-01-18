package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import com.ExtentListeners.ExtentManager;
//import com.ExtentListeners.ExtentTestManager;
import com.browserstack.DriverManager;

public class LandingPage extends BasePage {

	static File file;

//	public static WebDriverManager.getDriver() DriverManager.getDriver();
//
//	public LandingPage(WebDriverManager.getDriver() DriverManager.getDriver()) {
//		this.DriverManager.getDriver() = DriverManager.getDriver();
//	}

	By privacyAccept = By.xpath("//button[text()=' I accept']");
	By link_Apply = By.xpath("//form[contains(@class,'menu-bar-height')] //a[text()='Apply']");
	By link_Renew = By.xpath("//form[contains(@class,'menu-bar-height')] //a[text()='Renew']");
	By link_Switch = By.xpath("//form[contains(@class,'menu-bar-height')] //a[text()='Switch']");
	By link_MenuBuy = By.xpath("//form[contains(@class,'menu-bar-height')] //a[text()='Buy']");
	By link_Help = By.xpath("//form[contains(@class,'menu-bar-height')] //a[text()=' Help ']");
	By link_LogoGlobe = By.xpath("//a/img[@alt = 'Globe Logo']");
	By link_XtremeHomePrepaidWiFi = By.xpath("//a[text() = 'Xtreme Home Prepaid WiFi']");
	By link_GlobeAtHomePrepaidWiFi = By.xpath("//a[text() = 'Globe At Home Prepaid WiFi']");
	By link_LTE_Advanced = By.xpath("//a[text() = 'LTE Advanced']");
	By link_BLACKPINKLimitedEdition = By.xpath("//a[text() = 'BLACKPINK Limited Edition']");
	By link_MyFiLTE = By.xpath("//a[text() = 'MyFi LTE']");
	By link_MyFiLTE_Advanced = By.xpath("//a[text() = 'MyFi LTE-Advanced']");
	By CartIcon = By.xpath("//a/img[contains(@src,'cart-icon')]");
	By link_TrackMyOrder = By.xpath("//form[contains(@class,'menu-bar-height')] //a[text()=' Track my order ']");
	By cookiesNotification = By.xpath("//p[contains(text(),'uses cookies to help')]");
	By downloadManual = By.xpath("//a[text()='Download Manual']");
	By buyNow = By.xpath("//button[text()='Buy now']");
	By floatingBuyNow = By.xpath("//span[text()='Buy now']");
	By floatActualPrice = By.xpath("//span[@class='actualPrice']");
	By link_highlights = By.xpath("//div[@class='link' and text()=' Highlights ']");
	By link_features = By.xpath("//div[@class='link' and text()=' Features ']");
	By link_specifications = By.xpath("//div[@class='link' and text()=' Specifications ']");
	By link_compare = By.xpath("//div[@class='link' and text()=' Compare ']");
	By footer = By.xpath("//div[text()='© 2021 GLOBE TELECOM, INC.']");
	By footerPrivacyPolicy = By.xpath("//a[text()='Privacy Policy']");
	By footerTermsOfUse = By.xpath("//a[text()='Terms of Use']");
	By footerSiteMap = By.xpath("//a[text()='Site Map']");

//	By rBtn_condominium = By.xpath("//input[@id='Condominium']");

	By thankYouNote = By.xpath("//h1[text()=' Thank you! ']");
//	By orderID = By.xpath("//div[text()=' Reference number ']/../div[2]/div[1]");
	By orderID = By.xpath(
			"//div[text()=' Reference number ']/../div[2]/div[1] | //span[text()='Reference number']/../../div[2]/span");

	/********************************************************************************************************************************/
	public WebElement get_privacyAccept() {
		return DriverManager.getDriver().findElement(privacyAccept);
	}

	/********************************************************************************************************************************/
	public WebElement get_menuBuy() {
		return DriverManager.getDriver().findElement(link_MenuBuy);
	}

	/********************************************************************************************************************************/
	public WebElement get_LTE_Advanced() {
		return DriverManager.getDriver().findElement(link_LTE_Advanced);
	}

	/********************************************************************************************************************************/
	public WebElement get_XtremeHomePrepaidWiFi() {
		return DriverManager.getDriver().findElement(link_XtremeHomePrepaidWiFi);
	}

	/********************************************************************************************************************************/
	public WebElement get_downloadManual() {
		return DriverManager.getDriver().findElement(downloadManual);
	}

	/********************************************************************************************************************************/
	public WebElement get_buyNow() {
		return DriverManager.getDriver().findElement(buyNow);
	}

	/********************************************************************************************************************************/
	public WebElement get_OrderID() {
		return DriverManager.getDriver().findElement(orderID);
	}

	/********************************************************************************************************************************/
	public WebElement get_floatActualPrice() {
		return DriverManager.getDriver().findElement(floatActualPrice);
	}

	/********************************************************************************************************************************/
	public WebElement get_link_highlights() {
		return DriverManager.getDriver().findElement(link_highlights);
	}

	/********************************************************************************************************************************/
	public WebElement get_link_features() {
		return DriverManager.getDriver().findElement(link_features);
	}

	/********************************************************************************************************************************/
	public WebElement get_link_specifications() {
		return DriverManager.getDriver().findElement(link_specifications);
	}

	/********************************************************************************************************************************/
	public WebElement get_floatBuy() {
		return DriverManager.getDriver().findElement(floatingBuyNow);
	}

	/********************************************************************************************************************************/
	public WebElement get_link_compare() {
		return DriverManager.getDriver().findElement(link_compare);
	}

	/********************************************************************************************************************************/
	public WebElement get_link_BLACKPINKLimitedEdition() {
		return DriverManager.getDriver().findElement(link_BLACKPINKLimitedEdition);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_link_GlobeAtHomePrepaidWiFi() {
		return DriverManager.getDriver().findElement(link_GlobeAtHomePrepaidWiFi);
	}

	/********************************************************************************************************************************/

	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "privacyAccept":
			flag = waitForElementVisibility(privacyAccept, waitTime);
			break;
		case "downloadManual":
			flag = waitForElementVisibility(downloadManual, waitTime);
			break;
		case "buyNow":
			flag = waitForElementVisibility(buyNow, waitTime);
			break;
		case "menuBuy":
			flag = waitForElementVisibility(link_MenuBuy, waitTime);
			break;
		case "floatingBuyNow":
			flag = waitForElementVisibility(floatingBuyNow, waitTime);
			break;
		case "thankYouNote":
			flag = waitForElementVisibility(thankYouNote, waitTime);
			break;
		case "link_LogoGlobe":
			flag = waitForElementVisibility(link_LogoGlobe, waitTime);
			break;
		case "link_Apply":
			flag = waitForElementVisibility(link_Apply, waitTime);
			break;
		case "link_Renew":
			flag = waitForElementVisibility(link_Renew, waitTime);
			break;
		case "link_Switch":
			flag = waitForElementVisibility(link_Switch, waitTime);
			break;
		case "link_MenuBuy":
			flag = waitForElementVisibility(link_MenuBuy, waitTime);
			break;
		case "link_Help":
			flag = waitForElementVisibility(link_Help, waitTime);
			break;
		case "link_XtremeHomePrepaidWiFi":
			flag = waitForElementVisibility(link_XtremeHomePrepaidWiFi, waitTime);
			break;
		case "link_GlobeAtHomePrepaidWiFi":
			flag = waitForElementVisibility(link_GlobeAtHomePrepaidWiFi, waitTime);
			break;
		case "link_LTE_Advanced":
			flag = waitForElementVisibility(link_LTE_Advanced, waitTime);
			break;
		case "link_BLACKPINKLimitedEdition":
			flag = waitForElementVisibility(link_BLACKPINKLimitedEdition, waitTime);
			break;
		case "link_MyFiLTE":
			flag = waitForElementVisibility(link_MyFiLTE, waitTime);
			break;
		case "link_MyFiLTE_Advanced":
			flag = waitForElementVisibility(link_MyFiLTE_Advanced, waitTime);
			break;
		case "CartIcon":
			flag = waitForElementVisibility(CartIcon, waitTime);
			break;
		case "link_TrackMyOrder":
			flag = waitForElementVisibility(link_TrackMyOrder, waitTime);
			break;
		case "cookiesNotification":
			flag = waitForElementVisibility(cookiesNotification, waitTime);
			break;
		case "link_highlights":
			flag = waitForElementVisibility(link_highlights, waitTime);
			break;
		case "link_features":
			flag = waitForElementVisibility(link_features, waitTime);
			break;
		case "link_specifications":
			flag = waitForElementVisibility(link_specifications, waitTime);
			break;
		case "footer":
			flag = waitForElementVisibility(footer, waitTime);
			break;
		case "footerPrivacyPolicy":
			flag = waitForElementVisibility(footerPrivacyPolicy, waitTime);
			break;
		case "footerTermsOfUse":
			flag = waitForElementVisibility(footerTermsOfUse, waitTime);
			break;
		case "footerSiteMap":
			flag = waitForElementVisibility(footerSiteMap, waitTime);
			break;
		case "link_compare":
			flag = waitForElementVisibility(link_compare, waitTime);
			break;

		}

		if (flag) {
//			ExtentTestManager.logInfo(message + " - exists");
			System.out.println(message + " - exists");
		} else {
//			ExtentTestManager.logFail(message + " - do not exists");
			System.out.println(message + " - do not exist");
		}

		return flag;
	}

	/********************************************************************************************************************************/
	public boolean isClickable(String element, int waitTime) {

		boolean flag = false;

		switch (element) {
		case "link_LTE_Advanced":
			flag = waitForElementClickable(link_LTE_Advanced, waitTime);
			break;
		case "downloadManual":
			flag = waitForElementClickable(downloadManual, waitTime);
			break;
		case "buyNow":
			flag = waitForElementClickable(buyNow, waitTime);
			break;
		case "menuBuy":
			flag = waitForElementClickable(link_MenuBuy, waitTime);
			break;
		case "link_XtremeHomePrepaidWiFi":
			flag = waitForElementClickable(link_XtremeHomePrepaidWiFi, waitTime);
			break;
		case "link_highlights":
			flag = waitForElementClickable(link_highlights, waitTime);
			break;
		case "link_features":
			flag = waitForElementClickable(link_highlights, waitTime);
			break;
		case "link_specifications":
			flag = waitForElementClickable(link_specifications, waitTime);
			break;
		case "link_compare":
			flag = waitForElementClickable(link_compare, waitTime);
			break;
		case "link_BLACKPINKLimitedEdition":
			flag = waitForElementClickable(link_BLACKPINKLimitedEdition, waitTime);
			break;
		case "link_GlobeAtHomePrepaidWiFi":
			flag = waitForElementClickable(link_GlobeAtHomePrepaidWiFi, waitTime);
			break;

		}

		return flag;
	}

	/********************************************************************************************************************************/
	public void moveToElement(String element) {

		WebElement ele = null;

		switch (element) {
		case "menuBuy":
			ele = DriverManager.getDriver().findElement(link_MenuBuy);
			break;

		case "floatingBuyNow":
			ele = DriverManager.getDriver().findElement(floatingBuyNow);
			break;
		}

		try {
			Actions a = new Actions(DriverManager.getDriver());
			Thread.sleep(500L);
			a.moveToElement(ele).build().perform();
		} catch (Exception e) {

		}
	}

	/********************************************************************************************************************************/
	public String getURLOfNewTab() {

		String title = "";
		try {
			Set<String> winID = DriverManager.getDriver().getWindowHandles();
			Iterator<String> winItr = winID.iterator();
			String parentID = winItr.next();
			String childID = winItr.next();

			DriverManager.getDriver().switchTo().window(childID);
			title = DriverManager.getDriver().getCurrentUrl();
			DriverManager.getDriver().close();
			DriverManager.getDriver().switchTo().window(parentID);

		} catch (Exception e) {
			System.out.println("FAIL : to get the tab title. Message :" + e.getMessage());
		}
		return title;
	}

	/********************************************************************************************************************************/

	/********************************************************************************************************************************/
	public void write_OrderID_in_PropertiesFile(String key, String data) {
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties p = new Properties();

			File file = new File(".//OrderID.properties");
			fileIn = new FileInputStream(file);
			p.load(fileIn);
			p.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			p.store(fileOut, null);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			try {
				fileOut.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/********************************************************************************************************************************/
	public void clickOnElement(String type, String eleName, String ele) {

		try {
			switch (ele) {
			case "menuBuy":
				get_menuBuy().click();
				break;
			case "link_XtremeHomePrepaidWiFi":
				get_XtremeHomePrepaidWiFi().click();
				break;
			case "link_highlights":
				get_link_highlights().click();
				break;
			case "link_features":
				get_link_features().click();
				break;
			case "link_specifications":
				get_link_specifications().click();
				break;
			case "float_buy":
				get_floatBuy().click();
				break;
			case "link_compare":
				get_link_compare().click();
				break;
			case "link_BLACKPINKLimitedEdition":
				get_link_BLACKPINKLimitedEdition().click();
				break;
			case "link_GlobeAtHomePrepaidWiFi":
				get_link_GlobeAtHomePrepaidWiFi().click();
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
