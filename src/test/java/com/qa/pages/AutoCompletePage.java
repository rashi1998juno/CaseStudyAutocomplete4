package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoCompletePage {

	WebDriver driver;

	// Getting input Textbox of Google
//	@FindBy(id="input")
	@FindBy(xpath = "//input[@class='gLFyf gsfi']")
    WebElement Search_Textbox;

	public WebElement getSearchTextbox() {
		Search_Textbox.clear();
		return Search_Textbox;
	}

	// xpath
	@FindAll(@FindBy(xpath = "//ul[@class='erkvQe']//li"))
	List<WebElement> ItemsNames;

	public List<WebElement> get_Itemnames() {
		return ItemsNames;
	}

	public AutoCompletePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);// all the elements of this particular driver is attached
	}

}
