package com.qa.testscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class AutoCompleteItemsItems extends TestBase {

	@Test(dataProvider="get_Data")
	public void SearchTextbox(String SearchTopic) throws InterruptedException {

		AutoOR.getSearchTextbox().sendKeys(SearchTopic);
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		List<WebElement> itemName = AutoOR.get_Itemnames();

		for (WebElement item : itemName) {
			
			
			System.out.println(item.getText());
			AutoOR.getSearchTextbox().clear();
			
		}
		
	AutoOR.getSearchTextbox().sendKeys(SearchTopic + Keys.ENTER);
		
		String title = driver.getTitle();
		if (title.contains(SearchTopic)) {
			System.out.println(" The Title is same as the search term   " + title);
		} else {
			System.out.println("The Title is not same as the search term " + title);
		}
		
		//AutoOR.getSearchTextbox().clear();
	}
	

	
	
	
	@DataProvider
	public String[][] get_Data() throws IOException
	{
		//Object[][] datas=new Object[3][2];
		
		
		String xFile="C:\\Users\\HP\\Desktop\\Selenium_java\\CaseStudyAutocomplete4\\src\\test\\java\\com\\qa\\testdatainput\\Input.xlsx";
		String xSheet="Sheet1";
		int rowCount=ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount=ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][]  datas=new String[rowCount][cellCount];
		
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				datas[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		
return datas;
	}
}
