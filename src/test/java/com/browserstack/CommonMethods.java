package com.browserstack;

import java.security.Key;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.ExtentListeners.ExtentTestManager;
import com.pages.CheckoutPage;
import com.pages.FormPage;
import com.pages.LandingPage;
import com.pages.OrderDetailsPage;
import com.pages.PayPage;
import com.pages.ProductComparatorPage;
import com.pages.ThankYouPage;
import com.pages.TrackOrderPage;

public class CommonMethods {

	private util util = new util();

	private LandingPage LP = new LandingPage();
	private CheckoutPage checkout = new CheckoutPage();
	private FormPage Form = new FormPage();
	private PayPage Pay = new PayPage();
	private ThankYouPage ThankYou = new ThankYouPage();
	private ProductComparatorPage PC = new ProductComparatorPage();
	private TrackOrderPage TrackOrder = new TrackOrderPage();
	private OrderDetailsPage OrderDetails = new OrderDetailsPage();

	/********************************************************************************************************************************/
	public void insert_phoneNo_select_checkout_option(String phoneNo, String checkoutOption)
			throws InterruptedException {

		checkout.get_mobileNumber().clear();
		checkout.get_mobileNumber().sendKeys(phoneNo);
		System.out.println("Inserted mobile no : " + phoneNo);
		Constant.dataMap.put("OMT_MobileNumber", phoneNo);
		checkout.scroll_vertical(600);

		if (checkoutOption.equalsIgnoreCase("StandardCheckout")) {
			if (checkout.isClickable("StanCheckout", 10)) {
				checkout.get_standardCheckout().click();
				System.out.println("Clicked on Standard Checkout");
			}

		} else if (checkoutOption.equalsIgnoreCase("GCash")) {

			if (checkout.isElementExist("Button - Gcash Checkout", "gcashCheckout", 10)) {
				checkout.get_gcashCheckout().click();
				System.out.println("Clicked on gcash Pay");
			}
		}
	}

	/********************************************************************************************************************************/
	public void handle_and_insert_OTP() {
		if (checkout.isElementExist("Text OTP", "otpText", 30)) {
			for (int j = 0; j < checkout.get_OTP().size(); j++) {
				checkout.get_OTP().get(j).sendKeys(String.valueOf(j + 1));
			}
			System.out.println("Inserted OTP");
		}

		if (Form.isElementExist("Heading - Form", "hdrForm", 10)) {
			System.out.println("Waiting... for FORM page to load");
		}

		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Form");
	}

	/********************************************************************************************************************************/
	public void validateTotalAMount(String cashoutAmt, String shipping, String totalAmt) {

		float iCashoutAmt = 0;
		float iShipping = 0;
		float itotalAmt = 0;

		cashoutAmt = (String) cashoutAmt.subSequence(1, cashoutAmt.length());
		iCashoutAmt = Float.valueOf(cashoutAmt.replace(",", ""));

		if (shipping.equalsIgnoreCase("free")) {
			iShipping = 0;
		} else {
			shipping = (String) shipping.subSequence(1, shipping.length());
			iShipping = Float.valueOf(shipping.replace(",", ""));
		}

		totalAmt = (String) totalAmt.subSequence(1, totalAmt.length());
		itotalAmt = Float.valueOf(totalAmt.replace(",", ""));

		if (itotalAmt == (iCashoutAmt + iShipping)) {
			System.out.println("Total Amount is same as Cashout + Shipping :" + itotalAmt);
		} else {
			System.out.println("Total Amount is not same as Cashout + Shipping. Total :" + itotalAmt
					+ " - CaShout+Shipping : " + (iCashoutAmt + iShipping));
		}
	}

	/********************************************************************************************************************************/
	public void insert_personal_info_on_form(String email, String payOption) throws InterruptedException {
		Form.scroll_vertical(25);
		if (payOption.equalsIgnoreCase("GCash")) {
			Thread.sleep(8000L);
		} else {
			Thread.sleep(2000L);
		}

		Form.get_firstName().clear();
		Form.get_firstName().sendKeys("TestF");
		System.out.println("First Name : TestF");
		Form.get_middleName().clear();
		Form.get_middleName().sendKeys("TestM");
		System.out.println("Middle Name : TestM");
		Form.get_lastName().clear();
		Form.get_lastName().sendKeys("TestL");
		System.out.println("Last Name : TestL");
		Form.get_email().clear();
		Form.get_email().sendKeys(email);
		System.out.println("Email : " + email);

		Constant.dataMap.put("OMT_CustomerDetails", "TestF - TestM - TestL - " + email);

		Form.scroll_vertical(450);
		Thread.sleep(1500L);
	}

	/********************************************************************************************************************************/
	public void insert_address_details_Condominium() throws InterruptedException {
		// LP.get_condominium().click();
		Form.javascript_clickCondominium();
		System.out.println("Selected radio button : Condominium");

		System.out.println(
				"Condominium Signal Strength Warning Text 1 : " + Form.get_SignalStrengthWarning().get(0).getText());
		System.out.println(
				"Condominium Signal Strength Warning Text 2 : " + Form.get_SignalStrengthWarning().get(1).getText());

		Form.scroll_vertical(375);
		Thread.sleep(2000L);

		Form.get_floor().sendKeys("10");
		System.out.println("Floor : 10");

		Form.get_buildingName().sendKeys("Test");
		System.out.println("Building Name : Test");

		Form.get_street().sendKeys("Test");
		System.out.println("Street : Test");

		Form.select_province("METRO MANILA");
		System.out.println("Province : METRO MANILA");
		
		Form.select_city("MANILA CITY (BINONDO)");
		System.out.println("City : MANILA CITY (BINONDO)");
		
		Form.select_barangay("Barangay 290");
		System.out.println("Barangay : Barangay 290");
		Thread.sleep(1000L);

		Constant.dataMap.put("OMT_ShippingAddress",
				"10 - Test - Test - METRO MANILA - MANILA CITY (BINONDO) - Barangay 290");
		Constant.dataMap.put("OMT_AddressDetails",
				"10 - Test - Test - METRO MANILA - MANILA CITY (BINONDO) - Barangay 290");
		Constant.dataMap.put("Magento_AddressInformation",
				"10 - Test - Test - METRO MANILA - MANILA CITY (BINONDO) - Barangay 290");
	}

