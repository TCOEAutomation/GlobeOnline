package com.browserstack;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.CheckoutPage;
import com.pages.FormPage;
import com.pages.LandingPage;
import com.pages.OrderDetailsPage;
import com.pages.PayPage;
import com.pages.ProductComparatorPage;
import com.pages.ThankYouPage;
import com.pages.TrackOrderPage;

public class TestSingleCart_LTE extends BrowserStackJUnitTest {
//public class TestSingleCart_LTE {
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
//	}
	
	private String invalid_GCash_No = "01234567890";

	private static TestSingleCart_LTE singleCartLTE = new TestSingleCart_LTE();
	private util util = new util();
	private CommonMethods common = new CommonMethods();

	private LandingPage LP = new LandingPage();
	private ProductComparatorPage PC = new ProductComparatorPage();
	private CheckoutPage checkout = new CheckoutPage();
	private FormPage Form = new FormPage();
	private PayPage Pay = new PayPage();
	private ThankYouPage ThankYou = new ThankYouPage();

	@Test
	public void testSingleCartLTE() throws Exception {

		String cashoutAmount_checkout = "";
		String shipping = "";
		String totalAmount = "";

		Constant.dataMap.put("TestClassName", singleCartLTE.getClass().getSimpleName());
		Constant.dataMap.put("OMT_LAS", "NOT FOUND");
		Constant.dataMap.put("OMT_DispositionStatus", "NOT FOUND");
		Constant.dataMap.put("OMT_UpdateDate", "NOT FOUND");
		Constant.dataMap.put("OMT_DateOrdered", "NOT FOUND");
		Constant.dataMap.put("OMT_EstimatedDayOfDelivery", "NOT FOUND");
		Constant.dataMap.put("OMT_OrderDetails", "NOT FOUND");
		Constant.dataMap.put("Magento_Details", "NOT FOUND");
		Constant.dataMap.put("Magento_OrderAccountInfo", "NOT FOUND");

		// ************************************************************************************
		// Step -1, line - 269
		// ************************************************************************************
		DriverManager.getDriver().get("https://onlineuat.globe.com.ph/port-number");
//		DriverManager.getDriver().get("https://onlinepreprod.globe.com.ph/");

		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Globe Online");

		// ************************************************************************************
		// Step -2, line - 270
		// ************************************************************************************
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

		common.acceptCookies();

		// ************************************************************************************
		// line - 271, 272 - Validate LTE-Advanced landing page
		// ************************************************************************************
		common.select_LTE_Advanced_on_home_page();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(),
				"Home Prepaid WiFi LTE-Advanced");

		// ************************************************************************************
		// line - 273 - Validate LTE-Advanced Landing Page including - Footer - not
		// covered
		// ************************************************************************************
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

		// ************************************************************************************
		// line - 274 - Validate All banner for LTE - not covered
		// ************************************************************************************

		// ************************************************************************************
		// line 275, 276, 277
		// Click Highlight tab - validation not covered, need clarity
		// Click Feature tab - validation not covered, need clarity
		// Click Compare - validation not covered, need clarity
		// ************************************************************************************
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

		if (LP.isElementExist("Header - Compare", "link_compare", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_compare", 5)) {
				LP.clickOnElement("Link", "Compare", "link_compare");
			}
		}

		// ************************************************************************************
		// line 278 - Validate Product compare section
		// ************************************************************************************
		if (PC.get_Products().size() <= 3) {
			System.out.println("PASS - Atmost 3 products are available on comparator screen. Product available : "
					+ PC.get_Products().size());
		} else {
			System.out.println("FAIL - More than 3 products are available on comparator screen. Product available : "
					+ PC.get_Products().size());
		}

		common.compareProducts();

		// ************************************************************************************
		// line 279 - Validate and click Express Checkout button
		// ************************************************************************************
		PC.scroll_vertical(1200);
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			Thread.sleep(500L);
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// ************************************************************************************
		// line - 280 , Validate Express Checkout Page
		// ************************************************************************************
		System.out.println("*********  Express Checkout Page ************");
		Thread.sleep(2000L);
		checkout.scroll_vertical(150);

		String dataMap_qty = "";
		for (int i = 0; i < checkout.get_quantities().size(); i++) {

			String pName = checkout.get_productsName().get(i).getText();
			String qty = checkout.get_quantities().get(i).getText();
			System.out.println("For product : " + pName + " Quantity is : " + qty);
			dataMap_qty = dataMap_qty.concat(" | ").concat(qty);
		}

		cashoutAmount_checkout = checkout.getText("cashoutAmount");
		System.out.println("Cashout Amount : " + cashoutAmount_checkout);

