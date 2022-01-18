package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.browserstack.DriverManager;

public class PayPage extends BasePage {

	By hdrPay = By.xpath("//h1[text()=' Pay ']");
	By cod = By.xpath("//div[text()=' Cash On Delivery ']");
	By payOptionGCash = By.xpath("//h2[contains(@class,'payoption')] //div[text()=' GCash ']");
	By payOption_Visa_MasterCard = By.xpath("//h2[contains(@class,'payoption')] //div[text()=' Visa / MasterCard ']");
	By payOption_overTheCounter = By.xpath("//h2[contains(@class,'payoption')] //div[text()=' Over the Counter ']");
	By payOrder = By.xpath("//button[@id='payOrder']");

	By quantity = By.xpath("//div[contains(@class,'onex')]/span");
	By productName = By.xpath("//div[contains(@class,'cashout')]/span");
	By price = By.xpath("//div[contains(@class,'amount-1')]/span");
	By shipping = By.xpath("//span[contains(@class,'float-end')]");
	By totalAmount = By.xpath("//div[contains(@class,'ampount-2')]/span");

	By shipAddress = By.xpath("//div[contains(@class,'ship-address')]/span");

	By notification_OTC = By.xpath("//div[text()='Paying Over the Counter']");
	By notification_OTC_text = By
			.xpath("//div[text()='Paying Over the Counter']/../../following-sibling::div/div/span");
	By nearestECPay = By.xpath("//a[text()='Find the nearest ECPay near me']");
	By promoCode = By.xpath("//div[contains(@class,'promo-code-part-content')]");
	By changeAddress = By.xpath("//div[@id='changeAddress']/span");
	
	By textCreditCard = By.xpath("//span[text()='Credit Card']");	
	By cardNumberFrame = By.xpath("//span[@data-encrypted-field='encryptedCardNumber']/iframe");
	By cardNumber = By.xpath("//input[@aria-label='Credit or debit card number']");
	
	By cardExpiryDateFrame = By.xpath("//span[@data-encrypted-field='encryptedExpiryDate']/iframe");
	By cardExpiryDate = By.xpath("//input[@id='encryptedExpiryDate']");
	
	By cvvFrame = By.xpath("//span[@data-encrypted-field='encryptedSecurityCode']/iframe");
	By cvv = By.xpath("//input[@id='encryptedSecurityCode']");
	
	By btnPay_CC = By.xpath("//button[contains(@class,'js-chckt-button--submit')]");
	
	

	/********************************************************************************************************************************/
	public WebElement get_cod() {
		return DriverManager.getDriver().findElement(cod);
	}

	/********************************************************************************************************************************/
	public WebElement get_payOpt_Gcash() {
		return DriverManager.getDriver().findElement(payOptionGCash);
	}

	/********************************************************************************************************************************/
	public WebElement get_payOpt_VisaMasterCard() {
		return DriverManager.getDriver().findElement(payOption_Visa_MasterCard);
	}

	/********************************************************************************************************************************/
	public WebElement get_payOpt_overTheCounter() {
		return DriverManager.getDriver().findElement(payOption_overTheCounter);
	}

	/********************************************************************************************************************************/
	public WebElement get_notification_OTC() {
		return DriverManager.getDriver().findElement(notification_OTC);
	}

	/********************************************************************************************************************************/
	public WebElement get_notification_OTC_text() {
		return DriverManager.getDriver().findElement(notification_OTC_text);
	}

	/********************************************************************************************************************************/
	public WebElement get_nearestECPay() {
		return DriverManager.getDriver().findElement(nearestECPay);
	}

	/********************************************************************************************************************************/
	public WebElement get_payOrder() {
		return DriverManager.getDriver().findElement(payOrder);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_quantity() {
		return DriverManager.getDriver().findElements(quantity);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_productName() {
		return DriverManager.getDriver().findElements(productName);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_price() {
		return DriverManager.getDriver().findElements(price);
	}

	/********************************************************************************************************************************/
	public WebElement get_shipping() {
		return DriverManager.getDriver().findElement(shipping);
	}

	/********************************************************************************************************************************/
	public WebElement get_totalAmount() {
		return DriverManager.getDriver().findElement(totalAmount);
	}

	/********************************************************************************************************************************/
	public WebElement get_shipAddress() {
		return DriverManager.getDriver().findElement(shipAddress);
	}

	/********************************************************************************************************************************/
	public WebElement get_promoCode() {
		return DriverManager.getDriver().findElement(promoCode);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_changeAddress() {
		return DriverManager.getDriver().findElement(changeAddress);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_cardNumberFrame() {
		return DriverManager.getDriver().findElement(cardNumberFrame);
	}
	/********************************************************************************************************************************/
	public WebElement get_cardNumber() {
		return DriverManager.getDriver().findElement(cardNumber);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_cardExpiryDateFrame() {
		return DriverManager.getDriver().findElement(cardExpiryDateFrame);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_cardExpiryDate() {
		return DriverManager.getDriver().findElement(cardExpiryDate);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_cvvFrame() {
		return DriverManager.getDriver().findElement(cvvFrame);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_cvv() {
		return DriverManager.getDriver().findElement(cvv);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_btnPay_CC() {
		return DriverManager.getDriver().findElement(btnPay_CC);
	}

	/********************************************************************************************************************************/
	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "hdrPay":
			flag = waitForElementVisibility(hdrPay, waitTime);
			break;
		case "payOpt_VisaMaster":
			flag = waitForElementVisibility(payOption_Visa_MasterCard, waitTime);
			break;
		case "payOpt_GCash":
			flag = waitForElementVisibility(payOptionGCash, waitTime);
			break;
		case "payOpt_overTheCounter":
			flag = waitForElementVisibility(payOption_overTheCounter, waitTime);
			break;
		case "payOpt_COD":
			flag = waitForElementVisibility(cod, waitTime);
			break;
		case "notification_OTC":
			flag = waitForElementVisibility(notification_OTC, waitTime);
			break;
		case "creditCardPage":
			flag = waitForElementVisibility(textCreditCard, waitTime);
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
	public boolean isClickable(String element, int waitTime) {

		boolean flag = false;

		switch (element) {
		case "payOrder":
			flag = waitForElementClickable(payOrder, waitTime);
			break;
		case "nearestECPay":
			flag = waitForElementClickable(nearestECPay, waitTime);
			break;
			
		case "btnPay_CC":
			flag = waitForElementClickable(btnPay_CC, waitTime);
			break;

		}

		return flag;
	}
}