	/********************************************************************************************************************************/
	public void insert_address_details_House() throws InterruptedException {
		// LP.get_condominium().click();
		Form.javascript_clickRadioBtn_House();
		System.out.println("Selected radio button : House");

		Form.scroll_vertical(275);
		Thread.sleep(2000L);

		Form.get_house().sendKeys("100");
		System.out.println("House : 100");

		Form.get_street().sendKeys("Test");
		System.out.println("Street : Test");

		Form.get_village_subDivision().sendKeys("Test");
		System.out.println("Village/SubDivision : Test");

		Form.select_province("METRO MANILA");
		Form.select_city("MANILA CITY (BINONDO)");
		Form.select_barangay("Barangay 290");
		Thread.sleep(1000L);

		Constant.dataMap.put("OMT_ShippingAddress",
				"10 - Test - Test - METRO MANILA - MANILA CITY (BINONDO) - Barangay 290");
		Constant.dataMap.put("OMT_AddressDetails",
				"10 - Test - Test - METRO MANILA - MANILA CITY (BINONDO) - Barangay 290");
		Constant.dataMap.put("Magento_AddressInformation",
				"10 - Test - Test - METRO MANILA - MANILA CITY (BINONDO) - Barangay 290");
	}

	/********************************************************************************************************************************/
	public void select_chkbx_acceptAllTerms() throws InterruptedException {
		LP.scroll_vertical(5000);
		Thread.sleep(2000L);

		if (Form.isElementExist("Checkbox - Accept All", "chkbx_acceptAll", 10)) {
			Form.get_checkbox_acceptAll().click();
			Thread.sleep(2000L);
		}
	}

	/********************************************************************************************************************************/
	public void click_pay_btn_on_form() {
		if (Form.isClickable("Pay", 10)) {
			Form.get_btnPay().click();
			System.out.println("Clicked on Pay button on Form page");

			if (Pay.isElementExist("Heading - Pay", "hdrPay", 10)) {
				System.out.println("Waiting... for PAY page to load");
			}
		}
	}

	/********************************************************************************************************************************/
	public void select_payment_option_proceed_with_payment(String payOption) throws InterruptedException {

		if ((payOption.equalsIgnoreCase("StandardCheckout")) || (payOption.equalsIgnoreCase("COD"))) {
			Pay.scroll_vertical(400);
			Pay.get_cod().click();
			System.out.println("Selected COD on Pay page");
			payOption = "COD";

		} else if (payOption.equalsIgnoreCase("GCash")) {
			Pay.get_payOpt_Gcash().click();
			System.out.println("Selected Gcash on Pay page");

		} else if (payOption.equalsIgnoreCase("OTC")) {
			Pay.get_payOpt_overTheCounter().click();
			System.out.println("Selected Over The Counter (OTC) on Pay page");
		} else if (payOption.equalsIgnoreCase("Card")) {
			Pay.get_payOpt_VisaMasterCard().click();
			System.out.println("Selected Visa/MasterCard on Pay page");
		}

		Constant.dataMap.put("OMT_PaymentMethodUsed", payOption);
		Constant.dataMap.put("OMT_PaymentDetails", payOption);
		Constant.dataMap.put("Magento_PaymentShippingMethod", payOption);

		Pay.scroll_vertical(2500);
		Thread.sleep(2000L);

//		if (Pay.isClickable("payOrder", 10)) {
//			Pay.get_payOrder().click();
//			System.out.println("Clicked on pay on payment page");
//		} else {
//			System.out.println("Fail : to click on pay button on payment page");
//		}
	}