		shipping = checkout.getText("shipping");
		System.out.println("Shipping : " + shipping);

		totalAmount = checkout.getText("totalAmount");
		System.out.println("Total Amount : " + totalAmount);

//				Constant.dataMap.put("OMT_ProductQty", checkout.getText("quantity"));
//				Constant.dataMap.put("Magento_ItemsOrdered", checkout.getText("quantity"));
		Constant.dataMap.put("OMT_ProductQty", dataMap_qty.substring(2));
		Constant.dataMap.put("Magento_ItemsOrdered", dataMap_qty.substring(2));
		Constant.dataMap.put("OMT_AmountPaid", totalAmount);
		Constant.dataMap.put("Magento_OrderTotal", totalAmount);

		common.validateTotalAMount(cashoutAmount_checkout, shipping, totalAmount);

		// ************************************************************************************
		// line 281, Validate Order Details
		// line - 282 - Validate GCash - Next day delivery
		// ************************************************************************************
		System.out.println("*********  Order details ************");
		common.validate_order_details_on_checkout();

		// ************************************************************************************
		// line - 283 - Validate Proceed standard checkout button
		// ************************************************************************************
		if (checkout.isElementExist("Button - Standard Checkout", "btnStandardCheckout", 5)) {
			System.out.println("Standard Checkout Button is avaibale");
		} else {
			System.out.println("Standard Checkout Button is not avaibale");
		}

		// ************************************************************************************
		// line - 284 - Validate What is GCash
		// ************************************************************************************
		checkout.scroll_vertical(400);
		common.verifyWhatIsGCash();

		// ************************************************************************************
		// line - 285 - Click +
		// ************************************************************************************
		checkout.scroll_vertical(-200);
		common.addQuantityOnCheckout();

		// ************	************************************************************************
		// line - 286 - Click -
		// ************************************************************************************
		common.removeQuantityOnCheckout();

