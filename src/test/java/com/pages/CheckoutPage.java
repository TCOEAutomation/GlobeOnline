package com.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.browserstack.DriverManager;

public class CheckoutPage extends BasePage {

	By hdrCheckout = By.xpath("//h1[text()=' Checkout ']");
	By quantity = By.xpath("//div[@class='quantity'] //div[@class='number']");
	By cashoutAmount = By.xpath("//span[text()='Cashout']/../../div[2]/span");
	By shipping = By.xpath("//span[text()='Shipping']/../../div[2]/span");
	By totalAmount = By.xpath("//span[text()='Total']/../../div[2]/span");
	By productCategory = By.xpath("//div[@class='rightDetails'] //div[@class='cardtitleheading']");
	By productName = By.xpath("//div[@class='rightDetails'] //div[@class='sub-heading']");
	By productOverview = By.xpath("//div[@class='description']/span");
	By productPrice = By.xpath("//div[contains(@class,'price')]/span");
	By imgXPW = By.xpath("//img[@alt='Xtreme Home Prepaid WiFi']");
	By imgGHPW = By.xpath("//img[@alt='Globe At Home Prepaid WiFi']");
	By imgBlackPink = By.xpath("//img[@alt='Blackpink LTE Advanced with TP Link']");
	By txtNextDayDelivery = By.xpath("//div[@class='need-your-item-now']/span");
	By txt_gCashChckout = By.xpath("//div[@class='gcash-checkout']/p");

	By mobileNumber = By.xpath("//input[@formcontrolname='mobile']");
	By standardCheckout = By.xpath("//button[@id='standardCheckout']");
	By btnGcashCheckout = By.xpath("//button[@id='gcashCheckout']");
	By otpText = By.xpath("//div[contains(text(),' We sent the code to')]");
	By otp = By.xpath("//input[contains(@id,'otpInput')]");

	By link_gCashDefinition = By.xpath("//span[text()=' What is GCash?']");
	By gCashDefinition = By.xpath("//div[contains(@class,'row GCashText')] //p");
	By addQuantity = By.xpath("//img[@alt='Add quantity']");
	By removeQuantity = By.xpath("//img[@alt='Remove quantity']");
	By closeButton = By.xpath("//div[@class='close-icon']");
	By btn_confirm_removeProduct = By.xpath("//div[contains(@class,'yes-button')]/button");

	By btnTryAgain = By.xpath("//button[text()=' Try Again ']");
	By btn_resendOPT = By.xpath("//button[text()=' Resend code. ']");
	By confirmationResendOTP = By.xpath("//div[text()=' We resent your OTP! ']");
	By btnPromoCode = By.xpath("//button[@id='promoClick']");
	By txtbx_promoCode = By.xpath("//input[@formcontrolname='coupon']");
	By btn_applyPromo = By.xpath("//button[@id='applyPromoClick']");
	By promoSuccessMsg = By.xpath("//div[contains(@class,'promocode-success-message')]");
	By promoFailMsg = By.xpath("//div[contains(@class,'promocode-fail-message')]/div/span");

	/********************************************************************************************************************************/
	public WebElement get_mobileNumber() {
		return DriverManager.getDriver().findElement(mobileNumber);
	}

	/********************************************************************************************************************************/
	public WebElement get_standardCheckout() {
		return DriverManager.getDriver().findElement(standardCheckout);
	}