	/********************************************************************************************************************************/
	public void verify_handle_survey_popup() throws InterruptedException {

		String expShopExperience = "How did you like your shopping experience?";
		String expRecommendGlobe = "Based on your online purchases, how likely are you to recommend Globe to others?";
		String expTxtTellUs = "Tell us how you feel";
		String expshareWithOther = "Don’t keep it to yourself. Share the love! Send the link to your friends and let them know.";
		String exptxtThatsNice = "Awww that's nice.";

		String logSuccess = "Validated survery text. ";
		String logFail = "Failed to validate survey text. ";

		if (ThankYou.isElementExist("Survery popup", "surveyForm", 35)) {

			// validate text messages for shopping experience

			String actShopExperience = ThankYou.get_txt_shoppingExperience().getText();
			if (actShopExperience.equals(expShopExperience)) {
				System.out.println(logSuccess + " : " + expShopExperience);
			} else {
				System.out.println(logFail + "Expected : " + expShopExperience + " - Actual : " + actShopExperience);
			}

			String act_ShopExp_TellUs = ThankYou.get_txt_shopExperience_feedback_().getText();
			if (act_ShopExp_TellUs.equals(expTxtTellUs)) {
				System.out.println(logSuccess + " : " + expTxtTellUs);
			} else {
				System.out.println(logFail + "Expected : " + expTxtTellUs + " - Actual : " + act_ShopExp_TellUs);
			}

			// validate text messages for recommend Globe

			String actRecommendGlobe = ThankYou.get_txt_recommendGlobe().getText();
			if (actRecommendGlobe.equals(expRecommendGlobe)) {
				System.out.println(logSuccess + ": " + expRecommendGlobe);
			} else {
				System.out.println(logFail + "Expected : " + expRecommendGlobe + " - Actual : " + actRecommendGlobe);
			}

			String act_Recommend_TellUs = ThankYou.get_txt_recommend_feedback().getText();
			if (act_Recommend_TellUs.equals(expTxtTellUs)) {
				System.out.println(logSuccess + ": " + expTxtTellUs);
			} else {
				System.out.println(logFail + ". Expected : " + expTxtTellUs + " - Actual : " + act_Recommend_TellUs);
			}

			// validate shopping experience emoji
			System.out.println("Printing Shopping Experience Emoji");
			for (int i = 0; i < ThankYou.get_shopExpEmoji().size(); i++) {
				System.out.println(ThankYou.get_shopExpEmoji().get(i).getAttribute("id"));
			}

			// select DISSATISFIED emoji for shopping experience and give feedback
			ThankYou.get_shopExpEmoji().get(3).click();
			System.out.println("Select Shopping exp emoji : DISSATISFIED");
			ThankYou.get_shopExpFeedbackTextArea().sendKeys("Test1");
			System.out.println("Inserted feedback : Test1");

			// validate recommend globe emoji
			System.out.println("Printing Recommend Globe Emoji");
			for (int i = 0; i < ThankYou.get_recomGlobeEmoji().size(); i++) {
				System.out.println(ThankYou.get_recomGlobeEmoji().get(i).getAttribute("id"));
			}

			// select VERY DISSATISFIED emoji for recommend globe and give feedback
			ThankYou.get_recomGlobeEmoji().get(4).click();
			System.out.println("Select Recommend Globe emoji : VERY DISSATISFIED");
			ThankYou.get_RecomGlobeTextArea().sendKeys("Test2");
			System.out.println("Inserted feedback : Test2");

			// submit survey
			ThankYou.get_submitSurver().click();
			Thread.sleep(2000L);

			// validate thumbs up image
			if (ThankYou.isElementExist("Image - Survey success", "imgSurveySuccess", 10)) {
				System.out.println("Thumbs up image displayed");

				String actThatsNice = ThankYou.get_txt_thatsNice().getText();
				if (actThatsNice.equals(exptxtThatsNice)) {
					System.out.println(logSuccess + " : " + exptxtThatsNice);
				} else {
					System.out.println(logFail + " Expected : " + exptxtThatsNice + " - Actual : " + actThatsNice);
				}

				String actShareOthers = ThankYou.get_txt_shareOthers().getText();
				if (actShareOthers.equals(expshareWithOther)) {
					System.out.println(logSuccess + " : " + expshareWithOther);
				} else {
					System.out.println(logFail + " Expected : " + expshareWithOther + " - Actual : " + actShareOthers);
				}

				if (ThankYou.isElementExist("Survey - Close button", "closeButton", 15)) {
					ThankYou.get_closeButton().click();
				} else {
					System.out.println("Close icon not found on survey popup");
				}

			} else {
				System.out.println("Thumbs image not displayed");
			}

		} else {
			System.out.println("Feedback popup do not open");
			Assert.assertTrue(false);
		}

		// validate text

	}

	/********************************************************************************************************************************/
	public String verifyUserGuideTitle() throws InterruptedException {

		String downloadManualTitle = "";
		if (LP.isClickable("downloadManual", 10)) {
			LP.get_downloadManual().click();
			System.out.println("Clicked on Download Manual");
			Thread.sleep(3000L);
			downloadManualTitle = LP.getURLOfNewTab();
		} else {
			System.out.println("FAIL : Download Manual button not found");
		}

		return downloadManualTitle;
	}

	/********************************************************************************************************************************/
	public void capture_orderID() {
		String orderID = LP.get_OrderID().getText();
		System.out.println("Order Completed successfully : " + orderID);
//		LP.write_OrderID_in_PropertiesFile(dateTimeStamp, orderID);
		Constant.dataMap.put("OrderID", orderID);
	}

	/********************************************************************************************************************************/
	public void selectGiftOptionOnForm() throws InterruptedException {
		if (Form.getAttributeValue("imgGiftOption", "src").contains("inactive")) {
			Thread.sleep(3000L);
			if (Form.isClickable("toggleGiftOption", 10)) {
//				Form.get_toggleGiftOption().click();

				Form.javascript_clickOnElement(Form.get_toggleGiftOption());
//				
//				JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
//				executor.executeScript("arguments[0].click();", Form.get_toggleGiftOption());

				System.out.println("Clicked on Gift option");
			}
		} else {
			System.out.println("Gift option is already selected");
		}
	}

