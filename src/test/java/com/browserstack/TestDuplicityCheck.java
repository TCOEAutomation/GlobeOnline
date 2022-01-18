package com.browserstack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.ExtentListeners.ExtentManager;
//import com.ExtentListeners.ExtentTestManager;
import com.browserstack.Constant;
import com.pages.BasePage;
import com.pages.CheckoutPage;
import com.pages.FormPage;
import com.pages.LandingPage;
import com.pages.PayPage;

//public class TestDuplicityCheck extends BrowserStackJUnitTest {

	// ***********************************************************************************************************************
public class TestDuplicityCheck {
	private WebDriver driver;

	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();

		DriverManager.setWebDriver(driver);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
//		String browserName = cap.getBrowserName().toUpperCase();
//
//		ExtentTestManager.startTest(browserName + " : Test Name : ");
//		ExtentTestManager.logInfo("Execution started for : ");
//		ExtentTestManager.logInfo("Browser Launched : " + browserName);
	}

	@After
	public void tearDown() {
//		ExtentTestManager.logInfo("Execution Finished");
//		ExtentManager.getReporter().flush();
	}
	// ***********************************************************************************************************************

	private static TestDuplicityCheck duplicityCheck = new TestDuplicityCheck();

	private util util = new util();
	private CommonMethods common = new CommonMethods();
	private LandingPage LP = new LandingPage();
	private CheckoutPage checkout = new CheckoutPage();
	private FormPage Form = new FormPage();
	private PayPage Pay = new PayPage();

	private String cashoutAmount_checkout = "";
	private String shipping = "";
	private String totalAmount = "";

	@Test
	public void testDuplicityCheck() throws Exception {

		String[] payOptions = { "StandardCheckout", "GCash" };

		DriverManager.getDriver().get("https://onlineuat.globe.com.ph/port-number");
//		DriverManager.getDriver().get("https://onlinepreprod.globe.com.ph/");
		System.out.println("In SampleTest");
		assertTrue(DriverManager.getDriver().getTitle().contains("Globe Online"));
		System.out.println("Validated title : Globe Online");

		// line 502
		if (LP.isElementExist("Cookies Notification", "cookiesNotification", 10)) {
			LP.get_privacyAccept().click();
			System.out.println("Clicked on 'Privacy - I accept' button");
		}

		for (int i = 0; i < payOptions.length; i++) {

			Constant.dataMap.put("TestClassName", duplicityCheck.getClass().getSimpleName());
			Constant.dataMap.put("OMT_LAS", "NOT FOUND");
			Constant.dataMap.put("OMT_DispositionStatus", "NOT FOUND");
			Constant.dataMap.put("OMT_UpdateDate", "NOT FOUND");
			Constant.dataMap.put("OMT_DateOrdered", "NOT FOUND");
			Constant.dataMap.put("OMT_EstimatedDayOfDelivery", "NOT FOUND");
			Constant.dataMap.put("OMT_OrderDetails", "NOT FOUND");
			Constant.dataMap.put("Magento_Details", "NOT FOUND");
			Constant.dataMap.put("Magento_OrderAccountInfo", "NOT FOUND");

			// line 503
			common.select_LTE_Advanced_on_home_page();

			assertTrue(DriverManager.getDriver().getTitle().contains("LTE-Advanced"));
			System.out.println("Validated title : LTE-Advanced");

			/**********************************************************************************************/
			// line 504, 505
			String userGuideTitle = common.verifyUserGuideTitle();
			assertTrue(userGuideTitle.contains("LTE-ADVANCED-UserGuide.pdf"));
			System.out.println("PDF title validated : LTE-ADVANCED-UserGuide.pdf");

			if (LP.isClickable("buyNow", 10)) {
				Thread.sleep(2000L);
				LP.get_buyNow().click();
				System.out.println("Clicked button - Buy now");
			} else {
				System.out.println("FAIL : could not click Buy now button");
			}

			/**********************************************************************************************/
			// line - 506 - validate price strikethrough for the product
			// line - 507 - Add items to cart

			/**********************************************************************************************/

			// line - 508
			if (checkout.isElementExist("Heading - Checkout", "hdrCheckout", 10)) {
				System.out.println("Waiting... for checkout page to load");
			} else {
				System.out.println("Failed to load checkout page");
			}

			assertTrue(DriverManager.getDriver().getTitle().contains("Checkout"));
			System.out.println("Validated title : Checkout");

			System.out.println("*********  Express Checkout Page ************");
			System.out.println("Quantity : " + checkout.getText("quantity"));
			Constant.dataMap.put("OMT_ProductQty", checkout.getText("quantity"));
			Constant.dataMap.put("Magento_ItemsOrdered", checkout.getText("quantity"));

			System.out.println("Cashout Amount : " + checkout.getText("cashoutAmount"));
			cashoutAmount_checkout = checkout.getText("cashoutAmount");

			System.out.println("Shipping : " + checkout.getText("shipping"));
			shipping = checkout.getText("shipping");

			System.out.println("Total Amount : " + checkout.getText("totalAmount"));
			totalAmount = checkout.getText("totalAmount");
			Constant.dataMap.put("OMT_AmountPaid", totalAmount);
			Constant.dataMap.put("Magento_OrderTotal", totalAmount);

			common.validateTotalAMount(cashoutAmount_checkout, shipping, totalAmount);

			/**********************************************************************************************/
			// line - 509
			if (payOptions[i].equalsIgnoreCase("StandardCheckout")) {
				common.insert_phoneNo_select_checkout_option("09270004201", payOptions[i]);
			} else if (payOptions[i].equalsIgnoreCase("GCash")) {
				common.insert_phoneNo_select_checkout_option(Constant.gCash_number, payOptions[i]);
			}

			common.handle_and_insert_OTP();

			assertTrue(DriverManager.getDriver().getTitle().contains("Form"));

			System.out.println("Form-TopSection-ProductName : " + Form.getText("topSectionProductName"));
			Constant.dataMap.put("OMT_ProductName", Form.getText("topSectionProductName"));

			/**********************************************************************************************/
			// line - 510, 511
			common.insert_personal_info_on_form("praveen1982qa@gmail.com", payOptions[i]);

			if (Form.isClickable("rBtn_condominium", 10)) {
				common.insert_address_details_Condominium();
				common.select_chkbx_acceptAllTerms();
				common.click_pay_btn_on_form();
			}

			assertTrue(DriverManager.getDriver().getTitle().contains("Pay"));

			common.select_payment_option_proceed_with_payment(payOptions[i]);

			common.clickPayOrderOnPayScreen();
			Constant.dataMap.put("TimeStamp", util.getTimeStamp());

			common.verify_handle_survey_popup();

			assertTrue(DriverManager.getDriver().getTitle().contains("Thank you"));

			common.capture_orderID();

			Constant.dataMap.put("TimeStamp", util.getTimeStamp());
			util.writeToExcelLastRowFromMap("Sheet1", Constant.dataMap);

		}
		System.out.println("!!! Execution Completed !!!");

	}

	/********************************************************************************************************************************/

}