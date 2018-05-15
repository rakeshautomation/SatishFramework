package config;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseTestSetting {
	public static String ConfigPropertyPath = System.getProperty("user.dir")+"\\TestData\\ConfigDetail.properties";
	public static WebDriver mydriver;
	//public static String TestDataSheetPath = System.getProperty("user.dir")+(getPropertiesFileData("ConfigDetail.properties","TestDataPath"));
	
	
//	public void main(String[] args) throws IOException {
//	
//	}
	//This method will create a HashMap and collect all data from excel sheet and return the value
		
//	// This method help us to get the value with reference to the key from the hashmap data
//	public static String get(HashMap<?, ?> HashMap, String ColumnName) {
//		return (String) HashMap.get(ColumnName);
//	}
	
	//This method will open corresponding bRowser as per the user INput
	//Examaple for InternetExplorere = IE
	//Mozilla = Mozilla
	//Chrome = Chrome
	public static void OpenBrowser(String BrowserType, String Url, int impWaitTime){
		//WebDriver driver=null;
		if (BrowserType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\target\\"+"chromedriver.exe");
			mydriver=new ChromeDriver();
		}else if(BrowserType.equalsIgnoreCase("Mozilla")){
			mydriver=new FirefoxDriver();
		}else if(BrowserType.equalsIgnoreCase("IE")){
			mydriver=new InternetExplorerDriver();
		}
		mydriver.manage().window().maximize();
		mydriver.get(Url);
		mydriver.manage().timeouts().implicitlyWait(impWaitTime,TimeUnit.SECONDS);
	}
	//====================================================================================================
	//=============================================================================================
	// This method will return the property value by taking input PropertyName, and the key
	public static String getPropertiesFileData(String PropertyFilePath,String Key) throws IOException{
		Properties config= new Properties();
		File file = new File(PropertyFilePath);
		FileInputStream Fi = new FileInputStream(file);
		config.load(Fi);
		String Value = config.getProperty(Key);
		return Value;
	}
	//=============================================================================================
	//This method will capture the screenshot
	//input - TestCaseName
	//input - Description
	//output - Not Require
	public static void TakeScreenShot(String TestCaseName, String Description) throws IOException {
		//take screenshot
		String PathToSave = "";
		TakesScreenshot scrShot =((TakesScreenshot)mydriver);
		//Call getScreenshotAs method to create image file
	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    Date d=new Date();
	    SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy-hh/mm/ss");
	    String iname=df.format(d);
		//Move image file to new destination
	    
	    if (Description=="") {
	    	PathToSave = ("D:\\Screenshot\\"+TestCaseName+"_"+iname+".png");
	    }else {
	    	PathToSave = ("D:\\Screenshot\\"+TestCaseName+"_"+Description+"_"+iname+".png");
	    }
	    PathToSave = PathToSave.replace("/", "");
	    File DestFile=new File(PathToSave);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	//===================================================
	public void Select_The_Checkbox(WebElement element) {
		try {
            if (element.isSelected()) {
               System.out.println("Checkbox: " + element + "is already selected");
            } else {
            	// Select the checkbox
                element.click();
            }
        } catch (Exception e) {
        	System.out.println("Unable to select the checkbox: " + element);
        }
		
	}
	//====================================================
	public void DeSelect_The_Checkbox(WebElement element) {
		try {
            if (element.isSelected()) {
            	//De-select the checkbox
                element.click();
            } else {
            	System.out.println("Checkbox: "+element+"is already deselected");
            }
        } catch (Exception e) {
        	System.out.println("Unable to deselect checkbox: "+element);
        }
     }		
	//==================================================

}
