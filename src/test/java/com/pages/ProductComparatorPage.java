package com.pages;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import com.browserstack.DriverManager;

public class ProductComparatorPage extends BasePage {

	static File file;

	By img_XPW_Spec = By.xpath("//img[@alt='XPW Spec']");
	By img_BlackPink_specification = By.xpath("//img[@alt='Blackpink Limited Edition Modem']");

	private String xpath_compareProductSection = "(//div[contains(@class,'comparison-left-content')]){0} ";

	String xpath_CommercialName = "//div[contains(@class,'image-card')]/../../div[3]/div/span";
	By txtCommercialName = By.xpath(xpath_CommercialName);

	String xpath_imageProduct = "//div[contains(@class,'image-card')]/img";

	String xpath_LanSupport = "//span[text()='LAN Support']/../../following-sibling::div[1] //p/strong";
	By txtLanSupport = By.xpath(xpath_LanSupport);

	String xpath_SupportNetwork = "//span[text()='Supported Networks']/../../following-sibling::div[1] //p/strong";
	By txtSuportNetwork = By.xpath(xpath_SupportNetwork);

	String xpath_WifiSupport = "//span[text()='WiFi Support']/../../following-sibling::div[1] //p/strong";
	By txtWiFiSupport = By.xpath(xpath_WifiSupport);

	String xpath_Features = "//span[text()='Features']/../../following-sibling::div[1] //p/strong";
	By txtFeatures = By.xpath(xpath_Features);

	String xpath_Freebies = "//span[text()='Freebies']/../../following-sibling::div[1] //p/strong";
	By txtFreebies = By.xpath(xpath_Freebies);

	String xpath_BestWIth = "//span[text()='Best with']/../../following-sibling::div[1] //p";
	By txtBestWith = By.xpath(xpath_BestWIth);

	String xpath_stockAvalability = "//img[contains(@alt,'stock')][1]/../.. //div[2]/span";
	By stockAvalability = By.xpath(xpath_stockAvalability);

	String xpath_avalabilityStock = "//img[contains(@alt,'stock')][1]/../.. //div[2]/img";
	By avalabilityStock = By.xpath(xpath_avalabilityStock);

	String xpath_offeredPrice = "//div[contains(@class,'price')]/span[1]";
	By offeredPrice = By.xpath(xpath_offeredPrice);

	String xpath_actualPrice = "//div[contains(@class,'price')]/span[2]";
	By actualPrice = By.xpath(xpath_actualPrice);

	String xpath_btnBuyNow_Checkout = "//button[contains(@id,'checkoutButton')]";
	By btnBuyNow_Checkout = By.xpath(xpath_btnBuyNow_Checkout);

	String xpath_txtPaymentOption = "//div[contains(@class,'acceptingCash-text')]/span";
	By txtPaymentOption = By.xpath(xpath_txtPaymentOption);

	By imgProducts = By.xpath("//div[@class='comparision-bg'] //div[contains(@class,'image-card')]");
	
	By xtremeWifi_deliveryCaveat_1 = By.xpath("//div[contains(@class,'delivery-content')]/div");
	By xtremeWifi_deliveryCaveat_2 = By.xpath("//div[contains(@class,'delivery-content')]/div/../div[2]");

