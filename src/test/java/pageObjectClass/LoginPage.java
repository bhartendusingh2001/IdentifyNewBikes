package pageObjectClass;

import java.io.IOException;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilites.ExcelUtility;

public class LoginPage extends BasePage{

	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	ExcelUtility excelUtility = new ExcelUtility();

	// Locators
	
	//XPath of Email Input Box
	@FindBy(id="identifierId")
	WebElement emailInputbox_loc;
	
	//XPath of Next Button 
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement nextBtn_loc;
	
	//XPath of Error Message
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement errorMsg_loc;
		
	
	// Actions
	
	//Sending random Inputs 
	public void setEmailInput() {
		emailInputbox_loc.sendKeys(randomString() + "@gmail.com");
	}
	
	//Click on Next Button
	public  void clickNextBtn() {
		nextBtn_loc.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Capturing error message
	public void getErrorMsg() throws IOException{
		String errorMsg = errorMsg_loc.getText();
		System.out.println("-----------------------------");
		System.out.println(errorMsg);
		excelUtility.setCellData("LoginPage", 0, 0, errorMsg);
	}
	
	//Sending random string 
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	
	
	
}
