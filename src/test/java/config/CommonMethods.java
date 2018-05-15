package config;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods extends BaseTestSetting {

  //=============This method is used to select value from the weblist============
	public void selectWeblist(By weblistpath, String weblistText) 
	{
		try {
		   WebElement e1=mydriver.findElement(weblistpath);
	       Select s1=new Select(e1);
	       s1.selectByVisibleText(weblistText);	
	       
			}catch(NoSuchElementException e) {
				System.out.println(weblistText+" Option value not find in dropdown");
			}

	 }
  //=================End Method=======================================================
//============== This method is used to select the option in dropdown based on the value=========

	public void selectWeblist(By weblistpath, int index) 
	{
		try {
		   WebElement e1=mydriver.findElement(weblistpath);
	       Select s1=new Select(e1);
	       s1.selectByIndex(index);
	       
			}catch(NoSuchElementException e) {
				System.out.println(index+" is not present");
			}

	 }
//=============================================================================================

////=====================This method is used to select the option in dropdown based on the index value
//
//public static void select_Option_In_DropDown_ByValue(WebElement element, int indexVal) {
//    try {
//        Select select = new Select(element);
//        select.selectByIndex(indexVal);
//    } catch (NoSuchElementException e) {
//        System.out.println("Option value not find in dropdown");
//    }
//}

}