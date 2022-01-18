package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.browserstack.DriverManager;

public class ThankYouPage extends BasePage {

	By surveyForm = By.xpath("//div[@id='feedback-block'] //div[@class='modal-box']");
	By txtSurveyShoppingExperience = By.xpath("//h2[contains(text(),'shopping experience?')]");
	By surveyText1 = By.xpath("//h2[contains(text(),'shopping experience?')]/../p");
	By txtSurveyRecommend = By.xpath("//h2[contains(text(),'are you to recommend Globe to others?')]");
	By surveyText2 = By.xpath("//h2[contains(text(),'are you to recommend Globe to others?')]/../p");
	By Emoji_ShoppingExp = By.xpath(
			"//h2[contains(text(),'shopping experience?')]/.. //ul[@class='rating'] //li[contains(@id,'rating-icon')]");
	By Emoji_Recommendation = By.xpath(
			"//h2[contains(text(),'are you to recommend Globe to others?')]/.. //ul[@class='rating'] //li[contains(@id,'rating-icon')]");
	By feedbackTextAread1 = By.xpath("//textarea[@id='feedback-block-feedback-1']");
	By feedbackTextAread2 = By.xpath("//textarea[@id='feedback-block-feedback-2']");
	By submitSurvey = By.xpath("//span[@id='rater-button']");
	By imgFeedbackSuccess = By.xpath("//div[@class='success-image']");
	By txtFeedbackSuccess_1 = By.xpath("//div[@class='success-image']/../h1");
	By txtFeedbackSuccess_2 = By.xpath("//div[@class='success-image']/../p");
	By btnClose = By.xpath("//span[@class='close-button']");

//	By copyOrderID = By.xpath("//div[@id='copyOrderNumber']/img");
	By copyOrderID = By.xpath("//div[@id='copyOrderNumber']/img | //div[@class='reference-img']");

	By linkTrackOrder = By.xpath("//a[text()=' Track my order ']");
	By printIcon = By.xpath("//div[@class='print-icon']");
	By copyRefrerenceNoSuccessMsg = By.xpath("//div[text()='Reference number copied to clipboard!']");
	By summaryShippingAddress = By.xpath("//div[@class='shipping-address']/../div[2]/span");
	By summaryAmtToPay = By.xpath("//span[text()='Amount to pay']/../following-sibling::div/span");
	By summaryProductCount = By.xpath("//div[@class='leftCard']");
	By summaryProductImage = By.xpath("//img[@class='globeImage1']");
	By summaryProductName = By.xpath("//div[@class='cardtitleheading']/following-sibling::div");
	By summaryDescription = By.xpath("//div[@class='description']");
	By summaryQuantity = By.xpath("//div[contains(@class,'unit-section')]/div/span");
	By summaryReminder1 = By.xpath("//div[contains(@class,'reminder-content')]/div/span");
	By summaryReminder2 = By.xpath("//div[contains(@class,'reminder-content')]/div[2]/p");
	By tryDifferentPayment = By.xpath("//button[@id='tryDifferentPayment']");
	By msgPurchaseDeclined = By.xpath("//span[text()='Sorry, your purchase was declined. ']");

	/********************************************************************************************************************************/
	public WebElement get_txt_shoppingExperience() {
		return DriverManager.getDriver().findElement(txtSurveyShoppingExperience);
	}

	/********************************************************************************************************************************/
	public WebElement get_txt_recommendGlobe() {
		return DriverManager.getDriver().findElement(txtSurveyRecommend);
	}

	/********************************************************************************************************************************/
	public WebElement get_txt_shopExperience_feedback_() {
		return DriverManager.getDriver().findElement(surveyText1);
	}

