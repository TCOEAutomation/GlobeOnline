package com.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import com.browserstack.DriverManager;

public class SurveyPage extends BasePage {

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
	
	By SurveyTitle = By.xpath("//*[contains(text(), 'How did you like your shopping experience?')]");
	By SurveySpiel = By.xpath("(//p[text()='Tell us how you feel'])[1]");
	By SurveyClosebtn = By.xpath("//span[@class='close-button']");
	By SurveyEmotion1 = By.xpath("(//li[@class='one-rating-icon rating-icon'])[1]");
	By SurveyEmotion2 = By.xpath("(//li[@class='rating-icon two-rating-icon'])[1]");
	By SurveyEmotion3 = By.xpath("(//li[@class='rating-icon three-rating-icon'])[1]");
	By SurveyEmotion4 = By.xpath("(//li[@class='four-rating-icon rating-icon'])[1]");
	By SurveyEmotion5 = By.xpath("(//li[@class='five-rating-icon rating-icon'])[1]");
	By SurveyField = By.xpath("(//div[@class='form-field'])[1]");
	By SurveyFieldSpiel = By.xpath("(//span[text()='Tell us what went wrong'])[1]");
	By SurveySubmit = By.xpath("//span[text()='Submit']");
	By IISurveyTitle = By.xpath("//*[contains(text(), 'Based on your online purchases, how likely are you to recommend Globe to others?')]");
	By IISurveySpiel = By.xpath("(//p[text()='Tell us how you feel'])[2]");
	By IISurveyEmotion1 = By.xpath("(//li[@class='one-rating-icon rating-icon'])[2]");
	By IISurveyEmotion2 = By.xpath("(//li[@class='rating-icon two-rating-icon'])[2]");
	By IISurveyEmotion3 = By.xpath("(//li[@class='rating-icon three-rating-icon'])[2]");
	By IISurveyEmotion4 = By.xpath("(//li[@class='four-rating-icon rating-icon'])[2]");
	By IISurveyEmotion5 = By.xpath("(//li[@class='five-rating-icon rating-icon'])[2]");
	By IISurveyField = By.xpath("(//div[@class='form-field'])[2]");
	By IISurveyFieldSpiel = By.xpath("(//span[text()='Tell us what went wrong'])[2]");
	By SuccessSurveyImg = By.xpath("(//div[@class='success-image'])[1]");
	By SuccessSurveyClose = By.xpath("(//*[@class='close-button'])[1]");
	By SuccessSurveySpiel1 = By.xpath("//*[contains(text(), 'Awww that's nice.')]");
	By SuccessSurveySpiel2 = By.xpath("//*[contains(text(), 'Don’t keep it to yourself. Share the love! Send the link to your friends and let them know.')]");
	
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
	public WebElement get_XButton() {
		return DriverManager.getDriver().findElement(SurveyClosebtn);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q1Emoji1() {
		return DriverManager.getDriver().findElement(SurveyEmotion1);
	}

	/********************************************************************************************************************************/
	public WebElement get_Q1Emoji2() {
		return DriverManager.getDriver().findElement(SurveyEmotion2);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q1Emoji3() {
		return DriverManager.getDriver().findElement(SurveyEmotion3);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q1Emoji4() {
		return DriverManager.getDriver().findElement(SurveyEmotion4);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q1Emoji5() {
		return DriverManager.getDriver().findElement(SurveyEmotion5);
	}
	/********************************************************************************************************************************/
	public WebElement get_SurveySubmitBtn() {
		return DriverManager.getDriver().findElement(SurveySubmit);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q2Emoji1() {
		return DriverManager.getDriver().findElement(IISurveyEmotion1);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q2Emoji2() {
		return DriverManager.getDriver().findElement(IISurveyEmotion2);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q2Emoji3() {
		return DriverManager.getDriver().findElement(IISurveyEmotion3);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q2Emoji4() {
		return DriverManager.getDriver().findElement(IISurveyEmotion4);
	}
	/********************************************************************************************************************************/
	public WebElement get_Q2Emoji5() {
		return DriverManager.getDriver().findElement(IISurveyEmotion5);
	}
	/********************************************************************************************************************************/
	public WebElement get_SuccessSurveyClose() {
		return DriverManager.getDriver().findElement(SuccessSurveyClose);
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
		case "SurveyTitle":
			flag = waitForElementVisibility(SurveyTitle, waitTime);
			break;
		case "SurveySpiel":
			flag = waitForElementVisibility(SurveySpiel, waitTime);
			break;
		case "SurveyClosebtn":
			flag = waitForElementVisibility(SurveyClosebtn, waitTime);
			break;
		case "SurveyEmotion1":
			flag = waitForElementVisibility(SurveyEmotion1, waitTime);
			break;
		case "SurveyEmotion2":
			flag = waitForElementVisibility(SurveyEmotion2, waitTime);
			break;
		case "SurveyEmotion3":
			flag = waitForElementVisibility(SurveyEmotion3, waitTime);
			break;
		case "SurveyEmotion4":
			flag = waitForElementVisibility(SurveyEmotion4, waitTime);
			break;
		case "SurveyEmotion5":
			flag = waitForElementVisibility(SurveyEmotion5, waitTime);
			break;
		case "SurveyField":
			flag = waitForElementVisibility(SurveyField, waitTime);
			break;
		case "SurveyFieldSpiel":
			flag = waitForElementVisibility(SurveyFieldSpiel, waitTime);
			break;
		case "SurveySubmit":
			flag = waitForElementVisibility(SurveySubmit, waitTime);
			break;
		case "IISurveyTitle":
			flag = waitForElementVisibility(IISurveyTitle, waitTime);
			break;
		case "IISurveySpiel":
			flag = waitForElementVisibility(IISurveySpiel, waitTime);
			break;
		case "IISurveyEmotion1":
			flag = waitForElementVisibility(IISurveyEmotion1, waitTime);
			break;
		case "IISurveyEmotion2":
			flag = waitForElementVisibility(IISurveyEmotion2, waitTime);
			break;
		case "IISurveyEmotion3":
			flag = waitForElementVisibility(IISurveyEmotion3, waitTime);
			break;
		case "IISurveyEmotion4":
			flag = waitForElementVisibility(IISurveyEmotion4, waitTime);
			break;
		case "IISurveyEmotion5":
			flag = waitForElementVisibility(IISurveyEmotion5, waitTime);
			break;
		case "IISurveyField":
			flag = waitForElementVisibility(IISurveyField, waitTime);
			break;
		case "IISurveyFieldSpiel":
			flag = waitForElementVisibility(IISurveyFieldSpiel, waitTime);
			break;
		case "SuccessSurveyImg":
			flag = waitForElementVisibility(SuccessSurveyImg, waitTime);
			break;
		case "SuccessSurveyClose":
			flag = waitForElementVisibility(SuccessSurveyClose, waitTime);
			break;
		case "SuccessSurveySpiel1":
			flag = waitForElementVisibility(SuccessSurveySpiel1, waitTime);
			break;
		case "SuccessSurveySpiel2":
			flag = waitForElementVisibility(SuccessSurveySpiel2, waitTime);
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
			case "SurveyClosebtn":
				get_XButton().click();
				break;
			case "SurveyEmotion1":
				get_Q1Emoji1().click();
				break;
			case "SurveyEmotion2":
				get_Q1Emoji2().click();
				break;
			case "SurveyEmotion3":
				get_Q1Emoji3().click();
				break;
			case "SurveyEmotion4":
				get_Q1Emoji4().click();
				break;
			case "SurveyEmotion5":
				get_Q1Emoji5().click();
				break;
			case "SurveySubmit":
				get_SurveySubmitBtn().click();
				break;
			case "IISurveyEmotion1":
				get_Q2Emoji1().click();
				break;
			case "IISurveyEmotion2":
				get_Q2Emoji2().click();
				break;
			case "IISurveyEmotion3":
				get_Q2Emoji3().click();
				break;
			case "IISurveyEmotion4":
				get_Q2Emoji4().click();
				break;
			case "IISurveyEmotion5":
				get_Q2Emoji5().click();
				break;
			case "SuccessSurveyClose":
				get_SuccessSurveyClose().click();
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
