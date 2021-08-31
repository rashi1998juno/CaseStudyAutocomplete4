package com.qa.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AutoCompletePage;

public class TestBase {

	AutoCompletePage AutoOR;
	WebDriver driver;

	// 1.Open a browser
	@BeforeClass
	@Parameters({ "Browser", "Url" })
	public void setUp(String Browser, String Url) {
		// 1.Open a browser
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\HP\\Videos\\selenium_jar\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		AutoOR = new AutoCompletePage(driver);
		driver.manage().window().maximize();

		// 2.launching the url
		driver.get(Url);

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		// close the browser
		Thread.sleep(2000);
		driver.close();

	}

}
