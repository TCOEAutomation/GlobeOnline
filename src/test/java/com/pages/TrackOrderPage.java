package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.browserstack.DriverManager;

public class TrackOrderPage extends BasePage {

	By referenceNumber = By.xpath("//input[@formcontrolname='referenceNumber']");
	By email = By.xpath("//input[@formcontrolname='email']");
	By btn_trackOrder = By.xpath("//button[text()=' Track order']");

	/********************************************************************************************************************************/
	public WebElement get_referenceNumber() {
		return DriverManager.getDriver().findElement(referenceNumber);
	}

	/********************************************************************************************************************************/
	public WebElement get_email() {
		return DriverManager.getDriver().findElement(email);
	}

	/********************************************************************************************************************************/
	public WebElement get_btn_trackOrder() {
		return DriverManager.getDriver().findElement(btn_trackOrder);
	}

}
