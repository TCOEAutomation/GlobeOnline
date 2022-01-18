package com.browserstack;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.ExtentListeners.ExtentManager;
//import com.ExtentListeners.ExtentTestManager;
import com.pages.CheckoutPage;
import com.pages.FormPage;
import com.pages.LandingPage;
import com.pages.PayPage;
import com.pages.ProductComparatorPage;

public class TestMultipleCart extends BrowserStackJUnitTest {

////***********************************************************************************************************************
//public class TestMultipleCart {
//
//	private WebDriver driver;
//
//	@Before
//	public void Setup() {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
//		driver = new ChromeDriver();
//
//		DriverManager.setWebDriver(driver);
//
//		DriverManager.getDriver().manage().window().maximize();
//		DriverManager.getDriver().manage().deleteAllCookies();
//		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
//		String browserName = cap.getBrowserName().toUpperCase();
//
//		ExtentTestManager.startTest(browserName + " : Test Name : ");
//		ExtentTestManager.logInfo("Execution started for : ");
//		ExtentTestManager.logInfo("Browser Launched : " + browserName);
//	}
//
//	@After
//	public void tearDown() {
//		ExtentTestManager.logInfo("Execution Finished");
//		ExtentManager.getReporter().flush();
//	}
//	// ***********************************************************************************************************************

	private static TestMultipleCart multipleCart = new TestMultipleCart();
	private util util = new util();
	private CommonMethods common = new CommonMethods();

	private LandingPage LP = new LandingPage();
	private ProductComparatorPage PC = new ProductComparatorPage();
	private CheckoutPage checkout = new CheckoutPage();
	private FormPage Form = new FormPage();