	/********************************************************************************************************************************/
	public WebElement get_ActualPrice() {
		return DriverManager.getDriver().findElement(actualPrice);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsCommercialName(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleCommercialName = By.xpath(tempXpath_ProductSection + xpath_CommercialName);
		return DriverManager.getDriver().findElements(multipleCommercialName);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsImage(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleProductImage = By.xpath(tempXpath_ProductSection + xpath_imageProduct);
		return DriverManager.getDriver().findElements(multipleProductImage);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsActualPrice(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleActualPrice = By.xpath(tempXpath_ProductSection + xpath_actualPrice);
		return DriverManager.getDriver().findElements(multipleActualPrice);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsPaymentOption(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multiple_txtPaymentOption = By.xpath(tempXpath_ProductSection + xpath_txtPaymentOption);
		return DriverManager.getDriver().findElements(multiple_txtPaymentOption);
	}

	/********************************************************************************************************************************/
	public WebElement get_BuyNow_Checkout() {
		return DriverManager.getDriver().findElement(btnBuyNow_Checkout);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_Products() {
		return DriverManager.getDriver().findElements(imgProducts);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsLanSupport(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleLanSupport = By.xpath(tempXpath_ProductSection + xpath_LanSupport);
		return DriverManager.getDriver().findElements(multipleLanSupport);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsFeatures(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleFeatures = By.xpath(tempXpath_ProductSection + xpath_Features);
		return DriverManager.getDriver().findElements(multipleFeatures);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsFreebies(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleFreebies = By.xpath(tempXpath_ProductSection + xpath_Freebies);
		return DriverManager.getDriver().findElements(multipleFreebies);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsBestWith(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleBestWith = By.xpath(tempXpath_ProductSection + xpath_BestWIth);
		return DriverManager.getDriver().findElements(multipleBestWith);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsNetworkSupport(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleSupportNetwork = By.xpath(tempXpath_ProductSection + xpath_SupportNetwork);
		return DriverManager.getDriver().findElements(multipleSupportNetwork);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsWifiSupport(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleWifiSupport = By.xpath(tempXpath_ProductSection + xpath_WifiSupport);
		return DriverManager.getDriver().findElements(multipleWifiSupport);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsOfferedPrice(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleOfferedPrice = By.xpath(tempXpath_ProductSection + xpath_offeredPrice);
		return DriverManager.getDriver().findElements(multipleOfferedPrice);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsBtnExpressChekout(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleStockAvailability = By.xpath(tempXpath_ProductSection + xpath_btnBuyNow_Checkout);
		return DriverManager.getDriver().findElements(multipleStockAvailability);
	}

	/********************************************************************************************************************************/
	public List<WebElement> get_ProductsStockAvalability(String parentID) {
		String tempXpath_ProductSection = updateProductSectionXpathWithParentID(xpath_compareProductSection, parentID);
		By multipleStockAvalability = By.xpath(tempXpath_ProductSection + xpath_avalabilityStock);
		return DriverManager.getDriver().findElements(multipleStockAvalability);
	}

	/********************************************************************************************************************************/

	public boolean isElementExist(String message, String element, int waitTime) {
		boolean flag = false;

		switch (element) {
		case "img_XPW_Spec":
			flag = waitForElementVisibility(img_XPW_Spec, waitTime);
			break;
		case "btnBuyNow_Checkout":
			flag = waitForElementVisibility(btnBuyNow_Checkout, waitTime);
			break;
		case "img_BlackPink_specification":
			flag = waitForElementVisibility(img_BlackPink_specification, waitTime);
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
			case "LanSupport":
				text = DriverManager.getDriver().findElement(txtLanSupport).getText();
				break;
			case "SuportNetwork":
				text = DriverManager.getDriver().findElement(txtSuportNetwork).getText();
				break;
			case "WiFiSupport":
				text = DriverManager.getDriver().findElement(txtWiFiSupport).getText();
				break;
			case "Features":
				text = DriverManager.getDriver().findElement(txtFeatures).getText();
				break;
			case "Freebies":
				text = DriverManager.getDriver().findElement(txtFreebies).getText();
				break;
			case "BestWith":
				text = DriverManager.getDriver().findElement(txtBestWith).getText();
				break;
			case "stockAvalability":
				text = DriverManager.getDriver().findElement(stockAvalability).getText();
				break;
			case "offeredPrice":
				text = DriverManager.getDriver().findElement(offeredPrice).getText();
				break;
			case "actualPrice":
				text = DriverManager.getDriver().findElement(actualPrice).getText();
				break;
			case "PaymentOption":
				text = DriverManager.getDriver().findElement(txtPaymentOption).getText();
				break;
			case "XtremeWifiDeliveryCaveat_1":
				text = DriverManager.getDriver().findElement(xtremeWifi_deliveryCaveat_1).getText();
				break;
			case "XtremeWifiDeliveryCaveat_2":
				text = DriverManager.getDriver().findElement(xtremeWifi_deliveryCaveat_2).getText();
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
			case "BuyNow_Checkout":
				get_BuyNow_Checkout().click();
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
	public boolean isClickable(String element, int waitTime) {

		boolean flag = false;

		switch (element) {
		case "BuyNow_Checkout":
			flag = waitForElementClickable(btnBuyNow_Checkout, waitTime);
			break;

		}

		return flag;
	}

	/********************************************************************************************************************************/
	public String updateProductSectionXpathWithParentID(String xpath_compareProductSection, String parentID) {
		String tempXpath_ProductSection = xpath_compareProductSection;
		tempXpath_ProductSection = tempXpath_ProductSection.replace("{0}", "[" + parentID + "]");

		return tempXpath_ProductSection;
	}

	/********************************************************************************************************************************/
	public void reportProductFeatures(String parentID) {
		int count = get_ProductsFeatures(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("Features : " + get_ProductsFeatures(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductBestWith(String parentID) {
		int count = get_ProductsBestWith(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("Best With : " + get_ProductsBestWith(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductFreebies(String parentID) {
		int count = get_ProductsFreebies(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("Freebies : " + get_ProductsFreebies(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductLanSupport(String parentID) {
		int count = get_ProductsLanSupport(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("LAN Support : " + get_ProductsLanSupport(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductSupportedNetwork(String parentID) {
		int count = get_ProductsNetworkSupport(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("Suport Network : " + get_ProductsNetworkSupport(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductWiFiSupport(String parentID) {
		int count = get_ProductsWifiSupport(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("WiFi Support : " + get_ProductsWifiSupport(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductOfferedPrice(String parentID) {
		int count = get_ProductsOfferedPrice(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println("Offered Price : " + get_ProductsOfferedPrice(parentID).get(i).getText());
		}
	}

	/********************************************************************************************************************************/
	public void reportProductActualPrice(String parentID) {

		int count = get_ProductsActualPrice(parentID).size();

		if (count != 0) {
			for (int i = 0; i < count; i++) {
				System.out.println("Actual Price : " + get_ProductsActualPrice(parentID).get(i).getText());

				if (get_ProductsActualPrice(parentID).get(i).getCssValue("text-decoration").contains("line-through")) {
					System.out.println("Actual Price on specification is 'Strikethrough'");
				} else {
					System.out.println("Actual Price on specification is not 'Strikethrough'");
				}
			}

		} else {
			System.out.println("Actual price is not present on screen");
		}
	}

	/********************************************************************************************************************************/
	public void reportProductPaymentOption(String parentID) {

		int count = get_ProductsPaymentOption(parentID).size();

		if (count != 0) {
			for (int i = 0; i < count; i++) {
				System.out.println("Payment Option : " + get_ProductsPaymentOption(parentID).get(i).getText());
			}

		} else {
			System.out.println("Payment Option is not present on screen");
		}
	}

	/********************************************************************************************************************************/
	public void reportProductBtnExpressCheckout(String parentID) {
		int count = get_ProductsBtnExpressChekout(parentID).size();
		for (int i = 0; i < count; i++) {

			if (waitForElementVisibility(get_ProductsBtnExpressChekout(parentID).get(i), 5)) {
				System.out.println("Button - Express Checkout - exists");
			} else {
				System.out.println("Button - Express Checkout - do not exists");
			}
		}
	}

	/********************************************************************************************************************************/
	public String reportProductCommercialName(String parentID) {

		String commercialName = "";
		int count = get_ProductsCommercialName(parentID).size();
		for (int i = 0; i < count; i++) {
			commercialName = get_ProductsCommercialName(parentID).get(i).getText();
			System.out.println("Product Commercial Name : " + commercialName);
		}

		return commercialName;
	}

	/********************************************************************************************************************************/
	public void reportProductImage(String parentID, String productName) {

		String imgName = "";

		int count = get_ProductsImage(parentID).size();
		for (int i = 0; i < count; i++) {
			imgName = get_ProductsImage(parentID).get(i).getAttribute("alt");

			if (imgName.contains(productName)) {
				System.out.println("Correct product Image is displayed for the description given");
			} else {
				System.out.println("Incorrect product Image is displayed for the description given");
			}
		}
	}

	/********************************************************************************************************************************/
	public void reportStockAvalability(String parentID) {

		int count = get_ProductsStockAvalability(parentID).size();
		for (int i = 0; i < count; i++) {
			System.out.println(
					"Stock Avalability : " + get_ProductsStockAvalability(parentID).get(i).getAttribute("alt"));
		}
	}

}
