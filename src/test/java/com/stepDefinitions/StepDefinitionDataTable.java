package com.stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.test.pages.LoginPageActions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefinitionDataTable {

	LoginPageActions objAction;
	WebDriver driver;
	String URL ="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(URL);
	}

	@When("^User enters credentials to login$")
	public void user_enters_credentials_to_login(DataTable credentials) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		objAction = new LoginPageActions(driver);
		List<List<String>> data = credentials.raw();
	       objAction.Username.sendKeys(data.get(0).get(0));
	       objAction.Password.sendKeys(data.get(0).get(1));
	       objAction.LoginButton.click();
	}

	@Then("^Message displayed Login Successfull$")
	public void message_displayed_Login_Successfull() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String ExpectedTitle = objAction.GetTitle();
		   if(ExpectedTitle.equals("OrangeHRM"))
			   System.out.println("title Matches! login successfull");
		   else  
			   System.out.println("Title not matches!");
	}

}