	/********************************************************************************************************************************/
	public void insert_and_validate_recipientMobile(String mobCategory, String mobNumber) {

		String expErrMessage = "";
		String actErrMessage = "";

		Form.get_recipientMobile().clear();
		Form.get_recipientMobile().sendKeys(mobNumber);
		Form.get_recipientMobile().sendKeys(Keys.TAB);
		System.out.println("Inserted special character in recipient mobile : " + mobNumber);

		if (mobCategory.contains("specialChar") || mobCategory.contains("incompleteNumber")) {
			if (mobCategory.contains("specialChar")) {
				expErrMessage = "Mobile Number is mandatory.";
			} else if (mobCategory.contains("incompleteNumber")) {
				expErrMessage = "Please provide valid Mobile Number.";
			}

			if (Form.isElementExist("Recipient Error Message", "errRecipientMobile", 10)) {
				actErrMessage = Form.getText("errRecipientMobile");
				if (actErrMessage.equals(expErrMessage)) {
					System.out.println("Recipient Mobile : Error message displayed : " + expErrMessage);
				} else {
					System.out.println("Incorrect 'Recipient Mobile'err msg displayed. Expected-" + expErrMessage
							+ " Actual - " + actErrMessage);
				}
			} else {
				System.out.println("Recipient Mobile err message not displayed. Expected : " + expErrMessage);
			}
		}

		if (mobCategory.contains("validNumber")) {
			if (Form.isElementExist("Recipient Error Message", "errRecipientMobile", 3)) {
				actErrMessage = Form.getText("errRecipientMobile");
				System.out.println("FAIL - Recipient Mobile error displayed : " + actErrMessage);
			} else {
				System.out.println("No error message displayed for valid Recipient Mobile");
			}
		}

	}

	/********************************************************************************************************************************/
	public void validate_order_details_on_checkout() {

		for (int i = 0; i < checkout.get_productsName().size(); i++) {

			System.out.println("Product Category : " + checkout.get_productsCategory().get(i).getText());
			System.out.println("Product Name : " + checkout.get_productsName().get(i).getText());
			System.out.println("Product overview : " + checkout.get_productsOverview().get(i).getText());
			System.out.println("Price : " + checkout.get_productsPrice().get(i).getText());
			System.out.println("Quantity : " + checkout.get_quantities().get(i).getText());

			if (checkout.get_productsName().get(i).getText().equals("Globe At Home Prepaid WiFi")) {
				checkout.isElementExist("Image - Product - GHPW", "imgGHPW", 10);

			} else if (checkout.get_productsName().get(i).getText().equals("Xtreme Home Prepaid WiFi")) {
				checkout.isElementExist("Image - Product - XPW", "imgXPW", 10);

			} else if (checkout.get_productsName().get(i).getText().contains("Blackpink Limited Edition")) {
				checkout.isElementExist("Image - Product - BlackPink", "imgBlackPink", 10);
			}
		}
		System.out.println("Get Next Delivery : " + checkout.getText("txtNextDayDelivery"));
		System.out.println("Get Next Delivery : " + checkout.getText("txt_gCashChckout"));

	}

	/********************************************************************************************************************************/
	public void validate_product_specification(String product) throws InterruptedException {

		if (product.equalsIgnoreCase("Xtreme Home Prepaid WiFi")) {
			PC.isElementExist("Image - XPW Specification", "img_XPW_Spec", 10);

		} else if (product.equalsIgnoreCase("BLACKPINK Prepaid WiFi")) {
			PC.isElementExist("Image - BLACKPINK Specification", "img_BlackPink_specification", 10);
		}

		System.out.println("LAN Support : " + PC.getText("LanSupport"));
		System.out.println("Suport Network : " + PC.getText("SuportNetwork"));
		System.out.println("WiFi Support : " + PC.getText("WiFiSupport"));
		System.out.println("Features : " + PC.getText("Features"));
		System.out.println("Freebies : " + PC.getText("Freebies"));
		System.out.println("Best With : " + PC.getText("BestWith"));

		Thread.sleep(1500L);
		LP.scroll_vertical(400);
		Thread.sleep(1500L);
		System.out.println("Stock Avalability : " + PC.getText("stockAvalability"));
		System.out.println("Offered Price : " + PC.getText("offeredPrice"));
		System.out.println("Actual Price : " + PC.getText("actualPrice"));

		if (PC.get_ActualPrice().getCssValue("text-decoration").contains("line-through")) {
			System.out.println("Actual Price on specification is 'Strikethrough'");
		} else {
			System.out.println("Actual Price on specification is not 'Strikethrough'");
		}

		PC.isElementExist("Button - BuyNow/Checkout", "btnBuyNow_Checkout", 10);

		System.out.println("Payment Option : " + PC.getText("PaymentOption"));

		if (product.equalsIgnoreCase("Xtreme Home Prepaid WiFi")) {
			validate_XtremeWifi_deliveryCaveat();
		}

	}

	/********************************************************************************************************************************/
	public void validate_termsConditions_checkbox_toggle() throws InterruptedException {

		int pauseTime = 0;
		if (getBrowserName().toUpperCase().contains("SAFARI")) {
			pauseTime = 4000;
		} else {
			pauseTime = 250;
		}

		// read all checkboxes
		try {
			int countTerms = Form.get_chkbxTermsConditions().size();
			String labelTerms = "";
			for (int i = 0; i < countTerms - 1; i++) {
				labelTerms = Form.get_chkbxLabelTermsConditions().get(i).getText();
				Thread.sleep(pauseTime);
				Form.get_chkbxTermsConditions().get(i + 1).click();
				System.out.println("Selected Terms/Conditions : " + labelTerms);
				Thread.sleep(pauseTime);
				Form.get_chkbxTermsConditions().get(i + 1).click();
				System.out.println("Unselected Terms/Conditions : " + labelTerms);
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error - IndexOutOfBound :" + e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error :" + e1.getMessage());
		}
	}

	/********************************************************************************************************************************/
	public void clickPayOrderOnPayScreen() {
		if (Pay.isClickable("payOrder", 10)) {
			Pay.get_payOrder().click();
			System.out.println("Clicked on pay on payment page");
		} else {
			System.out.println("Fail : to click on pay button on payment page");
		}
	}

