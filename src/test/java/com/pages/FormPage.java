package com.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;

import com.browserstack.DriverManager;

public class FormPage extends BasePage {

	By hdrForm = By.xpath("//h1[text()=' Form ']");
	By firstName = By.xpath("//input[@formcontrolname='firstName']");
	By middleName = By.xpath("//input[@formcontrolname='middleName']");
	By lastName = By.xpath("//input[@formcontrolname='lastName']");
	By email = By.xpath("//input[@formcontrolname='email']");
	By mobileNumber = By.xpath("//input[@formcontrolname='mobile']");
	By rBtn_condominium = By.xpath("//label[text()='Condominium']");
	By rBtn_house = By.xpath("//label[text()='House']");
	By SignalStrengthWarning = By.xpath("//div[contains(@class,'address-sub-section-flex-content')]/span");
	By houseNo = By.xpath("//input[@formcontrolname='HouseNo']");
	By street = By.xpath("//input[@formcontrolname='street']");
	By village_subDivision = By.xpath("//input[@formcontrolname='subDivision']");
	By subDivision = By.xpath("//input[@formcontrolname='subDivision']");
	By floor = By.xpath("//input[@formcontrolname='FloorNo']");
	By buildingName = By.xpath("//input[@formcontrolname='buildingName']");
	By drpdwnProvince = By.xpath("//select[@formcontrolname='province']");
	By drpdwnCity = By.xpath("//select[@formcontrolname='city']");
	By drpdwnBarangay = By.xpath("//select[@formcontrolname='barangay']");
	By chkbx_acceptAll = By.xpath("//input[@formcontrolname='all']");
	By btnPay = By.xpath("//button[contains(@class,'btn-primary-custom pay-button')][1]");
	By topSectionImgXPW = By.xpath("//div[@class='top-section'] //img[@alt='Xtreme Home Prepaid WiFi']");
	By topSectionImgGHPW = By.xpath("//div[@class='top-section'] //img[@alt='Globe At Home Prepaid WiFi']");
	By topSectionImgBlackPink = By.xpath("//div[@class='top-section'] //img[@alt='Blackpink LTE Advanced with TP Link']");

	By topSectionProductName = By.xpath("//div[@class='top-section'] //div[@class='prepaid-text']/span");
	By topSectionPrice = By.xpath("//div[@class='top-section'] //div[@class='prepaid-cost']/span");
	By btnReviewBag = By.xpath("//button[text()=' Review my bag ']");
	By formPersonalInfo = By.xpath("//span[text()='Personal information']");

	By imgGiftOption = By.xpath("//div[@formgroupname='giftOption'] //img");
	By toggleGiftOption = By.xpath("//div[@formgroupname='giftOption'] //span[@class='slider round']");
	By recipientName = By.xpath("//input[@formcontrolname='recipientName']");
	By recipientMobile = By.xpath("//input[@formcontrolname='recipientMobile']");
	By errRecipientMobile = By.xpath("//input[@formcontrolname='recipientMobile'] /../following-sibling::div/span");
	By zipCode = By.xpath("//input[@formcontrolname='zipCode']");
	By imgSameDayDelivery = By.xpath("//input[@formcontrolname='isSameDay']/../../img");
	By txtdeliveryCaveat_1 = By.xpath("//div[contains(@class,'delivery-msg-block')]/div[1]");
	By txtdeliveryCaveat_2 = By.xpath("//div[contains(@class,'delivery-msg-block')]/div[2]/p");
	By chkbxTermsConditions = By.xpath("//div[@class='terms-and-condition-wrapper'] // input[@type='checkbox']");
	By get_chkbxLabelTermsConditions = By.xpath(
			"//div[@class='terms-and-condition-wrapper'] // input[@type='checkbox']/../../following-sibling::div //span[1]");
By label_accept_all_terms = By.xpath("//label[text()=' I accept all Terms and Conditions. ']");
	
	
	By specialInstruction = By.xpath("//input[@formcontrolname='instruction']");

	/********************************************************************************************************************************/
	public WebElement get_firstName() {
		return DriverManager.getDriver().findElement(firstName);
	}

	/********************************************************************************************************************************/
	public WebElement get_middleName() {
		return DriverManager.getDriver().findElement(middleName);
	}

	/********************************************************************************************************************************/
	public WebElement get_lastName() {
		return DriverManager.getDriver().findElement(lastName);
	}

	/********************************************************************************************************************************/
	public WebElement get_email() {
		return DriverManager.getDriver().findElement(email);
	}

	/********************************************************************************************************************************/
	public WebElement get_condominium() {
		return DriverManager.getDriver().findElement(rBtn_condominium);
	}

	/********************************************************************************************************************************/
	public WebElement get_house() {
		return DriverManager.getDriver().findElement(houseNo);
	}

	/********************************************************************************************************************************/
	public WebElement get_street() {
		return DriverManager.getDriver().findElement(street);
	}

