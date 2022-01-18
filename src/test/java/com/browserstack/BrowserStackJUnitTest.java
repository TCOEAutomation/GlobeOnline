package com.browserstack;

//import com.ExtentListeners.ExtentManager;
//import com.ExtentListeners.ExtentTestManager;
import com.browserstack.local.Local;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parallelized.class)
public class BrowserStackJUnitTest {
	private WebDriver driver;

	private Local l;
	public String env;

	private static JSONObject config;

	@Parameter(value = 0)
	public int taskID;

	@Parameters
	public static Iterable<? extends Object> data() throws Exception {
		List<Integer> taskIDs = new ArrayList<Integer>();

		if (System.getProperty("config") != null) {
			JSONParser parser = new JSONParser();
			config = (JSONObject) parser
					.parse(new FileReader("src/test/resources/conf/" + System.getProperty("config")));
			int envs = ((JSONArray) config.get("environments")).size();

			for (int i = 0; i < envs; i++) {
				taskIDs.add(i);
			}
		}

		return taskIDs;
	}

	@Before
	public void setUp() throws Exception {
		JSONArray envs = (JSONArray) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		Map<String, String> envCapabilities = (Map<String, String>) envs.get(taskID);
		Iterator it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (capabilities.getCapability(pair.getKey().toString()) == null) {
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		String username = System.getenv("BROWSERSTACK_USERNAME");
		if (username == null) {
			username = (String) config.get("user");
		}

		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if (accessKey == null) {
			accessKey = (String) config.get("key");
		}

		env = (String) config.get("env");

		if (capabilities.getCapability("browserstack.local") != null
				&& capabilities.getCapability("browserstack.local") == "true") {
			l = new Local();
			Map<String, String> options = new HashMap<String, String>();
			options.put("key", accessKey);
			l.start(options);
		}

		if (env.equalsIgnoreCase("remote")) {
			// DesiredCapabilities capability;
			// capability = new DesiredCapabilities();
			capabilities.setCapability("browserstack.debug", true);
			// capabilities.setCapability("browserstack.local", true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
			capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"),
					capabilities);

			DriverManager.setWebDriver(driver);

			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();

//			Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
//			String browserName = cap.getBrowserName().toUpperCase();
//
//			ExtentTestManager.startTest(browserName + " : Test Name : ");
//			ExtentTestManager.logInfo("Execution started for : ");
//			ExtentTestManager.logInfo("Browser Launched : " + browserName);
		}

		else {

			driver = new ChromeDriver();

			DriverManager.setWebDriver(driver);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();

//			Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
//			String browserName = cap.getBrowserName().toUpperCase();
//
//			ExtentTestManager.startTest(browserName + " : Test Name : ");
//			ExtentTestManager.logInfo("Execution started for : ");
//			ExtentTestManager.logInfo("Browser Launched : " + browserName);

		}

	}

	@After
	public void tearDown() throws Exception {

//		ExtentTestManager.logInfo("Execution Finished");
//		ExtentManager.getReporter().flush();

		DriverManager.getDriver().quit();
		if (l != null)
			l.stop();
	}
}