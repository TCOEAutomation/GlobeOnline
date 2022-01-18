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
import com.pages.ThankYouPage;

public class TestMultipleCartWithPromo extends BrowserStackJUnitTest {

////***********************************************************************************************************************
//public class TestMultipleCartWithPromo {
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
//	}
//
//	@After
//	public void tearDown() {
//	}
//	// ***********************************************************************************************************************

	private String invalid_GCash_No = "01234567890";

	private static TestMultipleCartWithPromo multipleCartWithPromo = new TestMultipleCartWithPromo();
	private util util = new util();
	private CommonMethods common = new CommonMethods();

	private LandingPage LP = new LandingPage();
	private ProductComparatorPage PC = new ProductComparatorPage();
	private CheckoutPage checkout = new CheckoutPage();
	private FormPage Form = new FormPage();
	private PayPage Pay = new PayPage();
	private ThankYouPage ThankYou = new ThankYouPage();

	@Test
	public void testMultipleCartWithPromo() throws Exception {

		String cashoutAmount_checkout = "";
		String shipping = "";
		String totalAmount = "";

		Constant.dataMap.put("TestClassName", multipleCartWithPromo.getClass().getSimpleName());
		Constant.dataMap.put("OMT_LAS", "NOT FOUND");
		Constant.dataMap.put("OMT_DispositionStatus", "NOT FOUND");
		Constant.dataMap.put("OMT_UpdateDate", "NOT FOUND");
		Constant.dataMap.put("OMT_DateOrdered", "NOT FOUND");
		Constant.dataMap.put("OMT_EstimatedDayOfDelivery", "NOT FOUND");
		Constant.dataMap.put("OMT_OrderDetails", "NOT FOUND");
		Constant.dataMap.put("Magento_Details", "NOT FOUND");
		Constant.dataMap.put("Magento_OrderAccountInfo", "NOT FOUND");

		// ************************************************************************************
		// line - 16
		// ************************************************************************************
		String url = "https://onlineuat.globe.com.ph/port-number";
		DriverManager.getDriver().get(url);
//		ExtentTestManager.logInfo("Launched Browser : " + url);
//		DriverManager.getDriver().get("https://onlinepreprod.globe.com.ph/");

		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Globe Online");

		// ************************************************************************************
		// line - 17
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

		// ************************************************************************************
		// line - 18, 19
		// ************************************************************************************
		common.acceptCookies();

		// ************************************************************************************
		// line - 20
		// ************************************************************************************
		common.clickBuyLinkOnHeader();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Home Prepaid WiFi");

		// ************************************************************************************
		// line - 21 - Validate GHPW Landing Page including
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
		// line - 22 - Validate All banner for GHPW - Not Covered
		// ************************************************************************************

		// ************************************************************************************
		// line - 23, 24, 25
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

		if (LP.isElementExist("Header - Compare", "link_compare", 10)) {
			Thread.sleep(1000L);
			if (LP.isClickable("link_compare", 5)) {
				LP.clickOnElement("Link", "Compare", "link_compare");
			}
		}

		// ************************************************************************************
		// line 26 - Validate Product compare section
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
		// line 27 - Validate and click Express Checkout button
		// ************************************************************************************
		PC.scroll_vertical(1200);
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			Thread.sleep(500L);
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// ************************************************************************************
		// line 28 - Hover on BUY nav
		// ************************************************************************************

		if (LP.isElementExist("Menu bar link - Buy", "link_MenuBuy", 10)) {
			Thread.sleep(2000L);
			checkout.moveToElement("btnPromoCode");
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
		// line 29 - Click TheBlackPink Edition
		// line 30 - Validate BPHPW Landing Page including
		// ************************************************************************************
		if (LP.isClickable("link_BLACKPINKLimitedEdition", 5)) {
			LP.clickOnElement("Link", "BLACKPINK Limited Edition", "link_BLACKPINKLimitedEdition");
			Thread.sleep(2000L);
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(),
				"BLACKPINK Prepaid WiFi LTE-Advanced");

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
		// line - 31 - Validate All banner for BPHPW
		// ************************************************************************************

		// ************************************************************************************
		// line -32, 33, 34
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
		// line - 35 - Validate Product compare section
		// ************************************************************************************
		common.validate_product_specification("BLACKPINK Prepaid WiFi");

		// ************************************************************************************
		// line -36 - Validate and click Express Checkout button
		// ************************************************************************************
		if (PC.isClickable("BuyNow_Checkout", 5)) {
			PC.clickOnElement("Button", "BuyNow/Checkout", "BuyNow_Checkout");
		}
		checkout.isElementExist("Header - Checkout", "hdrCheckout", 10);
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Checkout");

		// ************************************************************************************
		// line - 37 , Validate Express Checkout Page
		// ************************************************************************************

		System.out.println("*********  Express Checkout Page ************");
		Thread.sleep(2000L);
		checkout.scroll_vertical(400);
//				System.out.println("Quantity : " + checkout.getText("quantity"));

		int totalQuantity = 0;
		String dataMap_qty = "";
		for (int i = 0; i < checkout.get_quantities().size(); i++) {
			String pName = checkout.get_productsName().get(i).getText();
			String qty = checkout.get_quantities().get(i).getText();
			totalQuantity = totalQuantity + Integer.parseInt(qty);
			System.out.println("For product : " + pName + " Quantity is : " + qty);
			dataMap_qty = dataMap_qty.concat(" | ").concat(qty);
		}

//				Constant.dataMap.put("OMT_ProductQty", checkout.getText("quantity"));
//				Constant.dataMap.put("Magento_ItemsOrdered", checkout.getText("quantity"));
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

		// ************************************************************************************
		// line - 38, Validate Order Details
		// line - 39 - Validate Delivery caveat
		// ************************************************************************************
		System.out.println("*********  Order details ************");
		common.validate_order_details_on_checkout();

		// ************************************************************************************
		// line - 40 - Validate What is GCash
		// ************************************************************************************
		checkout.scroll_vertical(400);
		common.verifyWhatIsGCash();

		// ************************************************************************************
		// line - 41 : Click + : Should be disable if quantity reach maximum qty of 2
		// ************************************************************************************
		common.verifyAddQuantityDisbaledOnCheckout(totalQuantity);

		// ************************************************************************************
		// line - 42 - Click x
		// ************************************************************************************
		checkout.scroll_vertical(-300);
		Thread.sleep(3000L);
		common.btnCloseToRemoveProductFromCheckout();
		Thread.sleep(3000L);

		// ************************************************************************************
		// line - 43 - Pre-requisite: Add removed the product
		// ************************************************************************************

		Thread.sleep(1000L);

		if (LP.isElementExist("Menu bar link - Buy", "link_MenuBuy", 10)) {
			Thread.sleep(2000L);
			checkout.moveToElement("btnPromoCode");
			Thread.sleep(2000L);
			LP.moveToElement("menuBuy");
			Thread.sleep(2000L);
			System.out.println("Moved to Buy icon on menu bar");

			if (LP.isClickable("link_GlobeAtHomePrepaidWiFi", 5)) {
				LP.clickOnElement("Link", "Globe At Home Prepaid WiFi", "link_GlobeAtHomePrepaidWiFi");
				Thread.sleep(2000L);
			}
		}

		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Home Prepaid WiFi");

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
		// line - 44, 45, 46 - Clcik the link on "Got a promo code. Click Here"
		// ************************************************************************************
		common.verify_invalid_and_valid_promo_code();

		// ************************************************************************************
		// line - 47 - Input invalid mobile number
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
		// line - 48 - Input gcash mobile number
		// ************************************************************************************
		System.out.println("Validation for correct GCash number");
		checkout.scroll_vertical(400);
		common.insert_phoneNo_select_checkout_option(Constant.insufficient_gCash_number, "GCash");

		// ************************************************************************************
		// line - 50 - Validate OTP prompt
		// ************************************************************************************
		if (checkout.isElementExist("Text OTP", "otpText", 30)) {
			System.out.println("Navigated to screen to insert OTP");
		}
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "One-Time Password");

		// ************************************************************************************
		// line - 52 - Click resend code after "Resend code" button is enabled
		// ************************************************************************************
		common.resendOTP();

		// ************************************************************************************
		// line - 53 - Enter OTP
		// ************************************************************************************
		common.handle_and_insert_OTP();

		// ************************************************************************************
		// line - 54 - Validate and click bag displayed in the top section
		// ************************************************************************************
		Form.isElementExist("Form-Top Section-Image-Product - GHPW", "topSectionImgGHPW", 10);
		Form.isElementExist("Form-Top Section-Image-Product - BlackPink", "topSectionImgBlackPink", 10);

		String omt_pName = "";
		for (int i = 0; i < Form.get_topSectionProductsName().size(); i++) {
			String topSection_pName = Form.get_topSectionProductsName().get(i).getText();
			System.out.println("Form-TopSection-ProductName : " + topSection_pName);
			System.out.println("Form-TopSection-Price : " + Form.get_topSectionProductsPrice().get(i).getText());

			omt_pName = omt_pName.concat(" | ").concat(topSection_pName);
		}

		Constant.dataMap.put("OMT_ProductName", omt_pName.substring(2));

		// ************************************************************************************
		// line - 55 - Go back to DAF form
		// ************************************************************************************
		Form.scroll_vertical(200);
		System.out.println("Form-Prefilled Mobile No : " + Form.getAttributeValue("mobileNumber", "value"));

		// ************************************************************************************
		// line - 56 - Click Review my bag
		// ************************************************************************************
		if (Form.isClickable("reviewBag", 5)) {
			Form.clickOnElement("Button", "Review my bag", "reviewBag");
			Thread.sleep(1500L);
		}

		// ************************************************************************************
		// line - 57 - Go back to DAF form
		// ************************************************************************************
		checkout.scroll_vertical(500);
		Thread.sleep(1000);
		if (checkout.isClickable("btnGcashCheckout", 5)) {
			checkout.get_gcashCheckout().click();
		}

		Form.scroll_vertical(200);
		System.out.println("Form-Prefilled Mobile No : " + Form.getAttributeValue("mobileNumber", "value"));

		// ************************************************************************************
		// line - 58 - Validate Application Form
		// ************************************************************************************
		Form.isElementExist("Form-Personal Information", "formPersonalInfo", 10);

		// ************************************************************************************
		// line - 59 to 62
		// ************************************************************************************
		common.insert_personal_info_on_form("praveen1982qa@gmail.com", "StandardCheckout");

		// ************************************************************************************
		// line - 63 to 69 - Validate Address field
		// ************************************************************************************
		common.insert_address_details_House();

		// ************************************************************************************
		// line - 70 - Validate Postal Code
		// ************************************************************************************
		String zipCOde = Form.get_zipCode().getAttribute("value");
		if (zipCOde == null || zipCOde.isEmpty()) {
			System.out.println("FAIL : ZIP Code -  is blank");
		} else {
			System.out.println("ZIP Code is pre-populated : " + zipCOde);
		}

		// ************************************************************************************
		// line - 71 - validate Next day delivery
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
		// line - 72 - Validate delivery caveat
		// ************************************************************************************
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_1"));
		System.out.println("Text - 1 : Delivery Caveat : " + Form.getText("txtdeliveryCaveat_2"));

		// ************************************************************************************
		// line - 73 - Enter special instructions
		// ************************************************************************************
		String specialInstruct = "testSpecialInstruction";
		if (Form.isElementExist("Enter special instructions", "specialInstruction", 5)) {
			Form.get_specialInstruction().sendKeys(specialInstruct);
			System.out.println("Inserted special Instruction : " + specialInstruct);
		} else {
			System.out.println("FAIL: special Instruction field do not exist");
		}

		// ************************************************************************************
		// line - 74 - Validate MAP / Pin location - not covered
		// ************************************************************************************

		// ************************************************************************************
		// line - 75 to 81 - Checked i accept all terms and conditions
		// ************************************************************************************
		LP.scroll_vertical(5000);
		Thread.sleep(2000L);
		common.validate_termsConditions_checkbox_toggle();
		common.select_chkbx_acceptAllTerms();

		// ************************************************************************************
		// line - 82 - Click Pay
		// ************************************************************************************
		Thread.sleep(1500L);
		common.click_pay_btn_on_form();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");

		// ************************************************************************************
		// line - 83 - Click change address
		// ************************************************************************************
		Pay.scroll_vertical(800);
		common.validate_form_onClick_of_changeAddress("House");

		// ************************************************************************************
		// line - 84 to 87 - Select GCASH as Payment menthod then click pay and use
		// INSUFFICIENT GCASH number - Not covered
		// ************************************************************************************
		common.select_payment_option_proceed_with_payment("GCash");
		common.clickPayOrderOnPayScreen();
		
		if(ThankYou.isElementExist("Sorry, your purchase was declined.", "msgPurchaseDeclined", 30)) {
			if(ThankYou.isClickable("tryDifferentPayment", 5)) {
				ThankYou.get_tryDifferentPayment().click();
				System.out.println("Clicked on Try different payment option");
				util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");
			}else {
				System.out.println("FAIL: Try different payment button is not clickable");
			}
		}else {
			System.out.println("Purchase declined messagge do not appear.");
		}
		
		
		
		// ************************************************************************************
		// line - 88 - Validate Payment Page
		// ************************************************************************************
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");

		// ************************************************************************************
		// line - 89, 90 - Validate order details, shipping address
		// ************************************************************************************
		Pay.scroll_vertical(-500);
		common.validate_order_shipAdddress_Details_screenPay();

		// ************************************************************************************
		// line - 92 - Pay via CC
		// ************************************************************************************
		common.pay_via_creditCard();

		// ************************************************************************************
		// line - 93 to 96 - validate the Survey Form
		// ************************************************************************************
		Thread.sleep(5000L);
		common.verify_handle_survey_popup();

		// ************************************************************************************
		// line - 97 - Validate Thank you page
		// ************************************************************************************
		assertTrue(DriverManager.getDriver().getTitle().contains("Thank you"));
		common.capture_orderID();

		Constant.dataMap.put("TimeStamp", util.getTimeStamp());
		util.writeToExcelLastRowFromMap("Sheet1", Constant.dataMap);

		// ************************************************************************************
		// line - 98 - Click Copy icon
		// ************************************************************************************
		ThankYou.get_copyOrderID().click();
		System.out.println("Copied Order ID");

		// ************************************************************************************
		// line - 99 - Click Track my order
		// ************************************************************************************
		ThankYou.get_linkTrackOrder().click();
		System.out.println("Clicked on Track Order link");

		Thread.sleep(2000L);
		assertTrue(DriverManager.getDriver().getTitle().contains("Track Your Order"));

		common.insertDetailsOnTrackYourOrder();

		Thread.sleep(2500L);

		common.validateOrderDetails();

		// ************************************************************************************
		System.out.println("!!! Execution Completed !!!");

	}
}