	/********************************************************************************************************************************/
	public WebElement get_village_subDivision() {
		return DriverManager.getDriver().findElement(village_subDivision);
	}

	/********************************************************************************************************************************/
	public WebElement get_floor() {
		return DriverManager.getDriver().findElement(floor);
	}

	/********************************************************************************************************************************/
	public WebElement get_buildingName() {
		return DriverManager.getDriver().findElement(buildingName);
	}

	/********************************************************************************************************************************/
	public WebElement get_subDivision() {
		return DriverManager.getDriver().findElement(subDivision);
	}

	/********************************************************************************************************************************/
	public void select_province(String option) {
		Select s = new Select(DriverManager.getDriver().findElement(drpdwnProvince));
		s.selectByValue(option);
	}

	/********************************************************************************************************************************/
	public void select_city(String option) {
		Select s = new Select(DriverManager.getDriver().findElement(drpdwnCity));
		s.selectByValue(option);
	}

	/********************************************************************************************************************************/
	public void select_barangay(String option) {
		Select s = new Select(DriverManager.getDriver().findElement(drpdwnBarangay));
		s.selectByValue(option);
	}

	/********************************************************************************************************************************/
	public WebElement get_checkbox_acceptAll() {
		return DriverManager.getDriver().findElement(chkbx_acceptAll);
	}

	/********************************************************************************************************************************/
	public WebElement get_btnPay() {
		return DriverManager.getDriver().findElement(btnPay);
	}

	/********************************************************************************************************************************/
	public WebElement get_reviewBag() {
		return DriverManager.getDriver().findElement(btnReviewBag);
	}

	/********************************************************************************************************************************/
	public WebElement get_toggleGiftOption() {
		return DriverManager.getDriver().findElement(toggleGiftOption);
	}

	/********************************************************************************************************************************/
	public WebElement get_recipientName() {
		return DriverManager.getDriver().findElement(recipientName);
	}