	/********************************************************************************************************************************/
	public String getBrowserName() {
		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return cap.getBrowserName();
	}

	/********************************************************************************************************************************/
	public void acceptCookies() throws InterruptedException {
		if (LP.isElementExist("Cookies Notification", "cookiesNotification", 10)) {
			LP.get_privacyAccept().click();
//			ExtentTestManager.logInfo("Clicked on 'Privacy - I accept' button");
			System.out.println("Clicked on 'Privacy - I accept' button");
		}
	}

	/********************************************************************************************************************************/
	public void clickBuyLinkOnHeader() throws InterruptedException {
		if (LP.isClickable("menuBuy", 5)) {
			LP.clickOnElement("Link", "Menu Buy", "menuBuy");
			Thread.sleep(2000L);
		}
	}

	/********************************************************************************************************************************/
	public void select_LTE_Advanced_on_home_page() {
		if (LP.isElementExist("Menu - Buy link", "menuBuy", 10)) {
			LP.moveToElement("menuBuy");
			System.out.println("Moved to Buy icon on menu bar");

			if (LP.isClickable("link_LTE_Advanced", 10)) {
				LP.get_LTE_Advanced().click();
				System.out.println("Clicked on LTE Advanced");
			}
		}

		if (LP.isElementExist("Floating button - Buy now", "floatingBuyNow", 10)) {
			LP.moveToElement("floatingBuyNow");
			System.out.println("Moved to floating Buy now icon");
		}
	}

