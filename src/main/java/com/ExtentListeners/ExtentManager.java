//package com.ExtentListeners;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.browserstack.*;
//
//public class ExtentManager {
//
//	static ExtentReports extent;
//	static Date d = new Date();
//	static String fileName = "Globe_Automation_Report_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
//	static util util;
//
//	public synchronized static ExtentReports getReporter() {
//		if (extent == null) {
//
//			util = new util();
//
//			String date = util.getCurrentDate("dd MMM yyyy");
//			String reportPath = "D://Globe Automation Execution Reports//" + date + "//";
//
//			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath + fileName);
//
////			htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
////			htmlReporter.config().setChartVisibilityOnOpen(true);
//			sparkReporter.config().setTheme(Theme.DARK);
//			sparkReporter.config().setDocumentTitle(fileName);
//			sparkReporter.config().setEncoding("utf-8");
//			sparkReporter.config().setReportName(fileName);
//
//			extent = new ExtentReports();
//			extent.attachReporter(sparkReporter);
//			extent.setSystemInfo("Automation Tester", "");
//			extent.setSystemInfo("Application", "Globe");
//			extent.setSystemInfo("Environment", "UAT");
//		}
//		return extent;
//	}
//
////	public static String screenshotPath;
////	public static String screenshotName;
////	static int i = 0;
////
////	public static void captureScreenshot() {
////		i = i + 1;
////		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
////
////		Date d = new Date();
////		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "_" + i + ".jpg";
////
////		try {
////			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////
////	}
//
//}