	@Test
	public void testMultipleCart() throws Exception {

		String cashoutAmount_checkout = "";
		String shipping = "";
		String totalAmount = "";

//		ExtentTestManager.logInfo("Test Name : " + multipleCart.getClass().getSimpleName());
		Constant.dataMap.put("TestClassName", multipleCart.getClass().getSimpleName());
		Constant.dataMap.put("OMT_LAS", "NOT FOUND");
		Constant.dataMap.put("OMT_DispositionStatus", "NOT FOUND");
		Constant.dataMap.put("OMT_UpdateDate", "NOT FOUND");
		Constant.dataMap.put("OMT_DateOrdered", "NOT FOUND");
		Constant.dataMap.put("OMT_EstimatedDayOfDelivery", "NOT FOUND");
		Constant.dataMap.put("OMT_OrderDetails", "NOT FOUND");
		Constant.dataMap.put("Magento_Details", "NOT FOUND");
		Constant.dataMap.put("Magento_OrderAccountInfo", "NOT FOUND");

		// Step -1, line - 148
		String url = "https://onlineuat.globe.com.ph/port-number";
		DriverManager.getDriver().get(url);
//		ExtentTestManager.logInfo("Launched Browser : " + url);
//		DriverManager.getDriver().get("https://onlinepreprod.globe.com.ph/");

		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Globe Online");

		// Step -2, line - 149
		LP.isElementExist("Link Globe logo", "link_LogoGlobe", 10);
		LP.isElementExist("Menu bar link - Apply", "link_Apply", 10);
		LP.isElementExist("Menu bar link - Renew", "link_Renew", 10);
		// b.1) Gallery - Not Covered
		LP.isElementExist("Menu bar link - Switch", "link_Switch", 10);

		if (LP.isElementExist("Menu bar link - Buy", "link_MenuBuy", 10)) {
			Thread.sleep(2000L);
			LP.moveToElement("menuBuy");
			Thread.sleep(2000L);
			System.out.println("Moved to Buy icon on menu bar");
			LP.isElementExist("Link - Buy - Xtreme Home Prepaid WiFi", "link_XtremeHomePrepaidWiFi", 10);
			LP.isElementExist("Link - Buy - Globe At Home Prepaid WiFi", "link_GlobeAtHomePrepaidWiFi", 10);
			LP.isElementExist("Link - Buy - LTE Advanced", "link_LTE_Advanced", 10);
			LP.isElementExist("Link - Buy - BLACKPINK Limited Edition", "link_BLACKPINKLimitedEdition", 10);
			LP.isElementExist("Link - Buy - MyFi LTE", "link_MyFiLTE", 10);
			LP.isElementExist("Link - Buy - MyFi LTE-Advanced", "link_MyFiLTE_Advanced", 10);
		}

		LP.isElementExist("Menu bar link - Help", "link_Help", 10);
		LP.isElementExist("Menu bar link - Cart Icon", "CartIcon", 10);
		LP.isElementExist("Menu bar link - Track my order", "link_TrackMyOrder", 10);

		// Step - 3, 4, line - 150, 151
		common.acceptCookies();

		// Step - 5, line - 152
		common.clickBuyLinkOnHeader();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Home Prepaid WiFi");

		// Step - 12, line - 153
		// Validate and click Express Checkout button for GHPW - not covered
		LP.clickOnElement("Button", "float_buy", "float_buy");
		System.out.println("Clicked on Buy icon on Home Prepaid WiFi screen");

		// Step - 13, line - 154
		if (LP.isElementExist("Menu bar link - Buy", "link_MenuBuy", 10)) {

			Thread.sleep(2000L);
//			LP.moveToElement("floatingBuyNow");
//			Thread.sleep(1000L);
			checkout.moveToElement("btnPromoCode");
			Thread.sleep(2000L);
			LP.moveToElement("menuBuy");
			Thread.sleep(3000L);
			System.out.println("Moved to Buy icon on menu bar");
			LP.isElementExist("Link - Buy - Xtreme Home Prepaid WiFi", "link_XtremeHomePrepaidWiFi", 10);
			LP.isElementExist("Link - Buy - Globe At Home Prepaid WiFi", "link_GlobeAtHomePrepaidWiFi", 10);
			LP.isElementExist("Link - Buy - LTE Advanced", "link_LTE_Advanced", 10);
			LP.isElementExist("Link - Buy - BLACKPINK Limited Edition", "link_BLACKPINKLimitedEdition", 10);
		}

		// line - 155, 156
		if (LP.isClickable("link_XtremeHomePrepaidWiFi", 5)) {
			LP.clickOnElement("Link", "Xtreme Home Prepaid WiFi", "link_XtremeHomePrepaidWiFi");
			Thread.sleep(2000L);
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Xtreme Home Prepaid WiFi");

		// line - 156
		// Validate XHPW Landing Page including
		Thread.sleep(1000L);
		LP.moveToElement("floatingBuyNow");
		Thread.sleep(1000L);
		LP.isElementExist("Button - Download Manual", "downloadManual", 10);
		LP.isElementExist("Button - Buy now", "buyNow", 10);
		LP.isElementExist("Button - Floating Buy now", "floatingBuyNow", 10);

		if (LP.get_floatActualPrice().getCssValue("text-decoration").contains("line-through")) {
			System.out.println("Float Actual Price is 'Strikethrough'");
		} else {
			System.out.println("Float Actual Price is not 'Strikethrough'");
		}

		common.validateFooter();

		// Step - 16, line - 157
		// Validate All banner for XHPW - not covered

		// line 158, 159, 160
		// Click Highlight tab - validation not covered, need clarity
		// Click Feature tab - validation not covered, need clarity
		// Click Specifications - validation not covered, need clarity
		LP.scroll_vertical(600);
		if (LP.isElementExist("Header - Highlights", "link_highlights", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_highlights", 5)) {
				LP.clickOnElement("Link", "Highlights", "link_highlights");
			}
		}

		if (LP.isElementExist("Header - Features", "link_features", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_features", 5)) {
				LP.clickOnElement("Link", "Features", "link_features");
			}
		}

		if (LP.isElementExist("Header - Specifications", "link_specifications", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_specifications", 5)) {
				LP.clickOnElement("Link", "Specifications", "link_specifications");
			}
		}

		// Step -16, line 161
		// Validate Product Comparator/Specification

		common.validate_product_specification("Xtreme Home Prepaid WiFi");

		// line 162 - Validate and click Express checkout
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// Step -21, line - 163 , Validate Express Checkout Page

		System.out.println("*********  Express Checkout Page ************");
		Thread.sleep(2000L);
		checkout.scroll_vertical(400);
//		System.out.println("Quantity : " + checkout.getText("quantity"));

		String dataMap_qty = "";
		for (int i = 0; i < checkout.get_quantities().size(); i++) {
			String pName = checkout.get_productsName().get(i).getText();
			String qty = checkout.get_quantities().get(i).getText();
			System.out.println("For product : " + pName + " Quantity is : " + qty);
			dataMap_qty = dataMap_qty.concat(" | ").concat(qty);
		}

//		Constant.dataMap.put("OMT_ProductQty", checkout.getText("quantity"));
//		Constant.dataMap.put("Magento_ItemsOrdered", checkout.getText("quantity"));
		Constant.dataMap.put("OMT_ProductQty", dataMap_qty.substring(2));
		Constant.dataMap.put("Magento_ItemsOrdered", dataMap_qty.substring(2));

		System.out.println("Cashout Amount : " + checkout.getText("cashoutAmount"));
		cashoutAmount_checkout = checkout.getText("cashoutAmount");

		System.out.println("Shipping : " + checkout.getText("shipping"));
		shipping = checkout.getText("shipping");

		System.out.println("Total Amount : " + checkout.getText("totalAmount"));
		totalAmount = checkout.getText("totalAmount");
		Constant.dataMap.put("OMT_AmountPaid", totalAmount);
		Constant.dataMap.put("Magento_OrderTotal", totalAmount);

		common.validateTotalAMount(cashoutAmount_checkout, shipping, totalAmount);

		// Step - 23, line 164, Validate Order Details
		// line - 165 - validate delivery caveat on express checkout page
		System.out.println("*********  Order details ************");
		common.validate_order_details_on_checkout();

		// line - 166, 167 - Input gcash mobile number, Click "Proceed standard
		// checkout" button
		common.insert_phoneNo_select_checkout_option(Constant.gCash_number, "StandardCheckout");

		// line - 168 - Validate OTP prompt
		common.handle_and_insert_OTP();

		// line - 169 - Validate Products in the bag displayed in the top section

		Form.isElementExist("Form-Top Section-Image-Product - GHPW", "topSectionImgGHPW", 10);
		Form.isElementExist("Form-Top Section-Image-Product - XPW", "topSectionImgXPW", 10);

		String omt_pName = "";
		for (int i = 0; i < Form.get_topSectionProductsName().size(); i++) {
			String topSection_pName = Form.get_topSectionProductsName().get(i).getText();
			System.out.println("Form-TopSection-ProductName : " + topSection_pName);
			System.out.println("Form-TopSection-Price : " + Form.get_topSectionProductsPrice().get(i).getText());

			omt_pName = omt_pName.concat(" | ").concat(topSection_pName);
		}

		Constant.dataMap.put("OMT_ProductName", omt_pName.substring(2));

//		Constant.dataMap.put("OMT_ProductName", Form.getText("topSectionProductName"));
//		System.out.println("Form-TopSection-Price : " + Form.getText("topSectionPrice"));

		// line - 170-Go back to DAF form-Should have prefilled mobile number & details
		Form.scroll_vertical(200);
		System.out.println("Form-Prefilled Mobile No : " + Form.getAttributeValue("mobileNumber", "value"));

		// line - 171 - Click Review my bag
		if (Form.isClickable("reviewBag", 5)) {
			Form.clickOnElement("Button", "Review my bag", "reviewBag");
		}

		// line - 172 - Go back to DAF form
		checkout.scroll_vertical(500);
		Thread.sleep(1000);
		if (checkout.isClickable("StanCheckout", 5)) {
			checkout.get_standardCheckout().click();
			System.out.println("Form-Prefilled Mobile No : " + Form.getAttributeValue("mobileNumber", "value"));
		}
		// line - 173 - Validate Application Form
		Form.isElementExist("Form-Personal Information", "formPersonalInfo", 10);

		// line - 174 to 177
		common.insert_personal_info_on_form("praveen1982qa@gmail.com", "StandardCheckout");

		// line - 178 to 182

		if (Form.check_AttirbuteNotEmpty("imgGiftOption", "src", 10)) {
			common.selectGiftOptionOnForm();
			Form.get_recipientName().sendKeys("TestRecipient");
			Constant.dataMap.put("OMT_RecipientDetails", "TestRecipient");

			common.insert_and_validate_recipientMobile("specialChar", "!@#$%^&*()");
			common.insert_and_validate_recipientMobile("incompleteNumber", "12345");
			common.insert_and_validate_recipientMobile("validNumber", "09270004201");
		}
		// line - 183 to 189 - condominium address information
		// line - 184 - not covered
		common.insert_address_details_Condominium();

		// line - 190 - Validate Postal Code
		String zipCOde = Form.get_zipCode().getAttribute("value");
		if (zipCOde == null || zipCOde.isEmpty()) {
			System.out.println("FAIL : ZIP Code -  is blank");
		} else {
			System.out.println("ZIP Code is pre-populated : " + zipCOde);
		}

		// line 191 - validate Next day delivery
		Form.scroll_vertical(350);
		if (Form.check_AttirbuteNotEmpty("imgSameDayDelivery", "src", 10)) {
			if (Form.getAttributeValue("imgSameDayDelivery", "src").contains("active")) {
				System.out.println("Same day delivery toggle is auto - selected");
			} else {
				System.out.println("FAIL : Same day delivery toggle is not auto - selected");
			}
		}

		// line - 192 - Validate delivery caveat
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_1"));
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_2"));

		// line - 193 - Validate MAP / Pin location - not covered

		// line -194 to 200 - toggle checkboxes
		LP.scroll_vertical(5000);
		Thread.sleep(2000L);
		common.validate_termsConditions_checkbox_toggle();
		common.select_chkbx_acceptAllTerms();

		// line - 201 - Click Pay
		common.click_pay_btn_on_form();

		// line - 202 - Validate Payment Page
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");

		// line - 203, 204 - Select GCASH - Click Pay and Validate Gcash payment page
		common.select_payment_option_proceed_with_payment("GCash");

		common.clickPayOrderOnPayScreen();

		// line - 205 to 209 - survey form
		common.verify_handle_survey_popup();
		assertTrue(DriverManager.getDriver().getTitle().contains("Thank you"));
		common.capture_orderID();

		Constant.dataMap.put("TimeStamp", util.getTimeStamp());

		util.writeToExcelLastRowFromMap("Sheet1", Constant.dataMap);

		System.out.println("!!! Execution Completed !!!");

	}
}
