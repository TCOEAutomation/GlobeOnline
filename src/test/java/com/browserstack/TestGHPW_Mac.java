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

public class TestGHPW_Mac extends BrowserStackJUnitTest {
//public class TestGHPW_Mac {
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

	private static TestGHPW_Mac ghpwMac = new TestGHPW_Mac();
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

		Constant.dataMap.put("TestClassName", ghpwMac.getClass().getSimpleName());
		Constant.dataMap.put("OMT_LAS", "NOT FOUND");
		Constant.dataMap.put("OMT_DispositionStatus", "NOT FOUND");
		Constant.dataMap.put("OMT_UpdateDate", "NOT FOUND");
		Constant.dataMap.put("OMT_DateOrdered", "NOT FOUND");
		Constant.dataMap.put("OMT_EstimatedDayOfDelivery", "NOT FOUND");
		Constant.dataMap.put("OMT_OrderDetails", "NOT FOUND");
		Constant.dataMap.put("Magento_Details", "NOT FOUND");
		Constant.dataMap.put("Magento_OrderAccountInfo", "NOT FOUND");

		// ************************************************************************************
		// line - 456, 457
		// ************************************************************************************
		System.out.println("Execution started for browser : " + common.getBrowserName());

		DriverManager.getDriver().get("https://onlineuat.globe.com.ph/port-number");
//		DriverManager.getDriver().get("https://onlinepreprod.globe.com.ph/");

		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Globe Online");

		common.acceptCookies();

		// ************************************************************************************
		// line - 458 - Click Home Prepaid Wifi on navigation Bar
		// ************************************************************************************
		common.clickBuyLinkOnHeader();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Home Prepaid WiFi");

		// ************************************************************************************
		// line - 459 - Click Buy for Globe At Home Prepaid WiFi
		// ************************************************************************************
		if (LP.isClickable("buyNow", 10)) {
			Thread.sleep(2000L);
			LP.get_buyNow().click();
			System.out.println("Clicked button - Buy now");
		} else {
			System.out.println("FAIL : could not click Buy now button");
		}

		// ************************************************************************************
		// line - 460 - Validate checkout Page
		// ************************************************************************************
		if (checkout.isElementExist("Heading - Checkout", "hdrCheckout", 10)) {
			System.out.println("Waiting... for checkout page to load");
		} else {
			System.out.println("Failed to load checkout page");
		}

		assertTrue(DriverManager.getDriver().getTitle().contains("Checkout"));
		System.out.println("Validated title : Checkout");

		// ************************************************************************************
		// line - 461 - Enter Non-Gcash Number
		// line 462 - Click Standard Checkout
		// ************************************************************************************
		checkout.scroll_vertical(1000);

		common.insert_phoneNo_select_checkout_option(Constant.insufficient_gCash_number, "StandardCheckout");
		System.out.println("Insufficient Gcash number inserted : " + Constant.insufficient_gCash_number);
		common.handle_and_insert_OTP();

		// ************************************************************************************
		// line - 463 - Validate DAF form
		// ************************************************************************************
		assertTrue(DriverManager.getDriver().getTitle().contains("Form"));

		// ************************************************************************************
		// line - 464 to 470 - Validate Application Form and enter details
		// ************************************************************************************
		common.insert_personal_info_on_form("praveen1982qa@gmail.com", "Standard Checkout");

		if (Form.isClickable("rBtn_condominium", 10)) {
			common.insert_address_details_Condominium();

			String zipCOde = Form.get_zipCode().getAttribute("value");
			if (zipCOde == null || zipCOde.isEmpty()) {
				System.out.println("FAIL : ZIP Code -  is blank");
			} else {
				System.out.println("ZIP Code is pre-populated : " + zipCOde);
			}

			LP.scroll_vertical(5000);
			if (common.getBrowserName().toUpperCase().contains("SAFARI")) {
				common.toggle_and_select_terms_checkboxes();
			} else {
				Thread.sleep(2000L);
				common.validate_termsConditions_checkbox_toggle();
				Thread.sleep(2000L);
				common.select_chkbx_acceptAllTerms();
			}

//			LP.scroll_vertical(5000);
			common.click_pay_btn_on_form();
		}

		// ************************************************************************************
		// line - 476 - Click GCash
		// line - 477 - Enter GCash with Insufficient Balance
		// line - 478 - Validate "Try another payment options"
		// ************************************************************************************
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");
		common.select_payment_option_proceed_with_payment("GCash");
		common.clickPayOrderOnPayScreen();

		if (ThankYou.isElementExist("Sorry, your purchase was declined.", "msgPurchaseDeclined", 30)) {
			ThankYou.scroll_vertical(300);
			if (ThankYou.isClickable("tryDifferentPayment", 5)) {
				ThankYou.get_tryDifferentPayment().click();
				Thread.sleep(1500L);
				System.out.println("Clicked on Try different payment option");
				util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");
			} else {
				System.out.println("FAIL: Try different payment button is not clickable");
			}
		} else {
			System.out.println("Purchase declined messagge do not appear.");
			Thread.sleep(1500L);
			util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");
		}

		// ************************************************************************************
		// line - 479 - select Over the Counter (OTC)
		// line - 480 - Click on Pay Over the Counter
		// line - 481 - Click on Find the nearest ECPay near me
		// line - 482 - Click Pay button
		// ************************************************************************************
		Pay.scroll_vertical(400);
		common.select_payment_option_proceed_with_payment("OTC");
		common.validate_overTheCounter_payment_notification();

		String merchantURL = common.verifyAccreditedECPayMerchants();
		assertTrue(merchantURL.contains("ecpay-merchants.html"));
		System.out.println("'Accredited ECPay Merchants' page validated");

		common.clickPayOrderOnPayScreen();

		// ************************************************************************************
		// line - 471 to 473 - validate the Survey Form
		// ************************************************************************************
		common.verify_handle_survey_popup();

		assertTrue(DriverManager.getDriver().getTitle().contains("Thank you"));
		common.capture_orderID();

		Constant.dataMap.put("TimeStamp", util.getTimeStamp());
		util.writeToExcelLastRowFromMap("Sheet1", Constant.dataMap);

		// ************************************************************************************
		System.out.println("!!! Execution Completed !!!");

	}
}