	/********************************************************************************************************************************/
	public WebElement get_gcashCheckout() {
		return DriverManager.getDriver().findElement(btnGcashCheckout);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_OTP() {
		return DriverManager.getDriver().findElements(otp);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_quantities() {
		return DriverManager.getDriver().findElements(quantity);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_productsName() {
		return DriverManager.getDriver().findElements(productName);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_productsCategory() {
		return DriverManager.getDriver().findElements(productCategory);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_productsOverview() {
		return DriverManager.getDriver().findElements(productOverview);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_productsPrice() {
		return DriverManager.getDriver().findElements(productPrice);
	}

	/********************************************************************************************************************************/
	public WebElement get_linkGCashDefinition() {
		return DriverManager.getDriver().findElement(link_gCashDefinition);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnAddQuantity() {
		return DriverManager.getDriver().findElement(addQuantity);
	}
	
	/********************************************************************************************************************************/
	public List<WebElement> get_buttonsAddQuantity() {
		return DriverManager.getDriver().findElements(addQuantity);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnRemoveQuantity() {
		return DriverManager.getDriver().findElement(removeQuantity);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnClose() {
		return DriverManager.getDriver().findElement(closeButton);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnConfirmRemoveProduct() {
		return DriverManager.getDriver().findElement(btn_confirm_removeProduct);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnTryAgain() {
		return DriverManager.getDriver().findElement(btnTryAgain);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnResendOTP() {
		return DriverManager.getDriver().findElement(btn_resendOPT);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnPromoCode() {
		return DriverManager.getDriver().findElement(btnPromoCode);
	}

	/********************************************************************************************************************************/
	public WebElement get_txtbx_promoCode() {
		return DriverManager.getDriver().findElement(txtbx_promoCode);
	}

	/********************************************************************************************************************************/
	public WebElement get_btn_applyPromo() {
		return DriverManager.getDriver().findElement(btn_applyPromo);
	}

	/********************************************************************************************************************************/

	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "header_checkout":
			flag = waitForElementVisibility(hdrCheckout, waitTime);
			break;
		case "imgXPW":
			flag = waitForElementVisibility(imgXPW, waitTime);
			break;
		case "imgGHPW":
			flag = waitForElementVisibility(imgGHPW, waitTime);
			break;
		case "imgBlackPink":
			flag = waitForElementVisibility(imgBlackPink, waitTime);
			break;
		case "gcashCheckout":
			flag = waitForElementVisibility(btnGcashCheckout, waitTime);
			break;
		case "otpText":
			flag = waitForElementVisibility(otpText, waitTime);
			break;
		case "hdrCheckout":
			flag = waitForElementVisibility(hdrCheckout, waitTime);
			break;
		case "btnStandardCheckout":
			flag = waitForElementVisibility(standardCheckout, waitTime);
			break;
		case "btnTryAgain":
			flag = waitForElementVisibility(btnTryAgain, waitTime);
			break;
		case "confirmationResendOTP":
			flag = waitForElementVisibility(confirmationResendOTP, waitTime);
			break;
		case "promoSuccessMsg":
			flag = waitForElementVisibility(promoSuccessMsg, waitTime);
			break;
		case "promoFailMsg":
			flag = waitForElementVisibility(promoFailMsg, waitTime);
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
	public String getText(String ele) {
		String text = "";

		try {
			switch (ele) {
			case "quantity":
				text = DriverManager.getDriver().findElement(quantity).getText();
				break;
			case "cashoutAmount":
				text = DriverManager.getDriver().findElement(cashoutAmount).getText();
				break;
			case "shipping":
				text = DriverManager.getDriver().findElement(shipping).getText();
				break;
			case "totalAmount":
				text = DriverManager.getDriver().findElement(totalAmount).getText();
				break;
			case "productCategory":
				text = DriverManager.getDriver().findElement(productCategory).getText();
				break;
			case "productName":
				text = DriverManager.getDriver().findElement(productName).getText();
				break;
			case "productOverview":
				text = DriverManager.getDriver().findElement(productOverview).getText();
				break;
			case "productPrice":
				text = DriverManager.getDriver().findElement(productPrice).getText();
				break;
			case "txtNextDayDelivery":
				text = DriverManager.getDriver().findElement(txtNextDayDelivery).getText();
				break;
			case "txt_gCashChckout":
				text = DriverManager.getDriver().findElement(txt_gCashChckout).getText();
				break;
			case "gCashDefinition":
				text = DriverManager.getDriver().findElement(gCashDefinition).getText();
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
	public boolean isClickable(String element, int waitTime) {

		boolean flag = false;

		switch (element) {
		case "StanCheckout":
			flag = waitForElementClickable(standardCheckout, waitTime);
			break;
		case "gCashDefinitionLink":
			flag = waitForElementClickable(link_gCashDefinition, waitTime);
			break;
		case "addQuantity":
			flag = waitForElementClickable(addQuantity, waitTime);
			break;
		case "removeQuantity":
			flag = waitForElementClickable(removeQuantity, waitTime);
			break;
		case "closeButton":
			flag = waitForElementClickable(closeButton, waitTime);
			break;
		case "confirm_removeProduct":
			flag = waitForElementClickable(btn_confirm_removeProduct, waitTime);
			break;
		case "btnPromoCode":
			flag = waitForElementClickable(btnPromoCode, waitTime);
			break;
		case "btnGcashCheckout":
			flag = waitForElementClickable(btnGcashCheckout, waitTime);
			break;

			
			
		}
		return flag;
	}

	/********************************************************************************************************************************/
	public void moveToElement(String element) {

		WebElement ele = null;

		switch (element) {
		case "btnPromoCode":
			ele = DriverManager.getDriver().findElement(btnPromoCode);
			break;
		}

		try {
			Actions a = new Actions(DriverManager.getDriver());
			Thread.sleep(500L);
			a.moveToElement(ele).build().perform();
		} catch (Exception e) {

		}
	}
}
