package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserstack.DriverManager;

public class BasePage {

	public static boolean waitForElementVisibility(By ele, int waitTime) {

		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			flag = true;
		} catch (Exception e) {
			System.out.println("Element not found : " + ele + "Message : " + e.getMessage());
		}

		return flag;
	}

	/********************************************************************************************************************************/
	public static boolean waitForElementVisibility(WebElement ele, int waitTime) {

		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
			wait.until(ExpectedConditions.visibilityOf(ele));
			flag = true;
		} catch (Exception e) {
			System.out.println("Element not found : " + ele + "Message : " + e.getMessage());
		}

		return flag;
	}

	/********************************************************************************************************************************/
	public static boolean waitForElementClickable(By ele, int waitTime) {

		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			flag = true;
		} catch (Exception e) {
			System.out.println("Element not found : " + ele + "Message : " + e.getMessage());
		}
		return flag;
	}

	/********************************************************************************************************************************/
	public void scroll_vertical(int y_Axis) throws InterruptedException {
		Thread.sleep(500L);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(0," + y_Axis + ")", "");
		Thread.sleep(500L);
	}

	/********************************************************************************************************************************/
	public static boolean waitForElementAttributeToBeNotEmpty(By ele, String attribute, int waitTime) {

		WebElement element = DriverManager.getDriver().findElement(ele);

		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), waitTime);
			wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));

			flag = true;
		} catch (Exception e) {
			System.out.println("Element Attribute : " + ele + " is empty. Message : " + e.getMessage());
		}
		return flag;
	}

	/********************************************************************************************************************************/
	public void javascript_clickOnElement(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}
}
