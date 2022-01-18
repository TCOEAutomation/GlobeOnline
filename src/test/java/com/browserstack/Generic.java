///*
// *Description: Control Functions library 
//'Author :Sunanda Tirunagari
// */
//
//package com.browserstack;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//import java.net.URLDecoder;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//import java.lang.*;
//import org.apache.poi.common.usermodel.HyperlinkType;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Assert;
////import org.assertj.core.api.SoftAssertions;
//import org.junit.Test;
//import org.apache.poi.ss.usermodel.*;
//
//public class Generic {
//	
//	//private static SoftAssertions softAssertions;	
//	private static XSSFWorkbook workbook;
//	private static XSSFSheet Worksheet;
//	private static XSSFCell cell;
//	
//	private static String getcelldata(int rownum, int colnum) throws Exception{
//		String celldata=null;
//		DataFormatter formatter = new DataFormatter();
//		try{
//			//cell= Worksheet.getRow(rownum).getCell(colnum);
//		
//		 //celldata=cell.getStringCellValue();
//			celldata=formatter.formatCellValue(Worksheet.getRow(rownum).getCell(colnum));
//			//System.out.println();
//		
//		}catch (Exception e) {			
//			System.out.println("Exception while getCellData : Row,Col"+rownum+","+colnum+e.getMessage());
//			e.printStackTrace();
//			
//			//System.exit(-1);
//		}
//		return celldata;
//	}
//	public static String ReadFromExcel(String strVariable, String strSheetname,int iColumnNo) throws Exception
//	{
//		//System.out.println("In Read from Excel");
//		String strText = null;
//		String strData;
//		try {
//			FileInputStream ExcelFile= new FileInputStream(Constant.TestDataFilePath);
//			workbook = new XSSFWorkbook(ExcelFile);
//			Worksheet =  workbook.getSheet(strSheetname);		
//			int totalrows=Worksheet.getLastRowNum();		
//			for(int i=0; i<totalrows+1;i++)
//			{
//				strData=getcelldata(i,0);
//				//System.out.println("StrData is "+strData);
//				//System.out.println("StrVar is "+strVariable);
//				if(strVariable.equals(strData.toString())){					
//					strText=getcelldata(i,iColumnNo);
//					//System.out.println("*************************** [ FINALLY EQUAL ] *************************** ");
//					break;
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception while reading from Excel : "+e.getMessage());
//			e.printStackTrace();
//		}
//		return strText;		
//	}
//	public static void WriteToExcel(String strVariable, String strText, String strSheetname,int iColumnNo) throws Exception
//	{
//		String strData;
//		try {
//			FileInputStream ExcelFile= new FileInputStream(Constant.TestDataFilePath);
//			workbook = new XSSFWorkbook(ExcelFile);
//			Worksheet =  workbook.getSheet(strSheetname);		
//			int totalrows=Worksheet.getLastRowNum();	
//			for(int i=0; i<totalrows+1;i++)
//			{
//				strData=getcelldata(i,0);
//				if (strData.toString().equals(strVariable))
//				{
//					cell = Worksheet.getRow(i).getCell(iColumnNo);
//					cell.setCellValue(strText);
//					break;
//				}
//			}
//			FileOutputStream fos = new FileOutputStream(Constant.TestDataFilePath);
//			workbook.write(fos);
//			fos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//	}
//	
//	/*public static void TestScriptStart(String UserStoryName) throws Exception{
//		
//		System.out.println("Handling Repo Creation");
//		RepositoryCreation();
//		System.out.println("Done Repo Creation");
//		Constant.UserStoryName = UserStoryName;
//		String Main_Folder;
//		Main_Folder= ReadFromExcel("ResultsFolderPath","AI_TestData",1);
//		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//		DateFormat TimeFormat = new SimpleDateFormat("HHMMSS");
//		Date date2= new Date();
//		
//		String Date3 = TimeFormat.format(date2); 
//		Date date= new Date();
//		String Date1 = dateFormat.format(date);
//		String strFolderName  = UserStoryName +Date1+"_"+Date3;
//		File file = new File(Main_Folder);
//		if(!file.exists()) {
//			file.mkdir();
//		}
//		String strFolderPath = Main_Folder  + strFolderName;
//		file = new File(strFolderPath);
//		if(!file.exists()) {
//			file.mkdir();
//		}
//		strFolderName = strFolderPath + File.separator + UserStoryName;
//		file = new File(strFolderName);
//		if (!file.exists()) {
//			file.mkdir();
//		}
//		String strXlsFileName = strFolderName + File.separator + UserStoryName +".xlsx";
//		String strHtmlFileName = strFolderName + File.separator + UserStoryName +".html";
//		if (file.exists()) 
//		{	
//			File FileName= new File(strXlsFileName);
//			FileOutputStream fos =new FileOutputStream (FileName);
//			XSSFWorkbook Wb = new  XSSFWorkbook();
//			XSSFSheet sh = Wb.createSheet("Results");
//			Row row = sh.createRow(0);
//			String[] columNames = {"Test Scenario Sr No","Test Step No","Test Case/Step Desc","Test Object Name","Test Data","Expected Result","Actual Result","Test Case/Step Status"	,"Screenshot", "StartTime", "EndTime"};
//			
//			for(int i=0;i<=10;i++) {
//				Cell cell =row.createCell(i);
//				cell.setCellValue(columNames[i]);				
//			}		
//			Wb.write(fos);
//			fos.close();	
//			Wb.close();
//			strFolderName = strFolderName + File.separator + "Screenshots";
//			
//			Constant.ScreenshotFolderName = strFolderName;
//			file = new File(strFolderName);
//			if(!file.exists()) 
//			{
//				file.mkdir();
//			}
//			Date objDate = new Date();
//			//StringBuilder htmlStringBuilder=new StringBuilder();
//	        //htmlStringBuilder.append("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
//	        //htmlStringBuilder.append("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://myaccountpreprod.globe.com.ph/etc/designs/multi-solutions/assets/img/icon/loglobe.png'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=2><B>&nbsp;OMNI-My Account Automation - " + objDate.toString() + " -  & Time &  on Machine  & Environment.Value(LocalHostName) & </B></FONT></TD></TR></TABLE>");
//	        //htmlStringBuilder.append("<TABLE BORDER=1 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
//	        //htmlStringBuilder.append("<TR><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Business Process Name:  </B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"+UserStoryName +"</B></FONT></TD></TR>");
//	        //htmlStringBuilder.append("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case No</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Description</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Expected Result</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Actual Result</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Result</B></FONT></TD></TR>");
//	        //File HtmlFileName = new File(strHtmlFileName);
//	        
//	        //FileOutputStream outputStream = new FileOutputStream(HtmlFileName);
//	        //Writer writer=new OutputStreamWriter(outputStream);
//	        //writer.write(htmlStringBuilder.toString());
//	        //writer.close();*/
//	        
//		/*}
//		Constant.ResultFilePath=strXlsFileName;
//		
//		
//	}*/
//	
//public static void TestScriptStart(String UserStoryName,String platform) throws Exception{
//		
//
//		
//		System.out.println("Handling Repo Creation");
//		RepositoryCreation(platform);
//		RepositoryLabelCreation();
//		System.out.println("Done Repo Creation");
//		Constant.UserStoryName = UserStoryName;
//		Constant.Platform=platform;
//		String Main_Folder;
//		if(platform.equals("iOS")) {
//			Main_Folder= System.getProperty("user.dir")+File.separator+ReadFromExcel("ResultsFolderPath","AI_TestData",1);
//		}else {
//			Main_Folder= System.getProperty("user.dir")+File.separator+ReadFromExcel("ResultsFolderPath_Android","AI_TestData",1);
//		}
//		
//		System.out.println(System.getProperty("user.dir"));
//		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
//		DateFormat TimeFormat = new SimpleDateFormat("HHMMSS");
//		Date date2= new Date();
//		
//		String Date3 = TimeFormat.format(date2); 
//		Date date= new Date();
//		String Date1 = dateFormat.format(date);
//		String strFolderName  = UserStoryName +Date1+"_"+Date3;
//		File file = new File(Main_Folder);
//		if(!file.exists()) {
//			file.mkdir();
//			System.out.println("Created : "+Main_Folder);
//		}
//		String strFolderPath = Main_Folder  + strFolderName;
//		file = new File(strFolderPath);
//		if(!file.exists()) {
//			file.mkdir();
//			System.out.println("Created : "+strFolderPath);
//		}
//		strFolderName = strFolderPath + File.separator + UserStoryName;
//		file = new File(strFolderName);
//		if (!file.exists()) {
//			file.mkdir();
//			System.out.println("Created : "+strFolderName);
//		}
//		String strXlsFileName = strFolderName + File.separator + UserStoryName +".xlsx";
//		String strHtmlFileName = strFolderName + File.separator + UserStoryName +".html";
//		if (file.exists()) 
//		{	
//			File FileName= new File(strXlsFileName);
//			FileOutputStream fos =new FileOutputStream (FileName);
//			XSSFWorkbook Wb = new  XSSFWorkbook();
//			XSSFSheet sh = Wb.createSheet("Results");
//			Row row = sh.createRow(0);
//			String[] columNames = {"Test Scenario Sr No","Test Step No","Test Case/Step Desc","Test Object Name","Test Data","Expected Result","Actual Result","Test Case/Step Status"	,"Screenshot", "StartTime", "EndTime"};
//			
//			for(int i=0;i<=10;i++) {
//				Cell cell =row.createCell(i);
//				cell.setCellValue(columNames[i]);				
//			}		
//			Wb.write(fos);
//			fos.close();	
//			Wb.close();
//			strFolderName = strFolderName + File.separator + "Screenshots";
//			
//			Constant.ScreenshotFolderName = strFolderName;
//			file = new File(strFolderName);
//			if(!file.exists()) 
//			{
//				file.mkdir();
//			}
//			Date objDate = new Date();
//			
//	        
//		}
//		Constant.ResultFilePath=strXlsFileName;
//		
//		
//	
//	}
//	
////public static void TestScriptStart1(String UserStoryName) throws Exception{
////	
////
////	
////	System.out.println("Handling Repo Creation");
////	RepositoryCreation(platform);
////	System.out.println("Done Repo Creation");
////	Constant.UserStoryName = UserStoryName;
////	String Main_Folder;
////	Main_Folder= System.getProperty("user.dir")+File.separator+ReadFromExcel("ResultsFolderPath","AI_TestData",1);
////	DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
////	DateFormat TimeFormat = new SimpleDateFormat("HHMMSS");
////	Date date2= new Date();
////	
////	String Date3 = TimeFormat.format(date2); 
////	Date date= new Date();
////	String Date1 = dateFormat.format(date);
////	//String strFolderName  = UserStoryName +Date1+"_"+Date3;
////	String strFolderName  = UserStoryName;
////
////	File file = new File(Main_Folder);
////	if(!file.exists()) {
////		file.mkdir();
////		System.out.println("Created : "+Main_Folder);
////	}
////	String strFolderPath = Main_Folder  + strFolderName;
////	file = new File(strFolderPath);
////	if(!file.exists()) {
////		file.mkdir();
////		System.out.println("Created : "+strFolderPath);
////	}
////	strFolderName = strFolderPath + File.separator + UserStoryName;
////	file = new File(strFolderName);
////	if (!file.exists()) {
////		file.mkdir();
////		System.out.println("Created : "+strFolderName);
////	}
////	String strXlsFileName = strFolderName + File.separator + UserStoryName +".xlsx";
////	String strHtmlFileName = strFolderName + File.separator + UserStoryName +".html";
////	if (file.exists()) 
////	{	
////		File FileName= new File(strXlsFileName);
////		FileOutputStream fos =new FileOutputStream (FileName);
////		XSSFWorkbook Wb = new  XSSFWorkbook();
////		XSSFSheet sh = Wb.createSheet("Results");
////		Row row = sh.createRow(0);
////		String[] columNames = {"Test Scenario Sr No","Test Step No","Test Case/Step Desc","Test Object Name","Test Data","Expected Result","Actual Result","Test Case/Step Status"	,"Screenshot", "StartTime", "EndTime"};
////		
////		for(int i=0;i<=10;i++) {
////			Cell cell =row.createCell(i);
////			cell.setCellValue(columNames[i]);				
////		}		
////		Wb.write(fos);
////		fos.close();	
////		Wb.close();
////		strFolderName = strFolderName + File.separator + "Screenshots";
////		
////		Constant.ScreenshotFolderName = strFolderName;
////		file = new File(strFolderName);
////		if(!file.exists()) 
////		{
////			file.mkdir();
////		}
////		Date objDate = new Date();
////		
////        
////	}
////	Constant.ResultFilePath=strXlsFileName;
////	
////	
////
////}
//
//public static void RC1() throws Exception	{
//		String strText,PageName, strValue;
//		int totalrows;
//		try {
//			FileInputStream ExcelFile= new FileInputStream(Constant.TestDataFilePath);
//			workbook = new XSSFWorkbook(ExcelFile);
//			
//			for(int j=0; j<workbook.getNumberOfSheets(); j++){
//				PageName = workbook.getSheetName(j);			
//				Constant.Map.put(PageName, new HashMap<String,String>());
//				Worksheet =  workbook.getSheet(PageName);
//				totalrows = Worksheet.getLastRowNum();
//				for(int i=0; i<totalrows+1;i++)
//				{							
//					strText=getcelldata(i,0);
//					strValue = getcelldata(i,1);
//					Constant.Map.get(PageName).put(strText, strValue);
//					strText=null;	
//				}
//				
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//
//	
//	public static void WriteTestData(String strStepDesc, String strObjectname, String strTestData, String strExpectedResult,String strActualResult, String strStepStatus ) {
//		try
//		{
//			String strXlsFileName = Constant.ResultFilePath;
//			//System.out.println("Results file : "+strXlsFileName);
//			int strData,strData1, strData11, strData111;
//			strData = Constant.StepIndex;
//			strData1 = strData+1;
//			Constant.StepIndex = strData1;
//			strData = Constant.StepIndex;
//			strData11 = Constant.TestStepIndex;
//			strData111 = strData11+1;
//			Constant.TestStepIndex = strData111;
//			strData111 = Constant.TestStepIndex;	
//			FileInputStream ExcelFile=null;
//			try {
//			ExcelFile= new FileInputStream(strXlsFileName);
//			workbook = new XSSFWorkbook(ExcelFile);
//			Worksheet =  workbook.getSheet("Results");
//			Row row = Worksheet.createRow(strData);
//			String[] columNames = {""+strData111+"",strStepDesc,strObjectname,strTestData,strExpectedResult,strActualResult,strStepStatus};
//			for(int i=1;i<8;i++) {
//				Cell cell =row.createCell(i);
//				cell.setCellValue(columNames[i-1]);				
//			}	
//			
//			if(strStepStatus.equalsIgnoreCase("Fail")) {   
//
//					strData11 = Constant.StepStatus;
//					strData11 = strData11+1;
//					Constant.StepStatus = strData11;
//				
//
//	        	//Control.takeScreenshot(false);        	
//		        Cell cell = row.createCell(8);
//		    	cell.setCellValue(Constant.ScreenshotFolderName+File.separator+Constant.RecentScreenshot);
//		        final Hyperlink href = workbook.getCreationHelper().createHyperlink(HyperlinkType.FILE);
//		        String FolderPath= "File:///"+ Constant.ScreenshotFolderName+File.separator+Constant.RecentScreenshot;	        
//		        FolderPath= FolderPath.replace("\\", "/");	       
//		        href.setAddress(FolderPath);
//		        cell.setHyperlink(href);
//	        }
//		
//			}catch (Exception e) {
//				System.out.println("Exception in WriteTestData(): "+e.getMessage());
//				e.printStackTrace();
//				
//			}
//			
//			finally
//			{
//				ExcelFile.close();		
//				FileOutputStream fos = new FileOutputStream(strXlsFileName);		
//				workbook.write(fos);		
//				workbook.close();
//				fos.close();	
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception while Writing test data : "+e.getMessage());
//			e.printStackTrace();
//		}
//
//	}
//	public static void RepositoryCreation(String platform) throws Exception
//	{
//		String strText,PageName, strValue;
//		int totalrows;
//		try {
//			FileInputStream ExcelFile= new FileInputStream(Constant.TestDataFilePath);
//			workbook = new XSSFWorkbook(ExcelFile);
//			if(platform.equalsIgnoreCase("iOS")) {
//				Worksheet =  workbook.getSheet("ObjectRepository");
//			}
//			else {
//				Worksheet =  workbook.getSheet("ObjectRepository_Android");
//			}
//			
//			totalrows = Worksheet.getLastRowNum();
//			PageName = null; 
//			for(int j=0; j <= totalrows; j++){
//				strValue= getcelldata(j, 0);
//				//System.out.println("strValue is "+strValue);
//				
//				if (strValue.equalsIgnoreCase("")){
//					
//				}
//				else
//				{
//					PageName = strValue;
//					Constant.Map.put(PageName, new HashMap<String,String>());
//				}						
//				strText=getcelldata(j,1);
//				strValue = getcelldata(j,2);
//				Constant.Map.get(PageName).put(strText, strValue);
//				strText=null;				
//				
//			}				
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static void WriteTestCase(String sTestCaseNumber,String strScenarioDesc,String strExpectedResult,String strActualResult) throws Exception{
//		String strXlsFileName = Constant.ResultFilePath;
//		Constant.StepStatus=0;
//		if(Constant.MultipleTCInOneMethod)
//		{
//			
//		}
//		else
//		{
//		Constant.Failures = " ";
//		}
//		try
//		{
//			File f=new File(Constant.ResultFilePath);
//			f.getParentFile().mkdirs();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		
//		int strData1,strData2, stepStatus, strDiff;
//		strData1 = Constant.StepIndex; 
//        strData2 = Constant.TestStepIndex;
//        stepStatus = Constant.StepStatus;
//        strDiff= strData1-strData2;   
//        FileInputStream ExcelFile= new FileInputStream(strXlsFileName);
//		workbook =  new XSSFWorkbook(ExcelFile);
//		Worksheet =  workbook.getSheet("Results");
////		Row row = Worksheet.createRow(strDiff+1);
////		CellStyle style = workbook.createCellStyle();
////		for(int i=0;i<8;i++) {
////			Cell cell =row.createCell(i);
////			if(stepStatus==0) {				
////				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
////				cell.setCellStyle(style);
////			}
////			else
////			{
////				style.setFillForegroundColor(IndexedColors.RED.getIndex());
////				cell.setCellStyle(style);				
////			}
////		}
//		
//		Constant.StepStatus=0;
//		
//	int strData = Constant.StepIndex;
//	if(Constant.TestCaseNumber==0) {
//	    strData1=strData+1;
//	    Constant.StepIndex=strData1 ;
//	}
//	    strData =Constant.StepIndex;
//	    
//	    strData2 = Constant.TestCaseIndex;
//	    int strData3=strData2+1;
//	    Constant.TestCaseIndex=strData3;
//	    int strData4 = Constant.TestCaseIndex;
//	            	            
//	    Constant.TestStepIndex=0;
//	    //Row row1 = Worksheet.createRow(strDiff+1);
//	    Row row1 = Worksheet.createRow(strData);	
//	    Cell cell=row1.createCell(0);
//	    cell.setCellValue(sTestCaseNumber);
//	    cell=row1.createCell(5);	     
//	    cell.setCellValue(strExpectedResult);
//	    cell=row1.createCell(6);
//	    cell.setCellValue(strActualResult); 		
//	    cell=row1.createCell(2);
//	   // Worksheet.addMergedRegion(new CellRangeAddress(strData,strData,1,4));
//	    cell.setCellValue(strScenarioDesc); 
//	    cell=row1.createCell(1);
//	    cell.setCellValue(""); 
//	    cell=row1.createCell(3);
//	    cell.setCellValue(""); 
//	    cell=row1.createCell(4);
//	    cell.setCellValue(""); 
//	    cell=row1.createCell(7);
//	    cell.setCellValue(""); 
//	    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//	    cell=row1.createCell(9);
//	    String tim = LocalDateTime.now().format(dtf);
//	    cell.setCellValue(tim); 
//	    
////	    cell=row1.createCell(11);
////	    cell.setCellValue(Control.checkbal("*143*2*2*1#")); 
//	    
//	    
//		ExcelFile.close();		
//		FileOutputStream fos = new FileOutputStream(strXlsFileName);	
//		workbook.write(fos);		
//		workbook.close();
//		fos.close();
//		Constant.strScenarioDesc =strScenarioDesc;
//		Constant.strExpectedResult =strExpectedResult;
//		Constant.strActualResult =strActualResult;
//		Constant.TestCaseNumber=Constant.TestCaseNumber+1;
//				
//	}
//	
//	@Test
//	public static void TestScriptEnds() throws Exception{
//		String strXlsFileName = Constant.ResultFilePath;
//
//        int strData1,strData2, stepStatus, strDiff;
//
//        strData1 = Constant.StepIndex;
//
//			strData2 = Constant.TestStepIndex;
//			
//			stepStatus = Constant.StepStatus;
//			
//			strDiff= strData1-strData2;
//			
//			try {
//			
//			FileInputStream ExcelFile= new FileInputStream(strXlsFileName);
//			
//			        workbook = new XSSFWorkbook(ExcelFile);
//			
//			        Worksheet =  workbook.getSheet("Results");
//			
//			        Row row = Worksheet.getRow(strDiff); 
//			
//			        CellStyle style = workbook.createCellStyle();
//			
//			        for(int i=0;i<8;i++) {
//			                Cell cell =row.getCell(i);
//			                if(stepStatus==0) {                                                          
//			                    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//			                    style.setAlignment(HorizontalAlignment.CENTER);
//			                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//			                    cell.setCellStyle(style);
//			                }
//			                else{                                                             
//			                    style.setFillForegroundColor(IndexedColors.RED.getIndex());
//			                    style.setAlignment(HorizontalAlignment.CENTER);
//			                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);          
//			                    cell.setCellStyle(style);
//			                }
//			        }
//			
//			        
//			        Cell cell =row.getCell(7);
//		        	if(stepStatus==0) {
//		                cell.setCellValue("Pass");
//				        cell=row.createCell(10);
//					    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//					    cell.setCellValue(LocalDateTime.now().format(dtf).toString()); 
////					    cell=row.createCell(12);
////					    cell.setCellValue(Control.checkbal("*143*2*2*1#")); 
//		                }
//		                else
//		                {
//		                    cell.setCellValue("Fail");
//					        cell=row.createCell(10);
//						    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//						    cell.setCellValue(LocalDateTime.now().format(dtf).toString()); 
////						    cell=row.createCell(12);
////						    cell.setCellValue(Control.checkbal("*143*2*2*1#")); 
//		                }
//		        
//			        	
//				    cell = row.createCell(8);
//			        if(stepStatus==0) {
//			        	
//			        }
//			        else
//			        {
//			        	
//			        	cell.setCellValue(Constant.ScreenshotFolderName);
//			            final Hyperlink href = workbook.getCreationHelper().createHyperlink(HyperlinkType.FILE);
//			            String FolderPath= "File:///"+ Constant.ScreenshotFolderName;
//			            FolderPath= FolderPath.replace("\\", "/");
//			            System.out.println(FolderPath);
//			            href.setAddress(FolderPath);
//			            cell.setHyperlink(href);
//			        }
//			        
//
//			        
//			        //Constant.StepStatus=0;
//					int strData = Constant.StepIndex;
//					strData1=strData+1;
//					Constant.StepIndex=strData1 ;
//					strData =Constant.StepIndex;
//					strData2 = Constant.TestCaseIndex;
//					int strData3=strData2+1;
//					Constant.TestCaseIndex=strData3;     
//					ExcelFile.close();                             
//					FileOutputStream fos = new FileOutputStream(strXlsFileName);                
//					workbook.write(fos);                    
//					workbook.close();
//					fos.close();
//					
//					if(!(Constant.StepStatus==0))
//					{
//						//Assert.fail("\n" + Constant.Failures);	
//	        			//softAssertions.fail("\n" + Constant.Failures);
//
//					}
//					
//			}catch (Exception e) {
//			
//			        System.out.println(e.getMessage());
//			}
//}
//	
//	@Test
//	public static void MultipleTestScriptEnds() throws Exception{
//		String strXlsFileName = Constant.ResultFilePath;
//
//        int strData1,strData2, stepStatus, strDiff;
//
//        strData1 = Constant.StepIndex;
//
//			strData2 = Constant.TestStepIndex;
//			
//			stepStatus = Constant.StepStatus;
//			
//			strDiff= strData1-strData2;
//			
//			try {
//			
//			FileInputStream ExcelFile= new FileInputStream(strXlsFileName);
//			
//			        workbook = new XSSFWorkbook(ExcelFile);
//			
//			        Worksheet =  workbook.getSheet("Results");
//			
//			        Row row = Worksheet.getRow(strDiff); 
//			
//			        CellStyle style = workbook.createCellStyle();
//			
//			        for(int i=0;i<8;i++) {
//			                Cell cell =row.getCell(i);
//			                if(stepStatus==0) {                                                          
//			                    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//			                    style.setAlignment(HorizontalAlignment.CENTER);
//			                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//			                    cell.setCellStyle(style);
//			                }
//			                else{                                                             
//			                    style.setFillForegroundColor(IndexedColors.RED.getIndex());
//			                    style.setAlignment(HorizontalAlignment.CENTER);
//			                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);          
//			                    cell.setCellStyle(style);
//			                }
//			        }
//			
//			        
//			        Cell cell =row.getCell(7);
//		        	if(stepStatus==0) {
//		                cell.setCellValue("Pass");
//				        cell=row.createCell(10);
//					    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//					    cell.setCellValue(LocalDateTime.now().format(dtf).toString()); 
////					    cell=row.createCell(12);
////					    cell.setCellValue(Control.checkbal("*143*2*2*1#")); 
//		                }
//		                else
//		                {
//		                    cell.setCellValue("Fail");
//					        cell=row.createCell(10);
//						    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//						    cell.setCellValue(LocalDateTime.now().format(dtf).toString()); 
////						    cell=row.createCell(12);
////						    cell.setCellValue(Control.checkbal("*143*2*2*1#")); 
//		                }
//		        
//			        	
//				    cell = row.createCell(8);
//			        if(stepStatus==0) {
//			        	
//			        }
//			        else
//			        {
//			        	
//			        	cell.setCellValue(Constant.ScreenshotFolderName);
//			            final Hyperlink href = workbook.getCreationHelper().createHyperlink(HyperlinkType.FILE);
//			            String FolderPath= "File:///"+ Constant.ScreenshotFolderName;
//			            FolderPath= FolderPath.replace("\\", "/");
//			            System.out.println(FolderPath);
//			            href.setAddress(FolderPath);
//			            cell.setHyperlink(href);
//			        }
//			        
//
//			        
//			        //Constant.StepStatus=0;
//					int strData = Constant.StepIndex;
//					strData1=strData+1;
//					Constant.StepIndex=strData1 ;
//					strData =Constant.StepIndex;
//					strData2 = Constant.TestCaseIndex;
//					int strData3=strData2+1;
//					Constant.TestCaseIndex=strData3;     
//					ExcelFile.close();                             
//					FileOutputStream fos = new FileOutputStream(strXlsFileName);                
//					workbook.write(fos);                    
//					workbook.close();
//					fos.close();
//					
//					if(!(Constant.Failures==""))
//					{
//						//Assert.fail("\n" + Constant.Failures);	
//						Assert.fail("\n"+Constant.Failures);
//						Constant.Failures = "";
//
//					}
//					
//			}catch (Exception e) {
//			
//			        System.out.println(e.getMessage());
//			}
//}
//
//	
//	
//	
//	public static String RandomString(int intvalue) throws Exception{
//		char c[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//		int randomPosition;
//		String RandomString= "";
//		for(int i=0;i<intvalue;i++) {
//			randomPosition=generateRandomIntIntRange(0,51);
//			RandomString=RandomString+c[randomPosition];
//		}
//		System.out.println(RandomString);
//		return RandomString;		
//	}
//	
//	public static int generateRandomIntIntRange(int min, int max) {
//	    Random r = new Random();
//	    return r.nextInt((max - min) + 1) + min;
//	}
//	public static void GenerateHTMLReport() {
//		String strData,strTestCaseNo,strTestDesc,strExpectedResult,strActualResult,strTestCaseStatus;
//		int strTotalCases;
//		try {
//			FileInputStream ExcelFile= new FileInputStream(Constant.ResultFilePath);
//			String HtmlFile = Constant.ResultFilePath.replace("xlsx","htm");
//			workbook = new XSSFWorkbook(ExcelFile);
//			Worksheet =  workbook.getSheet("Results");		
//			int totalrows=Worksheet.getLastRowNum();
//			//File file1 = new File(HtmlFileName);
//			//FileWriter fw = new FileWriter(file1);
//			//StringBuilder htmlStringBuilder=new StringBuilder();
//			//File HtmlFileName = new File(HtmlFile);
//			
//			StringBuilder htmlStringBuilder=new StringBuilder();
//	        htmlStringBuilder.append("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
//	        htmlStringBuilder.append("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://myaccountpreprod.globe.com.ph/etc/designs/multi-solutions/assets/img/icon/loglobe.png'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=2><B>&nbsp;OMNI-My Account Automation - " + "objDate.toString()" + " -  & Time &  on Machine  & Environment.Value(LocalHostName) & </B></FONT></TD></TR></TABLE>");
//	        htmlStringBuilder.append("<TABLE BORDER=1 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
//	        htmlStringBuilder.append("<TR><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Business Process Name:  </B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"+Constant.UserStoryName +"</B></FONT></TD></TR>");
//	        htmlStringBuilder.append("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case No</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Description</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Expected Result</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Actual Result</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Result</B></FONT></TD></TR>");
//	        File HtmlFileName = new File(HtmlFile);
//	        
//			for(int i=1;i<totalrows;i++) {
//				strData = getcelldata(i,0);
//				if(!strData.equals("")){
//					strTestCaseNo = getcelldata(i,0);
//					strTestDesc = getcelldata(i,2);
//					strExpectedResult = getcelldata(i,5);
//					strActualResult = getcelldata(i,6);
//					strTestCaseStatus = getcelldata(i,7);
//					if(strTestCaseStatus.equals("Fail")) {
//						Constant.FailedCases =Constant.FailedCases+1;
//						htmlStringBuilder.append("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strTestCaseNo+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strTestDesc+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strExpectedResult+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strActualResult+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><a href=ScreenShots><B>"+strTestCaseStatus+"</B></FONT></a> </TD></TR>");
//						
//					}
//					if(strTestCaseStatus.equals("Pass")) {
//						Constant.PassedCases =Constant.PassedCases+1;
//				
//						htmlStringBuilder.append("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strTestCaseNo+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strTestDesc+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strExpectedResult+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>"+strActualResult+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><a href=ScreenShots><B>"+strTestCaseStatus+"</B></FONT></a> </TD></TR>");
//					}					
//			        
//			        /*FileOutputStream outputStream = new FileOutputStream(HtmlFile);
//			        Writer writer=new OutputStreamWriter(outputStream);
//			        writer.append(htmlStringBuilder.toString());
//			        writer.close();*/
//			   }
//			}
//			strTotalCases= Constant.PassedCases + Constant.FailedCases;
//			 htmlStringBuilder.append("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Total Test Cases: "+strTotalCases+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>No. Of Test Cases Passed: "+Constant.PassedCases+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>No. Of Test Cases Failed: "+Constant.FailedCases+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B></B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B></B></FONT></TD></TR>");
//			FileOutputStream outputStream = new FileOutputStream(HtmlFileName);
//	        Writer writer=new OutputStreamWriter(outputStream);
//	        writer.write(htmlStringBuilder.toString());
//	        writer.close();
//	        /*strTotalCases= Constant.PassedCases + Constant.FailedCases;
//			strTotalCases= Constant.PassedCases + Constant.FailedCases;
// 	        htmlStringBuilder.append("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Total Test Cases: "+strTotalCases+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>No. Of Test Cases Passed: "+Constant.PassedCases+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>No. Of Test Cases Failed: "+Constant.FailedCases+"</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B></B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B></B></FONT></TD></TR>");
// 	       FileOutputStream outputStream = new FileOutputStream(HtmlFile);
//	        Writer writer=new OutputStreamWriter(outputStream);
//	        writer.append(htmlStringBuilder.toString());
//	        writer.close();*/
//			
//		}
//		catch (Exception e){
//			e.printStackTrace();
//			
//		}
//	}
//	
//	
//	public static void setScreenshothyperlink(String screenshotFilePath) throws Exception{			
//			int strData=Constant.StepIndex;   			
//				try {				
//						FileInputStream ExcelFile= new FileInputStream(Constant.ResultFilePath);
//				        workbook = new XSSFWorkbook(ExcelFile);
//				        Worksheet =  workbook.getSheet("Results");
//						Row row = Worksheet.getRow(strData); 		
//						Cell cell = row.createCell(8);
//						cell.setCellValue(screenshotFilePath);
//						final Hyperlink href = workbook.getCreationHelper().createHyperlink(HyperlinkType.FILE);
//						String FolderPath= "File:///"+ screenshotFilePath;
//						FolderPath= FolderPath.replace("\\", "/");			        
//						href.setAddress(FolderPath);
//						cell.setHyperlink(href);				
//						ExcelFile.close();		
//						FileOutputStream fos = new FileOutputStream(Constant.ResultFilePath);		
//						workbook.write(fos);		
//						workbook.close();
//						fos.close();
//			}
//			catch(Exception e) {	
//			    System.out.println(e.getMessage());
//						}
//				}
//	public static void TestDataForUSSD(String SheetName) throws Exception
//	{
//		String  strValue,ColumnName,ColumnValue;
//		int totalrows,totalColumns;
//		try {
//			FileInputStream ExcelFile= new FileInputStream(Constant.TestDataFilePath);
//			workbook = new XSSFWorkbook(ExcelFile);
//			Worksheet =  workbook.getSheet(SheetName);
//			totalrows = Worksheet.getLastRowNum();
//			totalColumns= Worksheet.getRow(0).getLastCellNum();
//			for(int i=0; i<=totalrows;i++) {	
//				Constant.Map2.put("TestCase"+ i , new HashMap<String,String>());
//				for(int j=0; j <= totalColumns; j++){
//					ColumnName= getcelldata(0,j);
//						
//						ColumnValue = getcelldata(i,j);		
//						//System.out.println("Sheet : "+SheetName+"(Row,Col) : ("+i+","+j+"):"+ColumnValue);
//						Constant.Map2.get("TestCase"+ i).put(ColumnName, ColumnValue);
//						
//				}
//				
//			}				
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	  public void GenerateReport(String path_to_python_scripts,String path_to_input_excel,String path_to_output_pdf,String input_excel_name,String output_pdf_name)
//	    {
//	    	String python_command=path_to_python_scripts+"python.exe RP3.py "+path_to_python_scripts+" "+input_excel_name+" "+path_to_input_excel+" "+path_to_output_pdf+" "+output_pdf_name;
//	                   try
//	                    {
//	                	   
//	                	   
//	                        path_to_python_scripts=URLDecoder.decode(path_to_python_scripts, "UTF-8");
//	                        System.out.println("Path to python script : "+path_to_python_scripts);
//	                        python_command=URLDecoder.decode(python_command, "UTF-8");
//	                         System.out.println("Python command: "+python_command);
//	                    }
//	                catch(Exception e)
//	                    {
//	                            System.out.println("Exception while setting Python Path : "+e.getMessage());
//	                            System.exit(-1);
//	                    }
//	        
//	        
//	                ProcessBuilder builder = new ProcessBuilder(
//	                "cmd.exe", "/c", "cd "+path_to_python_scripts+" && "+python_command);
//	                builder.redirectErrorStream(true);
//	                try
//	                {
//	                							String line=null;
//	                                            Process p = builder.start();
//	                                            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//	                                            System.out.println("Buffered Reader : "+r.readLine());
//
//	                                            while (true) 
//	                                            {
//	                                                try
//	                                                {
//	                                                    line =r.readLine();
//	                                                    if(line==null)
//	                                                        break;
//
//	                                                    System.out.println(""+line);
//	                                                }
//
//	                                                catch(Exception e)
//	                                                {
//	                                                    System.out.println("Execption while receiving output from Python Script : "+e.getMessage());
//	                                                    break;
//	                                                }
//	                                            }
//
//	                    
//
//	                }
//	                catch(Exception e)
//	                {
//	                    System.out.println("Exception while triggering process to initialize PDF Generation Script  : "+e.getMessage());
//	                }    
//	    }
//	  
//	  
//	  
//
//	  public static void startTimer()
//	  {
//		  Constant.updatedStartTime=System.currentTimeMillis();
//		  
//		  
//	  }
//	  public static void stopTimer()
//	  {
//		  //the moment a timer is stopped, final time becomes initial time, and elapsedDuration increases
//		  
//		  //calculate the elapsed duration
//		  Constant.youtubeElapsedTime+=System.currentTimeMillis()-Constant.updatedStartTime;
//		  
//	  }
//	  
//	
//		 public static String ReadRandomCellData(String sheetName) {
//				String celldata = null;
//				try {
//					FileInputStream ExcelFile = new FileInputStream(Constant.TestDataFilePath);
//					workbook = new XSSFWorkbook(ExcelFile);
//					Worksheet = workbook.getSheet(sheetName);
//					int totalrows = Worksheet.getLastRowNum();
//					Random r = new Random();
//					int rownum = r.nextInt(totalrows);
//					try {
//						cell = Worksheet.getRow(rownum).getCell(0);
//
//						celldata = cell.getStringCellValue();
//
//					} catch (Exception e) {
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return celldata;
//			}
//		 
//			public static void RepositoryLabelCreation() throws Exception {
//				String strText, PageName, strValue;
//				int totalrows;
//				try {
//					FileInputStream ExcelFile = new FileInputStream(Constant.TestDataFilePath);
//					workbook = new XSSFWorkbook(ExcelFile);
//					Worksheet = workbook.getSheet("Label");
//					totalrows = Worksheet.getLastRowNum();
//					PageName = null;
//					for (int j = 0; j <= totalrows; j++) {
//						strValue = getcelldata(j, 0);
//						//System.out.println("strValue is " + strValue);
//						if (strValue.equalsIgnoreCase("")) {
//						} else {
//							PageName = strValue;
//							Constant.labelMap.put(PageName, new HashMap<String, String>());
//						}
//						strText = getcelldata(j, 1);
//						strValue = getcelldata(j, 2);
//						//System.out.println(strText + " : " + strValue);
//						Constant.labelMap.get(PageName).put(strText, strValue);
//						strText = null;
//
//					}
//
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		 
//		
//		
//}
//
