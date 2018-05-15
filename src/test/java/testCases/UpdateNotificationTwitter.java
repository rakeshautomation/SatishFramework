package testCases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import config.BaseTestSetting;

public class UpdateNotificationTwitter extends BaseTestSetting {
public static String TestCaseName = "UpdateNotificationSettingTwitter";
public static String NotificationPropPath ="D:\\TwitterSelenium\\Data\\NotificationData.properties";
public static String UserDetails ="D:\\TwitterSelenium\\Data\\UserData.properties";

  @Test
  public void OpenBrowserTesting() throws IOException, InterruptedException, AWTException {
	  
	    
	    //CommonMethods ComMethod = new CommonMethods();    
	    OpenBrowser("Chrome","https://twitter.com/",40);
	    TakeScreenShot(TestCaseName,"Before Filling Form");
	    //driver.findElements(By.xpath("Xpath Value")).size());
//	    if (mydriver.findElements(By.xpath("//*[@id='user-dropdown-toggle']")).size() > 0){
//	    	//Already logged in
//	    }else {
		    mydriver.findElement(By.xpath("//a[contains(text(), 'Log in') and starts-with(@class,'StaticLoggedOutHomePage')]")).click();
		    
		    String LoginID = getPropertiesFileData(UserDetails,"UserID");
		    String Password = getPropertiesFileData(UserDetails,"Password");
		    
		    mydriver.findElement(By.xpath(".//input[@type='text' and @value='' and @name='session[username_or_email]']")).sendKeys(LoginID);
		    mydriver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[2]/input")).sendKeys(Password);
		    mydriver.findElement(By.xpath("//button[@type='submit']")).click();	
//	    }
	    mydriver.findElement(By.xpath("//*[@id='user-dropdown-toggle']")).click();
	    mydriver.findElement(By.xpath("//a[contains(text(), 'Settings and privacy')]")).click();
	    mydriver.findElement(By.xpath("//a[@data-nav='notifications_timeline']")).click();
	    
	    
	    File file = new File(NotificationPropPath);
	    					FileInputStream fileInput = null;
	    					try {
	    						fileInput = new FileInputStream(file);
	    					} catch (FileNotFoundException e) {
	    						e.printStackTrace();
	    					}
	    					Properties prop = new Properties();
	    					try {
	    						prop.load(fileInput);
	    					} catch (IOException e) {
	    						e.printStackTrace();
	    					}
	    					Enumeration<?> KeyValues = prop.keys();
	    					while (KeyValues.hasMoreElements()) {
	    						String key = (String) KeyValues.nextElement();
	    						String value = prop.getProperty(key);
//	    						System.out.println(key + ":- " + value);
	    						//Select the notification as per the Properties file
	    						if (key.equalsIgnoreCase("Youdontfollow")) {
	    							if (value.equalsIgnoreCase("ON")) {
	    								Select_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='following_filter_enabled']")));
	    							}else if(value.equalsIgnoreCase("OFF")){
	    								DeSelect_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='following_filter_enabled']")));
	    							}
	    						}else if(key.equalsIgnoreCase("Whodontfollowyou")) {
	    							if (value.equalsIgnoreCase("ON")) {
	    								Select_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_not_followed_by_enabled']")));
	    							}else if(value.equalsIgnoreCase("OFF")){
	    								DeSelect_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_not_followed_by_enabled']")));
	    							}
	    						}else if(key.equalsIgnoreCase("Withanewaccount")) {
	    							if (value.equalsIgnoreCase("ON")) {
	    								Select_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_new_users_enabled']")));
	    							}else if(value.equalsIgnoreCase("OFF")){
	    								DeSelect_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_new_users_enabled']")));
	    							}
	    						}else if(key.equalsIgnoreCase("Whohaveadefaultprofilephoto")) {
	    							if (value.equalsIgnoreCase("ON")) {
	    								Select_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_default_profile_image_enabled']")));
	    							}else if(value.equalsIgnoreCase("OFF")){
	    								DeSelect_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_default_profile_image_enabled']")));
	    							}
	    						}else if(key.equalsIgnoreCase("Whohaventconfirmedtheiremail")) {
	    							if (value.equalsIgnoreCase("ON")) {
	    								Select_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_no_confirmed_email_enabled']")));
	    							}else if(value.equalsIgnoreCase("OFF")){
	    								DeSelect_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_no_confirmed_email_enabled']")));
	    							}
	    						}else if(key.equalsIgnoreCase("Whohaventconfirmedtheirphonenumber")) {
	    							if (value.equalsIgnoreCase("ON")) {
	    								Select_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_no_confirmed_phone_enabled']")));
	    							}else if(value.equalsIgnoreCase("OFF")){
	    								DeSelect_The_Checkbox(mydriver.findElement(By.xpath("//*[@id='filter_no_confirmed_phone_enabled']")));
	    							}
	    						}
	    					}	
	    //Save changes
	    mydriver.findElement(By.xpath("//*[@id='settings_save']']")).click();
	    					
	    //mydriver.close();		
  }
  
}