	/********************************************************************************************************************************/
	public WebElement get_txt_recommend_feedback() {
		return DriverManager.getDriver().findElement(surveyText2);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_shopExpEmoji() {
		return DriverManager.getDriver().findElements(Emoji_ShoppingExp);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_recomGlobeEmoji() {
		return DriverManager.getDriver().findElements(Emoji_Recommendation);
	}

	/********************************************************************************************************************************/
	public WebElement get_shopExpFeedbackTextArea() {
		return DriverManager.getDriver().findElement(feedbackTextAread1);
	}

	/********************************************************************************************************************************/
	public WebElement get_RecomGlobeTextArea() {
		return DriverManager.getDriver().findElement(feedbackTextAread2);
	}

	/********************************************************************************************************************************/
	public WebElement get_submitSurver() {
		return DriverManager.getDriver().findElement(submitSurvey);
	}

	/********************************************************************************************************************************/
	public WebElement get_txt_thatsNice() {
		return DriverManager.getDriver().findElement(txtFeedbackSuccess_1);
	}

	/********************************************************************************************************************************/
	public WebElement get_txt_shareOthers() {
		return DriverManager.getDriver().findElement(txtFeedbackSuccess_2);
	}

	/********************************************************************************************************************************/
	public WebElement get_closeButton() {
		return DriverManager.getDriver().findElement(btnClose);
	}

	/********************************************************************************************************************************/
	public WebElement get_copyOrderID() {
		return DriverManager.getDriver().findElement(copyOrderID);
	}

	/********************************************************************************************************************************/
	public WebElement get_linkTrackOrder() {
		return DriverManager.getDriver().findElement(linkTrackOrder);
	}

	/********************************************************************************************************************************/
	public WebElement get_printIcon() {
		return DriverManager.getDriver().findElement(printIcon);
	}

	/********************************************************************************************************************************/
	public WebElement get_summaryShippingAddress() {
		return DriverManager.getDriver().findElement(summaryShippingAddress);
	}

	/********************************************************************************************************************************/
	public WebElement get_summaryAmtToPay() {
		return DriverManager.getDriver().findElement(summaryAmtToPay);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_summaryProductCount() {
		return DriverManager.getDriver().findElements(summaryProductCount);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_summaryProductImage() {
		return DriverManager.getDriver().findElements(summaryProductImage);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_summaryProductName() {
		return DriverManager.getDriver().findElements(summaryProductName);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_summaryDescription() {
		return DriverManager.getDriver().findElements(summaryDescription);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_summaryQuantity() {
		return DriverManager.getDriver().findElements(summaryQuantity);
	}

	/********************************************************************************************************************************/
	public WebElement get_summaryReminder1() {
		return DriverManager.getDriver().findElement(summaryReminder1);
	}

	/********************************************************************************************************************************/
	public WebElement get_summaryReminder2() {
		return DriverManager.getDriver().findElement(summaryReminder2);
	}

	/********************************************************************************************************************************/
	public WebElement get_tryDifferentPayment() {
		return DriverManager.getDriver().findElement(tryDifferentPayment);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_msgPurchaseDeclined() {
		return DriverManager.getDriver().findElement(msgPurchaseDeclined);
	}

	/********************************************************************************************************************************/
	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "closeButton":
			flag = waitForElementVisibility(btnClose, waitTime);
			break;
		case "surveyForm":
			flag = waitForElementVisibility(surveyForm, waitTime);
			break;
		case "imgSurveySuccess":
			flag = waitForElementVisibility(imgFeedbackSuccess, waitTime);
			break;
		case "printIcon":
			flag = waitForElementVisibility(printIcon, waitTime);
			break;
		case "copyRefrerenceNoSuccessMsg":
			flag = waitForElementVisibility(copyRefrerenceNoSuccessMsg, waitTime);
			break;
		case "tryDifferentPayment":
			flag = waitForElementVisibility(tryDifferentPayment, waitTime);
			break;
		case "msgPurchaseDeclined":
			flag = waitForElementVisibility(msgPurchaseDeclined, waitTime);
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
		case "tryDifferentPayment":
			flag = waitForElementClickable(tryDifferentPayment, waitTime);
			break;

		}

		return flag;
	}

}
