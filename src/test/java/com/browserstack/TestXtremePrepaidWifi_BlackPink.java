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
import com.pages.PayPage;
import com.pages.ProductComparatorPage;
import com.pages.ThankYouPage;

public class TestXtremePrepaidWifi_BlackPink extends BrowserStackJUnitTest {
//public class TestXtremePrepaidWifi_BlackPink {
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

	private static TestXtremePrepaidWifi_BlackPink xtreme_blackPink = new TestXtremePrepaidWifi_BlackPink();
	private util util = new util();
	private CommonMethods common = new CommonMethods();

	private LandingPage LP = new LandingPage();
	private ProductComparatorPage PC = new ProductComparatorPage();
	private CheckoutPage checkout = new CheckoutPage();
	private FormPage Form = new FormPage();
	private PayPage Pay = new PayPage();
	private ThankYouPage ThankYou = new ThankYouPage();

	@Test
	public void testXtremeWifiBlankPink() throws Exception {

		String cashoutAmount_checkout = "";
		String shipping = "";
		String totalAmount = "";

		Constant.dataMap.put("TestClassName", xtreme_blackPink.getClass().getSimpleName());
		Constant.dataMap.put("OMT_LAS", "NOT FOUND");
		Constant.dataMap.put("OMT_DispositionStatus", "NOT FOUND");
		Constant.dataMap.put("OMT_UpdateDate", "NOT FOUND");
		Constant.dataMap.put("OMT_DateOrdered", "NOT FOUND");
		Constant.dataMap.put("OMT_EstimatedDayOfDelivery", "NOT FOUND");
		Constant.dataMap.put("OMT_OrderDetails", "NOT FOUND");
		Constant.dataMap.put("Magento_Details", "NOT FOUND");
		Constant.dataMap.put("Magento_OrderAccountInfo", "NOT FOUND");

		// ************************************************************************************
		// line - 362
		// ************************************************************************************
		DriverManager.getDriver().get("https://onlineuat.globe.com.ph/port-number");
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Globe Online");

		common.acceptCookies();

		// ************************************************************************************
		// line - 363
		// ************************************************************************************
		LP.isElementExist("Link Globe logo", "link_LogoGlobe", 10);
		LP.isElementExist("Menu bar link - Apply", "link_Apply", 10);
		LP.isElementExist("Menu bar link - Renew", "link_Renew", 10);
		// b.1) Gallery - Not Covered
		LP.isElementExist("Menu bar link - Switch", "link_Switch", 10);
		LP.isElementExist("Menu bar link - Help", "link_Help", 10);
		LP.isElementExist("Menu bar link - Cart Icon", "CartIcon", 10);
		LP.isElementExist("Menu bar link - Track my order", "link_TrackMyOrder", 10);

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

		// ************************************************************************************
		// line - 364 - Validate and click Xtreme Home Prepaid WiFi Landing Page
		// ************************************************************************************
		if (LP.isClickable("link_XtremeHomePrepaidWiFi", 5)) {
			LP.clickOnElement("Link", "Xtreme Home Prepaid WiFi", "link_XtremeHomePrepaidWiFi");
			Thread.sleep(2000L);
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Xtreme Home Prepaid WiFi");

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
		// line - 365 - Validate All banner for XHPW
		// ************************************************************************************

		// ************************************************************************************
		// line 366, 367, 368
		// Click Highlight tab - validation not covered, need clarity
		// Click Feature tab - validation not covered, need clarity
		// Click Specifications - validation not covered, need clarity
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

		if (LP.isElementExist("Header - Specifications", "link_specifications", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_specifications", 5)) {
				LP.clickOnElement("Link", "Specifications", "link_specifications");
			}
		}

		// ************************************************************************************
		// line 369 - Validate Product Comparator/Specification
		// line 370 - Validate Delivery Caveat in Compare Section
		// ************************************************************************************
		common.validate_product_specification("Xtreme Home Prepaid WiFi");

		// ************************************************************************************
		// line 371 - Validate and click Buy Now button
		// ************************************************************************************
//		PC.scroll_vertical(1200);
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			Thread.sleep(500L);
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// ************************************************************************************
		// line 372 - Click BUY Nav and Choose BlackPink
		// line 373 - Validate BlackPink Prepaid WiFi landing page
		// ************************************************************************************
		if (LP.isElementExist("Menu bar link - Buy", "link_MenuBuy", 10)) {
			Thread.sleep(1000L);
			LP.moveToElement("menuBuy");
			Thread.sleep(3000L);
			System.out.println("Moved to Buy icon on menu bar");
		}

		if (LP.isClickable("link_BLACKPINKLimitedEdition", 5)) {
			LP.clickOnElement("Link", "BLACKPINK Limited Edition", "link_BLACKPINKLimitedEdition");
			Thread.sleep(2000L);
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(),
				"BLACKPINK Prepaid WiFi LTE-Advanced");

		// ************************************************************************************
		// line 374 - Validate and click BlackPink Landing Page
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
		// line 375 - Validate All banner for BlackPink - Not Covered
		// ************************************************************************************

		// ************************************************************************************
		// line 376, 377, 378
		// Click Highlight tab - validation not covered, need clarity
		// Click Feature tab - validation not covered, need clarity
		// Click Specifications - validation not covered, need clarity
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

		if (LP.isElementExist("Header - Specifications", "link_specifications", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_specifications", 5)) {
				LP.clickOnElement("Link", "Specifications", "link_specifications");
			}
		}

		// ************************************************************************************
		// line 379 - Validate Product Comparator/Specification
		// ************************************************************************************
		common.validate_product_specification("BLACKPINK Prepaid WiFi");

		// ************************************************************************************
		// line 380 - Validate and click Express Checkout button for BPHPW
		// ************************************************************************************
		//PC.scroll_vertical(1200);
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			Thread.sleep(500L);
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// ************************************************************************************
		// line - 381 - Validate Express Checkout Page
		// ************************************************************************************
		System.out.println("********* Checkout Page ************");
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

		Constant.dataMap.put("OMT_ProductQty", dataMap_qty.substring(2));
		Constant.dataMap.put("Magento_ItemsOrdered", dataMap_qty.substring(2));
		Constant.dataMap.put("OMT_AmountPaid", totalAmount);
		Constant.dataMap.put("Magento_OrderTotal", totalAmount);

		common.validateTotalAMount(cashoutAmount_checkout, shipping, totalAmount);

		// ************************************************************************************
		// line 382 - Validate Order Details
		// ************************************************************************************
		System.out.println("*********  Order details ************");
		common.validate_order_details_on_checkout();

		// ************************************************************************************
		// line 383 - Enter valid Promo code - Not Covered
		// ************************************************************************************
		common.applyPromoCodeOnCheckout();

		// ************************************************************************************
		// line 384 - Enter mobile number
		// line 385 - Click Proceed with Standard Checkout
		// ************************************************************************************
		checkout.scroll_vertical(400);
		common.insert_phoneNo_select_checkout_option("09270004201", "StandardCheckout");

		// ************************************************************************************
		// line 386 - Receive SMS for OTP
		// line 387 - Enter valid OTP code
		// ************************************************************************************
		common.handle_and_insert_OTP();

		// ************************************************************************************
		// line 388 - Validate Products in the bag displayed in the top section
		// ************************************************************************************
		String omt_pName = "";
		for (int i = 0; i < Form.get_topSectionProductsName().size(); i++) {
			String topSection_pName = Form.get_topSectionProductsName().get(i).getText();
			System.out.println("Form-TopSection-ProductName : " + topSection_pName);
			System.out.println("Form-TopSection-Price : " + Form.get_topSectionProductsPrice().get(i).getText());

			omt_pName = omt_pName.concat(" | ").concat(topSection_pName);
		}

		Constant.dataMap.put("OMT_ProductName", omt_pName.substring(2));

		// ************************************************************************************
		// line 389 - Go back to DAF form
		// ************************************************************************************
		if (Form.isClickable("reviewBag", 5)) {
			Form.clickOnElement("Button", "Review my bag", "reviewBag");
		}

		checkout.scroll_vertical(500);
		Thread.sleep(1000);
		if (checkout.isClickable("StanCheckout", 5)) {
			checkout.get_standardCheckout().click();
			checkout.scroll_vertical(200);
			System.out.println("Form-Prefilled Mobile No : " + Form.getAttributeValue("mobileNumber", "value"));
		}

		// ************************************************************************************
		// line 390 to 395- Validate Application Form
		// ************************************************************************************
		common.insert_personal_info_on_form("praveen1982qa@gmail.com", "StandardCheckout");

		/// ************************************************************************************
		// line 396 to 399 - Select toggle button for 'im giving this gift'
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
		// line 400 to 406 - Toggle home
		// ************************************************************************************
		common.insert_address_details_House();

		// ************************************************************************************
		// line 407 - Validate Postal Code
		// ************************************************************************************
		String zipCOde = Form.get_zipCode().getAttribute("value");
		if (zipCOde == null || zipCOde.isEmpty()) {
			System.out.println("FAIL : ZIP Code -  is blank");
		} else {
			System.out.println("ZIP Code is pre-populated : " + zipCOde);
		}

		// ************************************************************************************
		// line 408 - Validate delivery caveat
		// ************************************************************************************
		Form.scroll_vertical(350);
		if (Form.check_AttirbuteNotEmpty("imgSameDayDelivery", "src", 10)) {
			if (Form.getAttributeValue("imgSameDayDelivery", "src").contains("active")) {
				System.out.println("Same day delivery toggle is auto - selected");
			} else {
				System.out.println("FAIL : Same day delivery toggle is not auto - selected");
			}
		}

		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_1"));
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_2"));

		// ************************************************************************************
		// line 409 to 414 - Toggle Billing and Collection of Fees
		// ************************************************************************************
		LP.scroll_vertical(5000);
		Thread.sleep(2000L);
		common.validate_termsConditions_checkbox_toggle();
		common.select_chkbx_acceptAllTerms();

		// ************************************************************************************
		// line 415 - Click pay button
		// ************************************************************************************
		common.click_pay_btn_on_form();

		// ************************************************************************************
		// line 416 - validate Payment page
		// ************************************************************************************
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");

		Pay.scroll_vertical(1000);
		common.validate_paymentOptionsOnPayScreen();

		// ************************************************************************************
		// line 417 - Validate order details
		// Promo code step - Not Covered
		// ************************************************************************************
		common.validate_order_shipAdddress_Details_screenPay();
		System.out.println("Promo Code : " + Pay.get_promoCode().getText());
		
		
		

		// ************************************************************************************
		// line 418 - select Over the Counter (OTC)
		// ************************************************************************************
		common.select_payment_option_proceed_with_payment("OTC");

		// ************************************************************************************
		// line 419 - Click on Pay Over the Counter
		// ************************************************************************************
		common.validate_overTheCounter_payment_notification();

		// ************************************************************************************
		// line 420 - Click on Find the nearest ECPay near me
		// ************************************************************************************
		String merchantURL = common.verifyAccreditedECPayMerchants();
		assertTrue(merchantURL.contains("ecpay-merchants.html"));
		System.out.println("'Accredited ECPay Merchants' page validated");

		// ************************************************************************************
		// line 421 - Click Pay button
		// ************************************************************************************
		common.clickPayOrderOnPayScreen();

		// ************************************************************************************
		// line 422 to 424 - validate the Survey Form
		// line 430 - validate referrence number
		// ************************************************************************************
		common.verify_handle_survey_popup();

		assertTrue(DriverManager.getDriver().getTitle().contains("Thank you"));
		common.capture_orderID();

		Constant.dataMap.put("TimeStamp", util.getTimeStamp());
		util.writeToExcelLastRowFromMap("Sheet1", Constant.dataMap);

		// ************************************************************************************
		// line 428 - Click Print icon
		// line 429 - Validate printed Purchase summary - Not Covered
		// ************************************************************************************
		ThankYou.isElementExist("Print Icon", "printIcon", 5);
		// add code to click print icon

		// ************************************************************************************
		// line 431 - Click copy icon
		// ************************************************************************************
		ThankYou.get_copyOrderID().click();
		System.out.println("Copied Order ID");

		// ************************************************************************************
		// line 432 - Validate popup msg for copy icon
		// ************************************************************************************
		ThankYou.isElementExist("Copy Refrerence Number Success Message", "copyRefrerenceNoSuccessMsg", 5);

		// ************************************************************************************
		// line 433 - Validate purchase summary
		// line 434 - Validate item ordered
		// line 435 - validate reminder
		// ************************************************************************************
		common.validate_purchaseSummaryDetails();

		// ************************************************************************************
		System.out.println("!!! Execution Completed !!!");

	}
}