	/********************************************************************************************************************************/
	public WebElement get_recipientMobile() {
		return DriverManager.getDriver().findElement(recipientMobile);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_SignalStrengthWarning() {
		return DriverManager.getDriver().findElements(SignalStrengthWarning);
	}

	/********************************************************************************************************************************/
	public WebElement get_ImgGiftOption() {
		return DriverManager.getDriver().findElement(imgGiftOption);
	}

	/********************************************************************************************************************************/
	public WebElement get_zipCode() {
		return DriverManager.getDriver().findElement(zipCode);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_chkbxTermsConditions() {
		return DriverManager.getDriver().findElements(chkbxTermsConditions);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_chkbxLabelTermsConditions() {
		return DriverManager.getDriver().findElements(get_chkbxLabelTermsConditions);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_topSectionProductsName() {
		return DriverManager.getDriver().findElements(topSectionProductName);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_topSectionProductsPrice() {
		return DriverManager.getDriver().findElements(topSectionPrice);
	}

	/********************************************************************************************************************************/
	public WebElement get_specialInstruction() {
		return DriverManager.getDriver().findElement(specialInstruction);
	}

	/********************************************************************************************************************************/
	public WebElement get_radioBtnHouse() {
		return DriverManager.getDriver().findElement(rBtn_house);
	}
	
	/********************************************************************************************************************************/
	public WebElement get_label_accept_all_terms() {
		return DriverManager.getDriver().findElement(label_accept_all_terms);
	}

	/********************************************************************************************************************************/
	public boolean isClickable(String element, int waitTime) {

		boolean flag = false;

		switch (element) {
		case "rBtn_condominium":
			flag = waitForElementClickable(rBtn_condominium, waitTime);
			break;
		case "Pay":
			flag = waitForElementClickable(btnPay, waitTime);
			break;
		case "reviewBag":
			flag = waitForElementClickable(btnReviewBag, waitTime);
			break;
		case "toggleGiftOption":
			flag = waitForElementClickable(toggleGiftOption, waitTime);
			break;

		}
		return flag;
	}

	/********************************************************************************************************************************/
	public void javascript_clickCondominium() {
		WebElement ele = DriverManager.getDriver().findElement(rBtn_condominium);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", ele);

	}

	/********************************************************************************************************************************/
	public void javascript_clickRadioBtn_House() {
		WebElement ele = DriverManager.getDriver().findElement(rBtn_house);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", ele);

	}

	/********************************************************************************************************************************/
	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "chkbx_acceptAll":
			flag = waitForElementVisibility(chkbx_acceptAll, waitTime);
			break;
		case "hdrForm":
			flag = waitForElementVisibility(hdrForm, waitTime);
			break;
		case "topSectionImgXPW":
			flag = waitForElementVisibility(topSectionImgXPW, waitTime);
			break;
		case "topSectionImgGHPW":
			flag = waitForElementVisibility(topSectionImgGHPW, waitTime);
			break;
		case "formPersonalInfo":
			flag = waitForElementVisibility(formPersonalInfo, waitTime);
			break;
		case "errRecipientMobile":
			flag = waitForElementVisibility(errRecipientMobile, waitTime);
			break;
		case "specialInstruction":
			flag = waitForElementVisibility(specialInstruction, waitTime);
			break;
		case "topSectionImgBlackPink":
			flag = waitForElementVisibility(topSectionImgBlackPink, waitTime);
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
			case "topSectionProductName":
				text = DriverManager.getDriver().findElement(topSectionProductName).getText();
				break;
			case "topSectionPrice":
				text = DriverManager.getDriver().findElement(topSectionPrice).getText();
				break;
			case "errRecipientMobile":
				text = DriverManager.getDriver().findElement(errRecipientMobile).getText();
				break;
			case "txtdeliveryCaveat_1":
				text = DriverManager.getDriver().findElement(txtdeliveryCaveat_1).getText();
				break;
			case "txtdeliveryCaveat_2":
				text = DriverManager.getDriver().findElement(txtdeliveryCaveat_2).getText();
				break;
			case "firstName":
				text = DriverManager.getDriver().findElement(firstName).getText();
				break;
			case "middleName":
				text = DriverManager.getDriver().findElement(middleName).getText();
				break;
			case "lastName":
				text = DriverManager.getDriver().findElement(lastName).getText();
				break;
			case "email":
				text = DriverManager.getDriver().findElement(email).getText();
				break;
			case "mobileNumber":
				text = DriverManager.getDriver().findElement(mobileNumber).getText();
				break;
			case "houseNo":
				text = DriverManager.getDriver().findElement(houseNo).getText();
				break;
			case "street":
				text = DriverManager.getDriver().findElement(street).getText();
				break;
			case "village_subDivision":
				text = DriverManager.getDriver().findElement(village_subDivision).getText();
				break;
			case "drpdwnProvince":
				text = DriverManager.getDriver().findElement(drpdwnProvince).getText();
				break;
			case "drpdwnCity":
				text = DriverManager.getDriver().findElement(drpdwnCity).getText();
				break;
			case "drpdwnBarangay":
				text = DriverManager.getDriver().findElement(drpdwnBarangay).getText();
				break;
			case "zipCode":
				text = DriverManager.getDriver().findElement(zipCode).getText();
				break;
			case "specialInstruction":
				text = DriverManager.getDriver().findElement(specialInstruction).getText();
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
	public void clickOnElement(String type, String eleName, String ele) {

		try {
			switch (ele) {
			case "reviewBag":
				get_reviewBag().click();
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
	public String getAttributeValue(String ele, String attribute) {
		String text = "";

		try {
			switch (ele) {
			case "imgGiftOption":
				text = DriverManager.getDriver().findElement(imgGiftOption).getAttribute(attribute);
				break;
			case "imgSameDayDelivery":
				text = DriverManager.getDriver().findElement(imgSameDayDelivery).getAttribute(attribute);
				break;
			case "mobileNumber":
				text = DriverManager.getDriver().findElement(mobileNumber).getAttribute(attribute);
				break;
				
			case "firstName":
				text = DriverManager.getDriver().findElement(firstName).getAttribute(attribute);
				break;
			case "middleName":
				text = DriverManager.getDriver().findElement(middleName).getAttribute(attribute);
				break;
			case "lastName":
				text = DriverManager.getDriver().findElement(lastName).getAttribute(attribute);
				break;
			case "email":
				text = DriverManager.getDriver().findElement(email).getAttribute(attribute);
				break;
			case "houseNo":
				text = DriverManager.getDriver().findElement(houseNo).getAttribute(attribute);
				break;
			case "street":
				text = DriverManager.getDriver().findElement(street).getAttribute(attribute);
				break;
			case "village_subDivision":
				text = DriverManager.getDriver().findElement(village_subDivision).getAttribute(attribute);
				break;
			case "drpdwnProvince":
				text = DriverManager.getDriver().findElement(drpdwnProvince).getAttribute(attribute);
				break;
			case "drpdwnCity":
				text = DriverManager.getDriver().findElement(drpdwnCity).getAttribute(attribute);
				break;
			case "drpdwnBarangay":
				text = DriverManager.getDriver().findElement(drpdwnBarangay).getAttribute(attribute);
				break;
			case "zipCode":
				text = DriverManager.getDriver().findElement(zipCode).getAttribute(attribute);
				break;
			case "specialInstruction":
				text = DriverManager.getDriver().findElement(specialInstruction).getAttribute(attribute);
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
	public boolean check_AttirbuteNotEmpty(String eleName, String attribute, int waitTime) {

		boolean success = false;

		switch (eleName) {
		case "imgGiftOption":
			success = waitForElementAttributeToBeNotEmpty(imgGiftOption, "src", 10);
			break;
		case "imgSameDayDelivery":
			success = waitForElementAttributeToBeNotEmpty(imgSameDayDelivery, "src", 10);
			break;
		}

		return success;
	}

}
