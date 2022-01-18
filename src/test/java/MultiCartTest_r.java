import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.browserstack.DriverManager;
import com.browserstack.util;
import com.pages.LandingPage;

public class MultiCartTest_r {
	LandingPage LP = new LandingPage();
	private util util = new util();

	private WebDriver driver;

//	public void main(String[] args) throws InterruptedException, IOException {

	@Test
	public void test() throws InterruptedException, IOException {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();

		DriverManager.setWebDriver(driver);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String appURL = util.readConfigPropFile("urlUAT");
		
		DriverManager.getDriver().get("https://onlineuat.globe.com.ph/port-number");;
//		DriverManager.getDriver().get(util.readConfigPropFile("urlPreProd"));
		
		String a = DriverManager.getDriver().findElement(By.xpath("//span[@class='actualPrice']")).getCssValue("text-decoration");
		System.out.println(a);
		
	}
}