	/********************************************************************************************************************************/
	public void validateFooter() throws InterruptedException {

		int iFooter = 0;

		boolean blnFooter = false;
		boolean blnFooterPrivacy = false;
		boolean blnFooterTerms = false;
		boolean blnFooterSiteMap = false;

		DriverManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		for (iFooter = 0; iFooter < 10; iFooter++) {
			if (LP.isElementExist("Landing Page - Footer", "footer", 0)) {
				blnFooter = true;

				if (LP.isElementExist("Landing Page - Footer Privacy Policy", "footerPrivacyPolicy", 0)) {
					blnFooterPrivacy = true;
				}
				if (LP.isElementExist("Landing Page - Footer Terms of use", "footerTermsOfUse", 0)) {
					blnFooterTerms = true;
				}
				if (LP.isElementExist("Landing Page - Footer Site Map", "footerSiteMap", 0)) {
					blnFooterSiteMap = true;
				}

				break;
			} else {
				LP.scroll_vertical(5000);
			}
		}

		// scroll back on top
		for (int i = 0; i <= iFooter; i++) {
			LP.scroll_vertical(-5000);
		}

		if (blnFooter) {
			System.out.println("Validated footer - © 2021 GLOBE TELECOM, INC.");
		} else {
			System.out.println("Failed to validate footer - © 2021 GLOBE TELECOM, INC.");
		}

		if (blnFooterPrivacy) {
			System.out.println("Validated footer - Privacy Policy link");
		} else {
			System.out.println("Failed to validate footer - Privacy Policy link");
		}

		if (blnFooterTerms) {
			System.out.println("Validated footer - Terms Of Use link");
		} else {
			System.out.println("Failed to validate footer - Terms Of Use link");
		}

		if (blnFooterSiteMap) {
			System.out.println("Validated footer - Site Map link");
		} else {
			System.out.println("Failed to validate footer - Site Map link");
		}

		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	/********************************************************************************************************************************/
	public void compareProducts() throws InterruptedException {

		String parentID = "";

		for (int i = 0; i < PC.get_Products().size(); i++) {
			System.out.println("Specification for Product : " + (i + 1));
			parentID = String.valueOf((i + 1));

			String commercialName = PC.reportProductCommercialName(parentID);
			PC.reportProductImage(parentID, commercialName);
			PC.reportProductFeatures(parentID);
			PC.reportProductFreebies(parentID);
			PC.reportProductBestWith(parentID);
			PC.reportProductLanSupport(parentID);
			PC.reportProductSupportedNetwork(parentID);
			PC.reportProductWiFiSupport(parentID);

//			LP.scroll_vertical(400);

			PC.reportStockAvalability(parentID);

			PC.reportProductOfferedPrice(parentID);
			PC.reportProductActualPrice(parentID);
			PC.reportProductPaymentOption(parentID);

			PC.reportProductBtnExpressCheckout(parentID);

//			LP.scroll_vertical(-400);
		}
	}

	/********************************************************************************************************************************/
	public void verifyWhatIsGCash() {

		if (checkout.isClickable("gCashDefinitionLink", 5)) {
			checkout.get_linkGCashDefinition().click();
			System.out.println("Clicked on link - What is GCash");
			System.out.println("Text : What is GCash : " + checkout.getText("gCashDefinition"));

		} else {
			System.out.println("link - What is GCash -  is not clickable");
		}
	}

	/********************************************************************************************************************************/
	public void addQuantityOnCheckout() throws InterruptedException {
		int qty = Integer.parseInt(checkout.get_quantities().get(0).getText());
		System.out.println("Current Quantity : " + qty);

		if (checkout.isClickable("addQuantity", 5)) {
			checkout.get_btnAddQuantity().click();
			Thread.sleep(2000L);
			int newQty = Integer.parseInt(checkout.get_quantities().get(0).getText());

			if (newQty == (qty + 1)) {
				System.out.println("Quantity is successfully incremented by '1'. New quantity : " + newQty);
			} else {
				System.out.println("Quantity is not incremented by '1'. New quantity : " + newQty);
			}

		} else {
			System.out.println("Button to 'Add Quantity' is not available");
		}
	}

	/********************************************************************************************************************************/
	public void removeQuantityOnCheckout() throws InterruptedException {
		int qty = Integer.parseInt(checkout.get_quantities().get(0).getText());
		System.out.println("Current Quantity : " + qty);

		if (checkout.isClickable("removeQuantity", 5)) {
			checkout.get_btnRemoveQuantity().click();
			Thread.sleep(2000L);
			int newQty = Integer.parseInt(checkout.get_quantities().get(0).getText());

			if (newQty == (qty - 1)) {
				System.out.println("Quantity is successfully decremented by '1'. New quantity : " + newQty);
			} else {
				System.out.println("Quantity is not decremented by '1'. New quantity : " + newQty);
			}

		} else {
			System.out.println("Button to 'Remove Quantity' is not available");
		}
	}

	/********************************************************************************************************************************/
	public void btnCloseToRemoveProductFromCheckout() throws InterruptedException {

		if (checkout.isClickable("closeButton", 5)) {
			checkout.get_btnClose().click();
			System.out.println("Clicked on 'close' icon to remove added product from checkout screen");

			if (checkout.isClickable("confirm_removeProduct", 5)) {
				checkout.get_btnConfirmRemoveProduct().click();
				System.out.println("Clicked on 'Yes' button to remove product");
			}

		} else {
			System.out.println("Button 'Close' is not available to remove added product on checkout");
		}
	}

	/********************************************************************************************************************************/
	public boolean isAttribtuePresent(WebElement element, String attribute) {

		boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	/********************************************************************************************************************************/
	public void validate_order_shipAdddress_Details_screenPay() {
		System.out.println("Validating Order details on Pay screen");

		for (int i = 0; i < Pay.get_productName().size(); i++) {
			System.out.println("Product Name : " + Pay.get_productName().get(i).getText());
			System.out.println("Quantity : " + Pay.get_quantity().get(i).getText());
			System.out.println("Price : " + Pay.get_price().get(i).getText());
		}

		System.out.println("Shipping : " + Pay.get_shipping().getText());
		System.out.println("Total Amount : " + Pay.get_totalAmount().getText());

		System.out.println("Shipping Address : " + Pay.get_shipAddress().getText());
	}

	/********************************************************************************************************************************/
	public void resendOTP() throws InterruptedException {

		for (int i = 1; i <= 15; i++) {
			checkout.scroll_vertical(300);
			if (!isAttribtuePresent(checkout.get_btnResendOTP(), "disabled")) {
				System.out.println("Resend OTP button gets enabled");

				Thread.sleep(2000L);
				checkout.get_btnResendOTP().click();
				Thread.sleep(2000L);
				System.out.println("Clicked on Resend OTP button");

				if (checkout.isElementExist("Resend OTP - Confirmation", "confirmationResendOTP", 20)) {
					System.out.println("Got the confirmation for Resend OTP");
				} else {
					System.out.println("Did not got the confirmation for Resend OTP in given time");
				}

				break;
			} else {
				Thread.sleep(3000L);
				System.out.println("Waiting for Resend OTP button to get enabled. Seconds Elapsed : " + (i * 3));
			}
		}
	}

	/********************************************************************************************************************************/
	public void insertDetailsOnTrackYourOrder() throws InterruptedException {
		String orderID = Constant.dataMap.get("OrderID");
		TrackOrder.get_referenceNumber().sendKeys(orderID);
		System.out.println("Inserted Reference Number on Track your order screen : " + orderID);

		TrackOrder.get_email().sendKeys("praveen1982qa@gmail.com");
		System.out.println("Inserted email on Track your order screen : praveen1982qa@gmail.com");

		TrackOrder.scroll_vertical(2000);
		Thread.sleep(1500L);
		TrackOrder.get_btn_trackOrder().click();
	}

	/********************************************************************************************************************************/
	public void validateOrderDetails() throws InterruptedException {

		System.out.println("Reference Number : " + OrderDetails.get_referenceNumber().getText());
		System.out.println("Order Active Status : " + OrderDetails.get_orderActiveStatus().getText());
		System.out.println("Completed Date : " + OrderDetails.get_completedDate().getText());
		OrderDetails.scroll_vertical(4000);
		System.out.println("Product Name : " + OrderDetails.get_productName().getText());
		System.out.println("Quantity : " + OrderDetails.get_quantity().getText());
		System.out.println("Product Image : " + OrderDetails.getAttributeValue("productImage", "alt"));
		System.out.println("Update Date : " + OrderDetails.get_updateDate().getText());
		System.out.println("Date Ordered : " + OrderDetails.get_dateOrdered().getText());
		System.out.println("Payment Method : " + OrderDetails.get_paymentMethod().getText());
		System.out.println("Amount Paid : " + OrderDetails.get_amountPaid().getText());
		System.out.println("Shipping Address : " + OrderDetails.get_shippingAddress().getText());
		System.out.println("Estimated Day of Delivery : " + OrderDetails.get_estDayOfDelivery().getText());
	}

	/********************************************************************************************************************************/
	public void validate_XtremeWifi_deliveryCaveat() {
		System.out.println("Delivery Caveat : " + PC.getText("XtremeWifiDeliveryCaveat_1"));
		System.out.println("Delivery Caveat : " + PC.getText("XtremeWifiDeliveryCaveat_2"));
	}

	/********************************************************************************************************************************/
	public void validate_paymentOptionsOnPayScreen() {
		Pay.isElementExist("Payment Option - Visa/MasterCard", "payOpt_VisaMaster", 10);
		Pay.isElementExist("Payment Option - GCash", "payOpt_GCash", 10);
		Pay.isElementExist("Payment Option - Over The Counter", "payOpt_overTheCounter", 10);
		Pay.isElementExist("Payment Option - Cash On Delivery", "payOpt_COD", 10);
	}

	/********************************************************************************************************************************/
	public void validate_overTheCounter_payment_notification() {

		if (Pay.isElementExist("Over The Counter - Notification", "notification_OTC", 10)) {
			Pay.get_notification_OTC().click();
			System.out.println("Clicked on 'Over The Counter - Notification'");
			System.out.println("Over The Counter - Notification Text : " + Pay.get_notification_OTC_text().getText());
		}
	}

	/********************************************************************************************************************************/
	public String verifyAccreditedECPayMerchants() throws InterruptedException {

		String url = "";
		if (Pay.isClickable("nearestECPay", 10)) {
			Pay.get_nearestECPay().click();
			System.out.println("Clicked on 'Find the nearest ECPay near me' link");
			Thread.sleep(5000L);
			url = LP.getURLOfNewTab();
		} else {
			System.out.println("FAIL : Download Manual button not found");
		}

		return url;
	}

	/********************************************************************************************************************************/
	public void validate_purchaseSummaryDetails() throws InterruptedException {

		// Validate purchase summary
		ThankYou.scroll_vertical(700);
		System.out.println("Purchase Summary - Shipping Address : " + ThankYou.get_summaryShippingAddress().getText());
		System.out.println("Purchase Summary - Amount To Pay : " + ThankYou.get_summaryAmtToPay().getText());

		// Validate item ordered
		ThankYou.scroll_vertical(300);
		int productCount = ThankYou.get_summaryProductCount().size();

		for (int i = 0; i < productCount; i++) {
			System.out.println("Purchase Summary - Product Image :"
					+ ThankYou.get_summaryProductImage().get(i).getAttribute("src"));
			System.out
					.println("Purchase Summary - Product Name :" + ThankYou.get_summaryProductName().get(i).getText());
			System.out.println(
					"Purchase Summary - Product Description :" + ThankYou.get_summaryDescription().get(i).getText());
			System.out
					.println("Purchase Summary - Product Quantity :" + ThankYou.get_summaryQuantity().get(i).getText());

		}

		// validate reminder
		ThankYou.scroll_vertical(700);
		System.out.println("Purchase Summary - Reminder - Text : " + ThankYou.get_summaryReminder1().getText());
		System.out.println("Purchase Summary - Reminder - Text : " + ThankYou.get_summaryReminder2().getText());
	}

	/********************************************************************************************************************************/
	public void applyPromoCodeOnCheckout() throws InterruptedException {
		if (checkout.isClickable("btnPromoCode", 10)) {
			checkout.get_btnPromoCode().click();
			System.out.println("Clicked on 'Click Here' button to insert promo code");

			checkout.get_txtbx_promoCode().sendKeys("GLOBE-10-OFF");
			System.out.println("Inserted promo code : GLOBE-10-OFF");

			Thread.sleep(1500L);
			checkout.get_btn_applyPromo().click();
			System.out.println("Clicked on apply button to apply promo code");

			checkout.isElementExist("Promo code applied successfully - Success Message", "promoSuccessMsg", 5);

		} else {
			System.out.println("FAIL : Could not insert promo code on checkout screen");
		}
	}

	/********************************************************************************************************************************/
	public void verifyAddQuantityDisbaledOnCheckout(int totalQty) throws InterruptedException {

//		System.out.println("Total Quantity on checkout page is : " + totalQty);

		for (int i = 0; i < checkout.get_buttonsAddQuantity().size(); i++) {

			Thread.sleep(2000L);
			int qty = Integer.parseInt(checkout.get_quantities().get(i).getText());
			checkout.get_buttonsAddQuantity().get(i).click();
			Thread.sleep(2000L);
			int newQty = Integer.parseInt(checkout.get_quantities().get(i).getText());

			if (newQty == (qty)) {
				System.out.println("PASS: + icon is disabled for product :" + (i + 1));
			} else {
				System.out.println("FAIL: + icon is enabled for product :" + (i + 1));
			}
		}
	}

	/********************************************************************************************************************************/
	public void verify_invalid_and_valid_promo_code() throws InterruptedException {
		if (checkout.isClickable("btnPromoCode", 10)) {
			checkout.get_btnPromoCode().click();
			System.out.println("Clicked on 'Click Here' button to insert promo code");

			checkout.get_txtbx_promoCode().sendKeys("GLOB-10-OFF");
			System.out.println("Inserted promo code : GLOB-10-OFF");

			Thread.sleep(1500L);
			checkout.get_btn_applyPromo().click();
			System.out.println("Clicked on apply button to apply promo code");
			checkout.isElementExist("That’s not a valid promo code. - Failure Message", "promoFailMsg", 5);

			checkout.get_txtbx_promoCode().clear();

			checkout.get_txtbx_promoCode().sendKeys("GLOBE-10-OFF");
			System.out.println("Inserted promo code : GLOBE-10-OFF");

			Thread.sleep(1500L);
			checkout.get_btn_applyPromo().click();
			System.out.println("Clicked on apply button to apply promo code");
			checkout.isElementExist("Promo code applied successfully - Success Message", "promoSuccessMsg", 5);

		} else {
			System.out.println("FAIL: failed to click on promo code");
		}
	}

	/********************************************************************************************************************************/
	public void validate_form_onClick_of_changeAddress(String addressType) throws InterruptedException {

		Pay.get_changeAddress().click();
		System.out.println("Clicked on Change Address button");

		Form.scroll_vertical(200);

		System.out.println("Validate FORM field values are pre-populated");

		System.out.println("First Name : " + Form.getAttributeValue("firstName", "value"));
		System.out.println("Middle Name : " + Form.getAttributeValue("middleName", "value"));
		System.out.println("Last Name : " + Form.getAttributeValue("lastName", "value"));
		System.out.println("Email : " + Form.getAttributeValue("email", "value"));
		System.out.println("Mobile Number : " + Form.getAttributeValue("mobileNumber", "value"));

		Form.scroll_vertical(600);

		if (addressType.equalsIgnoreCase("house")) {
			System.out.println("House radio button is selected");

			System.out.println("House : " + Form.getAttributeValue("houseNo", "value"));
			System.out.println("Street : " + Form.getAttributeValue("street", "value"));
			System.out.println("Village/Subdivision : " + Form.getAttributeValue("village_subDivision", "value"));
			System.out.println("Province : " + Form.getAttributeValue("drpdwnProvince", "value"));
			System.out.println("City : " + Form.getAttributeValue("drpdwnCity", "value"));
			System.out.println("Barangay : " + Form.getAttributeValue("drpdwnBarangay", "value"));
			System.out.println("ZipCode : " + Form.getAttributeValue("zipCode", "value"));
		}
		Form.scroll_vertical(300);

		System.out.println("Special Instruction : " + Form.getAttributeValue("specialInstruction", "value"));

		Form.scroll_vertical(1500);

		select_chkbx_acceptAllTerms();

		click_pay_btn_on_form();
		util.assertContainText("Validated title", DriverManager.getDriver().getTitle(), "Pay");

	}

	/********************************************************************************************************************************/
	public void pay_via_creditCard() throws InterruptedException {

		String cardNumber = "4421 8815 4231 5201";
		String expiryDate = "0726";
		String cvv = "777";

		select_payment_option_proceed_with_payment("Card");
		clickPayOrderOnPayScreen();

		if (Pay.isElementExist("Credit Card Page", "creditCardPage", 30)) {

			Thread.sleep(1500L);

			DriverManager.getDriver().switchTo().frame(Pay.get_cardNumberFrame());
			Pay.get_cardNumber().sendKeys(cardNumber);
			System.out.println("Inserted Card number : " + cardNumber);
			DriverManager.getDriver().switchTo().defaultContent();

			DriverManager.getDriver().switchTo().frame(Pay.get_cardExpiryDateFrame());
			Pay.get_cardExpiryDate().sendKeys(expiryDate);
			System.out.println("Inserted Expiry Date : " + expiryDate);
			DriverManager.getDriver().switchTo().defaultContent();

			DriverManager.getDriver().switchTo().frame(Pay.get_cvvFrame());
			Pay.get_cvv().sendKeys(cvv);
			System.out.println("Inserted CVV : " + cvv);
			DriverManager.getDriver().switchTo().defaultContent();

			if (Pay.isClickable("btnPay_CC", 5)) {
				Pay.get_btnPay_CC().click();
				System.out.println("Clicked on Pay button");

			}
		} else {
			System.out.println("Credit Card Page do not open");
		}

	}

	/********************************************************************************************************************************/
	public void pressKeyboardKey(String key) throws InterruptedException {

		Actions a = new Actions(DriverManager.getDriver());
		Thread.sleep(500L);

		switch (key.toUpperCase()) {
		case "TAB":
			a.sendKeys(Keys.TAB).build().perform();
			break;
		case "SPACE":
			a.sendKeys(Keys.SPACE).build().perform();
			break;
		case "SHIFT_TAB":
			a.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).build().perform();
			break;
		}

	}

	/********************************************************************************************************************************/
	public void toggle_and_select_terms_checkboxes() throws InterruptedException {

//		// navigate to terms and condition check boxes
//		Form.get_zipCode().click();
//		for (int ctr = 0; ctr < 16; ctr++) {
//			Thread.sleep(1500L);
//			pressKeyboardKey("TAB");
//		}
		
		Form.get_label_accept_all_terms().click();
		Thread.sleep(1000L);
		Form.get_label_accept_all_terms().click();
		Thread.sleep(1500L);
		pressKeyboardKey("TAB");

		try {
			int countTerms = Form.get_chkbxTermsConditions().size();
			String labelTerms = "";
			for (int i = 0; i < countTerms - 1; i++) {
				labelTerms = Form.get_chkbxLabelTermsConditions().get(i).getText();

				Thread.sleep(1500L);
				pressKeyboardKey("SPACE");
				System.out.println("Selected Terms/Conditions : " + labelTerms);

				Thread.sleep(1500L);
				pressKeyboardKey("SPACE");
				System.out.println("Unselected Terms/Conditions : " + labelTerms);

				Thread.sleep(1500L);
				pressKeyboardKey("TAB");
				Thread.sleep(1500L);
				pressKeyboardKey("TAB");
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error - IndexOutOfBound :" + e.getMessage());
		} catch (Exception e1) {
			System.out.println("Error :" + e1.getMessage());
		}

		// navigate back to accept all term checkbox
		for (int ctr = 0; ctr < 13; ctr++) {
			Thread.sleep(1500L);
			pressKeyboardKey("SHIFT_TAB");
		}
		Thread.sleep(1500L);
		pressKeyboardKey("SPACE");
	}
}
