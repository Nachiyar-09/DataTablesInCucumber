package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {

	WebDriver driver;
	
	 public LoginPageActions(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
		
		@FindBy(id ="txtUsername")
		public static WebElement Username;
		
		@FindBy(id ="txtPassword")
		public static WebElement Password;
		
		@FindBy(id ="btnLogin")
		public static WebElement LoginButton;
		


public String GetTitle(){
	return driver.getTitle();
}
}