		// ************************************************************************************
		// line - 287 - Click x
		// ************************************************************************************
		Thread.sleep(3000L);
		common.btnCloseToRemoveProductFromCheckout();
		Thread.sleep(3000L);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "New Globe Online Shop");

		// ************************************************************************************
		// line - 288 - Pre-requisite: Add removed the product
		// ************************************************************************************

		LP.moveToElement("menuBuy");
		Thread.sleep(1000L);

		common.select_LTE_Advanced_on_home_page();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(),
				"Home Prepaid WiFi LTE-Advanced");

		LP.scroll_vertical(600);

		if (LP.isElementExist("Header - Compare", "link_compare", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_compare", 5)) {
				LP.clickOnElement("Link", "Compare", "link_compare");
			}
		}

		Thread.sleep(2000L);
		PC.scroll_vertical(1300);
		Thread.sleep(2000L);
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// ************************************************************************************
		// line - 289 - Input invalid gcash mobile number
		// ************************************************************************************
		checkout.scroll_vertical(400);
		System.out.println("Validation for incorrect GCash number");
		common.insert_phoneNo_select_checkout_option(invalid_GCash_No, "GCash");
		checkout.scroll_vertical(100);
		if (checkout.isElementExist("Button - Try Again", "btnTryAgain", 30)) {
			//
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Error");
		checkout.get_btnTryAgain().click();
		System.out.println("Clicked on Try again button");

		// ************************************************************************************
		// line - 290, 291 - Input gcash mobile number
		// ************************************************************************************
		System.out.println("Validation for correct GCash number");
		checkout.scroll_vertical(400);
		common.insert_phoneNo_select_checkout_option(Constant.gCash_number, "GCash");

		// ************************************************************************************
		// line - 292 - Validate OTP prompt
		// ************************************************************************************
		if (checkout.isElementExist("Text OTP", "otpText", 30)) {
			System.out.println("Navigated to screen to insert OTP");
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "One-Time Password");

		// ************************************************************************************
		// line - 293 - Click Resend code
		// ************************************************************************************
		common.resendOTP();
		// ************************************************************************************
		// line - 294 - Enter OTP
		// ************************************************************************************
		common.handle_and_insert_OTP();

		// ************************************************************************************
		// line - 295 - Validate Application Form
		// ************************************************************************************
		String omt_pName = "";
		for (int i = 0; i < Form.get_topSectionProductsName().size(); i++) {
			String topSection_pName = Form.get_topSectionProductsName().get(i).getText();
			System.out.println("Form-TopSection-ProductName : " + topSection_pName);
			System.out.println("Form-TopSection-Price : " + Form.get_topSectionProductsPrice().get(i).getText());

			omt_pName = omt_pName.concat(" | ").concat(topSection_pName);
		}

		Constant.dataMap.put("OMT_ProductName", omt_pName.substring(2));

		Form.scroll_vertical(200);
		System.out.println("Form-Prefilled Mobile No : " + Form.getAttributeValue("mobileNumber", "value"));

		common.insert_personal_info_on_form("praveen1982qa@gmail.com", "StandardCheckout");

		// ************************************************************************************
		// line - 296 to 300 - Select toggle button for 'im giving this gift'
		// ************************************************************************************
		if (Form.check_AttirbuteNotEmpty("imgGiftOption", "src", 10)) {
			common.selectGiftOptionOnForm();
			Form.get_recipientName().sendKeys("TestRecipient");
			Constant.dataMap.put("OMT_RecipientDetails", "TestRecipient");

			common.insert_and_validate_recipientMobile("specialChar", "!@#$%^&*()");
			common.insert_and_validate_recipientMobile("incompleteNumber", "12345");
			common.insert_and_validate_recipientMobile("validNumber", "09270004201");
		}

		// ************************************************************************************
		// line - 301 to 306 - Select House
		// ************************************************************************************
		common.insert_address_details_House();

		// ************************************************************************************
		// line - 307 - Validate Postal Code
		// ************************************************************************************
		String zipCOde = Form.get_zipCode().getAttribute("value");
		if (zipCOde == null || zipCOde.isEmpty()) {
			System.out.println("FAIL : ZIP Code -  is blank");
		} else {
			System.out.println("ZIP Code is pre-populated : " + zipCOde);
		}

		// ************************************************************************************
		// line - 308 - validate Next day delivery
		// ************************************************************************************
		Form.scroll_vertical(350);
		if (Form.check_AttirbuteNotEmpty("imgSameDayDelivery", "src", 10)) {
			if (Form.getAttributeValue("imgSameDayDelivery", "src").contains("active")) {
				System.out.println("Same day delivery toggle is auto - selected");
			} else {
				System.out.println("FAIL : Same day delivery toggle is not auto - selected");
			}
		}

		// ************************************************************************************
		// line - 310 - Validate delivery caveat
		// ************************************************************************************
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_1"));
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_2"));

		// ************************************************************************************
		// line - 311 - Validate MAP / Pin location - not covered
		// ************************************************************************************

		// ************************************************************************************
		// line - 312 to 318 - Checked i accept all terms and conditions
		// ************************************************************************************
		LP.scroll_vertical(5000);
		Thread.sleep(2000L);
		common.validate_termsConditions_checkbox_toggle();
		common.select_chkbx_acceptAllTerms();

		// ************************************************************************************
		// line - 319 - Click Pay
		// ************************************************************************************
		common.click_pay_btn_on_form();

		// ************************************************************************************
		// line - 320 - Validate Payment Page
		// ************************************************************************************
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");

		// ************************************************************************************
		// line - 321, 322 - Validate order details, shipping address
		// ************************************************************************************
		common.validate_order_shipAdddress_Details_screenPay();

		// ************************************************************************************
		// line - 323 - Click COD as payment method and click Pay
		// ************************************************************************************
		common.select_payment_option_proceed_with_payment("COD");

		common.clickPayOrderOnPayScreen();

		// ************************************************************************************
		// line - 324 - validate the Survey Form
		// ************************************************************************************
		common.verify_handle_survey_popup();

		// ************************************************************************************
		// line - 328 - Validate Thank you page
		// ************************************************************************************
		assertTrue(DriverManager.getDriver().getTitle().contains("Thank you"));
		common.capture_orderID();

		Constant.dataMap.put("TimeStamp", util.getTimeStamp());
		util.writeToExcelLastRowFromMap("Sheet1", Constant.dataMap);

		// ************************************************************************************
		// line - 329 - Click Copy icon
		// ************************************************************************************
		ThankYou.get_copyOrderID().click();
		System.out.println("Copied Order ID");

		// ************************************************************************************
		// line - 330 - Click Track my order
		// ************************************************************************************
		ThankYou.get_linkTrackOrder().click();
		System.out.println("Clicked on Track Order link");

		// ************************************************************************************
		// line - 331 - Go to Order Tracker and Validate tracking Page
		// ************************************************************************************
		Thread.sleep(2000L);
		assertTrue(DriverManager.getDriver().getTitle().contains("Track Your Order"));

		common.insertDetailsOnTrackYourOrder();

		Thread.sleep(2500L);

		common.validateOrderDetails();

		// ************************************************************************************
		System.out.println("!!! Execution Completed !!!");

	}
}
